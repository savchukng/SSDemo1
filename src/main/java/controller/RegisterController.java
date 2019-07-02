package controller;

import service.AccountService;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterController extends HttpServlet {

    private AccountService accountService;

    @Override
    public void init() throws ServletException {
        accountService = ServiceFactory.getInstance().getAccountService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        accountService.registerUser(req.getParameter("username"), req.getParameter("password"), req.getParameter("email"),
                                    req.getParameter("firstName"), req.getParameter("lastName"), req.getParameter("occupation"));
        resp.sendRedirect("/index.html");
    }

}