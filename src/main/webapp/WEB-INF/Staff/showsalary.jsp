<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看薪酬信息</title>
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
    <a href="/showinfo.jsp">返回个人信息界面</a>
</div>
<form action="/salary_edit" method="post">
    <table>
        <tr>
            <th>员工id</th>
            <th>员工姓名</th>
            <th>绩效工资</th>
            <th>工龄工资</th>
            <th>津贴补助</th>
        </tr>
        <tr>
            <td>${staff.getId()}</td>
            <td>${staff.getName()}></td>
            <td>${salary.getMeritpay()}></td>
            <td>${salary.getSenioritypay()}></td>
            <td>${salary.getsubsidy()}></td>    
        </tr>
    </table>
</form>
</body>
</html>