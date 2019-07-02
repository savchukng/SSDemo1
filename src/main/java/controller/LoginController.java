package controller;

import com.google.gson.Gson;
import dao.DAOImpl;
import model.User;
import service.AccountService;
import service.ServiceFactory;

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

    private AccountService accountService;

    @Override
    public void init() throws ServletException {
        accountService = ServiceFactory.getInstance().getAccountService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        if(!accountService.authorize(req)){
            resp.setContentType("application/json");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(accountService.getErrorJSON("Wrong username or password"));
        }
        else {
            resp.sendRedirect("/index.html");
        }
    }
}