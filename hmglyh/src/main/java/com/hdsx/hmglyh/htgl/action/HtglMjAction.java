package com.hdsx.hmglyh.htgl.action;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.base.BaseActionSupport;
import com.hdsx.hmglyh.htgl.bean.HtglMjlx;
import com.hdsx.hmglyh.htgl.service.HtglMjService;
import com.hdsx.hmglyh.util.Combobox;
import com.hdsx.hmglyh.util.JsonUtils;

/**  
 *  枚举Action
 * @author LiRui
 * @created 2015年6月5日 上午10:26:11 
 */
@Controller
@Scope(value="request")
public class HtglMjAction extends BaseActionSupport<HtglMjlx> {

	private static final long serialVersionUID = 7618261107448397388L;

	@Resource(name="htglMjServiceImpl")
	private HtglMjService server;

	@Override
	protected void prepareModel() throws Exception {}

	/**
	 * 创建枚举类型下拉框
	 */
	public void createCombobox(){
		try{
			String mjTypecodes[] = model.getTypecodeStr().split(",");
			List<Combobox> comboxList = new ArrayList<Combobox>();
			for(int i = 0;i<mjTypecodes.length;i++){
				List<HtglMjlx> mjListOfType = server.queryDateToCreateCombobox(new HtglMjlx(mjTypecodes[i]));
				if(mjListOfType != null && mjListOfType.size()>0){
					for(HtglMjlx mj : mjListOfType){
						Combobox combox = new Combobox(mj.getKey(),mj.getValue());
						comboxList.add(combox);
					}
				}
			}
			JsonUtils.write(comboxList, getResponse().getWriter());
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
