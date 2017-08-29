package com.hdsx.hmglyh.gis.card;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.hdsx.hmglyh.gis.card.util.ExcelToHtml;

public class Test {
	public static void main(String[] args) throws Exception {
		
		String path = "D://fb.xls";

		File sourcefile = new File(path);

		InputStream is = new FileInputStream(sourcefile);
		
		String html = ExcelToHtml.getHtml(is); 
		is.close();
		System.out.println(html);
	}
}
