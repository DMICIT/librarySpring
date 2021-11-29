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

    <title>User abonement</title>
</head>
<body>

<c:import url="components/header.jsp"/>
<div class="container">

<h2>${user.userName}</h2>


<table class="table">
<thead>
<tr>

    <td><spring:message code="orders.#"/></td>
    <td><spring:message code="books.book.name"/></td>
    <td><spring:message code="books.author"/></td>
    <td><spring:message code="orders.book.spot"/></td>
    <td><spring:message code="orders.return.date"/></td>
    <td><spring:message code="orders.status"/></td>


</tr>
</thead>

<c:forEach items="${ordersByUser}" var="order">
    <tr>

        <td>${order.id}</td>
        <td>${order.bookData.bookName}</td>
        <td>${order.bookData.author}</td>
        <td> <c:if test="${order.bookSpot eq 'abonement'}">
            <spring:message code="abonement"/>
        </c:if>
            <c:if test="${order.bookSpot eq 'library hall'}">
                <spring:message code="library.hall"/>
            </c:if></td>
        <td>${order.returnDate}</td>
        <td>
            <c:if test="${order.status eq 'expected'}">
                <spring:message code="expected"/>
            </c:if>
            <c:if test="${order.status eq 'checked out'}">
                <spring:message code="checked.out"/>
            </c:if>
            <c:if test="${order.status eq 'returned'}">
                <spring:message code="returned"/>
            </c:if>
        </td>
    </tr>

    </c:forEach>
    </table>
    </div>
    <c:import url="components/footer.jsp"/>
    </body>
    </html>
