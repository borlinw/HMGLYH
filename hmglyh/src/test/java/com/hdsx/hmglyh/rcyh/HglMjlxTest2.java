package com.hdsx.hmglyh.rcyh;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.Luxian;
import com.hdsx.hmglyh.rcyh.dao.HtglMjlxMapper;
import com.hdsx.hmglyh.rcyh.dao.model.HtglGljlxb;

 @RunWith(SpringJUnit4ClassRunner.class)
/* @TransactionConfiguration(transactionManager = "transactionManager",defaultRollback = true)
 @Transactional // 配置事物
 @ContextConfiguration(locations = { "classpath:applicationContext.xml" })*/
public class HglMjlxTest2 {
	 public static void main(String[] args) {
		 ApplicationContext context =
					new ClassPathXmlApplicationContext(new String[] {"applicationContext.xml"});
			SqlSessionFactory sf = (SqlSessionFactory) context.getBean("sqlSessionFactory");
			
			SqlSession session = sf.openSession();
			try {
			HtglMjlxMapper luxianMapper = session.getMapper(HtglMjlxMapper.class);
			Luxian lx = new Luxian();
			lx.setLxcode("G217");
			List<HtglGljlxb> luxians = luxianMapper.selectGljclTree();
			
			for( HtglGljlxb lux:luxians) {
				System.out.println(lux.toString());
			}
			
			} finally {
			session.close();
			}
	}
}
