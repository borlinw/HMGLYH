<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../public/charthead.jsp"%>
<title>路线技术等级</title>
</head>
<body>
	<%-- <s:debug></s:debug> --%>
	<div id="main" style="width:98%;height:98%;margin:0px;padding:5px;"></div>
	
	
	
	 <script type="text/javascript">
        // 路径配置
        require.config({
            paths: {
                echarts: 'http://echarts.baidu.com/build/dist'
            }
        });
        
        // 使用
        require(
            [
                'echarts',
                'echarts/chart/pie', // 使用柱状图就加载bar模块，按需加载
                'echarts/chart/funnel'
            ],
            function (ec) {
            	var label = {
                	    normal : {
                	        label : {
                	            show : false,
                	            position : 'center',
                	            formatter : '{a}',
                	            textStyle: {
                	                baseline : 'bottom'
                	            }
                	        },
                	        labelLine : {
                	            show : false
                	        }
                	    }
                	};    
            	
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('main')); 
                var roads= [<s:iterator value="roads" id="road" status="status">'<s:property value="#road.name"  escape='false' />'<s:if test='roads.size != #status.index + 1'>,</s:if></s:iterator>];
                var exroads = [];
            
                myChart.showLoading({
                    text: '正在玩命的加载...',    //loading话术
                });
				
                myChart.hideLoading();
                
                option = {
                	    tooltip : {
                	        trigger: 'item',
                	        formatter: "{a} <br/>{b} : {c} ({d}%)"
                	    },
                	    title : {
                	        text: '隧道按类型统计',
                	        x: 'center',
                	        textStyle:{
                	        	fontSize:14,
                	        	color:'#0791a8',
                	        	fontWeight:'bolder'
                	        }
                	    },
                	    legend: {
                	        orient : 'vertical',
                	        x : 'left',
                	        data:[<s:iterator value="roads" id="road" status="status">'<s:property value="#road.name"  escape='false' />'<s:if test='roads.size != #status.index + 1'>,</s:if></s:iterator>]
                	    },
                	    toolbox: {
                	        show : true,
                	        feature : {
                	            mark : {show: false},
                	            dataView : {show: false, readOnly: false},
                	            magicType : {
                	                show: false, 
                	                type: ['pie', 'funnel']
                	            },
                	            restore : {show: false},
                	            saveAsImage : {show: true}
                	        }
                	    },
                	    calculable : false,
                	    series : [
                	        {
                	            name:'评定等级',
                	            type:'pie',
                	            selectedMode: 'single',
                	            radius : [0, 70],
                	            
                	            // for funnel
                	            x: '20%',
                	            width: '40%',
                	            funnelAlign: 'right',
                	            max: 1548,
                	            
                	            itemStyle : {
                	                normal : {
                	                    label : {
                	                        position : 'inner'
                	                    },
                	                    labelLine : {
                	                        show : false
                	                    }
                	                }
                	            },
                	            data:[
                	                <s:iterator value="chartRows" id="row" status="status">
                  	                {value:<s:property value="#row.value" />, name:"<s:property value='#row.name' escape='false' />", itemStyle : label}<s:if test="chartRows.size != #status.index + 1">,</s:if>
                  	                </s:iterator>
                	            ]
                	        },
                	        {
                	            name:'路线长度',
                	            type:'pie',
                	            radius : [100, 140],
                	            
                	            // for funnel
                	            x: '60%',
                	            width: '35%',
                	            funnelAlign: 'left',
                	            max: 1048,
                	            
                	            data:[
                	                <s:iterator value="roads" id="road" status="status">
                	                {value:<s:property value="#road.value" />, name:"<s:property value='#road.name' escape='false' />"}<s:if test="roads.size != #status.index + 1">,</s:if>
                	                </s:iterator>
                	            ]
                	        }
                	    ]
                	};
        
                var ecConfig = require('echarts/config');
                myChart.on(ecConfig.EVENT.DATA_CHANGED, function (param){
                	console.log(param);
                	
                	if( param.seriesIndex > 0 ) {
                		exroads.push(param.name);
                	}else{
               		 	 for( var i = 0 ; i < exroads.length ; i++ ) {
     						if( exroads[i] == param.name ) {
     							exroads.splice(i,1);
     						}						
                      	 }
                	}
                	
                	console.log("exroads:%o",exroads);
                	
                    var newRoads = [];
                    
                    for( var i = 0 ; i < roads.length ; i++ ) {
                    	var isFound = true;
                    	for( var j = 0; j < exroads.length ; j ++ ) {
                    		if( roads[i] == exroads[j]) {
                    			isFound = false;
                    		}	
                    	}
                    	if( isFound) {
                    		newRoads.push(roads[i]);
                    	}
                    }
                    
                    console.log("newRoads:%o",newRoads);
                  
                    myChart.setOption({legend:{data:newRoads}});
                    
                    $.ajax({
                    	url:"${pageContext.request.contextPath}/gis/gouzaowu_qlkjflChart.do",
                    	dataType:"json",
                    	data:{
                    		roadcodes:newRoads
                    	},
                    	traditional:true,
                    	success:function(result){
                    		myChart.setSeries([
                                      	        {
                                   	            name:'技术等级',
                                   	            type:'pie',
                                   	            selectedMode: 'single',
                                   	            radius : [0, 70],
                                   	            // for funnel
                                   	            x: '20%',
                                   	            width: '40%',
                                   	            funnelAlign: 'right',
                                   	            itemStyle : {
                                   	                normal : {
                                   	                    label : {
                                   	                        position : 'inner'
                                   	                    },
                                   	                    labelLine : {
                                   	                        show : false
                                   	                    }
                                   	                }
                                   	            },
                                   	            data:result.rows
                                   	        },
	                                   	    {
                                	            name:'路线长度',
                                	            type:'pie',
                                	            radius : [100, 140],
                                	            // for funnel
                                	            x: '60%',
                                	            width: '35%',
                                	            funnelAlign: 'left',
                                	            data:result.roads
	                                	     }
                                   	    ],true);
                    	}
                    });
                });
                // 为echarts对象加载数据 
                myChart.setOption(option); 
                window.onresize = myChart.resize;
            }
        );
    </script>
</body>
	
</body>
</html>