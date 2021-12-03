<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改个人信息</title>
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
    <a href="<c:url value="/Staff/ShowInfo"/>">返回个人信息</a>
</div>
<form action="<c:url value="/Staff/editStaff"/>" method="post">
    <table>
        <tr>
            <th>ID</th>
            <th>姓名</th>
            <th>电话</th>
            <th>邮件</th>
            <th>部门</th>
            <th>操作</th>
        </tr>
        <tr>
            <td>
                <input name="id" type="number" value="${staffInfo.id}" readonly="readonly">
            </td>
            <td>
                <input name="name" type="text" value="${staffInfo.name}">
            </td>
            <td>
                <input name="phoneNumber" type="text" value="${staffInfo.phoneNumber}">
            </td>
            <td>
                <input name="email" type="text" value="${staffInfo.email}">
            </td>
            <td>
                <input name="department" type="number" value="${staffInfo.department}" readonly="readonly">
            </td>
            <td>
                <input name="edit" type="submit" value="修改">
            </td>
        </tr>
    </table>
</form>
<form action=<c:url value="/Staff/changePassword"/> method="post">
    <table>
        <tr>
            <th>密码</th>
            <th>再次输入密码</th>
        </tr>
        <tr>
            <td>
                <input name="password1" type="text">
            </td>
            <td>
                <input name="password2" type="text">
            </td>
            <td>
                <input name="edit" type="submit" value="修改">
            </td>
        </tr>
    </table>
</form>
<script>
</script>
</body>
</html>