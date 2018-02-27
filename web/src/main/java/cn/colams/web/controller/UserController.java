package cn.colams.web.controller;

import cn.colams.common.utils.UuidUtils;
import cn.colams.model.dto.Acount;
import cn.colams.model.dto.BaseDTO;
import cn.colams.web.utils.ResultUtils;
import com.alibaba.dubbo.common.utils.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


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


    @GetMapping("/uuid1")
    public String getUUID1(HttpSession session) {
        String uuid = UuidUtils.getUuid();
        List<String> uuidList = null;

        Object obj = session.getAttribute("uuid");

        if (obj instanceof ArrayList) {
            uuidList = (ArrayList) obj;
        }

        if (CollectionUtils.isEmpty(uuidList)) {
            uuidList = new ArrayList<String>();
        }

        uuidList.add(uuid);
        session.setAttribute("uuid", uuidList);
        return uuid;
    }
}
