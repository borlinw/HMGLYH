
package com.hdsx.hmglyh.rcyh.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.rcyh.dao.HtglMjlxMapper;
import com.hdsx.hmglyh.rcyh.dao.HtglYhbMapper;
import com.hdsx.hmglyh.rcyh.dao.RcyhBhjlbMapper;
import com.hdsx.hmglyh.rcyh.dao.RcyhGlxcsjbMapper;
import com.hdsx.hmglyh.rcyh.dao.model.HtglBhlx;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhBhjlb;
import com.hdsx.hmglyh.rcyh.dao.model.ZP;
import com.hdsx.hmglyh.rcyh.service.BhService;
import com.hdsx.hmglyh.rcyh.service.WorkFlowService;
import com.hdsx.hmglyh.rcyh.util.RcyhUtils;

@Service
@Transactional
public class BhServiceImpl implements BhService{

	Log log = LogFactory.getLog(BhServiceImpl.class);
	
	@Autowired
	private RcyhGlxcsjbMapper glxcsjbMapper;
	@Autowired
	private RcyhBhjlbMapper bhjlMapper;
	@Autowired
	private HtglYhbMapper yhMapper;
	@Autowired
	private HtglMjlxMapper mjlxMapper;
	@Autowired
	private WorkFlowService workflowService;

	@Override
	public RcyhBhjlb queryBhByKey(String bhjlid) {
		return bhjlMapper.selectByPrimaryKeyWithZps(bhjlid);
	}


	@Override
	public List<RcyhBhjlb> listBh(RcyhBhjlb bhjl) {
		
		return bhjlMapper.listBh(bhjl);
	}
	
	@Override
	public int listBhCount(RcyhBhjlb bhjl) {
		return bhjlMapper.listBhCount(bhjl);
	}

	@Override
	public List<HtglBhlx> selectBhlxs() {
		return bhjlMapper.selectBhlxs();
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public int updateBh(RcyhBhjlb bhjl) {
		// 1 更新病害信息
		int c = bhjlMapper.updateByPrimaryKeySelective(bhjl);
		if( c > 0 ) {
			log.info(bhjl.getBhjlid() + "更新成功！");
		}else{
			log.info(bhjl.getBhjlid() + "更新失败！");
		}
		
		// 2 删除原来的 照片信息 然后 插入 新的 照片信息
		mjlxMapper.delPicBySsid(bhjl.getBhjlid());
		List<ZP> zpList = bhjl.getZps();
		if(zpList != null ) {
			for(ZP zp : zpList) {
				zp.setSsid(bhjl.getBhjlid());
				zp.setZpid(RcyhUtils.createZpID());
			}
			mjlxMapper.insertZpBatch(zpList);
		}
		
		// 3 更新巡道记录的信息
		RcyhUtils.updateXdjl(bhjl.getXcid());
		return c;
	}

	@Override
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public int delBh(RcyhBhjlb bhjl) {
		// 删除 流程实例
		workflowService.deleteProcessInstance(bhjl.getBhjlid());
		// 删除病害关联照片信息 
		List<ZP> listZp  = mjlxMapper.getZpsBySsid(bhjl.getBhjlid());
		if( listZp != null ) {
			RcyhUtils.removePicFromServer(listZp);   // 删除服务器上的照片
			mjlxMapper.delPicBySsid(bhjl.getBhjlid()); // 删除表中的照片
		}
		// 得先删除 病害记录 然后在去更新 巡道记录 顺序搞差了，没删之前 还要把xcid 给 查出来， 删完之后 就没有了
		RcyhBhjlb bh = bhjlMapper.selectByPrimaryKey(bhjl.getBhjlid());
		int c=bhjlMapper.deleteByPrimaryKey(bhjl.getBhjlid());
		// 更新相关巡道记录的状态
		RcyhUtils.updateXdjl(bh.getXcid()); // 更新巡道记录的信息
		return c;
	}

	@Override
	public void delBhs(RcyhBhjlb bhjl) {
		// TODO delBhs
		
	}


	@Override
	public List<RcyhBhjlb> listBhByRwdIdWithPage(int page,int rows,String rwdid) {
		return bhjlMapper.getBhsByRwdIdWithPage(page,rows,rwdid);
	}


	@Override
	public int listBhByRwdIdWithPageCount(String rwdid) {
		return bhjlMapper.getBhsByRwdIdWithPageCount(rwdid);
	}


	@Override
	public List<RcyhBhjlb> bhcxList(RcyhBhjlb bhjl) {
		return bhjlMapper.bhcxList(bhjl);
	}


	@Override
	public int bhcxListCount(RcyhBhjlb bhjl) {
		return bhjlMapper.bhcxListCount(bhjl);
	}
}
