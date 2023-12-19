package com.spring.databaseApp.service.exception;

public class FileUploadFailed  extends ServiceException{
    public FileUploadFailed(String message){
        super(message);
    }

    public FileUploadFailed(String message, Throwable cause){
        super(message, cause);
    }

    public FileUploadFailed(Throwable cause){
        super(cause);
    }

    public FileUploadFailed(String message,Throwable cause,boolean enableSuppression ,boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
