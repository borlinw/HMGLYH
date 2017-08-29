package com.hdsx.hmglyh.gis.jichusj.luxian;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.hdsx.hmglyh.gis.jichusj.luxian.dao.GpsmailroadMapper;
import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.Gpsmailroad;
import com.hdsx.hmglyh.gis.util.MapCatchUtil;
import com.hdsx.hmglyh.rcyh.dao.RcyhXdgjbMapper;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhXdgjb;


@RunWith(SpringJUnit4ClassRunner.class) // = extends SpringJUnit4ClassRunner
@TransactionConfiguration(transactionManager = "txManager", defaultRollback = true)  
//@Transactional   // 配置事物
@ContextConfiguration(locations = { "classpath:gis-mybatis-spring.xml"})
public class MyBatisTestForMailRoad {
	
	private static Logger log = LoggerFactory.getLogger(MapCatchUtil.class);
	
//	@Autowired
//	SqlSessionFactory sessionFactory;
	//SqlSessionFactory sessionFactory2;
	
	/*@Test
	public void testSelectRoad(){
		
		
		SqlSession session = sessionFactory.openSession();
		log.info("打开一个session");
		try {
			
			GpsmailroadMapper mapper = session.getMapper(GpsmailroadMapper.class);
			
			Gpsmailroad mailroad = new Gpsmailroad();
			mailroad.setRoadcode("G217");
			
			
			List<Gpsmailroad> listroad = mapper.selectRoadMapInfo(mailroad); 
			log.info("第一次查询 ：" + listroad.size());
			Gpsmailroad mailroad2 = new Gpsmailroad();
			mailroad2.setRoadcode("G217");
			mailroad2.setLdlx("1");
			List<Gpsmailroad> listroad2 = mapper.selectRoadMapInfo(mailroad2); 
			log.info("第二次查询 ：相同条件" + listroad2.size());
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			log.info("将要关闭连接");
			session.close();
		}
		
	}*/
	
	
	
	@Test
	public void testSelectRoad2(){
		
		ApplicationContext context =
				new ClassPathXmlApplicationContext(new String[] {"gis-mybatis-spring.xml"});
		
		SqlSessionFactory sessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory2");
		
		SqlSession session = sessionFactory.openSession();
		log.info("打开一个session");
		try {
			GpsmailroadMapper mapper = session.getMapper(GpsmailroadMapper.class);
			
			Gpsmailroad mailroad = new Gpsmailroad();
			mailroad.setRoadcode("G30");
			List<Gpsmailroad> listroad = mapper.selectRoadMapInfo(mailroad); 
		
			
			SqlSessionFactory sqlSessiontexFactory2 = (SqlSessionFactory) context.getBean("sqlSessionFactory");
			
			SqlSession session2 = sqlSessiontexFactory2.openSession();
			RcyhXdgjbMapper xdgjMapper = session2.getMapper(RcyhXdgjbMapper.class);
			
			RcyhXdgjb xdgj = new RcyhXdgjb();
			xdgj.setStime("2015-08-12 12:21:12");
			xdgj.setEtime("2015-08-12 17:21:12");
			xdgj.setShape(listroad.get(1).getShape());
			xdgj.setXcid(new Date().getTime()+"");
			xdgjMapper.insert(xdgj);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {  
			log.info("将要关闭连接");
			session.close();
		}
		
	}
	
}
