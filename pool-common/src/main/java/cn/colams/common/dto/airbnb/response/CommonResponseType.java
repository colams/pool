package cn.colams.common.dto.airbnb.response;

import cn.colams.common.dto.airbnb.common.Errors;
import cn.colams.common.dto.airbnb.common.LogExtensions;

import java.util.List;

public class CommonResponseType<T> {

    private T data;

    private LogExtensions extensions;

    private List<Errors> errors;

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

    public List<Errors> getErrors() {
        return errors;
    }

    public void setErrors(List<Errors> errors) {
        this.errors = errors;
    }
}
