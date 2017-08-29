/**
 * 弃用
 * 
 * @param obj
 * @param num
 */

function changeTabs(obj,num) {
	$(".tabs_tab").removeClass("tabs_tab_selected");
	$(obj).addClass("tabs_tab_selected");
	$(".tabs_item").hide();
	$(".tabs_item"+num).show();
	var roadcode = getQuery("roadcode");
	
	if(num == 1) {
		showChart1(roadcode);
	}
	
	if( num == 2 ) {
		showChart2(roadcode);
	}
	
	if( num == 3 ) {
		showChart3(roadcode);
	}
	
}


function showChart1(roadcode) {

}

function showChart2(roadcode){

}

function showChart3(roadcode){
	
}

function showChart4(roadcode){
	
}

window.onload = function(){
	$(".tabs_content").height($("body").height()-28);
	showChart1();
	window.onresize = function(e){
		$(".tabs_content").height($("body").height()-28);
	};
};

/**
 * 桥梁 提交 
 */
function mysubmit(){
		$("#dg").datagrid("load",getParam("fm"));
}
