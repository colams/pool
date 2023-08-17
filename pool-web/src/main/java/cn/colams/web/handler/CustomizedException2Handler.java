package cn.colams.web.handler;

import cn.colams.model.dto.Response;
import cn.colams.web.utils.ResultUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Created by zhangzt on 2018/2/9.
 */
@RestControllerAdvice(basePackages = "cn.colams.web.restcontroller")
public class CustomizedException2Handler {

    @ExceptionHandler(value = Exception.class)
    public Response handler(Exception e) {
        return ResultUtils.failure(999, e.getMessage(), "");
    }
}
