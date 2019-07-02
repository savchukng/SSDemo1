package controller;

import model.User;
import service.AccountService;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/change-password")
public class ChangePasswordController extends HttpServlet {

    private AccountService accountService;

    @Override
    public void init() throws ServletException {
        accountService = ServiceFactory.getInstance().getAccountService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if(!accountService.checkPassword(request, request.getParameter("oldPassword"))){
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(accountService.getErrorJSON("Wrong password"));
        }
        else {
            accountService.setPassword((User)request.getSession().getAttribute("user"), request.getParameter("newPassword"));
        }
    }
}
