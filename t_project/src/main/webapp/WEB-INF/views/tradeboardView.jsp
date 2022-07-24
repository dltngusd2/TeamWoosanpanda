<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	var number = null;
	function show(clicked_id) {
		if (number != null) {
			document.getElementById(number).style.display = "none";
			number = null;
		}
		number = "n" + clicked_id;
		document.getElementById(number).style.display = "block";
	}
	function modify(){
		window.location.href="tradeModify?write_no=${write_no}"
	}
	function deletes(){
		window.location.href="tradeDelete?write_no=${write_no}"
	}
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<table>
		<tr>
			<th>이미지</th>
			<td><img id="profileImg"
				src="displayFile?fileName=${image_addr}&directory=thumbnail"></td>
		</tr>
		<tr>
			<th>글 번호</th>
			<td>${write_no }</td>
		<tr>
			<th>제목</th>
			<td>${title }</td>
		</tr>
		<tr>
			<th>내용</th>
			<td>${content }</td>
		</tr>
		<tr>
			<th>주소</th>
			<td>${addr }${addr2 }</td>
		</tr>
		<tr>
			<th>카테고리</th>
			<td>${cate }</td>
		</tr>
		<tr>
			<th>가격</th>
			<td>${price }</td>
		</tr>
		<c:if test="${id eq 'admin' }">
			<tr>
				<th><input type="button" onclick="modify()" value="수정"><input
					type="button" onclick="deletes()" value="삭제"></th>
			</tr>
		</c:if>
	</table>
	<hr>
	<table id="reply">
		<c:if test="${empty list}">
			<tr>
				<th>작성된 댓글이 없습니다</th>
			</tr>
		</c:if>
		<c:if test="${not empty list }">
			<c:forEach var="dto" items="${list}">
				<c:if test="${dto.reply_level eq 1 }">
					<tr>
						<th colspan="3">대댓글</th>
					</tr>
				</c:if>
				<tr>
					<th>글쓴이</th>
					<td>${dto.id }</td>
				</tr>
				<c:if test="${dto.reply_level eq 0 }">
					<tr>
						<th>별점</th>
						<td>${dto.rate }</td>
					</tr>
				</c:if>
				<tr>
					<th>내용</th>
					<td>${dto.content }</td>
				</tr>
				<tr>
					<th>작성시간</th>
					<td>${dto.date }</td>
				</tr>
				<c:if test="${dto.reply_level eq 0 }">
					<tr>
						<th><button id="${dto.seq }" onclick="show(this.id)">대댓글달기</button></th>
					</tr>
					<tr style="display: none;" id="n${dto.seq }">
						<th>대댓글 달기</th>
						<td><form
								action="writeReply?level=1&reply_chkNum=${dto.reply_chkNo }&reply_no=${dto.reply_no}"
								method="post">
								<input type="text" name="content" id="content"><input
									type="submit" value="작성"> <input type="hidden"
									name="write_no" id="write_no" value="${write_no }">
							</form></td>
					</tr>
				</c:if>
			</c:forEach>
		</c:if>
	</table>
	<form action="writeReply?level=0" method="post" id="tradereply">
		<table>
			<tr>
				<th>별점</th>
				<td><input type="radio" value="1" name="rate" id="rate">1점
					<input type="radio" value="2" name="rate" id="rate">2점 <input
					type="radio" value="3" name="rate" id="rate">3점 <input
					type="radio" value="4" name="rate" id="rate">4점 <input
					type="radio" value="5" name="rate" id="rate">5점</td>
			</tr>
			<tr>
				<th>내용
				<td><textarea form="tradereply" name="content" id="content"
						placeholder="내용을 작성해주세요"></textarea></td>
			</tr>
			<tr>
				<th><input type="submit" value="작성">
			</tr>
		</table>
		<input type="hidden" name="write_no" id="write_no"
			value="${write_no }"> <input type="hidden" name="reply_no"
			id="reply_no" value="${max_replyno +1}"> <input type="hidden"
			name="reply_chkNum" id="reply_chkNum" value="0">
	</form>


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