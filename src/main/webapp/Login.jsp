<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

	<form action="/login" method="post" align="center">
		<div id="login">
			<h1>账号登录</h1>
			<div class="form">
				<p>用户ID</p>
				<div class="item">
					<input type="text" name="Id" placeholder="请输入ID"
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
    <c:choose>
       <c:when test="#{sessionScope.administrator == null && sessionScope.staff == null}"><a herf="#">重新登录</a></c:when>
    </c:choose>
	<a href="/Admin/editSalary">edit</a>

<!-- <script> 
//取出传回来的参数并判断
  var message = "${param.message}";
  if(message == "no"){undefined
   alert("登录失败!");
  }
</script> -->
</body>
</html>



