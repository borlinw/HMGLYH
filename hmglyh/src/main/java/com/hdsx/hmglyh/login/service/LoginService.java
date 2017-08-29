package com.hdsx.hmglyh.login.service;

import com.hdsx.hmglyh.login.bean.LoginUser;

/**  
 *  Login - Service
 * @author LiRui
 * @created 2015年6月8日 上午10:15:33 
 */

public interface LoginService {

	/**
	 * 用户登录
	 */
	public LoginUser login(LoginUser loginuser);

	/**
	 * 修改密码
	 */
	boolean changePassword(LoginUser loginuser);

}
