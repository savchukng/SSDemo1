package controller.client;

import com.google.gson.Gson;
import dao.DAOImpl;
import model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet("/search-by-number")
public class SearchByNumberController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DAOImpl dao = new DAOImpl(Vehicle.class);
        Vehicle vehicle = (Vehicle) dao.get("number_plate", request.getParameter("numberPlate").toUpperCase());
        Map<String, String> options = new LinkedHashMap<>();
        options.put("make", vehicle.getMake());
        options.put("model", vehicle.getModel());
        options.put("year", String.valueOf(vehicle.getYear()));
        options.put("state", String.valueOf(vehicle.getState()));
        String json = new Gson().toJson(options);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

    }
}
