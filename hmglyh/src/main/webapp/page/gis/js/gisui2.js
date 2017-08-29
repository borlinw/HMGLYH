/**
 *
 *  依赖：jquery 1.8.1
 *	      easyUI 1.3.2
 *	功能  easyUI再封装
 *	作者：zlm
 *	修改于 2015年5月4日10:22:20
 *
 */

// 类 GisUI 管理所有的窗口
function GisUI(config){

	this.config = {
		isShowToolBar : true,		// 是否显示窗口控制按钮
		debug:false			// 是否显示调试信息
	};

	$.extend(this.config,config);
	
	this.windows = [];		//当前正在显示的窗口
	this.closedWindows = [];	//当前已经关闭的窗口
	this.minWindows = [];		//当前最小化的窗口
	

	this.createWindow = function(jsonObj) {	// 创建一个窗口

		if(jsonObj.id != undefined ) {
			
			var isFind = this.findWindowById(jsonObj.id , function(i,d,arr) {
			//	gisui.windows.push(arr.splice(i,1));
				d.open();
			});
			
			if(isFind) {
				return;
			}

		}
		if( jsonObj.left == undefined && jsonObj.top == undefined) {

			if( this.windows.length > 0 ) {
				jsonObj.left = this.windows[ this.windows.length - 1 ].attribution.left + 20;
				jsonObj.top = this.windows[this.windows.length - 1 ].attribution.top + 20;
			}else{
				jsonObj.left = 240;
				jsonObj.top = 30;
			}
		
		}
		
		var win = new Window(jsonObj);
		win.create();
		this.windows.push(win);
		this.debug();
		this.drawToolbarButtons();

	};

	this.closeWindow = function(id) {		// 关闭一个窗口
		this.findWindowById(id,function(i,d){
			d.close();
		});
	};

	this.destroyWindow = function(id) {	// 摧毁一个窗口
		this.findWindowById(id,function(i,d){
			//console.log(d);
			d.destroy();
		});
	};

	this.minWindow = function(id) {		// 最小化一个窗口
		this.findWindowById(id,function(i,d){
		//	console.log(d);
			d.min();
		});
	};

	this.minAllWindow = function() {		// 最小化所有的窗口
		var len = this.windows.length;
		for( var i = 0 ; i < len; i ++ ) {
			this.minWindow(this.windows[i].attribution.id);
		}
	};

	this.closeAllWindows = function() {	// 关闭所有的窗口
	
	};

	this.findWindowById = function(id,callback) {	// 根据id 返回 窗口， 如果没有找到 返回null;

		for( var i = 0; i < this.windows.length ; i++ ) {	// 从当前正在显示的窗口中查找
			if( this.windows[i].attribution.id == id ) {
				callback(i,this.windows[i],this.windows);
				return true;
			}
		}

		return false;

	/*	for( var i = 0; i < this.closedWindows.length ; i++ ) {	// 从当前正在关闭的窗口中查找
			if( this.closedWindows[i].attribution.id == id ) {
				callback(i,this.closedWindows[i],this.closedWindows);
				return;
			}
		}


		for( var i = 0; i < this.minWindows.length ; i++ ) {	// 从已经最小化的窗口中查找
			if( this.minWindows[i].attribution.id == id ) {
				callback(i,this.minWindows[i],this.minWindows);
				return;
			}
		}*/


	};

	this.destroyAllWindows = function() { 	// 摧毁所有的窗口
		var len = this.windows.length;
		for( var i = 0 ; i < len; i ++ ) {
			if( this.windows[0].attribution.id != "debugbox" ) {
				this.destroyWindow(this.windows[0].attribution.id);
			}
		}
	};
	
	this.replaceTable = function() {   // 重新排列窗口
		var left = 50;
		var top = 50;
		var len = this.windows.length;
		for( var i = 0 ; i < len; i ++ ) {
			if( this.windows[i].attribution.id != "debugbox" ) {
				$("#"+this.windows[i].attribution.id).window("move",{left:left,top:top});
				left += 50;
				top += 50;
			}
		}
	};
	
	this.replaceTableH = function() {   // 重新排列窗口
		documentWidth = document.body.clientWidth ;
		var left = 0;
		var top = 25;
		var len = this.windows.length;
		for( var i = 0 ; i < len; i ++ ) {
			if( this.windows[i].attribution.id != "debugbox" ) {
				console.log(top);
				if( left < documentWidth ) {
					$("#"+this.windows[i].attribution.id).window("move",{left:left,top:top});
					var w = $("#"+this.windows[i].attribution.id).window("options").width;
					left += w;
				}else{
					var h = $("#"+this.windows[i].attribution.id).window("options").height;
					top += h;
					left = 0;
					$("#"+this.windows[i].attribution.id).window("move",{left:left,top:top});
				}
			}
		}
	};

	this.showToolbar = function() {		//显示控制窗口顶层显示的容器
		var _html = "<div id='mytoolbar' style='position:absolute;padding:0px;left:0px;top:0px;height:auto;width:100%;z-index:1000;' class='panel-header panel-header-noborder window-header' ></div>";
		$("body").append(_html);

	};

	this.drawToolbarButtons = function() {	//重绘控制窗口顶层显示的按钮

		if(!this.config.isShowToolBar) {
			return;
		}

		var _html = "";
		$.each(this.windows,function(i,d){
			_html += "<a href='#' '+attributes+' onClick=gisui.createWindow({id:'"+d.attribution.id+"'})  class='easyui-linkbutton l-btn l-btn-plain' data-options='plain:true' id=''><span class='l-btn-left'><span class='l-btn-text'>"+d.attribution.title+"</span></span></a>";
			//_html += "<input type='button' value='"+d.attribution.title+"' onClick=gisui.createWindow({id:'"+d.attribution.id+"'}) />";
		});

		$.each(this.minWindows,function(i,d){
			_html += "<input type='button' value='"+d.attribution.title+"' onClick=gisui.createWindow({id:'"+d.attribution.id+"'}) />";
		});

		$("#mytoolbar").html(_html);

	};

	this.showDebugBox = function() {
	};

	this.debug = function() {

		if(!this.config.debug) {
			return;
		}
	
		var _html = "当前正在显示的窗口<span style='color:red'>"+this.windows.length+"</span>个:<br>";
		    
		$.each(this.windows,function(i,d) {
			_html += "窗口的id:'"+d.attribution.id+"',标题是'"+d.attribution.title;
			if(d.attribution.tabs != undefined) {
				$.each(d.attribution.tabs.tabs,function(i,e){
					_html += ",页面的地址是'"+e.src;
				});
			}else{
				_html += ",页面的地址是" + d.attribution.src ;
			}
			_html += "<br>";
		});

		/*_html += "当前已经关闭的窗口<span style='color:red'>"+this.closedWindows.length+"</span>个:<br>";
		    
		$.each(this.closedWindows,function(i,d) {
			_html += i+":" + "id="+d.attribution.id+"<br>";
		});

		_html += "当前正在隐藏的窗口有<span style='color:red'>"+this.minWindows.length+"</span>个:<br>";
		    
		$.each(this.minWindows,function(i,d) {
			_html += i+":" + "id="+d.attribution.id+"<br>";
		});*/
		_html += "<br><br>";
		$("#iframe_console").contents().find("#debugbox").append(_html);
	};
	
	if(this.config.debug) {
		this.showDebugBox();
	}

	if(this.config.isShowToolBar) {
		this.showToolbar();
	}
}


