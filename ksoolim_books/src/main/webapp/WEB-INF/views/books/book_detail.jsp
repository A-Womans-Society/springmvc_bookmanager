<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관리</title>
</head>
<body>
<h2>도서정보관리-도서정보</h2>
<table border="1">

<tr>
	<td rowspan="5">
		<img width= "230" height= "280" src="${pageContext.request.contextPath}/resources/fileupload/${books.image}" ></td>
	<td><b>BOOK ISBN</b></td><td>${books.isbn}</td>
	<tr><td><b>도서명</b></td><td>${books.subject}</td></tr>
	<tr><td><b>저자</b></td><td>${books.writer}</td></tr>
	<tr><td><b>출판사</b></td><td>${books.publisher}</td></tr>
	<tr><td><b>도서 가격</b></td><td>${books.price}원</td></tr>
	
</tr>	
<tr>
	<td><b>책 소개</b></td>
	<td colspan="2">${books.comment}</td>
</tr>
	
</table>
<a href="<c:url value='/update?num=${books.num }'/>"><input type="button" value="수정"></a>
<a href="<c:url value='/delete?num=${books.num }'/>"><input type="button" value="삭제"></a>
<a href="<c:url value='/list'/>"><input type="button" value="도서정보 목록"></a>
</body>
</html>