<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
	integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
	crossorigin="anonymous">
<script>
	function PreviewImage() {
		var preview = new FileReader();
		preview.onload = function(e) {
			document.getElementById("book_image").src = e.target.result;
		};
		preview.readAsDataURL(document.getElementById("img").files[0]);
	};
</script>
</head>
<body>
	<div class="fluid-container">
		<div class="row justify-content-center text-center">
			<div class="col-7">
				<h1>도서정보관리-도서추가</h1>
				<form:form action="/books/add" method="post"
					enctype="multipart/form-data" modelAttribute="formData">
					<table border="2" class="table">
						<tr>
							<td colspan="3" align="right"><span>*</span>표시는 필수 입니다.</td>
						</tr>
						<tr>
							<td align="center" rowspan="7" id="imgTd" style="width: 50%;"><img
								id="book_image" alt="이미지를 선택해주세요."
								style="max-height: 300px; height: 100%;" /></td>
						</tr>
						<tr>
							<th class="table-active"><span>*</span>BOOK ISBN</th>
							<td><form:input path="bookIsbn" /><br /> <form:errors
									path="bookIsbn" /></td>
						</tr>
						<tr>
							<th class="table-active"><span>*</span>도서명</th>
							<td><form:input path="title" /><br /> <form:errors
									path="title" /></td>
						</tr>
						<tr>
							<th class="table-active"><span>*</span>저자</th>
							<td><form:input path="author" /><br /> <form:errors
									path="author" /></td>
						</tr>
						<tr>
							<th class="table-active"><span>*</span>출판사</th>
							<td><form:input path="publisher" /><br /> <form:errors
									path="publisher" /></td>
						</tr>
						<tr>
							<th class="table-active"><span>*</span>도서 가격</th>
							<td><form:input path="price" /><br /> <form:errors
									path="price" /></td>
						</tr>
						<tr>
							<th class="table-active"><span>*</span>이미지</th>
							<td><input type="file" name="img" id="img"
								onchange="PreviewImage();" /></td>
						</tr>
						<tr>
							<th class="table-active"><span>*</span>책 소개</th>
							<td colspan="3"><textarea rows="3" name="content"
									style="border: none;">${formData.content }</textarea><br /> <form:errors
									path="content" />
						</tr>
					</table>
					<input type="submit" value="도서정보 추가">
					<input type="button" value="도서정보 목록"
						onclick="document.location.href='/books/list'">
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>

