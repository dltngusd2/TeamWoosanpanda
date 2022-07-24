<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<meta charset="utf-8">
<title>Insert title here</title>

<script type="text/javascript">
	function readURL(input) {
		var file = input.files[0]
		if (file != '') {
			var reader = new FileReader();
			reader.readAsDataURL(file);
			reader.onload = function(e) {
				$('#preview').attr('src', e.target.result);
			}
		}
	}
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<form action="writeAdmit" id="tradeWrite" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" id="title" required></td>
			</tr>
			<tr>
				<th>사진 업로드</th>
				<td><input type="file" name="image_addr" id="image_addr"
					onchange="readURL(this);"></td>
				<td><img id="preview" src="#" height=100px width=100px
					alt="선택한 이미지가 없습니다">
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea form="tradeWrite" required name="content"
						id="content"></textarea></td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input type="text" name="price" id="price" required></td>
			</tr>
			<tr>
				<th>카테고리</th>
				<td><input type="radio" value="1" id="cate" name="cate">1.
					가전제품 <input type="radio" value="2" id="cate" name="cate">2.
					운동용품 <input type="radio" value="3" id="cate" name="cate">3.
					사무용품 <input type="radio" value="4" id="cate" name="cate">4.
					주방용품 <input type="radio" value="5" id="cate" name="cate">5.
					취미용품</td>
		</table>
		<input type="hidden" value=${id } name="id" id="id"> <input
			type="text" name="addr" id="addr"> <input type="text"
			name="addr2" id="addr2"> <input type="button"
			value="기존 주소 사용" onclick="memberAddr()"> <input type="button"
			value="현재 주소 사용" onclick="getAddrs()"> <input type="submit"
			value="작성">
	</form>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=ed445263dd16bda07760fb634155a272&libraries=services"></script>
	<script>
		function getAddrs() {
			var geocoder = new kakao.maps.services.Geocoder();
			// HTML5의 geolocation으로 사용할 수 있는지 확인합니다 
			if (navigator.geolocation) {

				// GeoLocation을 이용해서 접속 위치를 얻어옵니다
				navigator.geolocation
						.getCurrentPosition(function(position) {

							var lat = position.coords.latitude, // 위도
							lng = position.coords.longitude; // 경도
							var coord = new kakao.maps.LatLng(lat, lng);
							var callback = function(result, status) {
								if (status === kakao.maps.services.Status.OK) {
									document.getElementById("addr").value = result[0].region_1depth_name
									document.getElementById("addr2").value = result[0].region_2depth_name
								}
							}
							geocoder.coord2RegionCode(coord.getLng(), coord
									.getLat(), callback);
						})
			}
		}
		function memberAddr() {
			document.getElementById("addr").value = "서울특별시"
			document.getElementById("addr2").value = "종로구"
		}
	</script>

	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
	<!-- Bootstrap core CSS -->
	<link rel="stylesheet"
		href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
		integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
		crossorigin="anonymous">
</body>
</html>