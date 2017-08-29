var GIS_URL = document.location.protocol+"//"+document.location.host + "/hmglyh/gis/";

function c_before() {
	gisui.destroyAllWindows();
}

// 创建 管养机构窗口
function c_guanyangDW(){
	
	c_before();
	
	gisui.createWindow({
		id:"guanyangdw",
		title:"管养机构",
		iconCls:"chart",
		/*width:674,*/
		src:GIS_URL+"guanyangdw_guanyangdw.do",
		onDestroy:function(){
			map.clearLayerByWindowId("guanyangdw");
		}
	});
}

// 创建路线窗口
function c_luxian(){
	
	c_before();
	
	gisui.createWindow({
		id:"luxian",
		title:"路线",
		iconCls:"chart",
		src:GIS_URL + 'luxian_luxian.do',
		tools:"#lxtools",
		/*tabs:{
			tabs:[
			      {
			    	  title:'列表',
			    	  src:GIS_URL + 'luxian_luxian.do',
			      },
			      {
			    	  title:'专题图',
			    	  src:GIS_URL + 'luxian_zhuantitu.do'
			      }
			      ]
		},*/
		onDestroy:function(){
			map.clearLayerByWindowId("luxian");
		}
	});
}

function c_luxianchart(){
	gisui.createWindow({
		id:"tongjitu",
		title:"路线统计图",
		iconCls:"chart",
		width:920,
		height:511,
		tabs:{
			tabs:[
			      {
			    	  title:"按技术等级",
			    	  src:GIS_URL+"gis/luxian_tongjitu1.do"
			      },
			      {
			    	  title:"按路面类型",
			    	  src:GIS_URL+"gis/luxian_tongjitu2.do"
			      },
			      {
			    	  title:"按车道特征",
			    	  src:GIS_URL+"gis/luxian_tongjitu3.do"
			      }
			      ]
		}
		
	});
}

// 创建构造物窗口
function c_gouzaowu() {
	
	c_before();
	gisui.createWindow({
		id:"gouzaowu",
		title:"构造物",
		iconCls:"chart",
		tabs:{
			tabs:[
			      {
			    	  title:"桥梁",
			    	  src:GIS_URL+"gouzaowu_qiaolianglb.do?fromQl=true",
			    	  tools:"#p-qlcharts"
			      },
			      {
			    	  title:"隧道",
			    	  src:GIS_URL + "gouzaowu_suidaolb.do?fromSd=true",
			    	  tools:"#p-sdcharts"
			      },
			      {
			    	  title:"涵洞",
			    	  src:GIS_URL+"gouzaowu_handonglb.do?fromHd=true",
			    	  tools:"#p-hdcharts"
			      },
			      {
			    	  title:"路基防护",
			    	  src:GIS_URL + "gouzaowu_lujifhlb.do?fromLj=true",
			    	  tools:"#p-ljcharts"
			      }
			      ]
		},
		onDestroy:function(){
			map.clearLayerByWindowId("gouzaowu");
		}
	});
}

function c_qiaoliangCharts(){
	gisui.createWindow({
		id:"qiaoliangcharts",
		title:"桥梁专题图",
		iconCls:"chart",
		width:920,
		height:511,
		tabs:{
			tabs:[
			      {
			    	  title:"按桥梁跨径分类",
			    	  src:GIS_URL+"gouzaowu_qltongjitu1.do"
			      },
			      {
			    	  title:"按桥梁技术等级",
			    	  src:GIS_URL + "gouzaowu_qltongjitu2.do"
			      },
			      {
			    	  title:"按桥梁性质",
			    	  src:GIS_URL+"gouzaowu_qltongjitu3.do"
			      },{
			    	  title:"统计表格",
			    	  src:ip+"/page/gis/page/tj.jsp"
			      }
			      ]
		}
	});
}

