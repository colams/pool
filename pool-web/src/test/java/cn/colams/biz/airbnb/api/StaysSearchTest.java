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

    @Test
    public void testStaysSearch() throws IOException {
        CommonResponseType<StaySearchData> response = staysSearch.staysSearch(getStaysSearchParams());
        System.out.println(JacksonSerializerUtil.serialize(response));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>");
    }

    @Test
    public void testCrawlerStaysSearch() throws IOException, InterruptedException {
        String result = staysSearch.crawlerStaysSearch();
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
        return "{\n" +
                "    \"operationName\": \"StaysSearch\",\n" +
                "    \"variables\": {\n" +
                "        \"staysSearchRequest\": {\n" +
                "            \"requestedPageType\": \"STAYS_SEARCH\",\n" +
                "            \"cursor\": \"{\\\"section_offset\\\":1,\\\"items_offset\\\":270,\\\"version\\\":1}\",\n" +
                "            \"metadataOnly\": false,\n" +
                "            \"searchType\": \"filter_change\",\n" +
                "            \"treatmentFlags\": [\n" +
                "                \"decompose_stays_search_m2_treatment\",\n" +
                "                \"decompose_stays_search_m3_treatment\",\n" +
                "                \"decompose_stays_search_m3_5_treatment\",\n" +
                "                \"flex_destinations_june_2021_launch_web_treatment\",\n" +
                "                \"new_filter_bar_v2_fm_header\",\n" +
                "                \"flexible_dates_12_month_lead_time\",\n" +
                "                \"lazy_load_flex_search_map_compact\",\n" +
                "                \"lazy_load_flex_search_map_wide\",\n" +
                "                \"im_flexible_may_2022_treatment\",\n" +
                "                \"search_add_category_bar_ui_ranking_web\",\n" +
                "                \"feed_map_decouple_m11_treatment\",\n" +
                "                \"flexible_dates_options_extend_one_three_seven_days\",\n" +
                "                \"super_date_flexibility\",\n" +
                "                \"micro_flex_improvements\",\n" +
                "                \"micro_flex_show_by_default\",\n" +
                "                \"search_input_placeholder_phrases\",\n" +
                "                \"pets_fee_treatment\"\n" +
                "            ],\n" +
                "            \"rawParams\": [\n" +
                "                {\n" +
                "                    \"filterName\": \"categoryTag\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"Tag:677\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"cdnCacheSafe\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"false\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"channel\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"EXPLORE\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"federatedSearchSessionId\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"cbb023c8-6af2-47f9-989a-5d6ed7435511\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"flexibleTripLengths\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"one_week\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"itemsPerGrid\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"18\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"locationSearch\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"MIN_MAP_BOUNDS\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"monthlyLength\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"3\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"monthlyStartDate\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"2023-09-01\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"placeId\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"ChIJ33KYXQNCXz4R75Vyz3iKaSk\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"priceFilterInputType\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"0\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"priceFilterNumNights\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"5\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"query\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"Jumeirah Beach, 阿拉伯联合酋长国\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"refinementPaths\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"/homes\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"screenSize\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"large\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"searchMode\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"flex_destinations_search\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"tabId\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"home_tab\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"version\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"1.8.3\"\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        \"staysMapSearchRequestV2\": {\n" +
                "            \"requestedPageType\": \"STAYS_SEARCH\",\n" +
                "            \"cursor\": \"eyJzZWN0aW9uX29mZnNldCI6MSwiaXRlbXNfb2Zmc2V0IjoxODAsInZlcnNpb24iOjF9\",\n" +
                "            \"metadataOnly\": false,\n" +
                "            \"searchType\": \"filter_change\",\n" +
                "            \"treatmentFlags\": [\n" +
                "                \"decompose_stays_search_m2_treatment\",\n" +
                "                \"decompose_stays_search_m3_treatment\",\n" +
                "                \"decompose_stays_search_m3_5_treatment\",\n" +
                "                \"flex_destinations_june_2021_launch_web_treatment\",\n" +
                "                \"new_filter_bar_v2_fm_header\",\n" +
                "                \"flexible_dates_12_month_lead_time\",\n" +
                "                \"lazy_load_flex_search_map_compact\",\n" +
                "                \"lazy_load_flex_search_map_wide\",\n" +
                "                \"im_flexible_may_2022_treatment\",\n" +
                "                \"search_add_category_bar_ui_ranking_web\",\n" +
                "                \"feed_map_decouple_m11_treatment\",\n" +
                "                \"flexible_dates_options_extend_one_three_seven_days\",\n" +
                "                \"super_date_flexibility\",\n" +
                "                \"micro_flex_improvements\",\n" +
                "                \"micro_flex_show_by_default\",\n" +
                "                \"search_input_placeholder_phrases\",\n" +
                "                \"pets_fee_treatment\"\n" +
                "            ],\n" +
                "            \"rawParams\": [\n" +
                "                {\n" +
                "                    \"filterName\": \"categoryTag\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"Tag:677\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"cdnCacheSafe\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"false\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"channel\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"EXPLORE\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"federatedSearchSessionId\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"cbb023c8-6af2-47f9-989a-5d6ed7435511\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"flexibleTripLengths\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"one_week\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"itemsPerGrid\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"18\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"locationSearch\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"MIN_MAP_BOUNDS\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"monthlyLength\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"3\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"monthlyStartDate\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"2023-09-01\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"placeId\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"ChIJ33KYXQNCXz4R75Vyz3iKaSk\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"priceFilterInputType\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"0\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"priceFilterNumNights\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"5\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"query\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"Jumeirah Beach, 阿拉伯联合酋长国\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"refinementPaths\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"/homes\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"screenSize\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"large\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"searchMode\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"flex_destinations_search\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"tabId\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"home_tab\"\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"filterName\": \"version\",\n" +
                "                    \"filterValues\": [\n" +
                "                        \"1.8.3\"\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        \"feedMapDecoupleEnabled\": true,\n" +
                "        \"decomposeFiltersEnabled\": false,\n" +
                "        \"decomposeCleanupEnabled\": false\n" +
                "    },\n" +
                "    \"extensions\": {\n" +
                "        \"persistedQuery\": {\n" +
                "            \"version\": 1,\n" +
                "            \"sha256Hash\": \"d6c7011df2d9826b236c31cf81ab1bce2e601ce3302dec89f8f6325c2223d5a3\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
    }

}