package cn.colams.biz.airbnb.api;

import cn.colams.common.airbnb.AirbnbApiKeyUtils;
import cn.colams.common.dto.airbnb.entity.*;
import cn.colams.common.dto.airbnb.request.CommonRequestType;
import cn.colams.common.dto.airbnb.response.CommonResponseType;
import cn.colams.common.utils.HttpUtils;
import cn.colams.common.utils.JacksonSerializerUtil;
import cn.colams.dal.entity.Airbnb;
import cn.colams.dal.mapper.extension.AirbnbExtensionMapper;
import com.google.common.collect.Lists;
import org.apache.http.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.*;

@Component
public class StaysSearch {

    @Autowired
    AirbnbExtensionMapper airbnbExtensionMapper;

    public String crawlerStaysSearch() throws IOException {
        int pageIndex = 1;
        String data = getStaysSearchParamsV2();
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

        String cursor = response.getPaginationInfo().getNextPageCursor();
        Base64.getDecoder().decode(cursor);

        String state = response.getLoggingMetadata().getRemarketingLoggingData().getState();
        Optional.ofNullable(response.getSearchResults()).orElse(Lists.newArrayList()).forEach(result -> {
            Airbnb airbnb = airbnbExtensionMapper.selectByRoomId(result.getListing().getId());
            airbnb.withrState(state)
                    .withPrice(result.getPricingQuote().getStructuredStayDisplayPrice().getPrimaryline().getAccessibilitylabel())
                    .withrSrouce(2)
                    .withPage(pageIndex)
                    .withRoomName(result.getListing().getName())
                    .withPictureCount(result.getListing().getContextualPicturesCount())
                    .withRoomId(result.getListing().getId())
                    .withRoomUrl(String.format(Constant.ROOM_DETAIL_URL_TEMPLATE, result.getListing().getId()))
                    .withExtra(result.getListing().getAvgRatingA11yLabel())
                    .withRoomLocation(String.format("%s,%s", result.getListing().getCoordinate().getLatitude(), result.getListing().getCoordinate().getLongitude()))
                    .withOrgUrl("")
                    .withDealStatus(0);
            airbnbExtensionMapper.insertOrUpdate(airbnb);
        });
        return "success";
    }

    public CommonResponseType<StaySearchData> staysSearch(String requestData) throws IOException {
        String url = "https://zh.airbnb.com/api/v3/StaysSearch?operationName=StaysSearch&locale=zh&currency=SGD";
        List<Header> headers = AirbnbApiKeyUtils.getHeaders();
        String res = HttpUtils.doPost(url, requestData, headers);
        CommonResponseType<StaySearchData> response = JacksonSerializerUtil.deserialize(res, CommonResponseType.class, StaySearchData.class);
        return response;
    }

    private String getStaysSearchParamsV2() {
        CommonRequestType<StaysSearchVariables> requestType = new CommonRequestType<>();
        requestType.setExtensions(buildExtensions());
        requestType.setOperationName("StaysSearch");
        requestType.setVariables(buildVariables());
        return JacksonSerializerUtil.serialize(requestType);
    }

    private StaysSearchVariables buildVariables() {
        StaysSearchVariables variables = new StaysSearchVariables();
        variables.setDecomposeCleanupEnabled(false);
        variables.setDecomposeFiltersEnabled(false);
        variables.setFeedMapDecoupleEnabled(true);
        StaysSearchRequest searchRequest = buildSearchRequest();
        variables.setStaysMapSearchRequestV2(searchRequest);
        variables.setStaysSearchRequest(searchRequest);
        return variables;
    }

    private StaysSearchRequest buildSearchRequest() {
        StaysSearchRequest request = new StaysSearchRequest();
        request.setMetadataOnly(false);
        request.setRawParams(initRawParams());
        request.setRequestedPageType("STAYS_SEARCH");
        request.setSearchType("filter_change");
        request.setSource("structured_search_input_header");
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
        request.setCursor("{\"section_offset\":0,\"items_offset\":0,\"version\":1}");
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
