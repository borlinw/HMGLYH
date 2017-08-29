/**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.service.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.basicData.bean.GpsRoad;
import com.hdsx.hmglyh.jcpd.bean.Bbkzb;
import com.hdsx.hmglyh.jcpd.bean.Lkdcfb;
import com.hdsx.hmglyh.jcpd.bean.Qmldb;
import com.hdsx.hmglyh.jcpd.mapper.BbkzbMapper;
import com.hdsx.hmglyh.jcpd.mapper.QmldbMapper;
import com.hdsx.hmglyh.jcpd.service.QmldbService;

/**  
 *  
 * @author Baiyy
 * @created 2015年5月28日 下午8:00:43 
 */
@Transactional
@Service
public class QmldbServiceImpl implements QmldbService {
	@Resource(name="qmldbMapper")
	private QmldbMapper qmldbMapper;
	@Resource(name="bbkzbMapper")
	private BbkzbMapper bbkzbMapper;
	
	@Override
	public boolean createQmld(List<GpsRoad> list,int bbid) {
		Bbkzb b = new Bbkzb();
		b.setBbid(bbid);
		b.setBbsj(new Date());
		Qmldb q = new Qmldb();
		q.setBbid(bbid);
		//判断是否存在该版本的千米路段并且已经被使用
		if(qmldbMapper.isUsed(q).size() != 0)
			return false;
		//删除原有的千米路段
		qmldbMapper.dropQmld(q);
		//生成千米路段
		List<Qmldb> qmldb = new ArrayList<Qmldb>();
		for(GpsRoad road:list){
			int i = (int)road.getRoadStart()+1;
			double total = (int)road.getRoadEnds();
			if(road.getRoadEnds()>total)
				total = road.getRoadEnds();
			
			for(;i<total+1;i++){
				//若为高速或者一级公路则需要将路段分为上下行
				if(road.getIsgs()==1){
					Qmldb qmld1 = new Qmldb();
					Qmldb qmld2 = new Qmldb();
					if (i == (int)road.getRoadStart()+1) {
						qmld1.setSzhh(road.getRoadStart());
						qmld2.setSzhh(road.getRoadStart());
					}else{
						qmld1.setSzhh(i-1);
						qmld2.setSzhh(i-1);
					}
					if(i > total){
						qmld1.setEzhh(total);
						qmld2.setEzhh(total);
					}else{
						qmld1.setEzhh(i);
						qmld2.setEzhh(i);
					}
					qmld1.setCd((int)(Math.round(1000*qmld1.getEzhh())-Math.round(1000*qmld1.getSzhh())));
					qmld2.setCd((int)(Math.round(1000*qmld2.getEzhh())-Math.round(1000*qmld2.getSzhh())));
					qmld1.setLxCode(road.getRoadCode());
					qmld2.setLxCode(road.getRoadCode());
					qmld1.setLmkd(road.getLmkd()/2);
					qmld2.setLmkd(road.getLmkd()/2);
					qmld1.setBbid(bbid);
					qmld2.setBbid(bbid);
					qmld1.setLmlx(road.getLmlx());
					qmld2.setLmlx(road.getLmlx());
					qmld1.setIsgs(1);
					qmld2.setIsgs(1);
					qmld1.setFx("0301");
					qmld2.setFx("0302");
					qmldb.add(qmld1);
					qmldb.add(qmld2);
				}else{
					Qmldb qmld = new Qmldb();
					if (i == (int)road.getRoadStart()+1) {
						qmld.setSzhh(road.getRoadStart());
					}else{
						qmld.setSzhh(i-1);
					}
					if(i > total){
						qmld.setEzhh(total);
					}else{
						qmld.setEzhh(i);
					}
					qmld.setCd((int)(Math.round(1000*qmld.getEzhh())-Math.round(1000*qmld.getSzhh())));
					qmld.setLxCode(road.getRoadCode());
					qmld.setLmkd(road.getLmkd());
					qmld.setBbid(bbid);
					qmld.setLmlx(road.getLmlx());
					qmld.setIsgs(0);
					qmld.setFx("0303");
					qmldb.add(qmld);
				}
				
			}
		}
		bbkzbMapper.changeQmbb(b);
		//插入千米路段
		for(Qmldb qm:qmldb){
			System.out.println(qm);
			qmldbMapper.addQmld(qm);
		}
		return true;
	}

	@Override
	public List<Qmldb> getQmld(Qmldb qmldb) {
		return qmldbMapper.getQmld(qmldb);
	}

	@Override
	public int dropQmld(Qmldb qmldb) {
		//判断是否存在该版本的千米路段并且已经被使用
		if(qmldbMapper.isUsed(qmldb).size() != 0)
			return -1;
		return qmldbMapper.dropQmld(qmldb);
	}

	@Override
	public int getQmldCount(Qmldb qmldb) {
		return qmldbMapper.getQmldCount(qmldb);
	}

