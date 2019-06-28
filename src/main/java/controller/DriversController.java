package controller;

import dao.UserDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/drivers")
public class DriversController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        UserDAO userDao = new UserDAO();
        req.setAttribute("drivers", userDao.getAllDrivers());
        RequestDispatcher rd = req.getRequestDispatcher("drivers.jsp");
        rd.forward(req, resp);
    }
}