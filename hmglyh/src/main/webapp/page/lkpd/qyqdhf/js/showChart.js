
var names = '龟裂,块裂,纵、横向裂缝,沉陷,波浪拥包,车辙,坑槽,松散,泛油,修补';
var code = new Array('jl','kl','dtlf','cx','blyb','cz','kc','ss','fy','xb');

var initCombo = function(){
	$("#dcbbid").combobox({
		url : YMLib.url + "bbkzb/getQmbb.do?bblx=0201",
		textField : "bbmc",
		valueField : "bbid",
		onSelect : function(record){
			var params = "dcbbid="+record.bbid+"&bbid="+parent.$("#bbid").combobox("getValue")+"&lxCode="+parent.lxCode+"&szhh="+parent.szhh+
						"&ezhh="+parent.ezhh+"&bmCode="+parent.bmCode;
			YMLib.Ajax.POST("qdhfb/getBhfl.do",params,"json",function(data){
				getOption(data);
			},function(){
			});
		},
		onLoadSuccess : function(){
			var data = $("#dcbbid").combobox("getData");
			$("#dcbbid").combobox("select",data[0].bbid);
		}
	});
};

var getOption = function(_list){
	var name=names.split(",");	
	var series = [];
	for(var i=0;i<_list.length;i++){
		var row = [];
		var label = {
    	    normal : {
    	        label : {
    	            position : 'center',
    	            formatter : '{a}',
    	        },
    	        labelLine : {
    	            show : false
    	        }
    	    }
    	};
		
		var rowLabel = {
	    	    normal : {
	    	        label : {
	    	            position : 'outer',
	    	            formatter : function (params) {                         
                          return (params.percent - 0).toFixed(0) + '%';
                        }
	    	        },
	    	        labelLine : {
	    	            show : true
	    	        }
	    	    }
	    	};
		for(var j=0;j<name.length;j++){
			var ceil = {name:name[j],value:_list[i][code[j]],itemStyle:rowLabel};
			row.push(ceil);
		}
		row.push({name:'title',value:0});
		var title = 'K'+_list[i].szhh+'-K'+_list[i].ezhh;
		
		
		var serie = {type:'pie',
					radius:[40,55],
					itemStyle : label,
					name:title,
					data:row};
		if(_list.length>4){
			var x = ((i%4)*20+10)+'%';
			var center = [((i%4+1)*20)+'%',(parseInt(i/4)*40+30)+'%'];
			serie.x=x;
			serie.center=center;
			if(i>4)
				serie.y='55%';
		}else{
			serie.x = ((i%4)*20+10)+'%';
			serie.center = [((i%4+1)*20)+'%','50%'];
		};
		series.push(serie);
	}
	initChart(series);
};

var initChart = function(_series){

	require.config({
		paths: {
            echarts: 'http://echarts.baidu.com/build/dist'
        }
	});
	require(
		[
         	'echarts',
         	'echarts/chart/bar',
         	'echarts/chart/line',
         	'echarts/chart/pie'
         ],
		function(ec){
			var myChart = ec.init(document.getElementById("myChart"));
			var options = {  
				legend: {data: ['龟裂','块裂','纵、横向裂缝','沉陷','波浪拥包','车辙','坑槽','松散','泛油','修补']}, 
        	    tooltip:{show:true},
				toolbox: {
					show: true,     
					feature: { 
						mark: { show: false },
						dataView: { show: false, readOnly: false },
						restore: { show: false },
						saveAsImage: { show: true }
						}
					},  
				series: _series
			};
			myChart.setOption(options);
			
			console.info(options);
			
			$(window).resize(function(){
				$(myChart).resize();
			});
		}
	);
};

$(function(){
	initCombo();
});





















