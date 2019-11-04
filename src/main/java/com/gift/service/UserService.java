package com.gift.service;

import com.gift.vo.Login;

public interface UserService {
	public String login(Login loginVo);
	public boolean sendCode(String mobileString);
	public boolean validCode(String mobileString, String codeString);
}
