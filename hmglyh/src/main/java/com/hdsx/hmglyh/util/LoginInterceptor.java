package com.hdsx.hmglyh.util;

import java.lang.reflect.Method;

import org.apache.struts2.ServletActionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hdsx.hmglyh.login.bean.LoginUser;
import com.hdsx.hmglyh.rcyh.base.BaseAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 * struts2 拦截器  
 * 判断session 中是否 有用户信息 ， 如果 有 放行， 如果没有 ， 直接 跳转到 首页 登陆页面
 * 目前只拦截 日常养护 和 GIS 系统中的方法 。 其他 模块放行。
 * @author zhanglm
 */
public class LoginInterceptor extends MethodFilterInterceptor {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6156030245667019299L;

	private static Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
	
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		
		// 登陆 校验
		LoginUser user = (LoginUser) invocation.getInvocationContext().getSession().get("loginuser");
		
		if( user == null ) { // 此时 用户 没有登陆
		//	log.info("未知用户非法访问：" + invocation.getProxy().getMethod() + "方法，将强制跳转到登陆页面");
			return "loginPage";
		}else{
			
			// 权限校验
			
			//获取请求的action对象
			Object action = invocation.getAction();
			//获取请求的方法的名称
			String methodName = invocation.getProxy().getMethod();
			//获取action中的方法的封装类(action中的方法没有参数)
			Method method = action.getClass().getMethod(methodName, null);
			Object rtype = method.getReturnType();
			
			boolean isAuth = checkAuth(user,method);
			boolean isAjax = false;
			if(rtype.toString().equals("void")){
				isAjax = true;
			}
			
			if(!isAuth) {
				log.info(user.getUsername() + "访问：" + invocation.getProxy().getMethod() + "方法，但是他不具备此权限，已经跳转到错误页面");
				return "authErrorPage";
			}
			
			try {
				if(	BaseAction.class.isAssignableFrom(invocation.getAction().getClass())) {
					BaseAction ba = (BaseAction) invocation.getAction();
					ba.setResultname("SUCCESS");
					ba.setResultpage(invocation.getProxy().getMethod());
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			String resultStr = "";
			try {
				resultStr = invocation.invoke();
			} catch (Exception e) {
				e.printStackTrace();
				// 发生异常的时候 区分 返回类型 是 受否json 类型的 
				if(	BaseAction.class.isAssignableFrom(invocation.getAction().getClass())) {
					
					BaseAction ba = (BaseAction) invocation.getAction();
					if(isAjax) { // 返回Ajax的 方式
						ba.getGmap().put(Constants.ISERROR, true);
						ba.getGmap().put(Constants.INFO, e.toString());
						JsonUtils.write(ba.getGmap(), ServletActionContext.getResponse().getWriter());
						return null;
					}else{
						ba.getGmap().put(Constants.INFO, e.toString());
						resultStr = BaseAction.exception ;
					}
				}else{
					resultStr = "exceptionPage";
				}
			}
			
			return resultStr;
		}
		
	}
	
	public boolean checkAuth(LoginUser user,Method method){
		if( method == null || user == null)  {
			return false;
		}
		
		/**
		 *  controller 方法 是否 扛了 注解 
		 *  在这里 如果 扛了注解 表示 该方法 加入了权限 控制  
		 *  如果没有 暂时 放行 
		 */
		boolean isAnnotationPresent = method.isAnnotationPresent(AnnotationAuth.class);
		//不存在注解
		if(!isAnnotationPresent){
			//TODO 有待商量
			return true;
		}
		
		AnnotationAuth auth = method.getAnnotation(AnnotationAuth.class);
		
		String mkid = auth.mkid();
		
		if(user.getRoleStr().indexOf(mkid) == -1 ) { // 不具备此权限
			return false;
		}else{
			return true;
		}
	}

}
