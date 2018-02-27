package cn.colams.web.controller;

import cn.colams.common.utils.UuidUtils;
import cn.colams.model.dto.Acount;
import cn.colams.model.dto.BaseDTO;
import cn.colams.web.utils.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/uuid")
    public BaseDTO<Acount> getUUID(HttpSession session) {
        String uuid = UuidUtils.getUuid();

        Acount acount = new Acount();
        acount.setUuid(uuid);
        acount.setLevel(0);
        acount.setUserName("李苏女士");

        session.setAttribute(uuid, acount);

        return ResultUtils.createResult(acount);
    }
}
