
<%@ page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

.bottom a, .bottom span {
	margin: 0 10px 0 10px;
}
</style>
</head>
<body>

	<form action="/staff_conditionDelete" method="post">
		<table border="0" cellpadding="10px">
			<tr>
				<th>id</th>
				<th>用户名</th>
				<th>真实姓名</th>
				<th>部门</th>
				<th>电话</th>
				<th>邮件</th>
				<th>薪资</th>
				<th colspan="2">操作</th>
			</tr>
			<c:forEach items="${sessionScope.staffList}" var="staff">
				<tr>
					<td><input type="checkbox" name="sid" value="${staff.getId()}"></td>
					<td>${staff.getId()}</td>
					<td>${staff.getUsername()}</td>
					<td>${staff.getName()}</td>
					<td>${staff.getDepartment().getDepartmentNname()}</td>
					<td>${staff.getPhoneNumber()}</td>
					<td>${staff.getEmail()}</td>
					<td>${staff.getSalary()}</td>
					<td><a href="/showsalary.jsp?sid=${staff.getId()}">查看薪酬</a></td>
					<td><a href="/staff_edit?sid=${staff.getId()}">修改</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
	
	<script>
		// 修改用户
		var edit = document.getElementsByName("edit");
		for (let i = 0; i < edit.length; i++) {
			edit[i].addEventListener("click", function() {
				// 父级的父级的第2个子元素
				url = "/employee/employee_edit?eid="
						+ this.parentNode.parentNode.children[1].innerText;
				location = url;
			});
		}
	</script>
</body>
</html>