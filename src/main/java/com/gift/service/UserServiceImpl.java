package com.gift.service;

import java.util.Optional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gift.config.ConstantConfig;
import com.gift.entity.User;
import com.gift.exception.GlobalException;
import com.gift.repository.UserRepository;
import com.gift.result.CodeMsg;
import com.gift.utils.MyUtils;
import com.gift.utils.RedisUtils;
import com.gift.utils.RegexValidataUtils;
import com.gift.vo.Login;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	RedisUtils redisUtils;

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

	/**
	 * 发送验证码
	 */
	@Override
	public boolean sendCode(String mobileString) {
		////参数格式判断
		if(!RegexValidataUtils.validatePhone(mobileString)) {//手机号格式错误
    		throw new GlobalException(CodeMsg.MOBILE_REG_ERROR);
    	}
		////查询该手机号是否已经注册
		Optional<User> uinfo = userRepository.findFirstByMobile(mobileString);
		if(uinfo.isPresent()) {
			////TODO 通过短信发送验证码
			
			////发送记录保存到redis
			redisUtils.set(ConstantConfig.REDIS_PRE_SEND_CODE + mobileString, "111111", ConstantConfig.REDIS_CODE_EXPIRE_MILL_SECOND);
			
			////返回发送成功
			return true;
		} else {
			throw new GlobalException(CodeMsg.MOBILE_NOT_REG);
		}
	}
	
	@Override
	public boolean validCode(String mobileString, String codeString) {
		////参数格式判断
		if(!RegexValidataUtils.validatePhone(mobileString)) {
			throw new GlobalException(CodeMsg.MOBILE_REG_ERROR);
		}
		if(!RegexValidataUtils.validatePostCode(codeString)) {
			throw new GlobalException(CodeMsg.CODE_REG_ERROR);
		}
		
		//查询redis里是否有该记录及是否匹配
		String redisCodeString = redisUtils.get(ConstantConfig.REDIS_PRE_SEND_CODE + mobileString).toString();
		if(redisCodeString.equals(codeString)) {
			return true;
		}
		return false;
	}
	
	private String passEncode(String passwordString) {
		if (StringUtils.isBlank(passwordString)) {
			return null;
		} else {
			return MyUtils.md5(MyUtils.md5(passwordString));
		}
	}

}
