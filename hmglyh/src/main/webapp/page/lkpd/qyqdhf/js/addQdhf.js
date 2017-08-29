
var start = parent.szhh;
var avgPci = new Array();				//生成区段划分时用，pci平均值
var avgIri = new Array();				//生成区段划分时用，iri平均值
var avgPciForQuery = new Array();		//查询用pci平均值
var avgIriForQuery = new Array();		//查询用iri平均值
var cacheHighData = null;				//后台查询pci与iri的缓存
var endIndex = 0;						//当前已划分的区段的节点的下标
var startIndex = 0;
var bbState = false;
var pdbbid = 0;
var cacheQdhfList = null;
var cacheBhData = null;
var jdState = false;
var jd = null;
var jdStart = 0;
var jdEnd = 0;

var loadQdhf = function(_list){
	for(var i=0 ; i<_list.length ; i++){
		getIndex(_list[i].ezhh);
		var append = "<tr><td>K"+_list[i].szhh+"-K"+_list[i].ezhh+"<input type='hidden' name='start' value='"+_list[i].szhh+"'/>" +
				"<input type='hidden' name='end' value='"+_list[i].ezhh+"'/><input type='hidden' name='startIndex' value='"+startIndex+"'/>" +
				"<input type='hidden' name='endIndex' value='"+endIndex+"'/></td><td><img style='cursor:pointer;' src='../images/shanchu.png' onclick='Delete(this)'/></td>" +
				"<td><a href='javascript:void(0)' class='easyui-linkbutton' plain='true' onClick='AddJd("+_list[i].szhh+","+_list[i].ezhh+",this)'>节点</a><input type='hidden' name='jds' value='"+_list[i].jd+"'/></td></tr>";
		$("#append").append(append);
		$("#start").text(_list[i].ezhh);
		//计算平均值
		getPjz();
	}
	
};

var AddJd = function(_start,_end,_obj){
	jdStart = _start;
	jdEnd = _end;
	jd = $(_obj).next("input").val();
	YMLib.UI.createWindow("addJd","添加节点","addJd.jsp","box-qdhf",160,200,function(){
		if(jdState){
			$(_obj).next("input").val(jd);
			jdState = false;
		}
		jd = null;
	});
};

