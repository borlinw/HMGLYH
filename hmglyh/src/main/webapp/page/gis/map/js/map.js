/**
 * gis地图控件
 * @className:HdMap
 * @param:
 * @method:
 *
 * */
var iLineFlag = false;// 是否处于i查询状态
var iZhFlag = false;// 是否处于i查询状态
var iPointFlag = false;// 是否处于i查询状态

if (!window.HdMap) window.HdMap = {};
var HdMap = function () {
};
HdMap.prototype = {
    url:null,
    options:null,
    /**
     * Property: div
     * {} 地图容器
     */
    div: null,
    /**
     * Property: map
     * {}
     */
    map: null,
    /**
     * Property: popoup
     * {}
     */
    popup:null,
    
    intervalHandler:null,
    
    /**
     * Property: this.vectorLayer
     *
     */
    vectorLayer: null,
    LayerCatch:{},

    /**
     * Property: lineFeature
     *
     */
    lineFeature: null,
    startLonlat:null,
    
    HDLineCatch:{},

    /**
     * 初始化加载地图
     * */		
    initMap: function (div, url,bounds,layerName) {

        var wmsLayer;
        var pureCoverage = false;
        // pink tile avoidance
        OpenLayers.IMAGE_RELOAD_ATTEMPTS = 5;
        // make OL compute scale according to WMS spec
        OpenLayers.DOTS_PER_INCH = 25.4 / 0.28;
        var options = {
            controls: [],
            transitionEffect: "resize",
            maxExtent: bounds,
            maxResolution: 0.09816796875,
            projection: "EPSG:4326",
            units: 'degrees'
        };
        this.map = new OpenLayers.Map(div, options);
        wmsLayer = new OpenLayers.Layer.WMS(
            "wmsLayer", url,
            {
                LAYERS: layerName,
                STYLES: '',
                format: 'image/png',
                tiled: !pureCoverage,
                tilesOrigin: this.map.maxExtent.left + ',' + this.map.maxExtent.bottom

            },
            {attribution:'数据来源：'+ '<a target="_blank" ' +
                'href="http://www.hdsxtech.com">' +
                '恒达时讯科技</a> '},
            {
                buffer: 0,
                displayOutsideMaxExtent: true,
                isBaseLayer: true,
                transitionEffect: 'resize'
            }

        );

        this.map.addLayer(wmsLayer);
        //初始化设置地图中心,设置地图的放大级别
        //this.map.zoomToMaxExtent();
        this.map.setCenter(new OpenLayers.LonLat(85.016870579896,44.553373664609),7);
       
        // 添加地图控件	
      /*  this.map.addControl(new OpenLayers.Control.PanZoomBar({
            position: new OpenLayers.Pixel(2, 15)
        }));*/
        this.map.addControl(new OpenLayers.Control.Navigation());
       /* this.map.addControl(new OpenLayers.Control.Scale($('scale')));
        this.map.addControl(new OpenLayers.Control.MousePosition({element: $('location')}));*/
        
    },
    
    centerMap:function(){
        this.map.setCenter(new OpenLayers.LonLat(85.016870579896,44.553373664609),4);
    },
    /**
     * 添加比例尺控件并中文化
     * */
    addScaline:function(){
        OpenLayers.INCHES_PER_UNIT["千米"] = OpenLayers.INCHES_PER_UNIT["km"];
        OpenLayers.INCHES_PER_UNIT["米"] = OpenLayers.INCHES_PER_UNIT["m"];
        /*OpenLayers.INCHES_PER_UNIT["公里"] = OpenLayers.INCHES_PER_UNIT["mi"];
         OpenLayers.INCHES_PER_UNIT["英寸"] = OpenLayers.INCHES_PER_UNIT["ft"];*/
        this.map.addControl(new OpenLayers.Control.ScaleLine({topOutUnits: "千米",
            topInUnits: "米", bottomOutUnits: '', bottomInUnits: ''
        }));
    },
    /**
     * 添加地图地图加载进度条控件
     * */
    addLoadingPanel:function(){
        var loadingpanel = new OpenLayers.Control.LoadingPanel();
        this.map.addControl(loadingpanel);
    },
    /**
     * 添加地图自定义导航控件
     * */
    addPanZoomBar:function(){
        var panZoomBar = new OpenLayers.Control.TDTPanZoomBar();
        this.map.addControl(panZoomBar);
    },
    /**
     * 添加mouseposition鼠标跟随
     * */
    addMousePosition:function(){
        var mousePosition = new OpenLayers.Control.MousePosition({
            prefix:'<a target="_blank" ' +
                'href="http://spatialreference.org/ref/epsg/4326/">' +
                'EPSG:4326</a> 坐标: '
            /* element:document.getElementById('location')*/
        });
        this.map.addControl(mousePosition);
    },
    /**
     * 添加鹰眼控件
     * */
    addOverViewMap:function(){
        var overViewMap = new OpenLayers.Control.LTOverviewMap({

        });
        this.map.addControl(overViewMap);
    },
   
   /**
	*   可通过鼠标拖拽的方式平移地图
	**/
	dragPan:function() {
		//实例化 DragPan 控件
		var dragPan = new OpenLayers.Control.DragPan();
		this.map.addControl(dragPan);
		//激活控件
		dragPan.activate();

		map.cancelMeasureLine();
	},
    

    /**
     * 拉框放大
     * */
    zoomInBox:function(){
        var controlBox = new OpenLayers.Control();
        OpenLayers.Util.extend(controlBox, {
            draw: function () {
                this.box = new OpenLayers.Handler.Box( controlBox,
                    {"done": this.notice},{ "persist": true,boxDivClassName:"olHandlerBoxZoomBox",keyMask:OpenLayers.Handler.MOD_NONE}
                   );
                this.box.activate();
            },
            notice: function (e) {
			//	console.log(e.getCenterLonLat());
			//console.log(e);
				//map.map.zoomToExtent(e);
			//	map.map.setCenter(e.getCenterLonLat(),map.map.getZoom()+1);
             //   map.zoomIn();
				var ll = this.map.getLonLatFromPixel(new OpenLayers.Pixel(e.left, e.bottom));
                var ur = this.map.getLonLatFromPixel(new OpenLayers.Pixel(e.right, e.top));
               
			  var  bounds = new OpenLayers.Bounds();
				bounds.extend(new OpenLayers.LonLat(ll.lon.toFixed(4),ll.lat.toFixed(4)));
				bounds.extend(new OpenLayers.LonLat(ur.lon.toFixed(4),ur.lat.toFixed(4)));
				
			/*	alert(ll.lon.toFixed(4) + ", " +
                    ll.lat.toFixed(4) + ", " +
                    ur.lon.toFixed(4) + ", " +
                    ur.lat.toFixed(4));*/
				
				map.map.zoomToExtent(bounds);

            }
        });
        this.map.addControl(controlBox);
    },
  
    /**
     * 拉框缩小
     * */
    /**
     * 拉框缩小
     * */
    zoomOutBox:function(){
        var controlBox = new OpenLayers.Control();
        OpenLayers.Util.extend(controlBox, {
            draw: function () {
                this.box = new OpenLayers.Handler.Box( controlBox,
                    {"done": this.notice},{ "persist": true,boxDivClassName:"olHandlerBoxZoomBox",keyMask:OpenLayers.Handler.MOD_NONE}
                    );
                this.box.activate();
            },
            notice: function (e) {
               // map.zoomOut();

				var ll = this.map.getLonLatFromPixel(new OpenLayers.Pixel(e.left, e.bottom));
                var ur = this.map.getLonLatFromPixel(new OpenLayers.Pixel(e.right, e.top));
               
				var bounds = new OpenLayers.Bounds();
				bounds.extend(new OpenLayers.LonLat(ll.lon.toFixed(4),ll.lat.toFixed(4)));
				bounds.extend(new OpenLayers.LonLat(ur.lon.toFixed(4),ur.lat.toFixed(4)));

				map.map.setCenter(bounds.getCenterLonLat(),map.map.getZoom() - 1 );

            }
        });
        this.map.addControl(controlBox);
    },
    /**
     * 测量线
     * */
    measureLine:function(){
        var renderer = OpenLayers.Util.getParameters(window.location.href).renderer;
        renderer = (renderer) ? [renderer] : OpenLayers.Layer.Vector.prototype.renderers;

		var sketchSymbolizers = {  
            "Point": {  
                graphicName: "circle",  
                graphicHeight: 8,  
                graphicWidth: 8,  
                fillColor: "#0000FF",  
				strokeColor: "#0000FF" , 
                fillOpacity: 0.3,  
                strokeWidth: 2 
            },  
            "Line": {  
                strokeWidth: 2.0,  
                strokeOpacity: 1,  
                strokeColor: "#0000FF"  
            },  
            "Polygon": {  
                strokeWidth: 2.0,  
                strokeOpacity: 1,  
                strokeColor: "#0000FF",  
                fillColor: "#ccccff",  
                fillOpacity: 0.3  
            }  
        };  

		var style = new OpenLayers.Style();  
        style.addRules([new OpenLayers.Rule({ symbolizer: sketchSymbolizers })]);  
        var styleMap = new OpenLayers.StyleMap({ "default": style });
		
		this.pointLayer = new OpenLayers.Layer.Vector("Point Layer",{
			styleMap:styleMap
		});
		
		var style2 = new OpenLayers.Style({
				label:"${type}",
				fontColor:"blue",
				fontFamily:"宋体",
				fontWeight:"bold"
		});

		
		this.labelLayer  = new OpenLayers.Layer.Vector
			("points",{
				styleMap:new OpenLayers.StyleMap(style2)
			});

		
	

		this.map.addLayers([this.pointLayer,this.labelLayer]);

        this.LineMeasure = new OpenLayers.Control.Measure(
            OpenLayers.Handler.Path, {
                eventListeners: {
                    measure: function(evt) {
						var p = evt.geometry.components;
						len = p.length;
						p = p[len-1].clone();

						var pix = map.map.getPixelFromLonLat(new OpenLayers.LonLat(p.x,p.y));
						pix = pix.add(30,30);
						var ll = map.map.getLonLatFromPixel(pix);
						map.labelLayer.addFeatures([new OpenLayers.Feature.Vector(new OpenLayers.Geometry.Point(ll.lon,ll.lat),{type:evt.measure.toFixed(2) + evt.units})]);
                    },
					measurepartial:function(evt) {
						console.log(evt);
						var p = evt.geometry.components;
						len = p.length;
						if(evt.measure == 0) {
							map.labelLayer.removeAllFeatures();
							map.pointLayer.removeAllFeatures();
						}
 
						p = p[len-1].clone();

						var pix = map.map.getPixelFromLonLat(new OpenLayers.LonLat(p.x,p.y));
						pix = pix.add(30,30);
						var ll = map.map.getLonLatFromPixel(pix);

					//	console.log("p%o",evt.measure.toFixed(2) + evt.units);
						map.labelLayer.addFeatures([new OpenLayers.Feature.Vector(new OpenLayers.Geometry.Point(ll.lon,ll.lat),{type:evt.measure.toFixed(2) + evt.units})]);

					}
                },
                persist: true,
                handlerOptions: {
					style: "default",
                    layerOptions: {
                        renderers: renderer,
						styleMap: styleMap
                    }
                }
            }
        );

		this.drawPoint = new OpenLayers.Control.DrawFeature(this.pointLayer,
                        OpenLayers.Handler.Point,
						{
						}
						);

       
		this.map.addControl(this.drawPoint);
		this.map.addControl(this.LineMeasure);
      
		this.drawPoint.activate();
		this.LineMeasure.activate();
    },
	cancelMeasureLine:function(){
		if(map.labelLayer != null)
			map.labelLayer.removeAllFeatures();
		if(map.pointLayer != null )
			map.pointLayer.removeAllFeatures();
		if(this.drawPoint != null )
			this.drawPoint.deactivate();
		if(this.LineMeasure != null )
			this.LineMeasure.deactivate();
	},
    /**
     * 测量面
     * */
    measurePolygon:function(){
        var renderer = OpenLayers.Util.getParameters(window.location.href).renderer;
        renderer = (renderer) ? [renderer] : OpenLayers.Layer.Vector.prototype.renderers;
		
		var sketchSymbolizers = {  
            "Point": {  
                graphicName: "cross",  
                graphicHeight: 8,  
                graphicWidth: 8,  
                fillColor: "#FF0000",  
                fillOpacity: 1,  
                strokeWidth: 0  
            },  
            "Line": {  
                strokeWidth: 2.0,  
                strokeOpacity: 1,  
                strokeColor: "#0000FF"  
            },  
            "Polygon": {  
                strokeWidth: 2.0,  
                strokeOpacity: 1,  
                strokeColor: "#0000FF",  
                fillColor: "#ccccff",  
                fillOpacity: 0.3  
            }  
        };  

		var style = new OpenLayers.Style();  
        style.addRules([new OpenLayers.Rule({ symbolizer: sketchSymbolizers })]);  
        var styleMap = new OpenLayers.StyleMap({ "default": style });

        var polygonMeasure = new OpenLayers.Control.Measure(
            OpenLayers.Handler.Polygon, {
                persist: true,
                handlerOptions: {
                    style: "default",
                    layerOptions: {
                        renderers: renderer,
						styleMap: styleMap
                    }
                },
                eventListeners: {
                    measure: function(evt) {
                        alert("面积 " + evt.measure + "平方"+evt.units );
						polygonMeasure.deactivate();
                    }
                }
            }
        );
        this.map.addControl(polygonMeasure);
        polygonMeasure.activate();
    },
    zoomToMaxExtent:function(){
        this.map.zoomToMaxExtent();
    },
    selectFeature:function(windowid,featureid,method){
    	var layer = this.map.getLayersByName(windowid+"_layer")[0];
    	var feature;
    	if( featureid ) {
    		if( !method && method != "") {
    			feature = layer.getFeatureById(featureid);
    		}else{
    			feature = layer[method](featureid);
    		}
    		
    	}else {
    		feature = layer.features[0];
    	}
    	
    	var controlid = windowid + "_control";
    	var selector = this.map.getControl(controlid);
    	selector.select(feature);
    },
    
    // 通过windowid 隐藏图层 
    hideLayer:function(windowid) {
    	var layerArray = this.map.getLayersByName(windowid+"_layer");
    	
    	if( layerArray.length > 0 ) {
    		for( var i = 0 ; i < layerArray.length ; i++ ) {
    			
    			var name = layerArray[i].name;
    			var selectedFeatures = layerArray[i].selectedFeatures;
    			this.LayerCatch[name]=selectedFeatures;
    			this.removeAllPopUp();
    			layerArray[i].setVisibility(false);
    		}
    	}
    },
    
    // 显示 layer
    
    showLayer:function(windowid) {
    	var layerArray = this.map.getLayersByName(windowid + "_layer");
    	if( layerArray.length > 0 ) {
    		for( var i = 0 ; i < layerArray.length ; i ++ ) {
    			layerArray[i].setVisibility(true);
    			var feature = this.LayerCatch[layerArray[i].name];
    			if(feature && feature.length > 0 ) {
    				feature = feature[0];
    				var control = this.map.getControl(windowid + "_control");
    				control.select(feature);
    			}
    		}
    	}
    },
    removeAllPopUp :function() {
    	var len  = map.map.popups.length;
    	for(var i = 0; i < len; i++) {
    		map.map.removePopup(map.map.popups[0]);
    	}
    },
    
    /**
     * 根据 路线编码 得到 整条 路线的 shape 编码 
     * roadcode 路线编码 
     * isCopy 默认返回 新的实例 如果 传入 true 共享一个实例
     */
    getLineObj : function(roadcode,isCopy,ldlx){
    	
    	if( ldlx == undefined && this.HDLineCatch[roadcode]) {
    		if(isCopy) {
    			if( ldlx != undefined && ldlx != "" ) {
    				return this.HDLineCatch[roadcode+"_"+ldlx];
    			}else{
    				return this.HDLineCatch[roadcode];
    			}
    			
    		}else{
    			var line = {};
    			line.attr = this.HDLineCatch[roadcode].attr;
    			line.geometry =  new OpenLayers.Format.WKT().read("linestring("+this.HDLineCatch[roadcode].shapeString+")").geometry;
    			return line;
    		}
    		
    	}else if(ldlx != undefined && this.HDLineCatch[roadcode+"_"+ldlx] ){
    		var line = {};
			line.attr = this.HDLineCatch[roadcode+"_"+ldlx].attr;
			line.geometry =  new OpenLayers.Format.WKT().read("linestring("+this.HDLineCatch[roadcode+"_"+ldlx].shapeString+")").geometry;
			return line;
    	}else{
    		var lineObj = null;
    		
    		var url = "/hmglyh/gis/luxian_getRoadMapInfo.do?gmr.roadcode="+roadcode;
    		if( ldlx != undefined && ldlx != "" ) {
    			url += "&gmr.ldlx="+ldlx;
    		}
    		
    		$.ajax({
    			url:url,
    			async:false,
    			dataType:"json",
    			success:function(result){
    				 var line = new OpenLayers.Format.WKT().read("linestring("+result.shape+")").geometry;
    				
    				var p1 = line.components[0];
    				 var p2 = line.components[line.components.length - 1 ];
    				 
    				 if( p1.x == p2.x && p1.y == p2.y ) {
    					 line.components.length  = line.components.length-1; 
    				 }
    				 
    				 lineObj = {
    						 geometry:line,
    						 shapeString:result.shape,
    						 attr:{
    							 roadcode:result.roadcode,
    							 startzh:result.startzh,
    							 endzh:result.endzh
    						 }
    				 };
    				 if(ldlx){
    					 map.HDLineCatch[roadcode+"_"+ldlx] = lineObj;
    				 }else{
    					 map.HDLineCatch[roadcode] = lineObj;
    				 }
    				
    			},
    			error:function(e){
    				console.error(e);
    			}
    		});
    		return lineObj;
    	}
    	
    },
    
    getXdgjLineObj:function(xcid){
    	if(this.HDLineCatch[xcid]) {
    		return this.HDLineCatch[xcid];
    	}else{
    		var lineObj = null;
    		$.ajax({
    			url:"/hmglyh/rcyh/xdjl_getXdgjShape.do?xcsj.xcid="+xcid,
    			async:false,
    			dataType:"json",
    			success:function(r){
    				 if( r.isSuccess ) {
    					 var line = new OpenLayers.Format.WKT().read("linestring("+r.data.shape+")").geometry;
    					 lineObj = line;
    					 map.HDLineCatch[xcid] = lineObj;
    				 }else{
    					 $.messager.alert("提示",r.info,"warning");
    					 return;
    				 }
    			},
    			error:function(e){
    				console.error(e);
    			}
    		});
    		return lineObj;
    	}
    },
    
    /**
     * 测试
     */
    getTestLineObj:function(param){
    		var lineObj = null;
    		
    		if(param == undefined){
    			return null;
    		}
    		
    		if(param.roadcode == undefined || param.roadcode == "" ) {
    			return null;
    		}
    		
    		if( param.startzh == undefined || param.startzh == "" ) {
    			return null;
    		}
    		
    		if( param.endzh == undefined || param.endzh == "" ) {
    			return null;
    		}
    		
    		$.ajax({
    			url:"/hmglyh/gis/luxian_getTestLine.do?gmr.roadcode="+param.roadcode+"&gmr.startzh="+param.startzh+"&gmr.endzh="+param.endzh,
    			async:false,
    			dataType:"json",
    			success:function(r){
					 var line = new OpenLayers.Format.WKT().read("linestring("+r.shape+")").geometry;
					 lineObj = line;
    			},
    			error:function(e){
    				console.error(e);
    			}
    		});
    		return lineObj;
    },
    
    addLine_:function(lineJson,line){
    	var windowid = lineJson.windowid ? lineJson.windowid : "default";
		var strokeColor = lineJson.strokeColor ? lineJson.strokeColor : "#990000";
		var strokeWidth = lineJson.strokeWidth ? lineJson.strokeWidth : 4;
		// 定义地图样式 
		var styleMap = new OpenLayers.StyleMap({
	            "default": {
	                strokeColor: strokeColor,
	                strokeWidth: strokeWidth,
	                strokeDashstyle: "solid",
	                attributes:"info"
	            },
	            "select":{
	                strokeColor:strokeColor,
	                strokeWidth: strokeWidth,
	                strokeDashstyle: "solid",
	                attributes:"info"
	            }
	    });
	
		var lineLayer = this.map.getLayersByName(windowid+"_layer");
		
		if( lineLayer.length > 0 ) {
			lineLayer = lineLayer[0];
		}else{
			// 在地图上定线
    		lineLayer = new OpenLayers.Layer.Vector(windowid+"_layer",
                {
                styleMap:styleMap,
                eventListeners:{
                	'featureselected':onFeatureSelect,
                	'featureunselected':unSelect,
                	'featureremoved':onFeaturermoved
                }
                });
    		this.map.addLayer(lineLayer);
		}
        
        var feature = new OpenLayers.Feature.Vector(line);
        
        var featureid = lineJson.roadcode;

        if(lineJson.startzh != undefined && lineJson.startzh != "" ) {
        	featureid +="_" + lineJson.startzh;
        }
        
        if(lineJson.endzh != undefined && lineJson.endzh != "" ) {
        	featureid +="_"+ lineJson.endzh;
        }
        
        feature.id = featureid;
        
        if( lineJson.popup ) {
        	feature.mypopup = lineJson.popup;
        }
        
        var myfeature = lineLayer.getFeatureById(featureid);
     
        if( myfeature == null ) {
        	 lineLayer.addFeatures(feature);
        }else{
        //	lineLayer.removeFeatures(myfeature);
        	lineLayer.addFeatures(feature);
        }
    	function onFeatureSelect(feature) {
    	   if(feature.feature.mypopup == undefined ) return;
			   selectedFeature = feature;
			   var components = feature.feature.geometry.components;
			   var p = components[parseInt(components.length/2)];
			   var ll = new OpenLayers.LonLat(p.x,p.y);
			   map.addMyPopup(feature.feature,ll,feature.feature.mypopup);
    	}
        function unSelect(evt){
         	var len  = map.map.popups.length;
         	for(var i = 0; i < len; i++) {
         		map.map.removePopup(map.map.popups[0]);
         	}
        };
        function onFeaturermoved(evt){
         	var len  = map.map.popups.length;
         	for(var i = 0; i < len; i++) {
         		map.map.removePopup(map.map.popups[0]);
         	}
        }
     	var controlid = windowid+"_control";
        var selector = this.map.getControl(controlid);     
        if ( selector != null ) {
        	this.map.removeControl(selector);
        }
        selector = new OpenLayers.Control.SelectFeature(lineLayer,{
     		id:controlid,
  			click:true,
  			autoActivate:true
  		}); 
      	this.map.addControl(selector);
        if( lineJson.popup) {
			// 让 路线 处于选中的状态
         	if(!lineJson.nopopup){
         		selector.select(feature);
         	}
        }
        if(!lineJson.nopopup) {
        	map.map.raiseLayer(lineLayer);
        	this.map.zoomToExtent(feature.geometry.bounds,false);
        }
    },
    
    /**
     *  根据数据库存的信息定线
     *  lineJson {
     *  	windowid:			窗口id
     *  	roadcode:roadcode,	路线编码	必须
     *  	startzh:startzh,	起点桩号	
     *  	endzh:endzh			止点桩号
     *  	strokeColor:   		标线颜色
     *  }
     */
    addGpsmailroadToMap:function(lineJson){
    	var queryParams = {};
    	if( lineJson.roadcode != undefined) {
    		queryParams["gmr.roadcode"] = lineJson.roadcode; 
    	}
    	if( lineJson.startzh != undefined ) {
    		queryParams["gmr.startzh"] = lineJson.startzh;
    	}
    	if( lineJson.endzh != undefined ) {
    		queryParams["gmr.endzh"] = lineJson.endzh;
    	}
    	if( lineJson.ldlx != undefined ) {
    		queryParams["gmr.ldlx"] = lineJson.ldlx;
    	}
    	if( lineJson.id != undefined ) {
    		queryParams["gmr.id"] = lineJson.id;
    	}
    	$.ajax({
			url:"/hmglyh/gis/luxian_queryGpsmailroad.do",
			data:queryParams,
			dataType:"json",
			success:function(r){
				//console.log(r);
				 if( r && r.length > 0 ) {
					 $.each(r,function(i,d){
						 var line = new OpenLayers.Format.WKT().read("linestring("+d.shapeStr+")").geometry;
						 lineObj = line;
						 map.addLine_(lineJson,lineObj);
					 });
				 }
			},
			error:function(e){
				console.error(e);
			}
		});
    },
    
    /**
     *  根据 路线编码 和桩号 定线 如果 桩号 不传 定 整条线
     *  lineJson {
     *  	windowid:			窗口id
     *  	roadcode:roadcode,	路线编码	必须
     *  	startzh:startzh,	起点桩号	
     *  	endzh:endzh			止点桩号
     *  	strokeColor:   		标线颜色
     *  }
     */
    addLineToMap:function(lineJson){
    	
    		var lineObj = null;
    		if( lineJson.ldlx != undefined && lineJson.ldlx != '' ) {
    			lineObj = this.getLineObj(lineJson.roadcode,false,lineJson.ldlx);
    		}else{
    			lineObj = this.getLineObj(lineJson.roadcode);
    		}
    
    		var line = lineObj.geometry;
    		
    		if(
    				lineJson.startzh != null && lineJson.endzh != null &&
    				lineJson.startzh != "" && lineJson.endzh != "" 
    		){
    			
    			if( lineJson.startzh > lineJson.endzh) {
    				var tempzh = lineJson.endzh;
    				lineJson.endzh = lineJson.startzh;
    				lineJson.startzh = tempzh;
    			}
    			
    			// 如果定义了 起止点 桩号 截取 桩号 之间的 shape 字段 
        		var p1 = mapUtils.getLonLatByRoadPos(line,lineObj.attr.startzh,lineObj.attr.endzh,lineJson.startzh);
        		var p2 = mapUtils.getLonLatByRoadPos(line,lineObj.attr.startzh,lineObj.attr.endzh,lineJson.endzh);
        		//console.log("p1 %o",p1);
        		//console.log("p2 %o",p2);
        		line.components = line.components.slice(p1.m,p2.m);
    		}
    		var windowid = lineJson.windowid ? lineJson.windowid : "default";
    		var strokeColor = lineJson.strokeColor ? lineJson.strokeColor : "#990000";
    		var strokeWidth = lineJson.strokeWidth ? lineJson.strokeWidth : 4;
    		// 定义地图样式 
    		var styleMap = new OpenLayers.StyleMap({
    	            "default": {
    	                strokeColor: strokeColor,
    	                strokeWidth: strokeWidth,
    	                strokeDashstyle: "solid",
    	                attributes:"info"
    	            },
    	            "select":{
    	                strokeColor:strokeColor,
    	                strokeWidth: strokeWidth,
    	                strokeDashstyle: "solid",
    	                attributes:"info"
    	            }
    	    });
    	
    		var lineLayer = this.map.getLayersByName(windowid+"_layer");
    		
    		if( lineLayer.length > 0 ) {
    			lineLayer = lineLayer[0];
    		}else{
    			// 在地图上定线
        		lineLayer = new OpenLayers.Layer.Vector(windowid+"_layer",
                    {
                    styleMap:styleMap,
                    eventListeners:{
                    	'featureselected':onFeatureSelect,
                    	'featureunselected':unSelect,
                    	'featureremoved':onFeaturermoved
                    }
                    });
        		this.map.addLayer(lineLayer);
    		}
            
            var feature = new OpenLayers.Feature.Vector(line);
            
            var featureid = lineJson.roadcode;

            if(lineJson.startzh != undefined && lineJson.startzh != "" ) {
            	featureid +="_" + lineJson.startzh;
            }
            
            if(lineJson.endzh != undefined && lineJson.endzh != "" ) {
            	featureid +="_"+ lineJson.endzh;
            }
            
            feature.id = featureid;
            
            if( lineJson.popup ) {
            	feature.mypopup = lineJson.popup;
            }
            
            var myfeature = lineLayer.getFeatureById(featureid);
         
            if( myfeature == null ) {
            	 lineLayer.addFeatures(feature);
            }else{
            	lineLayer.removeFeatures(myfeature);
            	lineLayer.addFeatures(feature);
            }
        	function onFeatureSelect(feature) {
        	   if(feature.feature.mypopup == undefined ) return;
  			   selectedFeature = feature;
  			   var components = feature.feature.geometry.components;
  			   var p = components[parseInt(components.length/2)];
  			   var ll = new OpenLayers.LonLat(p.x,p.y);
  			   map.addMyPopup(feature.feature,ll,feature.feature.mypopup);
        	}
	        function unSelect(evt){
             	var len  = map.map.popups.length;
             	for(var i = 0; i < len; i++) {
             		map.map.removePopup(map.map.popups[0]);
             	}
	        };
	        function onFeaturermoved(evt){
             	var len  = map.map.popups.length;
             	for(var i = 0; i < len; i++) {
             		map.map.removePopup(map.map.popups[0]);
             	}
	        }
         	var controlid = windowid+"_control";
	        var selector = this.map.getControl(controlid);     
	        if ( selector != null ) {
	        	this.map.removeControl(selector);
	        }
	        selector = new OpenLayers.Control.SelectFeature(lineLayer,{
         		id:controlid,
      			click:true,
      			autoActivate:true
      		}); 
          	this.map.addControl(selector);
            if( lineJson.popup) {
    			// 让 路线 处于选中的状态
             	if(!lineJson.nopopup){
             		selector.select(feature);
             	}
            }
            if(!lineJson.nopopup) {
            	map.map.raiseLayer(lineLayer);
            	this.map.zoomToExtent(feature.geometry.bounds,false);
            }
    },
    
    /**
     *  根据 路线编码 和桩号 定线 如果 桩号 不传 定 整条线
     *  lineJson {
     *  	windowid:			窗口id
     *  	xcid:xcid,			xcid 必须
     *  	strokeColor:   		标线颜色
     *  }
     */
    addXdgjLineToMap:function(lineJson){
    	
	      	clearInterval(map.intervalHandler);
			map.clearLayerByWindowId('xunchagj');
    	
    		var line = this.getXdgjLineObj(lineJson.xcid);
    		var windowid = lineJson.windowid ? lineJson.windowid : "default";
    		var strokeColor = lineJson.strokeColor ? lineJson.strokeColor : "#00ff00";
    		var strokeWidth = lineJson.strokeWidth ? lineJson.strokeWidth : 10;
    		// 定义地图样式 
    		var styleMap = new OpenLayers.StyleMap({
    	            "default": {
    	                strokeColor: strokeColor,
    	                strokeWidth: strokeWidth,
    	                strokeDashstyle: "solid",
    	                attributes:"info"
    	            },
    	            "select":{
    	                strokeColor:strokeColor,
    	                strokeWidth: strokeWidth,
    	                strokeDashstyle: "solid",
    	                attributes:"info"
    	            }
    	    });
    	
    		var lineLayer = this.map.getLayersByName(windowid+"_layer");
    		
    		if( lineLayer.length > 0 ) {
    			lineLayer = lineLayer[0];
    		}else{
    			// 在地图上定线
        		lineLayer = new OpenLayers.Layer.Vector(windowid+"_layer",
                    {
                    styleMap:styleMap,
                    });
        		this.map.addLayer(lineLayer);
    		}
            
            var feature = new OpenLayers.Feature.Vector(line);
            
            var featureid = lineJson.xcid ;
            feature.id = featureid;
       
            if( lineJson.popup ) {
            	feature.mypopup = lineJson.popup;
            }
            
            var myfeature = lineLayer.getFeatureById(featureid);
         
            if( myfeature == null ) {
            	 lineLayer.addFeatures(feature);
            }else{
            	lineLayer.removeFeatures(myfeature);
            	lineLayer.addFeatures(feature);
            }
            this.map.zoomToExtent(feature.geometry.bounds,false);
            
            
            var stylePoint = new OpenLayers.StyleMap({
                "default": {
                    fillOpacity: 1,
                    strokeOpacity: 1,
                    strokeColor: "#000000",
                    graphicWidth: 64,
                    graphicHeight: 64,
                    externalGraphic: "${image}",
                    attributes: "${data}",
                    fontColor: "${favColor}",
                    fontSize: "12px",
                    fontFamily: "Courier New, monospace",
                    fontWeight: "bold",
                    labelAlign: "cm",
                    labelXOffset: "70",
                    labelYOffset: "-15",
                    labelOutlineColor: "white",
                    labelOutlineWidth: 3
                }
            });
            
            pointLayer = new OpenLayers.Layer.Vector(windowid+"_layer", {
	              styleMap:stylePoint
	        });
            
        	var len = feature.geometry.components.length;
      	  
            var lineFeature = feature;
            
            var point_obj = {"type": "Feature",
	  		 		  "properties": 
	  		 		   {
	  		 			  "pid":"carPoint",
	  		 			  "image": '/hmglyh/car1.png'
	  		 		   }, 
	  		 		   "geometry": {"type": "Point", "coordinates": [feature.geometry.components[0].x,feature.geometry.components[0].y]}
	  		 		};
            
            var jsons = {"type": "FeatureCollection", "features": [point_obj]};
            var geoJson = new OpenLayers.Format.GeoJSON();
            var feature = geoJson.read(jsons);
      		pointLayer.addFeatures(feature);
      	  	this.map.addLayer(pointLayer);
      	  	
      	
      	  	
      		var i = 0;
      	  	this.intervalHandler = setInterval(function(){
    		   i++;
    		   if( i >= len ) {
    			   clearInterval(map.intervalHandler);
    		   }
    		   addP(i);
      	  	},1000);
      	  	
      	  	function addP(i){
      	  	 pointLayer.removeFeatures(pointLayer.getFeaturesByAttribute("pid","carPoint"));
     	  	  var point_obj = {"type": "Feature",
	  		 		  "properties": 
	  		 		   {
	  		 			  "pid":"carPoint",
	  		 			  "image": '/hmglyh/car1.png'
	  		 		   }, 
	  		 		   "geometry": {"type": "Point", "coordinates": [lineFeature.geometry.components[i+10].x,lineFeature.geometry.components[i+10].y]}
	  		 		};
	           var jsons = {"type": "FeatureCollection", "features": [point_obj]};
	           var geoJson = new OpenLayers.Format.GeoJSON();
	           var feature = geoJson.read(jsons);
	           pointLayer.addFeatures(feature);
      	  }
    },
    
    
    
    addTestLineToMap:function(lineJson){
		var line = this.getTestLineObj(lineJson);
		
		if( line == null ) {
			$.messager.alert("警告","定位条件不准确,已经放弃定位","warning");
			return;
		}
		
		var strokeColor = lineJson.strokeColor ? lineJson.strokeColor : "#ff0000";
		var strokeWidth = lineJson.strokeWidth ? lineJson.strokeWidth : 8;
		var windowid = lineJson.windowid ? lineJson.windowid : "default";
		// 定义地图样式 
		var styleMap = new OpenLayers.StyleMap({
	            "default": {
	                strokeColor: strokeColor,
	                strokeWidth: strokeWidth,
	                strokeDashstyle: "solid",
	                attributes:"info"
	            },
	            "select":{
	                strokeColor:strokeColor,
	                strokeWidth: strokeWidth,
	                strokeDashstyle: "solid",
	                attributes:"info"
	            }
	    });
	
		
		// 在地图上定线 获取 路线图层
		var lineLayer = this.map.getLayersByName(windowid+"_layer");
		if( lineLayer.length > 0 ) {
			lineLayer = lineLayer[0];
		}else{
			// 在地图上定线
    		lineLayer = new OpenLayers.Layer.Vector(windowid+"_layer",
                {
                styleMap:styleMap,
                });
    		this.map.addLayer(lineLayer);
		}
		
		// 获取feature
		 var feature = new OpenLayers.Feature.Vector(line);
		 // 弹窗 
         if( lineJson.popup ) {
         	feature.mypopup = lineJson.popup;
         }
         var featureid = lineJson.roadcode;
         if(lineJson.startzh != undefined && lineJson.startzh != "" ) {
         	featureid +="_" + lineJson.startzh;
         }
         if(lineJson.endzh != undefined && lineJson.endzh != "" ) {
         	featureid +="_"+ lineJson.endzh;
         }
         feature.id = featureid;
         var myfeature = lineLayer.getFeatureById(featureid);
         if( myfeature == null ) {
         	 lineLayer.addFeatures(feature);
         }else{
         	lineLayer.removeFeatures(myfeature);
         	lineLayer.addFeatures(feature);
         }
         
     	function onFeatureSelect(feature) {
     	   if(feature.feature.mypopup == undefined ) return;
			   selectedFeature = feature;
			   var components = feature.feature.geometry.components;
			   var p = components[parseInt(components.length/2)];
			   var ll = new OpenLayers.LonLat(p.x,p.y);
			   map.addMyPopup(feature.feature,ll,feature.feature.mypopup);
     	}
	        function unSelect(evt){
          	var len  = map.map.popups.length;
          	for(var i = 0; i < len; i++) {
          		map.map.removePopup(map.map.popups[0]);
          	}
	         };
	         function onFeaturermoved(evt){
          	var len  = map.map.popups.length;
          	for(var i = 0; i < len; i++) {
          		map.map.removePopup(map.map.popups[0]);
          	}
	         }
	             
      	var controlid = windowid+"_control";
	        var selector = this.map.getControl(controlid);     
	        
	        if ( selector != null ) {
	        	this.map.removeControl(selector);
	        }
	        
	        selector = new OpenLayers.Control.SelectFeature(lineLayer,{
      		id:controlid,
   			click:true,
   			autoActivate:true
   		}); 
       	this.map.addControl(selector);
        if( lineJson.popup) {
 			// 让 路线 处于选中的状态
          	if(!lineJson.nopopup){
          		selector.select(feature);
          	}
        }
        if(!lineJson.nopopup) {
         	map.map.raiseLayer(lineLayer);
         	this.map.zoomToExtent(feature.geometry.bounds,false);
        }
    },
    
    /**
     * 在地图 上 添加 多点 如果 只有一个 点  默认 会 居中 显示  有弹窗 将 显示 弹窗 ， 如果 想取消此 默认 行为 将 传入nopopup 为true
     * @param points
     * @param windowid
     * @param nopopup
     */
    addPointBase:function(points,windowid,nopopup) {
    	  var jsons = {"type": "FeatureCollection", "features": points};
          var styleMap = new OpenLayers.StyleMap({
              "default": {
                  fillOpacity: 1,
                  strokeOpacity: 1,
                  strokeColor: "#000000",
                  graphicWidth: 24,
                  graphicHeight: 24,
                  externalGraphic: "${image}",
                  attributes: "${data}",
                  fontColor: "${favColor}",
                  fontSize: "12px",
                  fontFamily: "Courier New, monospace",
                  fontWeight: "bold",
                  labelAlign: "cm",
                  labelXOffset: "70",
                  labelYOffset: "-15",
                  labelOutlineColor: "white",
                  labelOutlineWidth: 3
              }
          });
          
          var geoJson = new OpenLayers.Format.GeoJSON();
          var pointLayer = this.map.getLayersByName(windowid+"_layer");
          
          if( pointLayer.length > 0 ) {
        	  pointLayer = pointLayer[0];
          }else{
        	  pointLayer = new OpenLayers.Layer.Vector(windowid+"_layer", {
	              styleMap:styleMap,
	               eventListeners:{
	              	'featureselected':onFeatureSelect,
	               	'featureunselected':unSelect,
	               	'featureremoved':onFeaturermoved
	               }
	          });
        	  this.map.addLayer(pointLayer);
          }
       
          function onFeatureSelect(evt) {
              feature = evt.feature;
              if( feature.attributes.popup ) {
            	  map.addMyPopup(feature,feature.geometry.getBounds().getCenterLonLat(),feature.attributes.popup);
              }
          }

          function unSelect(evt){
          	map.removeAllPopUp();
          };
          function onFeaturermoved(evt){
          	map.removeAllPopUp();
          }
          
         
    	  var feature = geoJson.read(jsons);
    	  
    	  if(points.length > 1) {
    		  pointLayer.addFeatures(feature);
    	  }else{
    		  var x = feature[0].geometry.x;
    		  var y = feature[0].geometry.y;
    		  pointLayer.removeFeatures(pointLayer.getFeaturesByAttribute("x_y",x+"_"+y));
    		  pointLayer.addFeatures(feature);
    	  }
    	  
    	 
    	  map.map.raiseLayer(pointLayer);
          
    	  var controlid = windowid + "_control";
    	  
    	  var selector = this.map.getControl(controlid);
    	  if( selector != null ) {
    		  this.map.removeControl(selector);
    	  }
    	  selector = new OpenLayers.Control.SelectFeature(pointLayer,{
    		  	id:controlid,
	  			click:true,
	  			autoActivate:true
	  	  }); 

		  this.map.addControl(selector);    
    	  
          if( points.length > 1 ) {   // 如果多点
         // 	map.map.zoomToMaxExtent();
        	  map.centerMap();
          }else{  						// 如果只有一个点 让这个点 处于选中的状态
        	 if(!nopopup) {
        		 map.map.setCenter(new OpenLayers.LonLat(points[0].geometry.coordinates[0],points[0].geometry.coordinates[1]),4);		
            	 selector.select(feature[0]);
        	 }
          }
    },
    
    /**
     * 根据 路线编码 和桩号 去定点
     * @param[ pointJson {
     * 		roadcode: 路线编码
     * 		zh:桩号
     * 		imgpath:图片路径
     * 		popup:弹窗定义对象
     * }]
     */
    addPointByZh:function(pointJsons,windowid,nopopup){
    	var points = [];
    	for( var i = 0 ; i < pointJsons.length; i ++ ) {
    		
    		var lineObj = this.getLineObj(pointJsons[i].roadcode);
    		var line = lineObj.geometry;
    		var point = mapUtils.getLonLatByRoadPos(line,lineObj.attr.startzh,lineObj.attr.endzh,pointJsons[i].zh);
    		
    		var point_obj = {"type": "Feature",
			  		 		  "properties": 
			  		 		   {
			  		 			  "x_y":point.x+"_"+point.y,
			  		 			  "image": pointJsons[i].imgpath
			  		 		   }, 
			  		 		   "geometry": {"type": "Point", "coordinates": [point.x,point.y]}
			  		 		};
    		
    		 if( pointJsons[i].popup ) {
    			 point_obj.properties.popup = pointJsons[i].popup;
    		 }
    		
    		 points.push(point_obj);
    	}
    	var windowid = windowid ? windowid : "default";
		this.addPointBase(points,windowid,nopopup);
    },
    
    /**
     * 根据 经度 和 纬度 定点 
     * @param[ pointJson {
     * 		ptx: 经度
     * 		pty: 纬度
     * 		imgpath:图片路径
     * 		popup:弹窗定义对象
     * }]
     * @param windowid
     */
    addPointByJw:function(pointJsons,windowid,nopopup){
    	var points = [];
    	for( var i = 0 ; i < pointJsons.length; i ++ ) {
    		var point_obj = {"type": "Feature",
    						  "id":windowid + "_" + pointJsons[i].ptx+"_"+pointJsons[i].pty,
			  		 		  "properties": 
			  		 		   {
			  		 			  "x_y":pointJsons[i].ptx+"_"+pointJsons[i].pty,
			  		 			  "image": pointJsons[i].imgpath
			  		 		   }, 
			  		 		   "geometry": {"type": "Point", "coordinates": [pointJsons[i].ptx,pointJsons[i].pty]}
			  		 		};
    		 if( pointJsons[i].popup ) {
    			 point_obj.properties.popup = pointJsons[i].popup;
    		 }
    		 
    		 points.push(point_obj);
    	}
    	
    	var windowid = windowid ? windowid : "default";
		this.addPointBase(points,windowid,nopopup);
    	
    },
    
    /**
     * 根据窗口的id 清除对应窗口地图图层的信息
     */
    clearLayerByWindowId:function(windowId) {
    	
    	// 得到 窗口 对应的所有的图层
    	var layers = this.map.getLayersByName(windowId+"_layer");
    	
    	if( layers == null ) return;
    	
    	var length = layers.length;
    	for(var i = 0; i < length ; i ++ ) {
    		layers[i].removeAllFeatures();
            this.map.removeLayer(layers[i]);
    	}
    },
    
    /**
     * 清空地图上所有的图层
     */
    clearAllLayers:function(){
    	
    	var len = gisui.windows.length;
    	for(var i = 0; i < len ; i ++ ) {
    		this.clearLayerByWindowId(gisui.windows[i].attribution.id);
    	}
    	
    	
    	this.clearLayerByWindowId("default");
    	
    },
    
   /**
    * 弹窗
    */
    addMyPopup : function(feature,ll,popup){
    	
    	  var html = getPopupHtml(popup);
    	  //var html= "<div class='datagrid-body' style='height:120px;overflow-y:auto;'><table class='datagrid-btable' cellspacing=0 cellpadding=0 style='width:100%'><tr  class='datagrid-row'><td style='width:110px;'><div style='height:auto;text-align:center' class='datagrid-cell'>你好</div></td><td><div style='height:auto;text-align:center' class='datagrid-cell'>我好afdasfsadfsadfasfdasfdasfdasdfasfsdafadsfasfdsafasasfsafadsfdsa</div></td></tr></table></div>";
    	
		  var popup = new OpenLayers.Popup.CSSFramedCloud("chicken", 
					    ll,
					    null,
					    "<div class='panel' style='width:290px;'>"+html+"</div>",
					    null, false, onPopupClose);
		   feature.popup = popup;
		   this.map.addPopup(popup);
		   
		   function onPopupClose(evt) {
	            // 'this' is the popup.
	            var feature = this.feature;
	            if (feature.layer) { // The feature is not destroyed
	                selectControl.unselect(feature);
	            } else { // After "moveend" or "refresh" events on POIs layer all
	                //     features have been destroyed by the Strategy.BBOX
	                this.destroy();
	            }
	        }
    },
    
    /**
     * i查询地图标线
     */
    addLine : function(lineData) {
        var lines = lineData.lines;
        var data = lineData.data;
        var type = lineData.type;
        var colors = lineData.color;
        var lineLayer = null;
        for ( var i = 0, j = 200; i < j; i++) {
        	if(lines[i]=="linestring("){
        		//
        	}else{
	            var line = (new OpenLayers.Format.WKT()).read(lines[i]).geometry;
	            line = line.transform(new OpenLayers.Projection("EPSG:4326"),
	                    new OpenLayers.Projection("EPSG:4326"));
	            //
	            var color = "";
	            if (typeof (colors) == "undefined" || typeof (colors) == undefined) {
	                color = "#990000";
	            } else {
	                color = colors[i];
	            }
	            // var styleMap = createStyle(color);
	            lineLayer = createLineFeature(color);
	
	            this.map.addLayer(lineLayer);
	
	            var feature = new OpenLayers.Feature.Vector(line);
	
	            if (data != null) {
	                var dataString = JSON.stringify(data[i]);
	                feature.attributes = dataString;
	            } else {
	                feature.attributes = null;
	            }
	            lineLayer.addFeatures(feature);  
	         //  alert("lines.length:"+lines.length);
	            if(lines.length == 1)
	        	   this.map.zoomToExtent(feature.geometry.bounds, false);
	           
	            var selectControl = new OpenLayers.Control.SelectFeature(lineLayer);
	            this.map.addControl(selectControl);
	            selectControl.activate();
	            if (typeof (selectControl.handlers) != "undefined") { // OL 2.7
	                selectControl.handlers.feature.stopDown = false;
	            } else if (typeof (selectControl.handler) != "undefined"){ // OL <
	                // 2.7
	                selectControl.handler.stopDown = false;
	                selectControl.handler.stopUp = false;
	            }
        	} 
        	//parent.showAndHideDiv('none');
        }
     
        function onSelect(evt) {
            feature = evt.feature;
            var data = JSON.parse(feature.attributes);
            var tempData = {
                data : data,
                type : type
            };
        
            if (feature.attributes != null) {
                    var htmlStr = getHtmlByData(tempData);
                    // var htmlStr = getFuWuQuHtml("");
                    var verticeArray = feature.geometry.getVertices()
                    var index = parseInt(verticeArray.length / 2)
                    var x = verticeArray[index].x;
                    var y = verticeArray[index].y;
                    var lonlat = new OpenLayers.LonLat(x, y);
                    this.popup = new OpenLayers.Popup.CSSFramedCloud(
                            "featurePopup", lonlat, new OpenLayers.Size(200,
                                    500), htmlStr, null, true, onPopupClose);
                    feature.popup = this.popup;
                    this.popup.feature = feature;
                    this.map.addPopup(this.popup, true);    
            }else{

            }
        };
        function unSelect(evt) {
             feature = evt.feature; 
             if (feature.popup) {
            	 this.popup.feature = null; 
            	 this.map.removePopup(feature.popup);
                 feature.popup.destroy(); 
                 feature.popup = null; 
             }            
        };
        function onPopupClose(evt) {
            // 'this' is the popup.
            this.destroy();
            var feature = this.feature;
            if (feature.layer) { // The feature is not destroyed
                selectControl.unselect(feature);
            } else { // After "moveend" or "refresh" events on POIs layer all
                // features have been destroyed by the Strategy.BBOX
                this.destroy();
            }
        };
        function createStyle(color) {
            // 地图标记点样式
            if (typeof (color) == "undefined" || typeof (color) == undefined) {
                color = "#ff00ff";
            }
            var styleMap = new OpenLayers.StyleMap({
                "default" : {
                    	strokeColor : color,
                        strokeWidth: 4,
                        strokeDashstyle: "solid",
                        attributes:"info"
                }
            });
            return styleMap;
        };

        function createLineFeature(color) {
            var styleMap = createStyle(color);
            var lineLayer = new OpenLayers.Layer.Vector("路线", {
                styleMap : styleMap,
            });
            lineLayer.events.on({
                'featureselected' : onSelect,
                'featureunselected' : unSelect
            });
            return lineLayer;
        }
    },
    
    /**
     * 清除线
     * */

    removeLine:function(){
        var LineLayer = this.map.getLayersByName("路线")[0];
        if (LineLayer != null) {
        	LineLayer.removeAllFeatures();
            this.map.removeLayer(LineLayer);
        }
    },
    /**
     * 标面
     * */
    addPolygon: function () {
        var polygon = {
            "type": "Polygon",
            "coordinates": [
                [
                    [117.43, 40.1],
                    [117.58, 40.20],
                    [1177.83, 40.3],
                    [117.86, 40.16],
                    [117.61, 41.96]
                ]
            ]
        };
        var featureCollection = {
            "type": "FeatureCollection",
            "features": [
                {"geometry": {
                    "type": "GeometryCollection",
                    "geometries": [
                        polygon
                    ]
                }}
            ]
        };
        var geojson_format = new OpenLayers.Format.GeoJSON();
        var polygonLayer = new OpenLayers.Layer.Vector("面");
        this.map.addLayer(polygonLayer);
        polygonLayer.addFeatures(geojson_format.read(featureCollection));

    },

    /**
     * 地图上画圆 传入点和半径
     * */

    addCircle:function(point,radius){
        // var  point = 'point(116.40124 39.92978)';
        //var point = new OpenLayers.Geometry.fromWKT(coordinate);
        var circlePoint =(new OpenLayers.Format.WKT()).read(point).geometry;

        var circleFeature = new OpenLayers.Feature.Vector(new OpenLayers.Geometry.Polygon.createRegularPolygon(
            circlePoint, radius, 360, 20), null, {
            fillOpacity: 0.5,
            fillColor: '#990000',
            strokeColor: '#990000',
            strokeOpacity: 1
        });
        var circleLayer = new OpenLayers.Layer.Vector("圆");
        circleLayer.addFeatures([circleFeature]);
        this.map.addLayer(circleLayer);
    },

    /**
     * 清除圆
     * */

    removeCircle:function(){
        var circleLayer = this.map.getLayersByName("圆")[0];
        if (circleLayer != null) {
            this.map.removeLayer(circleLayer);
        }
    },
    /**
     * 清除面
     * */
    removePolygon: function () {
        var PolygonLayer = this.map.getLayersByName("面")[0];
        if (PolygonLayer != null) {
            this.map.removeLayer(PolygonLayer);
        }
    },

    /**
     * 清除所有图层
     * */

    removeMarkLayer: function () {
        var layer = this.map.getLayersByName("point")[0];
        if (layer != null) {
            this.map.removeLayer(layer);
        }
        
        //遍历移除
        /*var layerPoints = this.map.getLayersByName("point");
        for(var i = 0; i<layerPoints.length;i++){
        	var layer = layerPoints[i];
        	if (layer != null) {
                this.map.removeLayer(layer);
            }
        }*/
        
        var layerPoint = this.map.getLayersByName("单点")[0];
        if (layerPoint != null) {
            this.map.removeLayer(layerPoint);
        }
        var PolygonLayer = this.map.getLayersByName("面")[0];
        if (PolygonLayer != null) {
            this.map.removeLayer(PolygonLayer);
        }
        var LineLayer = this.map.getLayersByName("路线")[0];
        if (LineLayer != null) {
            this.map.removeLayer(LineLayer);
        }
        
      //遍历移除
        /*var LineLayer = this.map.getLayersByName("路线");
        for(var i = 0; i<LineLayer.length;i++){
        	var layer = LineLayer[i];
        	if (layer != null) {
                this.map.removeLayer(layer);
            }
        }*/
        
        var circleLayer = this.map.getLayersByName("圆")[0];
        if (circleLayer != null) {
            this.map.removeLayer(circleLayer);
        }
        var markerLayer = this.map.getLayersByName("Markers")[0];
        if (layer != null) {
            this.map.removeLayer(markerLayer);
        }
        var startPoint = this.map.getLayersByName("startPoint")[0];
        if (startPoint != null) {
           this.map.removeLayer(startPoint);
        }
        var endPoint = this.map.getLayersByName("endPoint")[0];
        if (endPoint != null) {
            this.map.removeLayer(endPoint);
        }
        var markerLayer = this.map.getLayersByName("Markers")[0];
        if (markerLayer != null) {
            this.map.removeLayer(markerLayer);
        }
    },

    /**
     * 清除点
     * */

    removePoint: function () {
        var layer = this.map.getLayersByName("point")[0];
        if (layer != null) {
            this.map.removeLayer(layer);
        }
        var layerPoint = this.map.getLayersByName("Points")[0];
        if (layerPoint != null) {
            this.map.removeLayer(layerPoint);
        }
    },

    /**
     * 放大
     * */

    zoomIn: function () {
        this.map.zoomIn();
    },

    /**
     * 缩小
     **/

    zoomOut: function () {
        this.map.zoomOut();
    },
    
    /**
     * 获取当前地图缩放级数
     * 
     * @returns {*}
     */
    getZoom : function() {
        var num = this.map.getZoom();
        //console.log(num);
        return num;
    },
    /**
     * 拉宽并获取经纬度坐标系
     * */

    boxExtend: function () {
        var controlBox = new OpenLayers.Control();
        OpenLayers.Util.extend(controlBox, {
            draw: function () {
                this.box = new OpenLayers.Handler.Box(controlBox,
                    {"done": this.notice}, { "persist": true},
                    {keyMask: OpenLayers.Handler.MOD_SHIFT });
                this.box.activate();
            },

            notice: function (bounds) {
                var ll = this.map.getLonLatFromPixel(new OpenLayers.Pixel(bounds.left, bounds.bottom));
                var ur = this.map.getLonLatFromPixel(new OpenLayers.Pixel(bounds.right, bounds.top));
                alert(ll.lon.toFixed(4) + ", " +
                    ll.lat.toFixed(4) + ", " +
                    ur.lon.toFixed(4) + ", " +
                    ur.lat.toFixed(4));
            }
        });
        this.map.addControl(controlBox);
    },


    /**
     * 点居中并闪烁
     * */
    centerAt: function (isBlink) {


        var time1, time2;

        function hide() {
            this.map.pointLayer.setVisibility(false);
        }

        function show() {
            this.map.pointLayer.setVisibility(true);
        }

        this.map.setCenter(new OpenLayers.LonLat(107.4833233, 26.23578279), 2);
        if (isBlink) {
            time1 = setTimeout(hide, 500);
            time2 = setTimeout(show, 1000);
        }
    },
    /**
     * 标单点
     * */
    addSinglePoint: function (x, y, html, image, zoom) {

        var popup,pointLayer;

        // 地图标记点样式
        var styleMap = new OpenLayers.StyleMap({
            "default": {
                fillOpacity: 1,
                hoverFillOpacity: 1,
                hoverFillColor: "",
                strokeOpacity: 1,
                strokeColor: "#ee9900",
                graphicWidth: 30,
                graphicHeight: 30,
                externalGraphic: image
            }
        });

        var point = new OpenLayers.Geometry.Point(x, y);
        var feature = new OpenLayers.Feature.Vector(point);
        pointLayer = new OpenLayers.Layer.Vector("单点", {
            eventListeners:{
                featureover: onFeatureSelect,

                featureout: onFeatureUnselect,
                featureclick:clickTest

            },
            styleMap: styleMap});

        pointLayer.addFeatures(feature);
        if(pointLayer != null){
            pointLayer.removeMap();
        }
        this.map.addLayer(pointLayer);
        //点缩放至某一级显示在中心
        var lonLat = new OpenLayers.LonLat(x, y);
        this.map.setCenter(lonLat, zoom);

        /*// create the layer with listeners to create and destroy popups
         var selectControl = new OpenLayers.Control.SelectFeature(pointLayer);
         this.map.addControl(selectControl);
         selectControl.activate();
         *//* pointLayer.events.on({
         'featureselected':onFeatureSelect,
         'featureunselected': onFeatureUnselect
         });
         *//*

         if (typeof(selectControl.handlers) != "undefined") { // OL 2.7
         selectControl.handlers.feature.stopDown = false;
         } else if (typeof(selectControl.handler) != "undefined") { // OL < 2.7
         selectControl.handler.stopDown = false;
         selectControl.handler.stopUp = false;
         }*/

        function onFeatureSelect(evt) {
            feature = evt.feature;
            popup = new OpenLayers.Popup.CSSFramedCloud("featurePopup",
                feature.geometry.getBounds().getCenterLonLat(),
                new OpenLayers.Size(100, 100),

                html,
                null, true, onPopupClose);

            feature.popup = popup;
            popup.feature = feature;
            this.map.addPopup(popup, true);
        }

        function onFeatureUnselect(evt) {
            feature = evt.feature;
            if (feature.popup) {
                popup.feature = null;
                this.map.removePopup(feature.popup);
                feature.popup.destroy();
                feature.popup = null;
            }
        }
        function clickTest(evt){
            feature = evt.feature;
            if (feature.popup) {
                popup.feature = null;
                this.map.removePopup(feature.popup);
                feature.popup.destroy();
                feature.popup = null;
            }

        }

        function onPopupClose(evt) {
            // 'this' is the popup.
            var feature = this.feature;
            if (feature.layer) { // The feature is not destroyed
                selectControl.unselect(feature);
            } else { // After "moveend" or "refresh" events on POIs layer all
                //     features have been destroyed by the Strategy.BBOX
                this.destroy();
            }
            this.destroy();
        }

    },
    /**
     * 缩放至
     * */
    panTo:function(x,y,zoom){
        var lonlat = new OpenLayers.LonLat(x,y);
        this.map.panTo(lonlat);
        this.map.setCenter(lonlat,zoom);
    },
    /**
     * 缩放至
     * */
    zoomTo: function (lon, lat, zoom) {
        var lonLat = new OpenLayers.LonLat(lon, lat);
        this.map.setCenter(lonLat, zoom);
    },
    setStart:function(OPX){
        var startPoint = this.map.getLayersByName("startPoint")[0];
        if (startPoint != null) {
            this.map.removeLayer(startPoint);
        }
        var styleMap = new OpenLayers.StyleMap({
            "default": {
                graphicWidth: 32,
                graphicHeight: 32,
                externalGraphic: "map/img/起.png"
            }
        });
        this.startLonlat = this.map.getLonLatFromLayerPx(OPX);

        var point = (new OpenLayers.Format.WKT()).read("point(" + this.startLonlat.lon + " " + this.startLonlat.lat + ")").geometry;
        point = point.transform(new OpenLayers.Projection("EPSG:4326"), new OpenLayers.Projection("EPSG:4326"));
        var vector = new OpenLayers.Layer.Vector("startPoint", {
            styleMap: styleMap
        });
        var feature = new OpenLayers.Feature.Vector(point);
        vector.addFeatures(feature);
        this.map.addLayer(vector);


    },
    setEnd:function(OPX){
        console.log(this.startLonlat);
        var endPoint = this.map.getLayersByName("endPoint")[0];
        if (endPoint != null) {
            this.map.removeLayer(endPoint);
        }
        var styleMap = new OpenLayers.StyleMap({
            "default": {
                graphicWidth: 32,
                graphicHeight: 32,
                externalGraphic: "map/img/终.png"
            }
        });
        var lonlat = this.map.getLonLatFromLayerPx(OPX);
        
        var point = (new OpenLayers.Format.WKT()).read("point(" + lonlat.lon + " " + lonlat.lat + ")").geometry;
        point = point.transform(new OpenLayers.Projection("EPSG:4326"), new OpenLayers.Projection("EPSG:4326"));
        var vector = new OpenLayers.Layer.Vector("endPoint", {
            styleMap: styleMap
        });
        var feature = new OpenLayers.Feature.Vector(point);
        vector.addFeatures(feature);
        this.map.addLayer(vector);
        //this.addLine(lines);
    },
    addMarker:function(OPX){
       var markerLayer = this.map.getLayersByName("Markers")[0];
        if (markerLayer != null) {
            this.map.removeLayer(markerLayer);
        }
        var markers = new OpenLayers.Layer.Markers("Markers");
        this.map.addLayer(markers);
        var size = new OpenLayers.Size(28, 28);
        var offset = new OpenLayers.Pixel(-(size.w / 2), -size.h);
        var icon = new OpenLayers.Icon("map/img/marker.png", size, offset);
        var lonlat = this.map.getLonLatFromLayerPx(OPX);
        markers.addMarker(new OpenLayers.Marker(lonlat, icon)); 
    },
    
    CLASS_NAME: HdMap
}

