
package controller;

import dao.DAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        DAO userDao = new DAO(User.class);
        User newUser = new User(req.getParameter("username"), req.getParameter("password"), req.getParameter("email"),
                req.getParameter("firstName"), req.getParameter("lastName"), req.getParameter("occupation"));
        userDao.save(newUser);
        userDao.close();
        resp.sendRedirect("/request_route.html");
    }

}