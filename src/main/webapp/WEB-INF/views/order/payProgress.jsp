<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <c:set var="root" value="${pageContext.request.contextPath}"/>
<!doctypeHTML>
<html>
<head>
    <title>payment processing</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <link rel="stylesheet" type="text/css" href="${root}/resources/css/order/payProgress.css"/>
    <script type="text/javascript">
    	function progressClose(){
    		window.close();
    	}
    </script>
</head>
<body align="center" onload="move()">
    <div class="container" style="width: 450px;">
        <h2 style="font-weight: bold;">결제가 진행중 입니다.</h2>
        <p>결제완료까지 시간이 걸릴 수 있습니다.</p> 
        <div class="w3-light-grey w3-round">
          <div id="myBar" class="w3-container w3-blue w3-round" style="width:0%">0%</div>
        </div>
        <br>
    </div>
    <hr/>
    <div>
        <p>현재화면을 벗어나도 결제는 계속 진행되며, 주문결과는</p>
        <p>마이페이지 > 주문관리에서 확인 할 수 있습니다.</p>
        <br/><br/>
        <button type="button" class="btn btn-primary" onclick="progressClose()">확인</button>
    </div>
    <script>
    function move() {
      var elem = document.getElementById("myBar");   
      var width = 0;
      var id = setInterval(frame, 20);
      function frame() {
        if (width >= 100) {
          clearInterval(id);
        } else {
          width++; 
          elem.style.width = width + '%'; 
          elem.innerHTML = width * 1  + '%';
        }
      }
    }
    </script>
</body>
</html>