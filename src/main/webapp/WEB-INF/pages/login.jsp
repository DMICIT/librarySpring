
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>--%>
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

<title><spring:message code="login.login"/></title>
</head>
<body>
<c:import url="components/header.jsp"/>
<div class="container">

    <h2><spring:message code="login.login.form"/></h2>
    </br>
    </br>
    <form action="login" method="post">

        <div class="mb-3">
            <label for="email" class="form-label"><spring:message code="login.email"/></label>
            <input type="text" class="form-control" id="email" name="email">
        </div>

        <div class="mb-3">
            <label for="password" class="form-label"><spring:message code="login.password"/></label>
            <input type="password" class="form-control" id="password" name="password">
        </div>

        <button class="btn btn-primary" type="submit"><spring:message code="login.login"/></button>
    </form>

<%--    <custom:tags errorMessages="${errorMessages}" bundle="${bundle}" locale="${locale}"></custom:tags>--%>
</div>
<c:import url="components/footer.jsp"/>
</body>
</html>
