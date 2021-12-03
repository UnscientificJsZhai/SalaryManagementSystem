<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改员工信息</title>
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
<body style="background-color:gray">
<div style="width: 1000px;margin: 0 auto;text-align: center">
    <a href="/administrator/showStaff">返回员工列表</a>
    <br/>
    <br/>
    <br/>
    <p>修改当前员工信息:</p>
</div>
<form action="/administrator/changeStaffDepartment" method="post">
    <table>
        <tr>
            <th>id</th>
            <th>员工姓名</th>
            <th>部门</th>
            <th>操作</th>
        </tr>
        <tr>
            <td>${staff.id}</td>
            <td>${staff.name}></td>
            <td>
                <select name="departmentName">
                    <%--                    部门列表--%>
                    <c:forEach items="${sessionScope.departmentList}" var="department">
                        <c:choose>
                            <%--                            当前员工的部门--%>
                            <c:when test="${department.name == staff.department.name}">
                                <option value="${department.name}" selected>${department.name}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${department.name}">${department.name}</option>
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