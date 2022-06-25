<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="true"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>BookBook | Home</title>
  <link rel="stylesheet" href="<c:url value='./resources/css/menu.css'/>">
  <link rel="stylesheet" href="<c:url value='./resources/css/home.css'/>">  
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
  if(msg=="LIST_ERR")  alert("도서 목록을 가져오는데 실패했습니다. 다시 시도해 주세요.");
  if(msg=="READ_ERR")  alert("삭제되었거나 없는 게시물입니다.");
  if(msg=="DEL_ERR")   alert("삭제되었거나 없는 게시물입니다.");
  if(msg=="DEL_OK")    alert("성공적으로 삭제되었습니다.");
  if(msg=="WRT_OK")    alert("성공적으로 등록되었습니다.");
  if(msg=="MOD_OK")    alert("성공적으로 수정되었습니다.");
</script>
	<div align="center" class="greet">
		<table>
		<tr><td>
			<h1>오늘도 BookBook을 찾아오셨군요! 반갑습니다🤗</h1>
		</td></tr>
		<tr><td>
			<h3>읽은 책의 정보를 등록하고 독후감을 작성해보세요!</h3>
		</td></tr>
		<tr><td>	
			<h3>지금까지 당신이 등록한 책은 ${cnt}권입니다.</h3>
		</td></tr>
		</table>
	</div>

</body>
</body>
</html>