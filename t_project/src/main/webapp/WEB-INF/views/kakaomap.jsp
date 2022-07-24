<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form>
위도<input type="text" id="lat" readonly><br>
경도<input type="text" id="lng" readonly><br>
<input type="button" onclick="getAddrs()" value="현재 위치 받기(콘솔로그로 나옴)">
</form>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ed445263dd16bda07760fb634155a272&libraries=services"></script>
<script>
	function getAddrs(){
		var geocoder = new kakao.maps.services.Geocoder();
		// HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
		if (navigator.geolocation) {
		    
		    // GeoLocation을 이용해서 접속 위치를 얻어옵니다
		    navigator.geolocation.getCurrentPosition(function(position) {
		     
		        var lat = position.coords.latitude, // 위도
		        lng = position.coords.longitude; // 경도
		        document.getElementById("lat").value=lat
		        document.getElementById("lng").value=lng
		        var coord = new kakao.maps.LatLng(lat, lng);
		        var callback = function(result, status) {
		            if (status === kakao.maps.services.Status.OK) {
		                console.log(result[0].region_1depth_name);
		                console.log(result[0].region_2depth_name);
		            }
		        }
		        geocoder.coord2RegionCode(coord.getLng(), coord.getLat(), callback);
		    })
		}
	}
</script>
<!-- <script>
let lat = 37.5566803113882;
let lng = 126.904501286522;
getAddr(lat,lng);
function getAddr(lat,lng){
    let geocoder = new kakao.maps.services.Geocoder();

    let coord = new kakao.maps.LatLng(lat, lng);
    let callback = function(result, status) {
        if (status === kakao.maps.services.Status.OK) {
            console.log(result);
        }
    }
    geocoder.coord2Address(coord.getLng(), coord.getLat(), callback);
}
</script> -->
</body>
</html>