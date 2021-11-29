<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
</head>


<title><spring:message code="header.users"/></title>
</head>
<body>

<c:import url="components/header.jsp"/>
<div class="container">
    <form action="user-list" method="post" id="userForm" role="form">
        <input type="hidden" id ="bookId" name ="bookId">


        <h2><spring:message code="header.users"/></h2>

    <table class="table">
        <thead>
        <tr>
            <td><spring:message code="users.#"/></td>
            <td><spring:message code="users.name"/></td>
            <td><spring:message code="users.email"/></td>
            <td></td>
        </tr>
        </thead>

        <c:forEach items="${allUsers}" var="user" varStatus="loop">
            <tr>
                <td>${loop.count}</td>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>
                    <a href="user-abonement?userId=${user.id}"><spring:message code="abonement"/></a>
                </td>

            </tr>
        </c:forEach>

    </table>
</div>
<c:import url="components/footer.jsp"/>

</body>
</html>
