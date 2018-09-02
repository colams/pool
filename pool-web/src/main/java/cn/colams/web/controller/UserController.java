package cn.colams.web.controller;

import cn.colams.common.utils.UUIDUtils;
import cn.colams.model.dto.Account;
import cn.colams.model.dto.BaseDTO;
import cn.colams.model.enums.RetCode;
import cn.colams.web.utils.ResultUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/uuid")
    public BaseDTO<Account> getUUID(HttpSession session) {
        String uuid = UUIDUtils.getUuid();

        Account account = new Account();
        account.setUuid(uuid);
        account.setLevel(0);
        account.setUserName("测试");

        session.setAttribute(uuid, account);

        return ResultUtils.createResult(account, RetCode.SUCCESS);
    }

    @GetMapping("/valid")
    public BaseDTO<Account> validUser(HttpSession session, @RequestParam String uuid) {

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
