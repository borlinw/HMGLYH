package com.hdsx.hmglyh.login.mapper;

import com.hdsx.hmglyh.dao.Mapper;
import com.hdsx.hmglyh.login.bean.LoginUser;

/**  
 *  Login Mapper
 * @author LiRui
 * @created 2015年6月8日 上午10:06:58 
 */
@Mapper
public interface LoginMapper {

	/**
	 * 登陆
	 * @param loginuser（Username，pw）
	 * @return
	 */
	public LoginUser longin(LoginUser loginuser);

	/**
	 * 修改密码
	 */
	public int changePassword(LoginUser loginuser);

}