function c_suidaoCharts(){
	gisui.createWindow({
		id:"suidaocharts",
		title:"隧道专题图",
		iconCls:"chart",
		width:920,
		height:511,
		tabs:{
			tabs:[
			      {
			    	  title:"按隧道技术等级",
			    	  src:GIS_URL+"gouzaowu_sdtongjitu1.do"
			      },
			      {
			    	  title:"按隧道类型",
			    	  src:GIS_URL + "gouzaowu_sdtongjitu2.do"
			      },{
			    	  title:"隧道汇总",
			    	  src:ip+"/page/gis/page/sdtj.jsp"
			      }
			      ]
		}
	});
}

function c_lujifhCharts(){
	gisui.createWindow({
		id:"lujifhcharts",
		title:"路基防护专题图",
		iconCls:"chart",
		width:920,
		height:511,
		tabs:{
			tabs:[
			      {
			    	  title:"按路基防护类型",
			    	  src:GIS_URL+"gouzaowu_ljfhlx.do"
			      },
			      {
			    	  title:"按路基防护类型（每条路线）",
			    	  src:GIS_URL + "gouzaowu_ljfhlx2.do"
			      }
			      ]
		}
	});
}

function c_handongCharts(){
	gisui.createWindow({
		id:"suidaocharts",
		title:"涵洞专题图",
		iconCls:"chart",
		width:920,
		height:511,
		tabs:{
			tabs:[
			      {
			    	  title:"按涵洞类型统计",
			    	  src:GIS_URL+"gouzaowu_hdtongjitu1.do"
			      },
			      /*{
			    	  title:"按涵洞跨径统计",
			    	  src:GIS_URL + "gouzaowu_hdtongjitu2.do"
			      },*/{
			    	  title:"涵洞汇总",
			    	  src:ip+"/page/gis/page/hdtj.jsp"
			      }
			      ]
		}
	});
}

// 创建沿线设施 窗口
/*function c_yanxianSS(){
	c_before();
	gisui.createWindow({
		id:"yanxianss",
		title:"沿线设施",
		iconCls:"chart",
		tabs:{
			tabs:[
			   
			     
			    
			     
			     
			    
			     
			     
			      ]
		}
	});
}
*/

// 沿线设施 - 交通安全设施
function c_jiaotongAQSS(){
	c_before();
	gisui.createWindow({
		id:"yanxainss",
		title:"交通安全设施",
		iconCls:"chart",
		width:530,
		tabs:{
			tabs:[
			      {
			    	  title:"交安设施",
			    	  src:GIS_URL+"yanxianss_jiaoanss.do"
			      },
			      {
			    	  title:"交通标志",
			    	  src:GIS_URL+"yanxianss_jiaotongbz.do"
			      },
			      {
			    	  title:"天桥",
			    	  src:GIS_URL+"yanxianss_tianqiao.do"
			      },
			      {
			    	  title:"路面标线",
			    	  src:GIS_URL+"yanxianss_lumianbx.do"
			      }/*,
			      {
			    	  title:"防护工程",
			    	  src:GIS_URL+"yanxianss_fanghugc.do"
			      }*/
			      ]
		},
		onDestroy:function(){
			map.clearLayerByWindowId('yanxianss');
		}
	});
}

// 沿线设施 - 交通管理设施 
function c_jiaotongGLSS(){
	c_before();
	gisui.createWindow({
		id:"yanxianss",
		title:"交通管理设施",
		iconCls:"chart",
		tabs:{
			tabs:[
			      {
			    	  title:"检查站",
			    	  src:GIS_URL+"yanxianss_jianchazhan.do"
			      },
			      {
			    	  title:"交通量观测站",
			    	  src:GIS_URL+"yanxianss_jiaotonglianggcz.do"
			      },
			      {
			    	  title:"路线多媒体点",
			    	  src:GIS_URL+"yanxianss_luxiandmtd.do"
			      }
			      ]
		},
		onDestroy:function(){
			map.clearLayerByWindowId('yanxianss');
		}
	});
}

