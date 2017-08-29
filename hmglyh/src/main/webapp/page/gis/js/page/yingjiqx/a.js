require.config({
paths: {echarts: './../Style/echarts/echarts-map', 'echarts/chart/bar': './../Style/echarts/echarts-map','echarts/chart/line': './../Style/echarts/echarts-map','echarts/chart/map': './../Style/echarts/echarts-map'}});
require(['echarts','echarts/chart/bar','echarts/chart/line','echarts/chart/map'], function (ec) {
	var myChart = ec.init(document.getElementById('main'));  myChart.setOption(
{  
tooltip: {trigger: 'item',},   
legend: {data: ['自然区划','公路功能','交通量','交通组成','穿越情况','其他']},  
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
xAxis: [{type: 'value',      axisLabel: { show: true, formatter: function (value) { return 'K' + Math.floor(value / 1000) + '+' + (value % 1000); } },     min: 906000,    max: 1088810,    splitNumber: 5,    scale: true  }],  
yAxis: [{type: 'category',data: ['自然区划','公路功能','交通量','交通组成','穿越情况','其他']}], 
series: [
	{   name: '辅助', type: 'line', stack: '总量', itemStyle: { normal: { borderColor: 'rgba(0,0,0,0)', color: 'rgba(0,0,0,0)' }, emphasis: { borderColor: 'rgba(0,0,0,0)', color: 'rgba(0,0,0,0)' }, }, data: [906,936,966,996,1026,1056,1088] },  
	{     
		name: '交通组成', 
		type: 'scatter',    
		data: [906,936,966,996,1026,1056,1088],    
		markLine: {
			symbol: 'arrow',
			symbolSize: [5, 5],
			itemStyle: {
				normal: {
					label: {
						show: true,
						position: 'top',
						formatter:function(value){
							return value.value;
						}
					},
					labelLine: {show: true}
				},
				emphasis: {label: { show: false,position: 'top'}}
			},
			data: [        [          { name: '起点:K906+0', value: '重载交通(20％-35％)', xAxis: 906000, yAxis: 0 },          { name: '终点:K1088+810', xAxis: 1088810, yAxis: 0 }        ]      ]
		}
	},  
	{     
		name: '交通量', 
		type: 'scatter',    
		data: [906,936,966,996,1026,1056,1088],    
		markLine: {
			symbol: 'arrow',
			symbolSize: [5, 5],
			itemStyle: {normal: {label: {show: true,position: 'top',
						formatter:function(value){
							return value.value;
						}},labelLine: {show: true}},emphasis: {label: { show: false, position: 'top'}}},   
			data: [        
			[          { name: '分割线', value: '分割线', xAxis: 1068000, yAxis: -1 },          { name: '', xAxis: 1068000, yAxis: 1 }        ],        
			[          { name: '起点:K1068+0', value: '2000-10000辆', xAxis: 1068000, yAxis: 1 },          { name: '终点:K1088+810', xAxis: 1088810, yAxis: 1 }        ],        
			[          { name: '起点:K906+0', value: '2000-10000辆', xAxis: 906000, yAxis: 1 },          { name: '终点:K1068+0', xAxis: 1068000, yAxis: 1 }        ],        
			[          { name: '分割线', value: '分割线', xAxis: 1068000, yAxis: -1 },          { name: '', xAxis: 1068000, yAxis: 1 }        ]      ]
		}  
	},  
	{     
		name: '路面结构类型', 
		type: 'scatter',    
		data: [906,936,966,996,1026,1056,1088],    
		markLine: {
			symbol: 'arrow',
			symbolSize: [5, 5],
			itemStyle: {normal: {label: {show: true,position: 'top',
						formatter:function(value){
							return value.value;
						}},
			labelLine: {show: true}},
			emphasis: {label: { show: false, position: 'top'}}},   
			data: [        
				[          { name: '起点:K906+0', value: '沥青路面', xAxis: 906000, yAxis: 2 },          { name: '终点:K1088+810', xAxis: 1088810, yAxis: 2 }        ]      
			]
		}  
	},  
	{     
		name: '地质特征', 
		type: 'scatter',    
		data: [906,936,966,996,1026,1056,1088],    
		markLine: {
			symbol: 'arrow',
			symbolSize: [5, 5],
			itemStyle: {normal: {label: {show: true,position: 'top',
						formatter:function(value){
							return value.value;
						}},labelLine: {show: true}},emphasis: {label: { show: false, position: 'top'}}},   
			data: [
				[          { name: '分割线', value: '分割线', xAxis: 988000, yAxis: -1 },          { name: '', xAxis: 988000, yAxis: 3 }        ],
				[          { name: '起点:K988+0', value: '砂、砾类土', xAxis: 988000, yAxis: 3 },          { name: '终点:K1088+810', xAxis: 1088810, yAxis: 3 }        ],        
				[          { name: '起点:K906+0', value: '特殊土（常见的有盐渍土、冻土）对路基稳定存在较大影响', xAxis: 906000, yAxis: 3 },          { name: '终点:K988+0', xAxis: 988000, yAxis: 3 }        ],        
				[          { name: '分割线', value: '分割线', xAxis: 988000, yAxis: -1 },          { name: '', xAxis: 988000, yAxis: 3 }        ]      
			]
		}  
	},  
	{     
		name: '公路功能', 
		type: 'scatter',    
		data: [906,936,966,996,1026,1056,1088],    
		markLine: {
			symbol: 'arrow',
			symbolSize: [5, 5],
			itemStyle: {normal: {label: {show: true,position: 'top',
						formatter:function(value){
							return value.value;
						}},labelLine: {show: true}},emphasis: {label: { show: false, position: 'top'}}},   
			data: [        
				[          { name: '起点:K906+0', value: '干线公路', xAxis: 906000, yAxis: 4 },          { name: '终点:K1088+810', xAxis: 1088810, yAxis: 4 }        ]      
			]
		}  
	},  
	{     
		name: '穿越情况', 
		type: 'scatter',    
		data: [906,936,966,996,1026,1056,1088],    
		markLine: {
			symbol: 'arrow',
			symbolSize: [5, 5],
			itemStyle: {normal: {label: {show: true,position: 'top',
						formatter:function(value){
							return value.value;
						}},labelLine: {show: true}},emphasis: {label: { show: false, position: 'top'}}},   
			data: [        
				[          { name: '分割线', value: '分割线', xAxis: 1043000, yAxis: -1 },          { name: '', xAxis: 1043000, yAxis: 5 }        ],
				[          { name: '起点:K1043+0', value: '城镇', xAxis: 1043000, yAxis: 5 },          { name: '终点:K1045+0', xAxis: 1045000, yAxis: 5 }        ],        
				[          { name: '分割线', value: '分割线', xAxis: 1045000, yAxis: -1 },          { name: '', xAxis: 1045000, yAxis: 5 }        ]      
				]
		}  
	}
	]
	}
	);
	}
	);