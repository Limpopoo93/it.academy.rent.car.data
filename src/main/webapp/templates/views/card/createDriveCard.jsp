<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="login-page">
    <div class="form">
        <%--@elvariable id="authenticate" type="it.academy.rent.bean.Authenticate"--%>
        <form:form class="register-form" action="${pageContext.request.contextPath}/createDriveCard"
                   modelAttribute="authenticate" method="post">

            <form:errors path="name" cssStyle="color: red"/>
            <form:input path="name" type="text" placeholder="name"/>

            <form:errors path="surname" cssStyle="color: red"/>
            <form:input path="surname" type="text" placeholder="surname"/>

            <form:errors path="country" cssStyle="color: red"/>
            <form:input path="country" type="text" placeholder="country"/>

            <form:errors path="dateMake" cssStyle="color: red"/>
            <form:input path="dateMake" type="text" placeholder="dateMake"/>

            <form:errors path="category" cssStyle="color: red"/>
            <form:input path="category" type="text" placeholder="category"/>

            <button>Registration</button>
        </form:form>
    </div>
</div>
</body>
</html>
