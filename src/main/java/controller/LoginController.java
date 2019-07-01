package controller;

import com.google.gson.Gson;
import dao.DAOImpl;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        DAOImpl userDao = new DAOImpl(User.class);
        User user = (User) userDao.get("username", req.getParameter("username"));
        PrintWriter out = resp.getWriter();
        if(user == null || !user.getPassword().equals(req.getParameter("password"))){
            Map<String, String> options = new LinkedHashMap<>();
            options.put("error", "Wrong username or password");
            String json = new Gson().toJson(options);
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json);
        }
        else {
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
            resp.sendRedirect("/index.html");
        }
    }
}