function mapclick(e) {
    var position = this.map.events.getMousePosition(e);
    var ll = this.map.getLonLatFromPixel(new OpenLayers.Pixel(position.x,
            position.y));
    var level = this.map.getZoom();
    iLineCx(ll.lon, ll.lat, level);
}

function mapclickZh(e) {
    var position = this.map.events.getMousePosition(e);
    var ll = this.map.getLonLatFromPixel(new OpenLayers.Pixel(position.x,
            position.y));
    var level = this.map.getZoom();
    iZhCx(ll.lon, ll.lat, level);
}

function mapclickPoint(e) {
    var position = this.map.events.getMousePosition(e);
    var ll = this.map.getLonLatFromPixel(new OpenLayers.Pixel(position.x,
            position.y));
    var level = this.map.getZoom();
    var resolution=this.map.getResolution();
    iPointCx(ll.lon, ll.lat, level,resolution);
}

function mapTuli(){
	var shhi=document.getElementById("mapTuli").style.display;
	if(shhi==""){
		document.getElementById("mapTuli").style.display="none";
	}else{
		document.getElementById("mapTuli").style.display="";
	}
}
/**
 * {
 * 		columns:	easyui 表头 二维数组
 * 		rowData:	easyui 中一行的数据
 * 		title:		title
 * 		buttons:	自定义按钮
 * }
 * @param popup
 */
