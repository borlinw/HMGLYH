package com.hdsx.hmglyh.htgl.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.login.bean.Auth;
import com.hdsx.hmglyh.rcyh.base.BaseAction;

/**  
 *  后台权限管理 - home.jsp的权限控制（未应用）
 * @author LiRui
 * @created 2015年7月9日 上午9:26:09 
 */
@Controller
@Scope(value="request")
public class HomeAction extends BaseAction {

	private static final long serialVersionUID = 7400685134401743893L;

	//权限列表
	private List<Auth> menus = new ArrayList<Auth>();
	
	public List<Auth> getMenus() {
		return menus;
	}

	public void setMenus(List<Auth> menus) {
		this.menus = menus;
	}

	/**
	 * 跳转至htgl/index.jsp
	 */
	public String index(){
		for( Auth auth : getUser().getRole().getAuths() ) {
			if( auth.getMkid().startsWith("04") && auth.getMkid().length() == 4 ) {
				menus.add(auth);
			}
		}
		return "index";
	}

}
