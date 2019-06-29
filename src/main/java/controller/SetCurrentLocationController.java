package controller;

import dao.RouteDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/set-current-location")
public class SetCurrentLocationController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RouteDAO routeDao = new RouteDAO();
        routeDao.setCurrentLocation(Integer.parseInt(req.getParameter("routeId")), req.getParameter("currentLocation"));
        resp.sendRedirect("/routes");
    }
}
