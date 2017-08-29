[
	<#list list as bhlx>
	 {
        "bhid": "${bhlx.bhid}",
        "bhname": "${bhlx.bhname}",
        "dw": "${bhlx.dw!''}",
        "id": "${bhlx.id}",
        "state": "${bhlx.state!''}",
        "text": "${bhlx.text}",
        "wxsx": ${bhlx.wxsx!0}
        <#if (bhlx.children?size > 0) >
    	 ,
    	 "children": [
     			<#list bhlx.children as child>
     				 {
     				  "attributes":{
     				  	"dw":"${child.dw!'-'}"
     				  },
     				  "bhid": "${child.bhid}",
				      "bhname": "${child.bhname}",
				      "dw": "${child.dw!''}",
				      "id": "${child.id}",
				      "state": "${child.state!''}",
				      "text": "${child.text}",
				      "wxsx": ${child.wxsx!0}
				      }
				      <#if child_has_next >
				      ,
				      </#if>
     			</#list>
    	  ]
        </#if>
    }
    <#if bhlx_has_next > 
    ,
    </#if>
	</#list>
   
]