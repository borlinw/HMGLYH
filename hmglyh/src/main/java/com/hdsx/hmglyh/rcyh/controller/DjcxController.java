package com.hdsx.hmglyh.rcyh.controller;

import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import jxl.Workbook;
import jxl.format.Border;
import jxl.format.BorderLineStyle;
import jxl.format.UnderlineStyle;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.hdsx.hmglyh.rcyh.base.BaseAction;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhBasicRoad;
import com.hdsx.hmglyh.rcyh.dao.model.RcyhDjcx;
import com.hdsx.hmglyh.rcyh.service.RcyhDjcxService;
import com.hdsx.hmglyh.util.EasyUIPage;
import com.hdsx.hmglyh.util.JsonUtils;
import com.hdsx.hmglyh.util.ResponseUtils;

/**  
 *  冬季除雪Controller - 只是请求回来获取一下当前登录的用户信息
 *  2015-07-26增加冬季除雪-除雪快报表的相关数据
 * @author LiRui
 * @created 2015年7月8日 下午2:31:36 
 */
@Controller
@Scope(value="request")
public class DjcxController extends BaseAction {

	private static final long serialVersionUID = 2332065768039466052L;

	@Resource(name="rcyhDjcxServiceImpl")
	private RcyhDjcxService service;

	//相关参数声明
	private RcyhDjcx model = new RcyhDjcx();
	private String kbid;				//快报ID（UUID主键）
	private String bmcode;			//填报单位
	private Date tbdate;				//填报日期
	private String tbusername;	//填报人用户名
	private String tbrxm;				//填报人姓名
	private String shrxm;				//审核人姓名
	private String lxcode;			//路线编码
	private String lxname;			//路线名称
	private double wd;					//温度
	private String qzzh;				//起止桩号
	private String qzzhStr;			//用于计算里程（高速公路、一级公路 ^ 格式：370.123-385.001###402.1554-415.501）
	private Date jxsj;					//降雪时间
	private String jxsjStr;			//降雪时间Str（用于添加/编辑时传递带时分的日期）
	private Date txsj;					//停雪时间
	private String txsjStr;			//停雪时间Str（用于添加/编辑时传递带时分的日期）
	private double cxsj;				//持续时间
	private double pjhd;				//平均厚度
	private String cxfl;				//降雪（除雪）分类
	private double cxlc;				//除雪里程
	private Date stime;					//除雪开始时间
	private String stimeStr;		//除雪开始时间Str（用于添加/编辑时传递带时分的日期）
	private Date etime;					//除雪结束时间
	private String etimeStr;		//除雪结束时间Str（用于添加/编辑时传递带时分的日期）
	private double chuxsj;			//除雪时间（小时）
	private double cxmj;				//除雪面积
	private double cxl;					//除雪量（自动计算）
	private double rggr;				//人工工日
	private double jxtb;				//机械台班
	private double cxyysl;				//除雪用盐数量
	private double cxyydj;			//除雪用盐单价
	private double cxyyfy;			//除雪用盐费用
	private double rxjsl;				//融雪剂数量
	private double rxjdj;				//融雪剂单件
	private double rxjfy;				//融雪剂费用
	private double gssl;					//滚刷数量
	private double gsdj;				//滚刷单价
	private double gsfy;				//滚刷费用
	private double dpsl;				//刀片数量
	private double dpdj;				//刀片单价
	private double dpfy;				//刀片费用
	private double qysl;					//汽油数量
	private double qydj;				//汽油单价
	private double qyfy;				//汽油费用
	private double cysl;					//柴油数量
	private double cydj;				//柴油单价
	private double cyfy;				//柴油费用
	private double qtsl;					//其他数量
	private double qtdj;				//其他单价
	private double qtfy;				//其他费用
	private double fyhj;				//费用合计
	private String nz;					//备注
	private String ldcode;			//路段编码
	private String state;				//编辑状态
	private String cxrs;				//除雪人数：备注中的除雪人数
	private String jxcl;					//机械车辆：备注中的除雪车辆前部合计数量
	
	private boolean toAdd = false;//用于添加/查看/编辑“除雪快报”
	private boolean toView = false;//用于添加/查看/编辑“除雪快报”
	private boolean toEdit = false;//用于添加/查看/编辑“除雪快报”
	private String nowDate = "";//用于添加时显示当前日期

	//导出用
	private String fileName;		//文件名（除去后缀名）
	private OutputStream fileStream;	//下载使用的文件流
	private String type = "xls";	//文件类型（文件后缀名）

	/**
	 * 冬季除雪主页
	 * 描述：唯一的页面
	 * @return 当前登陆用户的用户信息
	 */
	@SuppressWarnings("deprecation")
	public String index(){
		System.out.println("--冬季除雪--冬季除雪--冬季除雪--");
		return getResultname();
	}

