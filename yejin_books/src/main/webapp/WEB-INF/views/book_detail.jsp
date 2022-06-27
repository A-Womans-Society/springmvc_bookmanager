<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>도서관리</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
</head>
<body>
	<div class="fluid-container">
		<div class="row justify-content-center text-center">
			<div class="col-7">
				<h1>도서정보관리-도서정보</h1>

				<table border="2" class="table">
					<tr>
						<td style="width: 50%;" align="center" rowspan="6" width="200"
							height="250" id="imgTd"><image
								src="/resources/uploadFiles/${book.img }" /></td>
					</tr>
					<tr>
						<th class="table-active">BOOK ISBN</th>
						<td>${book.bookIsbn }</td>
					</tr>
					<tr>
						<th class="table-active">도서명</th>
						<td>${book.title }</td>
					</tr>
					<tr>
						<th class="table-active">저자</th>
						<td>${book.author }</td>
					</tr>
					<tr>
						<th class="table-active">출판사</th>
						<td>${book.publisher }</td>
					</tr>
					<tr>
						<th class="table-active">도서 가격</th>
						<td>${book.price }원</td>
					</tr>
					<tr style="height: 130px;">
						<th class="table-active">책 소개</th>
						<td colspan="3">${book.content }</textarea>
					</tr>
				</table>

				<input type="button" value="도서정보 목록"
					onclick="document.location.href='/books/list'">
			</div>
		</div>
	</div>

</body>
</html>
