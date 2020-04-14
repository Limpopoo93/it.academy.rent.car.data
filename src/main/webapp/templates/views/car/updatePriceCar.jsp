<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Price Form</title>
</head>
<body>
<table>
    <tr>
        <th>name price</th>
        <th>price</th>
        <th>name car</th>
        <th>make car</th>
        <th>company</th>

    </tr>
    <tr>
        <td>
        <td>${requestScope.priceCar.namePrice}</td>
        <td>
        <td>${requestScope.priceCar.priceCar}</td>
        <td>
        <td>${requestScope.priceCar.car.nameCar}</td>
        <td>
        <td>${requestScope.priceCar.car.makeCar}</td>
        <td>
        <td>${requestScope.priceCar.car.company.nameCompany}</td>
    </tr>
</table>

<%--@elvariable id="priceCar" type="it.academy.rent.car.bean.PriceCar"--%>
<form:form class="register-form"
           action="${pageContext.request.contextPath}updatePrice"
           modelAttribute="priceCar" method="post">
    <div class="form">
        <form:errors path="namePrice" cssStyle="color: red"/>
        <form:input path="namePrice" type="text" placeholder="namePrice"/>

        <form:errors path="priceCar" cssStyle="color: red"/>
        <form:input path="priceCar" type="password" placeholder="priceCar"/>

        <div class="send-button">
            <input type="submit" value="Update">
        </div>
    </div>
</form:form>
</body>
</html>
