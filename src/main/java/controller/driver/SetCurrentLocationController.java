package controller.driver;

import service.DriverService;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/set-current-location")
public class SetCurrentLocationController extends HttpServlet {

    private DriverService driverService;

    @Override
    public void init() throws ServletException {
        driverService = ServiceFactory.getInstance().getDriverService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        driverService.setCurrentLocation(Integer.parseInt(req.getParameter("routeId")), req.getParameter("currentLocation"));
        resp.sendRedirect("/routes");
    }
}
