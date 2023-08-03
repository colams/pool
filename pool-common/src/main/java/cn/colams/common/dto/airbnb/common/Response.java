package cn.colams.common.dto.airbnb.common;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Response {

    @JsonProperty("statusCode")
    private int statuscode;
    private Body body;

    public void setStatuscode(int statuscode) {
        this.statuscode = statuscode;
    }

    public int getStatuscode() {
        return statuscode;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    public Body getBody() {
        return body;
    }
}
