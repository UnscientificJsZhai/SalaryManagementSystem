<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>修改部门信息</title>
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
    <a href="/administrator/showDepartment">返回部门列表</a>
</div>
<form action="/department_edit" method="post">
    <table>
        <tr>
            <th>部门id</th>
            <th>部门名称</th>
            <th>上级部门</th>
            <th>级别</th>
            <th>操作</th>
        </tr>
        <tr>
            <td>${department.id}</td>
            <td>
                <input name="departmentName" type="text" value="${department.name}">
            </td>
            <td>${department.parentDepartment}</td>
            <td>${department.level}</td>
            <td>
                <input name="edit" type="submit" value="修改">
            </td>
        </tr>
    </table>
</form>
</body>
</html>