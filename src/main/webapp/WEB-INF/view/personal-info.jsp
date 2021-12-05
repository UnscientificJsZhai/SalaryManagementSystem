<%--
  Created by IntelliJ IDEA.
  User: mikasa
  Date: 2021/12/4
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="dateTag" uri="dateTag" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Staff Information</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.88.1">
    <title>Features · Bootstrap v5.1</title>

    <link rel="canonical" href="https://getbootstrap.com/docs/5.1/examples/features/">


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
    <link href="${pageContext.request.contextPath}/resources/css/features.css" rel="stylesheet">
</head>
<body>
<jsp:include page="banner.jsp"/>
<main>
    <div class="container px-4 py-5" id="featured-3">
        <h2 class="shadow-lg p-3 mb-5 bg-white rounded">Personal Information:</h2>
        <div class="row g-4 py-5 row-cols-1 row-cols-lg-3">
            <div class="feature col">
                <div class="icon-square bg-light text-dark flex-shrink-0 me-3">
                    <img width="50" height="50" src="${pageContext.request.contextPath}/resources/img/沙滩_太阳.svg"
                         alt="img1"/>
                </div>
                <div class="shadow-sm p-3 mb-5 bg-white rounded">
                    <h2>Staff Id</h2>
                </div>
                <div class="text-primary shadow-none p-3 mb-5 bg-light rounded">
                    <p>${staffInfo.id}</p>
                </div>
            </div>
            <div class="feature col">
                <div class="icon-square bg-light text-dark flex-shrink-0 me-3">
                    <img width="50" height="50" src="${pageContext.request.contextPath}/resources/img/沙滩_帆船.svg"
                         alt="img2"/>
                </div>
                <div class="shadow-sm p-3 mb-5 bg-white rounded">
                    <h2>Staff Name</h2>
                </div>
                <div class="text-primary shadow-none p-3 mb-5 bg-light rounded">
                    <c:if test="${staffInfo.name != null}">
                        <p>${staffInfo.name}</p>
                    </c:if>
                    <c:if test="${staffInfo.name == null}">
                        <p>未设置</p>
                    </c:if>
                </div>
                <c:if test="${sessionScope.staff != null}">
                    <form action="<c:url value="/Staff/editStaff"/>" method="post">
                        <div class="form-floating">
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="basic-addon7">New name</span>
                                </div>
                                <input name="name" type="text" id="floatingInput" class="form-control"
                                       placeholder="new name" aria-label="new name"
                                       aria-describedby="basic-addon1">
                            </div>
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
                <div class="shadow-sm p-3 mb-5 bg-white rounded">
                    <h2>Staff phone</h2>
                </div>
                <div class="text-primary shadow-none p-3 mb-5 bg-light rounded">
                    <c:if test="${staffInfo.phoneNumber != null}">
                        <p>${staffInfo.phoneNumber} </p>
                    </c:if>
                    <c:if test="${staffInfo.phoneNumber == null}">
                        <p>未设置</p>
                    </c:if>
                </div>
                <c:if test="${sessionScope.staff != null}">
                    <form action="<c:url value="/Staff/editStaff"/>" method="post">
                        <div class="form-floating">
                            <div class="input-group mb-3">
                                <div class="input-group-prepend">
                                    <span class="input-group-text" id="basic-addon6">New PhoneNum</span>
                                </div>
                                <input name="phoneNumber" type="text" id="floatingInput2" class="form-control"
                                       placeholder="new phoneNumber" aria-label="new phoneNumber"
                                       aria-describedby="basic-addon1">
                            </div>
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
                    <div class="shadow-sm p-3 mb-5 bg-white rounded">
                        <h2>Staff Email</h2>
                    </div>
                    <div class="text-primary">
                        <c:if test="${staffInfo.email != null}">
                            <div class="shadow-none p-3 mb-5 bg-light rounded">
                                <p>${staffInfo.email}</p>
                            </div>
                        </c:if>
                        <c:if test="${staffInfo.email == null}">
                            <div class="shadow-none p-3 mb-5 bg-light rounded">
                                <p>未设置</p>
                            </div>
                        </c:if>
                    </div>
                    <c:if test="${sessionScope.staff != null}">
                        <form action="<c:url value="/Staff/editStaff"/>" method="post">
                            <div class="form-floating">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="basic-addon4">New Email</span>
                                    </div>
                                    <input name="email" type="text" id="floatingInput3" class="form-control"
                                           placeholder="name@example.com" aria-label="name@example.com"
                                           aria-describedby="basic-addon1">
                                </div>
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
                    <div class="shadow-sm p-3 mb-5 bg-white rounded">
                        <h2>Staff Department</h2>
                    </div>
                    <div class="text-primary shadow-none p-3 mb-5 bg-light rounded">
                        <c:if test="${staffInfo.department != null}">
                            <p>${staffInfo.department}</p>
                        </c:if>
                        <c:if test="${staffInfo.department == null}">
                            <p>未设置</p>
                        </c:if>
                    </div>
                    <c:if test="${sessionScope.administrator != null}">
                        <form action="<c:url value="/Admin/editStaff"/>" method="post">
                            <div class="form-floating">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="basic-addon5">New Department</span>
                                    </div>
                                    <input name="department" type="number" id="floatingInput4" class="form-control"
                                           placeholder="new department" aria-label="new department"
                                           aria-describedby="basic-addon1">
                                </div>
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
                        <div class="shadow-sm p-3 mb-5 bg-white rounded">
                            <h2>Password</h2>
                        </div>
                        <div class="text-primary shadow-none p-3 mb-5 bg-light rounded">
                            <p>you can change password here!</p>
                        </div>

                        <form action="<c:url value="/Staff/changePassword"/>" method="post">
                            <div class="form-floating">
                                <div class="input-group mb-3">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text" id="basic-addon1">新密码</span>
                                    </div>
                                    <input name="password1" type="password" id="floatingInput5" class="form-control"
                                           placeholder="new password" aria-label="new password"
                                           aria-describedby="basic-addon1">
                                </div>
                                <div class="input-group mb-3">
                                    <div class="input-group-append">
                                        <span class="input-group-text" id="basic-addon2">请再次输入</span>
                                    </div>
                                    <input name="password2" type="password" id="floatingInput6" class="form-control"
                                           placeholder="new password again" aria-label="new password again"
                                           aria-describedby="basic-addon2">
                                </div>
                            </div>
                            <button class="w-100 btn btn-lg btn-primary" type="submit">click to update</button>
                        </form>
                    </div>
                </c:if>
            </div>
        </div>
    </div>

    <div class="b-example-divider"></div>

    <div class="container px-4 py-5" id="custom-cards">
        <h2 class="pb-2 border-bottom shadow p-3 mb-5 bg-white rounded">Salary</h2>
        <br/>
        <c:if test="${sessionScope.administrator != null}">
            <a href="/Admin/addSalary/${staffInfo.id}">
                <button type="button" class="btn btn-success">
                    Add Salary
                </button>
            </a>
        </c:if>
        <br/>
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

    <div class="container px-4 py-5" id="icon-grid">
        <h2 class="pb-2 border-bottom shadow p-3 mb-5 bg-white rounded">Personal Income Tax</h2>
        <div>
            <div class="bd-example">
                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th scope="col">year</th>
                        <th scope="col">tax</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${taxInfo}" var="tax">
                        <tr>
                            <td>${tax.first}</td>
                            <td>${tax.second}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</main>

</body>
</html>
