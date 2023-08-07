package cn.colams.biz.airbnb.api;

import cn.colams.common.CommonTest;
import cn.colams.common.dto.airbnb.entity.StaySearchData;
import cn.colams.common.dto.airbnb.response.CommonResponseType;
import cn.colams.common.utils.JacksonSerializerUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class StaysSearchTest extends CommonTest {


    @Autowired
    StaysSearch staysSearch;

    /**
     * 爬取房间信息
     *
     * @throws IOException
     */
    @Test
    public void testStaysSearch() throws IOException {
        CommonResponseType<StaySearchData> response = staysSearch.staysSearch(getStaysSearchParams());
        System.out.println(JacksonSerializerUtil.serialize(response));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    @Test
    public void testCrawlerStaysSearch() throws Exception {
        String result = staysSearch.crawlerStaysSearch("Singapore");
        System.out.println(result);
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    @Test
    public void testData() {
        String json = "{\"errors\":[{\"message\":\"java.lang.NullPointerException: null\",\"locations\":[{\"line\":24,\"column\":7}],\"path\":[\"presentation\",\"explore\",\"sections\"],\"extensions\":{\"fieldName\":\"sections\",\"parentType\":\"ExplorePresentation\",\"tenant\":\"viaduct-presentation-explore\",\"localizedMessage\":\"Sorry, something went wrong. Please try again later.\",\"classification\":\"DataFetchingException\"}}],\"data\":{\"presentation\":{\"__typename\":\"RootPresentationContainer\",\"explore\":{\"__typename\":\"ExplorePresentation\",\"sections\":null}}},\"extensions\":{\"traceId\":\"4wRGD7MDVHNp32VZOk6-aw==\"}}";
        CommonResponseType<StaySearchData> responseType = JacksonSerializerUtil.deserialize(json, CommonResponseType.class, StaySearchData.class);

        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");

    }

    private String getStaysSearchParams() {
        return "{\"extensions\":{\"persistedQuery\":{\"sha256Hash\":\"d6c7011df2d9826b236c31cf81ab1bce2e601ce3302dec89f8f6325c2223d5a3\",\"version\":1}},\"operationName\":\"StaysSearch\",\"variables\":{\"decomposeCleanupEnabled\":false,\"decomposeFiltersEnabled\":false,\"feedMapDecoupleEnabled\":true,\"staysMapSearchRequestV2\":{\"metadataOnly\":false,\"rawParams\":[{\"filterName\":\"cdnCacheSafe\",\"filterValues\":[\"false\"]},{\"filterName\":\"channel\",\"filterValues\":[\"EXPLORE\"]},{\"filterName\":\"datePickerType\",\"filterValues\":[\"monthly_stay\"]},{\"filterName\":\"flexibleTripLengths\",\"filterValues\":[\"one_week\"]},{\"filterName\":\"itemsPerGrid\",\"filterValues\":[\"18\"]},{\"filterName\":\"monthlyLength\",\"filterValues\":[\"1\"]},{\"filterName\":\"monthlyStartDate\",\"filterValues\":[\"2023-11-01\"]},{\"filterName\":\"placeId\",\"filterValues\":[\"ChIJyY4rtGcX2jERIKTarqz3AAQ\"]},{\"filterName\":\"priceFilterInputType\",\"filterValues\":[\"0\"]},{\"filterName\":\"priceFilterNumNights\",\"filterValues\":[\"31\"]},{\"filterName\":\"query\",\"filterValues\":[\"新加坡\"]},{\"filterName\":\"refinementPaths\",\"filterValues\":[\"/homes\"]},{\"filterName\":\"screenSize\",\"filterValues\":[\"small\"]},{\"filterName\":\"tabId\",\"filterValues\":[\"home_tab\"]},{\"filterName\":\"version\",\"filterValues\":[\"1.8.3\"]}],\"requestedPageType\":\"STAYS_SEARCH\",\"searchType\":\"filter_change\",\"source\":\"structured_search_input_header\",\"treatmentFlags\":[\"decompose_stays_search_m2_treatment\",\"decompose_stays_search_m3_treatment\",\"decompose_stays_search_m3_5_treatment\",\"flex_destinations_june_2021_launch_web_treatment\",\"new_filter_bar_v2_and_fm_treatment\",\"flexible_dates_12_month_lead_time\",\"lazy_load_flex_search_map_compact\",\"lazy_load_flex_search_map_wide\",\"im_flexible_may_2022_treatment\",\"search_add_category_bar_ui_ranking_web\",\"feed_map_decouple_m11_treatment\",\"flexible_dates_options_extend_one_three_seven_days\",\"super_date_flexibility\",\"micro_flex_improvements\",\"micro_flex_show_by_default\",\"search_input_placeholder_phrases\",\"pets_fee_treatment\"]},\"staysSearchRequest\":{\"metadataOnly\":false,\"rawParams\":[{\"filterName\":\"cdnCacheSafe\",\"filterValues\":[\"false\"]},{\"filterName\":\"channel\",\"filterValues\":[\"EXPLORE\"]},{ba\"filterName\":\"datePickerType\",\"filterValues\":[\"monthly_stay\"]},{\"filterName\":\"flexibleTripLengths\",\"filterValues\":[\"one_week\"]},{\"filterName\":\"itemsPerGrid\",\"filterValues\":[\"18\"]},{\"filterName\":\"monthlyLength\",\"filterValues\":[\"1\"]},{\"filterName\":\"monthlyStartDate\",\"filterValues\":[\"2023-11-01\"]},{\"filterName\":\"placeId\",\"filterValues\":[\"ChIJyY4rtGcX2jERIKTarqz3AAQ\"]},{\"filterName\":\"priceFilterInputType\",\"filterValues\":[\"0\"]},{\"filterName\":\"priceFilterNumNights\",\"filterValues\":[\"31\"]},{\"filterName\":\"query\",\"filterValues\":[\"新加坡\"]},{\"filterName\":\"refinementPaths\",\"filterValues\":[\"/homes\"]},{\"filterName\":\"screenSize\",\"filterValues\":[\"small\"]},{\"filterName\":\"tabId\",\"filterValues\":[\"home_tab\"]},{\"filterName\":\"version\",\"filterValues\":[\"1.8.3\"]}],\"requestedPageType\":\"STAYS_SEARCH\",\"searchType\":\"filter_change\",\"source\":\"structured_search_input_header\",\"treatmentFlags\":[\"decompose_stays_search_m2_treatment\",\"decompose_stays_search_m3_treatment\",\"decompose_stays_search_m3_5_treatment\",\"flex_destinations_june_2021_launch_web_treatment\",\"new_filter_bar_v2_and_fm_treatment\",\"flexible_dates_12_month_lead_time\",\"lazy_load_flex_search_map_compact\",\"lazy_load_flex_search_map_wide\",\"im_flexible_may_2022_treatment\",\"search_add_category_bar_ui_ranking_web\",\"feed_map_decouple_m11_treatment\",\"flexible_dates_options_extend_one_three_seven_days\",\"super_date_flexibility\",\"micro_flex_improvements\",\"micro_flex_show_by_default\",\"search_input_placeholder_phrases\",\"pets_fee_treatment\"]}}}";
    }

}