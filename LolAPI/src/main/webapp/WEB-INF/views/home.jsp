<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
	<title>LoL</title>
	<c:url var="head_url" value="/WEB-INF/views/module/default_js_css.jsp"></c:url>
    <jsp:include page="${head_url }" flush="false" />
</head>
<body>
<h1>
	롤 전적 확인 api 활용  
</h1>
	<section class="container p-5 my-5 border">
		<form action="/serch" method="post"> 
			<div class="mb-3">
		    	<label for="pwd" class="form-label">소환사명</label>
		    	<input type="text" class="form-control" id="summoner" placeholder="소환사 닉네임 입력" name="summoner">
		  	</div>
		  	<div class="mb-3" id="button_serch">
		  		<button type="submit" class="btn btn-primary">검색</button>
		  	</div>
		</form>
	</section>

</body>
</html>
