<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
	<link rel="stylesheet" href="https://static.pingendo.com/bootstrap/bootstrap-4.3.1.css">
	<link rel="stylesheet" type="text/css" href="${root}/resources/css/customerCenter/storeMap.css" />
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=083fd23ec02eeeda62d90dc0754b0c49"></script>
	<script type="text/javascript" src="${root}/resources/jquery/jquery.js"></script>
	<script type="text/javascript">
		function sendLocationCode(location_code, root){
			var code = location_code.toString();
			var latitude;
			var longtitude;
			var store_addr;
			var store_name;
			var store_phone;
			$.ajax({
				url : root + "/customerCenter/storeMapChange.do",
				type : "get",
				data : {location_code:code},
				dataType : "text",
				contentType: "application/x-www-form-urlencoded; charset=UTF-8",
				success : function(data){
					data = data.split("/");
					latitude = Number(data[0]);
					longtitude = Number(data[1]);
					store_addr = "매장주소: "+data[2];
					store_name = "매장이름: "+data[3];
					store_phone = "전화번호: "+data[4];
					initMap(latitude, longtitude);
					$("#store_name").text(store_name);
					$("#store_addr").text(store_addr);
					$("#store_phone").text(store_phone);
				},
				error : function(){
					alert("data 가져오기 실패");
				}
			});
		}
		
		function initMap(latitude,longtitude){
			var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
			mapOption = { 
			    center: new kakao.maps.LatLng(latitude, longtitude), // 지도의 중심좌표
			    level: 3 // 지도의 확대 레벨
			};
			var map = new kakao.maps.Map(mapContainer, mapOption); 
			var markerPosition  = new kakao.maps.LatLng(latitude, longtitude); 
			var marker = new kakao.maps.Marker({
			    position: markerPosition
			});
			marker.setMap(map);
		}
	</script>
</head>
<body onload="sendLocationCode(1,'${root}')">
	<div>
		<div style="float: left;">
			<a href="${root}/index.jsp"><img src="${root}/resources/images/cutomerCenter/cutomerCenterLogo.png" style="padding-top:40px;"/></a>
		</div>
		<nav class="navbar navbar-expand-md navbar-light"
			style="width: 50%; float: right;">
			<div class="container">
				<a class="navbar-brand text-primary" href="#"> </a>
				<button class="navbar-toggler navbar-toggler-right border-0"
					type="button" data-toggle="collapse" data-target="#navbar4">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbar4"
					style="float: right;">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link" href="#">홈으로</a></li>
						<li class="nav-item"><a class="nav-link" href="#">로그인</a></li>
						<li class="nav-item"><a class="nav-link" href="#">회원가입</a></li>
					</ul>
				</div>
			</div>
		</nav>
		<div style="width: 40%; float: right; margin-top: 60px;">
			<div class="container">
				<div class="row">
					<div class="col-md-12 d-md-flex d-flex justify-content-end" style="">
						<a class="nav-link active" href="#" style="background-color:white;">
							<h4 style="color: #1E3269; font-size: 3em; font-weight: bold;">매장안내</h4>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div style="width: 100%; height: 50px; float: right; border: 1px solid black; margin-top: px; background-color: #1E3269">
		<ul class="nav" style="float: right;">
			<li class="nav-item text-center">
				<a class="nav-link" href="javascript:location.reload();">
					<h4 style="color: white;">매장안내</h4>
				</a>
			</li>
			<li class="nav-item">
				<a class="nav-link" href="${root}/customerCenter/customerService.do">
					<h4 style="color: white;">고객 서비스</h4>
				</a>
			</li>
		</ul>
	</div>
	<div class="">
		<div class="container-fluid d-flex justify-content-center">
			<div style></div>
		</div>
	</div>
	<div class="" style="margin-top: 30px;">
		<div class="container">
			<div class="row">
				<div class="w-25 col-md-3" style="">
					<h5 class="mt-2 border-bottom" style="height: 35px;">위치 안내</h5>
					<div class="list-group">
						<a href="#" class="list-group-item list-group-item-action" style="background-color: #1E3269; color: aliceblue; font-weight: bold;">매장위치</a>
						<a href="javascript:sendLocationCode(1,'${root}');" class="list-group-item list-group-item-action">강남</a>
						<a href="javascript:sendLocationCode(2,'${root}');" class="list-group-item list-group-item-action">강동</a>
						<a href="javascript:sendLocationCode(3,'${root}');" class="list-group-item list-group-item-action">군자</a>
						<a href="javascript:sendLocationCode(4,'${root}');" class="list-group-item list-group-item-action">발산</a>
						<a href="javascript:sendLocationCode(5,'${root}');" class="list-group-item list-group-item-action">목동</a>
						<a href="javascript:sendLocationCode(6,'${root}');" class="list-group-item list-group-item-action">상봉</a>
						<a href="javascript:sendLocationCode(7,'${root}');" class="list-group-item list-group-item-action">신촌</a>
						<a href="javascript:sendLocationCode(8,'${root}');" class="list-group-item list-group-item-action">코엑스</a>
						<a href="javascript:sendLocationCode(9,'${root}');" class="list-group-item list-group-item-action">화곡</a>
					</div>
				</div>
				<div class="col-md-8">
					<h5 class="mt-2 border-bottom" style="height: 35px;">지도 안내</h5>
					<div class="row">
						<div class="col-md-12">
							<div style="width:100%; height:400px;" id="map"></div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="card">
								<div class="card-body">
									<h5 id="store_name"></h5>
									<h5 id="store_addr"></h5>
									<p id="store_phone"></p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		</div>
	<jsp:include page="../../../footer.jsp"/>
</body>
</html>