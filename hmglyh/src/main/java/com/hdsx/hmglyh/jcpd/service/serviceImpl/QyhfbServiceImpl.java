
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.jcpd.bean.Bbkzb;
import com.hdsx.hmglyh.jcpd.bean.Qyhfb;
import com.hdsx.hmglyh.jcpd.bean.Qyhfxxb;
import com.hdsx.hmglyh.jcpd.mapper.QyhfbMapper;
import com.hdsx.hmglyh.jcpd.service.QyhfbService;

/**  
 *  
 * @author Baiyy
 * @created 2015年7月3日 下午5:03:32 
 */
@Transactional
@Service
public class QyhfbServiceImpl implements QyhfbService {
	@Resource(name="qyhfbMapper")
	private QyhfbMapper qyhfbMapper;
	
	@Override
	public int addQyhfb(List<Qyhfb> list) {
		Qyhfb q = new Qyhfb();
		q.setLxCode(list.get(0).getLxCode());
		q.setSzhh(list.get(0).getSzhh());
		q.setEzhh(list.get(list.size()-1).getEzhh());
		q.setBbid(list.get(0).getBbid());
		q.setBmCode(list.get(0).getBmCode());
		
		qyhfbMapper.dropQyhfb(q);
		
		int total = 0;
		for(Qyhfb qyhfb:list){
			System.out.println(qyhfb);
			qyhfbMapper.addQyhfb(qyhfb);
			total ++;
		}
		return total;
	}
	@Override
	public boolean addQyhfXxb(List<Qyhfb> qybList,List<Qyhfxxb> xxbList){
		Qyhfb q = new Qyhfb();
		q.setLxCode(qybList.get(0).getLxCode());
		q.setSzhh(qybList.get(0).getSzhh());
		q.setEzhh(qybList.get(qybList.size()-1).getEzhh());
		q.setBbid(qybList.get(0).getBbid());
		q.setBmCode(qybList.get(0).getBmCode());
		
		qyhfbMapper.dropQyhfb(q);
		qyhfbMapper.dropXxb(q);
		
		for(Qyhfb qyhfb:qybList){
			if(qyhfbMapper.addQyhfb(qyhfb)==-1)
				return false;
		}
		
		for(Qyhfxxb qyhfxxb:xxbList){
			if(qyhfbMapper.addXxb(qyhfxxb)==-1)
				return false;
		}
		
		return true;
	}

	@Override
	public List<Qyhfb> queryQyhfb(Qyhfb qyhfb) {
		List<Qyhfb> list = qyhfbMapper.queryQyhfb(qyhfb);
		if(qyhfb.getRows() == null){
			for(Qyhfb q:list){
				if(qyhfbMapper.isGs(q)>0)
					q.setIsgs(false);
				else
					q.setIsgs(true);
			}
		}
		return list;
	}

	@Override
	public int dropQyhfb(Qyhfb qyhfb) {
		if(qyhfbMapper.isUsed(qyhfb)>0)
			return -2;
		qyhfbMapper.dropXxb(qyhfb);
		return qyhfbMapper.dropQyhfb(qyhfb);
	}

	@Override
	public int getQyhfbCount(Qyhfb qyhfb) {
		return qyhfbMapper.getQyhfbCount(qyhfb);
	}

	@Override
	public boolean isUsed(Qyhfb qyhfb) {
		if(qyhfbMapper.isUsed(qyhfb)>0)
			return true;
		return false;
	}

	@Override
	public List<Qyhfb> exportQyhfb(Qyhfb qyhfb) {
		List<Qyhfb> list = qyhfbMapper.queryQyhfb(qyhfb);
		if(list != null && list.size() != 0){
			for(Qyhfb q:list){
				q.setDescription(getDescription(qyhfbMapper.getJsdj(q)));
				System.out.println(q);
			}
		}
		return list;
	}
	/**
	 * 根据查询出的某一区域中的技术等级情况总结技术等级情况
	 * @param list
	 * @return
	 */
	private String getDescription(List<Qyhfb> list){
		if(list == null || list.size() == 0)
			return "";
		String description = "";
		double szhh = 0;
		double ezhh = 0;
		String jsdj = "";
		for(int i=0 ; i<list.size() ; i++){
			if(i==0){
				szhh = list.get(0).getSzhh();
				ezhh = list.get(0).getEzhh();
				jsdj = list.get(0).getJsdj();
			}else{
				if(list.get(i).getJsdj().equals(jsdj) && list.get(i).getSzhh() == ezhh){
					ezhh = list.get(i).getEzhh();
				}else if(!list.get(i).getJsdj().equals(jsdj)){
					description += "K"+szhh+"-K"+ezhh+jsdj+";";
					szhh = list.get(i).getSzhh();
					ezhh = list.get(i).getEzhh();
					jsdj = list.get(i).getJsdj();
				}else{
					description += "K"+szhh+"-K"+ezhh+"、";
					szhh = list.get(i).getSzhh();
					ezhh = list.get(i).getEzhh();
				}
			}
		}
		description += "K"+szhh+"-K"+ezhh+jsdj;
		return description;
	}

	@Override
	public List<Bbkzb> getQybb(Qyhfb qyhfb) {
		return qyhfbMapper.getQybb(qyhfb);
	}

	@Override
	public boolean copy(Qyhfb qyhfb) {
		//清除之前的数据
		qyhfbMapper.dropQyhfb(qyhfb);
		qyhfbMapper.dropXxb(qyhfb);
		qyhfbMapper.copy(qyhfb);
		qyhfbMapper.copyXxb(qyhfb);
		return true;
	}

	@Override
	public Qyhfb getDataForUpdate(Qyhfb qyhfb) {
		Qyhfb q = new Qyhfb();
		List<Qyhfxxb> list = qyhfbMapper.getXxb(qyhfb);
		if(list != null && list.size() != 0){
			List<Qyhfxxb> zrqh = new ArrayList<Qyhfxxb>();
			List<Qyhfxxb> glgn = new ArrayList<Qyhfxxb>();
			List<Qyhfxxb> jtl = new ArrayList<Qyhfxxb>();
			List<Qyhfxxb> jtzc = new ArrayList<Qyhfxxb>();
			List<Qyhfxxb> cyqk = new ArrayList<Qyhfxxb>();;
			List<Qyhfxxb> qt = new ArrayList<Qyhfxxb>();
		
			for(Qyhfxxb xxb:list){
				switch(xxb.getYxys()){
				case "自然区划":
					zrqh.add(xxb);
					break;
				case "公路功能":
					glgn.add(xxb);
					break;
				case "交通量":
					jtl.add(xxb);
					break;
				case "交通组成":
					jtzc.add(xxb);
					break;
				case "穿越情况":
					cyqk.add(xxb);
					break;
				case "其他":
					qt.add(xxb);
					break;
				}
			}
			q.setZrqh(zrqh);
			q.setGlgn(glgn);
			q.setJtl(jtl);
			q.setJtzc(jtzc);
			q.setCyqk(cyqk);
			q.setQt(qt);
			
			return q;
		}else{
			return null;
		}
		
	}
	@Override
	public List<Qyhfxxb> getXxbForUpdate(Qyhfb qyhfb) {
		return qyhfbMapper.getXxb(qyhfb);
	}

}














