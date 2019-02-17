<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP</title>
</head>
<body>
<% if(session.getAttribute("connected") != null) { %>
    <jsp:include page="../includes/parts/connected.jsp" />
<% } else { %>
    <h1>You are not connected <a href="http://localhost:8080/application_war/login">Click here!</a></h1>
    <h3>You don't have account ? <a href="http://localhost:8080/application_war/register">Click here!</a> </h3>
<% } %>