<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<html>
<head>
<link rel="styleSheet" type="text/css"
      href="${root}/resources/css/index/recent_product.css" />
      <script type="text/javascript">
  	$(function (){
  		var path = "${root}/search/getcookies.do";
  	   $.ajax({
  	       url:path,
  	       type:'get',
  	       dataType : 'json',
  	       success:function(data){
  	         //alert(data[0].book_name);
  	         var bar=document.getElementById("bar");
  	         
  	         for(var i=0; i<data.length;i++){
  	         var imgbax=document.createElement("div");
  	         imgbax.setAttribute("class", "imgvie");
  	       	
  	         var img=document.createElement("img");
  	       	 img.setAttribute("src",data[i].img_path);  	       	
  	       	 img.setAttribute("width","100%");
  	     	 img.setAttribute("height","100%");
  	     	
  	     	var closebtn=document.createElement("button");
  	     	closebtn.setAttribute("class", "close_btn");
  	     	closebtn.innerHTML="x";
  	     	
  	       	 imgbax.appendChild(img);
  	         bar.appendChild(imgbax);
  	       imgbax.appendChild(closebtn);
  	         }
  	       },
  	       error:function(){
  	               alert("에러입니다");
  	       }
  	   });
  	});
      </script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div id="bar" class="bar">
		
	</div>
</body>
</html>