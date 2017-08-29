package com.hdsx.hmglyh.htgl.action;

/**  
 *  测试字符串截取
 * @author LiRui
 * @created 2015年6月10日 上午11:30:30 
 */

public class TestSubString {

	public static void main(String[] args) {

		String testStr = "01020304";
		String printStr = testStr.substring(0,testStr.length()-2);
		System.out.println("“"+testStr+"”截取后为："+printStr);

	}

}
