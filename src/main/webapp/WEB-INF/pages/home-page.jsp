
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value = "${pageContext.request.contextPath}"/>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


<html>

<head>
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script></head>

<body>
<c:import url="components/header.jsp"/>

<div class="container">

    <div class="p-5 mb-4 bg-light rounded-3">
        <div class="container-fluid">
            <h1 class="display-5 fw-bold" style="text-align: center"><spring:message code="index.welcome"/></h1>
            <img src="img/library.jpeg" class="mx-auto" style="width: 100%">
            <p class="col-md-8 fs-4">Scientia nihil aliud est quam veritas.</p>
            <a class="btn btn-primary btn-lg" href="books"><spring:message code="books.header"/></a>
        </div>
    </div>
</div>

<c:import url="components/footer.jsp"/>
</body>
</html>
