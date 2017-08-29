var windowid = "htglld_lx"; // 互通管理路段表
var columns =  [[
                 {field:'ldname',title:'路线名称',width:140},
                 {field:'lxcode',title:'路线编码',width:100},
                 {field:'szhh',title:'起点桩号',width:100},
                 {field:'ezhh',title:'止点桩号',width:100},
                 {field:'mileage',title:'路线长度',width:100,formatter:function(value){return value+"(千米)";}},
                 {field:'bmcode',title:'部门编码',width:100},
                 {field:'bz',title:'备注',width:100}
             ]];
		
function gridSubmit(){
	$("#dg").datagrid("load",getParam("fm"));
}

function onClickRow(rowIndex,rowData){

	 top.map.hideLayer('guanyangdw');
  	 var row = top.$('#guanyangdw_iframe')[0].contentWindow.$('#tt').treegrid('getSelected');
  	 var columns = top.$('#guanyangdw_iframe')[0].contentWindow.columns;
  	 top.Apoint([row],'guanyangdw_temp','gljg.png',columns,'管养单位详细信息',false,top.$('#guanyangdw_iframe')[0].contentWindow.getButtons);
	
	top.map.clearLayerByWindowId(windowid);
	top.map.addLineToMap({
		windowid:windowid,
		roadcode:rowData.lxcode,
		startzh:rowData.szhh,
		endzh:rowData.ezhh,
		popup:{
			title:"路线信息-"+rowData.ldname,
			rowData:rowData,
			columns:columns
		}
	});
}