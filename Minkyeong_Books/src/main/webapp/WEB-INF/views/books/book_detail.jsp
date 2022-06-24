<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서정보관리</title>
<style type="text/css">
img {
   width:150px;
   height:150px;
   object-fit:contain;
   }
</style>
</head>
<body>
	<h2>도서정보관리-도서정보</h2>
	<form action="<c:url value="/books/list"/>" method="get">
		<table border="1" width="500" height="300">
			<colgroup>
				<col width="15%" />
				<col width="20%" />
				<col width="*" />
			</colgroup>
		<tr>
			<td align="center" rowspan="6" >
	<img src="${pageContext.request.contextPath}/resources/upload/${bookDto.image}"></td>
		</tr>
		<tr>
			<td><strong>BOOK ISBN</strong></td>
			<td>${bookDto.bookisbn}</td>
		</tr>
		<tr>
			<td><strong>도서명</strong></td>
			<td>${bookDto.book}</td>
		</tr>
		<tr>
			<td><strong>저자</strong></td>
			<td>${bookDto.writer}</td>
		</tr>
		<tr>
			<td><strong>출판사</strong></td>
			<td>${bookDto.publishing}</td>
		</tr>
		<tr>
			<td><strong>도서가격</strong></td>
			<td>${bookDto.price}원</td>
		</tr>
	</table>
	
	<table border="2" width="500" height="70">
		<tr>
			<td><strong>책 소개</strong></td>
			<td>${bookDto.content}</td>
		</tr>
	</table>
<br>
		<tr>
		<tr>
			<td><button type="button" onclick ="location.href='${pageContext.request.contextPath}/books/list';">도서정보 목록
				</button></td>
		</tr>
	</form>
</body>
</html>