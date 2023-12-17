package com.spring.databaseApp.util;

import java.lang.Throwable;
import java.io.Serializable;

//对JSON格式的数据进行响应,返回给前端浏览器
public class JsonResult<E> implements Serializable {
    private Integer state;   //响应状态码
    private String Message;   //状态码描述信息
    private E data;

    
    public JsonResult() {
        
    }
    public JsonResult(Integer state, E data) {
        this.state = state;
        this.data = data;
    }
    public JsonResult(Integer state) {
        this.state = state;
    }

    public JsonResult(Throwable exception) {
        this.Message = exception.getMessage();
    }

    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
    public void setMessage(String message) {
        this.Message = message;
    }
    public void setData(E data) {
        this.data = data;
    }

    public E getData() {
        return data;
    }

    public String getMessage() {
        return Message;
    }

}
