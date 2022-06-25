<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="true"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>BookBook | 도서목록</title>
  <link rel="stylesheet" href="<c:url value='../resources/css/menu.css'/>">
  <link rel="stylesheet" href="<c:url value='../resources/css/list.css'/>">
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
<div style="text-align:center">
  <div class="board-container">
    <div class="search-container">
      <form action="<c:url value="/book/list"/>" class="search-form" method="get">
        <select class="search-option" name="option">
<%--           <option value="A" ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>도서명+설명</option> --%>
          <option value="I" ${ph.sc.option=='I' ? "selected" : ""}>ISBN</option>
          <option value="N" ${ph.sc.option=='N' ? "selected" : ""}>도서명</option>
          <option value="A" ${ph.sc.option=='A' ? "selected" : ""}>저자명</option>
        </select>

        <input type="text" name="keyword" class="search-input" type="text" value="${ph.sc.keyword}" placeholder="검색어를 입력해주세요">
        <input type="submit" class="search-button" value="검색">
      </form>
      <button id="writeBtn" class="btn-write" onclick="location.href='<c:url value="/book/write"/>'"><i class="fa fa-pencil"></i> 글쓰기</button>
    </div>

    <table>
      <tr>
        <th class="no">No.</th>
        <th class="image">도서표지</th>
        <th class="ISBN">도서 ISBN</th>
        <th class="name">도서명</th>
        <th class="author">저자</th>
        <th class="publisher">출판사</th>
        <th class="price">가격</th>
      </tr>
      <c:forEach var="book" items="${bookList}" varStatus="status">
        <tr>
          <td class="no">${ph.sc.pageSize*(ph.sc.page-1)+1 + status.index}</td> <!-- 행 번호 -->
          <td class="image"> <!-- 도서 표지 -->
		  	<img style="width:100px; height:auto;" src="${pageContext.request.contextPath}/${book.sfile}" /> <!-- 이미지 파일 경로 -->
	      </td>
          <td class="ISBN">${ book.isbn }</td> <!-- 도서 ISBN -->
          <td class="name"><a href="<c:url value="/book/read${ph.sc.queryString}&num=${book.num}"/>">${book.name}</a></td> <!-- 도서명 -->
          <td class="author">${ book.author }</td> <!--저자명-->
		  <td class="publisher">${ book.publisher }</td> <!-- 출판사 -->
		  <td class="price">${ book.price }</td> <!-- 도서가격 -->
        </tr>
      </c:forEach>
    </table>
    <br>
    <div class="paging-container">
      <div class="paging">
        <c:if test="${totalCnt==null || totalCnt==0}">
          <div> 게시물이 없습니다. </div>
        </c:if>
        <c:if test="${totalCnt!=null && totalCnt!=0}">
          <c:if test="${ph.showPrev}">
            <a class="page" href="<c:url value="/book/list${ph.sc.getQueryString(ph.beginPage-1)}"/>">&lt;</a>
          </c:if>
          <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
            <a class="page ${i==ph.sc.page? "paging-active" : ""}" href="<c:url value="/book/list${ph.sc.getQueryString(i)}"/>">${i}</a>
          </c:forEach>
          <c:if test="${ph.showNext}">
            <a class="page" href="<c:url value="/book/list${ph.sc.getQueryString(ph.endPage+1)}"/>">&gt;</a>
          </c:if>
        </c:if>
      </div>
    </div>
  </div>
</div>
</body>
</html>