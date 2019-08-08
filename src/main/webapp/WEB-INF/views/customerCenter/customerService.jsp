<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
	<link rel="stylesheet" href="${root}/resources/css/customerCenter/theme.css" type="text/css">
	<link rel="stylesheet" href="${root}/resources/css/customerCenter/customerService.css" type="text/css">
	<title>고객 서비스</title>
</head>
<body style="border-bottom-width: 0px;">
	<div style="float: left;">
		<a href="${root}/index.jsp"><img src="${root}/resources/images/cutomerCenter/cutomerCenterLogo.png" style="padding-top:40px;"/></a>
	</div>
	<div style="height: 200px;">
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
						<li class="nav-item"><a class="nav-link" href="${root}/index.jsp">홈으로</a></li>
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
						<a class="nav-link" href="#">
							<h4 style="color: #1E3269; font-size: 3em; font-weight: bold;">고객 서비스</h4>
						</a>
					</div>
				</div>
			</div>
		</div>
		<div
			style="width: 100%; height: 50px; float: right; border: 1px solid black; margin-top: px; background-color: #1E3269">
			<ul class="nav" style="float: right;">
				<li class="nav-item text-center">
					<a class="nav-link" href="${root}/customerCenter/storeMap.do">
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
	</div>


	<div class="py-5" style="margin-top: 100px;">
		<div class="container">
			<div class="row">
				<div class="w-25 col-md-3" style="">
					<h5 class="mt-2 border-bottom" style="height: 35px;">고객센터</h5>
					<div class="list-group">
						<a href="#" class="list-group-item list-group-item-action"
							style="background-color: #1E3269; color: white; font-weight: bold;">FAQ</a>
						<a href="#" class="list-group-item list-group-item-action">반품/교환/환불</a>
						<a href="#" class="list-group-item list-group-item-action">주문/결제</a>
						<a href="#" class="list-group-item list-group-item-action">회원</a>
						<a href="#" class="list-group-item list-group-item-action">도서/상품정보</a>
						<a href="#" class="list-group-item list-group-item-action">배송/수령일안내</a>
					</div>
				</div>
				<div class="col-md-9 w-75" style="">
					<div class="row">
						<div class="col-md-12">
							<div class="row">
								<div class="col-md-2 text-center" style="">
									<h5 class="mt-2" style="height: 35px;">FAQ 검색</h5>
								</div>
								<div class="col-md-2" style="">
									<div class="btn-group pt-1" style="height: 50px;">
										<button class="btn btn dropdown-toggle" data-toggle="dropdown"style="background-color: #1E3269; color: white; font-weight: bold;">FAQ 분류 선택<br>
										</button>
										<div class="dropdown-menu">
											<a class="dropdown-item" href="#">반품/교환/환불</a> 
											<a class="dropdown-item" href="#">주문/결제</a>
											<a class="dropdown-item" href="#">회원</a>
											<a class="dropdown-item" href="#">도서/상품정보</a>
											<a class="dropdown-item" href="#">배송/수령일안내</a>
										</div>
									</div>
								</div>
								<div class="col-md-7" style="padding-left: 50px;">
									<form class="form-inline">
										<div class="input-group mt-2" style="float:right;">
											<input type="text" class="form-control"
												id="inlineFormInputGroup" placeholder="Search"
												style="width: 250px; height: 35px;float:right;">
											<div class="input-group-append">
												<button class="btn btn-primary" type="button"
													style="background-color: #1E3269; border: 0px; float:right;">
													<i class="fa fa-search" style="background-color: #1E3269"></i>
												</button>
											</div>
										</div>
									</form>
								</div>
							</div>
							<ol class="border-right border-top border-bottom border-left"
								style="border-style: 1pxsolid;">
								<li>회원가입은 어떻게 하나요?</li>
								<li>실명 인증은 어떻게 하나요?</li>
								<li>회원정보는 어디서 확인하나요?</li>
								<li>로그인 아이디(ID), 비밀번호를 잊어버렸는데 어떻게 해야하나요?</li>
								<li>개명한 경우 이름은 어떻게 변경하나요?</li>
								<li>회원탈퇴는 어떻게 하면 되나요?<br></li>
								<li>회원정보는 어디서 확인하나요?<br></li>
								<li>14세 미만 아동 회원 가입 안내<br></li>
								<li>부기앤북 온라인 멤버십이란 무엇인가요?</li>
								<li>부기앤북 온라인 멤버십에는 어떤 혜택이 있나요?<br></li>
							</ol>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-12" style="">
					<ul class="pagination justify-content-center mt-1" id="pageNumber">
						<li class="page-item"><a class="page-link" href="#"> <span>«</span></a>
						</li>
						<li class="page-item"><a class="page-link" href="#">1</a></li>
						<li class="page-item"><a class="page-link" href="#">2</a></li>
						<li class="page-item"><a class="page-link" href="#">3</a></li>
						<li class="page-item"><a class="page-link" href="#">4</a></li>
						<li class="page-item"><a class="page-link" href="#">5</a></li>
						<li class="page-item"><a class="page-link" href="#"> <span>»</span></a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-12 d-flex justify-content-end">
					<a class="btn btn-light" href="#">글쓰기</a>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../../../footer.jsp"></jsp:include>
</body>
</html>