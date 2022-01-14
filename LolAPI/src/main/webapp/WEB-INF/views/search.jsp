<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소환사 정보</title>
	<c:url var="head_url" value="/WEB-INF/views/module/default_js_css.jsp"></c:url>
    <jsp:include page="${head_url }" flush="false" />
</head>
<body>
	<div class="container-fluid p-5 bg-primary text-white text-center">
		  <h1>Liot API 활용</h1>
		  <p>전적 검색 웹페이지 만들기</p>
	</div>
	<div class="container mt-5">
		<div class="row">
			<div class="col-sm-4">
				<h3>${summoner.getName() }</h3>
				<p>Level : ${summoner.getSummonerLevel() }</p>
				<p><img src=${profile_icon } /></p>
			</div>
			<div class="col-sm-4">
			    <h3>솔로랭크</h3>
			    <p><img src=${rank_icon } /></p>
			    <p>${league.getTier() } ${league.getRank() }</p>
			    <p>${league.getLeaguePoints() } LP</p>
			</div>
			<div class="col-sm-4">
			    <h3>전적</h3>
			    <p>승리 : ${league.getWins() } </p>
			    <p>패배 : ${league.getLosses() } </p>
			    <p>승률 : ${league.getWinRate() }%</p>
			</div>
		</div>
	</div>
</body>
</html>