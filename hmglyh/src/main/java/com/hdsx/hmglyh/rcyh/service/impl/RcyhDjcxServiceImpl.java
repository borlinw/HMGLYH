package com.hdsx.hmglyh.rcyh.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdsx.hmglyh.rcyh.dao.RcyhBasicRoadMapper;
import com.hdsx.hmglyh.rcyh.dao.RcyhDjcxMapper;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhBasicRoad;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhDjcx;
import com.hdsx.hmglyh.rcyh.service.RcyhDjcxService;

/**  
 *  日常养护 - 冬季除雪ServiceImpl
 * @author LiRui
 * @created 2015年7月26日 下午12:51:56 
 */
@Service 
@Transactional 
public class RcyhDjcxServiceImpl implements RcyhDjcxService {

	@Resource(name="rcyhDjcxMapper")
	private RcyhDjcxMapper mapper;
	@Resource(name="rcyhBasicRoadMapper")
	private RcyhBasicRoadMapper basicMapper;

	@Override
	public boolean addOneDjcx(RcyhDjcx cx) {
		if(mapper.addOneDjcx(cx)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public boolean deldeteOneDjcx(RcyhDjcx cx) {
		if(mapper.deldeteOneDjcx(cx)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<RcyhDjcx> selectAllDjcxBySome(RcyhDjcx cx) {
		List<RcyhDjcx> list = mapper.selectAllDjcxBySome(cx);
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分");
		//SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日");
		for(RcyhDjcx c : list){
			if(c.getTbdate() != null){
				c.setTbdateStr(sdf1.format(c.getTbdate()));
			}
			if(c.getJxsj() != null){
				c.setJxsjStr(sdf1.format(c.getJxsj()));
			}
			if(c.getTxsj() != null){
				c.setTxsjStr(sdf1.format(c.getTxsj()));
			}
			if(c.getStime() != null){
				c.setStimeStr(sdf1.format(c.getStime()));
			}
			if(c.getEtime() != null){
				c.setEtimeStr(sdf1.format(c.getEtime()));
			}
		}
		return list;
	}

	@Override
	public int countAllDjcxBySome(RcyhDjcx cx) {
		return mapper.countAllDjcxBySome(cx);
	}

	@Override
	public RcyhDjcx queryOneCxkbByKbid(RcyhDjcx cx) {
		RcyhDjcx c = mapper.queryOneCxkbByKbid(cx);
		SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日 HH:mm");
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy年MM月dd日");
		if(c.getTbdate() != null){
			c.setTbdateStr(sdf1.format(c.getTbdate()));
		}
		if(c.getJxsj() != null){
			c.setJxsjStr(sdf.format(c.getJxsj()));
		}
		if(c.getTxsj() != null){
			c.setTxsjStr(sdf.format(c.getTxsj()));
		}
		if(c.getStime() != null){
			c.setStimeStr(sdf.format(c.getStime()));
		}
		if(c.getEtime() != null){
			c.setEtimeStr(sdf.format(c.getEtime()));
		}
		return c;
	}

	@Override
	public RcyhBasicRoad selectAllRoadByRoadcode(RcyhBasicRoad road) {
		//return basicMapper.selectAllRoadByRoadcode(road);//废除连接基础库的折算里程计算
		//新添加从HTGL_LKLDHFB中计算
		return mapper.selectAllRoadByRoadcode(road);
	}

	@Override
	public boolean updateOneDjcx(RcyhDjcx cx) {
		if(mapper.updateOneDjcx(cx)>0){
			return true;
		}else{
			return false;
		}
	}

	@Override
	public RcyhBasicRoad countCxmj(RcyhBasicRoad rode) {
		return mapper.countCxmj(rode);
	}

	@Override
	public boolean updateDjcxState(RcyhDjcx cx) {
		if(mapper.updateDjcxState(cx)>0){
			return true;
		}else{
			return false;
		}
	}

}
