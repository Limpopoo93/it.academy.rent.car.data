<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <th>email</th>
        <th>login</th>
        <th>password</th>
        <th>role</th>
        <th>profile Close</th>
        <th>delete</th>
        <th>block User</th>
        <th>unblock User</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${authenticates}" var="authenticate">
        <td>${authenticate.getLogin()}</td>
        <td>${authenticate.getPassword()}</td>
        <td>${authenticate.getEmail()}</td>
        <td>${authenticate.isProfileClose()}</td>
        <td>${authenticate.getRole()}</td>
        <form action="<c:url value="/userDeleteId/${authenticate.id}"/>" method="get">
            <button class="button block"><i class="fa fa-lock">Delete</i>
            </button>
        </form>
        <form action="<c:url value="/userBlockId/${authenticate.id}"/>" method="get">
            <button class="button block"><i class="fa fa-lock">Block User</i>
            </button>
        </form>
        <form action="<c:url value="/userUnBlockId/${authenticate.id}"/>" method="get">
            <button class="button block"><i class="fa fa-lock">Unblock User</i>
            </button>
        </form>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
