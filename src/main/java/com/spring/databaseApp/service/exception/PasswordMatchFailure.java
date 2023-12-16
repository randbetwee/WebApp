package com.spring.databaseApp.service.exception;

public class PasswordMatchFailure extends ServiceException{
    public PasswordMatchFailure(){
        super();
    }

    public PasswordMatchFailure(String message){
        super(message);
    }

    public PasswordMatchFailure(String message, Throwable cause){
        super(message, cause);
    }

    public PasswordMatchFailure(Throwable cause){
        super(cause);
    }

    public PasswordMatchFailure(String message,Throwable cause,boolean enableSuppression ,boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }

    
}
