package cn.colams.model.enums;

import cn.colams.model.IResult;

public enum RetCode implements IResult {
    SUCCESS(0, "接口调用成功"),
    FAILURE(1, "接口调用失败"),
    VALIDATE_FAILED(2, "参数校验失败"),
    FORBIDDEN(3, "没有权限访问资源");;

    RetCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int code;
    public String message;


    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
