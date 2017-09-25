<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../public/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/page/luxian/luduan.js"></script>
<title>路段</title>
<script type="text/javascript">
$(function(){
	$("#export").click(function(){
		var title = YMLib.Columns.getTitle(columns);
		var data = YMLib.Columns.getDataWithoutFormatter(columns);
		var params = getParamForMult('fm');
		
		var condition = "where 1=1 and roadcode='"+params['ldmxb.roadcode']+"'";
		if(params['ldmxb.jsdj'] != null && params['ldmxb.jsdj'] != ""){
			condition += " and jsdj in (select * from table(fn_split('"+params['ldmxb.jsdj']+"',',')))";
		}
		if(params['ldmxb.spos'] != null && params['ldmxb.spos'] != ""){
			condition += " and spos >= " + params['ldmxb.spos'];
		}
		if(params['ldmxb.epos'] != null && params['ldmxb.epos'] != ""){
			condition += " and " + params['ldmxb.epos'] + ">= epos";
		}
		
		condition += "order by roadcode,spos";
		
		var param = "pb.title="+encodeURIComponent(title)+"&pb.data="+encodeURIComponent(data)+"&pb.condition="+encodeURIComponent(condition)+"&pb.tableName=LUDUANJBQKMXB";

		YMLib.Ajax.POST("pb/getHtml.do",param,"json",function(result){
			location.href = YMLib.url + "page/gis/page/export.jsp";
		},function(){
			
		});
	});
});
</script>

</head>
<%
	String roadcode = request.getParameter("ld.roadcode");
	request.setAttribute("roadcode", roadcode);
%>
<body>
	<tabel id="dg" class="easyui-datagrid" data-options="
		url:'${pageContext.request.contextPath}/gis/luxian_luduanRows.do',
		columns:columns,
		pageNumber:1,
		pageSize:6,
		pageList:[6,12,18],
		pagination:true,
		singleSelect:true,
		queryParams : {
			'ldmxb.roadcode':'${roadcode }'
		},
		fit:true,
		rownumbers:true,
		toolbar:'#tb',
		onClickRow:onClickRow
	"></tabel>
	
	 <div id="tb" style="padding:10px;height:auto">
		<form id="fm">
			<%-- <input type="hidden" name = "roadcode" value="${roadcode}"> --%>
		<div>
			<table class="menu_table">
				<tr>
					<td>
						<input type="hidden" name="ldmxb.roadcode" value="${roadcode }"/>
							<span>技术等级</span>:<input name='ldmxb.jsdj' class='easyui-combobox' data-options="
																valueField:'valueField',
																textField:'textField',
																width:50,
																panelHeight:'auto',
																multiple : true,
																editable : false,
																separator : ',',
																data:[
																	{
																		textField:'高速',valueField:'10'
																	},{
																		textField:'一级',valueField:'11'
																	},{
																		textField:'二级',valueField:'12'
																	},{
																		textField:'三级',valueField:'13'				
																	},{
																		textField:'四级',valueField:'14'						
																	}
																]"/>
					</td>
					<td><a class="easyui-linkbutton" id="export">导出</a></td>
				</tr>
				<tr>
					<td>
						<span>起点桩号</span>:<input type="text" style="width:35px" name="ldmxb.spos"> - 
						<span>止点桩号</span>:<input type="text" style="width:35px" name="ldmxb.epos">
					</td>
					<td class='search_button'>
						<a type="button" class="easyui-linkbutton" onclick="gridsubmit()">查询</a>
					</td>
				</tr>
			</table>
		</div>
		</form>
	</div>
	
</body>
</html>