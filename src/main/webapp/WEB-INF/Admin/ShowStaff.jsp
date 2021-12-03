
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
	margin: 100px auto;
	text-align: center;
}

#add {
	margin-bottom: 20px;
}

img {
	vertical-align: middle;
}

.top {
    background:gray;
	position: fixed;
	top: 5px;
	width:100%;
}

.bottom {
	width: 100%;
	margin: auto;
	text-align: center;
}

.bottom span {
	margin: 0 10px 0 10px;
}

.show{
    height:80%
}
.search{
    display: flex;
    justify-content: center;
}
</style>
</head>
<body style="background: url(/showstaff.jpg); background-size: cover">
	<div class="top">
		<p style="text-align: center"><a href="<c:url value="/Admin/addStaff"/>" style="color:red">添加员工</a></p>
		<br/>
		<div class="search">
<%--		<form action="/staff_conditionSelect" method="post" style="float:left;">--%>
<%--			<p>姓名查询：</p>--%>
<%--			<input type="text" name="username" placeholder="请输入姓名查询"> --%>
<%--			<input type="submit" value="查询">--%>
<%--		</form>--%>
		<form action="<c:url value="/Admin/searchStaff"/>" method="post" style="float:left;">
			<p>id查询：</p>
			<input type="text" name="staffId" placeholder="请输入id查询">
			<input type="submit" value="查询">
		</form>
		</div>
	</div>
    <div class ="show">
	<form action="<c:url value="/Admin/deleteStaff"/>" method="post">
		<table border="1" cellpadding="10px">
			<tr>
				<th>ID</th>
				<th>姓名</th>
				<th>部门</th>
				<th>电话</th>
				<th>邮件</th>
				<th colspan="2">信息操作</th>
				<th colspan="3">薪酬操作</th>
			</tr>
			<c:forEach items="${staffList}" var="staff">
				<tr>
					<!-- <td><input type="checkbox" name="sid" value="${staff.id}"></td> -->
					<td>${staff.id}</td>
					<td>${staff.name}</td>
					<td>${staff.department}</td>
					<td>${staff.phoneNumber}</td>
					<td>${staff.email}</td>
					<td><a name="del" href="#?sid=${staff.id}">删除</a></td>
					<td><a href="<c:url value="/Admin/changeStaffDepartment?sid=${staff.id}"/>">修改</a></td>
					<td><a href="<c:url value="/Admin/addSalary?sid=${staff.id}"/>">添加薪酬</a></td>
					<td><a href="<c:url value="/Admin/editSalary?sid=${staff.id}"/>">修改薪酬</a></td>
					<td><a href="<c:url value="/Admin/searchSalary?sid=${staff.id}"/>">查看薪酬</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
	</div>
	<div class="bottom">
		<span>${sessionScope.pageIndex}/${sessionScope.totalPage}</span>
		<c:choose>
			<c:when test="${department.pid == null}">
				<a href="<c:url value="/Admin/searchStaff?pageIndex=1"/>">首页</a>
				<%--        所有员工--%>
				<c:if test="${sessionScope.pageIndex != 1}">
					<a href="<c:url value="/Admin/searchStaff?pageIndex=${sessionScope.pageIndex-1}"/>">上一页</a>
				</c:if>
				<c:if test="${sessionScope.pageIndex != sessionScope.totalPage}">
					<a href="<c:url value="/Admin/searchStaff?pageIndex=${sessionScope.pageIndex+1}"/>">下一页</a>
				</c:if>
				<a href="<c:url value="/Admin/searchStaff?pageIndex=${sessionScope.totalPage}"/>">末页</a>
			</c:when>
			<c:otherwise>
				<a href="<c:url value="/Admin/searchStaff?pageIndex=1"/>">首页</a>
				<%--        单个员工--%>
				<c:if test="${sessionScope.pageIndex != 1}">
					<a href="<c:url value="/Admin/searchStaff?pageIndex=${sessionScope.pageIndex-1}"/>">上一页</a>
				</c:if>
				<c:if test="${sessionScope.pageIndex != sessionScope.totalPage}">
					<a href="<c:url value="/Admin/searchStaff?pageIndex=${sessionScope.pageIndex+1}"/>">下一页</a>
				</c:if>
				<a href="<c:url value="/Admin/searchStaff?pageIndex=${sessionScope.totalPage}"/>">末页</a>

			</c:otherwise>
		</c:choose>

	</div>

</body>
</html>