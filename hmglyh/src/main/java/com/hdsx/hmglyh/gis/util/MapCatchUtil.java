package com.hdsx.hmglyh.gis.util;

import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hdsx.hmglyh.gis.jichusj.luxian.dao.GpsmailroadMapper;
import com.hdsx.hmglyh.gis.jichusj.luxian.dao.model.Gpsmailroad;
import com.hdsx.hmglyh.rcyh.dao.HtglMjlxMapper;
import com.hdsx.hmglyh.rcyh.dao.RcyhXdgjbMapper;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhXdgjb;
import com.hdsx.hmglyh.util.SpringContextUtil;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.LineString;
import com.vividsolutions.jts.io.WKBReader;

public class MapCatchUtil {
	
	
	private static Logger log = LoggerFactory.getLogger(MapCatchUtil.class);
	public static SqlSessionFactory sqlSessionFactory;
	public static SqlSessionFactory sqlSessionFactory2;
	
	public static HashMap<String,Object> MAPCATCH = new HashMap<String,Object>();
	public static HashMap<String,Object> XDJLSHAPE = new HashMap<String,Object>();
	
	// 初始化
	static {
		ApplicationContext context =
				new ClassPathXmlApplicationContext(new String[] {"gis-mybatis-spring.xml"});
		sqlSessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
		sqlSessionFactory2 = (SqlSessionFactory) context.getBean("sqlSessionFactory2");
	}
	
