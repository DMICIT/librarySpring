<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dmytro
  Date: 10/21/21
  Time: 10:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<c:set var="contextPath" value = "${pageContext.request.contextPath}"/>
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
<form action="admin-delete-book" method="post" id="bookForm" role ="form">
    <input type="hidden" id ="bookId" name ="bookId">

    <table class="table">
        <thead>
        <tr>
            <td><spring:message code="books.#"/></td>
            <td><spring:message code="books.author"/>
                <a style="text-decoration: none;"
                   href="admin-books?sort=author${not empty param.search ? '&search=' += param.search  : ''}${not empty param.page ? '&page=' += param.page : ''}">&#9650;</a>
                <a style="text-decoration: none;"
                   href="admin-books?sort=author&order=desc${not empty param.search ? '&search' += param.search : ''}${not empty param.page ? '&page=' += param.page : ''}">&#9660;</a>
            </td>

            <td><spring:message code="books.book.name"/>
                <a style="text-decoration: none;"
                   href="admin-books?sort=bookName${not empty param.search ? '&search=' += param.search : ''}${not empty param.page ? '&page=' += param.page : ''}">&#9650;</a>
                <a style="text-decoration: none;"
                   href="admin-books?sort=bookName&order=desc${not empty param.search ? '&search=' += param.search : ''}${not empty param.page ? '&page=' += param.page : ''}">&#9660;</a>
            </td>
            <td><spring:message code="books.edition"/>
                <a style="text-decoration: none;"
                   href="admin-books?sort=bookEdition${not empty param.search ? '&search=' += param.search : ''}${not empty param.page ? '&page=' += param.page : ''}">&#9650;</a>
                <a style="text-decoration: none;"
                   href="admin-books?sort=bookEdition&order=desc${not empty param.search ? '&search=' += param.search : ''}${not empty param.page ? '&page=' += param.page : ''}">&#9660;</a>
            </td>
            <td><spring:message code="books.date.of.reliase"/>
                <a style="text-decoration: none;"
                   href="admin-books?sort=releaseDate${not empty param.search ? '&search=' += param.search : ''}${not empty param.page ? '&page=' += param.page : ''}">&#9650;</a>
                <a style="text-decoration: none;"
                   href="admin-books?sort=releaseDate&order=desc${not empty param.search ? '&search=' += param.search : ''}${not empty param.page ? '&page=' += param.page : ''}">&#9660;</a>
            </td>
            <td><spring:message code="books.quantity"/></td>
            <td></td>
        </tr>
        </thead>

        <c:forEach items="${booksData.content}" var="book">
            <tr>
                <td><a href="admin-edit-book?id=${book.id}">${book.id}</a></td>
                <td>${book.author}</td>
                <td>${book.bookName}</td>
                <td>${book.bookEdition}</td>
                <td>${book.releaseDate}</td>
                <td>${book.catalogData.totalQuantity}</td>
                <td><a href="#" id="remove"
                onclick="document.getElementById('bookId').value = '${book.id}';
                document.getElementById('bookForm').submit();">
                    delete
                </a>
                </td>
            </tr>
        </c:forEach>
    </table>

<c:if test="${ booksData.pageable.pageNumber != 0}">
    <a href="admin-books?page=${booksData.pageable.pageNumber -1}${not empty param.search ? '&search=' += param.search : ''}${not empty param.sort ? '&sort=' += param.sort : ''}${not empty param.order ? '&order=' += param.order : ''}">
        <spring:message code="previous"/>
    </a>
</c:if>

<c:forEach begin="0" end="${booksData.totalPages -1}" var="i">
    <c:choose>
        <c:when test="${booksData.pageable.pageNumber  eq i}">
            ${i+1}
        </c:when>
        <c:otherwise>
            <a href="admin-books?page=${i}${not empty param.search ? '&search=' += param.search : ''}${not empty param.sort ? '&sort=' += param.sort : ''}${not empty param.order ? '&order=' += param.order : ''}">
                    ${i+1}
            </a>
        </c:otherwise>
    </c:choose>
</c:forEach>

<c:if test="${booksData.pageable.pageNumber  lt booksData.totalPages -1}">
    <a href="admin-books?page=${booksData.pageable.pageNumber +1}${not empty param.search ? '&search=' += param.search : ''}${not empty param.sort ? '&sort=' += param.sort : ''}${not empty param.order ? '&order=' += param.order : ''}">
    <spring:message code="next"/>
    </a>
</c:if>

</form>
<a href="admin-edit-book" class="btn btn-primary btn-md"><spring:message code="new.book"/></a>
</div>
<c:import url="components/footer.jsp"/>
</body>
</html>
