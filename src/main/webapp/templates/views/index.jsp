<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul id="menu">
    <li><a href="/">Home</a></li>
    <li>
        <a>User </a>
        <ul class="hidden">
            <li><a href="${pageContext.request.contextPath}/adminCreate">Create Admin</a></li>
            <li><a href="${pageContext.request.contextPath}/users">List User</a></li>
            <li><a href="${pageContext.request.contextPath}/letterAdminList">List Letter to Admin</a></li>
            <li><a href="${pageContext.request.contextPath}/userBlockList">List Block User</a></li>
        </uL>
    </li>
<table>
    <tr>
        <th>name</th>
        <th>surname</th>
        <th>email</th>
        <th>age</th>
        <th>login</th>
        <th>password</th>
        <th>role</th>
        <th>profileEnable</th>
        <th>profileClose</th>
    </tr>
    <tr>
        <td>
        <td>${sessionScope.authenticate.login}</td>
        <td>
        <td>${sessionScope.authenticate.password}</td>
        <td>
        <td>${sessionScope.authenticate.profileEnable}</td>
        <td>
        <td>${sessionScope.authenticate.profileClose}</td>
        <td>
        <td>${sessionScope.authenticate.email}</td>
        <td>
        <td>${sessionScope.authenticate.role}</td>
        <td>
    </tr>
</table>
</ul>
</body>
</html>
