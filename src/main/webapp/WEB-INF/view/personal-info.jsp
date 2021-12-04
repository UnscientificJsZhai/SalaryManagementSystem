<%--
  Created by IntelliJ IDEA.
  User: mikasa
  Date: 2021/12/4
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="dateTag" uri="dateTag"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Features · Bootstrap v5.1</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/features/">


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
    <link href="${pageContext.request.contextPath}/resources/css/features.css" rel="stylesheet">
</head>
<body>
<jsp:include page="banner.jsp"/>
<main>
    <div class="container px-4 py-5" id="featured-3">
        <h2 class="pb-2 border-bottom">Columns with icons</h2>
        <div class="row g-4 py-5 row-cols-1 row-cols-lg-3">
            <div class="feature col">
                <div class="icon-square bg-light text-dark flex-shrink-0 me-3">
                    <img width="140" height="140" src="${pageContext.request.contextPath}/resources/img/沙滩_太阳.svg"
                         alt="img1"/>
                </div>
                <h2>Staff Id</h2>
                <p>${staffInfo.id}</p>
            </div>
            <div class="feature col">
                <div class="icon-square bg-light text-dark flex-shrink-0 me-3">
                    <img width="50" height="50" src="${pageContext.request.contextPath}/resources/img/沙滩_帆船.svg"
                         alt="img2"/>
                </div>
                <h2>Staff Name</h2>
                <p>${staffInfo.name}</p>
                <c:if test="${sessionScope.staff != null}">
                    <form action="<c:url value="/Staff/editStaff"/>" method="post">
                        <div class="form-floating">
                            <input name="name" type="text" class="form-control" id="floatingInput"
                                   placeholder="new name">
                            <label for="floatingInput">new name</label>
                            <label>
                                <input name="id" type="number" hidden="hidden" value="${staffInfo.id}">
                            </label>
                            <label>
                                <input name="phoneNumber" type="text" hidden="hidden" value="${staffInfo.phoneNumber}">
                            </label>
                            <label>
                                <input name="department" type="number" hidden="hidden" value="${staffInfo.department}">
                            </label>
                            <label>
                                <input name="email" type="text" hidden="hidden" value="${staffInfo.email}">
                            </label>
                        </div>
                        <button class="w-100 btn btn-lg btn-primary" type="submit">click to alter</button>
                    </form>
                </c:if>
            </div>
            <div class="feature col">
                <div class="icon-square bg-light text-dark flex-shrink-0 me-3">
                    <img width="50" height="50" src="${pageContext.request.contextPath}/resources/img/沙滩_椰子汁.svg"
                         alt="img3"/>
                </div>
                <h2>Staff phone</h2>
                <p>${staffInfo.phoneNumber} </p>
                <c:if test="${sessionScope.staff != null}">
                    <form action="<c:url value="/Staff/editStaff"/>" method="post">
                        <div class="form-floating">
                            <input name="phoneNumber" type="text" class="form-control" id="floatingInput2"
                                   placeholder="new phoneNumber">
                            <label for="floatingInput2">new phoneNumber</label>
                            <label>
                                <input name="id" type="number" hidden="hidden" value="${staffInfo.id}">
                                <input name="name" type="text" hidden="hidden" value="${staffInfo.name}">
                                <input name="department" type="number" hidden="hidden" value="${staffInfo.department}">
                                <input name="email" type="text" hidden="hidden" value="${staffInfo.email}">
                            </label>
                        </div>
                        <button class="w-100 btn btn-lg btn-primary" type="submit">click to alter</button>
                    </form>
                </c:if>
            </div>
            <div class="feature col">
                <div class="icon-square bg-light text-dark flex-shrink-0 me-3">
                    <img width="50" height="50" src="${pageContext.request.contextPath}/resources/img/沙滩_照相机.svg"
                         alt="img4"/>
                </div>
                <div>
                    <h2>Staff Email</h2>
                    <p>${staffInfo.email}</p>
                    <c:if test="${sessionScope.staff != null}">
                        <form action="<c:url value="/Staff/editStaff"/>" method="post">
                            <div class="form-floating">
                                <input name="email" type="text" class="form-control" id="floatingInput3"
                                       placeholder="name@example.com">
                                <label for="floatingInput3">new email</label>
                                <label>
                                    <input name="id" type="number" hidden="hidden" value="${staffInfo.id}">
                                    <input name="name" type="text" hidden="hidden" value="${staffInfo.name}">
                                    <input name="phoneNumber" type="text" hidden="hidden"
                                           value="${staffInfo.phoneNumber}">
                                    <input name="department" type="number" hidden="hidden"
                                           value="${staffInfo.department}">
                                </label>
                            </div>
                            <button class="w-100 btn btn-lg btn-primary" type="submit">click to alter</button>
                        </form>
                    </c:if>
                </div>
            </div>
            <div class="feature col">
                <div class="icon-square bg-light text-dark flex-shrink-0 me-3">
                    <img width="50" height="50" src="${pageContext.request.contextPath}/resources/img/沙滩_背包.svg"
                         alt="img5"/>
                </div>
                <div>
                    <h2>Staff Department</h2>
                    <p>${staffInfo.department}</p>
                    <c:if test="${sessionScope.administrator != null}">
                        <form action="<c:url value="/Admin/editStaff"/>" method="post">
                            <div class="form-floating">
                                <input name="department" type="number" id="floatingInput4" class="form-control"
                                       placeholder="new department" required>
                                <label for="floatingInput4">new department</label>
                                <label>
                                    <input name="id" type="number" hidden="hidden" value="${staffInfo.id}">
                                    <input name="name" type="text" hidden="hidden" value="${staffInfo.name}">
                                    <input name="phoneNumber" type="text" hidden="hidden"
                                           value="${staffInfo.phoneNumber}">
                                    <input name="email" type="text" hidden="hidden" value="${staffInfo.email}">
                                </label>
                            </div>
                            <button class="w-100 btn btn-lg btn-primary" type="submit">click to alter</button>
                        </form>
                    </c:if>
                </div>
            </div>
            <div class="feature col">
                <div class="icon-square bg-light text-dark flex-shrink-0 me-3">
                    <img width="50" height="50" src="${pageContext.request.contextPath}/resources/img/沙滩_防晒霜.svg"
                         alt="img6"/>
                </div>
                <c:if test="${sessionScope.staff != null}">
                    <div>
                        <h2>Password</h2>
                        <p>you can change pwd here!</p>
                        <form action="<c:url value="/Staff/changePassword"/>" method="post">
                            <div class="form-floating">
                                <input name="password1" type="password" id="floatingInput5" class="form-control"
                                       placeholder="new pwd">
                                <label for="floatingInput5">new pwd</label>
                                <br/>
                                <input name="password2" type="password" id="floatingInput6" class="form-control"
                                       placeholder="new pwd again">
                                <label for="floatingInput6">new pwd again</label>
                            </div>
                            <br/>
                            <button class="w-100 btn btn-lg btn-primary" type="submit">click to alter</button>
                        </form>
                    </div>
                </c:if>

            </div>
        </div>
    </div>

    <div class="b-example-divider"></div>

    <div class="container px-4 py-5" id="custom-cards">
        <h2 class="pb-2 border-bottom">Custom cards</h2>
        <br/>
        <a href="/Admin/addSalary/${staffInfo.id}">addSalary</a>
        <div class="table-responsive">
            <table class="table table-striped table-sm">
                <c:if test="${sessionScope.administrator != null}">
                    <dateTag:showDate salaryList="${salaryList}" staff="${staffInfo}"
                                      administrator="${sessionScope.administrator}"/>
                </c:if>
                <c:if test="${sessionScope.staff != null}">
                    <dateTag:showDate salaryList="${salaryList}" staff="${sessionScope.staff}"
                                      administrator="${null}"/>
                </c:if>
            </table>
        </div>
    </div>
    <div class="b-example-divider"></div>
</main>
</body>
</html>
