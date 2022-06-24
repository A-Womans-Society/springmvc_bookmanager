<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서관리</title>
</head>
<body>
<h2>도서정보관리-도서추가</h2>
<form:form  action="add" modelAttribute="formdata" method="post" enctype="multipart/form-data">
<table border="1">
<tr>
<td colspan="3"><div style="text-align:right"><span style="color:red;"">*</span>표시는 필수 입니다</div></td>
</tr>
<tr>
	<td rowspan="6"  width= "150" height= "200"></td>
	<td><b><span style="color:red;"">*</span>BOOK ISBN</b></td><td><input type="text"  name="isbn"></td>
	<tr><td><b><span style="color:red;"">*</span>도서명</b></td><td><input type="text"  name="subject"></td></tr>
	<tr><td><b><span style="color:red;"">*</span>저자</b></td><td><input type="text" name="writer"></td></tr>
	<tr><td><b><span style="color:red;"">*</span>출판사</b></td><td><input type="text"  name="publisher"></td></tr>
	<tr><td><b><span style="color:red;"">*</span>도서 가격</b></td><td><input type="text"  name="price">원</td></tr>
	<tr><td><b><span style="color:red;"">*</span>이미지</b></td><td><input type="file" name="image"></td></tr>
</tr>	
<tr>
	<td><b><span style="color:red;"">*</span>책 소개</b></td>
	<td colspan="2"><textarea name="comment" cols="50" rows="10"></textarea></td>
</tr>
	
</table>
<input type="submit" value="도서정보 추가">
<a href="<c:url value='/list'/>"><input type="button" value="도서정보 목록"></a>

</form:form>

</body>
</html>