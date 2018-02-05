<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="com.hdsx.hmglyh.util.MD5Util"%>
<%@ include file="../public/head.jsp"%>
 <link href="${pageContext.request.contextPath}/css/uploadify.css" rel="stylesheet" type="text/css" />
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.uploadify.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/js/validation.js"></script>
 <script type="text/javascript" src="${pageContext.request.contextPath}/page/rcyh/js/fileUtil.js"></script>
<title></title>
</head>
<body>
	<form id="fm" action="<s:if test="add">${pageContext.request.contextPath}/rcyh/bhflow_saveBh.do</s:if><s:if test="update">${pageContext.request.contextPath}/rcyh/bh_saveUpdateBh.do</s:if>" 
		method="post">
		<div class="datagrid-body">
			<input type="hidden" name="bhjl.xcid" value="<s:property value="bhjl.xcid" />" />
			<input type="hidden" name="bhjl.bhjlid" value="<s:property value="bhjl.bhjlid" />" />
			<input type="hidden" name="bhjl.pgzt" value="0" />
			<input type="hidden" name="bhjl.bhwxzt" value="0" />
			<input type="hidden" name="fromXd" value="<s:property value="fromXd" />" />	
			<input type="hidden" name="fromPg" value="<s:property value="fromPg" />" />	
			<input type="hidden" name="fromSb" value="<s:property value="fromSb" />" />	
			
			<table class="form_table datagrid-btable" cellpadding=0 cellspacing=0 >
				<tr class="datagrid-row">
					<td style="width: 30px; text-align: center;">序号</td>
					<td style="width: 130px; text-align: center;">起点桩号</td>
					<td style="width: 130px; text-align: center;">止点桩号</td>
					<td style="width: 30px; text-align: center;">数量</td>
					<td style="width: 130px; text-align: center;">病害类型</td>
					<td style="width: 150px; text-align: center;">现场处置情况</td>
					<td style="width: 80px; text-align: center;">是否需要上报</td>
				</tr>
				<tr class="datagrid-row">
					
				</tr>	
			</table>
		</div>
	</form>
	<s:if test="add">
		<center style="margin-top:5px;">
			<a class="easyui-linkbutton" data-options="plain:true" onclick="$('#fm').submit()">保存</a>
			<a class="easyui-linkbutton" data-options="plain:true" onclick="history.back()">返回</a>
		</center>
    </s:if>
	<s:if test="update">
		<center style="margin-top:5px;">
			<a class="easyui-linkbutton" data-options="plain:true" onclick="$('#fm').submit()">更新</a>
			<a class="easyui-linkbutton" data-options="plain:true" onclick="history.back()">返回</a>
		</center>
    </s:if>

	<script>	
    <s:if test="show" >
		$("input").attr("readonly","readonly");
	</s:if>
	
	
	function getQshCombobox(){
		var bhid = $("#bhlxtree").combotree("getValue");
	 	if(bhid.match('^04') == '04' 
		|| bhid.match('^05') == '05'
		|| bhid.match('^06') == '06'
		){
	 		var ldcode = $('#ldCombobox').combobox('getValue');
			var szhh0 = $('#szhh0').val();
			var szhh1 = $('#szhh1').val();
			
			if(ldcode == null || ldcode == '') {
				return;
			}
			
			if(szhh0 == null || szhh0 == '' ){
				return;
			}
			
			if(szhh1 == null || szhh1 == '' ){
				return;
			} 
			
			if(bhid.match("^04") == 04 ) {
			//	$('.qlCombobox').combobox('reload',
			//	'/hmglyh/gis/gouzaowu_qlCombobox100.do?ql.roadcode='+ldcode+'&ql.pos='+(parseInt(szhh0) + parseInt(szhh1) / 1000));
				$.post('/hmglyh/gis/gouzaowu_qlCombobox100.do?ql.roadcode='+ldcode+'&ql.pos='+(parseInt(szhh0) + parseInt(szhh1) / 1000),function(data){
					if(data.length > 0 ) {
						$(".qlCombobox").combobox("loadData",data);
					}else{
						$(".qlCombobox").combobox("clear");
						$(".qlCombobox").combobox("loadData",[]);
					}
				},"json");
			}
			
			if(bhid.match("^05") == 05 ) {
			 //	$('.sdCombobox').combobox('reload',
			 //	'/hmglyh/gis/gouzaowu_sdCombobox100.do?sd.roadcode='+ldcode+'&sd.pos='+(parseInt(szhh0) + parseInt(szhh1) / 1000));
				$.post('/hmglyh/gis/gouzaowu_sdCombobox100.do?sd.roadcode='+ldcode+'&sd.pos='+(parseInt(szhh0) + parseInt(szhh1) / 1000),function(data){
					if(data.length > 0 ) {
						$(".sdCombobox").combobox("loadData",data);
					}else{
						$(".sdCombobox").combobox("clear");
						$(".sdCombobox").combobox("loadData",[]);
					}
				},"json");
			}
			
			if(bhid.match("^06") == 06 ) {
				//	$('.hdCombobox').combobox('reload',
				// '/hmglyh/gis/gouzaowu_hdCombobox100.do?hd.roadcode='+ldcode+'&hd.pos='+(parseInt(szhh0) + parseInt(szhh1) / 1000));
				$.post('/hmglyh/gis/gouzaowu_hdCombobox100.do?hd.roadcode='+ldcode+'&hd.pos='+(parseInt(szhh0) + parseInt(szhh1) / 1000),function(data){
					if(data.length > 0 ) {
						$(".hdCombobox").combobox("loadData",data);
					}else{
						$(".hdCombobox").combobox("clear");
						$(".hdCombobox").combobox("loadData",[]);
					}
				},"json");
			}
		} 
	}
	
    $(function() {
		      var i = 0;
		      $('#file_upload').uploadify({
		          'formData'     : {
		              'timestamp' : '<%=new Date().getTime()%>',
		              'token'     : '<%=MD5Util.MD5(new Date().getTime()+"")%>',
		          },
		          'width':100,
		          'height':20,
		          'buttonText' : '选择上传图片',
		          'fileTypeDesc':'请选择 jgp,jpeg,gif,png 格式的图片', // 貌似不好用
		          'debug':false,
		          'swf'      : '${pageContext.request.contextPath}/uploadify.swf',
		          'uploader' : '${pageContext.request.contextPath}/up',
		          'fileSizeLimit':'5mb',
		          'fileTypeExts':'*.jpeg;*.jpg; *.png;*.gif',
		          'onUploadSuccess':function(file,strData){
		              var jsonData = eval("(" + strData + ")");
		              $("#myfile-"+file.id).val(jsonData.rname);
		              $("#"+file.id + "-pic").css("color","blue"); 
		              $("#"+file.id + "-del").attr("zpdz",jsonData.rname); 
		              $("#"+file.id + "-del").attr("succ","1"); 
		              $("#"+file.id + "-del").css("color","blue"); 
		              $("#"+file.id+"-del").html("删除");
		              $("#"+file.id + "-pic").attr("href",jsonData.picUrl+"/"+jsonData.rname);
		              $("#"+file.id+"-queue").html("<span style='color:green;'>成功</span>");
		          
		          },
		          'onUploadStart':function(file) {
		              var html = "<tr class='datagrid-row'>"+
		              "<td style='width:120px;'>"+
		                  "<div style='text-align:center' class='datagrid-cell'>"+
		                      "<input style='text-align:center'  readonly='readonly' type='text' name='bhjl.zps["+i+"].zpmc' value="+file.name + "></input>" +  
		                      "<input id='myfile-"+file.id+"' type='hidden' name='bhjl.zps["+i+"].zpdz' value=''>"+
		                  "</div>"+
		              "</td>" +
		              "<td style='width:80px;'>"+
		                  "<div style='text-align:center' class='datagrid-cell'>"+
		                  		"修复前"+
		                  		"<input type='hidden' type='text' name='bhjl.zps["+i+"].ryid' value='0'>"+
		                  "</div>"+
	              	  "</td>"+
		              "<td style='width:80px;'>"+
		                  "<div style='text-align:center' class='datagrid-cell'>"+
		                  "<input type='text' readonly='readonly' name='bhjl.zps["+i+"].zpdx' value='" +((file.size / 1204 / 1024) .toFixed(2) )+"MB'>"+
		                  "</div>"+
		              "</td>"+
		              "<td style='width:100px'>"+
		                  "<div style='text-align:center' class='datagrid-cell'>"+
		                      "<a  id='"+file.id+"-del' zpdz='0' fid='"+file.id+"' succ='0' href='javascript:void(0);'  style='color:#f00' onclick=delZpRow(this)>取消上传</a>"+
		                      "|<a id='"+file.id+"-pic' href='javascript:void(0)' style='color:#ccc' target='blank' >查看</a>"+
		                  "</div>"+
		              "</td>"+
		              "<td style='width:80px;'>"+
		                  "<div id='"+file.id+"-queue' style='text-align:center' class='datagrid-cell'>"+
		                  "</div>"+
		              "</td>"+
		              "<td style='width:150px;'>"+
		             //     "<div style='text-align:center' class='datagrid-cell'>"+
		                	  "<input type='text' name='bhjl.zps["+i+"].zpms' value=''>"+
		              //    "</div>"+
		              "</td>"+
		              "</tr>";
		              $("#picTable").append(html);
		              i++;
		          },
		          'onUploadProgress' : function(file, bytesUploaded, bytesTotal, totalBytesUploaded, totalBytesTotal) {
		              bytesTotal = Math.round(bytesTotal / 1024);
		              bytesUploaded = Math.round(bytesUploaded / 1024);
		              var suffixTotal   = 'KB';
		              var suffixUploaded   = 'KB';
		              if (bytesTotal > 1000) {
		                  bytesTotal = Math.round(bytesTotal / 1000);
		                  suffixTotal   = 'MB';
		              }
		              if (bytesUploaded > 1000) {
		                  bytesUploaded = Math.round(bytesUploaded / 1000);
		                  suffixUploaded   = 'MB';
		              }
		              
		              bytesTotal = parseInt(bytesTotal);
		              bytesUploaded = parseInt(bytesUploaded);
		              
		              $('#'+file.id + '-queue').html(bytesUploaded + suffixUploaded + ' / ' + bytesTotal + suffixTotal);
		          },
		          'onUploadError' : function(file, errorCode, errorMsg, errorString) {
		              $('#'+file.id + '-queue').html("<span style='color:red'>上传失败</span>");
		          }
		      });
		  });
    	
	      function delZpRow(obj){
		        var succ = $(obj).attr("succ");
		        var fileid = $(obj).attr("fid");
		        var zpdz = $(obj).attr("zpdz");
		        if(succ == "0" ) {  // 1  如果是正在上传 之中 现在 要 取消上传 
		            $('#file_upload').uploadify("cancel",fileid);
		            //$("#"+fileid+"-queue").html("<span style='color:green;'>已取消</span>");
		            setTimeout(function(){
		               $(obj).parentsUntil('.datagrid-row').parent().remove();
		         },2000);
		        }else if(succ == "1" ){     // 2  如果已经上传成功 要将 服务已经上传的图片删除
		            if( zpdz == "0" ) return;
		            $.ajax({
		                url:"/hmglyh/rcyh/bh_delPic.do",
		                dataType:"json",
		                data:{
		                    "zp.zpdz":zpdz
		                },
		                success:function(data){
		                    $("#"+fileid+"-queue").html("<span style='color:green;'>删除成功</span>");
		                    setTimeout(function(){
		                          $(obj).parentsUntil('.datagrid-row').parent().remove();
		                    },2000);
		                },
		                error:function(){
		                    $("#"+fileid+"-queue").html("<span style='color:red;'>删除失败</span>");
		                }
		            });

		        }
	    }    
    
    </script>
</body>
</html>
