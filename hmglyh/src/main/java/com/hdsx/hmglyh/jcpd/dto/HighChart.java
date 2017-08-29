
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.dto;

import java.io.Serializable;
import java.util.List;

/**  
 *  
 * @author Baiyy
 * @created 2015年7月6日 下午2:00:26 
 */

public class HighChart implements Serializable {
	private static final long serialVersionUID = 3085022954924523971L;
	
	private List<String> categories;
	private double[] pci;
	private double[] iri;
	
	
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
	public double[] getPci() {
		return pci;
	}
	public void setPci(double[] pci) {
		this.pci = pci;
	}
	public double[] getIri() {
		return iri;
	}
	public void setIri(double[] iri) {
		this.iri = iri;
	}
	
	

}
