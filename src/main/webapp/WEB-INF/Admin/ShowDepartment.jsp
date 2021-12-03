
<%@ page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="departmentTag" uri="departmentTag"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>部门显示与查询</title>
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
	background: gray;
	position: fixed;
	top: 5px;
	width: 100%;
}

.bottom {
	width: 100%;
	margin: auto;
	text-align: center;
}

.bottom span {
	margin: 0 10px 0 10px;
}

.show {
	height: 80%
}

.search {
	display: flex;
	justify-content: center;
}
</style>
</head>
<body
	style="background: url(showdepartment.jpg); background-size: cover">
	<div class="top">
		<p style="text-align: center">
			<a href="/administrator/addDepartment">添加部门</a>
		</p>
		<div class="search">
			<form action="/administrator/showDepartment" method="post">
				<p>id查询：</p>
				<input type="text" name="departmentId" placeholder="请输入id查询">
				<input type="submit" value="查询">
			</form>
		</div>
	</div>
	<div class="show">
		<form action="/administrator/deleteDepartment" method="post">
			<table border="1" cellpadding="10px">
				<tr>
					<th>部门id</th>
					<th>部门名称</th>
					<th>上级部门</th>
					<th>级别</th>
					<th>操作</th>
				</tr>
			</table>
			<departmentTag:showDepartment/>
		</form>
	</div>
	<div class="bottom">
		<span>${sessionScope.pageIndex}/${sessionScope.totalPage}</span>
		<c:choose>
			<c:when test="${department.id == null}">
				<a href="/administrator/showDepartment?pageIndex=1">首页</a>
				<%--        所有部门--%>
				<c:if test="${sessionScope.pageIndex != 1}">
					<a
						href="/administrator/showDepartment?pageIndex=${sessionScope.pageIndex-1}">上一页</a>
				</c:if>
				<c:if test="${sessionScope.pageIndex != sessionScope.totalPage}">
					<a
						href="/administrator/showDepartment?pageIndex=${sessionScope.pageIndex+1}">下一页</a>
				</c:if>
				<a
					href="/administrator/showDepartment?pageIndex=${sessionScope.totalPage}">末页</a>
			</c:when>
			<c:otherwise>
				<a href="/administrator/showDepartment?pageIndex=1">首页</a>
				<%--        单个部门--%>
				<c:if test="${sessionScope.pageIndex != 1}">
					<a
						href="/administrator/showDepartment?pageIndex=${sessionScope.pageIndex-1}">上一页</a>
				</c:if>
				<c:if test="${sessionScope.i != sessionScope.totalPage}">
					<a
						href="/administrator/showDepartment?pageIndex=${sessionScope.pageIndex+1}">下一页</a>
				</c:if>
				<a
					href="/administrator/showDepartment?pageIndex=${sessionScope.totalPage}">末页</a>
			</c:otherwise>
		</c:choose>

	</div>

</body>
</html>