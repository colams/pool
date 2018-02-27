package cn.colams.web.utils;

import cn.colams.model.dto.BaseDTO;

public class ResultUtils {

    public static <T> BaseDTO<T> createResult(T t) {
        BaseDTO<T> result = new BaseDTO<T>();
        result.setResult(t);
        result.setMessage("");
        result.setResultCode(0);
        return result;
    }
}