	/**
	 * （添加/查看）除雪快报信息的操作
	 * 描述：用于跳转至addCxkb.jsp页面
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public String addCxkb(){
		if(toAdd){
			nowDate = new SimpleDateFormat("yyyy年MM月dd日").format(new Date());
			System.out.println("--添加冬季除雪快报--添加冬季除雪快报--添加冬季除雪快报--");
		}
		if(toView){
			RcyhDjcx cx = new RcyhDjcx();
			cx.setKbid(kbid);
			model = service.queryOneCxkbByKbid(cx);
			String nzStr = model.getNz();
			String nzArray[] = nzStr.split("###");
			model.setNzCxrs(nzArray[0]);	//备注：除雪人数
			model.setNzCxcl(nzArray[1]);	//备注：除雪车辆
			model.setNzCxmj(nzArray[2]);	//备注：除雪面积
			model.setNzCxl(nzArray[3]);		//备注：除雪量
			System.out.println("--查看冬季除雪快报--查看冬季除雪快报--查看冬季除雪快报--");
		}
		if(toEdit){
			RcyhDjcx cx = new RcyhDjcx();
			cx.setKbid(kbid);
			model = service.queryOneCxkbByKbid(cx);
			//拆分“起止桩号”
			String qzzhArray[] = model.getQzzh().split("、");
			qzzhStr = "";
			for(int i = 0; i<qzzhArray.length;i++){
				if(i == 0){
					qzzhStr = dealZh(qzzhArray[i]);//处理桩号的代码
				}else{
					qzzhStr = qzzhStr + "###" + dealZh(qzzhArray[i]);//处理桩号的代码
				}
			}
			model.setQzzhStr(qzzhStr);
			//拆分备注
			String nzStr = model.getNz();
			String nzArray[] = nzStr.split("###");
			model.setNzCxrs(nzArray[0]);	//备注：除雪人数
			model.setNzCxcl(nzArray[1]);	//备注：除雪车辆
			model.setNzCxmj(nzArray[2]);	//备注：除雪面积
			model.setNzCxl(nzArray[3]);		//备注：除雪量
			System.out.println("--查看冬季除雪快报--查看冬季除雪快报--查看冬季除雪快报--");
		}
		return getResultname();
	}

	//处理桩号（将K1+000-K123+050处理成1.000-123.050）
	public String dealZh(String zhStr){
		String zhOne = dealZh2(zhStr.split("-")[0]);
		String zhTwo = dealZh2(zhStr.split("-")[1]);
		String zh = zhOne + "-" + zhTwo;
		return zh;
	}

	//处理桩号（将K123+050处理成123.050）
	public String dealZh2(String zh){
		String zhStr[] = zh.split("\\+");
		zh = zhStr[0].substring(1, zhStr[0].length()) + "." + zhStr[1];
		return zh;
	}

	/**
	 * 查询全部
	 */
	public void queryAllCxkbBySome(){
	//public void queryAllCxkbBySome(){
		try{
			//将相关查询参数set如实体中
			//model.setKbid(kbid);
			model.setPage(page+"");
			model.setRows(rows+"");
			model.setBmcode(getUser().getBmcode());//从Session中取出部门信息
			List<RcyhDjcx> modelList = service.selectAllDjcxBySome(model);
			EasyUIPage<RcyhDjcx> ep = new EasyUIPage<RcyhDjcx>();
			int n = service.countAllDjcxBySome(model);
			ep.setRows(modelList);
			ep.setTotal(n);
			JsonUtils.write(ep, getResponse().getWriter(),new String[] { "hibernateLazyInitializer" },"yyyy-MM-dd HH:mm:ss");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 添加（除雪快报）
	 */
	public void addOneCxkb(){
		try{
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			String kbidUUID = UUID.randomUUID().toString();
			model.setKbid(kbidUUID);
			model.setBmcode(getUser().getBmcode());//从Session中取出部门编码
			//model.setTbdate(new Date());//默认填报时间为当前时间（正式发布最好是这样子。）
			model.setTbdate(tbdate);//接收从前台回传的填报日期。
			model.setTbusername(getUser().getUsername());//从Session中取出登陆人用户名
			model.setTbrxm(getUser().getRyname());//从Session中取出填报人姓名
			model.setShrxm(shrxm);
			model.setLxcode(lxcode);
			model.setLxname(lxname);
			model.setWd(wd);
			model.setQzzh(qzzh);
			model.setQzzhStr(qzzhStr);
			model.setJxsj(sf.parse(jxsjStr));
			model.setTxsj(sf.parse(txsjStr));
			model.setCxsj(cxsj);
			model.setPjhd(pjhd);
			model.setCxfl(cxfl);
			model.setCxlc(cxlc);
			model.setStime(sf.parse(stimeStr));
			model.setEtime(sf.parse(etimeStr));
			model.setChuxsj(chuxsj);
			model.setCxmj(cxmj);
			model.setCxl(cxl);
			model.setRggr(rggr);
			model.setJxtb(jxtb);
			model.setCxyysl(cxyysl);
			model.setCxyydj(cxyydj);
			model.setCxyyfy(cxyyfy);
			model.setRxjsl(rxjsl);
			model.setRxjdj(rxjdj);
			model.setRxjfy(rxjfy);
			model.setGssl(gssl);
			model.setGsdj(gsdj);
			model.setGsfy(gsfy);
			model.setDpsl(dpsl);
			model.setDpdj(dpdj);
			model.setDpfy(dpfy);
			model.setQysl(qysl);
			model.setQydj(qydj);
			model.setQyfy(qyfy);
			model.setCysl(cysl);
			model.setCydj(cydj);
			model.setCyfy(cyfy);
			model.setQtsl(qtsl);
			model.setQtdj(qtdj);
			model.setQtfy(qtfy);
			model.setFyhj(fyhj);
			String nzStr = nz.replaceAll("xxxxx","+");
			model.setNz(nzStr);
			model.setLdcode(ldcode);//加入路段编码
			double zslc = convertIntoRoad(model);//折算里程（合成二级公路之后的里程）
			System.out.println("折合成二级公路后的总里程为："+zslc);
			model.setZslc(zslc);
			//2016-06-15新加备注
			if(!("".equals(cxrs))){model.setCxrs(cxrs);}
			if(!("".equals(jxcl))){model.setJxcl(jxcl);}
			if(service.addOneDjcx(model)){
				ResponseUtils.write(getResponse(), "true");
			}else{
				ResponseUtils.write(getResponse(), "true");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 将一段或者多段路折合成二级公路
	 */
	public double convertIntoRoad(RcyhDjcx cx){
		double qblc = 0.0;//全部里程（当前除雪快报起止桩号之中折合成二级公路之后的总里程数）
		String qzzhStrArray[] = cx.getQzzhStr().split("###");//拆分桩号信息：370.123-385.001###402.1554-415.501
		for(int i = 0;i<qzzhStrArray.length;i++){
			String zhdata[] = qzzhStrArray[i].split("-");//拆分桩号数据：378.152-470.123
			double startZh = Double.parseDouble(zhdata[0]);//桩号赋值（起点桩号）
			double endZh = Double.parseDouble(zhdata[1]);//桩号赋值（止点桩号）
			if((startZh - endZh) > 0){//如果止点桩号小于起点桩号
				//交换两个桩号信息
				double aaa = startZh;
				startZh = endZh;
				endZh = aaa;
			}
			qblc = qblc+endZh-startZh;//将里程（桩号段之间的距离加入总里程中）
			RcyhBasicRoad  br = new RcyhBasicRoad();
			br.setRoadcode(cx.getLxcode());//路线编码
			br.setRoadstart(startZh);
			br.setRoadends(endZh);
			RcyhBasicRoad rbr = service.selectAllRoadByRoadcode(br);
			if(rbr != null){
				double lc = rbr.getLc();//计算其中“高速、一级”公路的里程
				qblc = qblc+lc;
			}
		}
		DecimalFormat df = new DecimalFormat("#.000");
		double qblc2 = Double.parseDouble(df.format(qblc));
		return qblc2;
	}

	/**
	 * 计算某段路的除雪面积
	 */
	public void countCxmj(){
		try{
			double mjAll = 0.0;//计算总面积
			String qzzhStrArray[] = qzzhStr.split("XXX");//拆分桩号信息：370.123-385.001###402.1554-415.501
			for(int i = 0;i<qzzhStrArray.length;i++){
				String zhdata[] = qzzhStrArray[i].split("-");//拆分桩号数据：378.152-470.123
				double startZh = Double.parseDouble(zhdata[0]);//桩号赋值（起点桩号）
				double endZh = Double.parseDouble(zhdata[1]);//桩号赋值（止点桩号）
				if((startZh - endZh) > 0){//如果止点桩号小于起点桩号
					//交换两个桩号信息
					double aaa = startZh;
					startZh = endZh;
					endZh = aaa;
				}
				RcyhBasicRoad  br = new RcyhBasicRoad();
				br.setRoadcode(lxcode);//路线编码
				br.setRoadstart(startZh);
				br.setRoadends(endZh);
				RcyhBasicRoad rbr = service.countCxmj(br);
				if(rbr != null){
					mjAll = mjAll + rbr.getMj();//取出计算好的除雪面积
				}
			}
			ResponseUtils.write(getResponse(), mjAll+"");
		}catch(Exception e){
			ResponseUtils.write(getResponse(), "error");
			e.printStackTrace();
		}
	}

	/**
	 * 删除
	 */
	public void deleteOneCxkb(){
		model.setKbid(kbid);
		if(service.deldeteOneDjcx(model)){
			ResponseUtils.write(getResponse(), "true");
		}else{
			ResponseUtils.write(getResponse(), "true");
		}
	}

	/**
	 * 根据除雪快报ID导出除雪快报
	 */
	public void exportCxkb(){
		try{
			//请求除雪快报数据
			RcyhDjcx cx = new RcyhDjcx();
			model.setKbid(kbid);
			cx = service.queryOneCxkbByKbid(model);
			if(cx == null || cx.getKbid() == null){
				throw new Exception("请求“通知单数据出错。”");
			}
			//获取输出流
			OutputStream os = getResponse().getOutputStream();
			//创建工作薄（Excel）
			WritableWorkbook workbook = Workbook.createWorkbook(os);
			//WritableWorkbook workbook = Workbook.createWorkbook(new File("C:/Users/Administrator/Desktop/测试.xls"));
			WritableSheet sheet = workbook.createSheet("除雪快报表", 0);//根据Excel创建一个Excel的sheet
			sheet.mergeCells(0, 0, 6, 0);//添加合并单元格，第一个参数是起始列，第二个参数是起始行，第三个参数是终止列，第四个参数是终止行
			//给所有列设置默认宽度
			//sheet.getSettings().setDefaultColumnWidth(20);
			sheet.setColumnView(0, 9);
			sheet.setColumnView(1, 9);
			sheet.setColumnView(2, 16);
			sheet.setColumnView(3, 15);
			sheet.setColumnView(4, 16);
			sheet.setColumnView(5, 15);
			sheet.setColumnView(6, 8);
			//设置表头（水平、垂直居中）
			WritableFont bold = new WritableFont(WritableFont.ARIAL,25,WritableFont.BOLD);
			WritableCellFormat titleFormate = new WritableCellFormat(bold);//生成一个单元格样式控制对象
			titleFormate.setAlignment(jxl.format.Alignment.CENTRE);//水平居中
			titleFormate.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);//垂直居中
			Label title = new Label(0,0,"哈密公路管理局冬季除雪快报",titleFormate);
			sheet.setRowView(0, 800, false);//设置第一行的高度（表头）
			sheet.addCell(title);
			//填表单位，填表日期
			sheet.setRowView(1, 600, false);//设置行的高度
			sheet.mergeCells(0, 1, 2, 1);//合并单元格：填表单位
			Label title2 = new Label(0,1," 填表单位："+cx.getBmname());
			sheet.addCell(title2);
			sheet.mergeCells(3, 1, 6, 1);//合并单元格：填报日期
			//添加“填报日期”的单元格格式：水平居中
			WritableCellFormat title3WCF = new WritableCellFormat();//生成一个单元格样式控制对象
			title3WCF.setAlignment(jxl.format.Alignment.CENTRE);//单元格水平居中
			Label title3 = new Label(3,1,"填报日期："+cx.getTbdateStr()+" ",title3WCF);
			sheet.addCell(title3);
			//正文格式（表中固有内容）：水平、垂直居中，全边框，加粗
				//设置字体属性：宋体，10号字，加粗，非斜体，无下划线，黑色字
			WritableFont wf = new WritableFont(WritableFont.createFont("宋体") ,10,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.BLACK); 
			WritableCellFormat textTitleWCF = new WritableCellFormat(wf);//生成一个单元格样式控制对象
			textTitleWCF.setAlignment(jxl.format.Alignment.CENTRE);//水平居中
			textTitleWCF.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);//垂直居中
			textTitleWCF.setBorder(Border.ALL, BorderLineStyle.THIN);//设置全边框
			//正文格式（数据库获取的数据）：水平、垂直居中，全边框
			WritableCellFormat textWCF = new WritableCellFormat();//生成一个单元格样式控制对象
			textWCF.setAlignment(jxl.format.Alignment.CENTRE);//水平居中
			textWCF.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);//垂直居中
			textWCF.setBorder(Border.ALL, BorderLineStyle.THIN);//设置全边框
			
			//正文内容开始
				//正文第一行
			sheet.setRowView(2, 600, false);//设置行的高度
			sheet.mergeCells(0, 2, 1, 2);//合并单元格：表中固有内容（路线名称）
			Label lxnameTitle = new Label(0,2,"路线名称",textTitleWCF);
			sheet.addCell(lxnameTitle);
			Label lxname = new Label(2,2,cx.getRoadName(),textWCF);
			sheet.addCell(lxname);
			Label lxcodeTitle = new Label(3,2,"路线名称",textTitleWCF);
			sheet.addCell(lxcodeTitle);
			sheet.mergeCells(4, 2, 6, 2);//合并单元格：数据库数据（路线编号）
			Label lxcode = new Label(4,2,cx.getLxcode(),textWCF);
			sheet.addCell(lxcode);
				//正文第二行
			sheet.setRowView(3, 600, false);//设置行的高度
			sheet.mergeCells(0, 3, 1, 3);//合并单元格：表中固有内容（温度）
			Label wdTitle = new Label(0,3,"温度",textTitleWCF);
			sheet.addCell(wdTitle);
			Label wd = new Label(2,3,cx.getWd()+"",textWCF);
			sheet.addCell(wd);
			Label qzzhTitle = new Label(3,3,"起止桩号",textTitleWCF);
			sheet.addCell(qzzhTitle);
			sheet.mergeCells(4, 3, 6, 3);//合并单元格：数据库数据（起止桩号）
			Label qzzh = new Label(4,3,cx.getQzzh(),textWCF);
			sheet.addCell(qzzh);
				//正文第三行
			sheet.setRowView(4, 600, false);//设置行的高度
			sheet.mergeCells(0, 4, 1, 4);//合并单元格：表中固有内容（降雪时间）
			Label jxsjTitle = new Label(0,4,"降雪时间",textTitleWCF);
			sheet.addCell(jxsjTitle);
			Label jxsj = new Label(2,4,cx.getJxsjStr(),textWCF);
			sheet.addCell(jxsj);
			Label txsjTitle = new Label(3,4,"停雪时间",textTitleWCF);
			sheet.addCell(txsjTitle);
			Label txsj = new Label(4,4,cx.getTxsjStr(),textWCF);
			sheet.addCell(txsj);
			Label cxsjTitle = new Label(5,4,"持续时间（h）",textTitleWCF);
			sheet.addCell(cxsjTitle);
			Label cxsj = new Label(6,4,cx.getCxsj()+"",textWCF);
			sheet.addCell(cxsj);
			//正文第四行
			sheet.setRowView(5, 600, false);//设置行的高度
			sheet.mergeCells(0, 5, 1, 5);//合并单元格：表中固有内容（平均厚度cm）
			Label pjhdTitle = new Label(0,5,"平均厚度（cm）",textTitleWCF);
			sheet.addCell(pjhdTitle);
			Label pjhd = new Label(2,5,cx.getPjhd()+"",textWCF);
			sheet.addCell(pjhd);
			Label cxflTitle = new Label(3,5,"降雪分类",textTitleWCF);
			sheet.addCell(cxflTitle);
			Label cxfl = new Label(4,5,cx.getCxflStr(),textWCF);
			sheet.addCell(cxfl);
			Label cxlcTitle = new Label(5,5,"除雪里程（km）",textTitleWCF);
			sheet.addCell(cxlcTitle);
			Label cxlc = new Label(6,5,cx.getCxlc()+"",textWCF);
			sheet.addCell(cxlc);
			//正文第五行
			sheet.setRowView(6, 600, false);//设置行的高度
			sheet.mergeCells(0, 6, 1, 6);//合并单元格：表中固有内容（除雪开始时间）
			Label stimeTitle = new Label(0,6,"除雪开始时间",textTitleWCF);
			sheet.addCell(stimeTitle);
			Label stime = new Label(2,6,cx.getStimeStr(),textWCF);
			sheet.addCell(stime);
			Label etimeTitle = new Label(3,6,"除雪结束时间",textTitleWCF);
			sheet.addCell(etimeTitle);
			Label etime = new Label(4,6,cx.getEtimeStr(),textWCF);
			sheet.addCell(etime);
			Label chuxsjTitle = new Label(5,6,"除雪时间（h）",textTitleWCF);
			sheet.addCell(chuxsjTitle);
			Label chuxsj = new Label(6,6,cx.getChuxsj()+"",textWCF);
			sheet.addCell(chuxsj);
				//正文第六行
			sheet.setRowView(7, 600, false);//设置行的高度
			sheet.mergeCells(0, 7, 1, 7);//合并单元格：表中固有内容（除雪面积㎡）
			Label cxmjTitle = new Label(0,7,"除雪面积（㎡）",textTitleWCF);
			sheet.addCell(cxmjTitle);
			Label cxmj = new Label(2,7,cx.getCxmj()+"",textWCF);
			sheet.addCell(cxmj);
			Label cxlTitle = new Label(3,7,"除雪量（m³）",textTitleWCF);
			sheet.addCell(cxlTitle);
			sheet.mergeCells(4, 7, 6, 7);//合并单元格：数据库数据（除雪量）
			Label cxl = new Label(4,7,cx.getCxl()+"",textWCF);
			sheet.addCell(cxl);
				//正文第七行：只有“工料机消耗”
				//设置字体属性：宋体，15号字，加粗，非斜体，无下划线，黑色字，左右边框
			WritableFont wf2 = new WritableFont(WritableFont.createFont("宋体") ,17,WritableFont.BOLD,false,UnderlineStyle.NO_UNDERLINE,jxl.format.Colour.BLACK); 
			WritableCellFormat textTitleWCF2 = new WritableCellFormat(wf2);//生成一个单元格样式控制对象
			textTitleWCF2.setAlignment(jxl.format.Alignment.CENTRE);//水平居中
			textTitleWCF2.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);//垂直居中
				//设置左右边框
			textTitleWCF2.setBorder(Border.LEFT, BorderLineStyle.THIN);
			textTitleWCF2.setBorder(Border.RIGHT, BorderLineStyle.THIN);
			sheet.mergeCells(0, 8, 6, 8);
			sheet.setRowView(8, 700, false);//设置行的高度
			Label title4 = new Label(0,8,"工料机消耗",textTitleWCF2);
			sheet.addCell(title4);
				//正文第八行
			sheet.setRowView(9, 600, false);//设置行的高度
			sheet.mergeCells(0, 9, 1, 9);//合并单元格
			Label name = new Label(0,9,"名   称",textTitleWCF);
			sheet.addCell(name);
			Label sl = new Label(2,9,"数  量",textWCF);
			sheet.addCell(sl);
			Label dj = new Label(3,9,"单   价",textTitleWCF);
			sheet.addCell(dj);
			sheet.mergeCells(4, 9, 6, 9);//合并单元格
			Label fy = new Label(4,9,"费  用（元）",textWCF);
			sheet.addCell(fy);
				//正文第九行
			sheet.setRowView(10, 600, false);//设置行的高度
			sheet.mergeCells(0, 10, 1, 10);//合并单元格
			Label rggrTitle = new Label(0,10,"人工工日",textTitleWCF);
			sheet.addCell(rggrTitle);
			Label rggr = new Label(2,10,cx.getRggr()+"",textWCF);
			sheet.addCell(rggr);
			sheet.addCell(new Label(3,10,"\\",textTitleWCF));
			sheet.mergeCells(4, 10, 6, 10);//合并单元格
			sheet.addCell(new Label(4,10,"\\",textWCF));
				//正文第十行
			sheet.setRowView(11, 600, false);//设置行的高度
			sheet.mergeCells(0, 11, 1, 11);//合并单元格
			sheet.addCell(new Label(0,11,"机械台班",textTitleWCF));
			sheet.addCell(new Label(2,11,cx.getJxtb()+"",textWCF));
			sheet.addCell(new Label(3,11,"\\",textTitleWCF));
			sheet.mergeCells(4, 11, 6, 11);//合并单元格
			sheet.addCell(new Label(4,11,"\\",textWCF));
				//正文第十一行
			sheet.setRowView(12, 600, false);//设置行的高度
			sheet.mergeCells(0, 12, 1, 12);//合并单元格
			sheet.addCell(new Label(0,12,"除雪用盐（t）",textTitleWCF));
			sheet.addCell(new Label(2,12,cx.getCxyysl()+"",textWCF));
			sheet.addCell(new Label(3,12,cx.getCxyydj()+"",textTitleWCF));
			sheet.mergeCells(4, 12, 6, 12);//合并单元格
			sheet.addCell(new Label(4,12,cx.getCxyyfy()+"",textWCF));
				//正文第十二行
			sheet.setRowView(13, 600, false);//设置行的高度
			sheet.mergeCells(0, 13, 1, 13);//合并单元格
			sheet.addCell(new Label(0,13,"融雪剂（t）",textTitleWCF));
			sheet.addCell(new Label(2,13,cx.getRxjsl()+"",textWCF));
			sheet.addCell(new Label(3,13,cx.getRxjdj()+"",textTitleWCF));
			sheet.mergeCells(4, 13, 6, 13);//合并单元格
			sheet.addCell(new Label(4,13,cx.getRxjfy()+"",textWCF));
				//正文第十三行
				//新加（滚刷）
			sheet.setRowView(14, 600, false);//设置行的高度
			sheet.mergeCells(0, 14, 1, 14);//合并单元格
			sheet.addCell(new Label(0,14,"滚刷（副）",textTitleWCF));
			sheet.addCell(new Label(2,14,cx.getGssl()+"",textWCF));
			sheet.addCell(new Label(3,14,cx.getGsdj()+"",textTitleWCF));
			sheet.mergeCells(4, 14, 6, 14);//合并单元格
			sheet.addCell(new Label(4,14,cx.getGsfy()+"",textWCF));
				//正文第十四行
			sheet.setRowView(15, 600, false);//设置行的高度
			sheet.mergeCells(0, 15, 1, 15);//合并单元格
			sheet.addCell(new Label(0,15,"刀片（副）",textTitleWCF));
			/*sheet.addCell(new Label(1,15,"修斯除雪车",textTitleWCF));*/
			sheet.addCell(new Label(2,15,cx.getDpsl()+"",textWCF));
			sheet.addCell(new Label(3,15,cx.getDpdj()+"",textTitleWCF));
			sheet.mergeCells(4, 15, 6, 15);//合并单元格
			sheet.addCell(new Label(4,15,cx.getDpfy()+"",textWCF));
				//正文第十五行
			sheet.setRowView(16, 600, false);//设置行的高度
			sheet.mergeCells(0, 16, 0, 17);//合并单元格
			sheet.addCell(new Label(0,16,"油料（L）",textTitleWCF));
			sheet.addCell(new Label(1,16,"汽油 93#",textTitleWCF));
			sheet.addCell(new Label(2,16,cx.getQysl()+"",textWCF));
			sheet.addCell(new Label(3,16,cx.getQydj()+"",textTitleWCF));
			sheet.mergeCells(4, 16, 6, 16);//合并单元格
			sheet.addCell(new Label(4,16,cx.getQyfy()+"",textWCF));
				//正文第十六行
			sheet.setRowView(17, 600, false);//设置行的高度
			sheet.addCell(new Label(1,17,"柴油 0#",textTitleWCF));
			sheet.addCell(new Label(2,17,cx.getCysl()+"",textWCF));
			sheet.addCell(new Label(3,17,cx.getCydj()+"",textTitleWCF));
			sheet.mergeCells(4, 17, 6, 17);//合并单元格
			sheet.addCell(new Label(4,17,cx.getCyfy()+"",textWCF));
				//正文第十七行
			sheet.setRowView(18, 600, false);//设置行的高度
			sheet.mergeCells(0, 18, 1, 18);//合并单元格
			sheet.addCell(new Label(0,18,"其他",textTitleWCF));
			sheet.addCell(new Label(2,18,cx.getQtsl()+"",textWCF));
			sheet.addCell(new Label(3,18,cx.getQtdj()+"",textTitleWCF));
			sheet.mergeCells(4, 18, 6, 18);//合并单元格
			sheet.addCell(new Label(4,18,cx.getQtfy()+"",textWCF));
				//正文第十八行
			sheet.setRowView(19, 600, false);//设置行的高度
			sheet.mergeCells(0, 19, 1, 19);//合并单元格
			sheet.addCell(new Label(0,19,"费用合计（元）",textTitleWCF));
			sheet.mergeCells(2, 19, 6, 19);//合并单元格
			sheet.addCell(new Label(2,19,cx.getFyhj()+"",textWCF));
				//正文第十九行
			sheet.setRowView(20, 400, false);//设置行的高度
			sheet.setRowView(21, 400, false);//设置行的高度
			sheet.setRowView(22, 400, false);//设置行的高度
			sheet.setRowView(23, 400, false);//设置行的高度
			sheet.mergeCells(0, 20, 0, 23);//合并单元格
			sheet.addCell(new Label(0,20,"备注",textTitleWCF));
			sheet.mergeCells(1, 20, 6, 20);//合并单元格
			sheet.mergeCells(1, 21, 6, 21);//合并单元格
			sheet.mergeCells(1, 22, 6, 22);//合并单元格
			sheet.mergeCells(1, 23, 6, 23);//合并单元格
			WritableCellFormat textWCF1 = new WritableCellFormat();//生成一个单元格样式控制对象（右、下边框）
			textWCF1.setAlignment(jxl.format.Alignment.LEFT);//水平靠左
			textWCF1.setVerticalAlignment(jxl.format.VerticalAlignment.TOP);//垂直靠上
			textWCF1.setBorder(Border.RIGHT, BorderLineStyle.THIN);//设置右边框
			textWCF1.setBorder(Border.BOTTOM, BorderLineStyle.THIN);//设置下边框
			WritableCellFormat textWCF2 = new WritableCellFormat();//生成一个单元格样式控制对象（右边框）
			textWCF2.setAlignment(jxl.format.Alignment.LEFT);//水平靠左
			textWCF2.setVerticalAlignment(jxl.format.VerticalAlignment.TOP);//垂直靠上
			textWCF2.setBorder(Border.RIGHT, BorderLineStyle.THIN);//设置右边框
			//sheet.addCell(new Label(1,20,cx.getNz(),textWCF1));
			//处理”备注“问题
			String nzStr = cx.getNz();
			String nzArray[] = nzStr.split("###");
			if(!("".equals(cxrs))){model.setCxrs(cxrs);}
			if(!("".equals(jxcl))){model.setJxcl(jxcl);}
			String newCxrs = "";//除雪人数
			String newCxcl = "";//除雪车辆
			if(cx.getCxrs() == null || "".equals(cx.getCxrs())){
				newCxrs = "除雪人数：" + nzArray[0];
			}else{
				newCxrs = "除雪人数：" + cx.getCxrs() + "人。";
			}
			if(cx.getJxcl() == null || "".equals(cx.getJxcl())){
				newCxcl = "除雪车辆：" + nzArray[1];
			}else{
				newCxcl = "除雪车辆：机械车共" + cx.getJxcl() + "辆。" + nzArray[1];
			}
			sheet.addCell(new Label(1,20,newCxrs,textWCF2));
			sheet.addCell(new Label(1,21,newCxcl,textWCF2));
			//sheet.addCell(new Label(1,20,"除雪人数："+nzArray[0],textWCF2));
			//sheet.addCell(new Label(1,21,"除雪车辆："+nzArray[1],textWCF2));
			sheet.addCell(new Label(1,22,"除雪面积："+nzArray[2],textWCF2));
			sheet.addCell(new Label(1,23,"除雪量："+nzArray[3],textWCF1));
				//表格底部：审核、填报人
			//设置底部单元格样式
			WritableCellFormat bottomWCF = new WritableCellFormat();//生成一个单元格样式控制对象
			bottomWCF.setAlignment(jxl.format.Alignment.LEFT);//水平居中
			sheet.setRowView(24, 400, false);//设置行的高度
			sheet.mergeCells(1, 24, 2, 24);//合并单元格
			sheet.addCell(new Label(1,24,"审核："+cx.getShrxm(),bottomWCF));
			sheet.mergeCells(5, 24, 6, 24);//合并单元格
			sheet.addCell(new Label(5,24,"填报人："+cx.getTbrxm(),bottomWCF));

			//处理文件名以及设置Response方式
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String fileNameStr = "除雪快报表"+cx.getLxcode()+sdf.format(cx.getStime())+".xls";
			System.out.println("处理好的带日期参数的文件名为："+fileNameStr);
			fileName = new String(fileNameStr.getBytes("UTF-8"), "ISO-8859-1");
			getResponse().setHeader("Content-disposition", "attachment;filename=" + fileName);
			//将内容输出并关闭输出流
			workbook.write();
			workbook.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 编辑（除雪快报）
	 */
	public void editOneCxkb(){
		try{
			SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
			model.setKbid(kbid);
			model.setShrxm(shrxm);
			model.setLxcode(lxcode);
			model.setLxname(lxname);
			model.setWd(wd);
			model.setQzzh(qzzh);
			model.setQzzhStr(qzzhStr);
			model.setJxsj(sf.parse(jxsjStr));
			model.setTxsj(sf.parse(txsjStr));
			model.setCxsj(cxsj);
			model.setPjhd(pjhd);
			model.setCxfl(cxfl);
			model.setCxlc(cxlc);
			model.setStime(sf.parse(stimeStr));
			model.setEtime(sf.parse(etimeStr));
			model.setChuxsj(chuxsj);
			model.setCxmj(cxmj);
			model.setCxl(cxl);
			model.setRggr(rggr);
			model.setJxtb(jxtb);
			model.setCxyysl(cxyysl);
			model.setCxyydj(cxyydj);
			model.setCxyyfy(cxyyfy);
			model.setRxjsl(rxjsl);
			model.setRxjdj(rxjdj);
			model.setRxjfy(rxjfy);
			model.setGssl(gssl);
			model.setGsdj(gsdj);
			model.setGsfy(gsfy);
			model.setDpsl(dpsl);
			model.setDpdj(dpdj);
			model.setDpfy(dpfy);
			model.setQysl(qysl);
			model.setQydj(qydj);
			model.setQyfy(qyfy);
			model.setCysl(cysl);
			model.setCydj(cydj);
			model.setCyfy(cyfy);
			model.setQtsl(qtsl);
			model.setQtdj(qtdj);
			model.setQtfy(qtfy);
			model.setFyhj(fyhj);
			String nzStr = nz.replaceAll("xxxxx","+");
			model.setNz(nzStr);
			double zslc = convertIntoRoad(model);//折算里程（合成二级公路之后的里程）
			System.out.println("折合成二级公路后的总里程为："+zslc);
			model.setZslc(zslc);
			model.setLdcode(ldcode);//加入路段编码
			//2016-06-15新加备注
			if(!("".equals(cxrs))){model.setCxrs(cxrs);}
			if(!("".equals(jxcl))){model.setJxcl(jxcl);}
			if(service.updateOneDjcx(model)){
				ResponseUtils.write(getResponse(), "true");
			}else{
				ResponseUtils.write(getResponse(), "true");
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * 修改State值
	 * 描述：操作是否允许编辑
	 */
	public void updateDjcxState() throws Exception{
		model.setState(state);
		model.setKbid(kbid);
		if(service.updateDjcxState(model)){
			ResponseUtils.write(getResponse(), "true");
		}else{
			ResponseUtils.write(getResponse(), "true");
		}
	}

	//Get、Set方法。
	public RcyhDjcx getModel() {
		return model;
	}
	public void setModel(RcyhDjcx model) {
		this.model = model;
	}
	public String getKbid() {
		return kbid;
	}
	public void setKbid(String kbid) {
		this.kbid = kbid;
	}
	public String getBmcode() {
		return bmcode;
	}
	public void setBmcode(String bmcode) {
		this.bmcode = bmcode;
	}
	public Date getTbdate() {
		return tbdate;
	}
	public void setTbdate(Date tbdate) {
		this.tbdate = tbdate;
	}
	public String getTbusername() {
		return tbusername;
	}
	public void setTbusername(String tbusername) {
		this.tbusername = tbusername;
	}
	public String getTbrxm() {
		return tbrxm;
	}
	public void setTbrxm(String tbrxm) {
		this.tbrxm = tbrxm;
	}
	public String getShrxm() {
		return shrxm;
	}
	public void setShrxm(String shrxm) {
		this.shrxm = shrxm;
	}
	public String getLxcode() {
		return lxcode;
	}
	public void setLxcode(String lxcode) {
		this.lxcode = lxcode;
	}
	public String getLxname() {
		return lxname;
	}
	public void setLxname(String lxname) {
		this.lxname = lxname;
	}
	public double getWd() {
		return wd;
	}
	public void setWd(double wd) {
		this.wd = wd;
	}
	public String getQzzh() {
		return qzzh;
	}
	public void setQzzh(String qzzh) {
		this.qzzh = qzzh;
	}
	public Date getJxsj() {
		return jxsj;
	}
	public void setJxsj(Date jxsj) {
		this.jxsj = jxsj;
	}
	public Date getTxsj() {
		return txsj;
	}
	public void setTxsj(Date txsj) {
		this.txsj = txsj;
	}
	public double getCxsj() {
		return cxsj;
	}
	public void setCxsj(double cxsj) {
		this.cxsj = cxsj;
	}
	public double getPjhd() {
		return pjhd;
	}
	public void setPjhd(double pjhd) {
		this.pjhd = pjhd;
	}
	public String getCxfl() {
		return cxfl;
	}
	public void setCxfl(String cxfl) {
		this.cxfl = cxfl;
	}
	public double getCxlc() {
		return cxlc;
	}
	public void setCxlc(double cxlc) {
		this.cxlc = cxlc;
	}
	public Date getStime() {
		return stime;
	}
	public void setStime(Date stime) {
		this.stime = stime;
	}
	public Date getEtime() {
		return etime;
	}
	public void setEtime(Date etime) {
		this.etime = etime;
	}
	public double getChuxsj() {
		return chuxsj;
	}
	public void setChuxsj(double chuxsj) {
		this.chuxsj = chuxsj;
	}
	public double getCxmj() {
		return cxmj;
	}
	public void setCxmj(double cxmj) {
		this.cxmj = cxmj;
	}
	public double getCxl() {
		return cxl;
	}
	public void setCxl(double cxl) {
		this.cxl = cxl;
	}
	public double getRggr() {
		return rggr;
	}
	public void setRggr(double rggr) {
		this.rggr = rggr;
	}
	public double getJxtb() {
		return jxtb;
	}
	public void setJxtb(double jxtb) {
		this.jxtb = jxtb;
	}
	public double getCxyysl() {
		return cxyysl;
	}
	public void setCxyysl(double cxyysl) {
		this.cxyysl = cxyysl;
	}
	public double getCxyydj() {
		return cxyydj;
	}
	public void setCxyydj(double cxyydj) {
		this.cxyydj = cxyydj;
	}
	public double getCxyyfy() {
		return cxyyfy;
	}
	public void setCxyyfy(double cxyyfy) {
		this.cxyyfy = cxyyfy;
	}
	public double getRxjsl() {
		return rxjsl;
	}
	public void setRxjsl(double rxjsl) {
		this.rxjsl = rxjsl;
	}
	public double getRxjdj() {
		return rxjdj;
	}
	public void setRxjdj(double rxjdj) {
		this.rxjdj = rxjdj;
	}
	public double getRxjfy() {
		return rxjfy;
	}
	public void setRxjfy(double rxjfy) {
		this.rxjfy = rxjfy;
	}
	public double getGssl() {
		return gssl;
	}
	public void setGssl(double gssl) {
		this.gssl = gssl;
	}
	public double getGsdj() {
		return gsdj;
	}
	public void setGsdj(double gsdj) {
		this.gsdj = gsdj;
	}
	public double getGsfy() {
		return gsfy;
	}
	public void setGsfy(double gsfy) {
		this.gsfy = gsfy;
	}
	public double getDpsl() {
		return dpsl;
	}
	public void setDpsl(double dpsl) {
		this.dpsl = dpsl;
	}
	public double getDpdj() {
		return dpdj;
	}
	public void setDpdj(double dpdj) {
		this.dpdj = dpdj;
	}
	public double getDpfy() {
		return dpfy;
	}
	public void setDpfy(double dpfy) {
		this.dpfy = dpfy;
	}
	public double getQysl() {
		return qysl;
	}
	public void setQysl(double qysl) {
		this.qysl = qysl;
	}
	public double getQydj() {
		return qydj;
	}
	public void setQydj(double qydj) {
		this.qydj = qydj;
	}
	public double getQyfy() {
		return qyfy;
	}
	public void setQyfy(double qyfy) {
		this.qyfy = qyfy;
	}
	public double getCysl() {
		return cysl;
	}
	public void setCysl(double cysl) {
		this.cysl = cysl;
	}
	public double getCydj() {
		return cydj;
	}
	public void setCydj(double cydj) {
		this.cydj = cydj;
	}
	public double getCyfy() {
		return cyfy;
	}
	public void setCyfy(double cyfy) {
		this.cyfy = cyfy;
	}
	public double getQtsl() {
		return qtsl;
	}
	public void setQtsl(double qtsl) {
		this.qtsl = qtsl;
	}
	public double getQtdj() {
		return qtdj;
	}
	public void setQtdj(double qtdj) {
		this.qtdj = qtdj;
	}
	public double getQtfy() {
		return qtfy;
	}
	public void setQtfy(double qtfy) {
		this.qtfy = qtfy;
	}
	public double getFyhj() {
		return fyhj;
	}
	public void setFyhj(double fyhj) {
		this.fyhj = fyhj;
	}
	public String getNz() {
		return nz;
	}
	public void setNz(String nz) {
		this.nz = nz;
	}
	public boolean isToAdd() {
		return toAdd;
	}
	public void setToAdd(boolean toAdd) {
		this.toAdd = toAdd;
	}
	public boolean isToView() {
		return toView;
	}
	public void setToView(boolean toView) {
		this.toView = toView;
	}
	public String getNowDate() {
		return nowDate;
	}
	public void setNowDate(String nowDate) {
		this.nowDate = nowDate;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public OutputStream getFileStream() {
		return fileStream;
	}
	public void setFileStream(OutputStream fileStream) {
		this.fileStream = fileStream;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getQzzhStr() {
		return qzzhStr;
	}
	public void setQzzhStr(String qzzhStr) {
		this.qzzhStr = qzzhStr;
	}
	public boolean isToEdit() {
		return toEdit;
	}
	public void setToEdit(boolean toEdit) {
		this.toEdit = toEdit;
	}
	public String getJxsjStr() {
		return jxsjStr;
	}
	public void setJxsjStr(String jxsjStr) {
		this.jxsjStr = jxsjStr;
	}
	public String getTxsjStr() {
		return txsjStr;
	}
	public void setTxsjStr(String txsjStr) {
		this.txsjStr = txsjStr;
	}
	public String getStimeStr() {
		return stimeStr;
	}
	public void setStimeStr(String stimeStr) {
		this.stimeStr = stimeStr;
	}
	public String getEtimeStr() {
		return etimeStr;
	}
	public void setEtimeStr(String etimeStr) {
		this.etimeStr = etimeStr;
	}
	public String getLdcode() {
		return ldcode;
	}
	public void setLdcode(String ldcode) {
		this.ldcode = ldcode;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCxrs() {
		return cxrs;
	}
	public void setCxrs(String cxrs) {
		this.cxrs = cxrs;
	}
	public String getJxcl() {
		return jxcl;
	}
	public void setJxcl(String jxcl) {
		this.jxcl = jxcl;
	}

}
