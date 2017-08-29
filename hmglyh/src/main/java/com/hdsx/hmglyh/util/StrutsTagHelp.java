package com.hdsx.hmglyh.util;

import org.junit.Test;


public class StrutsTagHelp {
	
	/**
	 * 判断参数2 是否以 参数 1 开头
	 * @param start
	 * @param source
	 * @return
	 */
	public static boolean isStartWith(String start,String source){
			return source.startsWith(start);
	}
	
	/**
	 * 截取 部门编码
	 * @param bmcode
	 * @return
	 */
	public static String substr(String bmcode){
		return bmcode.substring(0,bmcode.length()-2);
	}
	
	/*@Test
	public void mytest(){
		System.out.println(StrutsTagHelp.isStartWith("aa", "aabbcc"));
	}*/
}
