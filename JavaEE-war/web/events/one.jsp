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
<h1>Détail d'un événement</h1>
    
<table>
    <tr>
        <th>ID</th>
        <th>Lieu</th>
        <th>Description</th>
        <th>Date</th>
    </tr>
    <tr>
<%
    Evenement evenement = (Evenement) request.getAttribute("id");
    //out.println(evenement.getId() + " -> " + evenement.getLieu() + " | " + evenement.getDesc() + " / " + evenement.getDateEvenement() + "<br>");
    
    out.println("<td>" + evenement.getId() + "</td>");
    out.println("<td>" + evenement.getLieu() + "</td>");
    out.println("<td>" + evenement.getDesc() + "</td>");
    out.println("<td>" + evenement.getDateEvenement() + "</td>");
        
%>
    </tr>
</table>
</body>
</html>
