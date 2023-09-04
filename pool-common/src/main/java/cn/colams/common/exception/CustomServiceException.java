package cn.colams.common.exception;

import cn.colams.model.IResult;

public class CustomServiceException extends RuntimeException {

    protected IResult result;

    public CustomServiceException(IResult result) {
        super(result.getMessage());
        this.result = result;
    }

}
