package cn.colams.web.controller;

import cn.colams.common.utils.UuidUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/uuid")
    public String getUUID(HttpSession session) {
        String uuid = UuidUtils.getUuid();
        session.setAttribute("uuid", uuid);
        return uuid;
    }
}
