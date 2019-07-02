package controller.dispatcher;

import dao.ApplicationDAO;
import service.ClientService;
import service.DispatcherService;
import service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-application")
public class DeleteAppController extends HttpServlet {

    private DispatcherService dispatcherService;

    @Override
    public void init() throws ServletException {
        dispatcherService = ServiceFactory.getInstance().getDispatcherService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        dispatcherService.deleteApp(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect("/applications");
    }
}
