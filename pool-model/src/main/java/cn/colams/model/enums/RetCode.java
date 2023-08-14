package cn.colams.model.enums;

public enum RetCode {

    SUCCESS(0, "成功"),
    FAILURE(1, "失败"),;

    public int code;
    public String message;


    RetCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
