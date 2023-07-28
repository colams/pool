package cn.colams.web.controller.api;


import cn.colams.biz.airbnb.ScrapyList;
import cn.colams.biz.airbnb.ScrapyLord;
import cn.colams.biz.airbnb.ScrapyLord2List;
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
    private ScrapyList scrapyList;
    @Autowired
    private ScrapyLord scrapyLord;
    @Autowired
    private ScrapyLord2List lord2List;


    @GetMapping("/scrapy/list")
    public String scrapyList(@RequestParam String targetUrl, @RequestParam Boolean showBrowser) {
        scrapyList.scrapyList(targetUrl, null, showBrowser);
        return "success";
    }

    @GetMapping("/scrapy/lord")
    public String scrapyLord(@RequestParam Boolean showBrowser) {
        scrapyLord.scrapyLord(showBrowser);
        return "success";
    }


    @GetMapping("/scrapy/lord2list")
    public String lordList(@RequestParam Boolean showBrowser) {
        lord2List.lord2List(showBrowser);
        return "success";
    }

}
