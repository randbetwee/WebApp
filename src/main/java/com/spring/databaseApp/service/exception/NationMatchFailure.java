package com.spring.databaseApp.service.exception;

public class NationMatchFailure  extends ServiceException{
    public NationMatchFailure(String message){
        super(message);
    }

    public NationMatchFailure(String message, Throwable cause){
        super(message, cause);
    }

    public NationMatchFailure(Throwable cause){
        super(cause);
    }

    public NationMatchFailure(String message,Throwable cause,boolean enableSuppression ,boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
