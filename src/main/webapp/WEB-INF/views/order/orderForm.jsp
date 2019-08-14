<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath}"/>
<!doctype html>
<html>
<head>
	<meta charset="UTF-8">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
    <link type="text/css" rel="stylesheet" href="${root}/resources/css/order/orderForm.css"/> 
    <script type="text/javascript" src="${root}/resources/javascript/order/orderForm.js"></script>
	<script type="text/javascript" src="${root}/resources/javascript/jquery.js"></script>
	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
</head>
<body>
<c:set var="book_id" value="${book_id}"/>
<c:set var="member_id" value="${member_id}"/>
<c:set var="memberDto" value="${memberDto}"/>
<c:set var="name" value="${memberDto.name}"/>
<c:set var="zipcode" value="${memberDto.zipcode}"/>
<c:set var="addr1" value="${memberDto.addr1}"/>
<c:set var="addr2" value="${memberDto.addr2}"/>
<c:set var="phone" value="${memberDto.phone}"/>
<c:set var="quantity" value="${quantity}"/>
<c:set var="total" value="${total}"/>

<jsp:include page="../../../header.jsp"></jsp:include>
<div style="height: 100px; width: 800px;"></div>

<form action="${root}/order/paymentComplete.do" method="post" onsubmit="javascript:payProgress('${root}')">
    <div class="container mb-4">
        <div class="row">
            <div class="col-12">
                <div class="table-responsive">

                    <table class="table table-striped">
                        <thead>
                            <tr>
                                <th scope="col"><h3>배송정보</h3></th>
                                <th scope="col">
                                    <!-- Default unchecked -->
                                    <button type="button" class="btn btn-outline-primary" onclick="oldInfo('${name}','${zipcode}','${addr1}','${addr2}','${phone}')">기존정보</button>
                                    <button type="button" class="btn btn-outline-primary" onclick="newInfo()">새로입력</button>
                                </th>   
                                 <th scope="col">
                                    <!-- Default unchecked -->
                                    
                                </th>   
                            </tr>
                        </thead>
                       
                        <tbody>
                            <tr>
                                <td style="padding-left:70px"><label>수령인</label></td>
                                <td><input class="form-control" type="text" name="name" id="name" value="${memberDto.name}" style="width:150px;"/></td>
                                <td></td>
                                <td></td>
                                <td class="text-right"></td>
                                <td class="text-right"></td>
                            </tr>
                            <c:if test="${member_id == null}">
                            	<tr>
	                                <td style="padding-left:70px"><label>이메일</label></td>
	                                <td><input class="form-control" type="text" name="email" id="email" value="" style="width:200px;"/></td>
	                                <td></td>
	                                <td></td>
	                                <td class="text-right"></td>
	                                <td class="text-right"></td>
	                            </tr>
                            </c:if>	                                                    
                            <tr>
                                <td style="padding-left:70px"><label>배송지</label> </td>
                                <td>
                                    <input class="form-control" type="text" id="zipcode" name="zipcode" value="${memberDto.zipcode}" style="width:100px; float:left;" />
                                    <button type="button" class="btn btn-primary" name="zipcodeFinder"  style="float:left;" onclick="zipcodeRead()">우편번호</button>
                                    <input class="form-control" type="text" id="addr1" name="addr1" value="${memberDto.addr1}"/>
                                    <input class="form-control" type="text" placeholder="상세주소입력" id="addr2" name="addr2" value="${memberDto.addr2}"/>
                                </td>
                                <td></td>
                                <td></td>
                                <td class="text-right"></td>
                                <td class="text-right"></td>
                            </tr>
                            <tr>
                                <td style="padding-left:70px"><label>전화번호</label></td>
                                <td> <input class="form-control" type="text"  name="phone" id="phone" value="${memberDto.phone}" style="float:left;width:150px;" id="phone"/></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td class="text-right"></td>
                            </tr>
                            <tr>
                                <td style="padding-left:70px"><label>배송메모</label></td>
                                <td><div class="form-group green-border-focus">
                                  <div class="dropdown">
                                  <button class="btn btn-secondary dropdown-toggle" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"></button>
                                      <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                                        <a class="dropdown-item" id="drop1" onclick="dropItem1()">부재시 경비실에 맡겨주세요.</a>
                                        <a class="dropdown-item" id="drop2" onclick="dropItem2()">부재시 문앞에 놓아주세요.</a>
                                        <a class="dropdown-item" id="drop3" onclick="dropItem3()">방문전에 전화 부탁드립니다.</a>
                                      </div>
                                    </div>
                                  <textarea class="form-control" id="exampleFormControlTextarea5" rows="3"></textarea>
                                </div></td> 
                                <td></td> <td></td> <td></td> <td></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td><strong></strong></td>
                                <td class="text-right"><strong></strong></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col mb-2">
                <div class="row">
                    <div class="col-sm-12  col-md-6">
                        <input type="button" class="btn btn-secondary btn-lg btn-block" value="취소"/>
                    </div>
                    <div class="col-sm-12 col-md-6 text-right">
                        <input type="submit" class="btn btn-primary btn-lg btn-block" value="결제하기"/>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div style="height: 100px; width: 800px;"></div>
  <jsp:include page="../../../footer.jsp"></jsp:include>  
  <input type="hidden" name="member_id" value="${member_id}" id="member_id" />
  <input type="hidden" name="total" value="${total}"/>
  <input type="hidden" name="quantity" value="${quantity}"/>
</form>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
</body>
</html>