
<%@ page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>员工显示与查询</title>
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

.top {
	position: fixed;
	top: 5px;
	left: 50px;
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
	<div class="top">
		<a href="/Admin/addstaff.jsp">添加员工</a>

		<form action="/staff_conditionSelect" method="post">
			<p>用户名</p>
			<input type="text" name="username" placeholder="请输入用户名查询"> 
			<input type="submit" value="查询">
		</form>
	</div>

	<form action="/staff_conditionDelete" method="post">
		<table border="0" cellpadding="10px">
			<tr>
				<th>id</th>
				<th>用户名</th>
				<th>真实姓名</th>
				<th>部门</th>
				<th>电话</th>
				<th>邮件</th>
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
					<td><a name="del" href="#">删除</a></td>
					<td><a href="/staff_edit?sid=${staff.getId()}">修改</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<div class="bottom">
		<span>${sessionScope.i}/${sessionScope.pages}</span>
		<c:choose>
			<c:when test="${Department.uid == null}">
				<a href="/staff_conditionSelect?i=1">首页</a>
				<%--        所有员工--%>
				<c:if test="${sessionScope.i != 1}">
					<a href="/staff_conditionSelect?i=${sessionScope.i-1}">上一页</a>
				</c:if>
				<c:if test="${sessionScope.i != sessionScope.pages}">
					<a href="/staff_conditionSelect?i=${sessionScope.i+1}">下一页</a>
				</c:if>
				<a href="/staff_conditionSelect?i=${sessionScope.pages}">末页</a>
				<input id="inputPage" type="text" placeholder="请输入页码..." value="">
				<button id="goPage" type="button">GO</button>
			</c:when>
			<c:otherwise>
				<a href="/staff_conditionSelect?i=1">首页</a>
				<%--        单个员工--%>
				<c:if test="${sessionScope.i != 1}">
					<a href="/staff_conditionSelect?i=${sessionScope.i-1}">上一页</a>
				</c:if>
				<c:if test="${sessionScope.i != sessionScope.pages}">
					<a href="/staff_conditionSelect?i=${sessionScope.i+1}">下一页</a>
				</c:if>
				<a href="/staff_conditionSelect?i=${sessionScope.pages}">末页</a>
				<input id="inputPage" type="number" placeholder="请输入页码..." value="">
				<button id="goPage" type="button">GO</button>
			</c:otherwise>
		</c:choose>

	</div>
	<script>
		//单个用户删除
		var del = document.getElementsByName("del");
		for (let i = 0; i < del.length; i++) {
			del[i].onclick = function() {
				// 父级的父级的第4个子元素td，包含员工姓名
				let username = this.parentNode.parentNode.children[3];
				var ok = confirm("确定删除" + username.innerText + "吗？");
				if (!ok) {
					return false;
				} else {
					// 父级的父级的第1个子元素td里面的input，value为员工编号
					let eid = this.parentNode.parentNode.children[0].children[0];
					location = "/employee_del?eid=" + eid.value;
				}
			}
		}
		// 添加用户
		var add = document.getElementById("add");
		add.onclick = function() {
			location = "/Admin/addstaff.jsp";
		}
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