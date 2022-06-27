<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관리</title>
<style>
span {
	color: red;
}

textarea {
	resize: none;
	width: 95%;
}
</style>
</head>
<body>
	<h1>도서정보관리-도서추가</h1>
	<table border="2">
		<tr>
			<td colspan="3" align="right"><span>*</span>표시는 필수 입니다.</td>
		</tr>
		<tr>
			<td align="center" rowspan="7">이미지넣기</td>
		</tr>
		<tr>
			<td><span>*</span>BOOK ISBN</td>
			<td><input type="text"></td>
		</tr>
		<tr>
			<td><span>*</span>도서명</td>
			<td><input type="text"></td>
		</tr>
		<tr>
			<td><span>*</span>저자</td>
			<td><input type="text"></td>
		</tr>
		<tr>
			<td><span>*</span>출판사</td>
			<td><input type="text"></td>
		</tr>
		<tr>
			<td><span>*</span>도서 가격</td>
			<td><input type="text"></td>
		</tr>
		<tr>
			<td><span>*</span>이미지</td>
			<td><input type="file"></td>
		</tr>
		<tr>
			<td><span>*</span>책 소개</td>
			<td colspan="3"><textarea rows="9" ></textarea>
		</tr>
	</table>
</body>
</html>
