	var columns = [[
		                {
		                	title:"部门名称",field:"bmname",width:230
		                },
		                {
		                	title:"部门编码",field:"bmcode",width:230
		                },
		                {
		                	title:"部门类型",field:"bmlx",width:230
		                },
		                {
		                	title:"启用状态",field:"qyzt",width:230
		                },
		                {
		                	title:"部门真实编码",field:"bmzscode",width:230
		                },
		                {
		                	title:"负责人",field:"fzr",width:230
		                }
		                ]];
		
		
		function getButtons(rowData) {
			
			if( rowData.bmcode.length > 6 )  {
				return false;
			}
			
			return [
			  	         /*{
			          	 text:"专题图",
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
			           },*/
			           {
			          	 text:"路线",
			          	 attr:{
			          		 bmcode:rowData.bmcode,
			          		 bmname:rowData.bmname
			          	 },
			          	 eventHandler:function(obj){
			          		 var bmname = $(obj).attr('bmname');
			          		 var bmcode = $(obj).attr('bmcode');
			  	        	 var winid = 'htglld_lx';
			  	        	 gisui.destroyWindow(winid);
			          		 gisui.createWindow({
			          			 title:bmname+'所管辖路线',
			  	        		 id:winid,
			  	        		 height:300,
			  	        		 src:top.GIS_URL + 'gis/luxian_htglld.do?ldb.bmcode='+bmcode,
			  	        		 onDestroy:function(){
			  	        			 map.clearLayerByWindowId('htglld_lx');
			  	        			 map.clearLayerByWindowId('guanyangdw_temp');
			  	        			 map.showLayer('guanyangdw');
			  	        			 top.map.centerMap();
			  	        			 var row = $('#guanyangdw_iframe')[0].contentWindow.$('#tt').treegrid('getSelected');
			  	        			 map.selectFeature('guanyangdw','guangyangdw_'+row.ptx+'_'+row.pty,'getFeatureByFid');
			  	        		 }
			          		 });
			          	 }
			           },
			           {
			          	 text:"构造物",
			          	 attr:{
			          		 bmname:rowData.bmname,
			          		 bmcode:rowData.bmcode
			          	 },
			          	 eventHandler:function(obj){
			          		 	var bmname = $(obj).attr('bmname');
			          		 	var bmcode = $(obj).attr('bmcode');
			  	        		var winid = 'gouzaowu';
			  	        		var windowid = 'guanyangdw';
			  	        		gisui.destroyWindow(winid);
			  	        		gisui.createWindow({
			  	        			title:'桥隧涵-'+bmname,
			  	        			id:winid,
			  	        			onDestroy:function(){
			  	        				map.clearLayerByWindowId(winid);
			  	        				map.centerMap();
			      	        			map.selectFeature(windowid);
			  	        			},
			  	        			height:400,
			  	        			tabs:{
			  	        				tabs:[
			  	        				      {
			  	        				    	  title:'桥梁',
			  	        				    	  src:top.GIS_URL+'gis/gouzaowu_qiaoliang.do?ql.bmcode='+bmcode+'&fromBm=true'
			  	        				      },
			  	        				      {
			  	        				    	  title:'隧道',
			  	        				    	  src:top.GIS_URL+'gis/gouzaowu_suidao.do?sd.bmcode='+bmcode+'&fromBm=true'
			  	        				      },
			  	        				      {
			  	        				    	  title:'涵洞',
			  	        				    	  src:top.GIS_URL+'gis/gouzaowu_handong.do?hd.bmcode='+bmcode+'&fromBm=true'
			  	        				      },
			  	        				      {
			  	        				    	  title:'路基防护',
			  	        				    	  src:top.GIS_URL+'gis/gouzaowu_lujifh.do?lj.bmcode='+bmcode+'&fromBm=true'
			  	        				      }
			  	        				      ]
			  	        			}
			  	        			
			  	        		});
			          	 }
			           },
			           {
			          	 text:"沿线设施",
			        	 attr:{
			          		 bmname:rowData.bmname,
			          		 bmcode:rowData.bmcode
			          	 },
			          	 eventHandler:function(obj){
			          		 var bmname = $(obj).attr('bmname');
		          		 	 var bmcode = $(obj).attr('bmcode');
			  	        	 var winid = 'yanxainss';
			  	        	 gisui.destroyWindow(winid);
			  	        	 gisui.createWindow({
			  	        		 title:'沿线设施-'+bmname,
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
			  	        			    	   src:top.GIS_URL+'gis/yanxianss_jiaoanss.do?jass.bmcode='+bmcode+'&fromBm=true'
			  	        			       },
			  	        			       {
			  	        			    	   title:'交通标志',
			  	        			    	   src:top.GIS_URL+'gis/yanxianss_jiaotongbz.do?jtbz.bmcode='+bmcode+'&fromBm=true'
			  	        			       },
			  	        			       {
			  	        			    	   title:'天桥',
			  	        			    	   src:top.GIS_URL+'gis/yanxianss_tianqiao.do?tq.bmcode='+bmcode+'&fromBm=true'
			  	        			       },
			  	        			       {
			  	        			    	   title:'检查站',
			  	        			    	   src:top.GIS_URL+'gis/yanxianss_jianchazhan.do?jcz.bmcode='+bmcode+'&fromBm=true'
			  	        			       },
			  	        			       {
			  	        			    	   title:'交通量观测站',
			  	        			    	   src:top.GIS_URL+'gis/yanxianss_jiaotonglianggcz.do?gcz.bmcode='+bmcode+'&fromBm=true'
			  	        			       },
			  	        			       {
			  	        			    	   title:'路线多媒体点',
			  	        			    	   src:top.GIS_URL+'gis/yanxianss_luxiandmtd.do?dmtd.bmcode='+bmcode+'&fromBm=true'
			  	        			       },
			  	        			       {
			  	        			    	   title:'服务区',
			  	        			    	   src:top.GIS_URL+'gis/yanxianss_fuwuqu.do?fwq.bmcode='+bmcode+'&fromBm=true'
			  	        			       },
			  	        			       {
			  	        			    	   title:'沿线服务设施',
			  	        			    	   src:top.GIS_URL+'gis/yanxianss_yanxianfwss.do?fwss.bmcode='+bmcode+'&fromBm=true'
			  	        			       },
			  	        			       {
			  	        			    	   title:'收费站',
			  	        			    	   src:top.GIS_URL+'gis/yanxianss_shoufeizhan.do?sfz.bmcode='+bmcode+'&fromBm=true'
			  	        			       },
			  	        			     /*  {
			  	        			    	   title:'管理机构',
			  	        			    	   src:top.GIS_URL+'gis/yanxianss_guanlijg.do?gljg.roadcode='+roadcode
			  	        			       },*/
			  	        			       {
			  	        			    	   title:'养护站(养护工区)',
			  	        			    	   src:top.GIS_URL+'gis/yanxianss_yanghuzhan.do?yanghudaoban.bmcode='+bmcode+'&fromBm=true'
			  	        			       }
			  	        			       ]
			  	        		 }
			  	        	 });
			          	 }
			           },
			           /*{
			          	 text:"应急抢险",
			          	 attr:{
			          		 bmname:rowData.bmname,
			          		 bmcode:rowData.bmcode
			          	 },
			          	 eventHandler:function(obj){
			          		 	var bmname = $(obj).attr('bmname');
		    	        		var bmcode = $(obj).attr('bmcode');
		    	        		var winid = 'yingjiqx';
		    	        		var windowid = 'yingjiqx';
		    	        		gisui.destroyWindow(winid);
		    	        		gisui.createWindow({
		    	        			title:'应急抢险-'+bmname,
		    	        			id:winid,
		    	        			onDestroy:function(){
//		    	        				map.clearLayerByWindowId("default");
		    	        				map.clearLayerByWindowId(winid);
		    	        				map.centerMap();
			    	        			map.selectFeature(windowid);
		    	        			},
		    	        			tabs:{
		    	        				tabs:[
		    	        				      {
		    	        				    	  title:'地质灾害点',
		    	        				    	  src:'/hmglyh/gis/yingjiqx_dizhizhd.do?dzzhd.bmcode='+bmcode+'&fromBm=true'
		    	        				      },
		    	        				      {
		    	        				    	  title:'灾害易发路段',
		    	        				    	  src:'/hmglyh/gis/yingjiqx_zaihaiyfld.do?zhyfld.bmcode='+bmcode+'&fromBm=true'
		    	        				      },
		    	        				      {
		    	        				    	  title:'应急保障点',
		    	        				    	  src:'/hmglyh/gis/yingjiqx_yingjibzd.do?yjbzd.bmcode='+bmcode+'&fromBm=true'
		    	        				      }
		    	        				      ]
		    	        			}
		    	        			
		    	        		});
			          	 }
			           },*/
			           {
			          	 text:"路线交叉",
			          	 attr:{
			          		 bmname:rowData.bmname,
			          		 bmcode:rowData.bmcode
			          	 },
			          	 eventHandler:function(obj){
			          		    var bmcode = $(obj).attr('bmcode');
		    	        		var bmname = $(obj).attr('bmname');
		    	        		var winid = 'luxianjc';
		    	        		var windowid = 'luxianjc';
		    	        		gisui.destroyWindow(winid);
		    	        		gisui.createWindow({
		    	        			title:'路线交叉-'+bmname,
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
		    	        				    	  src:'/hmglyh/gis/luxianjc_churukou.do?crk.bmcode='+bmcode+'&fromBm=true'
		    	        				      },
		    	        				      {
		    	        				    	  title:'平交道口',
		    	        				    	  src:'/hmglyh/gis/luxianjc_pingjiaodk.do?pjdk.bmcode='+bmcode+'&fromBm=true'
		    	        				      }
		    	        				      ]
		    	        			}
		    	        			
		    	        		});
			          	 }
			           },
			           {
			          	 text:"养护信息",
			          	 attr:{
			          		 bmname:rowData.bmname,
			          		 bmcode:rowData.bmcode
			          	 },
			          	 eventHandler:function(obj){
			          		 var bmcode = $(obj).attr('bmcode');
		    	        	 var bmname = $(obj).attr('bmname');
		    	        	 gisui.destroyWindow('luxian_yhxx');
		    	        	 gisui.createWindow({
		    	        		 title:'养护信息-'+bmname,
		    	        		 id:'luxian_yhxx',
	    	        			 onDestroy:function(){
	    	        			 	map.clearLayerByWindowId('binghaiyhsj');
	    	        			 	map.clearLayerByWindowId('weixiuzy');
	    	        			 	map.clearLayerByWindowId('default');
	    	        			 	map.zoomToMaxExtent();
		    	        		//	map.selectFeature('luxian');
	    	        			 },
		    	        		 height:300,
		    	        		 width:550,
		    	        		 tabs:{
		    	        			 tabs:[
		    	        			       {
		    	        			    	   title:'病害信息',
		    	        			    	   src:top.GIS_URL+'html/luxian/luxian_bhs.do?bmcode='+bmcode+'&fromBm=true'
		    	        			       },
		    	        			       {
		    	        			    	   title:'维修作业',
		    	        			    	   src:top.GIS_URL+'html/luxian/luxian_wxs.do?bmcode='+bmcode+'&fromBm=true'
		    	        			       }
		    	        			       ]
		    	        		 }
		    	        	 });
			          	 }
			           }/*,
			           {
			          	 text:'路线评定',
			          	 eventHandler:'alert("路线评定")'
			          		 
			           }*/
			           ];
		}
		