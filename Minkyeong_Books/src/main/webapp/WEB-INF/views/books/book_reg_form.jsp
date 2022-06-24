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
<style type="text/css">
textarea {
	width: 100%;
	resize: none;
}
img {
   width:200px;
   height:200px;
   object-fit:contain;
   }
</style>
<script>
	function PreviewImage() {
		var preview = new FileReader();
		preview.onload = function(e) {
			document.getElementById("book_image").src = e.target.result;
		};
		preview.readAsDataURL(document.getElementById("image").files[0]);
	};
</script>
</head>
<body>
	<!--  작성완료가 되면 목록보기로 이동되어야 함. -->
	<h2>도서정보관리-도서추가</h2>

	<form:form action="add" modelAttribute="formData"
		enctype="multipart/form-data" method="post">
		<table border="1" width="600">
			<tr>
				<td colspan="3" align="right" style="border: none;">*표시는 필수입니다.</td>
			</tr>
			<tr>
				<td rowspan="7" width="200" height="150" >
				<img id="book_image"></td>
			<tr>
				<td><strong>*BOOK ISBN</strong></td>
				<td><input type="text" name="bookisbn" /> <span>
				<form:errors path="isbn" /></span></td>
			</tr>
			<tr>
				<td><strong>*도서명</strong></td>
				<td><input type="text" name="book" /></td>
			</tr>
			<tr>
				<td><strong>*저자</strong></td>
				<td><input type="text" name="writer" /></td>
			</tr>
			<tr>
				<td><strong>*출판사</strong></td>
				<td><input type="text" name="publishing" /></td>
			</tr>
			<tr>
				<td><strong>*도서가격</strong></td>
				<td><input type="text" name="price" /></td>
			</tr>
			<tr>
				<td><b>*이미지</b></td>
				<td><input type="file" name="image" id="image"
					onchange="PreviewImage();"/></td>
			</tr>
			<tr>
				<td>책 소개</td>
				<td colspan="3" height="150"><textarea name="content"
						style="border: none;"></textarea></td>
			</tr>
		</table>
		<button type="submit">도서정보 추가</button>
		<button type="button"
			onclick="location.href='${pageContext.request.contextPath}/books/list';">
			도서정보 목록</button>
	</form:form>
</body>
</html>