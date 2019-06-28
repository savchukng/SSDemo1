package controller;

import dao.ApplicationDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/applications")
public class ApplicationsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ApplicationDAO appDao = new ApplicationDAO();
        List<Object> apps = appDao.getAll();
        req.setAttribute("apps", apps);
        RequestDispatcher rd = req.getRequestDispatcher("applications.jsp");
        rd.forward(req, resp);
    }
}