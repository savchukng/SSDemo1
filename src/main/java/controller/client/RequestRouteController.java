package controller.client;

import dao.ApplicationDAO;
import dao.DAOImpl;
import model.Application;
import model.Preference;
import model.User;
import service.ClientService;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/request-route")
public class RequestRouteController extends HttpServlet {

    private ClientService clientService;

    @Override
    public void init() throws ServletException {
        clientService = ServiceFactory.getInstance().getClientService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = (User) request.getSession().getAttribute("user");

        clientService.requestRoute(user.getId(), request.getParameter("origin"), request.getParameter("destination"),
                                    request.getParameter("additionalInfo"), request.getParameter("make"),
                                    request.getParameter("model"), Integer.parseInt(request.getParameter("yearFrom")),
                                    Integer.parseInt(request.getParameter("yearTo")), Integer.parseInt(request.getParameter("stateFrom")),
                                    Integer.parseInt(request.getParameter("stateTo")), request.getParameter("numberPlate"));

        response.sendRedirect("/applications");
    }
}
