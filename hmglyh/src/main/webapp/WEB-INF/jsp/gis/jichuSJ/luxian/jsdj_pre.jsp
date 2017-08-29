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
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('main')); 
                var roads= [<s:iterator value="roadRows" id="road" status="status">'<s:property value="#road.name"  escape='false' />'<s:if test='roadRows.size != #status.index + 1'>,</s:if></s:iterator>];
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
                	        text: '技术等级',
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
                	        data:["高速公路","一级公路","二级公路","三级公路","四级公路","五级公路"]
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
                	            radius: [0, '60%'],
                	            // for funnel
                	            x: '20%',
                	            width: '40%',
                	            funnelAlign: 'right',
                	            max: 1548,
                	            
                	            itemStyle : {
                	                normal : {
                	                    label : {
                	                        formatter : "{b} : {c} ({d}%)"
                	                    },
                	                    labelLine : {
                	                        show : true
                	                    }
                	                }
                	            },
                	            data:[
                	                <s:iterator value="jsdjRows" id="jsdj" status="status">
                  	                {value:<s:property value="#jsdj.value" />, name:"<s:property value='#jsdj.name' escape='false' />"}<s:if test="jsdjRows.size != #status.index + 1">,</s:if>
                  	                </s:iterator>
                	            ]
                	        }
                	    ]
                	};
        
              
                // 为echarts对象加载数据 
                myChart.setOption(option); 
                window.onresize = myChart.resize;
            }
        );
    </script>
</body>
	
</body>
</html>