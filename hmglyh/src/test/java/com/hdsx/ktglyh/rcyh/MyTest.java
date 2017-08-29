package com.hdsx.hmglyh.rcyh;

import org.junit.Test;

import com.hdsx.hmglyh.rcyh.base.BaseAction;

public class MyTest extends BaseAction{
	private String test;
	
	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	@Test
	public void myTest() throws SecurityException, NoSuchFieldException{
		MyTest t = new MyTest();
	    System.out.println(BaseAction.class.isAssignableFrom(t.getClass()));	
	}
	
}
