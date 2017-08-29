var lxCode = null;
var szhh = null;
var ezhh = null;

var ldState = false;
var bbState = false;

var cacheQdhfList = null;
var cacheHighData = null;

var endIndex = 0;						//当前已划分的区段的节点的下标
var startIndex = 0;


var initCombo = function(){
	YMLib.Ajax.POST("qyhfb/queryQyhfb.do","bmCode="+parent.currentGridRows.bmCode1+"&bbid="+parent.currentGridRows.bbid1,"json",function(data){
		$("#ldCode").combobox({
			valueField : "qyid",
			textField : "qyName",
			onSelect : function(data){
				lxCode = data.lxCode;
				szhh = data.szhh;
				ezhh = data.ezhh;
			}
		}).combobox("loadData",data.rows);
		$("#ldCode").combobox("select",data.rows[0].qyid);
		//表格初始化
		ldState = true;
		if(bbState){
			getTable();
		}
		getQdhfData();
		getLkpdData();
	});
	
	$("#dcbbid").combobox({
		url : YMLib.url + "bbkzb/getBbid.do?bblx=0201&bbid="+ parent.currentGridRows.qmbbid,
		valueField : "bbid",
		textField : "bbmc",
		onLoadSuccess : function(){
			var data = $("#dcbbid").combobox("getData");
			$("#dcbbid").combobox("select",data[0].bbid);
			//表格初始化
			bbState = true;
			if(ldState){
				getTable();
			}
		}
	});
	
};

var getTable = function(){
	var params = "bbid="+parent.currentGridRows.bbid1+"&dcbbid="+$("#dcbbid").combobox("getValue")+"&lxCode="+lxCode+"&szhh="+szhh+"&ezhh="+ezhh;
	var src = YMLib.reportUrl + "reportlet="+YMLib.cjkEncode('区段划分病害列表')+".cpt&"+YMLib.cjkEncode(params);
	$("#bhlb").attr("src",src);
};


var initButton = function(){
	$("#query").click(function(){
		getTable();
		getQdhfData();
		getLkpdData();
	});
};

$(function(){
	initCombo();
	initButton();
});


var getQdhfData = function(){
	//区段划分信息
	var params = "lxCode="+lxCode+"&szhh="+szhh+"&ezhh="+ezhh+"&bbid="+parent.currentGridRows.bbid1+"&bmCode="+parent.currentGridRows.bmCode1;
	YMLib.Ajax.POST("qdhfb/getBb.do",params,"json",function(data){
		cacheQdhfList = data.qdhfList;
		if(cacheHighData != null){
			loadQdhf(cacheQdhfList);
		}
	},function(){
		YMLib.UI.Show("获取版本以及区段信息失败",2000);
	});
};

var getLkpdData = function(){
	//路况评定信息
	YMLib.Ajax.POST("qdhfb/getHighChartData.do","lxCode="+lxCode+"&szhh="+szhh+"&ezhh="+ezhh+"&bbid="+parent.currentGridRows.qmbbid,"json",function(data){
		cacheHighData = data;
		if(cacheQdhfList != null){
			loadQdhf(cacheQdhfList);
		}
	},function(){
		YMLib.UI.Show("查询出错",2000);
	});
	
};

//加载区段划分iri，pci平均值
var loadQdhf = function(_list){
	endIndex = 0;	
	startIndex = 0;
	cacheHighData.avgPci = [];
	cacheHighData.avgIri = [];
	for(var i=0;i<_list.length;i++){
		getIndex(_list[i].ezhh);
		getPjz();
	}
	console.info(cacheHighData);
	initHighCharts();
};

//获取index
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

//求平均值
var getPjz = function(){
	var pci = 0;
	var iri = 0;
	for(var i=startIndex ; i <= endIndex ; i++){
		pci += cacheHighData.pci[i];
		iri += cacheHighData.iri[i];
	}
	for(var i=startIndex ; i <= endIndex ; i++){
		cacheHighData.avgPci.push(Math.round(pci*100/(endIndex-startIndex+1))/100);
		cacheHighData.avgIri.push(Math.round(iri*100/(endIndex-startIndex+1))/100);
	}
};






//加载highchart图表
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
            minTickInterval : Math.ceil((ezhh-szhh)/10)
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
            data: cacheHighData.avgPci,
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
            data: cacheHighData.avgIri,
            dashStyle: 'shortdot'
        }]
    });

};



























