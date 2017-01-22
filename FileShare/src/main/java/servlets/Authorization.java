package servlets;

import additional.User;
import services.UserControl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by firdavs on 22/01/17.
 */
@WebServlet("/signin")
public class Authorization extends HttpServlet {
    private UserControl user = UserControl.getInstance();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/Authorization.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter()
        User check;
        if (user.getUser(req.getParameter("login")) == null) {
            resp.getWriter().println("User doesn't exist");
            return;
        } else if ( (check = user.getUser(req.getParameter("login"))) != null) {
            if (check.getPassword().equals(req.getParameter("password"))) {
                resp.getWriter().println("Success, you have been authorized");
                resp.getWriter().println("Your login is: " + check.getLogin() + " password: " + check.getPassword());
            } else
                resp.getWriter().println("Incorrect Password !");
        }

    }
}
