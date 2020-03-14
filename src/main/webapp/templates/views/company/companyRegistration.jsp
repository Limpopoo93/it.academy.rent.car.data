<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="login-page">
    <div class="form">
        <%--@elvariable id="company" type="it.academy.rent.bean.Company"--%>
        <form:form class="register-form" action="${pageContext.request.contextPath}/createCompany"
                   modelAttribute="company" method="post">

            <form:errors path="nameCompany" cssStyle="color: red"/>
            <form:input path="nameCompany" type="text" placeholder="nameCompany"/>

            <form:errors path="telephone" cssStyle="color: red"/>
            <form:input path="telephone" type="text" placeholder="telephone"/>

            <form:errors path="email" cssStyle="color: red"/>
            <form:input path="email" type="text" placeholder="email"/>

            <button>Registration</button>
        </form:form>
    </div>
</div>
</body>
</html>
