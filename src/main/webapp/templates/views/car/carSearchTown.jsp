<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <thead>
    <tr>
        <th>town</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${towns}" var="town">
        <tr>
            <td>${town.getTown()}</td>
    </c:forEach>
    </tbody>
</table>
<div class="form">

    <%--@elvariable id="carSearch" type="it.academy.rent.car.bean.CarSearch"--%>
    <form:form class="register-form" action="${pageContext.request.contextPath}searchFormCountry"
               modelAttribute="carSearch" method="post">

        <form:errors path="country" cssStyle="color: red"/>
        <form:input path="country" type="text" placeholder="country"/>

        <form:errors path="typeCar" cssStyle="color: red"/>
        <form:input path="typeCar" type="text" placeholder="typeCar"/>

        <button>Search</button>
        ${carError}
    </form:form>
</div>
</body>
</html>
