<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%--@elvariable id="authenticate" type="it.academy.rent.bean.Authenticate"--%>
<form:form class="register-form" action="${pageContext.request.contextPath}/pushLetter"
           modelAttribute="authenticate" method="post">

    <form:errors path="letter" cssStyle="color: red"/>
    <form:input path="letter" type="text" placeholder="letter"/>

    <button>Come In</button>
</form:form>
</body>
</html>
