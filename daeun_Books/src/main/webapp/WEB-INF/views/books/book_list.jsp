<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 조회</title>
<style type="text/css">
table {
	min-width: 80%;
	text-align: center;
}
</style>
</head>
<body>
	<h3>도서정보관리 - 리스트</h3>

	<form action="${pageContext.request.contextPath}/books/search">
		검색 키워드 입력: <select name="type">
			<option value="title">제목</option>
			<option value="writer">저자</option>
			<option value="publisher">출판사</option>
		</select> 
		<input type="text" name="keyword" placeholder="도서제목 또는 저자 입력">
		<input type="submit" value="찾기">
	</form>

	<table border="1">
		<tr>
			<th>등록 번호</th>
			<th>도서 표지</th>
			<th>도서 ISBN</th>
			<th>도서 제목</th>
			<th>저자</th>
			<th>출판사</th>
			<th>가격</th>
		</tr>
		<c:if test="${empty books}">
		<tr>
			<td colspan="7">검색 결과가 없습니다.</td>
		</tr>
		</c:if>
		<c:forEach var="book" items="${books}" varStatus="status">
			<tr style="height: 150px;">
				<td>${book.id}</td>
				<td><img
					src="${pageContext.request.contextPath}/resources/uploadFiles/${book.saveFile}"
					width="120" height="150" alt="이미지를 찾을 수 없습니다."></td>
				<td>${book.isbn}</td>
				<td><a href="<c:url value='/books/read/${book.id}'/>">
						${book.title}</a></td>
				<td>${book.writer}</td>
				<td>${book.publisher}</td>
				<td>${book.price}원</td>
		</c:forEach>
	</table>
	<button type="button"
		onclick="location.href='${pageContext.request.contextPath}/books/add'">도서정보
		추가</button>
	<button type="button"
		onclick="location.href='${pageContext.request.contextPath}/books/list'">도서정보
		목록</button>
</body>
</html>