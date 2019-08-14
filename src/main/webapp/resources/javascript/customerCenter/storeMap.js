/**
 *  storeMap 이 열리자 마자 = onlod 되자마자 강남점 지도 parsing 해줌
 *  강남 강동 ..........코엑스 화곡 목록 누를 때마자 ajax로 지도 parsing 해줘야함
 *  parsing 할때 필요한 값들.... latitude longtitude 
 *  강남 = 1, 강동 = 2, 군자 = 3, 발산 = 4
 *  목동 = 5, 상봉 = 6, 신촌 = 7, 코엑스 = 8, 화곡 = 9 
 *  숫자는 location_code;
 */
//initMap(latitude, longtitude);

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