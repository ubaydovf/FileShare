package servlets;

import services.UserControl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by firdavs on 21/01/17.
 */
@WebServlet("/signup")
public class Registration extends HttpServlet {

    private String login;
    private String password;
    private String confirmPassword;
    private UserControl users = UserControl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/Registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("password").equals(req.getParameter("confirmPassword"))) {

            /* Добавляем пользователя в мапу (наверное) */
            if (!req.getParameter("login").equals("") && !req.getParameter("password").equals("")) {

                users.addUser(req.getParameter("login"), req.getParameter("password"));

                resp.getWriter().println("You have been successfully Registered !");
                resp.getWriter().println("Your login is: " + req.getParameter("login"));
                resp.getWriter().println("Your password is: " + req.getParameter("password"));
            } else {
                resp.setContentType("test/html; charset=utf-8;");
                resp.getWriter().println("Введите правильные данные !");
            }

        } else {
            resp.setContentType("text/html; charset=utf-8;");
            resp.getWriter().println(" Введенные пароли не совпадают, башмак ");
        }
    }
}
