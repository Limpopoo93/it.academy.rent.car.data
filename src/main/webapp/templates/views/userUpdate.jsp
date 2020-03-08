<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Aleksandr
  Date: 08.03.2020
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="login-page">
    <div class="form">
        <%--@elvariable id="authenticate" type="it.academy.rent.bean.Authenticate"--%>
        <form:form class="register-form" action="${pageContext.request.contextPath}/user-update-form"
                   modelAttribute="authenticate" method="post">

            <form:errors path="login" cssStyle="color: red"/>
            <form:input path="login" type="text" placeholder="_login"/>

            <form:errors path="password" cssStyle="color: red"/>
            <form:input path="password" type="text" placeholder="_password"/>

            <form:errors path="email" cssStyle="color: red"/>
            <form:input path="email" type="text" placeholder="_email"/>

            <form:errors path="profileClose" cssStyle="color: red"/>
            <form:input path="profileClose" type="text" placeholder="profileClose"/>

            <form:errors path="profileEnable" cssStyle="color: red"/>
            <form:input path="profileEnable" type="text" placeholder="profileEnable"/>

            <form:errors path="role" cssStyle="color: red"/>
            <form:input path="role" type="text" placeholder="role"/>

            <button>Update</button>
        </form:form>
    </div>
</div>
</body>
</html>