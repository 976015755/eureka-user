package com.gift.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Login {
	@NotBlank(message = "手机号不能为空！")
	@Pattern(regexp = "^1\\d{10}$", message = "手机号格式不对！")
	@Size(max = 11, min = 11, message = "字符长度为11位！")
	private String mobile;
	
	@NotBlank(message = "密码不能为空！")
	@Size(min = 6, message = "密码格式错误")
	private String password;
	
	@Size(min = 4, message = "验证码格式错误！")
	private String code;
}
