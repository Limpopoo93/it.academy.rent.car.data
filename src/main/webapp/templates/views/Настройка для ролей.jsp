<%--
  Created by IntelliJ IDEA.
  User: Aleksandr
  Date: 14.04.2020
  Time: 8:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<sec:authorize access="hasRole('ROLE_ADMIN')">
</sec:authorize>
th:text="${error}"
</body>
</html>
