<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:set var="root" value="${pageContext.request.contextPath }"/>
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link type="text/css" rel="stylesheet" href="${root}/resources/css/order/paymentComplete.css"/>
</head>
<body>
   <jsp:include page="../../../header.jsp"></jsp:include>
<form action="#" method="post">
    <div class="container mb-4">
        <div class="row">
            <div class="col-12">
                <div class="table-responsive">  
                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col"><h3>주문정보</h3></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td style="padding-left:60px;"><label>주문번호</label> </td>
                                <td></td>
                                <td>${orderList[0].order_id}</td>
                                <td></td>
                                <td class="text-right"></td>
                                <td class="text-right"></td>
                            </tr>
                             <tr>
                                <td style="padding-left:60px;"><label>주문날짜</label> </td>
                                <td></td>
                                <td>
                                	<fmt:formatDate value="${orderList[0].order_date}" pattern="yyyy년 MM월 dd일" /> <br>
                                </td>
                                <td></td>
                                <td class="text-right"></td>
                                <td class="text-right"></td>
                            </tr>
                            <tr>
                                <td style="padding-left:60px;"><label>배송지</label> </td>
                                <td></td>
                                <td>${orderList[0].addr1}&nbsp;${orderList[0].addr2}</td>
                                <td></td>
                                <td class="text-right"></td>
                                <td class="text-right"></td>
                            </tr>
                            <tr>
                                <td style="padding-left:60px;"><label>주문자</label></td>
                                <td></td>
                                <td>${orderList[0].name}</td>
                                <td></td>
                                <td></td> <td></td>
                                <td class="text-right"></td>
                            </tr>
                         
                            <tr>
                                <td style="padding-left:60px;"><label>제목(수량)</label></td>
                                <td></td>
                                <c:if test="${orderList != null}">
                                	
	                                	<td style="word-break:break-all;">
	                                		<c:forEach var="orderDetail" items="${orderList}">
	                          				${orderDetail.book_name} (${orderDetail.quantity}권)&nbsp;&nbsp;&nbsp;     
	                          				</c:forEach> 
	                          			</td>	   
                               		
                                </c:if>
                                <c:if test="${orderList == null}">
                                	<td style="word-break:break-all;">
                                		${orderList[0].book_name}(${orderList[0].quantity}권)<br/>
                                	</td>
                                </c:if>         
                            </tr>                  
                            <tr>
                                <td style="padding-left:60px;"><label>주문금액</label></td>
                                <td></td>
                                <td><strong>${orderList[0].total_price}</strong>원</td>
                                <td></td>
                                <td></td>
                                <td class="text-right"></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col mb-2">
                <div class="row">
                    <div class="col-sm-12  col-md-6">
                       
                    </div>
                    <div class="col-sm-12 col-md-6 text-right">
                        <button type="button" class="btn btn-primary btn-lg" onclick="location.href='${root}/index.jsp'">확인</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</form>
   <jsp:include page="../../../footer.jsp"></jsp:include>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>
