<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<c:set var="root" value="${pageContext.request.contextPath}"></c:set>
  <head>
    <meta charset="utf-8">
    <title>관리자 페이지</title>
    <link href="https://fonts.googleapis.com/css?family=Black+Han+Sans|Maven+Pro|Play&display=swap" rel="stylesheet">    
    <link rel="stylesheet" type="text/css" href="${root}/resources/css/admin_content.css"/>
  </head>
  <body>
    <jsp:include page="admin_header.jsp"></jsp:include>
    <div id="content">
      <div class="section1">
        <div class="center">
          <div class="tmp1">
            <div class="borbtmeff" style="margin-bottom: 15px;">
              <b style="color:#5e6b9e; font-size:20px;">사용자 통계</b>
            </div>
            <div id="adminSection1">
              <div id="cndtjd" style="margin-top:50px">

              </div>
              <div id="chart_div" style="width: 1000px; height: 500px; margin: 50px auto 0px auto;"></div>
                <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
            		<script type="text/javascript">
            			google.charts.load('current', {packages: ['corechart', 'bar']});
            			google.charts.setOnLoadCallback(drawBasic);

            			function drawBasic() {
            				var data = new google.visualization.DataTable();
            				data.addColumn('string', '요일');
            				data.addColumn('number', '방문자수(명)');

            				data.addRows([
            					['일', ${sunCount}],
            					['월', ${monCount}],
            					['화', ${tueCount}],
            					['수', ${wedCount}],
            					['목', ${thuCount}],
            					['금', ${friCount}],
            					['토', ${satCount}]
            				]);

            				var options = {
            					title: '이번주 일별 방문자 현황',
            					hAxis: {
            						title: '요일',
            						viewWindow: {
            							min: [7, 30, 0],
            							max: [17, 30, 0]
            						}
            					},

            					vAxis: {
            						title: '방문자수(명)'
            					}
            				};

            				var chart = new google.visualization.ColumnChart(
            				document.getElementById('chart_div'));

            				chart.draw(data, options);
            			}
            		</script>
            </div>
          </div>
		</div>
	  </div>
	</div>
  </body>
</html>
