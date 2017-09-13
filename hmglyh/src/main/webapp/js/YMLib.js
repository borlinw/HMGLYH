/*
 * Project :		首发安畅路产核心脚本库
 * Description : 	基于jQuery 1.10.2 & jQuery.EasyUI 1.3.4
 * 				  	前端开发框架联合开发核心库
 * Version :		1.1
 * Create :			2013.11.15
 * Modified :		2014.02.24
 * Author : 		Kvkens
 * QQ :				574035
 * HTTP : 			www.imyy.org
 * EMAIL :			admin@imyy.org
 * Update:			2013.12.14 增加下拉树、树的图标去除方法。
 * 					2014.02.24 增加消息队列执行函数。YMLib.Tools.queueFunction()
 */
if(!(typeof window.jQuery !== "undefined")){
	//alert("YMLib 没有找到依赖脚本库jQuery1.10.2\n请开发人员检查jQuery环境！");
}
var YMLib = {
		/*
		 * 核心库版本号
		 */
		version : "v1.1",
		/*
		 * 获得当前项目路径（绝对路径）
		 */
		url : document.location.protocol+"//"+document.location.host + "/hmglyh/",

		/*
		 * 获取报表的地址
		 */
		reportUrl : document.location.protocol+"//localhost:8075/WebReport/ReportServer?",
		
		/*
		 * 枚举类型
		 */
		/**LR添加“网络错误！”**/
		Enum : {
			Login : new Array("验证码错误！","用户名或密码错误！","网络错误！")
		},
		/*
		 * 首页自动刷新时间间隔ms
		 */
		PageInterval : 60000,
		/*
		 * 报表用编码
		 */
		cjkEncode : function(text) {                                                                           
			if (text == null) {          
				return "";          
			}          
			var newText = "";          
			for (var i = 0; i < text.length; i++) {          
				var code = text.charCodeAt (i);           
				if (code >= 128 || code == 91 || code == 93) {  //91 is "[", 93 is "]".          
					newText += "[" + code.toString(16) + "]";          
				} else {          
					newText += text.charAt(i);          
				}          
			}          
			return newText;          
		},
		//获取uuid
		guid : function() {
		  return 'xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx'.replace(/[xy]/g, function(c) {
		    var r = Math.random()*16|0, v = c == 'x' ? r : (r&0x3|0x8);
		    return v.toString(16);
		  });
		},
		
		/*
		 * AJAX操作相关
		 */
		Ajax : {
			/*
			 * YMLib的POST请求
			 */
			POST : function(_url,_param,_type,_callback,_error){
				$.ajax({
					type : "POST",
					url : YMLib.url + _url,
					dataType : _type,
					data : _param,
					success : _callback,
					error : _error
				});
			},
			/*
			 * YMLib的GET请求
			 */
			GET : function(_url,_param,_type,_callback,_error){
				$.ajax({
					type : "GET",
					url : YMLib.url + _url,
					dataType : _type,
					data : _param,
					success : _callback,
					error : _error
				});
			},
			/*
			 * YMLib的POST请求
			 */
			POSTSF : function(_url,_param,_type,_callback,_error){
				$.ajax({
					type : "POST",
					url : YMLib.sfUrl + _url,
					dataType : _type,
					data : _param,
					success : _callback,
					error : _error
				});
			},
			/*
			 * YMLib的GET请求
			 */
			GETSF : function(_url,_param,_type,_callback,_error){
				$.ajax({
					type : "GET",
					url : YMLib.sfUrl + _url,
					dataType : _type,
					data : _param,
					success : _callback,
					error : _error
				});
			}
		},
		/*
		 * 命名空间函数
		 */
		Namespace : function(_ns){
			var parts = _ns.split("."),
			object = this;
			i,len;
			for (var i = 0,len = parts.length; i < len; i++) {
				if(!object[parts[i]]){
					object[parts[i]] = {};
				}
				object = object[parts[i]];
			}
			return object;
		},
		/*
		 * 相关工具类函数
		 */
		Tools : {
			/*
			 * 函数执行消息队列系统
			 * 参数1：要执行的队列数组
			 * 参数2：执行先后的时间
			 * 例子：如下
			 */
			/*
			 * 
			 * var testArr = new Array();
			var testFuncOne = function(){
				console.info("5+6=" + (5+6));
			};
			var testFuncTwo = function(){
				console.info("56x34="+ (56*34));
			};
			var testFuncThree = function(){
				console.info("1024*1024="+(1024*1024));
			};
			
			testArr.push(testFuncOne);
			testArr.push(testFuncTwo);
			testArr.push(testFuncThree);
			
			*/
			queueFunction : function(arr,interval){
				if(typeof arr !== "object"){
					alert("队列参数不正确！");
					return ;
				}
				var num = arr.length;
				var funcnum = 0;
				var thisinterval;
				thisinterval = setInterval(function(){
					if(num !== 0){
						arr[funcnum]();
						funcnum++;
					}else{
						clearInterval(thisinterval);
					}
					num--;
				}, interval);
			},
			/*
	    	 * 客户端模板插槽替换。
	    	 */
	    	sprintf : function(text){
	    		var i = 1 , args = arguments;
	    		return text.replace(/%s/g,function(){
	    			return (i < args.length) ? args[i++] : "";
	    		});
	    	},
			/*
			 * 清除下拉树的节点图标
			 */
			clearComboTreeIcon : function(){
				$("ul[class='tree tree-lines'] span[class='tree-icon tree-folder tree-folder-open']").removeAttr("class");
		    	$("ul[class='tree tree-lines'] span[class='tree-icon tree-file']").removeAttr("class");
			},
			/*
			 * 清除树的节点图标
			 */
			clearTreeIcon : function(_id) {
				$("#" + _id +" span[class$='tree-file']").removeAttr("class").attr("class", "tree-icon");
				$("#" + _id +" span[class='tree-icon tree-folder tree-folder-open']").removeAttr("class");
				$("#" + _id +" span[class='tree-icon tree-folder']").removeAttr("class");
			},
			/*
	    	 * 获取网址
	    	 */
	    	getParameter : function(name) {
	    	    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	    	    var r = window.location.search.substr(1).match(reg);
	    	    if (r != null) return unescape(r[2]); return null;
	    	},
			/*
			 * 页面可见
			 */
		    ShowPage : function(){
		    	$("body").css("visibility","visible");
		    },
	        /*
	         * 创建指定div
	         */
	        createDivById : function(myDiv) {
	            var _t = document.createElement("div");
	            _t.setAttribute("id", myDiv);
	            document.body.appendChild(_t);
	            return myDiv;
	        },
	        /*
	         * 创建随机名字的div
	         */
	        createDiv : function(){
	        	var _id = YMLib.UI.createRandomDiv();
	        	var _t = document.createElement("div");
	            _t.setAttribute("id",_id);
	            document.body.appendChild(_t);
	            return _id;
	        },
	        /*
	         * 创建随机div的名字
	         */
	        createRandomDiv: function () {
	            return "_K" + new Date().getHours() + new Date().getMinutes() + new Date().getSeconds() + new Date().getMilliseconds();
	        }
		},
		/*
		 * 日期类操作函数
		 */
		DateTime : {
			/*
			 * 获取本机时间 （yyyy-MM-dd HH:mm:ss）
			 */
			getDateTime : function(){
        	    var _yyyy = new Date().getFullYear();
        	    var _MM = new Date().getMonth()+1;
        	    var _dd = new Date().getDate();
        	    var _hh = new Date().getHours();
        	    var _ff = new Date().getMinutes();
        	    var _mm = new Date().getSeconds();
        	    _MM = _MM < 10 ? '0' + _MM : _MM;
        	    _dd = _dd < 10 ? '0' + _dd : _dd;
        	    _hh = _hh < 10 ? '0' + _hh : _hh;
        	    _ff = _ff < 10 ? '0' + _ff : _ff;
        	    _mm = _mm < 10 ? '0' + _mm : _mm;
        	    return _yyyy + '-' + _MM + '-' + _dd + ' ' + _hh + ':' + _ff + ':' + _mm;
			},
			/*
			 * 获得本机指定格式的时间（yyyy-MM-dd HH:mm:ss）
			 */
			getDateFormat : function(format){
				 var dt = new Date();
				 //年份
				 this.Year=dt.getFullYear();
				 //月份
				 this.Month=dt.getMonth()+1<10?'0'+(dt.getMonth()+1):dt.getMonth()+1;
				 //日期
				 this.Day=dt.getDate()<10?'0'+dt.getDate():dt.getDate();
				 //星期几,数字
				 this.Week=dt.getDay();
				 //星期几，中文
				 this.WeekDay='日一二三四五六'.charAt(dt.getDay()); 
				 //24制小时
				 this.Hours24=dt.getHours()<10?'0'+dt.getHours():dt.getHours();
				 //12制小时
				 this.Hours12=this.Hours24>12 ? this.Hours24-12 : this.Hours24; 
				 //分钟
				 this.Minutes=dt.getMinutes()<10?'0'+dt.getMinutes():dt.getMinutes();
				 //秒
				 this.Seconds=dt.getSeconds();
				 format=format.replace("yy",this.Year);
				 format=format.replace("MM",this.Month);
				 format=format.replace("dd",this.Day);
				 format=format.replace("HH",this.Hours24);
				 format=format.replace("hh",this.Hours12);
				 format=format.replace("mm",this.Minutes);
				 format=format.replace("ss",this.Seconds);
				 format=format.replace("ww",this.Week);
				 format=format.replace("WW",this.WeekDay); 
				 return format;
			},
			getDateFormats : function(format){
				 var dt = new Date();
				 //年份
				 this.Year=dt.getFullYear();
				 //月份
				 this.Month=dt.getMonth()+1<10?'0'+(dt.getMonth()+1):dt.getMonth()+1;
				 //日期
				 this.Day=dt.getDate()<10?'0'+dt.getDate():dt.getDate();
				 //星期几,数字
				 this.Week=dt.getDay();
				 //星期几，中文
				 this.WeekDay='日一二三四五六'.charAt(dt.getDay()); 
				 //24制小时
				 this.Hours24=dt.getHours()<10?'0'+dt.getHours():dt.getHours();
				 //12制小时
				 this.Hours12=this.Hours24>12 ? this.Hours24-12 : this.Hours24; 
				 //分钟
				 this.Minutes=dt.getMinutes()<10?'0'+dt.getMinutes():dt.getMinutes();
				 //秒
				 this.Seconds=dt.getSeconds();
				 format=format.replace("yy",this.Year);
				 format=format.replace("MM",this.Month);
				 format=format.replace("dd",this.Day);
				 format=format.replace("HH",this.Hours24);
				 format=format.replace("hh",this.Hours12);
				 format=format.replace("mm",this.Minutes);
				 format=format.replace("ss",this.Seconds);
				 format=format.replace("ww",this.Week);
				 format=format.replace("WW",this.WeekDay); 
				 return format;
			}
		},
		/*
		 * EasyUI相关操作函数
		 */
		UI : {
	        /*
	         * 新版iOS消息推送
	         */
	        pushMessage : function(_id,_count){
	        	//alert("位置：x:" + $("#" + _id).position().left + " y:"+$("#" + _id).position().top);
	        	if (_count >= 10) {
	        		_count = 10;
				}
	        	if(_count===0){
	        		$("div[rid="+_id+"]").remove();
	        		return;
	        	}
	        	$("div[rid="+_id+"]").remove();
	        	var _left = $("#" + _id).position().left + 120;
	        	var _top = $("#" + _id).position().top - 30;
	        	var _html = "<div class=\"count count"+_count+"\" rid=\""+_id+"\" style=\"position:absolute;top:"+_top+"px;left:"+_left+"px\"></div>";
	        	$(document.body).append(_html);
	        },
	        /*
	         * 添加Tab面板。
	         */
	        addTab: function (_id,_title,_src,_icon,_close) {
				if($("#" +_id).tabs('exists',_title)){
					$("#" + _id).tabs('select',_title);
				}else{
					$("#" + _id).tabs('add',{
						title : _title,
						content : "<iframe id='tabFrame' name='tabFrame' src='"+_src+"' frameborder='0' height='100%' width='100%'></iframe>",
						loadingMessage : '正在加载中……',
						iconCls : _icon,
						closable : _close
					});
				}
	        
	        },
			/*
			 *	启用遮罩层
			 */
			MaskShow : function(_txt){
				var _maskWidth = $(document).width();
				var _maskHeight = $(document).height();
				var _mask = "<div id=\"yyui-mask\" style=\"z-index:99999;position:absolute;top:0px;left:0px;width:"+_maskWidth+"px;height:"+_maskHeight+"px;background:gray;filter:Alpha(Opacity=30);-moz-opacity:0.4;opacity:0.4;\"></div>";
				var _msg = arguments.length !== 0 ?arguments[0] :"正在操作中...";
		    	var _uiWidth = _msg.length * 15 + parseInt((_msg.indexOf(".") !== -1)?0:70);
				var _left = ($(document).width() / 2.0 - parseFloat(_uiWidth / 2.0));
		    	var _top = ($(document).height() / 2.0 - 22.5);
		    	//var _src = YMLib.url + "images/loading.gif";
		    	var _src = YMLib.url + "images/box_002.png";
		    	//var _ui = "<div id=\"yyui-maskmsg\" unselectable=\"on\" onselectstart=\"return false\" style=\"z-index:999999;-webkit-user-select:none;-moz-user-select:none;position:absolute;top:"+_top+"px;left:"+_left+"px;border:5px solid #ABA5F8;background-color:#DEDCFA;width:"+_uiWidth+"px;height:45px;font-size:14px;font-family:'\\5FAE\\8F6F\\96C5\\9ED1';text-align:center;cursor:wait\"><p style=\"z-index : 9999;font-size:14px;font-family:'\\5FAE\\8F6F\\96C5\\9ED1';vertical-align:middle;margin-top:13px\"><img src=\""+_src+"\" style=\"vertical-align:middle;margin-right:6px;width:16px;height:16px\" />"+_msg+"</p></div>";
		    	var _ui = "<div id=\"yyui-maskmsg\" unselectable=\"on\" onselectstart=\"return false\" style=\"z-index:999999;-webkit-user-select:none;-moz-user-select:none;position:absolute;top:"+_top+"px;left:"+_left+"px;border:0px; background-color:#FFFFFF;width:"+_uiWidth+"px;height:45px;font-size:12px;color:#0890A6;font-family:'\u5b8b\u4f53';text-align:center;cursor:wait\"><p style=\"z-index : 9999;font-size:12px;color:#0890A6;font-family:'\u5b8b\u4f53';vertical-align:middle;margin-top:13px\"><img src=\""+_src+"\" style=\"vertical-align:middle;margin-right:6px;width:16px;height:16px\" />"+_msg+"</p></div>";
		    	$(document.body).append(_mask);
		    	$(document.body).append(_ui);
		    	return "嘿嘿^_^打开了界面";
			},
			/*
			 *	隐藏遮罩层
			 */
			MaskHide : function(){
				$("#yyui-mask,#yyui-maskmsg").remove();
		    	return "嘿嘿^_^关闭了界面";
			},
			 /*
	         * 提示模态信息。
	         */
	        Show: function (_txt, _time) {
	            var _id = YMLib.Tools.createRandomDiv();
				var _msg = _txt;
		    	var _uiWidth = _msg.length * 15 + parseInt((_msg.indexOf(".") !== -1)?0:70);
				var _left = ($(document).width() / 2.0 - parseFloat(_uiWidth / 2.0));
		    	var _top = ($(document).height() / 2.0 - 22.5);
		    	//var _src = YMLib.url + "images/information.png";
		    	var _src = YMLib.url + "images/box_002.png";
		    	//var _ui = "<div id=\""+_id+"\" unselectable=\"on\" onselectstart=\"return false\" style=\"z-index:999999;-webkit-user-select:none;-moz-user-select:none;position:absolute;top:"+_top+"px;left:"+_left+"px;border:5px solid #ABA5F8;background-color:#DEDCFA;width:"+_uiWidth+"px;height:45px;font-size:14px;font-family:'\\5FAE\\8F6F\\96C5\\9ED1';text-align:center;cursor:default;\"><p style=\"z-index : 9999;font-size:14px;font-family:'\\5FAE\\8F6F\\96C5\\9ED1';vertical-align:middle;margin-top:13px\"><img src=\""+_src+"\" style=\"vertical-align:middle;margin-right:3px;width:16px;height:16px\" />"+_msg+"</p></div>";
		    	var _ui = "<div id=\""+_id+"\" unselectable=\"on\" onselectstart=\"return false\" style=\"z-index:999999;-webkit-user-select:none;-moz-user-select:none;position:absolute;top:"+_top+"px;left:"+_left+"px;border:0px;background-color:#FFFFFF;width:"+_uiWidth+"px;height:45px;font-size:12px;color:#0890A6;font-family:'\u5b8b\u4f53';text-align:center;cursor:default;\"><p style=\"z-index : 9999;font-size:12px;color:#0890A6;font-family:'\u5b8b\u4f53';vertical-align:middle;margin-top:13px\"><img src=\""+_src+"\" style=\"vertical-align:middle;margin-right:3px;width:16px;height:16px\" />"+_msg+"</p></div>";
		    	$(document.body).append(_ui);
	            //闭包操作关闭提示
	            function closeShow() {
	                $("#" + _id).fadeOut('slow', function () {
	                    $("#" + _id).html(null);
	                    $("#" + _id).remove();
	                });
	            }
	            $("#" + _id).fadeIn('slow', 'linear', function () {
	                setInterval(closeShow, _time);
	            });
	            return "嘿嘿没问题^_^";
	        },
	        /*
	         * 提示模态信息。
	         */
	        LoginShow: function (_txt, _time) {
	            var _id = YMLib.Tools.createRandomDiv();
				var _msg = _txt;
		    	var _uiWidth = _msg.length * 15 + parseInt((_msg.indexOf(".") !== -1)?0:70);
				var _left = ($(document).width() / 2.0 - parseFloat(_uiWidth / 2.0));
		    	var _top = ($(document).height() / 2.0 - 22.5);
		    	var _src = YMLib.url + "images/information.png";
		    	var _ui = "<div id=\""+_id+"\" unselectable=\"on\" onselectstart=\"return false\" style=\"z-index:999999;-webkit-user-select:none;-moz-user-select:none;position:absolute;top:"+_top+"px;left:"+_left+"px;border:5px solid #ABA5F8;background-color:#DEDCFA;width:"+_uiWidth+"px;height:45px;font-size:14px;font-family:'\\5FAE\\8F6F\\96C5\\9ED1';text-align:center;cursor:default\"><p style=\"z-index : 9999;font-size:14px;font-family:'\\5FAE\\8F6F\\96C5\\9ED1';vertical-align:middle;margin-top:13px\"><img src=\""+_src+"\" style=\"vertical-align:middle;margin-right:3px;width:16px;height:16px\" />"+_msg+"</p></div>";
		    	$(document.body).append(_ui);
	            //闭包操作关闭提示
	            function closeShow() {
	                $("#" + _id).fadeOut('slow', function () {
	                    $("#" + _id).html(null);
	                    $("#" + _id).remove();
	                });
	            }
	            $("#" + _id).fadeIn('slow', 'linear', function () {
	                setInterval(closeShow, _time);
	            });
	            return "嘿嘿没问题^_^";
	        },
			/*
	       * 加载Window窗体来自框架
	       */
	        createWindow : function(_id, _title, _href, _icon, _width, _height,_onClose){
	        	    if ($("#" + _id).size() != 0) {//是否存在
	        	    	alert("id重复，窗口创建失败。");
	        	        return;
	        	    }
	        	    YMLib.Tools.createDivById(_id); //创建div
	        	    $("#" + _id).window({//渲染window
	        	        title: _title,
	        	        iconCls: _icon,
	        	        content: "<iframe id='" + _id + "_frame' name='" + _id + "_frame' src='" + _href + "' frameborder='0' height='100%' width='100%'></iframe>",
	        	        width: _width,
	        	        height: _height,
	        	        //collapsible: typeof _collapsible == 'undefined',
	        	        collapsible : false,
	        	        minimizable: false,
	        	        maximizable: false,
	        	        resizable: true,
	        	        modal: true,
	        	        border: false,
	        	        onClose: function() {
	        	            var frame = $('iframe', $("#" + _id)); //释放frame
	        	            if (frame.length > 0) {
	        	                frame[0].contentWindow.document.write('');
	        	                frame[0].contentWindow.close();
	        	                frame.remove();
	        	            }
	        	            if(typeof _onClose !='undefined'){
	        	            	_onClose();
	        	            }
	        	            $("#" + _id).window('destroy');
	        	            $("#" + _id).remove();
	        	        }
	        	    });
	        	
	        },
	        /*
	         * 临时创建菜单。
	         */
	        createMenu : function(_xtype, _json) {
	            switch (_xtype) {
	                case 'LeftMenu':
	                    var id = typeof _json.id != 'undefined' ? _json.id : null;
	                    var title = typeof _json.title != 'undefined' ? _json.title : null;
	                    var imgSrc = typeof _json.imgSrc != 'undefined' ? _json.imgSrc : null;
	                    var renderTo = typeof _json.renderTo != 'undefined' ? _json.renderTo : null;
	                    var href = typeof _json.href != 'undefined' ? _json.href : null;
	                    var fun = typeof _json.click != 'undefined' ? _json.click : null;
	                    var html = "<div><a id='" + id + "' href='" + href + "' target='index-frame'><img src='" + imgSrc + "' alt='" + title + "' title='" + title + "'/><br/><span>" + title + "</span></a></div>";
	                    $("#" + renderTo).append(html);
	                    //$("#" + id).click(function(){
	                    	//YMLib.UI.clearTips(_json.id);
	                    	//fun();
	                    //});
	                    id = null;
	                    title = null;
	                    imgSrc = null;
	                    renderTo = null;
	                    html = null;
	                    fun = null;
	                    delete id;
	                    delete title;
	                    delete imgSrc;
	                    delete renderTo;
	                    delete html;
	                    delete fun;
	                    break;
	                default:
	                    alert("错误的类型");
	            }
	        },
	        /*
	         * Click
	         */
	        createMenuOnClick : function(_xtype, _json) {
	            switch (_xtype) {
	                case 'LeftMenu':
	                    var id = typeof _json.id != 'undefined' ? _json.id : null;
	                    var title = typeof _json.title != 'undefined' ? _json.title : null;
	                    var imgSrc = typeof _json.imgSrc != 'undefined' ? _json.imgSrc : null;
	                    var renderTo = typeof _json.renderTo != 'undefined' ? _json.renderTo : null;
	                    var fun = typeof _json.click != 'undefined' ? _json.click : null;
	                    var html = "<div><a id='" + id + "' href='" + "javascript:void(0)" + "' ><img src='" + imgSrc + "' alt='" + title + "'/><br/><span>" + title + "</span></a></div>";
	                    $("#" + renderTo).append(html);
	                    $("#" + id).click(function(){
	                    	//YMLib.UI.clearTips(_json.id);
	                    	_json.click();
	                    });
	                    id = null;
	                    title = null;
	                    imgSrc = null;
	                    renderTo = null;
	                    html = null;
	                    fun = null;
	                    delete id;
	                    delete title;
	                    delete imgSrc;
	                    delete renderTo;
	                    delete html;
	                    delete fun;
	                    break;
	                default:
	                    alert("错误的类型");
	            }
	        },
	        /*
	         * MouseMove
	         */
	        createMenuOnMove : function(_xtype, _json) {
	            switch (_xtype) {
	                case 'LeftMenu':
	                    var id = typeof _json.id != 'undefined' ? _json.id : null;
	                    var title = typeof _json.title != 'undefined' ? _json.title : null;
	                    var imgSrc = typeof _json.imgSrc != 'undefined' ? _json.imgSrc : null;
	                    var renderTo = typeof _json.renderTo != 'undefined' ? _json.renderTo : null;
	                    var mouseover = typeof _json.mouseover != 'undefined' ? _json.mouseover : null;
	                    var mouseout = typeof _json.mouseout != 'undefined' ? _json.mouseout : null;
	                    var html = "<div><a id='" + id + "' href='" + "javascript:void(0)" + "' ><img src='" + imgSrc + "' alt='" + title + "' title='" + title + "'/><br/><span>" + title + "</span></a></div>";
	                    $("#" + renderTo).append(html);
	                    $("#" + id).mouseover(function(){
	                    	_json.mouseover();
	                    });
	                    $("#" + id).mouseout(function(){
	                    	_json.mouseout();
	                    });
	                    
	                    id = null;
	                    title = null;
	                    imgSrc = null;
	                    renderTo = null;
	                    html = null;
	                    fun = null;
	                    delete id;
	                    delete title;
	                    delete imgSrc;
	                    delete renderTo;
	                    delete html;
	                    delete fun;
	                    break;
	                default:
	                    alert("错误的类型");
	            }
	        }
		},
		/**
		 * datagrid相关
		 */
		Columns : {
			/**
			 * 通过columns获取导出时的表头
			 */
			getTitle : function(_columns){
				var html = "";
				for(var i=0;i<_columns.length;i++){
					html += "<tr>";
					for(var j=0;j<_columns[i].length;j++){
						html += "<td";
						var data = _columns[i][j];
						if(data.colspan != null && data.colspan != undefined)
							html += " colspan=" + data.colspan;
						if(data.rowspan != null && data.rowspan != undefined)
							html += " rowspan=" + data.rowspan;
						html += ">" + data.title + "</td>";
					}
					html += "</tr>";
				}
				return html;
			},
			/**
			 * 只针对field在一行中并且不包含formatter时使用
			 */
			getDataWithoutFormatter : function(_columns){
				var result = "";
				for(var i=0;i<_columns.length;i++){
					for(var j=0;j<_columns[i].length;j++){
						var data = _columns[i][j];
						if(data.formatter != null && data.formatter != undefined){
							result += data.kid + "#";
						}else if(data.field != null && data.field != undefined){
							if(data.field == ""){
								result += "null#";
							}else{
								result += data.field + "#";
							}
						}
					}
				}
				return result;
			}
		}
};
//解决帆软中文传值乱码问题
function cjkEncode(text) {     

	if (text == null) {     

	return "";     

	}     

	var newText = "";     

	for (var i = 0; i < text.length; i++) {     

	var code = text.charCodeAt (i);      

	if (code >= 128 || code == 91 || code == 93) {//91 is "[", 93 is "]".     

	newText += "[" + code.toString(16) + "]";     

	} else {     

	newText += text.charAt(i);     

	}     

	}     

	return newText;     

}





