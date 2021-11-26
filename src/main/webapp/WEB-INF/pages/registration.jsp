
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value = "${pageContext.request.contextPath}"/>
<%--<%@ taglib prefix="custom" tagdir="/WEB-INF/tags" %>--%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

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
<form action="registration" method="post" >
    <div class="mb-3">
        <label for="name" class="form-label"><spring:message code="registration.name"/></label>
        <input type="text" pattern="[A-Za-zА-Яа-я0-9 ]*" placeholder="Enter only letters" class="form-control" id="name" name="name" >
    </div>
    <div class="mb-3">
        <label for="email" class="form-label"><spring:message code="registration.email"/></label>
        <input type="text" pattern="^[A-Za-z0-9+_.-]+@(.+)$" placeholder="Enter correct email adress" class="form-control" id="email" name="email">
    </div>
    <div class="mb-3">
        <label for="password" class="form-label"><spring:message code="registration.password"/></label>
        <input type="password"  pattern="^(?=.*?[A-Za-z0-9#?!@$%^&*-]){4,}$" placeholder="You can use letters, digits and #?!@$%^&*- symbols. Password should be more than 4 symbols "  class="form-control" id="password" name="password">
    </div>
    <div class="mb-3">
        <label for="confirm_password" class="form-label"><spring:message code="registration.confirm.password"/></label>
        <input type="password"  pattern="^[A-Za-z0-9#?!@$%^&*-]{4,}$" placeholder="You can use letters, digits and #?!@$%^&*- symbols." class="form-control" id="confirm_password" name="confirm_password">
    </div>
    <div class="mb-3">
        <label for="phone" class="form-label"><spring:message code="registration.phone"/></label>
        <input type="text" pattern="[0-9+]*" placeholder="Enter only digits"  class="form-control" id ="phone" name ="phone">
    </div>
  <div class="mb-3">
      <label for="sex" class="form-label"><spring:message code="registration.sex"/></label>
      <select class="form-control" id ="sex" name ="sex">
          <option value="man"><spring:message code="sex.man"/></option>
          <option value="woman"><spring:message code="sex.woman"/></option>
      </select>
  </div>

    <button class= "btn btn-primary" type="submit"><spring:message code="registration.register"/></button>
</form>

<%--    <custom:tags errorMessages="${errorMessages}" locale="${locale}" bundle="${bundle}"></custom:tags>--%>
</div>

<c:import url="components/footer.jsp"/>
</body>
</html>
