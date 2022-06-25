<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page session="true"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>BookBook | 도서상세정보</title>
  <link rel="stylesheet" href="<c:url value='../resources/css/menu.css'/>">
  <link rel="stylesheet" href="<c:url value='../resources/css/detail.css'/>">
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
  <h2 class="writing-header">도서정보 상세보기</h2>
  <form id="form" class="frm" enctype="multipart/form-data" action="" method="post">
    <input type="hidden" name="num" value="${book.num}"><br>
    <table width=100%>
    	<tr>
    		<td rowspan="6" width="40%">
    			<img style="width:90%; height:auto;" src="${pageContext.request.contextPath}/${book.sfile}" /><br/>
    			<span id="filemodify" style="font-size:small; color:darkblue; display:none;">▼ 도서표지를 바꾸려면 새로운 파일 선택(1개만 가능)<input type="file" name="image"></span> <%-- 원래 안 보이는 상태 --%>
    		</td>
    	</tr>
    	<tr>
    		<td id="isbn" width="90px" margin-right="30px" margin-left="30px">도서 ISBN</td>
    		<td><input name="isbn" type="text" value="${book.isbn}" placeholder="  도서 ISBN을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}></td>
    	</tr>
    	<tr>
    		<td>도서명</td>
    		<td><input name="name" type="text" value="${book.name}" placeholder="  도서명을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}></td>
    	</tr>
    	<tr>
    		<td>저자명</td>
    		<td><input name="author" type="text" value="${book.author}" placeholder="  저자명을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}></td>
    	</tr>
    	<tr>
    		<td>출판사</td>
    		<td><input name="publisher" type="text" value="${book.publisher}" placeholder="  출판사를 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}></td>
    	</tr>
    	<tr>
    		<td>도서가격</td>
    		<td><input name="price" type="text" value="${book.price}" placeholder="  도서가격을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}></td>
    	</tr>
    	<tr><td>독후감</td></tr>
    	<tr><td colspan="3">
    		<textarea name="content" rows="10" placeholder=" 내용을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}>${book.content}</textarea>
    	</td></tr>
    </table>
    <div id="btns">
      		<button type="button" id="modifyBtn" class="btn btn-modify"><i class="fa fa-edit"></i> 수정하기</button>
      		<button type="button" id="removeBtn" class="btn btn-remove"><i class="fa fa-trash"></i> 삭제하기</button>
			<button type="button" id="listBtn" class="btn btn-list"><i class="fa fa-bars"></i> 목록보기</button>
	</div>
  </form>
</div>
<script>
  $(document).ready(function(){
    let formCheck = function() { // 폼 검증
      let form = document.getElementById("form");
      if (form.isbn.value=="") {
        alert("도서 ISBN을 입력해 주세요.");
        form.isbn.focus();
        return false;
      }
      if (form.name.value=="") {
        alert("도서명을 입력해 주세요.");
        form.name.focus();
        return false;
      }
      if (form.author.value=="") {
          alert("저자명을 입력해 주세요.");
          form.author.focus();
          return false;
      }
      if (form.publisher.value=="") {
          alert("출판사명을 입력해 주세요.");
          form.publisher.focus();
          return false;
      }
      if (form.price.value=="") {
          alert("도서가격을 입력해 주세요.");
          form.price.focus();
          return false;
      }
      if (form.content.value=="") {
          alert("독후감을 입력해 주세요.");
          form.content.focus();
          return false;
      }      
      return true;
    }
    $("#modifyBtn").on("click", function(){ // 수정하기 클릭 시
      let form = $("#form");
      let isReadonly = $("input[name=isbn]").attr('readonly');
      // 읽기 상태이면, 수정 상태로 변경
      if(isReadonly=='readonly') {
        $(".writing-header").html("도서정보 수정하기");
        $("input[name=isbn]").attr('readonly', false);
        $("input[name=name]").attr('readonly', false);
        $("input[name=author]").attr('readonly', false);
        $("input[name=publisher]").attr('readonly', false);
        $("input[name=price]").attr('readonly', false);
        $("textarea").attr('readonly', false);
        $('#filemodify').show(); // 새로운 파일로 바꿀 수 있게 보여주기
        $("#modifyBtn").html("<i class='fa fa-pencil'></i> 수정완료");
        return;
      }
      // 수정 상태이면, 수정된 내용을 서버로 전송
      form.attr("action", "<c:url value='/book/modify${searchCondition.queryString}'/>");
      form.attr("method", "post");
      if (formCheck())
        form.submit();
    });
    $("#removeBtn").on("click", function(){ // 삭제하기 클릭 시
      if(!confirm("정말로 삭제하시겠습니까?")) return;
      let form = $("#form");
      form.attr("action", "<c:url value='/book/remove${searchCondition.queryString}'/>");
      form.attr("method", "post");
      form.submit();
    });
    $("#listBtn").on("click", function(){ // 목록보기 클릭 시
      location.href="<c:url value='/book/list${searchCondition.queryString}'/>";
    });
  });
</script>
</body>
</html>