<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<!DOCTYPE html>
<html>
<c:set var="root" value="${pageContext.request.contextPath}"/>
  <head>
    <meta charset="utf-8">
    <title>관리자 페이지</title>
    <link href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Maven+Pro|Play&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${root}/resources/css/admin/admin_header.css"/>
    <link rel="stylesheet" type="text/css" href="${root}/resources/css/admin/admin_content.css"/>
    <link rel="stylesheet" type="text/css" href="${root}/resources/css/admin/admin_table.css"/>
    <link rel="stylesheet" type="text/css" href="${root}/resources/css/admin/admin_book.css"/>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script type="text/javascript" src="${root}/resources/javascript/admin/editBook.js"></script>
    <script type="text/javascript" src="${root}/resources/javascript/admin/delBook.js"></script>
    <script type="text/javascript" src="${root}/resources/jquery/jquery.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script type="text/javascript">
	  
	</script>
  </head>

  <body>
    <jsp:include page="admin_header.jsp"></jsp:include>
    <div id="content">
      <div class="section1">
        <div class="center">
          <div class="tmp1">
            <div class="tmp2BookLineOne">      
            </div>
          </div>
		</div>
	  </div>
      <div class="section2">
        <div class="center">
          <div class="tmp2">
            <div class="borbtmeff">
              <b style="color:#5e6b9e; font-size:20px;">도서 관리</b>
            </div>
            <div class="tmp2BookLineTwo">
				<div class="container">	
			    <hr>
			    <div class="row">
			        <div>
			            <div>
			            <form action="adminBookSearchMng.do" method="get">
			            	<div class="input-group col-md-12">
                           		<input type="text" class="search-query form-control"
                              	name="book_name" id="term" placeholder="책이름으로 검색" /> <span
                              	class="input-group-btn">
                              	<button class="btn btn-primary" type="submit">
                                 	<span class=" glyphicon glyphicon-search"></span>
                              	</button>
                           		</span>
                        	</div>
                        </form>				      
			            </div>
			           	<c:if test="${count > 0}">
				            <table class="table table-striped table-bordered" style="width:1000px;">
				                <thead>
				                    <tr>
				                        	<td>책 번호</td>
				                        	<td>책 이름</td>
				                        	<td>저자</td>
				                        	<td>출판사</td>
				                        	<td>출판일</td>
				                        	<td class="text-center"> 수정/삭제 </td>
				                    </tr>
				                </thead>
				                <tbody>
				                	<c:forEach var="bookDto" items="${bookList}">
				                		<tr>
				                			<td>${bookDto.book_id}</td>
				                			<td>${bookDto.book_name}</td>
				                			<td>${bookDto.author}</td>
				                			<td>${bookDto.publisher}</td>
				                			<td><fmt:formatDate value="${bookDto.publish_date}" pattern="yy-MM-dd"/></td>
				                			<td class="text-center"><a class='btn btn-info btn-xs' href="javascript:editBook('${root}','${bookDto.book_id}')" id="editBtn${bookDto.book_id}"><span class="glyphicon glyphicon-edit"></span> 수정</a> <a href="javascript:delBook('${root}','${bookDto.book_id}')" class="btn btn-danger btn-xs" id="deleteBtn${bookDto.book_id}"><span class="glyphicon glyphicon-remove"></span> 삭제</a></td>
				                		</tr>
				                	</c:forEach>    
				                </tbody>
				            </table>
			            </c:if>
			            <div align="center">
			            	<c:if test="${count > 0}">
			            		<c:set var="pageBlock" value="${10}"/>
			            		<fmt:parseNumber var="pageCount" value="${count/listSize + (count%listSize == 0?0:1)}" integerOnly="true"/>
			            		
			            		<fmt:parseNumber var="result" value="${(currentPage-1)/pageBlock}" integerOnly="true"/>
			            		<c:set var="startPage" value="${result * pageBlock+1}"/>
			            		<c:set var="endPage" value="${startPage + pageBlock - 1}"/>
			            		<c:if test="${endPage > pageCount}">
			            			<c:set var="endPage" value="${pageCount}"/>
			            		</c:if>
			            		
			            		<c:if test="${startPage > pageBlock}">
			            			<a href="adminBookMng.do?pageNumber=${startPage-pageBlock}">[이전]</a>
			            		</c:if>
			            		
			            		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			            			<a href="adminBookMng.do?pageNumber=${i}">[${i}]</a>
			            		</c:forEach>
			            		
			            		<c:if test="${endPage < pageCount}">
			            			<a href="adminBookMng.do?pageNumber=${startPage+pageBlock}">[다음]</a>
			            		</c:if>
			            	</c:if>
			            </div>
			        </div>
			    </div>
			</div>				
            </div>
          </div>
        </div>
      </div>
		</div>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
  </body>
</html>
