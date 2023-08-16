package cn.colams.common.exception;

import cn.colams.model.IResult;

public class ServiceException extends RuntimeException {

    protected IResult result;

    public ServiceException(IResult result) {
        super(result.getMessage());
        this.result = result;
    }

}
