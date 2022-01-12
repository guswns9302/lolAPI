<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container-fluid">
		<a class="navbar-brand" href="/">Navbar</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item">
					<a class="nav-link" href="/">Home</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/guestbook">방명록</a>
				</li>
				<li class="nav-item">
					<a class="nav-link" href="/board">게시판</a>
				</li>
			</ul>
			<div class="d-flex">
				<ul class="navbar-nav">
				<c:choose>
					<c:when test="${param.login }">
						<li class="nav-item dropdown">
						  <a class="nav-link dropdown-toggle" href="/account/info" role="button" data-bs-toggle="dropdown">마이페이지</a>
						  <ul class="dropdown-menu">
						    <li><a class="dropdown-item" href="/account/profile">내 정보</a></li>
						    <li><a class="dropdown-item" href="/account/changepw">비밀번호 변경</a></li>
						    <li><a class="dropdown-item" href="/account/delete">회원 탈퇴</a></li>
						  </ul>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/account/logout">로그아웃</a>
						</li>
					</c:when>
					<c:otherwise>
						<li class="nav-item">
							<a class="nav-link" href="/account/join">회원가입</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/account/login">로그인</a>
						</li>
					</c:otherwise>
				</c:choose>
				</ul>
			</div>
		</div>
	</div>
</nav>
