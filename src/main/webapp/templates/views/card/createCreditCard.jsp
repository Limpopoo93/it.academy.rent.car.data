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
        <form:form class="register-form" action="${pageContext.request.contextPath}/createCreditCard"
                   modelAttribute="authenticate" method="post">

            <form:errors path="keyCard" cssStyle="color: red"/>
            <form:input path="keyCard" type="text" placeholder="keyCard"/>

            <form:errors path="date" cssStyle="color: red"/>
            <form:input path="date" type="date" placeholder="date"/>

            <form:errors path="nameUser" cssStyle="color: red"/>
            <form:input path="nameUser" type="text" placeholder="nameUser"/>

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
