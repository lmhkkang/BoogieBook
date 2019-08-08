<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
	<head>
		<meta charset="UTF-8">
		<title>shop</title>
        <link href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Maven+Pro|Play&display=swap" rel="stylesheet">
       	<link href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap" rel="stylesheet">
       	 
		<link rel="styleSheet" type="text/css" href="${root}/resources/css/index/index_header.css"/>
		<link rel="styleSheet" type="text/css" href="${root}/resources/css/index/index_content.css"/>
		<link rel="styleSheet" type="text/css" href="${root}/resources/css/index/index_footer.css"/>
		<script src="${root}/resources/javascript/index/header_js.js"></script>
		<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
		
		<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>
		<script type="text/javascript">
		$(function(){
			$(".logo").click(function(){
				$("a").href("${root}/index.do");
			})
		);
		</script>
    </head>
	<body>
		<header>
		<div class="gnb">
			<ul class="center">
				<li class="topHeader_l"><a href="#">매장안내</a><span>∨</span></li>
				<li class="topHeader_l"><a href="#">회원혜택</a><span>∨</span></li>
				<li></li>
				<li class="topHeader_r"><a href="#"></a></li>
				<li	class="topHeader_r"><a href="#"><img width="13px" height="13px" src="${root}/resources/images/keep.jpg"><span>0</span></a></li>
				<li class="topHeader_r"><a href="#">고객센터</a></li>
				<li class="topHeader_r"><a href="#">주문배송</a></li>	
				
				<c:if test="${name == null}">				
					<li class="topHeader_r"><a href="${root}/member/register.do">회원가입</a></li>
					<li class="topHeader_r"><a href="javascript:OpenLoginFrame()">로그인</a></li>
				</c:if>
				<c:if test="${name !=null}">					
					<li class="topHeader_r"><a href="#">마이페이지</a></li>
					<c:if test="${snsNum == 3}">
						<li class="topHeader_r"><a href="${root}/member/memberEdit.do?id=${id}">회원정보수정</a></li>
					</c:if>
					<c:if test="${snsNum == 1}">
						<li class="topHeader_r"><a href="${root}/member/KaKaoEdit.do?id=${id}">회원정보수정</a></li>
					</c:if>
					<li class="topHeader_r"><a href="${root}/member/logout.do">로그아웃</a></li>
					<li class="topHeader_r"><b>${name}님 환영합니다.</b></li>
				</c:if>
								
									
			</ul>
		</div>
		
           <div class="center">
               <div class="middleHeader">
                   <div class="logo"><img src="${root}/resources/images/BoogieBook_Logo.png"><a href="${root}/index.do"></a></div>
                   <div class="search_form">
                       <div class="search_top">
                       	<ul class="search_top_ul">
                       		<li class="search_top_li"><a href="#">수학</a></li>
                       		<li class="search_top_li"><a href="#">수능</a></li>
                       		<li class="search_top_li"><a href="#">저스티스</a></li>
                       		<li class="search_top_li" style="border-right: 0px;"><a href="#">언제까지</a></li>
                       		<li class="search_top_li" style="width:12px; border-right: 0px;"><a href="#" style=" border-right: 0px;"><img src="${root}/resources/images/before.png" width="11px" height="12px"></a></li>
                       		<li class="search_top_li" style="width:12px; border-right: 0px;"><a href="#" style=" border-right: 0px;"><img src="${root}/resources/images/forward.png" width="11px" height="12px"></a></li>
                       	</ul>
                       </div>                        	
                       <div class="search">
                       <form action="${root}/search/searchOk.do"method="get">
                       <div id="custom-search-input">
                           <div class="input-group col-md-12">
                               <input type="text" class="  search-query form-control" name="keyword" placeholder="Search" />
                               <span class="input-group-btn">
                                   <button class="btn btn-danger" type="submit" >
                                       <span class=" glyphicon glyphicon-search"></span>
                                   </button>
                               </span>
                           </div>
                       </div>
                       </form>
                       </div>
                   </div>
               </div>
           </div>
				
			<div class="lnb">
                <div id="center">
                    <ul class="center">
                        <li><a href="#">국내도서</a></li>
                        <li><a href="#">베스트셀러</a></li>
                        <li><a href="#">신간도서</a></li>
                        <li><a href="${root}/search/detailSearch.do">상세검색</a></li>
                        <li><a href="${root}/recommend/recommendMain.do">추천도서</a></li>
                        <li><a href="#">매장안내</a></li>
                    </ul>
                </div>
			</div>
		</header>
</body>
</html>