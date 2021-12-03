<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改薪酬信息</title>
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
<body style="background: url(editsalary.jpg);background-size: cover">
<div style="width: 1000px;margin: 0 auto;text-align: center;background-color:gray">
    <a href="/administrator/showStaff" style="color:red">返回员工列表</a>
</div>
<form action="/administrator/editSalary" method="post">
    <tr>
        <p>员工ID：${staff.id}</p>
        <p>员工姓名：${staff.name}</p>
    </tr>
    <table>
        <tr>
            <th>月份</th>
            <th>岗位工资</th>
            <th>绩效工资</th>
            <th>工龄工资</th>
            <th>补贴</th>
            <th>操作</th>
        </tr>
        <tr>
            <c:forEach items="${salaryList}" var="salary">
                <td>${salary.month}</td>
                <td>
                    <input name="postWage" type="text" value="${salary.postWage}">
                </td>
                <td>
                    <input name="meritPay" type="text" value="${salary.meritPay}">
                </td>
                <td>
                    <input name="seniorityPay" type="text" value="${salary.seniorityPay}">
                </td>
                <td>
                    <input name="subsidy" type="text" value="${salary.subsidy}">
                </td>
                <td>
                    <input name="edit" type="submit" value="修改">
                </td>
            </c:forEach>
        </tr>
    </table>
</form>
</body>
</html>