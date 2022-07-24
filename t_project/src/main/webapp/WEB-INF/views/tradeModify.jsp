<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
function radio(){
	var radioValue = ${cate }
	$(radioValue).prop("checked",true);
}
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
<form action="modifyAdmit" id="trademodify" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title" id="title" required value="${title }"></td>
			</tr>
			<tr>
				<th>사진 업로드</th>
				<td><input type="file" name="image_addr" id="image_addr"
					onchange="readURL(this);" value="${image_addr }"></td>
				<td><img id="preview" src="displayFile?fileName=${image_addr}&directory=thumbnail" height=100px width=100px
					alt="선택한 이미지가 없습니다">
			</tr>
			<tr>
				<th>내용</th>
				<td><textarea form="trademodify" required name="content"
						id="content">${content }</textarea></td>
			</tr>
			<tr>
				<th>가격</th>
				<td><input type="text" name="price" id="price" required value="${price }"></td>
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
		<input type="submit" value="작성">
		<input type="text" value="${image_addr }" name="og_img" id="og_img" hidden>
		<input type="text" value="${write_no }" name="write_no" id="write_no" hidden>
</form>
</body>
</html>