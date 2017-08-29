package com.hdsx.hmglyh.gis.help;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.junit.Test;

public class MyFileUtils {
	
	@Test
	public void mytest(){
		MyFileUtils.copyFileToDirectoryFile("D:/filetest/a.jpg", "D:/filetest/b.jpg");
	}
	
	public static void copyFileToDirectory(File sF,File dF){
		
		// 验证源文件 是否 存在 
		if( !sF.exists() ){
			throw new RuntimeException("文件源不存在！");
		}
		
		try {

			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sF));
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dF));
			
			byte[] buf = new byte[1024];
			int len = 0;
			while(( len = bis.read(buf)) != -1 ) {
				bos.write(buf, 0, len);
				bos.flush();
			}
			
			bis.close();
			bos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	
	
	public static void copyFileToDirectoryFile(String sf,String df){
		MyFileUtils.copyFileToDirectory(new File(sf), new File(df));
	}
	
	public static void copyFileToDirectoryFile(String sf,File df){
		MyFileUtils.copyFileToDirectory(new File(sf), df);
	}
	
	public static void copyFileToDirectoryFile(File sf,String df){
		MyFileUtils.copyFileToDirectory(sf, new File(df));
	}
	
	@Test
	public void mytest3(){
		System.out.println("010101@010102".indexOf("010101"));
	}
}
