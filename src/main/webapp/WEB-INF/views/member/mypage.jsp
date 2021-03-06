<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/board/css/member.css">
</head>
<body>
<header>
		<div class="container">
			<h1>Spring Project</h1>
			<nav>
				<a href="list">게시판</a>
				<c:if test="${userId == null}">
					<a href="login">로그인</a>
					<a href="sign_up">회원가입</a>
				</c:if>
				<c:if test="${userId != null}">
					<a href="logout">로그아웃</a>
					<a href="mypage">마이페이지</a>
				</c:if>
				<a href="https://github.com/bj-ts/Spring-Web-Board">GITHUB</a>
			</nav>
		</div>
	</header>
	<div class="login-box">
		<h1>MyPage</h1>
		<button class="submit-btn" onclick="location.href='mypage/modify_member' ">회원정보 수정</button>
		<button class="submit-btn" onclick="location.href='mypage/change_password' ">비밀번호 변경</button>
		<button class="submit-btn" onclick="location.href='mypage/delete_member' ">회원탈퇴</button>
	</div>
</body>
</html>