package com.spring.databaseApp.service.exception;

public class InsertException extends ServiceException{
    
    public InsertException(String message){
        super(message);
    }

    public InsertException(String message, Throwable cause){
        super(message, cause);
    }

    public InsertException(Throwable cause){
        super(cause);
    }

    public InsertException(String message,Throwable cause,boolean enableSuppression ,boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
