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

	<section class="container p-5 my-5 border border-5">
		<h3>League of Legends 전적 검색</h3>
		<form action="/search" method="post"> 
			<div class="input-group mb-3">
				<input type="text" class="form-control" name="summonerName" placeholder="ex) hide on bush">
				<button class="btn btn-success" type="submit">Search</button>
			</div>
		</form>
	</section>
	
	<div class="container">
		<div class="row">
			<div class="col-sm-6 border border-5">
				<h3>로데이션 챔피언</h3>
				<c:forEach var="freelotation_img" items="${freelotation_img }" varStatus="status">
					<span><img src=${freelotation_img } width="80" height="80"/></span>
				</c:forEach>
			</div>
			<div class="col-sm-6 border border-5">
				<h3>신규 유저 무료 챔피언</h3>
				<c:forEach var="freeForNewUser_img" items="${freeForNewUser_img }" varStatus="status">
					<span><img src=${freeForNewUser_img } width="80" height="80"/></span>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>
