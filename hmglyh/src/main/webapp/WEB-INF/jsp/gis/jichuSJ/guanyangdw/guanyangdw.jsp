<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../public/head.jsp"%>
<script type="text/javascript" src="${pageContext.request.contextPath}/page/gis/js/page/guanyangdw/guanyangdw.js"></script>
<title>管养单位</title>
</head>
<body>
	<table id="tt" class="easyui-treegrid" style=""
        data-options="url:'${pageContext.request.contextPath}/gis/guanyangdw_guanyangdwRows.do?bm.bmcode=0101',
        			  idField:'bmcode',
        			  treeField:'bmname',
        			  fit:true,
        			  onClickRow:function(row){top.Apoint([row],'guanyangdw','gljg.png',columns,'管养单位详细信息',false,getButtons)},
        			  onLoadSuccess:function(row,data){top.treePoint(data,'guanyangdw','gljg.png',columns,'管养单位详细信息',true,getButtons)}
        			  ">
    <thead>
        <tr>
            <th data-options="field:'bmname',width:230">部门名称</th>
            <th data-options="field:'jsnf',width:80">建设年份</th>
            <th data-options="field:'zdmj',width:80">占地面积</th>
            <th data-options="field:'jzmj',width:80">建筑面积</th>
            <th data-options="field:'dz',width:80">地址</th>
            <th data-options="field:'lxCode',width:80">路线</th>
            <th data-options="field:'fx',width:80">方向</th>
            <th data-options="field:'zh',width:80">桩号</th>
            <th data-options="field:'fzr',width:80">负责人</th>
            <th data-options="field:'lxdh',width:80">联系电话</th>
            <th data-options="field:'bmms',width:80">部门描述</th>
            <th data-options="field:'ptx',width:80">经度</th>
            <th data-options="field:'pty',width:80">纬度</th>
        </tr>
    </thead>
</table>
	
</body>
</html>