var initButton = function(){
	$("#add").click(function(){
		if(!bbState){
			YMLib.UI.Show("没有有数据的路况评定的版本，请先创建版本或者生成路况评定的数据",2000);
			return;
		}
		if($("#end").validatebox("isValid")){
			getIndex($("#end").val());
			var append = "<tr><td>K"+$("#start").text()+"-K"+$("#end").val()+"<input type='hidden' name='start' value='"+$("#start").text()+"'/>" +
					"<input type='hidden' name='end' value='"+$("#end").val()+"'/><input type='hidden' name='startIndex' value='"+startIndex+"'/>" +
					"<input type='hidden' name='endIndex' value='"+endIndex+"'/></td><td><img style='cursor:pointer;' src='../images/shanchu.png' onclick='Delete(this)'/></td>" +
					"<td><a href='javascript:void(0)' class='easyui-linkbutton' plain='true' onClick='AddJd("+$("#start").text()+","+$("#end").val()+",this)'>节点</a><input type='hidden' name='jds'/></td></tr>";
			$("#append").append(append);
			initAddQd($("#start").text(),$("#end").val());
			$("#start").text($("#end").val());
			//计算平均值
			getPjz();
		}
	});
	
	$("#end").blur(function(){
		var value = $("#end").val();
		if(value - $("#start").text() < 0){
			YMLib.UI.Show("止点桩号小于起点桩号，不符合要求",200);
			$("#end").val("");
		}else if(value - parent.ezhh >0){
			YMLib.UI.Show("止点桩号超出区域范围，不符合要求",200);
			$("#end").val("");
		}
	});
	
	$("#query").click(function(){
		if(!bbState){
			YMLib.UI.Show("没有有数据的路况评定的版本，请先创建版本或者生成路况评定的数据",2000);
			return;
		}
		if($("#end").validatebox("isValid")){
			getQueryPjz();
		}
	});
	
	$("#btnSave").click(function(){
		if(!bbState){
			YMLib.UI.Show("没有有数据的路况评定的版本，请先创建版本或者生成路况评定的数据",2000);
			return;
		}
		var params = $("#myForm").serialize()+"&lxCode="+parent.lxCode+"&szhh="+parent.szhh+"&ezhh="+parent.ezhh+"&bmCode="+parent.bmCode;
		YMLib.UI.MaskShow();
		YMLib.Ajax.POST("qdhfb/addQdhfb.do",params,"json",function(result){
			YMLib.UI.MaskHide();
			if(result){
				YMLib.UI.Show("区段划分成功",2000);
				parent.$("#myGrid").datagrid("reload");
				parent.$("#qdhfWindow").window("close");
			}else{
				YMLib.UI.Show("区段划分失败",2000);
			}
		},function(){
			YMLib.UI.MaskHide();
			YMLib.UI.Show("区段划分失败",2000);
		});
	});
};
//点击划分时计算平均值
var getPjz = function(){
	var pci = 0;
	var iri = 0;
//	alert(startIndex+"=="+endIndex);
	for(var i=startIndex ; i <= endIndex ; i++){
		pci += cacheHighData.pci[i];
		iri += cacheHighData.iri[i];
	}
	for(var i=startIndex ; i <= endIndex ; i++){
		avgPci.push(Math.round(pci*100/(endIndex-startIndex+1))/100);
		avgIri.push(Math.round(iri*100/(endIndex-startIndex+1))/100);
	}
//	
//	avgPciForQuery = avgPci.toString().split(",");
//	avgIriForQuery = avgIri.toString().split(",");
//	
//	alert(avgPci.length+"=="+avgIri.length);
	$("#container").highcharts("options").series[1].setData(avgPci);
	$("#container").highcharts("options").series[3].setData(avgIri);
	$("#container").highcharts("options").redraw();
	$("#end").val("");
//	alert(startIndex+"=="+endIndex);
};
//点击查询时计算平均值
var getQueryPjz = function(){
	if(endIndex != 0){
		avgPciForQuery = Copy(avgPci);
		avgIriForQuery = Copy(avgIri);
	}else{
		avgPciForQuery = new Array();		
		avgIriForQuery = new Array();		
	}
	var pci = 0;
	var iri = 0;
	var total = 0;
	var start = 0;
	if(endIndex != 0)
		start = endIndex+1;
	for(var i=start ; cacheHighData.categories[i] - $("#end").val() <= 0; i++){
		pci += cacheHighData.pci[i];
		iri += cacheHighData.iri[i];
		total ++;
	}
	for(var i=start ; cacheHighData.categories[i] - $("#end").val() <= 0; i++){
		avgPciForQuery.push(Math.round(pci*100/total)/100);
		avgIriForQuery.push(Math.round(iri*100/total)/100);
	}
	$("#container").highcharts("options").series[1].setData(avgPciForQuery); 
	$("#container").highcharts("options").series[3].setData(avgIriForQuery);
	$("#container").highcharts("options").redraw();
};

var getIndex = function(_value){
	if(endIndex != 0)
		startIndex = endIndex+1;
	for(var i=endIndex+1;i<cacheHighData.categories.length ; i++){
		if(Math.floor(_value) <= cacheHighData.categories[i]){
			endIndex = i;
			break;
		}
	}
};

var Copy = function(array1){
	var array2 = new Array();
	for(var i=0 ; i<array1.length ; i++){
		array2.push(array1[i]);
	}
	return array2;
};

var Delete = function(_this){
	if($(_this).parent().parent().prev().length != 0){
		start = $(_this).parent().parent().prev().find("input[name=end]").val();
		endIndex = $(_this).parent().parent().prev().find("input[name=endIndex]").val();
		startIndex = $(_this).parent().parent().prev().find("input[name=startIndex]").val();
		$("#qdTable tr[kid="+start+"]").nextAll().remove();
		$("#qdTable tr[kid="+start+"]").remove();
	}else{
		start = parent.szhh;
		startIndex = 0;
		endIndex = 0;
		$("#qdTable tr[kid="+start+"]").eq(0).nextAll().remove();
	}
	$(_this).parent().parent().nextAll().remove();
	$(_this).parent().parent().remove();
	clearPjz();
//	alert(startIndex+"=="+endIndex);
	$("#start").text(start);
};

