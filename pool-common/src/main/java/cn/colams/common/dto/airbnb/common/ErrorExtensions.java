package cn.colams.common.dto.airbnb.common;

public class ErrorExtensions {
    private Response response;
    private String code;

    public void setResponse(Response response) {
        this.response = response;
    }

    public Response getResponse() {
        return response;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
