package com.gift.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gift.exception.GlobalException;
import com.gift.result.CodeMsg;
import com.gift.result.Result;
import com.gift.service.UserService;
import com.gift.vo.Login;

@RestController
@RequestMapping(value = "/user/")
public class UserController {
	@Autowired
	UserService userService;
	
	/**
	 * 登陆
	 * @param request
	 * @param login
	 * @return
	 */
    @RequestMapping(value = "login")
    public Result<?> login(
    		HttpServletRequest request, 
    		@Valid Login login) {
    	throw new GlobalException(CodeMsg.MOBILE_EMPTY);
        //return Result.success("登陆成功");
    }
    
    /**
     * 发送验证码
     * @param request
     * @param mobileString
     * @return
     */
    @RequestMapping(value = "send_code")
    public Result<?> sendCode(
    		HttpServletRequest request,
    		@RequestParam(name = "mobile", required = true) String mobileString) {
    	boolean rs = userService.sendCode(mobileString);
    	if(rs) {
    		return Result.success("发送成功");
    	} else {
    		return Result.error(CodeMsg.SEND_CODE_FAILED);
    	}
    }
    
    /**
     * 验证短信验证码
     * @param mobileString
     * @param codeString
     * @return
     */
    @RequestMapping(value = "valid_code")
    public boolean validCode(
    		@RequestParam(name = "mobile", required = true) String mobileString,
    		@RequestParam(name = "code", required = true) String codeString) {
    	return userService.validCode(mobileString, codeString);
    }
}
