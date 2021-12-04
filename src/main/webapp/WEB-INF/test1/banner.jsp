<%--
  Created by IntelliJ IDEA.
  User: mikasa
  Date: 2021/12/4
  Time: 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Headers · Bootstrap v5.1</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/headers/">


    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/assets/dist/css/bootstrap.min.css" rel="stylesheet">

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


    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/css/headers.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <header class="d-flex flex-wrap justify-content-center py-3 mb-4 border-bottom">
        <a href="#" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-dark text-decoration-none">
            <svg class="bi me-2" width="40" height="32"></svg>
            <span class="fs-4">Simple header</span>
        </a>
        <ul class="nav nav-pills">
            <c:if test="${sessionScope.staff !=null}">
                <li class="nav-item"><a href="<c:url value="/Staff/ShowInfo"/> " class="nav-link active" aria-current="page">PersonalInfo</a></li>
            </c:if>
            <c:if test="${sessionScope.staff != null}">
                <li class="nav-item"><a href="<c:url value="/Staff/showSalary"/>" class="nav-link">MySalary</a></li>
            </c:if>
            <c:if test="${sessionScope.administrator != null}">
                <li class="nav-item"><a href="#" class="nav-link">Staff</a></li>
            </c:if>
            <c:if test="${sessionScope.administrator != null}">
                <li class="nav-item"><a href="#" class="nav-link">Department</a></li>
            </c:if>
        </ul>
    </header>
</div>
</body>
</html>
