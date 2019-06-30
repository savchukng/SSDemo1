package controller;

import com.google.gson.Gson;
import dao.UserDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet("/change-email")
public class ChangeEmailController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if(!user.getPassword().equals(request.getParameter("password"))){
            Map<String, String> options = new LinkedHashMap<>();
            options.put("error", "Wrong password");
            String json = new Gson().toJson(options);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
        else {
            UserDAO userDAO = new UserDAO();
            userDAO.setEmail(user.getId(), request.getParameter("email"));
        }
    }
}
