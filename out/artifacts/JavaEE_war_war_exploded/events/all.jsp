<%@ page import="fr.sebastien.leonard.Evenement" %>
<%@ page import="java.util.List" %>
<%@ page import="fr.sebastien.leonard.Personne" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="../includes/header.jsp" />
<h1>Liste des événements</h1>
<table>
  <tr>
    <th>ID</th>
    <th>Lieu</th>
    <% if(session.getAttribute("connected") != null) {
      out.println("<th>Action</th>");
    }%>
  </tr>
  <%
    List<Evenement> events = (List<Evenement>)request.getAttribute("events");
    for(Evenement evenement : events) {
      out.println("<tr>");
      out.println("<td>" + evenement.getId() + "</td>");
      out.println("<td>" + evenement.getLieu() + "</td>");
      if(session.getAttribute("connected") != null) {
        out.println("<td>" + "<a href='http://localhost:8080/application_war/reservation?idE=" + evenement.getId() + "&idP=" + ((Personne) session.getAttribute("connected")).getId() + "'>Reserver<a/>" + "</td>");
      }
      out.println("</tr>");
    }
  %>
</table>
<jsp:include page="../includes/footer.jsp"/>