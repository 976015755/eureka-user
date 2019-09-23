package com.gift.result;

import lombok.Data;

/**
 * 错误码
 * @author TOM
 *
 */
@Data
public class CodeMsg {
	private int code;
	private String msg;
	
	public static CodeMsg SUCCESS = new CodeMsg(0, "成功");
	//登陆模块
	public static CodeMsg MOBILE_EMPTY = new CodeMsg(500100, "手机号不能为空");
	
	
	private CodeMsg() {}
	private CodeMsg(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
}
