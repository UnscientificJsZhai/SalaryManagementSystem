<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改用户信息</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <style>
        table {
            width: 1000px;
            margin: 100px auto;
        }

        tr {
            text-align: center;
        }

        th, td {
            width: 12.5%;
        }
    </style>
</head>
<body>
<div style="width: 1000px;margin: 0 auto;text-align: center">
    <a href="/staff_conditionSelect">返回员工列表</a>
</div>
<form action="/editstaff" method="post">
    <table>
        <tr>
            <th>id</th>
            <th>员工姓名</th>
            <th>部门</th>
            <th>操作</th>
        </tr>
        <tr>
            <td>${staff.getId()}</td>
            <td>
                <input name="username" type="text" value="${staff.getUserName()}">
            </td>    
            <td>
                <input name="name" type="text" value="${staff.getName()}">
            </td>
            <td>
                <select name="departname">
                    <%--                    部门列表--%>
                    <c:forEach items="${sessionScope.departmentList}" var="department">
                        <c:choose>
                            <%--                            当前员工的部门--%>
                            <c:when test="${department.getDepartmentName() == staff.getDepartment().getDepartmentName()}">
                                <option value="${department.getDepartmentName()}" selected>${department.getDepartmentName()}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${department.getDepartmentName()}">${department.getDepartmentName()}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
            </td>

            <td>
                <input name="edit" type="submit" value="修改">
            </td>
        </tr>
    </table>
</form>
</body>
</html>