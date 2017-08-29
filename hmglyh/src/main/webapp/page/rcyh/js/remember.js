//即时提醒
var remember = {
	
	interval:1000*60*5,  // 每隔3秒 询问一次
	handler : null, 
	canAsk:true,
	clear : function() {
		clearInterval(handler);
	},
	
	ask:function(showInfo){
		$.ajax({
			url:"/hmglyh/rcyh/home_remember.do",
			dataType:"json",
			success:function(d){
				if(d.isSuccess) {
						remember.changeStatus(d);
						if(showInfo){
							remember.doTask(d);
						}
				}else{
					remember.changeStatus(d);
				}
			}
		});
	},
	
	changeStatus:function(d){
		$("#num2").html(d.bhsbTasks);
		$("#num3").html(d.bhpgTasks);
		$("#num4").html(d.bhwxTasks);
		$("#num5").html(d.wxsbTasks);
		$("#num6").html(d.wxysTasks);
	},
	doTask:function(d){
		remember.canAsk = false;
		var ts = [];
		if( d.bhsbTasks > 0 ) {
			ts.push({
				name:"病害上报",
				size:d.bhsbTasks,
				method:function(){
					bhsb();
				}
			});
		}
 		
		if( d.bhpgTasks > 0 ) {
			ts.push({
				name:"病害派工",
				size:d.bhpgTasks,
				method:function(){
					bhpg();
				}
			});
		}
		
		if( d.bhwxTasks > 0 ) {
			ts.push({
				name:"维修作业",
				size:d.bhwxTasks,
				method:function(){
					bhwx();
				}
			});
		}
		
		if( d.wxsbTasks > 0 ) {
			ts.push({
				name:"维修上报",
				size:d.wxsbTasks,
				method:function(){
					wxsb();
				}
			});
		}
		
		if( d.wxysTasks > 0 ) {
			ts.push({
				name:"作业验收",
				size:d.wxysTasks,
				method:function(){
					wxys();
				}
			});
		}
		
		var html ="";
		$.each(ts,function(i,d){
			html += "您有" + d.size + "个" + d.name + "的任务,<a href='javascrpt:void(0);' onclick='("+d.method+")()'>办理</a><br>";
		});
		
		$.messager.show({  	
			  title:'您有可办理的任务',  	
			  msg:html,  	
			  timeout:3000,  	
			  showType:'slide'  
		});  
	}
};

$(function(){
	setInterval(function(){
		remember.ask(true);
	},remember.interval);
});
