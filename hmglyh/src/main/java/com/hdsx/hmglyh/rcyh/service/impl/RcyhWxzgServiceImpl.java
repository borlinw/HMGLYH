
package com.hdsx.hmglyh.rcyh.service.impl; 
 

 
 

import java.text.SimpleDateFormat; 
 

import java.util.List; 
 

 
 


import javax.annotation.Resource; 
 

 
 


import org.springframework.stereotype.Service; 
 

import org.springframework.transaction.annotation.Transactional; 
 

 
 


import com.hdsx.hmglyh.rcyh.dao.RcyhWxzgMapper;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhWxzg;
import com.hdsx.hmglyh.rcyh.service.RcyhWxzgService;
 

 

 

 
 

/**   
 

 *  日常养护 - 维修整改（通知单/回复单）ServiceImpl 
 

 * @author LiRui 
 

 * @created 2015年6月25日 下午3:28:27  
 

 */ 
 

@Service 
 

@Transactional 
 

public class RcyhWxzgServiceImpl implements RcyhWxzgService { 
 

 
 

    @Resource(name="rcyhWxzgMapper") 
 

    private RcyhWxzgMapper mapper; 
 

 
 

    @Override 
 

    public boolean addOneTzd(RcyhWxzg zgtzd) { 
 

        if(mapper.addOneTzd(zgtzd)>0){ 
 

            return true; 
 

        }else{ 
 

            return false; 
 

        } 
 

    } 
 

 
 

    @Override 
 

    public boolean deleteOneTzd(RcyhWxzg zgtzd) { 
 

        if(mapper.deleteOneTzd(zgtzd)>0){ 
 

            return true; 
 

        }else{ 
 

            return false; 
 

        } 
 

    } 
 

 
 

    @Override 
 

    public boolean updateOneTzd(RcyhWxzg zgtzd) { 
 

        if(mapper.updateOneTzd(zgtzd)>0){ 
 

            return true; 
 

        }else{ 
 

            return false; 
 

        } 
 

    } 
 

 
 

    @Override 
 

    public List<RcyhWxzg> queryZgtzdBySome(RcyhWxzg zgtzd) { 
 

        return mapper.queryZgtzdBySome(zgtzd); 
 

    } 
 

 
 

    @Override 
 

    public int countZgtzdNumBySome(RcyhWxzg zgtzd) { 
 

        return mapper.countZgtzdNumBySome(zgtzd); 
 

    } 
 

 
 

    @Override 
 

    public boolean addOneHfd(RcyhWxzg zghfd) { 
 

        RcyhWxzg zg = new RcyhWxzg(zghfd.getTzdid(), 2); 
 

        if(mapper.updateTzdzt(zg)>0){ 
 

            if(mapper.addOneHfd(zghfd)>0){ 
 

                return true; 
 

            }else{ 
 

                return false; 
 

            } 
 

        }else{ 
 

            return false; 
 

        } 
 

    } 
 

 
 

    @Override 
 

    public boolean deleteOneHfd(RcyhWxzg zghfd) { 
 

        if(mapper.deleteOneHfd(zghfd)>0){ 
 

            return true; 
 

        }else{ 
 

            return false; 
 

        } 
 

    } 
 

 
 

    @Override 
 

    public boolean updateOneHfd(RcyhWxzg zghfd) { 
 

        if(mapper.updateOneHfd(zghfd)>0){ 
 

            return true; 
 

        }else{ 
 

            return false; 
 

        } 
 

    } 
 

 
 

    @Override 
 

    public List<RcyhWxzg> queryZghfdBySome(RcyhWxzg zghfd) { 
 

        List<RcyhWxzg> list = mapper.queryZghfdBySome(zghfd); 
 

        for(RcyhWxzg w : list){ 
 

            SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日"); 
 

            if(w.getSxtime() != null){ 
 

                String sxtimeStr = sf.format(w.getSxtime()); 
 

                w.setSxtimeStr(sxtimeStr); 
 

            } 
 

            if(w.getSdtime() != null){ 
 

                String sdtimeStr = sf.format(w.getSdtime()); 
 

                w.setSdtimeStr(sdtimeStr); 
 

            } 
 

        } 
 

        return list; 
 

    } 
 

 
 

    @Override 
 

    public int countZghfdNumBySome(RcyhWxzg zghfd) { 
 

        return mapper.countZghfdNumBySome(zghfd); 
 

    } 
 

 
 

    @Override 
 

