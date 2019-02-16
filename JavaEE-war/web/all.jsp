<%@ page import="fr.sebastien.leonard.Evenement" %>
<%@ page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="bean" class="fr.sebastien.leonard.beans.EventBean"/>

<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>JSP Page</title>
</head>
<body>
  <h1>Liste des événements</h1>
  
  <table>
    <tr>
      <th>ID</th>
      <th>Lieu</th>
    </tr>
  <%
    List<Evenement> events = (List<Evenement>)request.getAttribute("events");
    for(Evenement evenement : events) {
      out.println("<tr>");
      out.println("<td>" + evenement.getId() + "</td>");
      out.println("<td>" + evenement.getLieu() + "</td>");
      out.println("</tr>");
    }
  %>
  </table>
</body>
</html>
