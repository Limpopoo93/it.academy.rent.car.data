<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Aleksandr
  Date: 12.03.2020
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
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
