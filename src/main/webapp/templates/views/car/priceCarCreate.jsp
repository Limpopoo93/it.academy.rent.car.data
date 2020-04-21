<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Price</title>
</head>
<body>
<table>
    <thead>
    <tr>

        <th>name Car</th>
        <th>type Fuel</th>
        <th>col Doors</th>
        <th>col People</th>
        <th>mileage</th>
        <th>make Car</th>
        <th>type Car</th>
        <th>company</th>
        <th>unblock User</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${cars}" var="car">
        <tr>
            <td>${car.getNameCar()}</td>
            <td>${car.getTypeFuel()}</td>
            <td>${car.getColDoors()}</td>
            <td>${car.getColPeople()}</td>
            <td>${car.getMileage()}</td>
            <td>${car.getMakeCar()}</td>
            <td>${car.getTypeCar()}</td>
            <td>${car.company.getNameCompany()}</td>
            <td>
                <form action="<c:url value="createPriceCar/${car.id}"/>" method="get" modelAttribute="priceCar">
                    <form:errors path="namePrice" cssStyle="color: red"/>
                    <form:input path="namePrice" type="text" placeholder="namePrice"/>

                    <form:errors path="priceCar" cssStyle="color: red"/>
                    <form:input path="priceCar" type="text" placeholder="priceCar"/>

                    <button class="button block"><i class="fa fa-lock">Create Price</i>
                    </button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