function Window(jsonObj) {			// 窗口类

	/**
	 *	属性
	 */
	this.childrenWindow = [];		// 所有子窗口集合
	this.parentWindow = [];			// 所有父窗口集合
	this.attribution = {};

	
	/**
	 *	配置默认属性
	 */
	if( jsonObj.collapsible == undefined ) {
		jsonObj.collapsible = false;
	}
	if( jsonObj.maximizable == undefined ) {
		jsonObj.maximizable = false;
	}
	if( jsonObj.minimizable == undefined ) {
		jsonObj.minimizable = false;
	}
	if(jsonObj.width == undefined ) jsonObj.width = 465; 	// 默认宽度
	if(jsonObj.height == undefined ) jsonObj.height = 370; 	// 默认宽度
	if(jsonObj.left == undefined ) jsonObj.left = 260; 	// 默认宽度
	if(jsonObj.top == undefined ) jsonObj.top = 30; 	// 默认宽度
 //   jsonObj.left = 250; 	// 默认宽度
//	jsonObj.top = 30; 	// 默认宽度
	
	if(jsonObj.id == undefined ) jsonObj.id = UUID.prototype.createUUID(); // 默认ID
	
	if( jsonObj.tools != undefined ) {
		$("#tools_"+jsonObj.id).remove();
		$(jsonObj.tools).clone(true,true).attr("id","tools_" + jsonObj.id).appendTo("body");
		jsonObj.tools = "#tools_" + jsonObj.id;
	}

	/**
	 *      配置默认行为
	 */
	
	if( jsonObj.onClose != undefined ) {
		jsonObj._onClose = jsonObj.onClose;
		delete jsonObj.onClose;
	}

	if(jsonObj.onMinimize != undefined ) {
		jsonObj._onMinimize = jsonObj.onMinimize;
		delete jsonObj.onMinimize;
	}

	if(jsonObj.onDestroy != undefined ) {
		jsonObj._onDestroy = jsonObj.onDestroy;
		delete jsonObj.onDestroy;
	}
	
	jsonObj.onResizeColumn = function(){
		alert("resizeColumn");
	};

	this.attribution = jsonObj;



	this.attribution.onClose = function() {			// 关闭窗口的是时候
		var winid = $(this).attr("id");
		
		gisui.findWindowById(winid,function(i,d){
			// arr gisui.windows 
			//gisui.closedWindows.push(gisui.windows.splice(i,1)[0]);
			gisui.windows.splice(i,1)[0].destroy();
		});
		
		if(jsonObj._onClose != undefined ) {
			jsonObj._onClose();
		}

		gisui.debug();
	};

	this.attribution.onDestroy = function(){
		var winid = $(this).attr("id");
		gisui.findWindowById(winid,function(i,d,arr){
			arr.splice(i,1);
		});
		
		gisui.drawToolbarButtons();

		if(jsonObj._onDestroy != undefined ) {
			jsonObj._onDestroy();
		}

		gisui.debug();
	};

	this.attribution.onMinimize = function() {		// 最小化窗口的时候触发
		var winid = $(this).attr("id");
	/*	gisui.findWindowById(winid,function(i,d){
			console.log("i="+i);
			gisui.minWindows.push(gisui.windows.splice(i,1)[0]);
		});*/
		
		var options = $("#"+winid).window("options");

		var proy = '<div id="myproy" class="panel window" style="display: block; left: '+options.left+'px; top: '+options.top+'px; width: '+options.width+'px; height:'+options.height+'px z-index: 9003; position: absolute;">'+
	 '<div class="panel-header panel-header-noborder window-header" style="width: 453px;">'+
		 '<div class="panel-title">'+options.title+'</div>'+
		 '<div class="panel-tool"><a class="panel-tool-min" href="javascript:void(0)"></a><a class="panel-tool-close" href="javascript:void(0)"></a></div>'+
	 '</div>'+
	 '<div  title="" class="panel-body panel-body-noborder window-body" style="width: 451px; height: 264px;"></div>'+
'</div>';

		$("body").append(proy);

		$("#myproy").animate({
			left:'0px',
			top:'0px',
			width:'0px',
			height:'0px'
		},function(){
			$("#myproy").remove();
		});

		gisui.drawToolbarButtons();

		if(jsonObj._onMinimize != undefined ) {
			jsonObj._onMinimize();
		}

		gisui.debug();
	};


	/**
	 *
	 *	方法
	 */
	
	this.create = function() {	// 创建窗口

		var _html = "";
		var tabs;
		var divE = document.createElement("div");
		divE.setAttribute("id", jsonObj.id);
		if( jsonObj.content != undefined ) { 	//使用 content 指定内容创建窗口
			
			//_html = "<div id="+jsonObj.id+">"+jsonObj.content+"</div>";
			divE.innerHTML = jsonObj.content;
		}else if( jsonObj.src != undefined ) { 	// 使用iframe 创建 指定的窗口
		//	_html = "<div id="+jsonObj.id+" style='overflow:hidden;'><iframe id='"+jsonObj.id+"_iframe' style='border:none;padding:0px;margin:0px;height:100%;width:100%;' src="+jsonObj.src+"></div>"
			divE.setAttribute("style","overflow-y:hidden");
			var iframeE = document.createElement("iframe");
			iframeE.setAttribute("id", jsonObj.id+"_iframe");
		//	iframeE.src = jsonObj.src;
			iframeE.setAttribute("style","border:none;padding:0px;margin:0px;height:100%;width:100%;");
			$(divE).append(iframeE);
		}else if( jsonObj.href != undefined ){  //  使用ajax 方式 创建窗口
		
		}else if(jsonObj.tabs != undefined ){	//  创建 带有tabs 页签的窗口
			tabs = new Tabs(jsonObj);
		//	_html = "<div id="+jsonObj.id+" >"+jsonObj.id+"</div>";
			divE.innerHTML = jsonObj.id;
		}else{
			console.error("无法创建窗口(id:"+jsonObj.id+")" );
		} 

		$("body").append(divE);
		if( jsonObj.src ) {
			iframeE.src = jsonObj.src;
		}
		$("#"+jsonObj.id).window(this.attribution);
		if( jsonObj.tabs != undefined ) {
			tabs.createTabs("#"+jsonObj.id);
		}
	}

	this.open = function() {	// 打开窗口
		$("#"+this.attribution.id).dialog("open");
	}

	this.close = function() {	// 关闭窗口
		$("#"+this.attribution.id).dialog("close");
	}

	this.min = function() {		// 最小化窗口
		$("#"+this.attribution.id).dialog("minimize");
	}

	this.destroy = function() {	// 销毁窗口
		$("#"+this.attribution.id).dialog("destroy");
	}

	this.getAttribution = function() {		// 返回窗口的属性
		return this.attribution;
	}
}