	// TODO 可使用ECACHE 进一步 优化 效率
	// 通过路线编码 得到 路线 的shape 字段 第一次 从数据库中读取， 第二次 从 缓存中读取
	public static HashMap<String,Object> getRoadShapeByRoadCode(Gpsmailroad mailroad) {
		
			String roadcode = mailroad.getRoadcode();
			
			if(roadcode.equals("S236")){
				roadcode = "G575";
			}else if(roadcode.equals("S332")){
				roadcode = "G331";
			}
			
			mailroad.setRoadcode(roadcode);
			
			
			char c = roadcode.charAt(0);
			if(Character.isDigit(c)){
				roadcode = getRoadcodeByld(roadcode);
				if(roadcode.equals("S236")){
					roadcode = "G575";
				}else if(roadcode.equals("S332")){
					roadcode = "G331";
				}
				mailroad.setRoadcode(roadcode);
			}
			
			HashMap<String,Object> roadmap = null;
			
			if(StringUtils.isNotBlank(mailroad.getLdlx())){
				roadmap = (HashMap<String, Object>) MAPCATCH.get(roadcode+"_"+mailroad.getLdlx());
			}else{
				roadmap = (HashMap<String, Object>) MAPCATCH.get(roadcode);
			}
			
		
			if( roadmap != null ) {
				return roadmap;
			}
			
			SqlSession sqlSession = sqlSessionFactory2.openSession();
			if( sqlSession != null ) {
				log.info("成功打开session");
			}else{
				log.error("打开session 失败！");
				return null;
			}
			
			try {
				
				GpsmailroadMapper roadmapper = sqlSession.getMapper(GpsmailroadMapper.class);
				
				List<Gpsmailroad> list = roadmapper.selectRoadMapInfo(mailroad);
				
				HashMap<String,Object> m = new HashMap<String, Object>();
				StringBuilder sb = new StringBuilder();
				int i = 0 ; 
				m.put("roadcode", mailroad.getRoadcode());
				for( Gpsmailroad gml : list ) {
					
					if( i == 0 ) {
						m.put("startzh",gml.getStartzh());
					}
				
					if( i == list.size() - 1 ) {
						m.put("endzh", gml.getEndzh());
					}
									
					// 将 二进制shape 字段信息 转换为字符串
					
					PolygonTransfor pt = new PolygonTransfor();
					String s = "";
					LineString p = pt.trans2Polyline(gml.getShape());
			
					s = p.toString();
					sb.append(","+s.substring(12,s.length()-1));
					i++;
				}
				m.put("shape", sb.toString().substring(1));
				
				if( StringUtils.isNotBlank(mailroad.getLdlx())) {
					MAPCATCH.put(mailroad.getRoadcode()+"_"+mailroad.getLdlx(), m);
				}else{
					MAPCATCH.put(mailroad.getRoadcode(), m);
				}
			
				
				log.debug("MAPCATCH中合成了"+mailroad.getRoadcode()+"shape信息");
				
				return m;
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally{
				sqlSession.close();
				log.info("关闭了session");
			}
			
			return null;
	}
	
	public static List<Gpsmailroad> queryGqlmailroad(Gpsmailroad mailroad){
		SqlSession sqlSession = sqlSessionFactory2.openSession();
		if( sqlSession != null ) {
			log.info("成功打开session");
		}else{
			log.error("打开session 失败！");
			return null;
		}
		try {
			GpsmailroadMapper roadmapper = sqlSession.getMapper(GpsmailroadMapper.class);
			List<Gpsmailroad> list = roadmapper.selectRoadByCondition(mailroad);
			for( Gpsmailroad gml : list ) {
				// 将 二进制shape 字段信息 转换为字符串
				if( gml.getShape() != null ) {
					PolygonTransfor pt = new PolygonTransfor();
					String s = "";
					LineString p = pt.trans2Polyline(gml.getShape());
					s = p.toString();
					gml.setShapeStr(s.substring(12,s.length()-1));
					gml.setShape(null);
				}
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			sqlSession.close();
			log.info("关闭了session");
		}
		return null;
	}
	
	public static HashMap<String,Object> getXdjlShapeByXcid(String xcid){
		
		HashMap<String,Object> xcjlMap = (HashMap<String, Object>) XDJLSHAPE.get(xcid);
		
		if( xcjlMap != null ) {
			return xcjlMap;
		}
		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		if( sqlSession != null ) {
			log.info("成功打开 业务库  session");
		}else{
			log.error("打开 业务库  session 失败！");
			return null;
		}
		
		try {
			
			RcyhXdgjbMapper xdgjMapper = sqlSession.getMapper(RcyhXdgjbMapper.class);
			RcyhXdgjb xdgj = xdgjMapper.selectByPrimaryKey(xcid);
			StringBuilder sb = new StringBuilder();
			if( xdgj == null ) {
				return null;
			}
			
			PolygonTransfor pt = new PolygonTransfor();
			String s = "";
			
			byte[] b = xdgj.getShape();
			WKBReader reader = new WKBReader();
            Geometry g1 = reader.read(b);
            if(g1 instanceof LineString)
            {
                LineString line=(LineString)g1;
              /*  for(int i=0;i<line.getNumPoints();i++)
                {
                	Coordinate c = line.getCoordinateN(i);
                }*/
                
    			s = line.toString();
    			s= s.substring(12,s.length()-1);
    			xcjlMap = new HashMap<String,Object>();
    			xcjlMap.put("shape", s);
    			xcjlMap.put("xcid", xcid);
    			xcjlMap.put("stime", xdgj.getStime());
    			xcjlMap.put("etime", xdgj.getEtime());
    			XDJLSHAPE.put(xcid,xcjlMap);
            }
			
//			LineString p = pt.trans2Polyline(xdgj.getShape());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return xcjlMap;
	}

	public static HashMap<String,Object> getTestLine(Gpsmailroad gmr){
	
		SqlSession sqlSession = sqlSessionFactory2.openSession();
		if( sqlSession != null ) {
			log.info("成功打开 业务库  session");
		}else{
			log.error("打开 业务库  session 失败！");
			return null;
		}
		HashMap<String,Object> xcjlMap = new HashMap<String,Object>();
		try {
			GpsmailroadMapper roadMapper = sqlSession.getMapper(GpsmailroadMapper.class);
			List<Gpsmailroad> roads = roadMapper.selectRoadByCondition(gmr);
			PolygonTransfor pt = new PolygonTransfor();
			String s = "";
			LineString p = pt.trans2Polyline(roads.get(0).getShape());
			s = p.toString();
			s= s.substring(12,s.length()-1);
			xcjlMap.put("shape", s);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xcjlMap;
	}
	
	
	
	/**
	 * 将路段编码转换为路线编码
	 * @param roadcode
	 * @return
	 */
	public static String getRoadcodeByld(String roadcode) {
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil.getBean("htglMjlxMapper");
		return mjlxMapper.getLxcodeByld(roadcode);
	}
	
	/**
	 * 将路段编码转换为路线编码
	 * @param roadcode
	 * @return
	 */
	public static String getRoadcodeBylsld(String roadcode) {
		HtglMjlxMapper mjlxMapper = (HtglMjlxMapper) SpringContextUtil.getBean("htglMjlxMapper");
		return mjlxMapper.getLxcodeBylsld(roadcode);
	}
}
