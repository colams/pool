package cn.colams.biz.airbnb.api;

import cn.colams.common.airbnb.AirbnbApiKeyUtils;
import cn.colams.common.dto.airbnb.entity.*;
import cn.colams.common.dto.airbnb.request.CommonRequestType;
import cn.colams.common.dto.airbnb.response.CommonResponseType;
import cn.colams.common.utils.Base64Utils;
import cn.colams.common.utils.HttpUtils;
import cn.colams.common.utils.JacksonSerializerUtil;
import cn.colams.dal.entity.Airbnb;
import cn.colams.dal.mapper.extension.AirbnbExtensionMapper;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 爬取房间信息
 * 注意：需要有一个请求参数
 * 当前查询：https://zh.airbnb.com/s/Dubai/homes?tab_id=home_tab&refinement_paths%5B%5D=%2Fhomes&flexible_trip_lengths%5B%5D=one_week&monthly_start_date=2023-10-01&monthly_length=1&price_filter_input_type=0&price_filter_num_nights=5&channel=EXPLORE&query=Dubai&place_id=ChIJRcbZaklDXz4RYlEphFBu5r0&date_picker_type=monthly_stay&source=structured_search_input_header&search_type=autocomplete_click
 */
@Component
public class StaysSearch {

    private static final Logger LOGGER = LoggerFactory.getLogger(StaysSearch.class);

    @Autowired
    AirbnbExtensionMapper airbnbExtensionMapper;

    public String crawlerStaysSearch() throws IOException, InterruptedException {
        PageCourse course = new PageCourse();
        course.setVersion(1);
        course.setItemsOffset(0);
        course.setSectionOffset(0);
        return crawlerStaysSearch(course);
    }

    public String crawlerStaysSearch(PageCourse pageCourse) throws IOException, InterruptedException {
        String data = getStaysSearchParamsV2(pageCourse);
        int pageIndex = (pageCourse.getItemsOffset() / 18) + 1;
        LOGGER.info(JacksonSerializerUtil.serialize(pageCourse));
        CommonResponseType<StaySearchData> commonResponseType = staysSearch(data);
        if (Objects.isNull(commonResponseType)
                || !CollectionUtils.isEmpty(commonResponseType.getErrors())
                || Objects.isNull(commonResponseType.getData().getPresentation())) {
            return "no data";
        }
        StaysSearchResponse response = commonResponseType
                .getData()
                .getPresentation()
                .getExplore()
                .getSections()
                .getSectionIndependentData()
                .getStaysSearch();

        List<StaySearchResult> searchResults = Optional.ofNullable(response.getSearchResults()).orElse(Lists.newArrayList());
        if (CollectionUtils.isEmpty(searchResults)) {
            return "fail";
        } else {
            String cursor = response.getPaginationInfo().getNextPageCursor();
            PageCourse nextPageCourse = pageCourse;
            if (StringUtils.isBlank(cursor)) {
                nextPageCourse.setItemsOffset(nextPageCourse.getItemsOffset() + 18);
            } else {
                nextPageCourse = JacksonSerializerUtil.deserialize(Base64Utils.getBase64Decode(cursor), PageCourse.class);
            }
            saveAirbnbRoom(searchResults, pageIndex);
            Thread.sleep(1000);
            crawlerStaysSearch(nextPageCourse);
        }
        return "success";
    }


    private void saveAirbnbRoom(List<StaySearchResult> searchResults, int pageIndex) {
        searchResults.forEach(result -> {
            if (Objects.nonNull(result.getListing())) {
                Airbnb airbnb = airbnbExtensionMapper.selectByRoomId(result.getListing().getId());
                if (Objects.isNull(airbnb)) {
                    airbnb = new Airbnb();
                    airbnb.withrState(StringUtils.isEmpty(result.getListing().getCity()) ?
                                    result.getListing().getLocalizedCityName() : result.getListing().getCity())
                            .withPrice(Objects.isNull(result.getPricingQuote().getStructuredStayDisplayPrice().getPrimaryline().getDiscountedprice()) ? result.getPricingQuote().getStructuredStayDisplayPrice().getPrimaryline().getAccessibilitylabel() : result.getPricingQuote().getStructuredStayDisplayPrice().getPrimaryline().getDiscountedprice())
                            .withrSrouce(2)
                            .withPage(pageIndex)
                            .withRoomName(result.getListing().getName())
                            .withPictureCount(result.getListing().getContextualPicturesCount())
                            .withRoomId(result.getListing().getId())
                            .withRoomUrl(String.format(Constant.ROOM_DETAIL_URL_TEMPLATE, result.getListing().getId()))
                            .withExtra(result.getListing().getAvgRatingA11yLabel())
                            .withRoomLocation(String.format("%s,%s", result.getListing().getCoordinate().getLatitude(), result.getListing().getCoordinate().getLongitude()))
                            .withOrgUrl("")
                            .withLordId("")
                            .withDealStatus(0);
                    airbnbExtensionMapper.insertSelective(airbnb);
                }
            }
        });
    }

