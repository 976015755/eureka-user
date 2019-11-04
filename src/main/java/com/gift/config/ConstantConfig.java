package com.gift.config;

import lombok.Data;

@Data
public class ConstantConfig {
	public final static String REDIS_PRE_SEND_CODE = "redis_pre_send_code_"; 
	public final static Long REDIS_CODE_EXPIRE_MILL_SECOND = 600L;
	public final static String REDIS_PRE_TOKEN_STRING = "redis_pre_token_";
	public final static Long REDIS_TOKEN_EXPIRE_MILL_SECOND_LONG = 3600000L;
}
