<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서 관리</title>
</head>
<body>
	<h2>도서정보관리-리스트</h2>
<div>
	<form:form action="search" method="get" modelAttribute="searchdata">
	<label>검색키워드 입력 :</label>
	<select name="type">
		<option value="subject">도서 제목</option>
		<option value="writer">저자</option>
	</select>
	<input type="text" name="keyword" placeholder="도서제목 또는 저자 입력"/>
	<input type="submit" value="찾기">
	</form:form>
</div>
	<br></br>
	<c:if test="${!empty books }">
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

			<c:forEach var="books" items="${books }">
				<tr>
					<td>${books.num}</td>
					<td><img width="100" height="150" 
						src="${pageContext.request.contextPath}/resources/fileupload/${books.image}" ></td>
					<td>${books.isbn}</td>
					<td><a href="<c:url value="/read/${books.num}"/>">${books.subject}</a></td>
					<td>${books.writer}</td>
					<td>${books.publisher}</td>
					<td>${books.price}원</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${empty books }">
		<table border="1">
			<tr>
				<td>등록된 도서가 없습니다.</td>
			</tr>
		</table>
	</c:if>
	<a href="<c:url value="/add"/>"><input type="button"
		value="도서정보 추가"></a>
</body>
</html>