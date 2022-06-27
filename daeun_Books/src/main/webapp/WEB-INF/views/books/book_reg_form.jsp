<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>책 등록</title>
	<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
	<style type="text/css">
		span {
			color: red;
		}
	</style>
</head>
<body>
	<h3>도서정보관리 - 도서추가</h3>
	<form:form id="form" action="add" modelAttribute="formData"
		enctype="multipart/form-data" method="post" onsubmit="return validate();">
		<table border="1">
			<tr>
				<td colspan="3" align="right"><span>*</span>표시는 필수입니다.</td>
			</tr>
			<tr>
				<td rowspan="6" width="200" height="250" id="imgTd"><img
					id="book_image" style="width: 100%; height: 100%;"></td>
				<td><b><span>*</span>BOOK ISBN</b></td>
				<td><form:input path="isbn" /><br /> <span>
				<form:errors path="isbn"/></span></td>
			</tr>
			<tr>
				<td><b><span>*</span>도서명</b></td>
				<td><form:input path="title" /><br/>
					<form:errors path="title"/>
				</td>
				
			</tr>
			<tr>
				<td><b><span>*</span>저자</b></td>
				<td><form:input path="writer" /><br/>
					<form:errors path="writer"/></td>
			</tr>
			<tr>
				<td><b><span>*</span>출판사</b></td>
				<td><form:input path="publisher" /><br/>
					<form:errors path="publisher"/></td>
			</tr>
			<tr>
				<td><b><span>*</span>도서 가격</b></td>
				<td><form:input path="price" />
					<br/><form:errors path="price"/></td>
			</tr>
			<tr>
				<td><b><span>*</span>이미지</b></td>
				<td><input type="file" name="image" id="file" accept="image/*"
					onchange="PreviewImage();" /><br/>
 					<%-- <form:errors path="image"/> --%>
 					</td>
			</tr>
			<tr>
				<td><b><span>*</span>책소개</b></td>
				<td colspan="2">
				<textarea rows="10" cols="47" style="resize: none;" name="introduce" id="introduce"></textarea><br/>
					<form:errors path="introduce"/></td>
			</tr>
		</table>

		<input type="submit" value="등록 완료">
		<button type="button" onclick="location.href='${pageContext.request.contextPath}/books/list'">
		도서정보목록</button>
	</form:form>
<script>
	function PreviewImage() {
		var preview = new FileReader();
		preview.onload = function(e) {
			document.getElementById("book_image").src = e.target.result;
		};
		preview.readAsDataURL(document.getElementById("file").files[0]);
	};
	
	function validate(form) {
		if ( $('#file').val()=='' ) {
			alert("도서표지사진(png/jpeg)을 첨부해 주세요.") ;
			return false ;
			}
		return true;
	}

</script>
</body>
</html>