    public boolean updateOneTzdOfJd(RcyhWxzg zgtzd) { 
 

        if(mapper.updateOneTzdOfJd(zgtzd)>0){ 
 

            return true; 
 

        }else{ 
 

            return false; 
 

        } 
 

    } 
 

 
 

    @Override 
 

    public RcyhWxzg queryOneZgtzdByTzdid(RcyhWxzg zgtzd) { 
 

        RcyhWxzg w = mapper.queryOneZgtzdByTzdid(zgtzd); 
 

        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日"); 
 

        if(w.getJdtime() != null){ 
 

            String jdtimeStr = sf.format(w.getJdtime()); 
 

            w.setJdtimeStr(jdtimeStr); 
 

        } 
 

        if(w.getSdtime() != null){ 
 

            String sdtimeStr = sf.format(w.getSdtime()); 
 

            w.setSdtimeStr(sdtimeStr); 
 

        } 
 

        return w; 
 

    } 
 

 
 

    @Override 
 

    public boolean updateOneHfdOfSh(RcyhWxzg zgtzd) { 
 

        RcyhWxzg zg = new RcyhWxzg(zgtzd.getTzdid(), zgtzd.getTzdzt()); 
 

        if(mapper.updateTzdzt(zg)>0){ 
 

            if(mapper.updateOneHfdOfSh(zgtzd)>0){ 
 

                return true; 
 

            }else{ 
 

                return false; 
 

            } 
 

        }else{ 
 

            return false; 
 

        } 
 

    } 
 

 
 

    @Override 
 

    public RcyhWxzg queryZghfdByTzdid(RcyhWxzg zgtzd) { 
 

        RcyhWxzg w = mapper.queryZghfdByTzdid(zgtzd); 
 

        SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月dd日"); 
 

        if(w.getSxtime() != null){ 
 

            String sxtimeStr = sf.format(w.getSxtime()); 
 

            w.setSxtimeStr(sxtimeStr); 
 

        } 
 

        if(w.getSdtime() != null){ 
 

            String sdtimeStr = sf.format(w.getSdtime()); 
 

            w.setSdtimeStr(sdtimeStr); 
 

        } 
 

        if(w.getHfdate() != null){ 
 

            String hfdateStr = sf.format(w.getHfdate()); 
 

            w.setHfdateStr(hfdateStr); 
 

        } 
 

        if(w.getSjwctime() != null){ 
 

            String sjwctimeStr = sf.format(w.getSjwctime()); 
 

            w.setSjwctimeStr(sjwctimeStr); 
 

        } 
 

        return w; 
 

    } 
 

 
 

    @Override 
 

    public boolean fgOfHfd(RcyhWxzg zghfd) { 
 

        RcyhWxzg zg = new RcyhWxzg(zghfd.getTzdid(), 2); 
 

        if(mapper.updateTzdzt(zg)>0){ 
 

            if(mapper.fgOfHfd(zghfd)>0){ 
 

                return true; 
 

            }else{ 
 

                return false; 
 

            } 
 

        }else{ 
 

            return false; 
 

        } 
 

    }

	@Override
	public RcyhWxzg queryTzdToExport(RcyhWxzg zgtzd) {
		RcyhWxzg tzd = mapper.queryTzdToExport(zgtzd);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 hh时");
		if(tzd.getSxtime() != null){//要求完成时间
			tzd.setSxtimeStr(sdf.format(tzd.getSxtime()));
		}
		if(tzd.getSdtime() != null){//送单时间（带小时）
			tzd.setSdtimeStr(sdf2.format(tzd.getSdtime()));
		}
		if(tzd.getJdtime() != null){//接单时间
			tzd.setJdtimeStr(sdf.format(tzd.getJdtime()));
		}
		return tzd;
	}

	@Override
	public RcyhWxzg queryHfdToExport(RcyhWxzg zgtzd) {
		RcyhWxzg hfd = mapper.queryHfdToExport(zgtzd);
		if(hfd != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
			SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 hh时");
			if(hfd.getHfdate() != null){//表正文上边的“日期”
				hfd.setHfdateStr(sdf.format(hfd.getHfdate()));
			}
			if(hfd.getSdtime() != null){//通知时间（带小时）
				hfd.setSdtimeStr(sdf2.format(hfd.getSdtime()));
			}
			if(hfd.getSxtime() != null){//要求完成时间
				hfd.setSxtimeStr(sdf.format(hfd.getSxtime()));
			}
			if(hfd.getSjwctime() != null){//实际完成时间
				hfd.setSjwctimeStr(sdf.format(hfd.getSjwctime()));
			}
			return hfd;
		}else{
			return null;
		}
	} 
 

 
 

}  
