<jsp:include page="../includes/header.jsp"/>

<form action="http://localhost:8080/application_war/register" method="post">
    <input type="email" name="email" placeholder="email">
    <input type="password" name="password">
    <input type="submit" value="S'enregistrer">
</form>

<jsp:include page="../includes/footer.jsp"/>