var clearPjz = function(){
	for(;avgPci.length > endIndex;){
		avgPci.pop();
		avgIri.pop();
	}
	if(endIndex != 0){
		avgPciForQuery = Copy(avgPci);
		avgIriForQuery = Copy(avgIri);
	}else{
		avgPciForQuery = new Array();
		avgIriForQuery = new Array();
	}
	
	$("#container").highcharts("options").series[1].setData(avgPci);
	$("#container").highcharts("options").series[3].setData(avgIri);
	$("#container").highcharts("options").redraw();
};

var initHighCharts = function(){
	$('#container').highcharts({
        chart: {
            zoomType: 'xy',
        },
        title: {
            text: '区段划分',
        },
        xAxis: [{
            categories: cacheHighData.categories,
            minTickInterval : Math.ceil((parent.ezhh-parent.szhh)/10)
        }],
        yAxis: [{ // Primary yAxis
        	min : 0,
        	max : 100,
            labels: {
                style: {
                    color: '#89A54E',
                }
            },
            title: {
                text: 'PCI',
                style: {
                    color: '#89A54E'
                }
            },
            opposite: true,
            gridLineColor : "FFFFFF",
            plotLines : [{
				color : '#C0C0C0',
				dashStyle : 'line',
				value : 70,
				width : 1
			},{
				color : '#C0C0C0',
				dashStyle : 'line',
				value : 85,
				width : 1
			}]
        }, { // Secondary yAxis
        	min : 0,
            gridLineWidth: 0,
            title: {
                text: 'IRI',
                style: {
                    color: '#4572A7'
                }
            },
            labels: {
                style: {
                    color: '#4572A7'
                }
            }

        }],
        tooltip: {
            shared: true
        },
        legend: {
            layout: 'horizontal',
            align: 'center',
            verticalAlign: 'top',
            x : 10,
            y: 30,
            floating: true,
            backgroundColor: '#FFFFFF'
        },
		plotOptions : {
			series : {
				marker : {
					enabled : false	
				}
			}
		},
        series: [{
            name: 'PCI',
            color: '#4575A7',
            type: 'line',
            yAxis: 0,
            data: cacheHighData.pci
        },{
            name: 'PCI平均值',
            color: '#4545A7',
            type: 'line',
            data: [],
            dashStyle: 'shortdot',
        }, {
            name: 'IRI',
            color: '#89A54E',
            type: 'line',
            yAxis: 1,
            data: cacheHighData.iri
        }, {
            name: 'IRI平均值',
            color: '#89A54E',
            type: 'spline',
            yAxis: 1,
            data: [],
            dashStyle: 'shortdot'
        }]
    });
};

var initCombo = function(){
	$("#pdbbid").combobox({
		url : YMLib.url + "bbkzb/getQmbb.do?bblx=0203&isUse=1",
		valueField : "bbid",
		textField : "bbmc",
		onSelect : function(record){
			YMLib.UI.MaskShow();
			YMLib.Ajax.POST("qdhfb/getHighChartData.do","lxCode="+parent.lxCode+"&szhh="+parent.szhh+"&ezhh="+parent.ezhh+"&bbid="+record.bbid,"json",function(data){
				YMLib.UI.MaskHide();
				if(data.pci == null || data.pci.length ==0)
					bbState = false;
				cacheHighData = data;
				initHighCharts();
				loadQdhf(cacheQdhfList);
			},function(){
				YMLib.UI.MaskHide();
				YMLib.UI.Show("查询出错",2000);
			});
			
			initDcCombo(record.bbid);
		},
		onChange : function(){
			start = parent.szhh;
			avgPci = new Array();				//生成区段划分时用，pci平均值
			avgIri = new Array();				//生成区段划分时用，iri平均值
			avgPciForQuery = new Array();		//查询用pci平均值
			avgIriForQuery = new Array();		//查询用iri平均值
			endIndex = 0;						//当前已划分的区段的节点的下标
			startIndex = 0;
			$("#start").text(start);
			$("#append").html("");
		},
		onLoadSuccess : function(){
			var data = $("#pdbbid").combobox("getData");
			if(data == null || data.length == 0){
				YMLib.UI.Show("没有有数据的路况评定的版本，请先创建版本或者生成路况评定的数据",2000);
			}else{
				bbState = true;
				if(pdbbid == 0)
					$("#pdbbid").combobox("select",data[0].bbid);
				else
					$("#pdbbid").combobox("select",pdbbid);
			}
		}
	});
};

