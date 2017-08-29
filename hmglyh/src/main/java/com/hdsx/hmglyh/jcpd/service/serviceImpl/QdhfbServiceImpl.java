
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
import com.hdsx.hmglyh.jcpd.bean.Ldb;
import com.hdsx.hmglyh.jcpd.bean.Qdhfb;
import com.hdsx.hmglyh.jcpd.bean.Qyhfb;
import com.hdsx.hmglyh.jcpd.dto.HighChart;
import com.hdsx.hmglyh.jcpd.mapper.QdhfbMapper;
import com.hdsx.hmglyh.jcpd.service.QdhfbService;

/**  
 *  
 * @author Baiyy
 * @created 2015年7月6日 上午7:15:30 
 */
@Transactional
@Service
public class QdhfbServiceImpl implements QdhfbService{
	@Resource(name="qdhfbMapper")
	private QdhfbMapper qdhfbMapper;

	@Override
	public int addQdhfb(List<Qdhfb> list) {
		Qdhfb q = new Qdhfb();
		q.setLxCode(list.get(0).getLxCode());
		q.setSzhh(list.get(0).getSzhh());
		q.setEzhh(list.get(list.size()-1).getEzhh());
		q.setBbid(list.get(0).getBbid());
		q.setBmCode(list.get(0).getBmCode());
		q.setPdbbid(list.get(0).getPdbbid());
		System.out.println(q);
		if(qdhfbMapper.isSb(q) != null)
			return -1;
		qdhfbMapper.dropQdhfb(q);
		qdhfbMapper.changeDcbb(q);
		
		int total = 0;
		for(Qdhfb qdhfb:list){
			System.out.println(qdhfb);
			qdhfbMapper.addQdhfb(qdhfb);
			if(qdhfb.getJd()!=null && !qdhfb.getJd().equals(""))
				qdhfbMapper.addJd(qdhfb);
			total ++;
		}
		return total;
	}

	@Override
	public List<Qdhfb> queryQdhfb(Qdhfb qdhfb) {
		return qdhfbMapper.queryQdhfb(qdhfb);
	}

	@Override
	public int dropQdhfb(Qdhfb qdhfb) {
		if(qdhfbMapper.isSb(qdhfb) != null)
			return -1;
		int count = qdhfbMapper.dropQdhfb(qdhfb);
		if(qdhfbMapper.getCountByBb(qdhfb.getBbid())==0){
			qdhfb.setPdbbid(0);
			qdhfbMapper.changeDcbb(qdhfb);
		}
		return count;
	}

	@Override
	public int getQdhfbCount(Qdhfb qdhfb) {
		return qdhfbMapper.getQdhfbCount(qdhfb);
	}

	@Override
	public HighChart getPciIri(Qdhfb qdhfb) {
		HighChart highChart = new HighChart();
		String points = "";
		//获取categories
		int i=0;
		if(qdhfb.getSzhh() == qdhfb.getSzhh().intValue())
			i = qdhfb.getSzhh().intValue();
		else
			i = qdhfb.getSzhh().intValue() + 1;
		List<String> categories = new ArrayList<String>();
		for(;i<=qdhfb.getEzhh();i++){
			categories.add(i+"");
			points += i + ",";
		}
		highChart.setCategories(categories);
		//获取pci与iri
		qdhfb.setPoints(points);
		List<Qdhfb> list = qdhfbMapper.getPciIri(qdhfb);
		if(list == null || list.size() == 0)
			return null;
		double[] pci = new double[categories.size()];
		double[] iri = new double[categories.size()];
		System.out.println(list.size()+"==================");
		for(int j=0;j<list.size();j++){
			pci[j] = list.get(j).getPci();
			iri[j] = list.get(j).getIri();
		}
		highChart.setPci(pci);
		highChart.setIri(iri);
		
		return highChart;
	}

	@Override
	public Bbkzb getBb(Qdhfb qdhfb) {
		Bbkzb bbkzb = qdhfbMapper.getBb(qdhfb.getBbid());
		List<Qdhfb> list = qdhfbMapper.queryQdhfb(qdhfb);
		for(Qdhfb q : list){
			q.setJd(qdhfbMapper.getJd(q));
		}
		bbkzb.setQdhfList(list);
		
		return bbkzb;
	}

	@Override
	public List<Ldb> exportQdhf(Qdhfb qdhfb) {
		List<Ldb> list = qdhfbMapper.getLdb(qdhfb);
		for(Ldb ldb:list){
			int total = 0;
			List<Qyhfb> qyhfList = qdhfbMapper.getQyhfByLd(ldb);
			if(qyhfList!=null && qyhfList.size()!=0){
				for(Qyhfb qyhfb:qyhfList){
					qyhfb.setQdhfList(qdhfbMapper.getQdhfByQyhf(qyhfb));
					if(qyhfb.getQdhfList().size()!=0){
						total += qyhfb.getQdhfList().size();
						qyhfb.setColspan(qyhfb.getQdhfList().size());
					}else{
						total++;
						qyhfb.setColspan(1);
					}
				}
			}else{
				total = 1;
			}
			ldb.setQyhf(qyhfList);
			ldb.setColspan(total);
		}
		return list;
	}

	@Override
	public List<Qdhfb> getBhfl(Qdhfb qdhbf) {
		List<Qdhfb> list = new ArrayList<Qdhfb>();
		List<Qdhfb> qdhf = qdhfbMapper.getBhfl(qdhbf);
		for(int i=0;i<qdhf.size();i++){
			qdhbf.setJl(qdhbf.getJl()+qdhf.get(i).getJl());
			qdhbf.setKl(qdhbf.getKl()+qdhf.get(i).getKl());
			qdhbf.setDtlf(qdhbf.getDtlf()+qdhf.get(i).getDtlf());
			qdhbf.setCx(qdhbf.getCx()+qdhf.get(i).getCx());
			qdhbf.setBlyb(qdhbf.getBlyb()+qdhf.get(i).getBlyb());
			qdhbf.setCz(qdhbf.getCz()+qdhf.get(i).getCz());
			qdhbf.setKc(qdhbf.getKc()+qdhf.get(i).getKc());
			qdhbf.setSs(qdhbf.getSs()+qdhf.get(i).getSs());
			qdhbf.setFy(qdhbf.getFy()+qdhf.get(i).getFy());
			qdhbf.setXb(qdhbf.getXb()+qdhf.get(i).getXb());
			
		}
		list.add(qdhbf);
		list.addAll(qdhf);
		return list;
	}

}
















