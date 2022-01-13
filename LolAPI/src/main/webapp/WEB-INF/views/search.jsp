<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소환사 정보</title>
</head>
<body>
	<section class="container p-5 my-5 border">
			<div class="mb-3">
				<label>소환사 이름</label>
		    	<p>${summoner.getName() }</p>
		  	</div>
		  	<hr>
		  	<div class="mb-3">
		  		<label>소환사 레벨</label>
		    	<p>${summoner.getSummonerLevel() }</p>
		  	</div>
		  	<hr>
		  	<div class="mb-3">
		  		<label>소환사 아이콘</label>
		    	<img src=${profile_icon } />
		  	</div>
		  	<hr>
		  	<div class="mb-3">
		  		<label>매칭 타입</label>
		    	<p>${league.getQueueType() } </p>
		  	</div>
		  	<hr>
		  	<div class="mb-3">
		  		<label>현재 랭크</label>
		    	<p>${league.getRank() } <p/>
		  	</div>
		  	<hr>
		  	<div class="mb-3">
		  		<label>현재 티어</label>
		    	<p>${league.getTier() } <p/>
		  	</div>
		  	<hr>
		  	<div class="mb-3">
		  		<label>티어 아이콘</label>
		    	<img src=${rank_icon } />
		  	</div>
		  	<hr>
		  	<div class="mb-3">
		  		<label>리그 포인트</label>
		    	<p>${league.getLeaguePoints() } <p/>
		  	</div>
		  	<hr>
		  	<div class="mb-3">
		  		<label>승</label>
		    	<p>${league.getWins() } <p/>
		  	</div>
		  	<hr>
		  	<div class="mb-3">
		  		<label>패</label>
		    	<p>${league.getLosses() } <p/>
		  	</div>
		  	<hr>
	</section>
</body>
</html>