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
	<div class="container-fluid p-5 bg-primary text-white text-center">
		  <h1>Liot API 활용</h1>
		  <p>전적 검색 웹페이지 만들기</p>
	</div>
	<section class="container p-5 my-5 border">
		<h3>League of Legends 전적 검색</h3>
		<form action="/search" method="post"> 
			<div class="input-group mb-3">
				<input type="text" class="form-control" name="summonerName" placeholder="ex) hide on bush">
				<button class="btn btn-success" type="submit">Search</button>
			</div>
		</form>
	</section>
	<p>${lotation.getFreeChampionIds().get(0) }</p>
</body>
</html>
