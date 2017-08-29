package com.hdsx.hmglyh.gis.util;

import java.util.ArrayList;
import java.util.List;

/**
 * easyui的分页类
 * @author wusq
 *
 * @param <T>
 */
public class EasyUIPage<T> {

	/**
	 * 总记录数
	 */
	private int total;
	
	/**
	 * 每页数据
	 */
	private List<T> rows = new ArrayList<T>();
	private String dataStr;
	private List<T> rowsOut = new ArrayList<T>();
	private List<T> rowsIn = new ArrayList<T>();
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	public String getDataStr() {
		return dataStr;
	}
	public void setDataStr(String dataStr) {
		this.dataStr = dataStr;
	}
	public List<T> getRowsOut() {
		return rowsOut;
	}
	public void setRowsOut(List<T> rowsOut) {
		this.rowsOut = rowsOut;
	}
	public List<T> getRowsIn() {
		return rowsIn;
	}
	public void setRowsIn(List<T> rowsIn) {
		this.rowsIn = rowsIn;
	}
	
}
