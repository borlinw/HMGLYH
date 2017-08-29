var title = ['zrqh','glgn','jtl','jtzc','cyqk','qt'];
var titleName = ['自然区划','公路功能','交通量','交通组成','穿越情况','其他'];

$(function(){
	var params = parent.chartParam;
	YMLib.UI.MaskShow();
	YMLib.Ajax.POST("qyhfb/getXxbForUpdate.do",params,"json",function(result){
		YMLib.UI.MaskHide();
		if(result != null && result.length != 0){
			loadChart(result);
		}else{
			YMLib.UI.Show("未查询到相应的详细信息",2000);
		}
	},function(){
		YMLib.UI.MaskHide();
	});
	
});

var loadChart = function(_data){
	var series = new Array();
	var serie = new Array();
	var state = '';
	for(var i=0;i<=_data.length;i++){
		if(i == 0){
			state = _data[i].yxys;
		}else if(i == _data.length){
			var rows = {     
				name: titleName[getIndex(state)], 
				type: 'scatter',    
				data: [parent.szhh,parent.ezhh],    
				markLine: {
					symbol: 'arrow',
					symbolSize: [5, 5],
					itemStyle: {normal: {label: {show: true,position: 'top',
								formatter:function(value){
									return value.value;
								}},labelLine: {show: true}},emphasis: {label: { show: false, position: 'top'}}},   
					data: serie
				}  
			};
			series.push(rows);
			break;
		}else if(_data[i].yxys != state){
			var rows = {     
				name: titleName[getIndex(state)], 
				type: 'scatter',    
				data: [parent.szhh,parent.ezhh],    
				markLine: {
					symbol: 'arrow',
					symbolSize: [5, 5],
					itemStyle: {normal: {label: {show: true,position: 'top',
								formatter:function(value){
									return value.value;
								}},labelLine: {show: true}},emphasis: {label: { show: false, position: 'top'}}},   
					data: serie
				}  
			};
			series.push(rows);
			
			serie = new Array();
			state = _data[i].yxys;
		}
		
		var row = [{name:'起点：K'+Math.floor(_data[i].szhh) + '+' + (_data[i].szhh*1000 % 1000),value:_data[i].dj,xAxis:_data[i].szhh*1000,yAxis:getIndex(_data[i].yxys)},
		           {name:'止点：K'+Math.floor(_data[i].ezhh) + '+' + (_data[i].ezhh*1000 % 1000),xAxis:_data[i].ezhh*1000,yAxis:getIndex(_data[i].yxys)}];
		serie.push(row);
		if(_data[i].szhh != parent.szhh){
			var row_start = [{name:'分割线',value:'分割线',xAxis:_data[i].szhh*1000,yAxis:-1},
			           {name:'分割线',value:'分割线',xAxis:_data[i].szhh*1000,yAxis:getIndex(_data[i].yxys)}];
			serie.push(row_start);
		}
		if(_data[i].ezhh != parent.ezhh){
			var row_end = [{name:'分割线',value:'分割线',xAxis:_data[i].ezhh*1000,yAxis:-1},
					           {name:'分割线',value:'分割线',xAxis:_data[i].ezhh*1000,yAxis:getIndex(_data[i].yxys)}];
			serie.push(row_end);
		}
		
	}
	
	loadQyhfChart(series);
};

var getIndex = function(_value){
	for(var i=0;i<title.length;i++){
		if(title[i] == _value)
			return i;
	}
	return -1;
};

var loadQyhfChart = function(_series){
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
         	'echarts/chart/map',
         	'echarts/chart/scatter'
         ],
		function(ec){
			var myChart = ec.init(document.getElementById("chart"));
			var options = {  
				tooltip: {trigger: 'item',},   
				legend: {data: titleName},  
				toolbox: {
					show: true,     
					feature: { 
						mark: { show: false },
						dataView: { show: false, readOnly: false },
						restore: { show: false },
						saveAsImage: { show: true }
						}
					},  
				calculable: true, 
				xAxis: [{type: 'value',      axisLabel: { show: true, formatter: function (value) { return 'K' + Math.floor(value / 1000) + '+' + Math.floor(value % 1000); } },     min: parent.szhh*1000,    max: parent.ezhh*1000,    splitNumber: 5,    scale: true  }],  
				yAxis: [{type: 'category',data: titleName}], 
				series: _series
			};
			myChart.setOption(options);
			
			$(window).resize(function(){
				$(myChart).resize();
			});
		});
};








