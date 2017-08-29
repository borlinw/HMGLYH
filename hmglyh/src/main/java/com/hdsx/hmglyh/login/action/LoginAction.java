package com.hdsx.hmglyh.login.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.base.BaseActionSupport;
import com.hdsx.hmglyh.login.bean.LoginUser;
import com.hdsx.hmglyh.login.service.LoginService;
import com.hdsx.hmglyh.util.JsonUtils;
import com.hdsx.hmglyh.util.ResponseUtils;
import com.opensymphony.xwork2.ActionContext;

/**  
 *  Login - Action
 * @author LiRui
 * @created 2015年6月8日 上午10:20:57 
 */
@Controller
public class LoginAction extends BaseActionSupport<LoginUser> {

	private static final long serialVersionUID = 1783031169700716043L;

	@Resource(name="loginServiceImpl")
	private LoginService server;

	@Override
	protected void prepareModel() throws Exception {}

	/**
	 * 登陆
	 */
	public void login(){
		try{
			LoginUser login = server.login(model);
			if(login != null){
				//登陆成功，将用户信息放在Session中
				ActionContext.getContext().getSession().put("loginuser", login);
			//	ActionContext.getContext().getSession()
				HttpServletRequest request = (HttpServletRequest)ActionContext.getContext().get(org.apache.struts2.StrutsStatics.HTTP_REQUEST);
				request.getSession().setMaxInactiveInterval(60*60); //设置session 过期的时间 是 一个小时
				ResponseUtils.write(getResponse(), "{\"state\":true}");
			}else{
				ResponseUtils.write(getResponse(),"{\"state\":false,\"code\":1}");
			}
		}catch(Exception e){
			ResponseUtils.write(getResponse(), "{\"state\":false,\"code\":2}");
			e.printStackTrace();
		}
	}

	/**
	 * 判断用户是否 登陆
	 * @throws Exception
	 */
	public void userLoginAuthor() throws Exception {
		// 从session中获得登录用户信息
		LoginUser user = (LoginUser) ActionContext.getContext().getSession().get("loginuser");
		if(user == null){
			ResponseUtils.write(getResponse(), "{\"state\":false}");
		}else{
			//权限预留
			//user.setPw("***");
			JsonUtils.write(user, getResponse().getWriter());
		}
	}
	
	//退出登陆
	public void logout(){
		HttpSession session = getRequest().getSession(true);
		session.invalidate();
		ResponseUtils.write(getResponse(), "{\"state\":true}");
		//return SUCCESS;
	}

	//修改密码
	public void changePassword(){
		try{
			LoginUser loginUser = (LoginUser) ActionContext.getContext().getSession().get("loginuser");
			if(loginUser.getPw().equals(model.getPw())){
				//再此修改密码
				LoginUser u = new LoginUser();
				u.setUsername(loginUser.getUsername());
				u.setPw(model.getPw());
				u.setNewpw(model.getNewpw());
				if(server.changePassword(u)){
					ResponseUtils.write(getResponse(), "ok");//密码修改成功
				}else{
					ResponseUtils.write(getResponse(), "error");
				}
			}else{
				ResponseUtils.write(getResponse(), "no");//原密码不正确
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