/**
 *	tabs 对象
 */
function Tabs(jsonObj){
	
	if(!jsonObj.tabs){alert("无法创建tabs对象 原因：tabs 属性为null");return;}

	if(jsonObj.tabs.id == undefined) {jsonObj.tabs.id = UUID.prototype.createUUID();}
//	if(jsonObj.tabs.fit == undefined ) { jsonObj.tabs.fit = false;}
	if(jsonObj.tabs.plain == undefined ) { jsonObj.tabs.plain = true;}
	this.attribution = jsonObj.tabs;
	
	
	this.attribution.onSelect = function(title){
		//console.log(this);
		//console.log(title);
		
		var iframe = $(this).children(".tabs-panels").find("iframe:visible");
		
		if( iframe.attr("src") == "" ) {
			iframe.attr("src",iframe.attr("mysrc"));
		}
		/*for(var i = 0; i < this.attribution.tabs.length ; i ++ ) {
			if(this.attribution.tabs[i].title == title ) {
				$("#iframe_"+this.attribution.tabs[i].id).attr("src",this.attribution.tabs[i].src);
			}
		}*/
	};
	
	this.createTabs = function(container) {
			var len = this.attribution.tabs.length;
			var _html = "<div id='"+this.attribution.id+"' data-options='fit:true'>";
			var tabsall = getCookie(jsonObj.id+"_tabsall");
			var tabssel = getCookie(jsonObj.id+"_tabssel");
			if( len > 4 ) {
				// 添加按钮
				$(".temp_tools").remove();
				$("body").append("<div id='addtabs_tools' class='temp_tools'><a href='javascript:void(0)' winid='"+jsonObj.id+"' class='icon-add' onclick='javascript:c_addtabs(this)'></a></div>");
				$("#"+jsonObj.id).window({
					tools:"#addtabs_tools"
				});
				
				if( tabsall == "" ) {
					$.each(jsonObj.tabs.tabs,function(i,d){
						tabsall += d.title + "|";
						if( i < 5 ) {
							tabssel += d.title + "|";
						}
					});
					setCookie(jsonObj.id+"_tabsall",tabsall);
					setCookie(jsonObj.id+"_tabssel",tabssel);
				}
			}
		
			for(var i = 0; i < len ; i++){
				
					if( len > 4 && tabssel.indexOf(this.attribution.tabs[i].title) == -1 ) {
						continue;
					}
	
					// 拼接data-options 字符串
					var dataOP = "data-options=\"";
					
					if(this.attribution.tabs[i].href != undefined){
						dataOP += "href:'"+this.attribution.tabs[i].href+"',";
					}

					if(this.attribution.tabs[i].onLoad != undefined ) {
						dataOP += "onLoad:"+this.attribution.tabs[i].onLoad+",";
					}
					
					if(this.attribution.tabs[i].tools != undefined ) {
						
						$("#tools_"+jsonObj.id + "_" + i).remove();
						$(this.attribution.tabs[i].tools).clone(true,true).attr("id","tools_" + jsonObj.id + "_" + i).appendTo("body");
						this.attribution.tabs[i].tools = "#tools_" + jsonObj.id +  "_" + i;
						
						dataOP += "tools:'"+this.attribution.tabs[i].tools+"',";
					}
					
					/*if( this.attribution.tabs.length > 4 ) {
						dataOP +="fit:true,closable:true\"";
					}else{
						dataOP +="fit:true\"";
					}*/
					
					dataOP +="fit:true\"";
					
					if(this.attribution.tabs[i].id == undefined) this.attribution.tabs[i].id = UUID.prototype.createUUID(); 			
					if(this.attribution.tabs[i].content == undefined) {
						this.attribution.tabs[i].content = "使用href 通过ajax 获取内容， src 使用iframe ， content 字符串制定内容";
					}

					if(this.attribution.tabs[i].src != undefined ) {
						this.attribution.tabs[i].content =  "<iframe id='iframe_"+this.attribution.tabs[i].id+"' style='border:none;padding:0px;margin:0px;height:100%;width:100%;' mysrc='"+this.attribution.tabs[i].src+"' src='' />";
					}
					_html += "<div style='overflow:hidden' id='"+this.attribution.tabs[i].id+"' title='"+this.attribution.tabs[i].title+"' "+dataOP+">"+this.attribution.tabs[i].content+"</div>";
			}
			_html += "</div>";
			//return _html;
			$(container).html(_html);
			$("#"+this.attribution.id).tabs(this.attribution);
			if(this.attribution.selected != undefined ) {
				$("#"+this.attribution.id).tabs("select",this.attribution.selected);
			}
		}

}

