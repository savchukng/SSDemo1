package controller;

import dao.ApplicationDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-application")
public class DeleteAppServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationDAO appDao = new ApplicationDAO();
        appDao.deleteApp(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect("/applications");
    }
}
