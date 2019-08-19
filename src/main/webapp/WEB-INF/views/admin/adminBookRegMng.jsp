<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
    <link href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Maven+Pro|Play&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${root}/resources/css/admin/admin_header.css"/>
    <link rel="stylesheet" type="text/css" href="${root}/resources/css/admin/admin_content.css"/>
    <link rel="stylesheet" type="text/css" href="${root}/resources/css/admin/admin_table.css"/>
    <link rel="stylesheet" type="text/css" href="${root}/resources/css/admin/admin_book.css"/>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
     <script type="text/javascript">	
		//도서등록 (카테고리부분)
		var catAndActs = {};
		catAndActs['국내도서'] = ['장르를선택해주세요','소설', '시/에세이', '경제/경영', '자기계발', '인문'];
		catAndActs['외국도서'] = ['장르를선택해주세요','문학', '인문/사회', '유아/아동/청소년','경제/경영','과학/기술','취미/실용/여행'];
		catAndActs['eBook'] = ['장르를선택해주세요','소설', '장르소설', '경제경영', '건강/의학', '유아'];
		
		
		function ChangecatList() {
		    var catList = document.getElementById("validationCustom02");
		    var actList = document.getElementById("validationCustom03");
		    var selCat = catList.options[catList.selectedIndex].value;
		    //alert(selCat);
		    while (actList.options.length) {
		        actList.remove(0);
		    }
		    var cats = catAndActs[selCat];
		    if (cats) {
		        var i;
		        for (i = 0; i < cats.length; i++) {
		            var cat = new Option(cats[i], selCat + ":" +cats[i]);
		            actList.options.add(cat);
		        }
		    }
		} 
		
		var catAndActs2 = {};
		catAndActs2['국내도서:소설'] = ['한국소설', '영미소설', '일본소설', '중국소설', '러시아소설','프랑스소설','독일소설','기타나라소설'];
		catAndActs2['국내도서:시/에세이'] = ['나라별 시', '장르시', '시와 이야기', '나라별 에세이','테마에세이','인물/자전적에세이','지혜/상식'];
		catAndActs2['국내도서:경제/경영'] = ['경영일반', '경영이론', '경영관리', '경영전략', '경제일반', '경제이론','기업경제','각국경제','기업실무관리'];
		catAndActs2['국내도서:자기계발'] = ['성공/처세', '자기능력계발', '비즈니스능력계발', '인간관계', '화술/협상', '청소년자기계발', '오디오북', '전자책단말기'];
		catAndActs2['국내도서:인문'] = ['인문학일반','심리학','교육학','유아교육','특수교육','임용고시','철학','문학이론'];
		catAndActs2['외국도서:문학'] = ['문학이론/역사/비평','소설','시','희곡','에세이/자서전','기타 작품집','만화'];
		catAndActs2['외국도서:인문/사회'] = ['교양','철학','심리학','종교','명상','역사','정치학'];
		catAndActs2['외국도서:유아/아동/청소년'] = ['소설','동시/연극','만화','노부영','알파벳/파닉스','컨셉북','액티비티북'];
		catAndActs2['외국도서:경제/경영'] = ['경제학','경영학','마케팅/세일즈','재무관리','투자','취업','회계'];
		catAndActs2['외국도서:과학/기술'] = ['교양과학','수학','생물학/생명공학','농림수산학','화학/화학공학','지구과학/천문학','물리학'];
		catAndActs2['외국도서:취미/실용/여행'] = ['공예','정원가꾸기','여행','게임','기타 취미생활'];
		catAndActs2['eBook:소설'] = ['한국소설','영미소설','일본소설','중국소설','러시아소설','프랑스소설','독일소설','기타나라소설'];
		catAndActs2['eBook:장르소설'] = ['로맨스','무협','판타지','라이트노벨','BL/GL','성인소설'];
		catAndActs2['eBook:경제경영'] = ['경영일반/경영이론','경영관리/CEO','경영전략/e비즈니스','기업실무관리','마케팅/세일즈','유통/창업'];
		catAndActs2['eBook:건강/의학'] = ['건강일반','질병치료/예방','한방치료','다이어트/헬스','뷰티/미용','의학'];
		catAndActs2['eBook:유아'] = ['유아놀이','그림책','유아 교양','0~3세','4~7세','유아전집'];
		
		

		function ChangecatList2() {
		    var catList2 = document.getElementById("validationCustom03");
		    var actList2 = document.getElementById("validationCustom04");
		    var selCat2 = catList2.options[catList2.selectedIndex].value;
		    while (actList2.options.length) {
		        actList2.remove(0);
		    }
		    var cats2 = catAndActs2[selCat2];
		    if (cats2) {
		        var i;
		        for (i = 0; i < cats2.length; i++) {
		            var cat2 = new Option(cats2[i], cats2[i]);
		            actList2.options.add(cat2);
		        }
		    }
		} 
	</script>
