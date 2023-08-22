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

    public String crawlerStaysSearch(String cityName) throws Exception {
        PageCourse course = new PageCourse();
        course.setVersion(1);
        course.setItemsOffset(0);
        course.setSectionOffset(0);
        String json = jsonValue(cityName);
        List<RawParam> rawParams = JacksonSerializerUtil.deserialize(json, List.class, RawParam.class);
        return crawlerStaysSearch(course, rawParams);
    }

    private String jsonValue(String cityName) {
        String json;
        try {
            json = Constant.class.getDeclaredField(cityName).get(Constant.class).toString();
        } catch (IllegalAccessException | NoSuchFieldException e) {
            LOGGER.error("json value:", e);
            json = JacksonSerializerUtil.serialize(initRawParams());
        }
        return json;
    }

    public String crawlerStaysSearch(PageCourse pageCourse, List<RawParam> rawParams) throws IOException, InterruptedException {
        CommonRequestType<StaysSearchVariables> request = getStaysSearchParamsV2(pageCourse, rawParams);
        int pageIndex = (pageCourse.getItemsOffset() / 18) + 1;
        LOGGER.info(JacksonSerializerUtil.serialize(pageCourse));
        CommonResponseType<StaySearchData> commonResponseType = staysSearch(JacksonSerializerUtil.serialize(request));
        if (Objects.isNull(commonResponseType) || !CollectionUtils.isEmpty(commonResponseType.getErrors()) || Objects.isNull(commonResponseType.getData().getPresentation())) {
            return "no data";
        }
        StaysSearchResponse response = commonResponseType.getData().getPresentation().getExplore().getSections().getSectionIndependentData().getStaysSearch();

        List<StaySearchResult> searchResults = Optional.ofNullable(response.getSearchResults()).orElse(Lists.newArrayList());
        if (CollectionUtils.isEmpty(searchResults)) {
            return "fail";
        } else {
            saveAirbnbRoom(searchResults, pageIndex);
            Thread.sleep(5000);
            if (searchResults.size() >= 18) {
                PageCourse nextPageCourse = getNextPageCourse(response.getPaginationInfo().getNextPageCursor(), pageCourse);
                crawlerStaysSearch(nextPageCourse, rawParams);
            }
        }
        return "success";
    }

    private PageCourse getNextPageCourse(String nextCursor, PageCourse currentCursor) {
        PageCourse nextPageCourse;
        if (StringUtils.isNotBlank(nextCursor)) {
            nextPageCourse = JacksonSerializerUtil.deserialize(Base64Utils.getBase64Decode(nextCursor), PageCourse.class);
        } else {
            nextPageCourse = currentCursor;
            nextPageCourse.setItemsOffset(currentCursor.getItemsOffset() + 18);
        }
        return nextPageCourse;

    }

    private void saveAirbnbRoom(List<StaySearchResult> searchResults, int pageIndex) {
        searchResults.forEach(result -> {
            if (Objects.nonNull(result.getListing())) {
                Airbnb airbnb = airbnbExtensionMapper.selectByRoomId(result.getListing().getId());
                if (Objects.isNull(airbnb)) {
                    airbnb = new Airbnb();
                    airbnb.withState(StringUtils.isEmpty(result.getListing().getCity()) ? result.getListing().getLocalizedCityName() : result.getListing().getCity()).withPrice(Objects.isNull(result.getPricingQuote().getStructuredStayDisplayPrice().getPrimaryline().getDiscountedprice()) ? result.getPricingQuote().getStructuredStayDisplayPrice().getPrimaryline().getAccessibilitylabel() : result.getPricingQuote().getStructuredStayDisplayPrice().getPrimaryline().getDiscountedprice())
                            .withSource(2)
                            .withPage(pageIndex)
                            .withRoomName(result.getListing().getName()).withPictureCount(result.getListing().getContextualPicturesCount())
                            .withRoomId(result.getListing().getId())
                            .withRoomUrl(String.format(Constant.ROOM_DETAIL_URL_TEMPLATE, result.getListing().getId()))
                            .withExtra(result.getListing().getAvgRatingA11yLabel())
                            .withRoomLocation(String.format("%s,%s", result.getListing().getCoordinate().getLatitude(), result.getListing().getCoordinate().getLongitude()))
                            .withOrgUrl("")
                            .withLordId("")
                            .withStatus(0);
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

    private CommonRequestType<StaysSearchVariables> getStaysSearchParamsV2(PageCourse pageCourse, List<RawParam> rawParams) {
        CommonRequestType<StaysSearchVariables> requestType = new CommonRequestType<>();
        requestType.setExtensions(buildExtensions());
        requestType.setOperationName("StaysSearch");
        requestType.setVariables(buildVariables(pageCourse, rawParams));
        return requestType;
    }

    private StaysSearchVariables buildVariables(PageCourse pageCourse, List<RawParam> rawParams) {
        StaysSearchVariables variables = new StaysSearchVariables();
        variables.setDecomposeCleanupEnabled(false);
        variables.setDecomposeFiltersEnabled(false);
        variables.setFeedMapDecoupleEnabled(true);
        StaysSearchRequest searchRequest = buildSearchRequest(pageCourse, rawParams);
        variables.setStaysMapSearchRequestV2(searchRequest);
        variables.setStaysSearchRequest(searchRequest);
        return variables;
    }

    private StaysSearchRequest buildSearchRequest(PageCourse pageCourse, List<RawParam> rawParams) {
        StaysSearchRequest request = new StaysSearchRequest();
        request.setMetadataOnly(false);
        request.setRawParams(rawParams);
        request.setRequestedPageType("STAYS_SEARCH");
        request.setSearchType("filter_change");
        request.setSource("structured_search_input_header");
        request.setCursor(Base64Utils.getBase64Encode(JacksonSerializerUtil.serialize(pageCourse)));
        request.setTreatmentFlags(Lists.newArrayList("decompose_stays_search_m2_treatment", "decompose_stays_search_m3_treatment", "decompose_stays_search_m3_5_treatment", "flex_destinations_june_2021_launch_web_treatment", "new_filter_bar_v2_fm_header", "flexible_dates_12_month_lead_time", "lazy_load_flex_search_map_compact", "lazy_load_flex_search_map_wide", "im_flexible_may_2022_treatment", "search_add_category_bar_ui_ranking_web", "feed_map_decouple_m11_treatment", "flexible_dates_options_extend_one_three_seven_days", "super_date_flexibility", "micro_flex_improvements", "micro_flex_show_by_default", "search_input_placeholder_phrases", "pets_fee_treatment"));
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
        String ROOM_DETAIL_URL_TEMPLATE = "https://zh.airbnb.com/rooms/%s?check_in=2023-11-01&check_out=2023-12-01";

        String Singapore = "[{\"filterName\":\"cdnCacheSafe\",\"filterValues\":[\"false\"]},{\"filterName\":\"channel\",\"filterValues\":[\"EXPLORE\"]},{\"filterName\":\"datePickerType\",\"filterValues\":[\"monthly_stay\"]},{\"filterName\":\"flexibleTripLengths\",\"filterValues\":[\"one_week\"]},{\"filterName\":\"itemsPerGrid\",\"filterValues\":[\"18\"]},{\"filterName\":\"monthlyLength\",\"filterValues\":[\"1\"]},{\"filterName\":\"monthlyStartDate\",\"filterValues\":[\"2023-11-01\"]},{\"filterName\":\"placeId\",\"filterValues\":[\"ChIJyY4rtGcX2jERIKTarqz3AAQ\"]},{\"filterName\":\"priceFilterInputType\",\"filterValues\":[\"0\"]},{\"filterName\":\"priceFilterNumNights\",\"filterValues\":[\"31\"]},{\"filterName\":\"query\",\"filterValues\":[\"新加坡\"]},{\"filterName\":\"refinementPaths\",\"filterValues\":[\"/homes\"]},{\"filterName\":\"screenSize\",\"filterValues\":[\"small\"]},{\"filterName\":\"tabId\",\"filterValues\":[\"home_tab\"]},{\"filterName\":\"version\",\"filterValues\":[\"1.8.3\"]}]";

        String HongKong = "[{\"filterName\":\"cdnCacheSafe\",\"filterValues\":[\"false\"]},{\"filterName\":\"channel\",\"filterValues\":[\"EXPLORE\"]},{\"filterName\":\"datePickerType\",\"filterValues\":[\"monthly_stay\"]},{\"filterName\":\"flexibleTripLengths\",\"filterValues\":[\"one_week\"]},{\"filterName\":\"itemsPerGrid\",\"filterValues\":[\"18\"]},{\"filterName\":\"monthlyLength\",\"filterValues\":[\"1\"]},{\"filterName\":\"monthlyStartDate\",\"filterValues\":[\"2023-11-01\"]},{\"filterName\":\"placeId\",\"filterValues\":[\"ChIJByjqov3-AzQR2pT0dDW0bUg\"]},{\"filterName\":\"priceFilterInputType\",\"filterValues\":[\"0\"]},{\"filterName\":\"priceFilterNumNights\",\"filterValues\":[\"30\"]},{\"filterName\":\"query\",\"filterValues\":[\"中国香港\"]},{\"filterName\":\"refinementPaths\",\"filterValues\":[\"/homes\"]},{\"filterName\":\"screenSize\",\"filterValues\":[\"small\"]},{\"filterName\":\"tabId\",\"filterValues\":[\"home_tab\"]},{\"filterName\":\"version\",\"filterValues\":[\"1.8.3\"]}]";

        String Bangkok = "[{\"filterName\":\"cdnCacheSafe\",\"filterValues\":[\"false\"]},{\"filterName\":\"channel\",\"filterValues\":[\"EXPLORE\"]},{\"filterName\":\"datePickerType\",\"filterValues\":[\"monthly_stay\"]},{\"filterName\":\"flexibleTripLengths\",\"filterValues\":[\"one_week\"]},{\"filterName\":\"itemsPerGrid\",\"filterValues\":[\"18\"]},{\"filterName\":\"monthlyLength\",\"filterValues\":[\"1\"]},{\"filterName\":\"monthlyStartDate\",\"filterValues\":[\"2023-11-01\"]},{\"filterName\":\"placeId\",\"filterValues\":[\"ChIJ82ENKDJgHTERIEjiXbIAAQE\"]},{\"filterName\":\"priceFilterInputType\",\"filterValues\":[\"0\"]},{\"filterName\":\"priceFilterNumNights\",\"filterValues\":[\"30\"]},{\"filterName\":\"query\",\"filterValues\":[\"曼谷\"]},{\"filterName\":\"refinementPaths\",\"filterValues\":[\"/homes\"]},{\"filterName\":\"screenSize\",\"filterValues\":[\"small\"]},{\"filterName\":\"tabId\",\"filterValues\":[\"home_tab\"]},{\"filterName\":\"version\",\"filterValues\":[\"1.8.3\"]}]";

        String Tokyo = "[{\"filterName\":\"cdnCacheSafe\",\"filterValues\":[\"false\"]},{\"filterName\":\"channel\",\"filterValues\":[\"EXPLORE\"]},{\"filterName\":\"datePickerType\",\"filterValues\":[\"monthly_stay\"]},{\"filterName\":\"flexibleTripLengths\",\"filterValues\":[\"one_week\"]},{\"filterName\":\"itemsPerGrid\",\"filterValues\":[\"18\"]},{\"filterName\":\"monthlyLength\",\"filterValues\":[\"1\"]},{\"filterName\":\"monthlyStartDate\",\"filterValues\":[\"2023-11-01\"]},{\"filterName\":\"placeId\",\"filterValues\":[\"ChIJXSModoWLGGARILWiCfeu2M0\"]},{\"filterName\":\"priceFilterInputType\",\"filterValues\":[\"0\"]},{\"filterName\":\"priceFilterNumNights\",\"filterValues\":[\"30\"]},{\"filterName\":\"query\",\"filterValues\":[\"东京\"]},{\"filterName\":\"refinementPaths\",\"filterValues\":[\"/homes\"]},{\"filterName\":\"screenSize\",\"filterValues\":[\"small\"]},{\"filterName\":\"tabId\",\"filterValues\":[\"home_tab\"]},{\"filterName\":\"version\",\"filterValues\":[\"1.8.3\"]}]";

        String Sydney = "[{\"filterName\":\"cdnCacheSafe\",\"filterValues\":[\"false\"]},{\"filterName\":\"channel\",\"filterValues\":[\"EXPLORE\"]},{\"filterName\":\"datePickerType\",\"filterValues\":[\"monthly_stay\"]},{\"filterName\":\"flexibleTripLengths\",\"filterValues\":[\"one_week\"]},{\"filterName\":\"itemsPerGrid\",\"filterValues\":[\"18\"]},{\"filterName\":\"monthlyLength\",\"filterValues\":[\"1\"]},{\"filterName\":\"monthlyStartDate\",\"filterValues\":[\"2023-11-01\"]},{\"filterName\":\"placeId\",\"filterValues\":[\"ChIJP3Sa8ziYEmsRUKgyFmh9AQM\"]},{\"filterName\":\"priceFilterInputType\",\"filterValues\":[\"0\"]},{\"filterName\":\"priceFilterNumNights\",\"filterValues\":[\"30\"]},{\"filterName\":\"query\",\"filterValues\":[\"悉尼\"]},{\"filterName\":\"refinementPaths\",\"filterValues\":[\"/homes\"]},{\"filterName\":\"screenSize\",\"filterValues\":[\"small\"]},{\"filterName\":\"tabId\",\"filterValues\":[\"home_tab\"]},{\"filterName\":\"version\",\"filterValues\":[\"1.8.3\"]}]";
    }

}
