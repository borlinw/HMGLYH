package com.hdsx.hmglyh.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.login.bean.Auth;
import com.hdsx.hmglyh.login.bean.LoginUser;
import com.hdsx.hmglyh.login.mapper.LoginMapper;
import com.hdsx.hmglyh.login.service.LoginService;

/**  
 *  Login-ServiceImpl
 * @author LiRui
 * @created 2015年6月8日 上午10:18:35 
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Resource(name="loginMapper")
	private LoginMapper mapper;

	@Override
	public LoginUser login(LoginUser loginuser) {
		// 拼接 权限 字符串
		LoginUser user = mapper.longin(loginuser);
		if( user != null ) {
			StringBuilder sb = new StringBuilder();
			for( Auth a : user.getRole().getAuths()) {
				sb.append(a.getMkid() + "@");
			}
			user.setRoleStr(sb.toString());
		}
		//auth.getMkid().startsWith("04")
		return user;
	}

	@Override
	public boolean changePassword(LoginUser loginuser) {
		if(mapper.changePassword(loginuser)>0){
			return true;
		}else{
			return false;
		}
	}

}
