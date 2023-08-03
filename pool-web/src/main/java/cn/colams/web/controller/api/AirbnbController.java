package cn.colams.web.controller.api;


import cn.colams.biz.airbnb.CrawlerApiKey;
import cn.colams.biz.airbnb.CrawlerList;
import cn.colams.biz.airbnb.CrawlerLord;
import cn.colams.biz.airbnb.CrawlerLord2List;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public String lordList(@RequestParam Boolean showBrowser, @RequestParam String lordId) {
        lord2List.lord2List(showBrowser, lordId);
        return "success";
    }

    @GetMapping("/apikey")
    public String apikey(@RequestParam String url) {
        return crawlerApiKey.crawlerApiKey(url);
    }

}
