package cn.colams.common.dto.airbnb.request;

import cn.colams.common.dto.airbnb.entity.RequestExtensions;

public class CommonRequestType<T> {
    private RequestExtensions extensions;
    private String operationName;
    private T variables;

    public RequestExtensions getExtensions() {
        return extensions;
    }

    public void setExtensions(RequestExtensions extensions) {
        this.extensions = extensions;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public T getVariables() {
        return variables;
    }

    public void setVariables(T variables) {
        this.variables = variables;
    }
}
