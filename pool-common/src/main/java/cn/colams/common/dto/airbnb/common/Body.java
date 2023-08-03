package cn.colams.common.dto.airbnb.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Body {

    @JsonProperty("error_code")
    private int errorCode;
    private String error;
    @JsonProperty("error_message")
    private String errorMessage;

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
