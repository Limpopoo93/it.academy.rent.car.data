<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aleksandr
  Date: 08.03.2020
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Letter List Admin</title>
</head>
<body>
<h2>Letters</h2>
<table class="blueTable">
    <thead>
    <tr>
        <th>login</th>
        <th>password</th>
        <th>email</th>
        <th>letter</th>
        <th>UnBlock</th>
        <th>Delete Letter</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${letters}" var="letter">
        <td>${letter.authenticate.getLogin()}</td>
        <td>${letter.authenticate.getPassword()}</td>
        <td>${letter.authenticate.getEmail()}</td>
        <td>${letter.getLetter()}</td>
        <form action="<c:url value="/user-unBlockId/${letter.authenticate.getId()}"/>" method="get">
            <button class="button block"><i class="fa fa-lock">UnBlock</i>
            </button>
        </form>
        <form action="<c:url value="/user-deleteId/${letter.getId()}"/>" method="get">
            <button class="button block"><i class="fa fa-lock">DeleteLetter</i>
            </button>
        </form>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
