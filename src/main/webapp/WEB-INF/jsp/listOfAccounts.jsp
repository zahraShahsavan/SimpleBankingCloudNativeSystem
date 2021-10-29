<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="<c:url value="/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css"/>" rel="stylesheet">
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
</head>
<body>

<%@include file="header.jsp"%>
<div class="container">
<br>


    <table class="table table-striped">
        <thead >
        <tr>
            <td scope="col" >aid</td>
            <td scope="col" >cif</td>
            <td scope="col" >amount</td>

        </tr>
        </thead>
        <c:forEach items="${accountList}" var="account">
            <tbody>

            <td scope="row" > <c:out value="${account.aid}"/> </td>
            <td scope="row"> <c:out value="${account.cif}"/> </td>
            <td scope="row"> <c:out value="${account.amount}"/> </td>

            <security:authorize access="hasRole('USER')">
            <td scope="row"><a href="/ui/account/update" class="btn btn-dark">Edit</a></td>
            <td scope="row"><a href="/ui/account/deletebyid?id=${account.aid}" class="btn btn-danger">Delete</a></td>
            </security:authorize>

            <td scope="row">
            </td>
            </tbody>
        </c:forEach>
    </table>
    <security:authorize access="hasRole('USER')">
        <a href="/ui/account/add" class="btn btn-success">Add New Account</a>

    </security:authorize>
</div>
</body>

</html>