function c_fuwuSS(){
	c_before();
	gisui.createWindow({
		id:"yanxianss",
		title:"服务设施",
		iconCls:"chart",
		tabs:{
			tabs:[
			      {
			    	  title:"服务区",
			    	  src:GIS_URL+"yanxianss_fuwuqu.do"
			      },
			      {
			    	  title:"其他服务设施",
			    	  src:GIS_URL+"yanxianss_fuwuss.do"
			      }, 
			      {
			    	  title:"收费站",
			    	  src:GIS_URL+"yanxianss_shoufeizhan.do"
			      }/*,
			      {
			    	  title:"管理机构",
			    	  src:GIS_URL+"yanxianss_guanlijg.do"
			      },
			      {
			    	  title:"养护站（养护工区）",
			    	  src:GIS_URL+"yanxianss_yanghuzhan.do"
			      }*/
			      ]
		},
		onDestroy:function(){
			map.clearLayerByWindowId('yanxianss');
		}
	});
}

// 其他要素窗口
function c_qitaYS(){
	c_before();
	gisui.createWindow({
		id:"qitays",
		title:"其他要素",
		iconCls:"chart",
		tabs:{
			tabs:[
			      {
			    	  title:"建制村",
			    	  src:GIS_URL+"qitays_jianzhicun.do"
			      },
			      {
			    	  title:"居民点(城市过境路)",
			    	  src:GIS_URL+"qitays_jumindian.do"
			      },
			      {
			    	  title:"乡镇",
			    	  src:GIS_URL+"qitays_xiangzhen.do"
			      },
			      {
			    	  title:"自然村",
			    	  src:GIS_URL+"qitays_zirancun.do"
			      },
			      {
			    	  title:"旅游景点",
			    	  src:GIS_URL+"qitays_lvyoujd.do"
			      },
			      {
			    	  title:"学校",
			    	  src:GIS_URL+"qitays_xuexiao.do"
			      },
			      {
			    	  title:"其他类型点",
			    	  src:GIS_URL+"qitays_qitalxd.do"
			      },
			      {
			    	  title:"过水路面",
			    	  src:GIS_URL+"qitays_guoshuilm.do"
			      },
			      {
			    	  title:"普通公路避险车道",
			    	  src:GIS_URL+"qitays_bixiancd.do"
			      },
			      {
			    	  title:"普通公路停车带",
			    	  src:GIS_URL+"qitays_tingchedai.do"
			      },
			      {
			    	  title:"绿化",
			    	  src:GIS_URL+"qitays_lvhua.do"
			      },
			      {
			    	  title:"穿城路段",
			    	  src:GIS_URL+"qitays_chuanchengld.do"
			      }
			      ]
		},
		onDestroy:function(){
			map.clearLayerByWindowId('qitays');
		}
	});
}

// 应急抢险
function c_yingjiQX(){
	c_before();
	gisui.createWindow({
		id:"yingjiqx",
		title:"应急抢险",
		iconCls:"chart",
		tabs:{
			tabs:[
			      {
			    	  title:"地质灾害点",
			    	  src:GIS_URL+"yingjiqx_dizhizhd.do"
			      },
			      {
			    	  title:"灾害易发路段",
			    	  src:GIS_URL+"yingjiqx_zaihaiyfld.do"
			      },
			      {
			    	  title:"拌合场",
			    	  src:GIS_URL+"yingjiqx_wuziku.do"
			      },
			      {
			    	  title:"应急保障点",
			    	  src:GIS_URL+"yingjiqx_yingjibzd.do"
			      }
			      ]
		},
		onDestroy:function(){
			map.clearLayerByWindowId('yingjiqx');
			map.clearLayerByWindowId("default");
		}
	});
}

// 路线交叉 
function c_luxianJC(){
	c_before();
	gisui.createWindow({
		id:"luxianjc",
		title:"路线交叉",
		iconCls:"chart",
		tabs:{
			tabs:[
			      {
			    	  title:"立体交叉",
			    	  src:GIS_URL+"luxianjc_churukou.do"
			      },
			      {
			    	  title:"平面交叉",
			    	  src:GIS_URL+"luxianjc_pingjiaodk.do"
			      }
			      ]
		},
		onDestroy:function(){
			map.clearLayerByWindowId('luxianjc');
		}
	});
}

/************************************************
 * 
 * 业务数据
 * 
 */

