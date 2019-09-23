package com.gift.result;

import lombok.Data;

@Data
public class Result<T> {
	private int code;
	private String codeMsg;
	private T data;
	
	public static <T> Result<T> success(T data) {
		return new Result<T>(data);
	}
	
	public Result(T data) {
		this.data = data;
	}
}