var initDcCombo = function(_bbid){
	$("#dcbbid").combobox({
		url : YMLib.url + "bbkzb/getBbid.do?bblx=0201&bbid="+_bbid,
		valueField : "bbid",
		textField : "bbmc",
		onSelect : function(record){
			YMLib.UI.MaskShow();
			YMLib.Ajax.POST("qmldb/getBhfltj.do","lxCode="+parent.lxCode+"&szhh="+parent.szhh+"&ezhh="+parent.ezhh+"&dcbbid="+record.bbid,"json",function(data){
				YMLib.UI.MaskHide();
				cacheBhData = data;
				initDetail();
				loadQdBh();
			},function(){
				YMLib.UI.MaskHide();
				YMLib.UI.Show("查询出错",2000);
			});
		},
		onLoadSuccess : function(){
			var data = $("#dcbbid").combobox("getData");
			$("#dcbbid").combobox("select",data[0].bbid);
		}
	});
};

var initDetail = function(){
	$("#detail tr[kid=add]").remove();
	for(var i=0;i<cacheBhData.length;i++){
		var qmldb = cacheBhData[i];
		var html = "<tr kid=add><td>K"+qmldb.lxCode+"线K"+qmldb.szhh+"-K"+qmldb.ezhh+"</td>" +
				"<td>"+qmldb.jl.toFixed(2)+"</td>"+"<td>"+qmldb.kl.toFixed(2)+"</td>"+"<td>"+qmldb.dtlf.toFixed(2)+"</td>"+
				"<td>"+qmldb.cx.toFixed(2)+"</td>"+"<td>"+qmldb.blyb.toFixed(2)+"</td>"+"<td>"+qmldb.cz.toFixed(2)+"</td>"+
				"<td>"+qmldb.kc.toFixed(2)+"</td>"+"<td>"+qmldb.ss.toFixed(2)+"</td>"+"<td>"+qmldb.fy.toFixed(2)+"</td>"+
				"<td>"+qmldb.xb.toFixed(2)+"</td>"+"<td></td></tr>";
		$("#detail").append(html);
	}
};

var loadQdBh = function(){
	initAddQd(parent.szhh,parent.ezhh);
	for(var y=0;y<cacheQdhfList.length;y++){
		initAddQd(cacheQdhfList[y].szhh,cacheQdhfList[y].ezhh);
	}
};

var initAddQd = function(_start,_end){
	var total = 0;
	var list = [0,0,0,0,0,0,0,0,0,0];
	for(var j=0;j<cacheBhData.length&&cacheBhData[j].szhh<_end;j++){
		if(cacheBhData[j].szhh>=_start){
			total ++;
			list[0]+=cacheBhData[j].jl;
			list[1]+=cacheBhData[j].kl;
			list[2]+=cacheBhData[j].dtlf;
			list[3]+=cacheBhData[j].cx;
			list[4]+=cacheBhData[j].blyb;
			list[5]+=cacheBhData[j].cz;
			list[6]+=cacheBhData[j].kc;
			list[7]+=cacheBhData[j].ss;
			list[8]+=cacheBhData[j].fy;
			list[9]+=cacheBhData[j].xb;
		}
	}
	var html = "<tr kid="+_start+"><td>K"+parent.lxCode+"线K"+_start+"-K"+_end+"</td>";
	for(var x=0;x<list.length;x++){
		html += "<td>"+(list[x]/total).toFixed(2)+"</td>";
	}
	html += "<td></td></tr>";
	$("#qdTable").append(html);
};

$(function(){
	var params = "lxCode="+parent.lxCode+"&szhh="+parent.szhh+"&ezhh="+parent.ezhh+"&bbid="+parent.$("#bbid").combobox("getValue")+"&bmCode="+parent.bmCode;
	YMLib.Ajax.POST("qdhfb/getBb.do",params,"json",function(data){
		cacheQdhfList = data.qdhfList;
		pdbbid = data.qmbbid;
		initCombo();
	},function(){
		YMLib.UI.Show("获取版本以及区段信息失败",2000);
	});
	
	$("#ldCode").text(parent.$("#ldCode").combobox("getText"));
	$("#qdbb").text(parent.$("#bbid").combobox("getText"));
	$("input[name=bbid]").val(parent.$("#bbid").combobox("getValue"));
	$("#start").text(start);
//	initCombo();
	initButton();
	
});
















