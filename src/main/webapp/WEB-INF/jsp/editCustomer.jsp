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
            <h1 class="title">Edit Customer Here</h1>
            <form action="http://localhost:8081/customer/update" method="get">
                <input type="text" id="cif" name="cif"  > cif <br>
                <input type="text" id="name" name="name" > name <br>
                <input type="text" id="nationalCode" name="nationalCode"> nationalCode <br>
                <input type="text" id="age" name="age"> age <br>
                <input class="submit-btn" type="submit" value="edit account">
            </form>
        </section>
    </div>
</div>

</body>
