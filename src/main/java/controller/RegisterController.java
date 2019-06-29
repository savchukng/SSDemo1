
package controller;

import dao.DAOImpl;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        DAOImpl userDao = new DAOImpl(User.class);
        User newUser = new User(req.getParameter("username"), req.getParameter("password"), req.getParameter("email"),
                req.getParameter("firstName"), req.getParameter("lastName"), req.getParameter("occupation"));
        userDao.save(newUser);
        resp.sendRedirect("/request_route.html");
    }

}