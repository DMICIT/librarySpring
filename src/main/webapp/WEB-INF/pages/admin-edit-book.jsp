<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html>

<head>
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script></head>


<title>Books</title>
</head>
<body>
<c:import url="components/header.jsp"/>
<div class="container">

    <h2><spring:message code="books.header"/></h2>

    <form:form action="admin-edit-book" method="post" id="bookForm" role ="form" modelAttribute = "adminEditBookForm">

        <form:input type="hidden" path ="bookId" />

        <div class ="form-group col-xs-4">
            <form:label path="author" class="control-label col-xs-4"><spring:message code="books.author"/></form:label>
            <form:input type = "text" path = "author" class="form-control"  required="true"/>
            <form:errors path="author" cssClass="text-danger"/>


            <form:label path="bookName" class="control-label col-xs-4"><spring:message code="books.book.name"/></form:label>
            <form:input type = "text" path = "bookName" class="form-control" required="true"/>
            <form:errors path="bookName" cssClass="text-danger"/>


            <form:label path="bookEdition" class="control-label col-xs-4"><spring:message code="books.edition"/></form:label>
            <form:input type = "text" path = "bookEdition" class="form-control" required="true"/>
            <form:errors path="bookEdition" cssClass="text-danger"/>


            <form:label path="releaseDate" class="control-label col-xs-4"><spring:message code="books.date.of.reliase"/></form:label>
            <form:input type = "text" path = "releaseDate" class="form-control" required="true"/>
            <form:errors path="releaseDate" cssClass="text-danger"/>


            <form:label path="count" class="control-label col-xs-4"><spring:message code="count"/></form:label>
            <form:input type = "text" path = "count" class="form-control"  required="true"/>
            <form:errors path="count" cssClass="text-danger"/>

            </br>
            <button type="submit" class="btn btn-primary btn-md">Accept</button>
        </div>
    </form:form>

</div>
<c:import url="components/footer.jsp"/>
</body>
</html>
