package com.hdsx.hmglyh.util;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

public class IntegerConvert extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map context, String[] values, Class toClass) {
		//System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>调用类型转换");
	//	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>" + toClass);
		if (Integer.class == toClass) {
			String integerStr = values[0];
		//	System.out.println("获取到的字符串" + integerStr);
		
			Integer d = new Integer(-1);
			
			if(!"null".equals(integerStr) && !"".equals(integerStr)){
				d = Integer.parseInt(integerStr);
				return d;
			}else{
				return d;
			}
		}
		return -1;
	}

	@Override
	public String convertToString(Map context, Object o) {
		if( -1 == Integer.parseInt(o.toString())) {
			return "";
		}else{
			return o.toString();
		}
	}

}
