
<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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
    <form action="admin-add-user" method="post" id="userForm" role="form">
        <c:if test="${empty action}">
            <c:set var="action" value="add"/>
        </c:if>
        <input type="hidden" id="action" name="action" value="${action}">

        <div class="form-group col-xs-4">
            <label for="name" class="control-label col-xs-4"><spring:message code="users.name"/></label>
            <input type="text" name="name" id="name" class="form-control" required>

            <label for="email" class="control-label col-xs-4"><spring:message code="users.email"/></label>
            <input type="text" name="email" id="email" class="form-control" required>

            <label for="sex" class="control-label col-xs-4"><spring:message code="users.sex"/></label>
            <input type="text" name="sex" id="sex" class="form-control" required>

            <label for="phone" class="control-label col-xs-4"><spring:message code="users.phone"/></label>
            <input type="text" name="phone" id="phone" class="form-control" required>

            <label for="password" class="control-label col-xs-4"><spring:message code="users.password"/></label>
            <input type="text" name="password" id="password" class="form-control" required>
            </br>
            <button type="submit" class="btn btn-primary btn-md"><spring:message code="accept"/></button>
        </div>
    </form>

    <custom:tags errorMessages="${errorMessages}" bundle="${bundle}" locale="${locale}"></custom:tags>
</div>
<c:import url="components/footer.jsp"/>
</body>
</html>
