<%--<!DOCTYPE html>--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link href="<c:url value="/webjars/bootstrap/4.4.1-1/css/bootstrap.min.css"/>" rel="stylesheet">
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
</head>
<body>

<%@include file="header.jsp"%>
<div class="container">
<br>
    <div align="center">

        <section class="get-in-touch">
            <form action="http://localhost:8081/account/delete" method="get">
                Are you sure for delete this account?
                <input type="text" id="id" name="id" value="${id}"> id <br>
                <input class="submit-btn" type="submit" value="delete account">
            </form>

        </section>

    </div>
</div>

</body>
