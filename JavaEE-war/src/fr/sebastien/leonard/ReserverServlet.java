package fr.sebastien.leonard;

import fr.sebastien.leonard.beans.ReservationBean;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ReserverServlet", urlPatterns = "/reservation")
public class ReserverServlet extends HttpServlet {

    @EJB
    private ReservationBean bean;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        bean.save(Integer.getInteger(request.getParameter("idP")), Integer.getInteger(request.getParameter("idE")));
        response.sendRedirect(response.encodeRedirectURL(request.getContextPath()+ "/app"));
    }

}
