<%@ page import="fr.sebastien.leonard.Evenement" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="bean" class="fr.sebastien.leonard.beans.EventBean"/>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
</head>
<body>
<h1>Hello, World!</h1>
<%
    Evenement evenement = (Evenement) request.getAttribute("id");
    out.println(evenement.getId() + " -> " + evenement.getLieu() + " | " + evenement.getDesc() + " / " + evenement.getDateEvenement() + "<br>");
%>
</body>
</html>
