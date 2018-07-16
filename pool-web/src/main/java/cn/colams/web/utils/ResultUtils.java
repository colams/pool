package cn.colams.web.utils;

import cn.colams.model.dto.BaseDTO;
import cn.colams.model.enums.RetCode;

public class ResultUtils {

    public static <T> BaseDTO<T> createResult(T t, RetCode retCode) {
        BaseDTO<T> result = new BaseDTO<T>();
        result.setResult(t);
        result.setMessage(retCode.message);
        result.setResultCode(retCode.code);
        return result;
    }
}
