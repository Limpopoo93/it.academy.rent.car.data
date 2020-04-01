<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select Car</title>
</head>
<body>
<div class="login-page">
    <div class="form">
        <%--@elvariable id="car" type="it.academy.rent.car.bean.Car"--%>
        <form:form class="register-form" action="${pageContext.request.contextPath}/createPrice"
                   modelAttribute="car" method="post">

            <form:errors path="nameCar" cssStyle="color: red"/>
            <form:input path="nameCar" type="text" placeholder="nameCar"/>

            <form:errors path="makeCar" cssStyle="color: red"/>
            <form:input path="makeCar" type="text" placeholder="makeCar"/>

            <form:errors path="company.nameCompany" cssStyle="color: red"/>
            <form:input path="company.nameCompany" type="text" placeholder="nameCompany"/>

            <form:errors path="company.town.town" cssStyle="color: red"/>
            <form:input path="company.town.town" type="text" placeholder="town"/>

            <form:errors path="company.town.country.country" cssStyle="color: red"/>
            <form:input path="company.town.country.country" type="text" placeholder="country"/>

            <button>Registration</button>
        </form:form>
    </div>
</div>
</body>
</html>
