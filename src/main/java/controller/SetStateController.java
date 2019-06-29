package controller;

import dao.VehicleDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/set-state")
public class SetStateController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        VehicleDAO vehicleDAO = new VehicleDAO();
        vehicleDAO.setState(Integer.parseInt(req.getParameter("vehicleId")), Integer.parseInt(req.getParameter("state")));
        resp.sendRedirect("/profile");
    }
}