	@Override
	public List<Qmldb> getQmldForLkdc(Qmldb qmldb) {
		List<Qmldb> list = qmldbMapper.getQmldForLkdc(qmldb);
		for(Qmldb qm:list){
			qm.setDcbbid(qmldb.getDcbbid());
			qm.setLxid(qmldb.getLxid());
			//统计各项病害的数量
			if(qm.getDcid() == null){
				qm.setDcid("");
			}
			List<Lkdcfb> lkdcfb = qmldbMapper.getLkdcfb(qm.getDcid());
			if(lkdcfb != null && lkdcfb.size() != 0){
				qm.setLkdcfb(lkdcfb);
			}
			//求pci，tci，bci，tci
			switch(qmldb.getLxid()){
			case "02"://路基
				qm.setSci(qmldbMapper.getSci(qm));
				break;
			case "03":
				qm.setBci(qmldbMapper.getBci(qm));
				break;
			case "04":
				qm.setTci(qmldbMapper.getTci(qm));
				break;
			default :
				switch(qm.getLmlx()){
				case 1:
					qm.setA0(15);
					qm.setA1(0.412);
					break;
				case 2:
					qm.setA0(10.66);
					qm.setA1(0.461);
					break;
				case 3:
					qm.setA0(10.1);
					qm.setA1(0.487);
					break;
				}
				qm.setPci(qmldbMapper.getPci(qm));
				break;
			}
		}
			
		return list;
	}

	@Override
	public int getQmldCountForLkdc(Qmldb qmldb) {
		return qmldbMapper.getQmldCountForLkdc(qmldb);
	}

	@Override
	public boolean createMxb(Qmldb qmldb) {
		qmldbMapper.dropMxb(qmldb);
		List<Qmldb> qmldbList = qmldbMapper.getLmjc(qmldb);
		for(Qmldb qm : qmldbList){
			qm.setDcbbid(qmldb.getDcbbid());
			qm.setJcbbid(qmldb.getJcbbid());
			qm.setPdbbid(qmldb.getPdbbid());
			switch(qm.getLmlx()){
			case 1:
				qm.setA0(15);
				qm.setA1(0.412);
				qm.setLxid("0101");
				break;
			case 2:
				qm.setA0(10.66);
				qm.setA1(0.461);
				qm.setLxid("0102");
				break;
			case 3:
				qm.setA0(10.1);
				qm.setA1(0.487);
				qm.setLxid("0103");
				break;
			}
			qm.setBci(qmldbMapper.getBci(qm));
			qm.setPci(qmldbMapper.getPci(qm));
			qm.setTci(qmldbMapper.getTci(qm));
			qm.setSci(qmldbMapper.getSci(qm));
			
			double pqi = 0;
			//计算pqi
			if(qm.getLmlx() == 3){//砂石路面，pqi=pci
				pqi = qm.getPci();
				qm.setPqi(qm.getPci());
			}else{
				if(qm.getIsgs()==1){  //高速或一级路
					if(qm.getLmlx() == 1){  //沥青路面 pqi=0.35*pci+0.4*rqi+0.15*rdi+0.1*sri
						pqi = 0.35*qm.getPci()+0.4*qm.getRqi()+0.15*qm.getRdi()+0.1*qm.getSri();
						qm.setPqi(Double.parseDouble(String.format("%.2f", pqi)));
					}else{  //水泥路面  pqi=0.5*pci+0.4*rqi+0.1*sri
						pqi = 0.5*qm.getPci()+0.4*qm.getRqi()+0.1*qm.getSri();
						qm.setPqi(Double.parseDouble(String.format("%.2f", pqi)));
					}
				}else{		//普通公路  pqi=0.6*pci+0.4*rqi
					pqi = 0.6*qm.getPci()+0.4*qm.getRqi();
					qm.setPqi(Double.parseDouble(String.format("%.2f", pqi)));
				}
			}
			//计算mqi mqi=0.7*pqi+0.08*sci+0.12*bci+0.1*tci
			Double mqi = 0.7*pqi+0.08*qm.getSci()+0.12*qm.getBci()+0.1*qm.getTci();
			qm.setMqi(Double.parseDouble(String.format("%.2f", mqi)));
			
			qmldbMapper.addMxb(qm);
		}
		return true;
	}

	@Override
	public List<Qmldb> queryMxb(Qmldb qmldb) {
		return qmldbMapper.queryMxb(qmldb);
	}

	@Override
	public int getMxbCount(Qmldb qmldb) {
		return qmldbMapper.getMxbCount(qmldb);
	}

	@Override
	public List<Qmldb> getLmlx(Qmldb qmldb) {
		return qmldbMapper.getLmlx(qmldb);
	}

	@Override
	public List<Qmldb> getJsdj(Qmldb qmldb) {
		return qmldbMapper.getJsdj(qmldb);
	}

