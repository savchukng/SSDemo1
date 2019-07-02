package controller.driver;

import service.DriverService;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/set-state")
public class SetStateController extends HttpServlet {

    private DriverService driverService;

    @Override
    public void init() throws ServletException {
        driverService = ServiceFactory.getInstance().getDriverService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        driverService.setState(Integer.parseInt(req.getParameter("vehicleId")), Integer.parseInt(req.getParameter("state")));
        resp.sendRedirect("/profile");
    }
}
