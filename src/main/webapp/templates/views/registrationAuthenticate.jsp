<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <form:form class="register-form" action="${pageContext.request.contextPath}/user-create"
                   modelAttribute="authenticate" method="post">

            <form:errors path="login" cssStyle="color: red"/>
            <form:input path="login" type="text" placeholder="_login"/>

            <form:errors path="password" cssStyle="color: red"/>
            <form:input path="password" type="text" placeholder="_password"/>

            <form:errors path="email" cssStyle="color: red"/>
            <form:input path="email" type="text" placeholder="_email"/>

            <button>Registration</button>
        </form:form>
    </div>
</div>
</body>
</html>
