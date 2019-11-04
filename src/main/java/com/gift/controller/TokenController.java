package com.gift.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gift.config.ConstantConfig;
import com.gift.utils.RedisUtils;
import com.gift.utils.RegexValidataUtils;

/**
 * 
 * @ClassName: TokenController.java
 * @Description: token控制类
 * @author TOM
 *
 * 2019年11月1日 下午4:00:03
 */
@RestController
@RequestMapping(value = "/token/")
public class TokenController {
	@Autowired
	RedisUtils redisUtils;
	/**
	 * 写入用户登陆token
	 * @param mobileString
	 * @param tokenString
	 * @return
	 */
	@RequestMapping(value = "writeLoginToken")
	public boolean writeLoginToken(
			@RequestParam(name = "mobile", required = true) String mobileString,
			@RequestParam(name = "token", required = true) String tokenString) {
		if(!RegexValidataUtils.validatePass(mobileString) || StringUtils.isBlank(tokenString)) {
			return false;
		}
		boolean rs = false;
		try {
			rs = redisUtils.set(ConstantConfig.REDIS_PRE_TOKEN_STRING + mobileString, tokenString, ConstantConfig.REDIS_TOKEN_EXPIRE_MILL_SECOND_LONG);
		} catch (Exception e) {
			
		}
		return rs;
	}
	
	/**
	 * 清除登陆token
	 * @param mobileString
	 * @return
	 */
	@RequestMapping(value = "cleanLoginToken")
	public boolean cleanLoginToken(
			@RequestParam(name = "mobile", required = true) String mobileString) {
		if(!RegexValidataUtils.validatePhone(mobileString)) {
			return false;
		}
		try {
			redisUtils.remove(ConstantConfig.REDIS_PRE_TOKEN_STRING + mobileString);
		} catch (Exception e) {
		}
		return true;
	}
	
	/**
	 * 检查token是否有效
	 * @param mobileString
	 * @param tokenString
	 * @return
	 */
	@RequestMapping(value = "checkLoginToken")
	public boolean checkLoginToken(
			@RequestParam(name = "mobile", required = true) String mobileString, 
			@RequestParam(name = "token", required = true) String tokenString) {
		if(!RegexValidataUtils.validatePhone(mobileString) || StringUtils.isBlank(tokenString)) {
			return false;
		}
		if(!redisUtils.exists(ConstantConfig.REDIS_PRE_TOKEN_STRING + mobileString)) {
			return false;
		}
		if(redisUtils.get(ConstantConfig.REDIS_PRE_TOKEN_STRING + mobileString).equals(tokenString)) {
			return true;
		}
		return false;
	}
}
