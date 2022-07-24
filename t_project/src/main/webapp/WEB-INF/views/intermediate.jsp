<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<script>
function intermediate(){
	var check = ${status };
	if(check==1){
		window.location.href="tradeboard";
	}
	if(check==0){
		window.location.href="tradeboardView?write_no=${write_no}";
	}
	if(check == null){
		alert("잘못된 접근입니다");
		window.location.href="tradeboard";
	}
}
intermediate()</script>
</body>
</html>