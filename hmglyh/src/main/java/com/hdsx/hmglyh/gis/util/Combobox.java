package com.hdsx.hmglyh.gis.util;

public class Combobox {
	
	private String text;
	private String value;
	private String valueField;
	private String textField;
	private boolean selected;
	
	private String q; // combobox 查询条件
	
	
	
	public String getValueField() {
		return valueField;
	}
	public void setValueField(String valueField) {
		this.valueField = valueField;
	}
	public String getTextField() {
		return textField;
	}
	public void setTextField(String textField) {
		this.textField = textField;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getQ() {
		return q;
	}
	public void setQ(String q) {
		this.q = q;
	}
	private double szhh;
	private double ezhh;

	public double getSzhh() {
		return szhh;
	}
	public void setSzhh(double szhh) {
		this.szhh = szhh;
	}
	public double getEzhh() {
		return ezhh;
	}
	public void setEzhh(double ezhh) {
		this.ezhh = ezhh;
	}
	
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
}
