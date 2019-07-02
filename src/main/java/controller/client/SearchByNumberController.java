package controller.client;

import service.ClientService;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/search-by-number")
public class SearchByNumberController extends HttpServlet {

    private ClientService clientService;

    @Override
    public void init() throws ServletException {
        clientService = ServiceFactory.getInstance().getClientService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(clientService.getVehicleJSON(request.getParameter("numberPlate")));
    }
}
