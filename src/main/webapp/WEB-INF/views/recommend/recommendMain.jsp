<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
<head>
<meta charset="UTF-8">
<title>shop</title>
	<link href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Maven+Pro|Play&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Jua&display=swap" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap" rel="stylesheet">
		
	<link rel="styleSheet" type="text/css" href="${root}/resources/css/recommend/recommend_content.css" />
	<script type="text/javascript" src="${root}/resources/javascript/xhr/xhr.js"></script>

<script type="text/javascript">
	
	function toServer(root, book_name) {
		var url = root + "/recommend/recommendProcxy.do?bookName=" + book_name;

		//alert(markList);
		sendRequest("GET", url, fromServer, null);
	}

	function fromServer() {
		//alert(xhr.readyState+","+xhr.status);
		if (xhr.readyState == 4 && xhr.status == 200) {
			//alert(xhr.responseXML);
			console.log(xhr.responseXML)
			processXML();
		}
	}

	function processXML() {
		var xmlDoc = xhr.responseXML;

		var discription = xmlDoc.getElementsByTagName("description");
		if (discription.length > 1) {
			document.getElementById("interest_des").innerHTML = discription[1].childNodes[0].nodeValue;
		} else {
			document.getElementById("interest_des").innerHTML = "미리보기내역이 존재하지 않습니다.";
		}
	}
	
