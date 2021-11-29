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

<title>Book Orders</title>
</head>
<body>
<c:import url="components/header.jsp"/>
<div class="container">

    <form action="librarian-orders" method="post" id="bookForm" role="form">
        <input type="hidden" id="action" name="action">
        <input type="hidden" id="orderId" name="orderId">

    <h2><spring:message code="book.orders"/></h2>
    </br>
    </br>

    <table class="table">
        <thead>
        <tr>
            <td><spring:message code="orders.#"/></td>
            <td><spring:message code="header.users"/></td>
            <td><spring:message code="books.book.name"/></td>
            <td><spring:message code="orders.book.spot"/></td>
            <td><spring:message code="orders.status"/></td>
            <td><spring:message code="orders.return.date"/></td>
            <td></td>
        </tr>
        </thead>
        <c:forEach items="${orders}" var="order" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td>${order.user.name}</td>
            <td>${order.book.bookName}</td>
            <td>
                <c:if test="${order.bookSpot == 'ABONEMENT'}">
                <spring:message code="abonement"/>
            </c:if>
                <c:if test="${order.bookSpot == 'LIBRARY_HALL'}">
                    <spring:message code="library.hall"/>
                </c:if>
            </td>
            <td><c:if test="${order.status == 'EXPECTED'}">
                <spring:message code="expected"/>
            </c:if>
                <c:if test="${order.status == 'CHECKED_OUT'}">
                    <spring:message code="checked.out"/>
                </c:if>
                <c:if test="${order.status == 'RETURNED'}">
                    <spring:message code="returned"/>
                </c:if>
            </td>
            <td>${order.returnDate}</td>
            <td>
                <c:if test="${order.status == 'EXPECTED'}">
                <a href="#" id="checked out"
                   onclick="document.getElementById('action').value = 'CHECKED_OUT';
                   document.getElementById('orderId').value = ${order.id};
                           document.getElementById('bookForm').submit();">
                    <spring:message code="check.out"/>
                </a>
                </c:if>
                <c:if test="${order.status  == 'CHECKED_OUT'}">
                    <a href="#" id="checked out"
                       onclick="document.getElementById('action').value = 'RETURNED';
                               document.getElementById('orderId').value = ${order.id};
                               document.getElementById('bookForm').submit();">
                        <spring:message code="returned"/>
                    </a>
                </c:if>
            </td>
        </tr>
        </c:forEach>
    </table>
    </form>

</div>
<c:import url="components/footer.jsp"/>

</body>
</html>
