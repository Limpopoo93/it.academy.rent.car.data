<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="login-page">
    <div class="form">
        <%--@elvariable id="town" type="it.academy.rent.bean.Town"--%>
        <form:form class="register-form" action="${pageContext.request.contextPath}/createTown"
                   modelAttribute="town" method="post">

            <form:errors path="town" cssStyle="color: red"/>
            <form:input path="town" type="text" placeholder="town"/>

            <button>Registration</button>
        </form:form>
    </div>
</div>
</body>
</html>
