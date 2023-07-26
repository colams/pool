package cn.colams.web.controller.api;


import cn.colams.biz.airbnb.AirbnbBusiness;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "airbnb", tags = {"airbnb"})
@RestController
@RequestMapping("/airbnb")
public class AirbnbController {

    @Autowired
    private AirbnbBusiness airbnbBusiness;

    @GetMapping("/scrapy/list")
    public String scrapyList(@RequestParam String targetUrl, @RequestParam Boolean showBrowser) {
        airbnbBusiness.scrapyList(targetUrl, null, showBrowser);
        return "success";
    }

    @GetMapping("/scrapy/lord")
    public String scrapyLord(@RequestParam Boolean showBrowser) {
        airbnbBusiness.scrapyLord(showBrowser);
        return "success";
    }

}
