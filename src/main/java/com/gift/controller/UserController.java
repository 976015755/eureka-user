package com.gift.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gift.exception.GlobalException;
import com.gift.result.CodeMsg;
import com.gift.result.Result;
import com.gift.vo.Login;

@RestController
@RequestMapping(value = "/user/")
public class UserController {
    @RequestMapping(value = "login")
    public Result<?> login(
    		HttpServletRequest request, 
    		@Valid Login login) {
    	throw new GlobalException(CodeMsg.MOBILE_EMPTY);
        //return Result.success("登陆成功");
    }

}
