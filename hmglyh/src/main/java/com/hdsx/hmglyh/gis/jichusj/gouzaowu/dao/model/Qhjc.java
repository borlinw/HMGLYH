package com.hdsx.hmglyh.gis.jichusj.gouzaowu.dao.model;

import java.util.Date;

/**  
 *  
 * @author Baiyy
 * @created 2017年9月4日 下午11:29:14 
 */

public class Qhjc {
	
	private String qlcode;				//桥梁编码
	
	private String hdcode;				//撼动编码
	
	private int page;					//查询用，页数
			
	private int rows;					//查询用，每页显示行数
	
	private String fzr;					//负责人
	
	private String jlr;					//记录人
	
	private Date jcsj;					//检查时间


	public String getFzr() {
		return fzr;
	}

	public void setFzr(String fzr) {
		this.fzr = fzr;
	}

	public String getJlr() {
		return jlr;
	}

	public void setJlr(String jlr) {
		this.jlr = jlr;
	}

	public Date getJcsj() {
		return jcsj;
	}

	public void setJcsj(Date jcsj) {
		this.jcsj = jcsj;
	}

	public String getQlcode() {
		return qlcode;
	}

	public void setQlcode(String qlcode) {
		this.qlcode = qlcode;
	}

	public String getHdcode() {
		return hdcode;
	}

	public void setHdcode(String hdcode) {
		this.hdcode = hdcode;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}
	
	
}
