package com.spring.databaseApp.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.databaseApp.util.JsonResult;

@RestController
public class errorController extends BaseController {
    
    @RequestMapping("err/notLogin")
    public JsonResult<String> notLogin(){
        return new JsonResult<String>(2006,"请先登录后解锁该功能");
    }

    @RequestMapping("err/noAuthority")
    public JsonResult<String> noAuth(){
        return new JsonResult<String>(2007,"不是管理员，暂无该权限");
    }
}
