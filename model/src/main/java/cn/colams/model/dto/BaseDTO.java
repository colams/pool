package cn.colams.model.dto;

public class BaseDTO<T> {

    private int resultCode;

    private String message;

    private T model;

    public int getResultCode() {
        return resultCode;
    }

    public void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }
}