</head>
<body>
   <jsp:include page="admin_header.jsp"></jsp:include>
    <div id="content">
      <div class="section1">
        <div class="center">
          <div class="tmp1">
            <div class="borbtmeff" style="margin-bottom: 15px;">
              <b style="color:#5e6b9e; font-size:20px;">도서 등록</b>
            </div>
            <div class="tmp2BookLineOne">
				<form action="${root}/admin/adminBookMngInsert.do">
				  <div class="form-group">
				    <h2 class="heading">도서등록</h2>
					<div class="row">
					  <div class="col-md-4 mb-3">
					  	<label for="validationCustom02">카테고리</label>
					      <select class="form-control form-control-lg" name="category" id="validationCustom02" onchange="ChangecatList()" required>
					        <option value="">카테고리를 선택해주세요 </option>
					        <option value="국내도서">국내도서</option>
					        <option value="외국도서">외국도서</option>
					        <option value="eBook">eBook</option>
					      </select>
						<div class="invalid-feedback">
							Please provide a category.
						</div>
					  </div>	
					  <div class="col-md-4 mb-3">
					  	<label for="validationCustom03">장르</label>
					      <select class="form-control form-control-lg" id="validationCustom03" name="genre" onchange="ChangecatList2()" required></select>		      
						<div class="invalid-feedback">
							Please provide a category.
						</div>
					  </div>
					  <div class="col-md-4 mb-3">
					  	<label for="validationCustom04">세부장르</label>
					     <select class="form-control form-control-lg"  name="genre_detail" id="validationCustom04" required></select>
					    <div class="invalid-feedback">
							Please provide an activity.
						</div>
					  </div>
					</div>
									    
				    <div class="controls">
				      <b>책이름</b><input type="text" id="book_name" name="book_name" placeholder="책이름">
				    </div>
				    <div class="controls">
				      <b>저자</b><input type="text" id="author" placeholder="저자" name="author">
				    </div>       
				    <div class="controls">
				      <b>출판사</b><input type="tel" id="publisher" placeholder="출판사" name="publisher">
				    </div>
				    <div class="grid">
				    <div class="col-1-4 col-1-4-sm">
				      <div class="controls">
				      	<b style="margin-bottom:20px;">출판일</b>
				        <input type="date" id="regyear" class="floatLabel" name="publish_date" value="<?php echo date('Y-m-d'); ?>" style="margin-top:10px;">
				        <label for="regyear" class="label-date"><i class="fa fa-calendar"></i></label>
				      </div>      
				    </div>
				    </div>				    
				      <div class="controls">
				        <b>가격</b><input type="text" id="country" placeholder="가격" name="price">				  
				      </div>
				      <div class="controls">
				        <b>재고</b><input type="text" id="country" placeholder="재고" name="stock">
				      </div>
				      <div class="controls">
				          <b>줄거리</b><textarea id="story" placeholder="줄거리" name="story"></textarea>
				      </div>
				      <div>
				      	<b style="margin-bottom:0px;">이미지</b>
				      	<input type="file" id="country" class="floatLabel" name="img_path" style="margin-top:12px;line-height: 30px;">
				      </div>
				  </div>
				  <br/>
					  <div class="grid" style="width:600px;">
					    <button type="submit" value="Submit" class="col-1-4" style="margin-right:10px; margin-left:200px;">확인</button>
					    <button type="reset" value="Reset" class="col-1-4">취소</button>
					  </div>  			      
				  </div> 
				</form>              
            </div>
          </div>
		</div>
	  </div> 
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</body>
</html>