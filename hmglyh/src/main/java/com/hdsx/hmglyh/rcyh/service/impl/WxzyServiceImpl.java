
package com.hdsx.hmglyh.rcyh.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.gis.jichusj.guanyangdw.dao.HtglBmbMapper;
import com.hdsx.hmglyh.gis.jichusj.guanyangdw.dao.model.HtglBmb;
import com.hdsx.hmglyh.rcyh.dao.HtglMjlxMapper;
import com.hdsx.hmglyh.rcyh.dao.RcyhBhjlbMapper;
import com.hdsx.hmglyh.rcyh.dao.RcyhRwdjlbMapper;
import com.hdsx.hmglyh.rcyh.dao.RcyhWxzyjlbMapper;
import com.hdsx.hmglyh.rcyh.dao.RcyhZyysjlbMapper;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhBhjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhCljxxhb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhRwdjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhRyzyjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhWxzyjlb;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhZyysjlb;
import com.hdsx.hmglyh.rcyh.dao.model.ZP;
import com.hdsx.hmglyh.rcyh.service.WorkFlowService;
import com.hdsx.hmglyh.rcyh.service.WxzyService;
import com.hdsx.hmglyh.rcyh.util.RcyhUtils;
import com.hdsx.hmglyh.util.Constants;
import com.hdsx.hmglyh.util.SpringContextUtil;

@Service
@Transactional
public class WxzyServiceImpl implements WxzyService {
	private static Logger log = LoggerFactory.getLogger(WxzyServiceImpl.class);

	@Autowired
	private RcyhBhjlbMapper bhjlMapper;
	@Autowired
	private RcyhRwdjlbMapper rwdMapper;
	@Autowired
	private RcyhWxzyjlbMapper wxzyMapper;
	@Autowired
	private WorkFlowService wfService;
	@Autowired
	private HtglMjlxMapper mjlxMapper;
	
	@Autowired
	private HtglBmbMapper bmMapper;
	
	@Override
	public List<RcyhRwdjlb> listRwd(RcyhRwdjlb rwd) {
		return rwdMapper.listRwd(rwd);
	}

	@Override
	public int listRwdCount(RcyhRwdjlb rwd) {
		return rwdMapper.listRwdCount(rwd);
	}

	@Override
	public RcyhRwdjlb queryRwdByKey(String rwdid) {
		return rwdMapper.selectByPrimaryKey(rwdid);
	}

	@Override
	public List<RcyhWxzyjlb> listWxzy(RcyhWxzyjlb wxzy) {
		return wxzyMapper.listWxzy(wxzy);
	}

	@Override
	public int listWxzyCount(RcyhWxzyjlb wxzy) {
		return wxzyMapper.listWxzyCount(wxzy);
	}

	@Override
	public RcyhWxzyjlb queryWxzyByKey(String zyid) {
		return wxzyMapper.selectByPrimaryKey(zyid);
	}

	@Override
	public List<RcyhWxzyjlb> listWxzyHz(RcyhWxzyjlb wxzy) {
		
		HtglBmb bm = bmMapper.selectBmbByBmcode(wxzy.getBmcode());
		
		if( 0 == bm.getSftsbm() ) {
			return wxzyMapper.listWxzyHz(wxzy);
		}else{
			return wxzyMapper.listTsbmWxzyHz(wxzy);
		}
	
	}

