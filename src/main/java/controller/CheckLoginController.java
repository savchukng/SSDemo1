
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

@WebServlet("/check-login")
public class CheckLoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        DAO userDao = new DAO(User.class);
        User user = (User) userDao.get("username", req.getParameter("username"));
        PrintWriter out = resp.getWriter();
        if(user == null || !user.getPassword().equals(req.getParameter("password"))){
            out.println("Wrong username or password");
        }
        else {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("/index.html");
        }
    }
}