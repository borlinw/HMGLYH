var windowid = "luxian";
var columns = [[
		    			{'field':'lxcode','title':'路线代码','width':80},
		    			{'field':'lxname','title':'路线名称','width':80},
		    			{'field':'szhh','title':'起点桩号(公里)','width':80},
		    			{'field':'ezhh','title':'止点桩号(公里)','width':80},
		    			{'field':'mileage','title':'路线长度(公里)','width':80},
		    			{'field':'zdlc','title':'匝道里程(公里)','width':80}
		    		]];
		
function gridSubmit(){
	$("#dg").datagrid("load",getParam("fm"));
}

var onLoadSuccess = function(){
	var rows = $("#dg").datagrid("getData").rows;
	var lcTotal = 0;
	var zdTotal = 0;
	for(var i=0;i<rows.length;i++){
		lcTotal += rows[i].mileage;
		zdTotal += rows[i].zdlc;
	}
	$("#dg").datagrid("appendRow",{'lxcode':'<span class="subtotal">合计</span>','mileage':'<span class="subtotal">'+lcTotal.toFixed(3)+'</span>',
									'zdlc':'<span class="subtotal">'+zdTotal.toFixed(3)+'</span>'});
};

function onClickRow(rowIndex,rowData){
	top.map.clearLayerByWindowId(windowid);
	top.map.addLineToMap({
		windowid:windowid,
		roadcode:rowData.lxcode,
		popup:{
			title:"路线信息-"+rowData.lxname,
			rowData:rowData,
			columns:columns,
			buttons:[
    	         {
    	        	 text:"专题图",
    	        	 attr:rowData,
    	        	 eventHandler:function(obj){
    	        		 
    	        		var winid = 'luxian_zhuantitu';
    	        		 
    	        		var roadcode = $(obj).attr('lxcode');
    	        		var roadname = $(obj).attr('lxname');
    	        		
    	        		gisui.destroyWindow(winid);
    	        		
    	        		gisui.createWindow({
    	        			title:'专题图-'+roadname,
    	        			id:winid,
    	        			width:720,
    	        			height:511,
    	        			tabs:{
    	        				tabs:[
    	        				      {
    	        				    	  title:'按技术等级统计',
    	        				    	  src:top.GIS_URL + 'luxian_jsdj_pre.do?roadcodes='+roadcode
    	        				      },
    	        				      {
    	        				    	  title:'按路面类型',
    	        				    	  src:top.GIS_URL+'luxian_lmlx_pre.do?roadcodes='+roadcode
    	        				      },
    	        				      {
    	        				    	  title:'按车道特征',
    	        				    	  src:top.GIS_URL+'luxian_cdtz_pre.do?roadcodes='+roadcode
    	        				      }
    	        				      ]
    	        			}
    	        			
    	        		});
    	        	 }
    	         },
    	         {
    	        	 text:"路段",
    	        	 attr:rowData,
    	        	 eventHandler:function(obj){
    	        		 var roadcode = $(obj).attr('lxcode');
	    	        	 var roadname = $(obj).attr('lxname');
	    	        	 var winid = 'luduan';
	    	        	 gisui.destroyWindow(winid);
    	        		 gisui.createWindow({
    	        			 title:'路段('+roadname+')',
	    	        		 id:winid,
	    	        		 height:450,
	    	        		 src:top.GIS_URL + 'gis/luxian_luduan.do?ld.roadcode='+roadcode,
	    	        		 onDestroy:function(){
	    	        			 var winid = 'luduan';
	    	        			 var windowid= 'luxian';
	    	        			 map.clearLayerByWindowId(winid);
	    	        			 top.map.centerMap();
	    	        			 map.selectFeature(windowid);
	    	        		 }
    	        		 });
    	        	 }
    	         },
    	         {
    	        	 text:"构造物",
    	        	 attr:rowData,
    	        	 eventHandler:function(obj){
    	        		 	var roadcode = $(obj).attr('lxcode');
	    	        		var roadname = $(obj).attr('lxname');
	    	        		var winid = 'gouzaowu';
	    	        		var windowid = 'luxian';
	    	        		gisui.destroyWindow(winid);
	    	        		gisui.createWindow({
	    	        			title:'桥隧涵-'+roadname,
	    	        			id:winid,
	    	        			onDestroy:function(){
	    	        				map.clearLayerByWindowId(winid);
	    	        				map.centerMap();
		    	        			map.selectFeature(windowid);
	    	        			},
	    	        			tabs:{
	    	        				tabs:[
	    	        				      {
	    	        				    	  title:'桥梁',
	    	        				    	  src:top.GIS_URL+'gis/gouzaowu_qiaoliang.do?ql.roadcode='+roadcode+'&fromLx=true'
	    	        				      },
	    	        				      {
	    	        				    	  title:'隧道',
	    	        				    	  src:top.GIS_URL+'gis/gouzaowu_suidao.do?sd.roadcode='+roadcode+'&fromLx=true'
	    	        				      },
	    	        				      {
	    	        				    	  title:'涵洞',
	    	        				    	  src:top.GIS_URL+'gis/gouzaowu_handong.do?hd.roadcode='+roadcode+'&fromLx=true'
	    	        				      },
	    	        				      {
	    	        				    	  title:'路基防护',
	    	        				    	  src:top.GIS_URL+'gis/gouzaowu_lujifh.do?lj.roadcode='+roadcode+'&fromLx=true'
	    	        				      }
	    	        				      ]
	    	        			}
	    	        			
	    	        		});
    	        	 }
    	         },
    	         {
    	        	 text:"沿线设施",
    	        	 attr:rowData,
    	        	 eventHandler:function(obj){
    	        		 var roadcode = $(obj).attr('lxcode');
	    	        	 var roadname = $(obj).attr('lxname');
	    	        	 var winid = 'yanxainss';
	    	        	 gisui.destroyWindow(winid);
	    	        	 gisui.createWindow({
	    	        		 title:'沿线设施-'+roadname,
	    	        		 id:winid,
	    	        		 onDestroy:function(){
	    	        			 top.map.clearLayerByWindowId('yanxianss');
	    	        			 map.centerMap();
	    	        			 map.selectFeature('luxian');
	    	        		 },
	    	        		 height:300,
	    	        		 width:550,
	    	        		 tabs:{
	    	        			 tabs:[
	    	        			       {
	    	        			    	   title:'交安设施',
	    	        			    	   src:top.GIS_URL+'gis/yanxianss_jiaoanss.do?jass.roadcode='+roadcode+'&fromLx=true'
	    	        			       },
	    	        			       {
	    	        			    	   title:'交通标志',
	    	        			    	   src:top.GIS_URL+'gis/yanxianss_jiaotongbz.do?jtbz.roadcode='+roadcode+'&fromLx=true'
	    	        			       },
	    	        			       {
	    	        			    	   title:'天桥',
	    	        			    	   src:top.GIS_URL+'gis/yanxianss_tianqiao.do?tq.roadcode='+roadcode+'&fromLx=true'
	    	        			       },
	    	        			       {
	    	        			    	   title:'检查站',
	    	        			    	   src:top.GIS_URL+'gis/yanxianss_jianchazhan.do?jcz.roadcode='+roadcode+'&fromLx=true'
	    	        			       },
	    	        			       {
	    	        			    	   title:'交通量观测站',
	    	        			    	   src:top.GIS_URL+'gis/yanxianss_jiaotonglianggcz.do?gcz.roadcode='+roadcode+'&fromLx=true'
	    	        			       },
	    	        			       {
	    	        			    	   title:'路线多媒体点',
	    	        			    	   src:top.GIS_URL+'gis/yanxianss_luxiandmtd.do?dmtd.roadcode='+roadcode+'&fromLx=true'
	    	        			       },
	    	        			       {
	    	        			    	   title:'服务区',
	    	        			    	   src:top.GIS_URL+'gis/yanxianss_fuwuqu.do?fwq.roadcode='+roadcode+'&fromLx=true'
	    	        			       },
	    	        			       {
	    	        			    	   title:'沿线服务设施',
	    	        			    	   src:top.GIS_URL+'gis/yanxianss_fuwuss.do?fwss.roadcode='+roadcode+'&fromLx=true'
	    	        			       },
	    	        			       {
	    	        			    	   title:'收费站',
	    	        			    	   src:top.GIS_URL+'gis/yanxianss_shoufeizhan.do?sfz.roadcode='+roadcode+'&fromLx=true'
	    	        			       }/*,
	    	        			       {
	    	        			    	   title:'管理机构',
	    	        			    	   src:top.GIS_URL+'gis/yanxianss_guanlijg.do?gljg.roadcode='+roadcode+'&fromLx=true'
	    	        			       },*/,
	    	        			       {
	    	        			    	   title:'养护站(养护工区)',
	    	        			    	   src:top.GIS_URL+'gis/yanxianss_yanghuzhan.do?yanghudaoban.roadcode='+roadcode+'&fromLx=true'
	    	        			       }
	    	        			       ]
	    	        		 }
	    	        	 });
    	        	 }
    	         },
    	         {
    	        	 text:"应急抢险",
    	        	 attr:rowData,
    	        	 eventHandler:function(obj){
 	        		 	    var roadcode = $(obj).attr('lxcode');
	    	        		var roadname = $(obj).attr('lxname');
	    	        		var winid = 'yingjiqx';
	    	        		var windowid = 'yingjiqx';
	    	        		gisui.destroyWindow(winid);
	    	        		gisui.createWindow({
	    	        			title:'应急抢险-'+roadname,
	    	        			id:winid,
	    	        			onDestroy:function(){
	    	        				map.clearLayerByWindowId("defalt");
	    	        				map.clearLayerByWindowId(winid);
	    	        				map.centerMap();
		    	        			map.selectFeature(windowid);
	    	        			},
	    	        			tabs:{
	    	        				tabs:[
	    	        				      {
	    	        				    	  title:'地址灾害点',
	    	        				    	  src:'/hmglyh/gis/yingjiqx_dizhizhd.do?dzzhd.roadcode='+roadcode+'&fromLx=true'
	    	        				      },
	    	        				      {
	    	        				    	  title:'灾害易发路段',
	    	        				    	  src:'/hmglyh/gis/yingjiqx_zaihaiyfld.do?zhyfld.roadcode='+roadcode+'&fromLx=true'
	    	        				      },
	    	        				      /*{
	    	        				    	  title:'物资库',
	    	        				    	  src:'/hmglyh/gis/yingjiqx_wuziku.do?wzk.roadcode='+roadcode+'&fromLx=true'
	    	        				      },*/
	    	        				      {
	    	        				    	  title:'应急保障点',
	    	        				    	  src:'/hmglyh/gis/yingjiqx_yingjibzd.do?yjbzd.roadcode='+roadcode+'&fromLx=true'
	    	        				      }
	    	        				      ]
	    	        			}
	    	        			
	    	        		});
    	        	 }
    	         },
    	         {
    	        	 text:"路线交叉",
    	        	 attr:rowData,
    	        	 eventHandler:function(obj){
 	        		 	    var roadcode = $(obj).attr('lxcode');
	    	        		var roadname = $(obj).attr('lxname');
	    	        		var winid = 'luxianjc';
	    	        		var windowid = 'luxianjc';
	    	        		gisui.destroyWindow(winid);
	    	        		gisui.createWindow({
	    	        			title:'路线交叉-'+roadname,
	    	        			id:winid,
	    	        			onDestroy:function(){
	    	        				map.clearLayerByWindowId(winid);
	    	        				map.centerMap();
		    	        			map.selectFeature(windowid);
	    	        			},
	    	        			tabs:{
	    	        				tabs:[
	    	        				      {
	    	        				    	  title:'高速出入口',
	    	        				    	  src:'/hmglyh/gis/luxianjc_churukou.do?crk.roadcode='+roadcode+'&fromLx=true'
	    	        				      },
	    	        				      {
	    	        				    	  title:'平交道口',
	    	        				    	  src:'/hmglyh/gis/luxianjc_pingjiaodk.do?pjdk.roadcode='+roadcode+'&fromLx=true'
	    	        				      }
	    	        				      ]
	    	        			}
	    	        			
	    	        		});
    	        	 }
    	         }/*,
    	         {
    	        	text:"其他要素",
    	        	eventHandler:"alert('其他要素')"
    	         }*/,
    	         {
    	        	 text:"养护信息",
    	        	 attr:rowData,
    	        	 eventHandler:function(obj){
    	        		 var roadcode = $(obj).attr('lxcode');
	    	        	 var roadname = $(obj).attr('lxname');
	    	        	 gisui.destroyWindow('luxian_yhxx');
	    	        	 gisui.createWindow({
	    	        		 title:'养护信息-'+roadname,
	    	        		 id:'luxian_yhxx',
    	        			 onDestroy:function(){
    	        			 	map.clearLayerByWindowId('binghaiyhsj');
    	        			 	map.clearLayerByWindowId('weixiuzy');
    	        			 	map.clearLayerByWindowId('default');
    	        			 	map.zoomToMaxExtent();
	    	        			map.selectFeature('luxian');
    	        			 },
	    	        		 height:300,
	    	        		 width:550,
	    	        		 tabs:{
	    	        			 tabs:[
	    	        			       {
	    	        			    	   title:'病害信息',
	    	        			    	   src:top.GIS_URL+'html/luxian/luxian_bhs.do?roadcode='+roadcode+'&fromLx=true'
	    	        			       },
	    	        			       {
	    	        			    	   title:'维修作业',
	    	        			    	   src:top.GIS_URL+'html/luxian/luxian_wxs.do?roadcode='+roadcode+'&fromLx=true'
	    	        			       }
	    	        			       ]
	    	        		 }
	    	        	 });
    	        	 }
    	         },
    	         {
    	        	 text:"历史维修记录",
    	        	 attr:rowData,
    	        	 eventHandler:function(obj){
    	        		 var roadcode = $(obj).attr('lxcode');
	    	        	 var roadname = $(obj).attr('lxname');
	    	        	 var winid = 'lswxjl';
	    	        	 var lx = 'lm';
	    	        	 gisui.destroyWindow(winid);
    	        		 gisui.createWindow({
    	        			 title:'历史维修记录-'+roadname,
	    	        		 id:winid,
	    	        		 width:500,
	    	        		 height:450,
	    	        		 src:YMLib.url + 'page/gis/page/lswxjl.jsp?roadcode='+roadcode+'&lx='+lx+'&qzzh=&wxlx=',
	    	        		 onDestroy:function(){
	    	        			 var winid = 'lswxjl';
	    	        			 var windowid= 'luxian';
	    	        			 map.clearLayerByWindowId(winid);
	    	        			 top.map.centerMap();
	    	        			 map.selectFeature(windowid);
	    	        		 }
    	        		 });
    	        	 }
    	         }
    	         
    	         
    	         /*,
    	         {
    	        	 text:'路线评定',
    	        	 eventHandler:'alert("路线评定")'
    	        		 
    	         }*/
    	         ]
    }
	});
}