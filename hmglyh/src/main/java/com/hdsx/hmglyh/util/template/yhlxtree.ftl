[
	<#list list as yhlx>
			{
                "attributes": {
                    "dw": "",
                    "grde":0
                },
                "dejs": ${yhlx.dejs!1},
                "dj": ${yhlx.dj!0},
                "dw": "${yhlx.dw!''}",
                "grde": ${yhlx.grde!0},
                "id": "${yhlx.id}",
                "text": "${yhlx.text}",
                "yhid": "${yhlx.yhid}",
                "yhname": "${yhlx.yhname}"
                <#if (yhlx.children?size > 0) >
                ,
                "children": [
                		<#list yhlx.children as child>
                			{
		                         "attributes": {
		                            "dw": "${child.dw!''}",
		                            "grde": ${child.grde!0}
		                         },
		                        "dejs": ${child.dejs!1},
		                        "dj": ${child.dj!0},
		                        "dw": "${child.dw!''}",
		                        "grde": ${child.grde!0},
		                        "id": "${child.id}",
		                        "text": "${child.text}",
		                        "yhid": "${child.yhid}",
		                        "yhname": "${child.yhname}"
		                       <#if (child.children?size > 0) >
		                        ,
		                        "children": [
		                        	<#list child.children as childchild>
		                        	{
		                        		 "attributes": {
				                            "dw": "${childchild.dw}",
				                            "grde": ${childchild.grde!0}
				                         },
				                        "dejs": ${childchild.dejs!1},
				                        "dj": ${childchild.dj!0},
				                        "dw": "${childchild.dw!''}",
				                        "grde": ${childchild.grde!0},
				                        "id": "${childchild.id}",
				                        "text": "${childchild.text}",
				                        "yhid": "${childchild.yhid}",
				                        "yhname": "${childchild.yhname}"
		                   			 }
				                    <#if childchild_has_next > 
									 ,
									</#if>
                		 			</#list>
                				]
                  				</#if>
                			}
	                 <#if child_has_next > 
					  ,
					 </#if>
				 </#list>
               	]
           </#if>
           }
      <#if yhlx_has_next > 
	  ,
	 </#if>
	</#list>
]