<jsp:include page="../includes/header.jsp"/>

<form action="http://localhost:8080/application_war/login" method="post">
    <input type="email" name="Email" placeholder="Email">
    <input type="password" name="password">

    <input type="submit" value="Se connecter">
</form>

<jsp:include page="../includes/footer.jsp"/>