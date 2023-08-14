package cn.colams.web.controller;

import cn.colams.common.utils.UUIDUtils;
import cn.colams.model.dto.entity.Account;
import cn.colams.model.dto.Response;
import cn.colams.model.enums.RetCode;
import cn.colams.web.utils.ResultUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/uuid")
    public Response<Account> getUUID(HttpServletRequest request) {
        String uuid = UUIDUtils.getUuid();

        Account account = new Account();
        account.setUuid(uuid);
        account.setLevel(0);
        account.setUserName("测试");
        HttpSession session = request.getSession();
        session.setAttribute(uuid, account);
        return ResultUtils.createResult(account, RetCode.SUCCESS);
    }

    @GetMapping("/valid")
    public Response<Account> validUser(HttpSession session, @RequestParam String uuid) {

        Account account = null;
        RetCode retCode;
        Object object = session.getAttribute(uuid);
        if (object != null && object instanceof Account) {
            account = (Account) object;
        }

        if (account == null) {
            retCode = RetCode.FAILURE;
        } else {
            retCode = RetCode.SUCCESS;
        }

        return ResultUtils.createResult(account, retCode);
    }


}
