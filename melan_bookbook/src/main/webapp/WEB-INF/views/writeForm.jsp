<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>BookBook | 도서등록하기</title>
  <link rel="stylesheet" href="<c:url value='../resources/css/menu.css'/>">
  <link rel="stylesheet" href="<c:url value='../resources/css/write.css'/>">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>
<body>
<div id="menu">
  <ul id="menuItem">
    <li id="logo">BookBook : 나의 독서생활도우미</li>
    <li><a href="<c:url value='/'/>">Home</a></li>
    <li><a href="<c:url value='/book/list'/>">Booklist</a></li>
    <li><a href="<c:url value='/book/write'/>">Register</a></li>
  </ul>
</div>
<script>
  let msg = "${msg}";
  if(msg=="WRT_ERR") alert("게시물 등록에 실패하였습니다. 다시 시도해 주세요.");
  if(msg=="MOD_ERR") alert("게시물 수정에 실패하였습니다. 다시 시도해 주세요.");
</script>
<div class="container">
  <h2 class="writing-header">도서 등록하기</h2>
  <form:form id="form" class="frm" enctype="multipart/form-data" action="write" method="post" modelAttribute="book">
    <input type="hidden" name="num" value="${book.num}"><br>
    <table width=100%>
    	<tr>
    		<td rowspan="6" width="40%"><input id="file" name="image" type="file" accept="image/*" required></td>
    	</tr>
    	<tr>
    		<td id="isbn"><form:label path="isbn">도서 ISBN</form:label></td>
    		<td><form:input path="isbn" size="20" placeholder="  도서 ISBN을 입력하세요."/><br/>
    		<form:errors cssStyle="color: red;" path="isbn" /></td>
    	</tr>
    	<tr>
    		<td id="name"><form:label path="name">도서명</form:label></td>
    		<td><form:input path="name" size="20" placeholder="  도서명을 입력해 주세요."/><br/>
    		<form:errors cssStyle="color: red;" path="name" /></td>
    	</tr>
    	<tr>
    		<td><form:label path="author">저자명</form:label></td>
    		<td><form:input path="author" size="20" placeholder="  저자명을 입력해 주세요."/><br/>
    		<form:errors cssStyle="color: red;" path="author" /></td>
    	</tr>
    	<tr>
    		<td><form:label path="publisher">출판사</form:label></td>
    		<td><form:input path="publisher" size="20" placeholder="  출판사를 입력해 주세요." /><br/>
    		<form:errors cssStyle="color: red;" path="publisher" /></td>
    	</tr>
    	<tr>
    		<td><form:label path="price">도서가격</form:label></td>
    		<td><form:input path="price" size="20" placeholder="  도서가격을 입력해 주세요."/><br/>
    		<form:errors cssStyle="color: red;" path="price" /></td>
    	</tr>
    	<tr><td><form:label path="content">독후감</form:label><form:errors cssStyle="color: red;" path="content"/></td></tr>
    	<tr><td colspan="3">
    		<form:textarea path="content" cols="30" rows="20" placeholder="  책 소개글이나 독후감을 입력해 주세요."/><br/>
    	</td></tr>
    </table>
    <div id="btns">
			<button type="button" id="writeBtn" class="btn btn-write"><i class="fa fa-pencil"></i> 등록하기</button>
			<button type="reset" class="btn btn-reset"><i class="fa fa-trash"></i>초기화</button>
			<button type="button" id="listBtn" class="btn btn-list"><i class="fa fa-bars"></i> 목록보기</button>
	</div>
  </form:form>
</div>
<script>
  $(document).ready(function(){
    let formCheck = function() { // 폼 검증
      let form = document.getElementById("form");
      let fileChk = document.getElementById("file");
      if(form.isbn.value=="") {
        alert("도서 ISBN을 입력해 주세요.");
        form.isbn.focus();
        return false;
      }
      if(form.name.value=="") {
        alert("도서명을 입력해 주세요.");
        form.name.focus();
        return false;
      }
      if(form.author.value=="") {
          alert("저자명을 입력해 주세요.");
          form.author.focus();
          return false;
      }
      if(form.publisher.value=="") {
          alert("출판사명을 입력해 주세요.");
          form.publisher.focus();
          return false;
      }
      if(form.price.value=="") {
          alert("도서가격을 입력해 주세요.");
          form.price.focus();
          return false;
      }
      if(form.content.value=="") {
          alert("독후감을 입력해 주세요.");
          form.content.focus();
          return false;
      }
      if (!fileChk.value) {
    	  alert("도서표지사진(png/jpeg)을 첨부해 주세요.");
    	  return false;
      }
      return true;
    }
    $("#writeBtn").on("click", function(){ // 등록하기 클릭 시
      let form = $("#form");
      form.attr("action", "<c:url value='/book/write'/>");
      form.attr("method", "post");
      if(formCheck())
        form.submit();
    });
    $("#listBtn").on("click", function(){ // 목록보기 클릭 시
      location.href="<c:url value='/book/list${searchCondition.queryString}'/>";
    });
  });
</script>
</body>
</html>