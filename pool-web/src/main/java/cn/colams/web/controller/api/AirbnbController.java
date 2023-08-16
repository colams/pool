package cn.colams.web.controller.api;


import cn.colams.biz.airbnb.CrawlerApiKey;
import cn.colams.biz.airbnb.CrawlerList;
import cn.colams.biz.airbnb.CrawlerLord;
import cn.colams.biz.airbnb.CrawlerLord2List;
import cn.colams.biz.airbnb.api.StaysSearch;
import cn.colams.biz.business.airbnb.SearchAirbnbLordBusiness;
import cn.colams.biz.business.airbnb.SearchAirbnbRoomsBusiness;
import cn.colams.dal.entity.Airbnb;
import cn.colams.dal.entity.AirbnbLord;
import cn.colams.model.dto.Request;
import cn.colams.model.dto.Response;
import cn.colams.model.dto.airbnb.SearchAirbnbLordParams;
import cn.colams.model.dto.airbnb.SearchAirbnbRoomsParams;
import cn.colams.model.dto.airbnb.SearchResultWithPage;
import cn.colams.model.enums.RetCode;
import cn.colams.web.utils.ResultUtils;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@Api(value = "airbnb", tags = {"airbnb"})
@RestController
@RequestMapping("/api/airbnb")
public class AirbnbController {

    @Autowired
    private CrawlerList crawlerList;
    @Autowired
    private CrawlerLord crawlerLord;
    @Autowired
    private CrawlerLord2List lord2List;
    @Autowired
    private CrawlerApiKey crawlerApiKey;
    @Autowired
    private StaysSearch staysSearch;

    @Autowired
    private SearchAirbnbRoomsBusiness searchAirbnbRoomsBusiness;
    @Autowired
    private SearchAirbnbLordBusiness searchAirbnbLordBusiness;


    @GetMapping("/list")
    public String crawlerList(@RequestParam String targetUrl, @RequestParam Boolean showBrowser) {
        crawlerList.crawlerList(targetUrl, null, showBrowser);
        return "success";
    }

    @GetMapping("/lord")
    public String crawlerLord(@RequestParam Boolean showBrowser) {
        crawlerLord.crawlerLord(showBrowser);
        return "success";
    }


    @GetMapping("/lord2list")
    public String lordList(@RequestParam(required = false, defaultValue = "") String lordId) {
        lord2List.lord2List(lordId);
        return "success";
    }

    @GetMapping("/apikey")
    public String apikey(@RequestParam(required = false, defaultValue = "") String url) {
        return crawlerApiKey.crawlerApiKey(url);
    }


    @GetMapping("/staySearch")
    public Response staySearch(@RequestParam String cityName) throws Exception {
        String result = staysSearch.crawlerStaysSearch(cityName);
        return ResultUtils.createResult(result, RetCode.SUCCESS, cityName);
    }

    @PostMapping("/rooms")
    public Response searchAirbnbRooms(@RequestBody Request<SearchAirbnbRoomsParams> request) throws ParseException {
        SearchResultWithPage<List<Airbnb>> airbnbs = searchAirbnbRoomsBusiness.searchAirbnbRooms(request.getData());
        return ResultUtils.createResult(airbnbs, RetCode.SUCCESS, request.getTraceId());
    }


    @PostMapping("/lords")
    public Response searchAirbnbLord(@RequestBody Request<SearchAirbnbLordParams> request) throws ParseException {
        SearchResultWithPage<List<AirbnbLord>> lords = searchAirbnbLordBusiness.searchAirbnbLord(request.getData());
        return ResultUtils.createResult(lords, RetCode.SUCCESS, request.getTraceId());
    }


}
