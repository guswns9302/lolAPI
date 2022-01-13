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
		    	<p>${summonerinfo.getName() }</p>
		  	</div>
		  	<hr>
		  	<div class="mb-3">
		  		<label>소환사 레벨</label>
		    	<p>${summonerinfo.getSummonerLevel() }</p>
		  	</div>
		  	<hr>
		  	<div class="mb-3">
		  		<label>소환사 아이콘</label>
		    	<img src=${profile_icon } />
		  	</div>
		  	<hr>
		  	
	</section>
</body>
</html>