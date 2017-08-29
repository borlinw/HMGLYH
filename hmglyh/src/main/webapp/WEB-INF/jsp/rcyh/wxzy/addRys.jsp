<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/page/rcyh/css/style.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/page/gis/js/easyui-1.4.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/page/gis/js/easyui-1.4.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/uuid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/easyui-1.4.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/easyui-1.4.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/rcyhGisui.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/tools.js"></script>
<title>添加人员</title>
</head>
<body>
    <div style="margin:5px 0;">
    	<a class="easyui-linkbutton" style="margin-left:5px;" onclick="saveRy()">保存</a>
    </div>
    <div id="tg" class="easyui-datalist"
            data-options="
                url: '/hmglyh/rcyh/wxzy_getRyTreeGrid.do',
                method: 'get',
                groupField: 'group',
                checkbox: true,
                singleSelect: false
            ">
    </div>
    
     
    
    <script>
    	
    	var doubleFixed = 3;
    	var moneyFixed = 2;
    
    	function saveRy(){
    		var selections = $("#tg").datalist("getSelections");
    		console.log(selections);
    		var ifr = parent.$("#addWxzy_iframe")[0].contentWindow.$;
    		
    		// 解析table 获取 已经填写的人员信息
    		var oldRyRows = [];
    		var oldRyRowsHtml = ifr(".ry-row");
    		var zysl = ifr("#zysl").val();
    		var grde = ifr("#grde").val();
    	//	var zgr = ifr("#zgr").val();
    		var zgr = 0;
    		
    		if(isNaN(zysl) || zysl < 0 ) {
    			zysl = 0;
    		} 
    		
    		if(isNaN(grde) || grde < 0 ) {
    			grde = 0;
    		} 
    		
    		$.each(oldRyRowsHtml,function(i,d){
    			var row = {};
    			var ryname = $(d).find(".rynameCls").val();
    			var ryid = $(d).find(".ryidCls").val();
    			var rygcl = $(d).find(".rygclCls").val();
    			var rygr = $(d).find(".rygrCls").val();
    			
    			row.ryname = ryname;
    			row.ryid = ryid;
    		
    			if(!isNaN(rygcl) && rygcl > 0 ) {
    				row.rygcl = rygcl;
    			
    			}else{
    				row.rygcl = 0.00; 
    			}
    			
    			if(!isNaN(rygr) && rygr > 0 ) {
    				row.rygr = rygr;
    			}else{
    				row.rygr = 0.00; 
    			}
    			oldRyRows.push(row);
    		});
    		
    		console.log(oldRyRows);
    		
    		$.each(selections,function(i,d){
				if(!isContainRy(oldRyRows,d.ryid)){
					var row = {};
					row.ryid = d.ryid;
					row.ryname = d.ryname;
					oldRyRows.push(row);
				}    		
    		});
    		
    		if( oldRyRows.length == 0 ) {
    			$.messager.alert("提示","请选择人员","info");	
    			return;
    		}
    		
    		$.each(oldRyRows,function(i,d){
    			d.rygcl = (zysl / oldRyRows.length).toFixed(doubleFixed);
    		//	d.rygr = (zgr / oldRyRows.length).toFixed(doubleFixed);
    			d.rygr = ( d.rygcl * grde ).toFixed(doubleFixed);
    			zgr +=  d.rygcl * grde;
    		});
    		
    		var html = createRyHtml(oldRyRows);
    		
    		oldRyRowsHtml.remove();
    		
    		ifr("#rytable").append(html);
    		ifr("#zgr").val(zgr.toFixed(doubleFixed));
    		parent.gisui.destroyWindow("addRy");
    	}
    	
    	function createRyHtml(jsonRows){
			var html = "";				
			$.each(jsonRows,function(i,d){
				html +=  "<tr class='datagrid-row ry-row'>"+	
								"<td>"+	
								"<div style='height:auto;text-align:center' class='datagrid-cell'>"+	
									"<input type='text' readonly='readonly' class='rynameCls' value='"+d.ryname+"' />"+	
									"<input name='wxzy.ryzys["+i+"].ryid' type='hidden' class='ryidCls' value='"+d.ryid+"' />"+
								"</div>"+
							"</td>"+
							"<td>"+
								"<div style='height:auto;text-align:center' class='datagrid-cell'>"+
									"<input id='wcgcl' errorInfo='完成工程量填写错误' name='wxzy.ryzys["+i+"].wcgcl' class='rygclCls int notnull' onfocus='pgslFocus(this)' onblur='pgslBlur(this)' type='text' value='"+d.rygcl+"' />"+
								"</div>"+
							"</td>"+
							"<td>"+
								"<div style='height:auto;text-align:center' class='datagrid-cell'>"+
									"<input id='wcgr' onblur='rygrBlur()' errorInfo='完成工日填写错误' name='wxzy.ryzys["+i+"].wcgr' class='rygrCls int notnull' type='text' value='"+d.rygr+"'>"+
								"</div>"+
							"</td>"+
							"<td>"+
									"<div style='height:auto;text-align:center' class='datagrid-cell'>"+
										"<a href='javascript:void(0)' onclick='delRyTr(this)'>删除</a>"+
									"</div>"+
							"</td>"+
						"</tr>";
			});		
			return html;
    	}
    	
    	function isContainRy(ryrows,ryid){
    		var i = 0 ;
    		for( i ; i < ryrows.length; i++ ) {
    			if(ryrows[i].ryid == ryid ) {
    				return true;
    			}
    		}
    		return false;
    	}
    	
    </script>
</body>
</html>