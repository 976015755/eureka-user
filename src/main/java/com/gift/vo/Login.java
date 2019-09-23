package com.gift.vo;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Login {
	@NotNull(message = "手机号不能为空！")
	private String mobile;
}
