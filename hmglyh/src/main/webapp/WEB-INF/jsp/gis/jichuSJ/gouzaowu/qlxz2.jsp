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
              
                myChart.showLoading({
                    text: '正在玩命的加载...',    //loading话术
                });
				
                myChart.hideLoading();
                
                var label = {
                	    normal : {
                	        label : {
                	            show : true,
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
	                var dislabel = {
	               		 normal : {
	               		        color: '#ccc',
	               		        label : {
	               		        	textStyle:{color:"#ccc"},
	               		            show : true,
	               		            formatter : '{a}',
	               		            position : 'center'
	               		        },
	               		        labelLine : {
	               		            show : false
	               		        }
	               		    }
	               };
                	var radius = [40, 55];
                	option = {
                	    legend: {
                	        x : 'center',
                	        y : 'center',
                	        data:["永久性","未分类"]
                	    },
                	    title : {
                	        text: '按桥梁性质统计',
                	        x: 'center',
                	        textStyle:{
                	        	fontSize:14,
                	        	color:'#0791a8',
                	        	fontWeight:'bolder'
                	        }
                	    },
                	    toolbox: {
                	        show : true,
                	        feature : {
                	            dataView : {show: false, readOnly: false},
                	            magicType : {
                	                show: false, 
                	                type: ['pie'],
                	            },
                	            restore : {show: false},
                	            saveAsImage : {show: true}
                	        }
                	    },
                	    tooltip:{show:true},
                	    series : [
                	      <s:iterator value="resultMap" id="entry" status="status">  
                	        {
                	            type : 'pie',
                	            name : '<s:property value="#entry.key" />',
                	            center : ['<s:property value="%{10 + (#status.index % 4 )* 25}" />%', '<s:property value="%{30 + (#status.index / 4 ) * 40}"/>%'],
                	            radius : radius,
                	            data : [
                	                  <s:if test = "#entry.value.size == 0 ">
            	                   		{name:"无数据",value:"4",itemStyle : dislabel,tooltip:{formatter:"暂无数据"}}
		           	                   </s:if>
		           	                   <s:if test="#entry.value.size > 0 "> 
		           	                   <s:iterator value="#entry.value" id="row" status="statuss" >
		               	              		{name:'<s:property value="#row.name" escape='false' />', value:'<s:property value="#row.value" escape='false' />', itemStyle : label}
		               	              		<s:if test="#entry.value.size != #statuss.index + 1">,</s:if>
		               	              	</s:iterator>
		           	                   </s:if>
                	            ]
                	        }
                	        <s:if test="resultMap.size != #status.index + 1">,</s:if>
                	      </s:iterator>
                	        
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