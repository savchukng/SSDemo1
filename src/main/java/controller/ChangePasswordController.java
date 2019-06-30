package controller;

import com.google.gson.Gson;
import dao.UserDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet("/change-password")
public class ChangePasswordController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        if(!user.getPassword().equals(request.getParameter("oldPassword"))){
            Map<String, String> options = new LinkedHashMap<>();
            options.put("error", "Wrong old password");
            String json = new Gson().toJson(options);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
        }
        else {
            UserDAO userDAO = new UserDAO();
            userDAO.setPassword(user.getId(), request.getParameter("newPassword"));
        }
    }
}