// 病害养护数据
function c_binghaiYHSJ(){
	c_before();
	gisui.createWindow({
		id:"binghaiyhsj",
		title:"病害养护数据",
		width:550,
		iconCls:"chart",
		src:GIS_URL+"binghaiyhsj_index.do",
		onDestroy:function(){
			map.clearLayerByWindowId("binghaiyhsj");
		}
	});
}

// 维修作业
function c_weixiuZY(){
	c_before();
	gisui.createWindow({
		id:"weixiuzy",
		title:"维修作业",
		iconCls:"chart",
		width:550,
		src:GIS_URL+"weixiuzy_index.do",
		onDestroy:function(){
			map.clearLayerByWindowId("weixiuzy");
		}
	});
}

// 巡查轨迹
function c_xunchaGJ(){
	c_before();
	gisui.createWindow({
		id:"xunchagj",
		title:"巡查轨迹",
		iconCls:"chart",
		src:GIS_URL+"xunchagj_index.do",
		onDestroy:function(){
			map.clearLayerByWindowId("xunchagj");
			clearInterval(map.intervalHandler);
		}
	});
}

// 路况展示
function c_lukuangZS(){
	c_before();
	gisui.createWindow({
		id:"lukuangzs",
		title:"路况展示",
		iconCls:"chart",
		width:638,
		src:GIS_URL+"lukuangpd_lkpd.do",
		onDestroy:function(){
			parent.map.clearLayerByWindowId("yhxx_lukuang1");
			parent.map.clearLayerByWindowId("yhxx_lukuang2");
			parent.map.clearLayerByWindowId("yhxx_lukuang3");
			parent.map.clearLayerByWindowId("yhxx_lukuang4");
			parent.map.clearLayerByWindowId("yhxx_lukuang5");
		}
	});
}


// 编辑要显示的tabs
function c_addtabs(obj){
	var winid = $(obj).attr("winid");
	var height = $("body").height();
	var width = $("body").width();
	
	var hh = 600;
	var ww = 800;
	var left = ( width - ww ) / 2;
	var top = (height - hh ) / 3 ;

	gisui.createWindow({
		title:"请选择您常用的页签",
		modal:true,
		iconCls:'icon-save',
		minimizable:false,
		src:GIS_URL+"addTabs.jsp?winid="+winid,
		left:left,
		top:top,
		width:ww,
		height:hh,
		onClose:function(){
			gisui.destroyWindow(winid);
		}
	});
}

//打开病害详情页 
function bhxq(xcid,bhjlid){
	gisui.createWindow({
		title:"病害详细信息",
		iconCls:"icon-page",
		modal:true,
		width:950,
		height:400,
		tabs:{
			selected:1,
			tabs:[
			      {
			    	  title:"巡道记录",
			    	  id:"tab_xdjl",
			    	  src:"/hmglyh/rcyh/xdjl_showXdjl.do?xcsj.xcid="+xcid
			      },
			      {
			    	  title:"病害信息",
			    	  id:"tab_bhxx",
			    	  src:"/hmglyh/rcyh/bh_showBh.do?bhjl.bhjlid="+bhjlid
			      },
			      {
			    	  title:"图片信息",
			    	  id:"tab_bhxx",
			    	  src:"/hmglyh/rcyh/bh_bhzps.do?bhjl.bhjlid="+bhjlid
			      }
			      ]
		}
	});
}

function wxzyXq(zyid){
	gisui.createWindow({
		title:"维修详细信息",
		iconCls:"icon-page",
		modal:true,
		width:950,
		height:400,
		tabs:{
			selected:1,
			tabs:[
			      {
			    	  title:"相关病害",
			    	  src:"/hmglyh/rcyh/bh_index.do?fromWx=true&wxzy.zyid="+zyid
			      },
			      {
			    	  title:"维修详情",
			    	  src:"/hmglyh/rcyh/wxzy_wxzyXq.do?wxzy.zyid="+zyid
			      },
			      {
			    	  title:"图片信息",
			    	  src:"/hmglyh/rcyh/wxzy_wxzyzps.do?wxzy.zyid="+zyid
			      }
			      ]
		}
	});
}

