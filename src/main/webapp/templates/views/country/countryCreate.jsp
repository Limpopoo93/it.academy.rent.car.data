<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="login-page">
    <div class="form">
        <%--@elvariable id="country" type="it.academy.rent.bean.Country"--%>
        <form:form class="register-form" action="${pageContext.request.contextPath}/countryRegistration"
                   modelAttribute="country" method="post">

            <form:errors path="country" cssStyle="color: red"/>
            <form:input path="country" type="text" placeholder="country"/>

            <button>Registration</button>
        </form:form>
    </div>
</div>
</body>
</html>
