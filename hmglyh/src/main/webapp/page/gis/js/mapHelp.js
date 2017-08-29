/**
 * 地图 定点方法 
 * datagrid onload 的 回调方法 
 */

function Apoint(rows,windowid,imgpath,columns,title,isClear,getButtons){
	
	if( rows.length == 0 ) return;
	
	if(isClear) {
		map.clearLayerByWindowId(windowid);
	}
	var points= [];
	$.each(rows,function(i,d){
		var point = {
				ptx:d.ptx,
				pty:d.pty,
				imgpath:"/hmglyh/page/gis/mapimg/"+imgpath,
				popup:{
					title:title,
					rowData:d,
					columns:columns
				}
		};
		
		if( getButtons ) {
			point.popup.buttons = getButtons(d);
		}
		 
		points.push(point);
	});
	map.addPointByJw(points,windowid);
}
/**
 * 地图，根据路线桩号定位的方法
 */
function APointByZh(rows,windowid,imgpath,columns,title,isClear,getButtons){
if( rows.length == 0 ) return;
	
	if(isClear) {
		map.clearLayerByWindowId(windowid);
	}
	var points= [];
	$.each(rows,function(i,d){
		var point = {
				roadcode:d.roadcode,
				zh:d.pos.split("-")[0],
				imgpath:"/hmglyh/page/gis/mapimg/"+imgpath,
				popup:{
					title:title,
					rowData:d,
					columns:columns
				}
		};
		
		if( getButtons ) {
			point.popup.buttons = getButtons(d);
		}
		 
		points.push(point);
	});
	map.addPointByZh(points,windowid);
}

/**
 *  treegrid 全部定位
 * @param rows
 * @param windowid
 * @param imgpath
 * @param columns
 * @param title
 * @param isClear
 */
function treePoint(tree,windowid,imgpath,columns,title,isClear,buttons) {
	var tree = tree[0];
	var TREE_POINTS = [];
	
	if(isClear) {
		map.clearLayerByWindowId(windowid);
	}
	getTreeGridPoints(tree,imgpath,title,columns,buttons,TREE_POINTS);
	map.addPointByJw(TREE_POINTS,windowid);
}

/**
 * 递归获取 treegrid 的 经纬度
 * @param img
 * @returns
 */
function getTreeGridPoints(tree,imgpath,title,columns,buttons,TREE_POINTS){
	var point = {
			ptx:tree.ptx,
			pty:tree.pty,
			imgpath:"/hmglyh/page/gis/mapimg/"+imgpath,
			popup:{
				title:title,
				rowData:tree,
				columns:columns
			}
	};
	
	if( buttons && tree.bmcode.length == 6) {
		point.popup.buttons = buttons(tree);
	}
	
	TREE_POINTS.push(point);
	
	if( tree.children && tree.children.length > 0 ) {
		$.each(tree.children,function(i,d){
			getTreeGridPoints(d,imgpath,title,columns,buttons,TREE_POINTS);
		});
	}
	
	
}
