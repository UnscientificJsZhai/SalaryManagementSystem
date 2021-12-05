<%--
  Created by IntelliJ IDEA.
  User: mikasa
  Date: 2021/12/4
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="departmentTag" uri="departmentTag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Departments List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Cheatsheet · Bootstrap v5.1</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/cheatsheet/">

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/assets/dist/css/bootstrap.css" rel="stylesheet">

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
</head>
<body>
<jsp:include page="banner.jsp"/>
<div class="container px-4 py-5" id="custom-cards">
    <div>
        <div class="panel panel-primary">
            <div class="panel-heading"><h3>Departments List</h3></div>
            <div class="panel-body">
                <departmentTag:showDepartment treeNodes="${treeNodes}"/>
            </div>
        </div>
    </div>
    <a href="<c:url value="/Admin/addDepartment"/>">
        <button type="button" class="btn btn-success">Add a Department</button>
    </a>
</div>
</body>
</html>
