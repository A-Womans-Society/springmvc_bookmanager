<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
			<div class="col-9">
				<h1 class="pb-3 pt-5">도서정보관리-리스트</h1>
				<div class="d-flex pb-3 justify-content-around">
					<form:form action="/books/list" method="post"
						modelAttribute="searchCommand">
		검색 키워드 입력 : 


			<c:if test="${empty keyword }">
							<input type="text" name="keyword" placeholder="도서제목 또는 저자 입력">
						</c:if>
						<c:if test="${not empty keyword }">
							<input type="text" name="keyword" value="${keyword }">
						</c:if>
						<form:select path="category">
							<form:option value="publisher">출판사</form:option>
							<form:option value="title">제목</form:option>
							<form:option value="author">저자</form:option>
						</form:select>
						<input type="submit" value="찾기">
						<input type="button" value="전체 보기"
							onclick="location.href='/books/list'">
					</form:form>
					<input type="button" value="도서 정보 추가"
						onclick="document.location.href='/books/add'">
				</div>

				<table border="2" class="table table-striped">
					<thead class="thead-dark">
						<tr>
							<th style="width: 7%;">등록 번호</th>
							<th style="width: 20%;">도서 표지</th>
							<th style="width: 12%;">도서 ISBN</th>
							<th style="width: 10%;">도서 제목</th>
							<th style="width: 10%;">저자</th>
							<th style="width: 10%;">출판사</th>
							<th style="width: 14%;">가격</th>
						</tr>
					</thead>
					<tbody>
						<c:if test="${empty list}">
							<tr height="300px">
								<td colspan="8" align="center">등록된 정보가 없습니다.</td>
							</tr>
						</c:if>
						<c:if test="${not empty list }">
							<c:forEach var="book" items="${list }" varStatus="status">
								<tr style="cursor: pointer;"
									onClick="location.href='/books/read/${book.no}'" height="150px"
									class="align-middle">
									<td class="align-middle">${status.count }</td>

									<%-- 					<img src="/resources/uploadFiles/${book.img }" onerror="this.src='/resources/uploadFiles/noImg.jpg'" />--%>
									<td><img src="/resources/uploadFiles/${book.img }"
										alt="이미지를 찾을 수 없습니다." style="width: 100px;" /></td>
									<td class="align-middle">${book.bookIsbn }</td>
									<td class="align-middle">${book.title }</td>
									<td class="align-middle">${book.author }</td>
									<td class="align-middle">${book.publisher }</td>
									<td class="align-middle">${book.price }원</td>
								</tr>
							</c:forEach>
						</c:if>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
