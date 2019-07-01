package controller.dispatcher;

import dao.ApplicationDAO;
import dao.UserDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/set-vehicle")
public class SetVehicleController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO appDao = new UserDAO();
        appDao.setVehicleId(Integer.parseInt(req.getParameter("driverId")), Integer.parseInt(req.getParameter("vehicleId")));
        resp.sendRedirect("/drivers");
    }
}
