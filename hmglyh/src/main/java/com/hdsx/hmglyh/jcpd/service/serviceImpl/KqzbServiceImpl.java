
 /**
 * 北京恒达时讯科技有限公司版权所有
 * Copyright (C) HDSX Corporation. All Rights Reserved
 */
package com.hdsx.hmglyh.jcpd.service.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.jcpd.bean.Kqfb;
import com.hdsx.hmglyh.jcpd.bean.Kqzb;
import com.hdsx.hmglyh.jcpd.mapper.KqzbMapper;
import com.hdsx.hmglyh.jcpd.service.KqzbService;

/**  
 *  
 * @author Baiyy
 * @created 2015年7月15日 下午5:01:54 
 */
@Transactional
@Service
public class KqzbServiceImpl implements KqzbService {
	@Resource(name="kqzbMapper")
	private KqzbMapper kqzbMapper;
	
	
	@Override
	public Kqzb getZbid(Kqzb kqzb) {
		Kqzb q = kqzbMapper.getZb(kqzb);
		if(q != null){
			q.setSaved(true);
			return q;
		}else{
			kqzb.setSaved(false);
			kqzb.setScdate(new Date());
			kqzb.setKqid(UUID.randomUUID().toString());
			System.out.println(kqzb);
			kqzbMapper.addZb(kqzb);
			List<Kqfb> list = kqzbMapper.getFbxxNew(kqzb);
			/*if(kqzb.getBmlx().equals("0103")){
				list = kqzbMapper.getXcFbxx(kqzb);
			}else{
				list = kqzbMapper.getFbxx(kqzb);
			}*/
			
			for(int i=0 ; i<list.size() ;){
				System.out.println(list.size()+"==="+i);
				Kqfb k = new Kqfb();
				String sql1 = "INSERT INTO RCYH_KQFB(KQID,RYID";
				String sql2 = "VALUES('"+kqzb.getKqid()+"','"+list.get(i).getRyid()+"'";
				int j=i;
				for(; j<list.size() ; j++){
					if(j!=i && list.get(j).getRyid() != list.get(j-1).getRyid()){
						break;
					}else{
						sql1 +=",d"+(list.get(j).getZytime().getDate());
						sql2 += ",'"+list.get(j).getKq()+"'";
					}
				}
				i=j;
				sql1 += ") ";
				sql2 += ")";
				k.setSql(sql1 + sql2);
				kqzbMapper.addFb(k);
			}
			return kqzb;
		}
	}

}
