package com.hdsx.hmglyh.util;

import java.text.DecimalFormat;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class DoubleConvert extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		//System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>调用类型转换");
	//	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>" + toClass);
		if (Double.class == toClass) {
			String integerStr = values[0];
		//	System.out.println("获取到的字符串" + integerStr);
		
			Double d = new Double(-1);
			
			if(!"null".equals(integerStr)){
				d = Double.parseDouble(integerStr);
			}
			return d;
		}
		return -1;
	}

	@Override
	public String convertToString(Map context, Object o) {
//		System.out.println(">>>>>>>>>>>>>>>>>>value  " + o);
//		System.out.println("value instanceof Double  " + (o instanceof Double));
		DecimalFormat df = new DecimalFormat("######0.000");   
		if( o != null ) {
			return df.format(Double.parseDouble(o.toString()));
		}else{
			return "0.000";
		}
		
	}

}
