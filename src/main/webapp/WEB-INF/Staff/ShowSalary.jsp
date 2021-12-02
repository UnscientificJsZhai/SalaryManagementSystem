<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<body style="background: url(showsalary.jpg); background-size: cover">
<div style="width: 1000px;margin: 0 auto;text-align: center">
    <a href="/staff/ShowInfo">返回个人信息界面</a>
</div>
<h3>
    name: ${staffName} <br/>
</h3>
<table>
    <tr>
        <th>月份。</th>
        <th>岗位工资。</th>
        <th>绩效工资。</th>
        <th>工龄工资。</th>
        <th>补贴。</th>
        <th>是否已发放工资。</th>
    </tr>
    <c:forEach items="${salaryList}" var="salary" >
        <tr>
<%--            把月份显示做成自定义tag--%>
            <td>${salary.month}</td>
            <td>${salary.postWage}</td>
            <td>${salary.meritPay}</td>
            <td>${salary.seniorityPay}</td>
            <td>${salary.subsidy}</td>
            <td>${salary.paid}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>