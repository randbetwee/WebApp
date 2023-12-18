package com.spring.databaseApp.service.exception;

public class DuplicatedName extends ServiceException{
    public DuplicatedName(String message){
        super(message);
    }

    public DuplicatedName(String message, Throwable cause){
        super(message, cause);
    }

    public DuplicatedName(Throwable cause){
        super(cause);
    }

    public DuplicatedName(String message,Throwable cause,boolean enableSuppression ,boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
