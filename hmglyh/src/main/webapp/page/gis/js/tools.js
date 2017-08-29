
/*$(function(){
	$("input[type=text]").focus(function(){
		this.select();
	});
});*/

// 获取 url 参数
function getParam(id) {
	var a = $("#"+id).serializeArray();
	console.log("a%o",a);
	var result = {};
	for( var i = 0; i < a.length ; i++ ) {
		result[a[i]['name']] = a[i]['value'];
	}
	console.log("result%o",result);
	return result;
}

function getParamForMult(id) {
	var a = $("#"+id).serializeArray();
	console.log("a%o",a);
	var result = {};
	for( var i = 0; i < a.length ; i++ ) {
		if(result[a[i]['name']] != null && result[a[i]['name']] != ''){
			result[a[i]['name']] += ','+ a[i]['value'];
		}else{
			result[a[i]['name']] = a[i]['value'];
		}
	}
	console.log("result%o",result);
	return result;
}

function getParamArray(id){
	var a = $("#"+id).serializeArray();
	var result = [];
	for( var i = 0; i < a.length ; i++ ) {
		result.push(a[i]['value']);
	}
	return result;
}

/**
 * 将 json 对象 转换为url 参数
 * @param json
 */
function json2Url(json){
	var url = "";
	for( p in json) {
		url += "&"+p+"="+json[p];
	}
	
	if(url.length > 1 ) {
		url = url.substring(1,url.length);
	}
	
	return url;
}

/**
 * 获取Cookie的值
 * @param c_name
 */
function getCookie(c_name){
	if (document.cookie.length>0){
		var c_start=document.cookie.indexOf(c_name + "=");
		if (c_start!=-1){
			c_start=c_start + c_name.length+1;
			c_end=document.cookie.indexOf(";",c_start);
			if (c_end==-1) 
				c_end=document.cookie.length;
				return unescape(document.cookie.substring(c_start,c_end));
				}
	 }
	return "";
}

function setCookie(c_name,value,expiredays) {
	var exdate = new Date();
	exdate.setDate(exdate.getDate() + expiredays);
	document.cookie=c_name+ "=" + escape(value) + ((expiredays==null) ? "" : ";expires="+exdate.toGMTString());
}

function getQuery(name) {
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	var r = window.location.search.substr(1).match(reg);
	if (r!=null) return unescape(r[2]); return null; 
};

function getQueryByName(name){
	var list = location.href.split("&"+name+"=");
	if(list.length<2)
		return null;
	return list[1].split("&")[0];
}
