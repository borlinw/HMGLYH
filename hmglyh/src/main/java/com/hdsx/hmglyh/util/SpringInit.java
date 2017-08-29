package com.hdsx.hmglyh.util;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.hdsx.hmglyh.rcyh.dao.model.HtglBhlx;
import com.hdsx.hmglyh.rcyh.dao.model.HtglGljlxb;
import com.hdsx.hmglyh.rcyh.dao.model.HtglYhlxb;
import com.hdsx.hmglyh.rcyh.service.BhService;
import com.hdsx.hmglyh.rcyh.service.WxzyService;
import com.hdsx.hmglyh.rcyh.util.RcyhUtils;

public class SpringInit implements ServletContextListener {

	private static WebApplicationContext springContext;
	
	private static Logger log = LoggerFactory.getLogger(SpringInit.class);
	
	public SpringInit() {
		super();
	}

	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		
		System.out.println("context init ... ");
		springContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
		try {
				String uploadPath = springContext.getServletContext().getInitParameter("uploadPath");
			String uploadPath1 = springContext.getServletContext().getInitParameter("uploadPath1");
			String picUrl = springContext.getServletContext().getInitParameter("picUrl");
			String picUrl2 = springContext.getServletContext().getInitParameter("picUrl2");
			if(uploadPath != null){
				Constants.UploadPath = uploadPath;
			}
			if(uploadPath1!=null){
				Constants.UploadPath1 = uploadPath1;
			}
			if(picUrl != null ) {
				Constants.PicUrl = picUrl;
			}
			if(picUrl2 != null ) {
				Constants.PicUrl2 = picUrl2;
			}
			
			// 生成病害 类型树 json 文件
			HDFreeMarker fm = new HDFreeMarker("template/");
			BhService bhService = springContext.getBean(BhService.class);
			List<HtglBhlx> bhlxList = bhService.selectBhlxs();
			HashMap<String,Object> root = new HashMap<String,Object>();
			root.put("list", bhlxList);
			String path = event.getServletContext().getRealPath("/");
			fm.createJsonFile(root, "bhlxtree.ftl", path+"/template/bhlxtree.json");
		
			//WxzyService wxzyService = springContext.getBean(WxzyService.class);
			List<HtglYhlxb> yhlxlist = RcyhUtils.getYhlxTree();
			root.put("list", yhlxlist);
			fm.createJsonFile(root, "yhlxtree.ftl", path+"/template/yhlxtree.json");
			List<HtglGljlxb> cllist = RcyhUtils.getGljclTree();
			root.put("list", cllist);
			fm.createJsonFile(root, "clgljtree.ftl", path+"/template/clgljtree.json");
			List<HtglGljlxb> jxlist = RcyhUtils.getGljjxTree();
			root.put("list", jxlist);
			fm.createJsonFile(root, "jxgljtree.ftl", path+"/template/jxgljtree.json");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
