
<%@ page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<a href="/Admin/adddepartment.jsp">添加部门</a>
		<form action="/department_conditionSelect" method="post">
        <select name="pidSelect">
            <option value="-1">所有部门</option>
            <c:forEach items="${sessionScope.departmentList}" var="department">
                <c:choose>
                    <c:when test="${department.getPid() == depid}">
                        <option value="${department.getPid()}" selected>${department.getDepartmentNname()}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${department.getPid()}">${department.getDepartmentName()}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
        <input type="submit" value="查询">
    </form>
	</div>
	
	<form action="/department_conditionDelete" method="post">
		<table border="0" cellpadding="10px">
			<tr>
				<th>部门id</th>
				<th>部门名称</th>
				<th>等级</th>
				<th colspan="2">操作</th>
			</tr>
			<c:forEach items="${sessionScope.departmentList}" var="department">
				<tr>
					<td><input type="checkbox" name="pid" value="${department.getId()}"></td>
					<td>${department.getId()}</td>
					<td>${department.getDepartmentNname()}</td>
					<td>${department.getGrade()}</td>
					<td><a name="del" href="#">删除</a></td>
					<td><a href="/department_edit?pid=${department.getId()}">修改</a></td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<div class="bottom">
		<span>${sessionScope.i}/${sessionScope.pages}</span>
		<c:choose>
			<c:when test="${Department.pid == null}">
				<a href="/department_conditionSelect?i=1">首页</a>
				<%--        所有部门--%>
				<c:if test="${sessionScope.i != 1}">
					<a href="/department_conditionSelect?i=${sessionScope.i-1}">上一页</a>
				</c:if>
				<c:if test="${sessionScope.i != sessionScope.pages}">
					<a href="/department_conditionSelect?i=${sessionScope.i+1}">下一页</a>
				</c:if>
				<a href="/department_conditionSelect?i=${sessionScope.pages}">末页</a>
				<input id="inputPage" type="text" placeholder="请输入页码..." value="">
				<button id="goPage" type="button">GO</button>
			</c:when>
			<c:otherwise>
				<a href="/department_conditionSelect?i=1">首页</a>
				<%--        单个部门--%>
				<c:if test="${sessionScope.i != 1}">
					<a href="/department_conditionSelect?i=${sessionScope.i-1}">上一页</a>
				</c:if>
				<c:if test="${sessionScope.i != sessionScope.pages}">
					<a href="/department_conditionSelect?i=${sessionScope.i+1}">下一页</a>
				</c:if>
				<a href="/department_conditionSelect?i=${sessionScope.pages}">末页</a>
				<input id="inputPage" type="number" placeholder="请输入页码..." value="">
				<button id="goPage" type="button">GO</button>
			</c:otherwise>
		</c:choose>

	</div>
	
	
	
</body>
</html>