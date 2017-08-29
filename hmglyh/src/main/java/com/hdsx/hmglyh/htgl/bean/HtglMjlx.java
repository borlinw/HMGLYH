package com.hdsx.hmglyh.htgl.bean;

import java.io.Serializable;

/**  
 *  后台管理 - 枚举类型实体
 * @author LiRui
 * @created 2015年6月5日 上午9:57:13 
 */

public class HtglMjlx implements Serializable {

	private static final long serialVersionUID = 2658739043837309287L;

	private String type;			//类型中文名
	private String typecode;	//类型编码
	private String key;				//枚举值编码
	private String value;			//枚举值
	private String typecodeStr;		//待查询枚举类型（01,02,03）可以查询多种枚举类型

	public HtglMjlx() {
		super();
	}

	public HtglMjlx(String typecode) {
		super();
		this.typecode = typecode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTypecode() {
		return typecode;
	}
	public void setTypecode(String typecode) {
		this.typecode = typecode;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getTypecodeStr() {
		return typecodeStr;
	}
	public void setTypecodeStr(String typecodeStr) {
		this.typecodeStr = typecodeStr;
	}

}
