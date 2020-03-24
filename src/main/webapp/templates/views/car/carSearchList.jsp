<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aleksandr
  Date: 23.03.2020
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>nameCar</th>
        <th>typeFuel</th>
        <th>colDoors</th>
        <th>colPeople</th>
        <th>mileage</th>
        <th>makeCar</th>
        <th>typeCar</th>
        <th>Name Company</th>
        <th>Book Car</th>
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
            <td>${car.getCompany().getNameCompany()}</td>
            <td> <form action="<c:url value="/bookCarId/${car.id}"/>" method="get">
                <button class="button block"><i class="fa fa-lock">Book Car</i>
                </button>
            </form></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
