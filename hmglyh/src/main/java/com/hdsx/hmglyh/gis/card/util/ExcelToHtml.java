package com.hdsx.hmglyh.gis.card.util;

import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelToHtml {
	public static String getHtml(InputStream is) throws Exception{
		Workbook wb = WorkbookFactory.create(is);
		if (wb instanceof XSSFWorkbook) {
			XSSFWorkbook xWb = (XSSFWorkbook) wb;
			return POIReadExcelToHtml07.getExcelToHtml(xWb);
		}else if(wb instanceof HSSFWorkbook){
			HSSFWorkbook hWb = (HSSFWorkbook) wb;
			return POIReadExcelToHtml03.getHtmlExcel(hWb);
		}
		return null;
	}
}
