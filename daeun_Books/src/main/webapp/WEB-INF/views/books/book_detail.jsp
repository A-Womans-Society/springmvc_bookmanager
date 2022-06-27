<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 관리</title>
<style>
td {
	text-align: center;
}

#imgTd {
	min-width: 350px;
	min-height: 435px;
	max-width: 350px;
	max-height: 435px;
}

.tdContent {
	min-width: 150px;
}
</style>
</head>
<body>
	<h3>도서정보관리 - 도서정보</h3>
	<form:form method="get">
		<table border="1">
			<tr>
				<td rowspan="5" id="imgTd"><img src="${pageContext.request.contextPath}/resources/uploadFiles/${book.saveFile}"
					style="width: 100%;"></td>
				<td><b>BOOK ISBN</b></td>
				<td class="tdContent">${book.isbn}</td>
			</tr>
			<tr>
				<td><b>도서명</b></td>
				<td class="tdContent">${book.title}</td>
			</tr>
			<tr>
				<td><b>저자</b></td>
				<td class="tdContent">${book.writer}</td>
			</tr>
			<tr>
				<td><b>출판사</b></td>
				<td class="tdContent">${book.publisher}</td>
			</tr>
			<tr>
				<td><b>도서 가격</b></td>
				<td class="tdContent">${book.price}원</td>
			</tr>
			<tr>
				<td><b>책소개</b></td>
				<td colspan="3" class="tdContent">${book.introduce}</td>
			</tr>
		</table>
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/books/list'">도서정보
			목록</button>
	</form:form>
</body>
</html>