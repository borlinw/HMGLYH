var windowid = "luduan";
//var columns = [[
//		    			{'field':'roadcode','title':'所在路线','width':120},
//		    			{'field':'roadname','title':'路线名称','width':80},
//		    			{'field':'startzh','title':'起点桩号(公里)','width':100},
//		    			{'field':'endzh','title':'止点桩号(公里)','width':100},
//		    			{'field':'ldlx','title':'路段类型','width':80},
//		    			{'field':'null','title':'管养单位名称','width':150},
//		    			{'field':'dsmc','title':'地市名称','width':150},
//		    			{'field':'qxmc','title':'区县名称','width':150},
//		    			{'field':'xzdj','title':'行政等级','width':80},
//		    			{'field':'null','title':'车道特征','width':80},
//		    			{'field':'ldxz','title':'路段性质','width':80},
//		    			{'field':'null','title':'路面类型','width':80}
//		    		/*	{'field':'gjsj','title':'gjsj','width':80},
//		    			{'field':'dm','title':'dm','width':80},
//		    			{'field':'sfxz','title':'sfxz','width':80},
//		    			{'field':'sfyfgs','title':'sfyfgs','width':80},
//		    			{'field':'sfqytc','title':'sfqytc','width':80},
//		    			{'field':'ljkd','title':'ljkd','width':80},
//		    			{'field':'sjss','title':'sjss','width':80}*/
//		    		]];

var columns = [[
	 {title:'路线编号',rowspan:3,kid:'roadcode'},
	 {title:'所在行政',colspan:2},
	 {title:'路线名称',rowspan:3},
	 {title:'路段编号',rowspan:3},
	 {title:'路段起止名称',colspan:2},
	 {title:'路段起止桩号',colspan:2},
	 {title:'里程',rowspan:3},
	 {title:'路段基本属性',colspan:10},
	 {title:'修建改建',colspan:2},
	 {title:'最近一次大中修年度',rowspan:3},
	 {title:'断链类型',rowspan:3},
	 {title:'是否城管路段',rowspan:3},
	 {title:'是否断头路段',rowspan:3},
	 {title:'路段收费性质',rowspan:3},
	 {title:'重复路段',colspan:3},
	 {title:'养护管理里程',colspan:4},
	 {title:'地貌',colspan:2},
	 {title:'涵洞数量',rowspan:3},
	 {title:'年平均日交通量（辆/日）',rowspan:3},
	 {title:'管养单位名称',rowspan:3},
	 {title:'省级出入口',rowspan:3},
	 {title:'备注',rowspan:3}],[
      {title:'区划代码',rowspan:2},
      {title:'区划名称',rowspan:2},
      {title:'起点名称',rowspan:2,kid:'startname'},
      {title:'止点名称',rowspan:2,kid:'endname'},
      {title:'起点桩号',rowspan:2,kid:'spos'},
      {title:'止点桩号',rowspan:2,kid:'epos'},
      {title:'技术等级',colspan:2,kid:'jsdjname'},
      {title:'是否一幅高速',rowspan:2},
      {title:'车道数量',rowspan:2},
      {title:'面层类型',colspan:2},
      {title:'面层厚度',rowspan:2},
      {title:'路基宽度',rowspan:2},
      {title:'路面宽度',rowspan:2},
      {title:'设计时速',rowspan:2},
      {title:'修建年度',rowspan:2},
      {title:'改建年度',rowspan:2},
      {title:'路线编号',rowspan:2},
      {title:'起点桩号',rowspan:2},
      {title:'终点桩号',rowspan:2},
      {title:'养护里程',rowspan:2},
      {title:'晴雨通车里程',rowspan:2},
      {title:'可绿化里程',rowspan:2},
      {title:'已绿化里程',rowspan:2},
      {title:'代码',rowspan:2},
      {title:'汉字',rowspan:2}],[
      {title:'代码'},
      {title:'等级'},
      {title:'代码'},
      {title:'等级'}],[
      {title:'1',field:'roadcode',width:100},
      {title:'2',field:'xzqh',width:100},
      {title:'3',field:'xzqhname',width:100},
      {title:'4',field:'roadname',width:100},
      {title:'5',field:'id',width:100},
      {title:'6',field:'startname',width:100},
      {title:'7',field:'endname',width:100},
      {title:'8',field:'spos',width:100},
      {title:'9',field:'epos',width:100},
      {title:'10',field:'mail',width:100},
      {title:'11',field:'jsdj',width:100},
      {title:'12',field:'jsdjname',width:100},
      {title:'13',field:'sfyfgd',width:100},
      {title:'14',field:'cdsl',width:100},
      {title:'15',field:'mclx',width:100},
      {title:'16',field:'mclxmc',width:120},
      {title:'17',field:'mchd',width:100},
      {title:'18',field:'ljkd',width:100},
      {title:'19',field:'lmkd',width:100},
      {title:'20',field:'sjss',width:100},
      {title:'21',field:'xjnd',width:100},
      {title:'22',field:'gjnd',width:100},
      {title:'23',field:'dzxnd',width:120},
      {title:'24',field:'dllx',width:100},
      {title:'25',field:'sfcgld',width:100},
      {title:'26',field:'sddtld',width:100},
      {title:'27',field:'ldsfxz',width:100},
      {title:'28',field:'cfldbh',width:100},
      {title:'29',field:'cfspos',width:100},
      {title:'30',field:'cfepos',width:100},
      {title:'31',field:'yhlc',width:100},
      {title:'32',field:'qytclc',width:100},
      {title:'33',field:'klhlc',width:100},
      {title:'34',field:'ylhlc',width:100},
      {title:'35',field:'dmdm',width:100},
      {title:'36',field:'dmhz',width:100},
      {title:'37',field:'hdsl',width:100},
      {title:'38',field:'npjrjtl',width:150},
      {title:'39',field:'gydw',width:100},
      {title:'40',field:'sjcrk',width:100},
      {title:'41',field:'bz',width:100}]];



function gridsubmit(){
	$("#dg").datagrid("load",getParamForMult("fm"));
}
function onClickRow(rowIndex,rowData){
	top.map.clearLayerByWindowId(windowid);
	var lineJson = {
			windowid:windowid,
			strokeColor:"#00ff00",
			roadcode:rowData.roadcode,
			startzh:rowData.spos,
			endzh:rowData.epos,
			popup:{
				title:"路段详情",
				rowData:rowData,
				columns:columns
			}
		};
	
	top.map.addLineToMap(lineJson);
}