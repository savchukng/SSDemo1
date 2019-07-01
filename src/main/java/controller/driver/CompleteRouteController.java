package controller.driver;


import dao.ApplicationDAO;
import dao.RouteDAO;
import model.Route;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/complete-route")
public class CompleteRouteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RouteDAO routeDAO = new RouteDAO();
        Route route = (Route) routeDAO.get(Integer.parseInt(req.getParameter("routeId")));
        ApplicationDAO appDao = new ApplicationDAO();
        appDao.setCompletionDate(route.getAppId(), new Date());
        routeDAO.deleteRoute(route.getId());
        resp.sendRedirect("/routes");
    }
}
