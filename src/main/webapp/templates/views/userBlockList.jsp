<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aleksandr
  Date: 08.03.2020
  Time: 13:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Users</h2>
<table class="blueTable">
    <thead>
    <tr>
        <th>login</th>
        <th>password</th>
        <th>email</th>
        <th>role</th>
        <th>profile Enable</th>
        <th>profile Close</th>
        <th>UnBlockUser</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${authenticates}" var="authenticate">
        <td>${authenticate.getLogin()}</td>
        <td>${authenticate.getPassword()}</td>
        <td>${authenticate.getEmail()}</td>
        <td>${authenticate.isProfileClose()}</td>
        <td>${authenticate.isProfileEnable()}</td>
        <form action="<c:url value="/user-unBlock/${authenticate.id}"/>" method="get">
            <button class="button block"><i class="fa fa-lock">UnBlock User</i>
            </button>
        </form>
</table>

</body>
</html>
