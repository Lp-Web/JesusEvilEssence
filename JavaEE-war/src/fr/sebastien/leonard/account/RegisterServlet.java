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
import java.util.ArrayList;

@WebServlet(name = "RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {

    @EJB
    private PersonneBean bean;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Create account
        HttpSession session = request.getSession();

        Personne personne = new Personne(
                request.getParameter("email"),
                request.getParameter("password"),
                false,
                new ArrayList<Evenement>()
        );

        System.out.println(personne.getEmail() + " est crée !");

        bean.createPersonne(personne);
        session.setAttribute("connected", personne);

        response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+ "/app"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("session/register.jsp").forward(request, response);
    }



}
