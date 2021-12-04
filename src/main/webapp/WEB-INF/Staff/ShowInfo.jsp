<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>个人信息</title>
<style>
* {
	padding: 0;
	margin: 0;
}

table {
	width: 80%;
	margin: 50px auto;
	text-align: center;
}

#add {
	margin-bottom: 20px;
}

img {
	vertical-align: middle;
}

.bottom {
	width: 100%;
	margin: auto;
	text-align: center;
}

.bottom span {
	margin: 0 10px 0 10px;
}

.info {
	text-align: center;
	font-size: 40px;
}

.logout {
	text-align: right;
	display: flex;
	justify-content: flex-end;
	padding-right: 50px;
}
</style>
	<jsp:include page="/WEB-INF/test1/banner.jsp"/>
</head>
<body style="background: url(showinfo.jpg); background-size: cover">

	<div class="info">
		<p>个人信息</p>
	</div>
	<div class="logout">

		<a href="<c:url value="/Staff/logout"/>">退出登录</a>
	</div>
	<form>
		<table border="1" cellpadding="10px">
			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>部门</th>
				<th>电话</th>
				<th>邮件</th>
				<th colspan="2">操作</th>
			</tr>
			<tr>
				<td>${staffInfo.id}</td>
				<td>${staffInfo.name}</td>
				<td>${staffInfo.department}</td>
				<td>${staffInfo.phoneNumber}</td>
				<td>${staffInfo.email}</td>
				<td><a href="<c:url value="/Staff/showSalary?sid=${staffInfo.id}"/>">查看薪酬</a></td>
				<td><a href="<c:url value="/Staff/editStaffForm?sid=${staffInfo.id}"/>">修改</a></td>
			</tr>
		</table>
		<input name="postWage" type="text" value="" >
	</form>
</body>
</html>