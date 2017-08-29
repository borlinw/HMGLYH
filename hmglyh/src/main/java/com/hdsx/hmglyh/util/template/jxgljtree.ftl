[
	<#list list as cl>
	  {
	  	"attributes":{
	  		"gg":"${cl.gg!''}"
	  	},
        "checkbox": true,
        "id": "${cl.id}",
        "lxid": "${cl.lxid}",
        "lxname": "${cl.lxname}",
        "text": "${cl.text}"
         <#if (cl.children?size > 0) >
    	 ,
    	 "children": [
        	<#list cl.children as clcl>
        		{
    				"attributes":{
				  		"gg":"${clcl.gg!''}"
				  	},
			        "checkbox": true,
			        "id": "${clcl.id}",
			        "lxid": "${clcl.lxid}",
			        "lxname": "${clcl.lxname}",
			        "text": "${clcl.text}"
			         <#if (clcl.children?size > 0) >
			    	 ,
			    	  "children": [
			        	<#list clcl.children as clclcl>
			        	   {
			        	   "attributes":{
							  		"gg":"${clclcl.gg!''}"
							  },
			        		 "checkbox": true,
					         "id": "${clclcl.id}",
					         "lxid": "${clclcl.lxid}",
					         "lxname": "${clclcl.lxname}",
					         "text": "${clclcl.text}"
					        }
					        <#if clclcl_has_next > 
							 ,
							</#if>
			        	</#list>
			        	]
			    	 </#if>
			       
			      }
			      <#if clcl_has_next > 
				   ,
				  </#if>
   			</#list>
     		 ]
    	 </#if>
      }
      <#if cl_has_next > 
	   ,
	   </#if>
	</#list>
]