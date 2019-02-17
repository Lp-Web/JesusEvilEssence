package fr.sebastien.leonard.account;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "DisconnectServlet", urlPatterns = "/disconnect")
public class DisconnectServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HttpSession session = req.getSession();
        session.setAttribute("connected", null);

        resp.sendRedirect(resp.encodeRedirectURL(req.getContextPath()+ "/app"));
    }

}
