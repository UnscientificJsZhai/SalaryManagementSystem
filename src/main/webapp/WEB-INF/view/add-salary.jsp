<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mikasa
  Date: 2021/12/4
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Salary</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Checkout example · Bootstrap v5.1</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/checkout/">

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


    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/resources/css/form-validation.css" rel="stylesheet">
</head>
<body class="bg-light">

<div class="container">
    <main>
        <div class="py-5 text-center">
            <h2>add staff</h2>
        </div>

        <div class="row g-5">
            <div class="col-md-7 col-lg-8">
                <h4 class="mb-3">staff info</h4>
                <form class="needs-validation" novalidate action="<c:url value="/Admin/addSalary"/> " method="post">
                    <div class="row g-3">

                        <div class="col-12">
                            <label> month
                                <input name="month" type="text" class="form-control" placeholder="month" required
                                       value="${salary.month}">
                            </label>
                        </div>
                        <div class="col-12">
                            <label> postWage
                                <input name="postWage" type="text" class="form-control" placeholder="postWage" required>
                            </label>
                        </div>

                        <div class="col-12">
                            <label> meritPay
                                <input name="meritPay" type="text" class="form-control" placeholder="meritPay" required>
                            </label>
                        </div>

                        <div class="col-12">
                            <label> seniorityPay
                                <input name="seniorityPay" type="text" class="form-control" placeholder="seniorityPay"
                                       required>
                            </label>
                        </div>

                        <div class="col-12">
                            <label> subsidy
                                <input name="subsidy" type="text" class="form-control" placeholder="subsidy" required>
                            </label>
                        </div>

                        <div class="col-12">
                            <label> paid
                                <input name="paid" type="text" class="form-control" placeholder="paid" required>
                            </label>
                        </div>
                        <div class="col-12">
                            <label>
                                <input name="id" type="number" hidden="hidden" value="${staffInfo.id}">
                            </label>
                        </div>
                    </div>
                    <br/>
                    <button class="w-100 btn btn-primary btn-lg" type="submit">Continue to checkout</button>
                </form>
            </div>
        </div>
    </main>
</div>

<script src="${pageContext.request.contextPath}/resources/css/assets/dist/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/form-validation.js"></script>

</body>
</html>