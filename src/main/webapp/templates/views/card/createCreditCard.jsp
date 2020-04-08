<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="login-page">
    <div class="form">

        <%--@elvariable id="card" type="it.academy.rent.car.bean.Card"--%>
        <form:form class="register-form" action="${pageContext.request.contextPath}user/createCreditCard"
                   modelAttribute="card" method="post">

            <form:errors path="nameUser" cssStyle="color: red"/>
            <form:input path="nameUser" type="text" placeholder="nameUser"/>

            <form:errors path="keyCard" cssStyle="color: red"/>
            <form:input path="keyCard" type="text" placeholder="keyCard"/>

            <form:errors path="carDate" cssStyle="color: red"/>
            <form:input path="carDate" type="date" placeholder="date"/>

            <form:errors path="keySecurity" cssStyle="color: red"/>
            <form:input path="keySecurity" type="text" placeholder="keySecurity"/>

            <form:errors path="keys" cssStyle="color: red"/>
            <form:input path="keys" type="text" placeholder="keys"/>

            <button>Registration</button>
        </form:form>
    </div>
</div>
</body>
</html>