    public CommonResponseType<StaySearchData> staysSearch(String requestData) throws IOException {
        String url = "https://zh.airbnb.com/api/v3/StaysSearch?operationName=StaysSearch&locale=zh&currency=SGD";
        List<Header> headers = AirbnbApiKeyUtils.getHeaders();
        String res = HttpUtils.doPost(url, requestData, headers);
        CommonResponseType<StaySearchData> response = JacksonSerializerUtil.deserialize(res, CommonResponseType.class, StaySearchData.class);
        return response;
    }

    private String getStaysSearchParamsV2(PageCourse pageCourse) {
        CommonRequestType<StaysSearchVariables> requestType = new CommonRequestType<>();
        requestType.setExtensions(buildExtensions());
        requestType.setOperationName("StaysSearch");
        requestType.setVariables(buildVariables(pageCourse));
        return JacksonSerializerUtil.serialize(requestType);
    }

    private StaysSearchVariables buildVariables(PageCourse pageCourse) {
        StaysSearchVariables variables = new StaysSearchVariables();
        variables.setDecomposeCleanupEnabled(false);
        variables.setDecomposeFiltersEnabled(false);
        variables.setFeedMapDecoupleEnabled(true);
        StaysSearchRequest searchRequest = buildSearchRequest(pageCourse);
        variables.setStaysMapSearchRequestV2(searchRequest);
        variables.setStaysSearchRequest(searchRequest);
        return variables;
    }

    private StaysSearchRequest buildSearchRequest(PageCourse pageCourse) {
        StaysSearchRequest request = new StaysSearchRequest();
        request.setMetadataOnly(false);
        request.setRawParams(initRawParams());
        request.setRequestedPageType("STAYS_SEARCH");
        request.setSearchType("filter_change");
        request.setSource("structured_search_input_header");
        request.setCursor(Base64Utils.getBase64Encode(JacksonSerializerUtil.serialize(pageCourse)));
        request.setTreatmentFlags(Lists.newArrayList(
                "decompose_stays_search_m2_treatment",
                "decompose_stays_search_m3_treatment",
                "decompose_stays_search_m3_5_treatment",
                "flex_destinations_june_2021_launch_web_treatment",
                "new_filter_bar_v2_fm_header",
                "flexible_dates_12_month_lead_time",
                "lazy_load_flex_search_map_compact",
                "lazy_load_flex_search_map_wide",
                "im_flexible_may_2022_treatment",
                "search_add_category_bar_ui_ranking_web",
                "feed_map_decouple_m11_treatment",
                "flexible_dates_options_extend_one_three_seven_days",
                "super_date_flexibility",
                "micro_flex_improvements",
                "micro_flex_show_by_default",
                "search_input_placeholder_phrases",
                "pets_fee_treatment"));
        return request;
    }

    private List<RawParam> initRawParams() {
        List<RawParam> rawParams = new ArrayList<>();
        rawParams.add(new RawParam("adults", Lists.newArrayList("1")));
        rawParams.add(new RawParam("cdnCacheSafe", Lists.newArrayList("false")));
        rawParams.add(new RawParam("channel", Lists.newArrayList("EXPLORE")));
        rawParams.add(new RawParam("datePickerType", Lists.newArrayList("monthly_stay")));

        rawParams.add(new RawParam("monthlyLength", Lists.newArrayList("1")));
        rawParams.add(new RawParam("itemsPerGrid", Lists.newArrayList("18")));
        rawParams.add(new RawParam("monthlyStartDate", Lists.newArrayList("2023-10-01")));


//        rawParams.add(new RawParam("flexibleTripDates", Lists.newArrayList("october")));
//        rawParams.add(new RawParam("flexibleTripLengths", Lists.newArrayList("one-month")));
        rawParams.add(new RawParam("placeId", Lists.newArrayList("ChIJRcbZaklDXz4RYlEphFBu5r0")));
        rawParams.add(new RawParam("priceFilterInputType", Lists.newArrayList("0")));
//        rawParams.add(new RawParam("priceFilterNumNights", Lists.newArrayList("28")));
//        rawParams.add(new RawParam("monthlyEndDate", Lists.newArrayList("2023-11-01")));

        rawParams.add(new RawParam("query", Lists.newArrayList("杜拜, 迪拜酋长国, 阿拉伯联合酋长国")));
        rawParams.add(new RawParam("refinementPaths", Lists.newArrayList("/homes")));
        rawParams.add(new RawParam("screenSize", Lists.newArrayList("large")));
        rawParams.add(new RawParam("tabId", Lists.newArrayList("home_tab")));
        rawParams.add(new RawParam("version", Lists.newArrayList("1.8.3")));
        return rawParams;
    }

    private RequestExtensions buildExtensions() {
        RequestExtensions extensions = new RequestExtensions();
        PersistedQuery persistedQuery = new PersistedQuery();
        persistedQuery.setVersion(1);
        persistedQuery.setSha256Hash("d6c7011df2d9826b236c31cf81ab1bce2e601ce3302dec89f8f6325c2223d5a3");
        extensions.setPersistedQuery(persistedQuery);
        return extensions;
    }

    public interface Constant {
        String ROOM_DETAIL_URL_TEMPLATE = "https://zh.airbnb.com/rooms/%s?check_in=2023-10-01&check_out=2023-11-01";
    }

}
