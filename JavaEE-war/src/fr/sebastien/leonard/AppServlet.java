package fr.sebastien.leonard;

import fr.sebastien.leonard.beans.EventBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet(name = "AppServlet", urlPatterns = "/app")
public class AppServlet extends HttpServlet {

    @EJB
    private EventBean bean;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("all.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Evenement evenement = new Evenement(
                "16/02/2019",
                "Clermont-Ferrand",
                "Projet numéro UN",
                new ArrayList<PlaceEvenement>(Arrays.asList(new PlaceEvenement(150)))
        );

        bean.createEvents(new ArrayList<Evenement>(Arrays.asList(evenement)));

        if(request.getParameter("id") == null) {
            request.setAttribute("events", bean.getEvenements());
            request.getRequestDispatcher("events/all.jsp").forward(request, response);
        } else {
            request.setAttribute("id", bean.getEvenementById(request.getParameter("id")));
            request.getRequestDispatcher("events/one.jsp").forward(request, response);
        }
    }

}
