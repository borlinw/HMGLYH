
 var BhjlbColumns = [[
    {field:"ck",checkbox:true},
    {field:'aaa',title:'操作',width:80,formatter:function(value,rowData,rowIndex){
    	var returnString = "<a href='javascript:void(0)' onclick=bhxq(\'"+rowData.xcid+"\',\'"+rowData.bhjlid+"\',\'"+rowData.bmcode+"\',\'"+rowData.jlusername+"\') >详情</a>";
    	if(rowData.bhsbzt != 2 ){
    		returnString += "|<a target='_blank' href='/hmglyh/rcyh/bhflow_showProcess.do?bhjl.bhjlid="+rowData.bhjlid+"&definitionKey=bhProcess'>流程图</a>";
    	}
    	return returnString;
    }},
    {field:'bhsbzt',title:'病害上报状态',width:100},
    {field:'pgzt',title:'派工状态',width:100}, 
    {field:'bhwxzt',title:'病害维修状态',width:100},
    {field:'bhlxname',title:'病害类型',width:100},
    {field:'jltime',title:'记录时间',width:140},
    {field:'jlusername',title:'记录人用户名',width:100},
    {field:'bmcode',title:'部门编码',width:100},
    {field:'ldcode',title:'路段编码',width:100},
    {field:'tq',title:'方向',width:100},
    {field:"bbb",title:"桩号",formatter:function(value,rowData){
    	return "K"+rowData.szhhkm + "+" + rowData.szhhm ;
    }},
    {field:'wzbc',title:'位置补充',width:100},
    {field:'qlcode',title:'桥梁编码',width:100},
    {field:'qlname',title:'桥梁名称',width:100},
    {field:'sdcode',title:'隧道编码',width:100},
    {field:'sdname',title:'隧道名称',width:100},
    {field:'hdcode',title:'涵洞编码',width:100},
    {field:'hdname',title:'涵洞名称',width:100},
    {field:'sl',title:'数量',width:100},
    {field:'bz',title:'备注',width:100},
    {field:'sbusername',title:'上报用户名',width:100},
    {field:'sbtime',title:'上报时间',width:100},
    {field:'sbbmcode',title:'上报部门编码',width:100},
    {field:'pgusename',title:'派工用户名',width:100},
    {field:'pgtime',title:'派工时间',width:100},
    {field:'ycpgtime',title:'延期派工时间',width:100}
   
]];
 var BhlxColumns = [[
    {field:'bhname',title:'bhname',width:100},
    {field:'dw',title:'dw',width:100},
    {field:'bhms',title:'bhms',width:100},
    {field:'wxsx',title:'wxsx',width:100},
    {field:'qyzt',title:'qyzt',width:100},
    {field:'px',title:'px',width:100}
]];