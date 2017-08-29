package com.hdsx.hmglyh.tj;

import java.io.File;
import java.lang.reflect.Method;

import org.junit.Test;

public class FileTest {
	
	public static String basePath = "D:/hdsx_git/hmglyh/hmglyh/src/main/java/com/hdsx/hmglyh/";
	public static String classPath = "D:/hdsx_git/hmglyh/hmglyh/target/classes";
	public static int count = 0;
	public static String maxClass ;
	public static int maxCount = 0;
	public static String minClass;
	public static int minCount = 2147483647;

	// 统计 一共多少java 文件 
	@Test
	public void fileCount(){
		File f = new File(basePath);
		JavaFilesCount(f);
		System.out.println("一共有" + FileTest.count + "个 java 文件");
	}
	
	@Test
	public void controllerCount(){
		File f = new File(basePath);
		ControllerFilesCount(f);
		System.out.println("一共有" + FileTest.count + "个 Controller");
	}
	
	@Test
	public void serviceCount(){
		File f = new File(basePath);
		ServiceFilesCount(f);
		System.out.println("一共有" + FileTest.count + "个Service");
	}
	
	@Test
	public void beanCount(){
		File f = new File(basePath);
		beanFilesCount(f);
		System.out.println("一共有" + FileTest.count + "个实体");
	}
	
	public static void JavaFilesCount(File f){
		File [] files = f.listFiles();
		for ( File ff : files ) {
			if( ff.isDirectory()) {
				JavaFilesCount(ff);
			}else{
				if( ff.getName().endsWith(".java")){
					System.out.println(ff.getName());
					count += 1;
				}
			}
		}
 	}
	
	public static void ControllerFilesCount(File f){
		File [] files = f.listFiles();
		for ( File ff : files ) {
			if( ff.isDirectory()) {
				ControllerFilesCount(ff);
			}else{
			//	System.out.println(ff.getName().indexOf("Controller"));
				if( ff.getName().indexOf("Controller") > 0 || ff.getName().indexOf("Action") > 0 ){
					System.out.println(ff.getName());
					count += 1;
				}
			}
		}
 	}
	
	public static void ServiceFilesCount(File f){
		File [] files = f.listFiles();
		for ( File ff : files ) {
			if( ff.isDirectory()) {
				ServiceFilesCount(ff);
			}else{
			//	System.out.println(ff.getName().indexOf("Controller"));
				if( ff.getName().indexOf("Service") > 0 ){
					System.out.println(ff.getName());
					count += 1;
				}
			}
		}
 	}
	
	public static void beanFilesCount(File f){
		File [] files = f.listFiles();
		for ( File ff : files ) {
		//	System.out.println(ff.getName());
			if( ff.isDirectory()) {
				beanFilesCount(ff);
			}else{
				if( ff.getName().endsWith(".java") && (ff.getParent().endsWith("bean") || ff.getParent().endsWith("model"))){
					System.out.println(ff.getName());
					count += 1;
				}
			}
		}
 	}
	
	
	@Test
	public void mapperCount(){
		File f = new File(basePath);
		mapperFilesCount(f);
		System.out.println("一共有" + FileTest.count + "个Mapper文件");
	}
	
	
	public static void mapperFilesCount(File f){
		File [] files = f.listFiles();
		for ( File ff : files ) {
		//	System.out.println(ff.getName());
			if( ff.isDirectory()) {
				mapperFilesCount(ff);
			}else{
				if( ff.getName().endsWith(".xml") && ( ff.getName().indexOf("Mapper") > 0 )){
					System.out.println(ff.getName());
					count += 1;
				}
			}
		}
 	}
	
	@Test
	public void methodCount() throws ClassNotFoundException{
		File f = new File(classPath);
		ClassLoader loader = this.getClass().getClassLoader();
		MethodCount(f,loader);
		System.out.println("一共有方法:"+count+"个");
		System.out.println("包含方法最多的类:"+ maxClass+":"+maxCount + "个");
		System.out.println("包含方法最少的类:"+ minClass+":"+minCount + "个");
	}
	
	public static void MethodCount(File f,ClassLoader loader) throws ClassNotFoundException{
		File [] files = f.listFiles();
	
		for ( File ff : files ) {
		//	System.out.println(ff.getName());
			if( ff.isDirectory()) {
				MethodCount(ff,loader);
			}else{
				if((ff.getName().endsWith("class")) && (ff.getName().indexOf("Mapper") > 0) ){
					
					String path = ff.getAbsolutePath();
					int length = "D:/hdsx_git/hmglyh/hmglyh/target/classes/".length();
					path = path.substring(length,path.length() - 6);
					path = path.replaceAll("\\\\", ".");
					Class clazz = loader.loadClass(path);
					Method [] methods = clazz.getDeclaredMethods();
					
					if( methods.length > maxCount ) {
						maxClass = ff.getName();
						maxCount = methods.length;
					}
					
					
					if( methods.length < minCount ) {
						minClass = ff.getName();
						minCount = methods.length;
					}
					
					//count += methods.length;
					for( Method method : methods ) {
						System.out.println(method.getName());
						count += 1;
					}
				}
				
			}
		}
 	}
	
	@Test
	public void classTest() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
	//	InputStream is = null; 
	//	is = ClassLoader.getSystemResourceAsStream("D:/新疆/备份/hmglyh/target/classes/com/hdsx/hmglyh/base/BaseActionSupport.class"); 
	//	ClassLoader.d
	//	System.out.println("==="+this.getClass().getClassLoader());
	//	System.out.println("==="+Thread.currentThread().getContextClassLoader());
		
	//	File file = new File("application.properties");
	//	System.out.println(file.getAbsolutePath());
	//	System.out.println(file.exists());
		
	ClassLoader loader = this.getClass().getClassLoader();
	Class clazz = loader.loadClass("com.hdsx.hmglyh.rcyh.controller.BhController");
	System.out.println(clazz);
	Method[] methods = clazz.getDeclaredMethods();
	for( Method m : methods ) {
		System.out.println(m.getName());
	}
		
	}
	
	
	
}
