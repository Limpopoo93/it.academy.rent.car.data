<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%--@elvariable id="letter" type="it.academy.rent.car.bean.Letter"--%>
<form:form class="register-form" action="${pageContext.request.contextPath}/pushLetter"
           modelAttribute="letter" method="post">

    <form:errors path="textLetter" cssStyle="color: red"/>
    <form:input path="textLetter" type="text" placeholder="letter"/>

    <button>Come In</button>
</form:form>
</body>
</html>
