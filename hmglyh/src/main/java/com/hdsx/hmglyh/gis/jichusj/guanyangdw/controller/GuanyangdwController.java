package com.hdsx.hmglyh.gis.jichusj.guanyangdw.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.gis.jichusj.guanyangdw.dao.HtglBmbMapper;
import com.hdsx.hmglyh.gis.jichusj.guanyangdw.dao.model.HtglBmb;
import com.hdsx.hmglyh.gis.jichusj.guanyangdw.service.BumenService;
import com.hdsx.hmglyh.rcyh.base.BaseAction;
import com.hdsx.hmglyh.util.Combotree;
import com.hdsx.hmglyh.util.JsonUtils;
import com.hdsx.hmglyh.util.SpringContextUtil;

@Controller
@Scope("request")
public class GuanyangdwController extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7229833784349237784L;
	
	@Autowired
	private BumenService bumenService;
	private HtglBmb bm;
	
	public HtglBmb getBm() {
		return bm;
	}

	public void setBm(HtglBmb bm) {
		this.bm = bm;
	}

	public String index(){
		return "jc_index";
	}
	
	public String guanyangdw(){
		return "jc_guanyangdw";
	}
	
	public void guanyangdwRows(){
		try {
			HtglBmb rows = bumenService.bumenRows(bm);
			rows.setState("open");
			List<HtglBmb> list = new ArrayList<HtglBmb>();
			list.add(rows);
			for(HtglBmb hb : rows.getChildren()) {
				if( hb.getChildren() != null && hb.getChildren().size() > 0) {
					hb.setState("closed");;
				}
			}
			JsonUtils.write(list, ServletActionContext.getResponse().getWriter());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 部门树
	 * @throws IOException
	 * @throws Except
	 */
	public void bmtree() throws IOException, Exception{
		List<Combotree> list = new ArrayList<Combotree>();
		com.hdsx.hmglyh.gis.jichusj.guanyangdw.dao.HtglBmbMapper bmMapper = (com.hdsx.hmglyh.gis.jichusj.guanyangdw.dao.HtglBmbMapper) SpringContextUtil.getBean("htglBmbMapper");
		System.out.println(bmMapper);
		list.add(bmMapper.selectBmCombotree(getUser().getBmcode()));
		JsonUtils.write(list, getResponse().getWriter());
	}
	
}
