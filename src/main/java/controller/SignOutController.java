
package controller;

import service.AccountService;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/sign-out")
public class SignOutController extends HttpServlet {

    private AccountService accountService;

    @Override
    public void init() throws ServletException {
        accountService = ServiceFactory.getInstance().getAccountService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        accountService.signOut(req);
        resp.sendRedirect("/login.html");
    }

}