package com.gift.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gift.vo.Login;

@RestController
@RequestMapping(value = "/user/")
public class UserController {
    @RequestMapping(value = "login")
    public String login(
    		@RequestParam(value = "name", defaultValue = "") String name, 
    		HttpServletRequest request, 
    		@Valid Login login) {
        return name + "登陆" + request.getRequestURL();
    }

}
