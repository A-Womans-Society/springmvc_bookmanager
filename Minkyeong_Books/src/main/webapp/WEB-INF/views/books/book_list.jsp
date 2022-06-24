<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관리</title>
<style>
a {
	text-decoration: none;
}
img {
   width:100px;
   height:100px;
   object-fit:contain;
   }
</style>
<!-- a태그는 밑줄 제거 -->
</head>
<body>
	<h2>도서정보관리 - 리스트</h2>
	<form:form action="./search" modelAttribute="formData" method="get">
		<table border="1" width="100%">
			<tr>
				<td align="left">검색키워드 입력 : <input type="text" placeholder ="도서제목 또는 저자 입력"
					name="keyword" /> <input type="submit" value="검색하기" /></td>
			</tr>
		</table>
	</form:form>
	<!-- 목록 테이블 -->
	<table border="1" width="100%" heigth="50%">
		<tr>
			<th width="5%">등록 번호</th>
			<th width="5%">도서 표지</th>
			<th width="10%">도서 ISBN</th>
			<th width="15%">도서 제목</th>
			<th width="15%">저자</th>
			<th width="15%">출판사</th>
			<th width="10%">가격</th>
		</tr>
		<c:forEach items="${list}" var="list" varStatus="status">
			<tr align="center">
				<td>${status.count}</td>
				<td><img src="${pageContext.request.contextPath}/resources/upload/${list.image}">
				</td>
				<td>${list.bookisbn}</td>
				<td align="left"><a
					href="<c:url value="/books/read/${list.idx}"/>"> ${list.book}</a></td>
				<td>${list.writer}</td>
				<td>${list.publishing}</td>
				<td>${list.price}원</td>
			</tr>
		</c:forEach>
	</table>
	<!-- 주소에 jsp 파일 금지, url로 도메인 매핑 -->
	<tr>
		<td width="100%">
			<td><button type="button"
						onclick="location.href='${pageContext.request.contextPath}/books/add';">
						도서정보 추가</button></td>
	</tr>
</body>
</html>