package com.gift.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @ClassName: RegexValidataUtils.java
 * @Description: 数据格式验证
 * @author TOM
 *
 * 2019年10月30日 下午12:06:44
 */
public class RegexValidataUtils {
	private static Pattern p = null;
	private static Matcher m = null;
	private static boolean flg = true;
	
	/**
	 * 验证用户名
	 * @param userName
	 * @return
	 */
	public static boolean validateUserName(String userName) {
		if(userName == null || StringUtils.isBlank(userName)) {
			return false;
		}
		p = Pattern.compile("[a-zA-Z]{1}[a-zA-Z0-9_]{1,5}");
		m = p.matcher(userName);
		flg = m.matches();
		return flg;
	}
 
	/**
	 * 验证密码
	 * @param pass
	 * @return
	 */
	public static boolean validatePass(String pass) {
		if(pass == null || StringUtils.isBlank(pass)) {
			return false;
		}
		p = Pattern.compile("[a-zA-Z0-9_.]{6,16}");
		m = p.matcher(pass);
		flg = m.matches();
		return flg;
	}
 
	/**
	 * 验证昵称
	 * @param nickName
	 * @return
	 */
	public static boolean validateNickName(String nickName) {
		if(nickName == null || StringUtils.isBlank(nickName)) {
			return false;
		}
        p = Pattern.compile("[[\u4e00-\u9fa5]+[a-zA-Z0-9_]+]{1,6}");
        m = p.matcher(nickName);
        flg = m.matches();
		return flg;
	}
	
	/**
	 * 验证手机号
	 * @param phone
	 * @return
	 */
	public static boolean validatePhone(String phone){
		if(phone == null || StringUtils.isBlank(phone)) {
			return false;
		}
		p = Pattern.compile("1[0-9]{10}");
        m = p.matcher(phone);
        flg = m.matches();
        return flg;
	}
	
	/**
	 * 验证验证码
	 * @param postCode
	 * @return
	 */
	public static boolean validatePostCode(String postCode){
		if(postCode == null || StringUtils.isBlank(postCode)) {
			return false;
		}
		p = Pattern.compile("[0-9]{6}");
        m = p.matcher(postCode);
        flg = m.matches();
        return flg;
	}
	
	/**
	 * 验证邮箱
	 * @param email
	 * @return
	 */
	public static boolean validateEmail(String email){
		if(email == null || StringUtils.isBlank(email)) {
			return false;
		}
		p = Pattern.compile("[a-zA-Z0-9]+[@]{1}[a-zA-Z0-9]+[.][a-z]+");
        m = p.matcher(email);
        flg = m.matches();
        return flg;
	}
}
