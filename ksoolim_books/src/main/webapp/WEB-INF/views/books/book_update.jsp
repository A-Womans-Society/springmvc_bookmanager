<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관리</title>
</head>
<body>
	<h2>도서정보관리-도서정보수정</h2>
	<h1>글 번호 : ${books.num }</h1>
	<form:form action="update" modelAttribute="updatedata" method="post"
		enctype="multipart/form-data">
		<table border="1">
			<tr>
				<td colspan="3"><div style="text-align: right">
						<span style="color: red;">*</span>표시는 필수 입니다
					</div></td>
			</tr>
			<tr>
				<td rowspan="6" ><img width="230" height="280" 
						src="${pageContext.request.contextPath}/resources/fileupload/${books.image}" ></td>
				<td><b><span style="color: red;"">*</span>BOOK ISBN</b></td>
				<td><input type="text" name="isbn" value="${books.isbn}"></td>
			<tr>
				<td><b><span style="color: red;"">*</span>도서명</b></td>
				<td><input type="text" name="subject" value="${books.subject}"></td>
			</tr>
			<tr>
				<td><b><span style="color: red;"">*</span>저자</b></td>
				<td><input type="text" name="writer" value="${books.writer}"></td>
			</tr>
			<tr>
				<td><b><span style="color: red;"">*</span>출판사</b></td>
				<td><input type="text" name="publisher"
					value="${books.publisher}"></td>
			</tr>
			<tr>
				<td><b><span style="color: red;"">*</span>도서 가격</b></td>
				<td><input type="text" name="price" value="${books.price}">원</td>
			</tr>
			<tr>
				<td><b>이미지</b></td>
				<td>첨부파일 있음.<br>파일명:${books.image}</td>
			</tr>
			</tr>
			<tr>
				<td><b><span style="color: red;"">*</span>책 소개</b></td>
				<td colspan="2"><textarea name="comment" cols="50" rows="10">${books.comment}</textarea></td>
			</tr>

		</table>
		<input type="submit" value="수정완료">
		</a>
		<input type="button" onClick="history.go(-1)" value="취소">
		<input type="hidden" value="${books.num }" name="num">
	</form:form>

</body>
</html>