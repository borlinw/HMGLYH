package com.hdsx.hmglyh.util;

import java.util.Date;
import java.util.HashMap;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hdsx.hmglyh.login.bean.LoginUser;
import com.hdsx.hmglyh.rcyh.dao.RcyhBhjlbMapper;
import com.hdsx.hmglyh.rcyh.dao.model.BhjlAndRwd;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhBhjlb;
import com.hdsx.hmglyh.rcyh.util.RcyhUtils;

public class BhHandler implements TaskListener{
	
	private static Logger log = LoggerFactory.getLogger(BhHandler.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void notify(DelegateTask delegateTask) {
		
		// 使用 name 有可能 改变 ， 直接 使用 key 判断
	/*	String key = delegateTask.getTaskDefinitionKey();
		
		if("binghaijilu".equals(key)) { // 病害记录
		}
		else if( "binghaishangbao".equals(key)) { //  病害上报
		}
		else if( "binghaipaigong".equals(key) ) { // 病害派工
			
		} */
	}
}