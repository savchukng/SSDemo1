package controller.dispatcher;

import dao.ApplicationDAO;
import dao.UserDAO;
import service.DispatcherService;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/set-vehicle")
public class SetVehicleController extends HttpServlet {

    private DispatcherService dispatcherService;

    @Override
    public void init() throws ServletException {
        dispatcherService = ServiceFactory.getInstance().getDispatcherService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        dispatcherService.setVehicle(Integer.parseInt(req.getParameter("driverId")), Integer.parseInt(req.getParameter("vehicleId")));
        resp.sendRedirect("/drivers");
    }
}
