<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="login-page">
    <div class="form">

        <%--@elvariable id="car" type="it.academy.rent.car.bean.Car"--%>
        <form:form class="register-form" action="${pageContext.request.contextPath}/createCar"
                   modelAttribute="car" method="post">

            <form:errors path="nameCar" cssStyle="color: red"/>
            <form:input path="nameCar" type="text" placeholder="nameCar"/>

            <form:errors path="typeFuel" cssStyle="color: red"/>
            <form:input path="typeFuel" type="text" placeholder="typeFuel"/>

            <form:errors path="colDoors" cssStyle="color: red"/>
            <form:input path="colDoors" type="text" placeholder="colDoors"/>

            <form:errors path="colPeople" cssStyle="color: red"/>
            <form:input path="colPeople" type="text" placeholder="colPeople"/>

            <form:errors path="mileage" cssStyle="color: red"/>
            <form:input path="mileage" type="text" placeholder="mileage"/>

            <form:errors path="makeCar" cssStyle="color: red"/>
            <form:input path="makeCar" type="text" placeholder="makeCar"/>

            <form:errors path="typeCar" cssStyle="color: red"/>
            <form:input path="typeCar" type="text" placeholder="typeCar"/>

            <form:errors path="company.nameCompany" cssStyle="color: red"/>
            <form:input path="company.nameCompany" type="text" placeholder="nameCompany"/>

            <form:errors path="price" cssStyle="color: red"/>
            <form:input path="price" type="text" placeholder="price"/>

            <button>Registration</button>
        </form:form>
    </div>
</div>
</body>
</html>