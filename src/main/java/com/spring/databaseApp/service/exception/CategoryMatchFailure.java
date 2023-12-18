package com.spring.databaseApp.service.exception;

public  class CategoryMatchFailure extends ServiceException{
    public CategoryMatchFailure(String message){
        super(message);
    }

    public CategoryMatchFailure(String message, Throwable cause){
        super(message, cause);
    }

    public CategoryMatchFailure(Throwable cause){
        super(cause);
    }

    public CategoryMatchFailure(String message,Throwable cause,boolean enableSuppression ,boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
