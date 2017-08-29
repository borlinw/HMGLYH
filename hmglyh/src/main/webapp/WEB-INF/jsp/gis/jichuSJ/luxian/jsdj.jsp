<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../../public/charthead.jsp"%>
<title>路线技术等级</title>
</head>
<body>
	<%-- <s:debug></s:debug> --%>
	<div id="main" style="width:98%;height:98%;padding:5px;"></div>
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
                    text: '正在加载...',    //loading话术
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
                	        data:[<s:iterator value="roadRows" id="road" status="status">'<s:property value="#road.name"  escape='false' />'<s:if test='roadRows.size != #status.index + 1'>,</s:if></s:iterator>]
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
                	                <s:iterator value="jsdjRows" id="jsdj" status="status">
                  	                {value:<s:property value="#jsdj.value" />, name:"<s:property value='#jsdj.name' escape='false' />"}<s:if test="jsdjRows.size != #status.index + 1">,</s:if>
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
                	                <s:iterator value="roadRows" id="road" status="status">
                	                {value:<s:property value="#road.value" />, name:"<s:property value='#road.name' escape='false' />"}<s:if test="roadRows.size != #status.index + 1">,</s:if>
                	                </s:iterator>
                	            ]
                	        }
                	    ]
                	};
                myChart.setOption(option); 
                window.onresize = myChart.resize;
            }
        );
    </script>
</body>
</html>