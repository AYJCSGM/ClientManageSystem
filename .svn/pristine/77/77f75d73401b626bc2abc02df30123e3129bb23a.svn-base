package com.java1234.util;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 加密工具
 * @author Administrator
 *
 */
public class CryptographyUtil {
	
	public static void main(String[] args) throws Exception {
	 System.out.println(md5("1","chenhao"));
	}
	
	
	/**
	 * Md5加密
	 * @param str  加密的内容
	 * @param salt  盐值 
	 */
	public static String md5(String str,String salt){
		return new Md5Hash(str,salt).toString();
	}
	
	
	
	
}
