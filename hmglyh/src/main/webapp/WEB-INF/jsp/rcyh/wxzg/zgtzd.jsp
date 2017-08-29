<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%> 
<%@ include file="../public/head.jsp"%> 
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/YMLib.js"></script> 
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/js/ValidatePlus.js"></script> 
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath }/page/rcyh/js/zgtzd.js"></script> 
</head> 
<body> 
<div class="easyui-layout" data-options="fit:true"> 
    <div data-options="region:'south',border:false" style="height:30px;padding-top:0px;text-align: center;"> 
        <s:if test="add"> 
            <input id="btnSave" type="button" value="确定" /> 
        </s:if> 
        <input id="close" type="button" value="取消" onclick="parent.$('#add,#edit,#view').window('close')"/> 
        <form> 
            <input id="action" value="<s:property value='add' />" type="hidden"> 
            <input id="viewAction" value="<s:property value='view' />" type="hidden"> 
            <input id="loginUsername" value="<s:property value='user.username' />" type="hidden"> 
        </form> 
    </div> 
    <div data-options="region:'center',border:false" style="padding-top:10px;height:100%;overflow-y:scroll;" >
        <form id="form">
            <table border="0"  cellspacing="0" cellpadding="0" align="center" width="90%"> 
                <tr> 
                    <th colspan="3" style="text-align:center; border-right: 0px; border-left: 0px; border-top: 0px; border-bottom: 0px;font-size:22px" >日常养护作业检查整改通知单</th> 
                </tr> 
                <tr> 
                    <td style="border-style:none" colspan="2" > 
                            <s:if test="add"> 
                                填表单位:<input id="tbbmname" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px" readonly="readonly" value="<s:property value='user.bmname' />" /> 
                                <input id="tbbmcode" name="tbbmcode" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px;display:none " readonly="readonly" value="<s:property value='user.bmcode' />" /> 
                            </s:if> 
                            <s:if test="view"> 
                                填表单位:<input id="tbbmname" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px" readonly="readonly" value="<s:property value='model.tbbmname' />" /> 
                            </s:if> 
                        <%-- 填表单位:<input id="tbbmname" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px" readonly="readonly" value="<s:property value='user.bmname' />" /> 
                        <input id="tbbmcode" name="tbbmcode" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px;display:none " readonly="readonly" /> --%> 
                    </td> 
                    <td style="text-align:right;border-style:none" >表 6-11</td> 
                </tr> 
                <tr> 
                    <td style="border-right: 0px; border-left: black 1px solid; border-top: black 1px solid; border-bottom: 0px;" ></td> 
                    <td style="border-right: 0px; border-left: 0px; border-top: black 1px solid; border-bottom: 0px;" ></td> 
                    <td style="text-align:right; border-right: black 1px solid; border-left: black 1px solid; border-top: black 1px solid; border-bottom: black 1px solid;" > 
                        通知单序列号： 
                       <s:if test="add"> 
                            <input id="tzdxlj" name="tzdxlj" class="easyui-validatebox" maxlength="30" data-options="required:true" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px" /> 
                        </s:if> 
                        <s:if test="view"> 
                            <input style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px" readonly="readonly" value="<s:property value='model.tzdxlj' />" /> 
                        </s:if> 
                    </td> 
                </tr> 
                <tr> 
                    <td colspan="3" style="border-right: black 1px solid; border-left: black 1px solid; border-top: 0px; border-bottom: 0px;"  > 
                        &nbsp;致： 
                       <br/> 
                        <s:if test="add"> 
                            <span id="dataToAdd" > 
                                &nbsp;&nbsp;&nbsp;&nbsp;经巡查、检查发现你单位 
                               <select class="easyui-combotree" name="sbbmcode" id="chooseBmcode" style="width:150px" 
                                    data-options=" 
                                        url:'${pageContext.request.contextPath}/htglbm/createDapartTree.do?bmcode=<s:property value='user.bmcode' />', 
                                        panelHeight : 170, 
                                        <!-- value : <s:property value='user.bmcode' />, --> 
                                        onSelect : function(record){ 
                                            sbbmcode = record.id; 
                                        } 
                                    " 
                                ></select> 
                                在 
                               <input id="wz" name="wz" class="easyui-validatebox" maxlength="100" data-options="required:true" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px" value="（某路线 Kxxx）" /> 
                                等处，从事的养护作业存在以下问题，请务必（ 
                               <span> 
                                    <input id="r1" type="radio" name="yq" style="border:none" value="尽快" checked /><label for="r1">尽快</label> 
                                    <input id="r2" type="radio" name="yq" style="border:none" value="立即" /><label for="r2">立即</label> 
                                </span> 
                                ）按本单要求进行整改，并于 
                                   <input id="sxtime" name="sxtime" class="easyui-datebox" data-options="required:true" style="width:120px" /> 
                                日前报送整改结果，特此通知。 
                           </span> 
                        </s:if> 
                        <!-- <span id="dataToAdd" > 
                            &nbsp;&nbsp;&nbsp;&nbsp;经巡查、检查发现你单位 
                           <select class="easyui-combotree" name="sbbmcode" id="chooseBmcode" style="width:150px"></select> 
                            在 
                           <input id="wz" name="wz" class="easyui-validatebox" maxlength="100" data-options="required:true" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px" value="（某路线 Kxxx）" /> 
                            等处，从事的养护作业存在以下问题，请务必（ 
                           <span> 
                                <input id="r1" type="radio" name="yq" style="border:none" value="尽快" checked /><label for="r1">尽快</label> 
                                <input id="r2" type="radio" name="yq" style="border:none" value="立即" /><label for="r2">立即</label> 
                            </span> 
                            ）按本单要求进行整改，并于 
                               <input id="sxtime" name="sxtime" class="easyui-datebox" data-options="required:true" style="width:120px" /> 
                            日前报送整改结果，特此通知。 
                       </span> --> 
                        <s:if test="view"> 
                            &nbsp;&nbsp;&nbsp;&nbsp; 
                            <span>经巡查、检查发现你单位 <s:property value='model.sbbmname' /> 在 <s:property value='model.wz' /> 等处，从事的养护作业存在以下问题，请务必 <s:property value='model.yq' /> 按本单要求进行整改，并于 <s:property value='model.sxtimeStr' /> 前报送整改结果，特此通知。</span> 
                        </s:if> 
                        <!-- <p id="dataToView" style="text-indent:2em;display:none" ></p> --> 
                    </td> 
                </tr> 
                <tr> 
                    <td colspan="3" style="text-align:right; border-right: black 1px solid; border-left: black 1px solid; border-top: 0px; border-bottom: 0px;" > 
                        <s:if test="add"> 
                            <p>检查人：<input id="tbrxm" name="tbrxm" class="easyui-validatebox" maxlength="30" data-options="required:true" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px" value="<s:property value='user.ryname' />" /></p> 
                        </s:if> 
                        <s:if test="view"> 
                            <p>检查人：<span><s:property value='model.tbrxm' /></span> 
                        </s:if> 
                        <!-- <p>检查人：<input id="tbrxm" name="tbrxm" class="easyui-validatebox" maxlength="30" data-options="required:true" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px" /></p> --> 
                    </td> 
                </tr> 
                <tr> 
                    <td colspan="3" style="text-align:right; border-right: black 1px solid; border-left: black 1px solid; border-top: 0px; border-bottom: black 1px solid;" > 
                        <s:if test="add"> 
                            <p>送单时间： 
                               <input id="sdtime" name="sdtime" class="easyui-datetimebox" data-options="required:true,showSeconds:true" value="current" style="width:150px" /> 
                            </p> 
                        </s:if> 
                        <s:if test="view"> 
                            <p>送单时间：<span><s:property value='model.sdtimeStr' /></span> 
                        </s:if> 
                    </td> 
                </tr> 
                <tr> 
                    <td style="text-align:center; width: 88px; border-right: black 1px solid; border-left: black 1px solid; border-top: 0px; border-bottom: black 1px solid;" >存在问题</td> 
                    <td colspan="2" style="border-right: black 1px solid; border-left: 0px; border-top: 0px; border-bottom: black 1px solid;" > 
                        <br/> 
                        <s:if test="add"> 
                            <div id="czwt" name="czwt" contenteditable="true" style="width: 95%;height:240px" >存在问题描述</div> 
                        </s:if> 
                        <s:if test="view"> 
                            <div style="width: 95%;height:240px" ><s:property value='model.czwt' /></div> 
                        </s:if> 
                    </td> 
                </tr> 
                <tr> 
                    <td style="text-align:center; width: 88px; border-right: black 1px solid; border-left: black 1px solid; border-top: 0px; border-bottom: black 1px solid;" >整改要求：</td> 
                    <td colspan="2" style="border-right: black 1px solid; border-left: 0px; border-top: 0px; border-bottom: black 1px solid;" > 
                        <br/> 
                        <s:if test="add"> 
                            <div id="zgyq" name="zgyq" contenteditable="true" style="width: 95%;height:150px" >请输入具体整改要求</div> 
                        </s:if> 
                        <s:if test="view"> 
                            <div style="width: 95%;height:240px" ><s:property value='model.zgyq' /></div> 
                        </s:if> 
                    </td> 
                </tr> 
                <tr height="23px"> 
                    <td colspan="2" style="text-align:left; border-right: 0px; border-left: black 1px solid; border-top: 0px; border-bottom: black 1px solid;" > 
                        <s:if test="add"> 
                            接单人：<input name="jdrxm" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px" readonly="readonly" /> 
                        </s:if> 
                        <s:if test="view"> 
                            接单人：<span><s:property value='model.jdrxm' /></span> 
                        </s:if> 
                    </td> 
                    <td style="text-align:right; border-right: black 1px solid; border-left: 0px; border-top: 0px; border-bottom: black 1px solid;" > 
                        接单时间： 
                       <s:if test="add"> 
                            <input name="jdtime" style="border-left:0px;border-top:0px;border-right:0px;border-bottom:1px" readonly="readonly" /> 
                        </s:if> 
                        <s:if test="view"> 
                            <span><s:property value='model.jdtimeStr' /></span> 
                        </s:if> 
                    </td> 
                </tr> 
            </table> 
        </form> 
    </div> 
</div> 
</body> 
</html> 
