<?xml version="1.0" encoding="UTF-8" ?> 
<%@ page language="java" contentType="text/html; charset=UTF-8" 
    pageEncoding="UTF-8"%> 
<%@ include file="../public/head.jsp"%> 
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/button.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/easyui/themes/icon.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/YMLib.js"></script> 
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath }/page/rcyh/js/wxzg.js"></script> 
</head> 
<body class="easyui-layout" fit="true" style="visibility: hidden;"> 
 
    <div data-options="region:'center',border:false,title:'当前位置：&nbsp;日常养护管理系统&nbsp;>&nbsp;维修整改',iconCls:'titleimage'" style="padding:0px"> 


        <form> 
 

            <input id="bmcode" value="<s:property value='user.bmcode' />" type="hidden"> 
 

        </form> 
 

        <div id="ma"  class="easyui-tabs" fit="true" border="false"> 
 

            <div title="发送整改通知" border="false" style="padding:0px"> 
 

                <div class="easyui-layout" fit="true" border="false"> 
 

                    <div id="tb1" data-options="region:'north',split:true"  border="false" style="height:45px;padding:4px 0px 0px 15px;border-bottom:1px solid #95b8e7"> 
 

                        <table> 
 

                            <tr> 
 

                                <!-- <td><input id="addWxzgtzd" type="button" value="添加" /></td> -->
                                <td>&nbsp;&nbsp;<a href="javascript:void(0)" class="easyui-linkbutton" plain="true" id="addWxzgtzd">添加</a></td> 
 

                            </tr> 
 

                        </table> 
 

                    </div> 
 

                    <div border="false" data-options="region:'center'" style="border-top:0px"> 
 

                        <table class="easyui-datagrid" 
 

                            data-options=" 
 

                                url:'${pageContext.request.contextPath}/rcyh/wxzg_queryAllOfTzd.do', 
 

                                queryParams:{ 
 

                                    tbbmcode : '<s:property value='user.bmcode' />' 
 

                                }, 
 

                                columns:[datagridFieldstzd], 
 

                                pageNumber : 1, 
 

                                pageSize : 15, 
 

                                pageList : [ 15, 25, 35 ], 
 

                                rownumbers : true, 
 

                                pagination : true, 
 

                                fit:true 
 

                            " 
 

                         id="zgtzdGrid"></table> 
 

                    </div> 
 

                </div> 
 

            </div> 
 

            <div title="接收整改通知" border="false" style="padding:0px;border-buttom:0px;"> 
 

                <div class="easyui-layout" fit="true" border="false"> 
 

                    <div border="false" data-options="region:'center'" style="border-top:0px"> 
 

                        <!-- <table id="zghfdGrid"></table> --> 
 

                        <table class="easyui-datagrid" 
 

                            data-options=" 
 

                                url:'${pageContext.request.contextPath}/rcyh/wxzg_queryAllOfHfd.do', 
 

                                queryParams:{ 
 

                                    sbbmcode : '<s:property value='user.bmcode' />' 
 

                                }, 
 

                                columns:[datagridFieldshfd], 
 

                                pageNumber : 1, 
 

                                pageSize : 15, 
 

                                pageList : [ 15, 25, 35 ], 
 

                                rownumbers : true, 
 

                                pagination : true, 
 

                                fit:true 
 

                            " 
 

                         id="zghfdGrid"></table> 
 

                    </div> 
 

                </div> 
 

            </div> 
 

        </div> 
 

    </div> 
 

</body> 
 

</html> 
