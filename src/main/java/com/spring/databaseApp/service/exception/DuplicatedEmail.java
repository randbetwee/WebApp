package com.spring.databaseApp.service.exception;

public class DuplicatedEmail extends ServiceException{
    
        public DuplicatedEmail(String message){
            super(message);
        }
    
        public DuplicatedEmail(String message, Throwable cause){
            super(message, cause);
        }
    
        public DuplicatedEmail(Throwable cause){
            super(cause);
        }
    
        public DuplicatedEmail(String message,Throwable cause,boolean enableSuppression ,boolean writableStackTrace){
            super(message, cause, enableSuppression, writableStackTrace);
        }
}

