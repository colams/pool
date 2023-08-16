package cn.colams.web.utils;

import cn.colams.model.IResult;
import cn.colams.model.dto.Response;
import cn.colams.model.enums.RetCode;

public class ResultUtils {

    public static <T> Response<T> createResult(T t, IResult retCode, String traceId) {
        Response<T> result = new Response<T>();
        result.setResult(t);
        result.setMessage(retCode.getMessage());
        result.setErrorCode(retCode.getCode());
        result.setTraceId(traceId);

        result.setHost("");
        result.setShowType(0);
        return result;
    }

    public static Response failureCode(IResult retCode, String traceId) {
        Response result = new Response();
        result.setMessage(retCode.getMessage());
        result.setErrorCode(retCode.getCode());
        result.setTraceId(traceId);

        result.setHost("");
        result.setShowType(0);
        return result;
    }

    public static Response failure(String traceId) {
        Response result = new Response();
        result.setMessage(RetCode.FAILURE.getMessage());
        result.setErrorCode(RetCode.FAILURE.getCode());
        result.setTraceId(traceId);

        result.setHost("");
        result.setShowType(0);
        return result;
    }

    public static Response success(String traceId) {
        Response result = new Response();
        result.setMessage(RetCode.SUCCESS.getMessage());
        result.setErrorCode(RetCode.SUCCESS.getCode());
        result.setTraceId(traceId);

        result.setHost("");
        result.setShowType(0);
        return result;
    }
}
