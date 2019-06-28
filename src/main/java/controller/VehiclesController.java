package controller;

import dao.DAO;
import model.Vehicle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/vehicles")
public class VehiclesController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DAO vehicleDao = new DAO(Vehicle.class);
        req.setAttribute("vehicles", vehicleDao.getAll());
        RequestDispatcher rd = req.getRequestDispatcher("/vehicles.jsp");
        rd.forward(req, resp);
    }
}