	@Override
	public List<Qmldb> getLmdcForExport(Qmldb qmldb) {
		//查询千米路段
		List<Qmldb> list = qmldbMapper.getQmldForLkdc(qmldb);
		double[] total = new double[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int cd = 0;
		for(Qmldb qm:list){
			cd += qm.getCd();
			switch(qm.getLmlx()){
			case 1:
				qm.setA0(15);
				qm.setA1(0.412);
				break;
			case 2:
				qm.setA0(10.66);
				qm.setA1(0.461);
				break;
			case 3:
				qm.setA0(10.1);
				qm.setA1(0.487);
				break;
			}
			if(qm.getDcid() == null){
				qm.setPci(100);
				qm.setLkdcfb(getLkdcfb(new double[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
			}else{
				qm.setPci(qmldbMapper.getPci(qm));
				List<Lkdcfb> lkdcfb = qmldbMapper.getLkdcfb(qm.getDcid());
				if(lkdcfb != null && lkdcfb.size() != 0){
					qm.setLkdcfb(lkdcfb);
					for(int i=0 ; i<lkdcfb.size() ; i++){
						total[i] += lkdcfb.get(i).getLjsj();
					}
				}else{
					qm.setLkdcfb(getLkdcfb(new double[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
				}
			}
		}
		Qmldb q = new Qmldb();
		q.setLdName("合计");
		q.setCd(cd);
		q.setLkdcfb(getLkdcfb(total));
		list.add(q);
		
		return list;
	}

	@Override
	public List<Qmldb> getLjdcForExport(Qmldb qmldb) {
		//查询千米路段
		List<Qmldb> list = qmldbMapper.getQmldForLkdc(qmldb);
		double[] total = new double[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int cd = 0;
		for(Qmldb qm:list){
			cd += qm.getCd();
			qm.setSci(qmldbMapper.getSci(qm));
			if(qm.getDcid() == null){
				qm.setDcid("");
			}
			List<Lkdcfb> lkdcfb = qmldbMapper.getLkdcfb(qm.getDcid());
			if(lkdcfb != null && lkdcfb.size() != 0){
				qm.setLkdcfb(lkdcfb);
				for(int i=0 ; i<lkdcfb.size() ; i++){
					total[i] += lkdcfb.get(i).getLjsj();
				}
			}else{
				qm.setLkdcfb(getLkdcfb(new double[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}));
			}
		}
		Qmldb q = new Qmldb();
		q.setLdName("合计");
		q.setCd(cd);
		q.setLkdcfb(getLkdcfb(total));
		list.add(q);
		
		return list;
	}

	@Override
	public List<Qmldb> getYxssdcForExport(Qmldb qmldb) {
		//查询千米路段
		List<Qmldb> list = qmldbMapper.getQmldForLkdc(qmldb);
		double[] total = new double[]{0,0,0,0,0,0};
		int cd = 0;
		for(Qmldb qm:list){
			cd += qm.getCd();
			qm.setTci(qmldbMapper.getTci(qm));
			if(qm.getDcid() == null){
				qm.setDcid("");
			}
			List<Lkdcfb> lkdcfb = qmldbMapper.getLkdcfb(qm.getDcid());
			if(lkdcfb != null && lkdcfb.size() != 0){
				qm.setLkdcfb(lkdcfb);
				for(int i=0 ; i<lkdcfb.size() ; i++){
					total[i] += lkdcfb.get(i).getLjsj();
				}
			}else{
				qm.setLkdcfb(getLkdcfb(new double[]{0,0,0,0,0,0}));
			}
		}
		Qmldb q = new Qmldb();
		q.setLdName("合计");
		q.setCd(cd);
		q.setLkdcfb(getLkdcfb(total));
		list.add(q);
		
		return list;
	}

	@Override
	public List<Qmldb> getQshdcForExport(Qmldb qmldb) {
		//查询千米路段
		List<Qmldb> list = qmldbMapper.getQmldForLkdc(qmldb);
		double[] total = new double[]{0,0,0,0,0,0,0,0,0,0,0};
		int cd = 0;
		for(Qmldb qm:list){
			cd += qm.getCd();
			qm.setBci(qmldbMapper.getBci(qm));
			if(qm.getDcid() == null){
				qm.setDcid("");
			}
			List<Lkdcfb> lkdcfb = qmldbMapper.getLkdcfb(qm.getDcid());
			if(lkdcfb != null && lkdcfb.size() != 0){
				qm.setLkdcfb(lkdcfb);
				for(int i=0 ; i<lkdcfb.size() ; i++){
					total[i] += lkdcfb.get(i).getLjsj();
				}
			}else{
				qm.setLkdcfb(getLkdcfb(new double[]{0,0,0,0,0,0,0,0,0,0,0}));
			}
		}
		Qmldb q = new Qmldb();
		q.setLdName("合计");
		q.setCd(cd);
		q.setLkdcfb(getLkdcfb(total));
		list.add(q);
		
		return list;
	} 
	
	
	private List<Lkdcfb> getLkdcfb(double[] ljsj){
		List<Lkdcfb> list = new ArrayList<Lkdcfb>();
		for(int j=0 ; j<ljsj.length ; j++){
			Lkdcfb l = new Lkdcfb();
			l.setLjsj(Double.parseDouble(String.format("%.2f", ljsj[j])));
			list.add(l);
		}
		return list;
	}

	@Override
	public List<Qmldb> getBhfltj(Qmldb qmldb) {
		return qmldbMapper.getBhfltj(qmldb);
	}
}
