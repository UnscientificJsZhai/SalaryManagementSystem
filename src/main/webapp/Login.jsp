<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>薪酬管理系统|统一身份认证|登录</title>
<link rel="stylesheet" href="Login.css" />
<style>
</style>
</head>
<body style="background: url(background.jpg); background-size: cover">

	<form action="login" method="post" align="center">
		<div id="login">
			<h1>账号登录</h1>
			<div class="form">
				<p>用户名</p>
				<div class="item">
					<input type="text" name="username" placeholder="请输入用户名"
						class="initem" />
				</div>
			</div>
			<div class="form">
				<p>密码</p>
				<div class="item">
					<input type="password" name="password" placeholder="请输入密码"
						class="initem" />
				</div>
			</div>
			<br>
			<button type="submit">登录</button>

		</div>
	</form>
	<br>
	<br>

	<%@include file="Footer.jsp"%>
</body>
</html>