function getPopupHtml(popup){
	
	if(typeof popup == "string") {
		return popup;
	}
	
	var html = "<div class='panel-header2 window-header'><div class='panel-title'>"+popup.title+"</div></div>";   // title
	
	 html += "<div class='datagrid-body' style='height:120px;overflow-y:auto;'>";				    // 属性列表
	 
	 if(popup.columns.length == 1){
		 html+= "<table class='datagrid-btable' style='width:100%;' cellspacing=0 cellpadding=0>";
		 for( var i = 0; i < popup.columns[0].length; i++) {
			 if(popup.columns[0][i].field && popup.columns[0][i].title && popup.columns[0][i].title != "操作") {
				 var newStr = "";
				 	var newFieldStr = "";
				 	var oldStr = popup.rowData[popup.columns[0][i].field];
				 	var oldFieldStr = popup.columns[0][i].title;
				 	
				 	if( popup.columns[0][i].formatter ) {
				 		oldStr = popup.columns[0][i].formatter(oldStr,popup.rowData);
				 	}
				 	
				 	if(oldStr == null) {
				 		oldStr = "";
				 	}
				 	
				 	newStr = oldStr;
				 	newFieldStr = oldFieldStr;
				 	if( oldStr.length >=13 ) {
				 		oldStr = oldStr.substring(0,13) + "...";
				 	}
				 	
				 	if( oldFieldStr.length >= 5 ) {
				 		oldFieldStr = oldFieldStr.substring(0,5) +"...";
				 	}
				 	
				 	html += "<tr class='datagrid-row'>";
					html += "<td style='width:110px;'><div title='"+newFieldStr+"' style='height:auto;text-align:center' class='datagrid-cell'>" + oldFieldStr + "</div></td><td style='width:195px;'><div style='height:auto;text-align:center' title="+newStr+" class='datagrid-cell'>"+oldStr+"</div></td>";
				 	html += "</tr>";
			 }
		 }
		html +="</table>";
	 }else if(popup.columns.length > 1){
		 console.log(popup);
		 
		 html+= "<table class='datagrid-btable' style='width:100%;' cellspacing=0 cellpadding=0>";
		 for(var j=0 ; j < 2 ; j++){
			 for( var i = 0; i < popup.columns[j].length; i++) {
				 if(popup.columns[j][i].kid && popup.columns[j][i].title && popup.columns[j][i].title != "操作") {
					var newStr = "";
					var newFieldStr = "";
					var oldStr = popup.rowData[popup.columns[j][i].kid];
					var oldFieldStr = popup.columns[j][i].title;
					
					if( popup.columns[j][i].formatter ) {
						oldStr = popup.columns[j][i].formatter(oldStr,popup.rowData);
					}
					
					if(oldStr == null) {
						oldStr = "";
					}
					
					newStr = oldStr;
					newFieldStr = oldFieldStr;
					if( oldStr.length >=13 ) {
						oldStr = oldStr.substring(0,13) + "...";
					}
					
					if( oldFieldStr.length >= 5 ) {
						oldFieldStr = oldFieldStr.substring(0,5) +"...";
					}
					
					html += "<tr class='datagrid-row'>";
					html += "<td style='width:110px;'><div title='"+newFieldStr+"' style='height:auto;text-align:center' class='datagrid-cell'>" + oldFieldStr + "</div></td><td style='width:195px;'><div style='height:auto;text-align:center' title="+newStr+" class='datagrid-cell'>"+oldStr+"</div></td>";
					html += "</tr>";
				 }
			 }
		 }
		html +="</table>";
	 }else{
		 html += "表头是复合的， 您需要完善getPopupHtml() 方法";
	 }
	
	 html += "</div>";
	 
	 if( popup.buttons != undefined) {
		 html += "<div class='buttonsContainer'>";
		 
		 for(var i = 0 ; i < popup.buttons.length ; i ++ ) {
			 
			 var attributes = "";
			if(popup.buttons[i].attr) {
				for (var ab in  popup.buttons[i].attr ) {
					if( popup.buttons[i].attr[ab] != undefined && popup.buttons[i].attr[ab] != '') {
						attributes += ab + " = " + popup.buttons[i].attr[ab] + " ";
					}
				}
			}
			
			if( typeof popup.buttons[i].eventHandler == "function") {
				html += '<a href="#" '+attributes+' onClick=\"('+popup.buttons[i].eventHandler+')(this)\"  class="easyui-linkbutton l-btn l-btn-plain" data-options="plain:true" id=""><span class="l-btn-left"><span class="l-btn-text">'+popup.buttons[i].text+'</span></span></a>';
			}else{
				html += '<a href="#" '+attributes+' onClick='+popup.buttons[i].eventHandler+'  class="easyui-linkbutton l-btn l-btn-plain" data-options="plain:true" id=""><span class="l-btn-left"><span class="l-btn-text">'+popup.buttons[i].text+'</span></span></a>';
			}
			
			
		 }
		 
		 html +="</div>";
	 }
//	console.log(html);
	return html;
}
