# BoogieBook

프로젝트 주제 : 도서구매 사이트
개발 인원 : 총 5명
개발 기간 : 7월 26일 ~ 8월 19일

개발 환경 : JDK12, JSP, JavaScript, css, Oracle 11g Release, Apache Tomcat 8.5, Spring Maven, myBais
기본기능 : 국내도서, 베스트셀러, 신간도서, 장바구니, 주문서작성, 결제완료, 고객센터(FAQ)
주요기능 : 1. 추천도서 (협엽 알고리즘)
           2. 상세검색 (DB필터링, myBatis 동적 쿼리문)
           3. 일일 사용자통계
           4. KaKao로그인
           5. KaKao Maps Parsing
           
1. 추천도서(협업 알고리즘)

    협업 필터링(Collaborative Filtering)이란?

    많은 사용자들로부터 얻은 기호 정보에 따라 사용자들의 관심사들을 예측하고 추천해주는 방법

    비슷한 취향을 가진 고객들에게 서로 아직 구매하지 않은 상품들을 교차 추천하거나 고객의 
    취향이나 생활 형태에 따라 관련 상품을 추천하는 형태의 서비스를 제공하기 위해 사용되는 방법

2. 상세검색(myBatis 동적쿼리문) - 다양한 조건에서 DB elect 가능해짐

    동적쿼리문 : oracle Database의 프로시져와 비슷하게 생각할 수 있음
    
3. 일일 사용자 통계
    3-1. 톰캣이 실행되면서 web.xml에 미리 등록해 둔 방문자 계산 클래스 실행
    3-2. 새로 세션을 부여 받았다면, 클래스 내에 함수가 실행되어 오늘 날짜의 요일 체크 후 해당 요일의 방문자수 1증가 
    3-3. 구글 API가 담긴 JSP에 DB에서 방문자수를 끌어와 적용시킨 후 뷰로 보여짐

4. Kakao 로그인
     STEP #1.
	      카카오 Developer 사이트에 개발자로 등록
     STEP #2. 
	      카카오 정보에 Acess할 수 있는 Key값을 획득
     STEP #3.
	      카카오 api를 이용하여 로그인에 성공한 사용	자의 정보를 담은 토큰을 가져옴
     STEP #4. 
        토큰안에 담긴 사용자 고유id와 간단한 추가정보 입력으로 회원가입.
 
5. KaKao maps Parsing
      STEP #1.
        원하는 위치의 위도와 경도를 미리 DataBase에 저장
      STEP #2.
         페이지 요청이 들어오면 Jquery Ajax 사용하여 원하는 위치의 지도를 띄움
         
         

	