</script>
</head>
<body onload="toServer('${root}','${interestDto.book_name}')">
	<jsp:include page="../../../header.jsp"></jsp:include>
	<div class="center">
		<div class="section1_l">
			<ul class="book_list">
				<li><a>종합</a></li>
				<li><a>소설</a></li>
				<li><a>시/에세이/기행</a></li>
				<li><a>자기계발</a></li>
				<li><a>가정/생활/요리</a></li>
				<li><a>건강/의학/미용</a></li>
				<li><a>인문/교양/철학</a></li>
				<li><a>역사/신화/문화</a></li>
				<li><a>유아</a></li>
				<li><a>어린이</a></li>
				<li><a>예술/대중문화</a></li>
				<li><a>여행/취미/레져</a></li>
				<li><a>잡지</a></li>
				<li><a>만화</a></li>
				<li><a>컴퓨터/IT</a></li>
			</ul>
		</div>
		<div class="section1_r">
			<div class="section2">
				<div class="interest">
					<div class="interest_top">
						<div class="interest_top_l">${id} 님의 관심분야책</div>
						<div class="interest_top_r">
							<button>다른 관심분야 선택하러가기</button>
						</div>
					</div>
					<div class="interest_body">
						<div class="interest_img">
							<img src="${interestDto.img_path}" width="100%" height="100%">
						</div>
						<div class="interest_subject_form">
							<div class="interest_sub">
								<div class="interest_subject">
									<div class="interest_subject1">
										<fmt:formatDate value="${interestDto.publish_date}"
											pattern="yyyy-MM-dd" />
									</div>
									<div class="interest_subject2">
										<a href="#"><b>${interestDto.book_name}</b></a>
									</div>
									<div class="interest_subject3">
										인터넷 판매가: <b style="color: red"><fmt:formatNumber value="${interestDto.price}" pattern="#,###" />원</b>
										(${interestDto.publisher} | ${interestDto.author})
									</div>
								</div>
							</div>
							<div class="interest_des" id="interest_des"></div>
							<div class="interest_btn">
								<button>바로 구매하기</button>
								<button>장바구니 담기</button>
							</div>
						</div>
					</div>
				</div>
			</div>

			<div class="section3">
				<div class="mark_form">
					<div class="mark_top">평점 좋은 책</div>
					<div class="mark_body">
						<div class="mark_content_form">
							<div class="mark_content" style="border: 5px solid #e3e3e4;">
								<div class="mark_content_top">오늘의 발견</div>
								<div class="mark_content_img_form">
									<div class="mark_content_img">
										<img width="100%" height="100%" src='${markBookList.get(0).img_path}'>
									</div>
									<div class="mark_content_genre">[${markBookList.get(0).type03}]</div>
									<div class="mark_content_sub">${markBookList.get(0).book_name}</div>
									<div class="mark_content_writer">${markBookList.get(0).author}</div>
									<div class="mark_icon">
										<img width="100%" height="100%" src="${root}${markBookIcon[0]}">
									</div>
									<div class="mark_number"><fmt:formatNumber value="${markList.get(0)}" pattern="#.#" /></div>
								</div>
							</div>
							<div class="mark_content_r">
								<div class="mark_content">
									<div class="mark_content_top" style="color: white">오늘의 발견</div>
									<div class="mark_content_img_form">
										<div class="mark_content_img">
											<img width="100%" height="100%"
												src='${markBookList.get(1).img_path}'>
										</div>
										<div class="mark_content_genre">[${markBookList.get(1).type03}]</div>
										<div class="mark_content_sub">${markBookList.get(1).book_name}</div>
										<div class="mark_content_writer">${markBookList.get(1).author}</div>
										<div class="mark_icon">
											<img width="100%" height="100%" src="${root}${markBookIcon[1]}">
										</div>
										<div class="mark_number"><fmt:formatNumber value="${markList.get(1)}" pattern="#.#" /></div>
									</div>
								</div>
								<div class="mark_content">
									<div class="mark_content_top" style="color: white">오늘의 발견</div>
									<div class="mark_content_img_form">
										<div class="mark_content_img">
											<img width="100%" height="100%"
												src='${markBookList.get(2).img_path}'>
										</div>
										<div class="mark_content_genre">[${markBookList.get(2).type03}]</div>
										<div class="mark_content_sub">${markBookList.get(2).book_name}</div>
										<div class="mark_content_writer">${markBookList.get(2).author}</div>
										<div class="mark_icon">
											<img width="100%" height="100%" src="${root}${markBookIcon[2]}">
										</div>
										<div class="mark_number"><fmt:formatNumber value="${markList.get(2)}" pattern="#.#" /></div>
									</div>
								</div>
								<div class="mark_content">
									<div class="mark_content_top" style="color: white">오늘의 발견</div>
									<div class="mark_content_img_form">
										<div class="mark_content_img">
											<img width="100%" height="100%"
												src='${markBookList.get(3).img_path}'>
										</div>
										<div class="mark_content_genre">[${markBookList.get(3).type03}]</div>
										<div class="mark_content_sub">${markBookList.get(3).book_name}</div>
										<div class="mark_content_writer">${markBookList.get(3).author}</div>
										<div class="mark_icon">
											<img width="100%" height="100%" src="${root}${markBookIcon[3]}">
										</div>
										<div class="mark_number"><fmt:formatNumber value="${markList.get(3)}" pattern="#.#" /></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="section4">
				<div class="recommend_form">
					<div class="recommend_top">${id} 님이 좋아할만한 책</div>
					<div class="recommend_body" style="background-image: url('${root}/resources/images/background.jpg');">
						<c:if test="${recommend_imgs[0]!=null}">
							<div class="rocommend_left"><a href="${root}/book/bookInfo.do?book_id=${recommend_imgs_book_id[0]}"><img width="100%" height="100%" src='${recommend_imgs[0]}'></a></div>
						</c:if>
						<c:if test="${recommend_imgs[0]==null}">
							<div class="rocommend_left" style="text-align: center; line-height: 2">더 많은 리뷰를 입력하시면 <br/>도서를 추천받으실 수 있습니다.</div>
						</c:if>
						<c:if test="${recommend_imgs[1]!=null}">
							<div class="rocommend_right"><a href="${root}/book/bookInfo.do?book_id=${recommend_imgs_book_id[1]}"><img width="100%" height="100%" src='${recommend_imgs[1]}'></a></div>
						</c:if>
						<c:if test="${recommend_imgs[1]==null}">
							<div class="rocommend_right" style="text-align: center; line-height: 2">더 많은 리뷰를 입력하시면 <br/>도서를 추천받으실 수 있습니다.</div>
						</c:if>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="../../../footer.jsp"></jsp:include>
</body>
</html>