	@Override
	public int listWxzyHzCount(RcyhWxzyjlb wxzy) {
		HtglBmb bm = bmMapper.selectBmbByBmcode(wxzy.getBmcode());
		if( 0 == bm.getSftsbm()){
			return wxzyMapper.listWxzyHzCount(wxzy);
		}else{
			return wxzyMapper.listTsbmWxzyHzCount(wxzy);
		}
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public int saveYs(RcyhZyysjlb zyys) {
		
		if(!RcyhUtils.canYs(zyys.getYhid(),zyys.getLdcode(),zyys.getBmcode(),zyys.getSsny())) {
			List<RcyhWxzyjlb> list = RcyhUtils.wxjlByYhidAndLd(zyys.getYhid(),zyys.getLdcode(),zyys.getSsny(),zyys.getBmcode());
			for( RcyhWxzyjlb wxzy : list  ) {
				wxzy.setYszt("4");
				int c = wxzyMapper.updateByPrimaryKeySelective(wxzy);
				if( c > 0 ) {
					log.info("已经将"+wxzy.getZyid()+"的验收状态更改为重复验收");
				}
				wfService.deleteProcessInstance(wxzy.getRwdid());
				log.info("已经将" + wxzy.getZyid() + "验收流程已经被删除");
			}
			return 2;
		}
		
		HashMap<String,Object>  variable= new HashMap<String,Object>();
		variable.put("zyyszt", zyys.getZyyszt());
		// 查询 此验收记录的 对应的所有 维修记录( 养护ID ，路段)
	//	List<RcyhWxzyjlb> list = RcyhUtils.wxjlByYhidAndLd(zyys.getYhid(),zyys.getLdcode());    当前月
		List<RcyhWxzyjlb> list = RcyhUtils.wxjlByYhidAndLd(zyys.getYhid(), zyys.getLdcode(), zyys.getSsny(),zyys.getBmcode());  // 传入的所属年月
		
		for(RcyhWxzyjlb wxzy : list ) {
			variable.put("zyys",zyys);
			
			if( "2".equals(zyys.getZyyszt())) { // 打回返工
				
				// 1 修改 '任务单状态' 为打回返工 修改  '任务单标识'  为 补充, 修改任务的所属年月为下月
				RcyhRwdjlb rwd = rwdMapper.selectByPrimaryKey(wxzy.getRwdid());
				
				if( rwd !=  null ) {
					rwd.setRwdlx("2");
					rwd.setRwdzt("3");
					rwd.setSsny(RcyhUtils.getSsny(1));
					int re = rwdMapper.updateByPrimaryKeySelective(rwd);
					if( re > 0 ) {
						log.info(rwd.getRwdid() + " 更改任务单状态成功！");
					}else{
						log.error(rwd.getRwdid() + " 更改任务单状态失败！");
					}
					// 2 修改对应的病害的维修标识 0 未维修
					List<RcyhBhjlb> bhList = RcyhUtils.getBhsByRwdId(rwd.getRwdid());
					for( RcyhBhjlb b : bhList) {
						b.setBhwxzt("0");
						bhjlMapper.updateByPrimaryKeySelective(b);
						log.info(b.getBhjlid() + " 病害的状态 已经更改为 未维修!");
					}
					
					// 3 修改所有的维修记录的 '验收状态' 为 验收不通过，删除任务单与维修记录单的 关联关系
					wxzy.setYszt("2");
					String rwdid = wxzy.getRwdid();
					wxzy.setRwdid(" ");
					int c = wxzyMapper.updateByPrimaryKey(wxzy);
					if(c>0){
						log.info(wxzy.getZyid()+"的作业记录已经和任务单的关联关系删除");
					}
					wxzy.setRwdid(rwdid);
					// 流程将会 跑到维修作业那里 , 给他 一个 rwd 好让他可以继续往下走
					variable.put("rwd", rwd);
				}else{ // 该维修作业没有对应的任务单， 直接 就是将维修作业状态更改为 验收不通过 ，删除对应的流程 直接返回，别往下走了
					wxzy.setYszt("2");
					int c = wxzyMapper.updateByPrimaryKey(wxzy);
					if(c>0){
						log.info(wxzy.getZyid()+"该维修作业没有对应的任务单， 已经该维修作业的状态更改为验收不通过");
					}
					wfService.deleteProcessInstance(wxzy.getRwdid());
					return 1;
				}
				
			} else if( "1".equals(zyys.getZyyszt())) { // 验收通过(全部验收)
				
				// 2 更改 维修作业记录表的状态 zyyszt 为 1 已验收
				wxzy.setYszt("1");
				int c = wxzyMapper.updateByPrimaryKeySelective(wxzy);
				if( c > 0 ) {
					log.info("维修作业的状态已经更改为已维修");
				}
				// 3 更改任务单 记录 rwdzt = 2 已验收
				RcyhRwdjlb rwd = rwdMapper.selectByPrimaryKey(wxzy.getRwdid());
				
				if( rwd != null ) {
					rwd.setRwdzt("2");
					int r = rwdMapper.updateByPrimaryKeySelective(rwd);
					if( r > 0 ) {
						log.info(rwd.getRwdid() + "任务单的状态已经更改为已验收");
					}else{
						log.info(rwd.getRwdid() + "任务单的状态更改失败");
					}
					// 4 更改对应的病害 为 已 维修 bhwxzt = 1 已维修
					List<RcyhBhjlb> bhList = RcyhUtils.getBhsByRwdId(rwd.getRwdid());
					for( RcyhBhjlb b : bhList) {
						b.setBhwxzt("1");
						bhjlMapper.updateByPrimaryKeySelective(b);
						log.info(b.getBhjlid() + " 病害的状态 已经更改为 已维修!");
					}
				}
			}
			wfService.completeTask(wxzy.getRwdid(), variable);
		}
		
		// 保存作业验收记录表
		if( "1".equals(zyys.getZyyszt())) {
			// 1 保存验收记记录
			RcyhZyysjlbMapper zyysMapper = (RcyhZyysjlbMapper) SpringContextUtil.getBean("rcyhZyysjlbMapper");
			zyys.setYsid(RcyhUtils.createZyysID());
			int r = zyysMapper.insert(zyys);
			if( r > 0 ) {
				log.info(zyys.getYsid() + "验收记录已经插入数据库中");
			}else{
				log.error(zyys.getYsid() + "验收记录插入失败");
			}
		}
		return 1;
	}

	@Override
	public RcyhWxzyjlb queryWxzyByKeyWithZps(String zyid) {
		return wxzyMapper.queryWxzyByKeyWithZps(zyid);
	}

	@Override
	public RcyhWxzyjlb queryWxzyByKeySimple(String zyid) {
		return wxzyMapper.queryWxzyByKeySimple(zyid);
	}

	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public int delWxzyWithoutProcess(RcyhWxzyjlb wx){
		// 1 删除维修作业 关联的人员记录信息
		int c = mjlxMapper.deleteRyzysByZyid(wx.getZyid());
		log.info(wx.getZyid()+ "作业的人员作业记录信息 删除成功!共 " + c + "条 记录 ");
		// 2 删除维修作业 关联的工料机消耗信息
		c = mjlxMapper.deleteGljxhBySsid(wx.getZyid());
		log.info(wx.getZyid() + "该维修相关的机械材料信息 已经删除 共 " + c + " 条记录");
		// 3 删除维修作业关联的照片信息
		if( wx.getZps() != null && wx.getZps().size() > 0 ) {
			RcyhUtils.removePicFromServer(wx.getZps());
		}
		c = mjlxMapper.delPicBySsid(wx.getZyid());
		log.info(wx.getZyid() + "该维修相关的机械材料信息 已经陈功删除 共有 " + c + "条记录");
		c = wxzyMapper.deleteByPrimaryKey(wx.getZyid());
		log.info(wx.getZyid() + "该条维修作业已经成功删除");
		return 1;
	}
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public int delWxzy(RcyhWxzyjlb wx) {
		if("1".equals(wx.getZysbzt())){ // 维修作业 已经上报 无法删除
			return 2;
		}else {
			delWxzyWithoutProcess(wx);
			wfService.deleteProcessInstance(wx.getRwdid());
			log.info(wx.getRwdid() + "对应的流程已经删除");
			return 1;
		}
	}
	
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public int saveWxzyWithoutProcess(RcyhWxzyjlb wxzy){
		String wxzyID = RcyhUtils.createWxzyID();
		wxzy.setZyid(wxzyID);
		// 1 更改任务单状态 为已维修
		if( StringUtils.isNoneBlank(wxzy.getRwdid())) {
			RcyhRwdjlb rwd = new RcyhRwdjlb();
			rwd.setRwdid(wxzy.getRwdid());
			rwd.setRwdzt("1");
			
		/*	if(wxzy.getYhid().startsWith("06") || wxzy.getYhid().startsWith("07")) {
				rwd.setRwdzt("2");  //如果养护类型 生产或者非生产的 直接 已验收
			}*/
			
			int count = rwdMapper.updateByPrimaryKeySelective(rwd);
			if( count > 0 ) {
				log.info("更新任务单状态更改为已维修 :" + rwd.getRwdid());
				// 1.1 更新与务单相关联的病害
				List<RcyhBhjlb> bhs = bhjlMapper.getBhsByRwdId(wxzy.getRwdid());
				if( bhs != null ) {
					for( RcyhBhjlb bh : bhs ) {
						bh.setBhwxzt("1");
						bhjlMapper.updateByPrimaryKeySelective(bh);
					}
					log.info("与" + wxzy.getRwdid() + "相关的病害状态已经修改");
				}
			}else{
				log.error("更新"+rwd.getRwdid()+"任务单更新没有成功");
			}
		}else{
			wxzy.setRwdid(wxzy.getZyid());
			wxzy.setYszt("0");
		}
	/*	
		if(wxzy.getYhid().startsWith("06") || wxzy.getYhid().startsWith("07")) {
			wxzy.setYszt("1");
			wxzy.setZysbzt("1");
		}*/
		wxzy.setZysbzt("0");
		// 2 保存维修作业记录
		int wxcount = wxzyMapper.insert(wxzy);
		if(wxcount > 0) {
			log.info("新插入了一条维修记录信息"+wxzy.getZyid());
		}else{
			log.error("插入维修作业信息 失败!");
		}
		
		// 3  保存关联的 人员工作量信息
		ArrayList<RcyhRyzyjlb> ryzys = new ArrayList<RcyhRyzyjlb>();
		for( RcyhRyzyjlb zyjl : wxzy.getRyzys()) {
			if( zyjl != null ) {
				zyjl.setZyid(wxzy.getZyid());
				ryzys.add(zyjl);
			}
		}
		mjlxMapper.insertRyzyjlBatch(ryzys);
		int count = wxzy.getRyzys().size();
		if(count  > 0 ) {
			log.info("批量插入了" + count + "和 修作业相关的 人员信息");
		}else{
			log.error("批量插入 维修相关的 人员信息 失败");
		}
	
		// 4  保存关联的 机械消耗 信息 
		if( wxzy.getCljxxhs() != null ) {
			List<RcyhCljxxhb> list = new ArrayList<RcyhCljxxhb>();
			for(RcyhCljxxhb cljx : wxzy.getCljxxhs()) {
				if( cljx != null ) {
					cljx.setSsid(wxzy.getZyid());
					cljx.setJe(cljx.getDj() * cljx.getSl());
					list.add(cljx);
				}
			}
			if( list.size() > 0 ) {
				mjlxMapper.insertCljxxhBatch(list);
				count = wxzy.getCljxxhs().size();
				if(count  > 0 ) {
					log.info("批量插入了" + count + "和 修作业相关的 材料信息");
				}else{
					log.error("批量插入 维修相关的 材料信息 失败");
				}
			}
		}
		// 5 批量插入 维修作业相关的 照片信息
		List<ZP> zps = wxzy.getZps();
		List<ZP> zps2 = new ArrayList<ZP>();
		if( zps != null ) {
			for( ZP zp : zps ) {
				if( zp != null) {
					zp.setZpid(RcyhUtils.createZpID());
					zp.setSsid(wxzyID);
					zps2.add(zp);
				}
			}
			mjlxMapper.insertZpBatch(zps2);
			log.info(wxzy.getZyid() + "相关照片信息插入成功!");
		}
		return wxcount;
	}
	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public int saveWxzy(RcyhWxzyjlb wxzy) {
		int c = saveWxzyWithoutProcess(wxzy);
	
	/*	if(wxzy.getYhid().startsWith("06") || wxzy.getYhid().startsWith("07")) {
			wfService.deleteProcessInstance(wxzy.getRwdid()); // 如果生产类型是辅助或者非生产类型的 直接 把流程删除掉
		}else{*/
			HashMap<String,Object> variables = new HashMap<String,Object>();
			variables.put("wxzy", wxzy);
			wfService.completeTask(wxzy.getRwdid(),variables);
	//	}
		return c;
	}
	
	@Override
	public int saveWxzyWithoutRwd(RcyhWxzyjlb wxzy) {
		int c = saveWxzyWithoutProcess(wxzy);
		/*if(wxzy.getYhid().startsWith("06") || wxzy.getYhid().startsWith("07")) {
			return c;
		}*/
		HashMap<String,Object> variables = new HashMap<String,Object>();
		RcyhRwdjlb rwd = new RcyhRwdjlb();
		rwd.setBmcode(wxzy.getBmcode());
		variables.put("rwd", rwd);
		wfService.startProcess("wxProcess", wxzy.getZyid(), variables);
		HashMap<String,Object> varaibles2 = new HashMap<String,Object>();
		varaibles2.put("wxzy", wxzy);
		wfService.completeTask(wxzy.getZyid(),varaibles2);
		return c;
	}

	/**
	 * 保存维修作业的更新  
	 */
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public int saveWxzyUpdate(RcyhWxzyjlb wxzy) {
		// 1 删除原来的维修作业信息
		RcyhWxzyjlb wx = wxzyMapper.selectByPrimaryKey(wxzy.getZyid());
		int c = delWxzyWithoutProcess(wx);
		// 2 保存原来的维修作业的信息
		if( c > 0 ) {
			saveWxzyWithoutProcess(wxzy);
			return c;
		}
		return 0;
	}

	@Override
	public RcyhRwdjlb selectByPrimaryKeyWithClxh(String rwdid) {
		return rwdMapper.selectByPrimaryKeyWithClxh(rwdid);
	}

	@Override
	public List<RcyhRwdjlb> listRwdcx(RcyhRwdjlb rwd) {
		return rwdMapper.listRwdcx(rwd);
	}

	@Override
	public int listRwdcxCount(RcyhRwdjlb rwd) {
		return rwdMapper.listRwdcxCount(rwd);
	}

	@Override
	public List<RcyhWxzyjlb> listWxzycx(RcyhWxzyjlb wxzy) {
		return wxzyMapper.listWxzycx(wxzy);
	}

	@Override
	public int listWxzycxCount(RcyhWxzyjlb wxzy) {
		return wxzyMapper.listWxzycxCount(wxzy);
	}

	@Override
	public List<RcyhRwdjlb> listRwdForYdjh(RcyhRwdjlb rwd) {
		return rwdMapper.listRwdForYdjh(rwd);
	}

	@Override
	public int listRwdForYdjhCount(RcyhRwdjlb rwd) {
		return rwdMapper.listRwdForYdjhCount(rwd);
	}

	@Override
	public RcyhWxzyjlb selectByPrimaryKeySimple(String zyid) {
		return wxzyMapper.queryWxzyByKeySimple(zyid);
	}

	
	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public int saveTsbmys(RcyhWxzyjlb wxzy) {
		//记录入维修作业记录表的合格数量里（数据库需要添加字段），修改维修作业状态为已验收
		if(wxzy.getYszt() != null ) {
			if( "1".equals(wxzy.getYszt())) { // 确认验收
				wxzy.setYszt("1"); 
				int c =	wxzyMapper.updateByPrimaryKeySelective(wxzy);
				if( c > 0 ) {
					log.info("维修作业已修改为确认验收，加入了合格数量");
				}
				
				if( wxzy.getRwdid() != null ) {
					
					RcyhRwdjlb r = rwdMapper.selectByPrimaryKeySimple(wxzy.getRwdid());
					
					if( r != null ) {
						r.setRwdzt(Constants.RwdYys);
						int rc = rwdMapper.updateByPrimaryKeySelective(r);
						if( rc > 0 ) {
							log.info("维修作业对应的任务单的状态已经更改为已验收");
						}
					}
					
				}
				
				HashMap<String,Object> variable = new HashMap<String,Object>();
				variable.put("zyyszt","1");
				wfService.completeTask(wxzy.getRwdid(),variable);
				return c;
			}else{ // 取消验收
			/**
			 * 修改维修作业状态为验收不通过，修改对应的任务单状态为打回返工，去除维修单和任务单之间的关联关系
			 */
				
				RcyhRwdjlb rwd = rwdMapper.selectByPrimaryKeySimple(wxzy.getRwdid());
				if(rwd != null ) {
					rwd.setRwdzt(Constants.RwdDhxg);
					int c = rwdMapper.updateByPrimaryKeySelective(rwd);
					if( c > 0 ) {
						log.info("已经将任务单的状态修改为打回返工");
					}
					HashMap<String,Object> variable = new HashMap<String,Object>();
					variable.put("zyyszt", "2");
					variable.put("rwd", rwd);
					wfService.completeTask(wxzy.getRwdid(),variable);
				}else{
					wfService.deleteProcessInstance(wxzy.getRwdid());
				}
				wxzy.setYszt("2");
				wxzy.setRwdid(" ");
				int c = wxzyMapper.updateByPrimaryKeySelective(wxzy);
				if(c > 0 ) {
					log.info("已经将维修作业的状态修改为验收不通过,去除了维修单和任务单的关系");
				}
				return c;
			}
		}else{
			return -1;
		}
	}

	@Override
	public int updateByCkzt(String rwdid) {
		// TODO Auto-generated method stub
		return rwdMapper.updateByCkzt(rwdid);
	}


}
