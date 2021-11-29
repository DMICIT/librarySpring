
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
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


<title>Users</title>
</head>
<body>
<c:import url="components/header.jsp"/>
<div class="container">

    <h2><spring:message code="users.librarian"/></h2>
    <form:form action="admin-add-librarian" method="post" id="userForm" role="form" modelAttribute = "adminAddLibrarianForm">

        <div class="form-group col-xs-4">
            <form:label path="name" class="control-label col-xs-4"><spring:message code="users.name"/></form:label>
            <form:input type="text" path="name" class="form-control" required="true"/>
            <form:errors path="name" cssClass="text-danger"/>


            <form:label path="email" class="control-label col-xs-4"><spring:message code="users.email"/></form:label>
            <form:input type="text" path="email"  class="form-control" required="true"/>
            <form:errors path="email" cssClass="text-danger"/>


            <form:label path="gender" class="control-label col-xs-4"><spring:message code="users.sex"/></form:label>
            <form:input type="text" path="gender" class="form-control" required="true"/>
            <form:errors path="gender" cssClass="text-danger"/>


            <form:label path="phone" class="control-label col-xs-4"><spring:message code="users.phone"/></form:label>
            <form:input type="text" path="phone" class="form-control" required="true"/>
            <form:errors path="phone" cssClass="text-danger"/>


            <form:label path="password" class="control-label col-xs-4"><spring:message code="users.password"/></form:label>
            <form:input type="text" path="password"  class="form-control" required="true"/>
            <form:errors path="password" cssClass="text-danger"/>

            </br>
            <button type="submit" class="btn btn-primary btn-md"><spring:message code="accept"/></button>
        </div>
    </form:form>

</div>
<c:import url="components/footer.jsp"/>
</body>
</html>
