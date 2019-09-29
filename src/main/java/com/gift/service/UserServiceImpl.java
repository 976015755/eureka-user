package com.gift.service;

import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gift.entity.User;
import com.gift.exception.GlobalException;
import com.gift.repository.UserRepository;
import com.gift.result.CodeMsg;
import com.gift.utils.MyUtils;
import com.gift.vo.Login;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;

	@Override
	public String login(Login loginVo) {
		if (StringUtils.isBlank(loginVo.getMobile())) {
			throw new GlobalException(CodeMsg.MOBILE_EMPTY);
		}

		if (StringUtils.isBlank(loginVo.getPassword())) {
			throw new GlobalException(CodeMsg.PASS_EMPTY);
		}

		Optional<User> uinfo = userRepository.findFirstByUsername(loginVo.getMobile());
		uinfo.ifPresent(u->{//能查到这个手机号
			if(u.getPassword().equals(passEncode(loginVo.getPassword()))) {//手机号对应的密码正确
				//记录token
				
				//返回token
			} else {
				throw new GlobalException(CodeMsg.USER_OR_PASS_ERR);
			}
		});
		throw new GlobalException(CodeMsg.USER_OR_PASS_ERR);
	}

	private String passEncode(String passwordString) {
		if (StringUtils.isBlank(passwordString)) {
			return null;
		} else {
			return MyUtils.md5(MyUtils.md5(passwordString));
		}
	}

}
