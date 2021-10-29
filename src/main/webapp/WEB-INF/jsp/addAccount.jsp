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

            <h1 class="title">Add New Account Here</h1>
            <form action="http://localhost:8081/account/add" method="get">
                <input type="text" id="customerId" name="customerId" > customerId <br>
                <input type="text" id="amount" name="amount"> amount <br>
                <input class="submit-btn" type="submit" value="add account">
            </form>

    </div>
</div>

</body>
