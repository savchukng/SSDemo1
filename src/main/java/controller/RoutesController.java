package controller;

import dao.DAO;
import model.Route;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/routes")
public class RoutesController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAO routeDao = new DAO(Route.class);
        req.setAttribute("routes", routeDao.getAll());
        RequestDispatcher rd = req.getRequestDispatcher("/routes.jsp");
        rd.forward(req, resp);
    }
}
