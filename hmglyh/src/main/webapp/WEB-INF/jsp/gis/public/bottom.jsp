<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <script>
		window.onload = function(){
			$(".tabs_content").height($("body").height()-28);
			var lb = $("#liebiao");
			lb.attr("src",lb.attr("mysrc"));
			window.onresize = function(e){
				$(".tabs_content").height($("body").height()-28);
			};
		};
	</script>