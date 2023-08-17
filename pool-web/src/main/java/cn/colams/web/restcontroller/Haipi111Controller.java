package cn.colams.web.restcontroller;


import cn.colams.biz.haipi111.Haipi111Biz;
import cn.colams.common.utils.JacksonSerializerUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Api(value = "haipi", tags = {"haipi"})
@Controller
@RequestMapping("/api/haipi")
public class Haipi111Controller {

    @Autowired
    Haipi111Biz haipi111Biz;

    @ResponseBody
    @GetMapping("/list")
    public Object list() throws Exception {
        return haipi111Biz.list();
    }


    @GetMapping("/infoid")
    public Object getHaipiDetail(@PathVariable("infoid") String infoid) {
        if (StringUtils.isEmpty(infoid)) {
            return "error";
        }

        return JacksonSerializerUtil.serialize(haipi111Biz.getHaipiDetail(infoid));
    }


}
