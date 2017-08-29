package com.hdsx.hmglyh.gis.jichusj.luxian;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.hdsx.hmglyh.rcyh.dao.RcyhXdgjbMapper;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhXdgjb;


@RunWith(SpringJUnit4ClassRunner.class) // = extends SpringJUnit4ClassRunner
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)  
//@Transactional   // 配置事物
@ContextConfiguration(locations = { "classpath:rcyh-mybatis-spring.xml"})
public class MyBatisTest {
	
	@Autowired
	SqlSessionFactory sqlSessionFactory2;
	
	// 数据源1  业务 数据库
	public static void main(String[] args) throws Exception {
		ApplicationContext context =
				new ClassPathXmlApplicationContext(new String[] {"rcyh-mybatis-spring.xml"});
		SqlSessionFactory sf = (SqlSessionFactory) context.getBean("sqlSessionFactory");
		
		SqlSession session = sf.openSession();
		try {
			RcyhXdgjbMapper gpsroadMapper = session.getMapper(RcyhXdgjbMapper.class);
			HashMap<String,Object> param = new HashMap<String,Object>();
			param.put("xcid", "61fedc87-079e-4fa6-8e00-90e4612baff7");
			RcyhXdgjb xdgj = gpsroadMapper.selectByPrimaryKey("61fedc87-079e-4fa6-8e00-90e4612baff7");
			System.out.println(xdgj);
			File f = new File("E://test");
			if(!f.exists()){
				f.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(xdgj.getShape(), 0, xdgj.getShape().length);
			fos.close();
		
		} finally {
		session.close();
		}
		
	}
	
	@Test
	public void selectRoadMapInfo(){
		SqlSession session = sqlSessionFactory2.openSession();
		RcyhXdgjbMapper gpsroadMapper = session.getMapper(RcyhXdgjbMapper.class);
		HashMap<String,Object> param = new HashMap<String,Object>();
		param.put("xcid", "61fedc87-079e-4fa6-8e00-90e4612baff7");
		RcyhXdgjb xdgj = gpsroadMapper.selectByPrimaryKey("61fedc87-079e-4fa6-8e00-90e4612baff7");
		System.out.println(xdgj);
	}
}
