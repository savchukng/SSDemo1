package controller.dispatcher;

import dao.ApplicationDAO;
import dao.DAOImpl;
import dao.RouteDAO;
import model.Application;
import model.Route;
import service.DispatcherService;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/set-driver")
public class SetDriverController extends HttpServlet {

    private DispatcherService dispatcherService;

    @Override
    public void init() throws ServletException {
        dispatcherService = ServiceFactory.getInstance().getDispatcherService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatcherService.setDriver(Integer.parseInt(req.getParameter("appId")), Integer.parseInt(req.getParameter("driverId")));
        resp.sendRedirect("/applications");
    }
}
