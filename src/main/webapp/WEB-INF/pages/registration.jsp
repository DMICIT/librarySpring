
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value = "${pageContext.request.contextPath}"/>
<%--<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>

<head>
    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script></head>

<title><spring:message code="registration.registration"/></title>
</head>

<body>
<c:import url="components/header.jsp"/>
<div class="container">

<h2><spring:message code="registration.registration.form"/></h2>
</br>
</br>
<form:form action="registration" method="post" modelAttribute="registrationForm" >
    <div class="mb-3">
        <form:label path="name" class="form-label"><spring:message code="registration.name"/></form:label>
        <form:input type="text" pattern="[A-Za-zА-Яа-я0-9 ]*" placeholder="Enter only letters" class="form-control" path="name"  />
        <form:errors path="name" cssClass="text-danger"/>

    </div>
    <div class="mb-3">
        <form:label path="email" class="form-label"><spring:message code="registration.email"/></form:label>
        <form:input type="text" pattern="^[A-Za-z0-9+_.-]+@(.+)$" placeholder="Enter correct email adress" class="form-control" path="email" />
        <form:errors path="email" cssClass="text-danger"/>

    </div>
    <div class="mb-3">
        <form:label path="password" class="form-label"><spring:message code="registration.password"/></form:label>
        <form:input type="password"  pattern="^(?=.*?[A-Za-z0-9#?!@$%^&*-]){4,}$" placeholder="You can use letters, digits and #?!@$%^&*- symbols. Password should be more than 4 symbols "  class="form-control" path="password" />
        <form:errors path="password" cssClass="text-danger"/>

    </div>
    <div class="mb-3">
        <form:label path="confirmPassword" class="form-label"><spring:message code="registration.confirm.password"/></form:label>
        <form:input type="password"  pattern="^[A-Za-z0-9#?!@$%^&*-]{4,}$" placeholder="You can use letters, digits and #?!@$%^&*- symbols." class="form-control" path="confirmPassword" />
        <form:errors path="confirmPassword" cssClass="text-danger"/>

    </div>
    <div class="mb-3">
        <form:label path="phone" class="form-label"><spring:message code="registration.phone"/></form:label>
        <form:input type="text" pattern="[0-9+]*" placeholder="Enter only digits"  class="form-control" path ="phone"/>
        <form:errors path="phone" cssClass="text-danger"/>

    </div>
  <div class="mb-3">
      <form:label path="gender" class="form-label"><spring:message code="registration.sex"/></form:label>
      <form:select class="form-control" path ="gender">
          <form:option value="MAN"><spring:message code="sex.man"/></form:option>
          <form:option value="WOMAN"><spring:message code="sex.woman"/></form:option>
      </form:select>
      <form:errors path="gender" cssClass="text-danger"/>
  </div>

    <form:errors element="formErrors" cssClass="text-danger"/>
    <br/>


    <button class= "btn btn-primary" type="submit"><spring:message code="registration.register"/></button>
</form:form>

<%--    <custom:tags errorMessages="${errorMessages}" locale="${locale}" bundle="${bundle}"></custom:tags>--%>
</div>

<c:import url="components/footer.jsp"/>
</body>
</html>
