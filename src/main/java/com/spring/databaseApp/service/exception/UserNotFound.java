package com.spring.databaseApp.service.exception;

public class UserNotFound extends ServiceException{
    public UserNotFound(){
        super();
    }

    public UserNotFound(String message){
        super(message);
    }

    public UserNotFound(String message, Throwable cause){
        super(message, cause);
    }

    public UserNotFound(Throwable cause){
        super(cause);
    }

    public UserNotFound(String message,Throwable cause,boolean enableSuppression ,boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
