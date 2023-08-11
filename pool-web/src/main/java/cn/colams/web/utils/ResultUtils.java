package cn.colams.web.utils;

import cn.colams.model.dto.Response;
import cn.colams.model.enums.RetCode;

public class ResultUtils {

    public static <T> Response<T> createResult(T t, RetCode retCode) {
        Response<T> result = new Response<T>();
        result.setResult(t);
        result.setMessage(retCode.message);
        result.setResultCode(retCode.code);
        return result;
    }
}
