package fr.sebastien.leonard.account;

import fr.sebastien.leonard.Evenement;
import fr.sebastien.leonard.Personne;
import fr.sebastien.leonard.beans.PersonneBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @EJB
    private PersonneBean bean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Create account
        HttpSession session = request.getSession();

        Personne personne = bean.getPersonneByEmail(request.getParameter("email"));
        if(personne.getPassword().equals(request.getParameter("password"))) {
            session.setAttribute("connected", personne);
        } else {
            session.setAttribute("connected", "Mauvais mot de passe");
        }
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+ "/app"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("session/login.jsp").forward(request, response);
    }

}
