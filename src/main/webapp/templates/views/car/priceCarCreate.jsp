<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="login-page">
    <div class="form">
        <%--@elvariable id="priceCar" type="it.academy.rent.bean.PriceCar"--%>
        <form:form class="register-form" action="${pageContext.request.contextPath}/createPrice"
                   modelAttribute="priceCar" method="post">

            <form:errors path="priceCar" cssStyle="color: red"/>
            <form:input path="priceCar" type="text" placeholder="priceCar"/>

            <form:errors path="namePrice" cssStyle="color: red"/>
            <form:input path="namePrice" type="text" placeholder="namePrice"/>

            <form:errors path="car.id" cssStyle="color: red"/>
            <form:input path="car.id" type="text" placeholder="indefNomerCar"/>

            <button>Registration</button>
        </form:form>
    </div>
</div>
</body>
</html>
