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
<section class="container p-5 my-5">
	<div style="text-align:center;">
		<div class="row">
			<div class="col-sm-4 border border-5">
				<h3>소환사</h3>
				<table class="table table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>Level</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${summoner.getName() }</td>
							<td>${summoner.getSummonerLevel() }</td>
						</tr>
					</tbody>
				</table>
				<p><img src=${profile_icon } /></p>
			</div>
			<div class="col-sm-4 border border-5">
			    <h3>솔로랭크</h3>
			    <table class="table table-striped">
					<thead>
						<tr>
							<th>티어</th>
							<th>포인트</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${league.getTier() } ${league.getRank() }</td>
							<td>${league.getLeaguePoints() } LP</td>
						</tr>
					</tbody>
				</table>
			    <p><img src=${rank_icon } /></p>
			</div>
			<div class="col-sm-4 border border-5">
			    <h3>전적</h3>
			    <table class="table table-striped">
					<thead>
						<tr>
							<th>승리</th>
							<th>패배</th>
							<th>승률</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${league.getWins() }</td>
							<td>${league.getLosses() }</td>
							<td>${league.getWinRate() }%</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</section>
</body>
</html>