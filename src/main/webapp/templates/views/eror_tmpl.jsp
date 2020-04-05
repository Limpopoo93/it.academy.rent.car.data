<%@ page import="it.academy.rent.car.util.InitConstant" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Object error = session.getAttribute(InitConstant.ERROR_KEY);

    if (error != null) {
        String errorMsg = String.valueOf(error);
        if (!errorMsg.isEmpty()){
            out.print("<h3 style=\"color:red; \"> " + "* " + errorMsg + "</h3>");
            session.removeAttribute(InitConstant.ERROR_KEY);
        }
    }
%>
