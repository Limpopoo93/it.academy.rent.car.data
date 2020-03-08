<%--
  Created by IntelliJ IDEA.
  User: Aleksandr
  Date: 08.03.2020
  Time: 21:02
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
        <form:form class="register-form" action="${pageContext.request.contextPath}/user-create-info"
                   modelAttribute="user" method="post">

            <form:errors path="name" cssStyle="color: red"/>
            <form:input path="name" type="text" placeholder="name"/>

            <form:errors path="surname" cssStyle="color: red"/>
            <form:input path="surname" type="text" placeholder="surname"/>

            <form:errors path="age" cssStyle="color: red"/>
            <form:input path="age" type="text" placeholder="age"/>

            <button>Registration</button>
        </form:form>
    </div>
</div>
</body>
</html>
