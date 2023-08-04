package cn.colams.common.dto.airbnb.response;

import cn.colams.common.dto.airbnb.common.LogExtensions;

public class CommonResponseType<T> {

    private T data;

    private LogExtensions extensions;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public LogExtensions getExtensions() {
        return extensions;
    }

    public void setExtensions(LogExtensions extensions) {
        this.extensions = extensions;
    }
}
