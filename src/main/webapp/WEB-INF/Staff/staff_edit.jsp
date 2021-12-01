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
<body>
<div style="width: 1000px;margin: 0 auto;text-align: center">
    <a href="/Staff/show.jsp">返回个人信息</a>
</div>
<form action="/staff_alter" method="post">
    <table>
        <tr>
            <th>用户名</th>
            <th>真实姓名</th>
            <th>电话</th>
            <th>邮件</th>
            <th>操作</th>
        </tr>
        <tr>
            
            <td>
                <input name="username" type="text" value="${staff.getUsername()}">
            </td>
            <td>
                <input name="name" type="text" value="${staff.getName()}">
            </td>
            <td>
                <input name="phoneNumber" type="text" value="${staff.getPhoneNumber()}">
            </td>
            <td>
                <input name="email" type="text" value="${staff.getEmail()}">
            </td>
            <td>
                <input name="edit" type="submit" value="修改">
            </td>
        </tr>
    </table>
</form>
</body>
</html>