package controller;

import dao.ApplicationDAO;
import dao.DAO;
import model.Application;
import model.Preference;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@WebServlet("/request-route")
public class RequestRouteController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ApplicationDAO applicationDao = new ApplicationDAO();
        Application app = new Application();
        app.setRegistrationDate(new Date());
        User user = (User) request.getSession().getAttribute("user");
        app.setUserId(user.getId());
        app.setOrigin(request.getParameter("origin"));
        app.setDestination(request.getParameter("destination"));
        app.setAdditionalInfo(request.getParameter("additionalInfo"));
        DAO preferenceDAO = new DAO(Preference.class);
        Preference preference = new Preference();
        preference.setvMake(request.getParameter("make"));
        preference.setvModel(request.getParameter("model"));
        preference.setvYearFrom(Integer.parseInt(request.getParameter("yearFrom")));
        preference.setvYearTo(Integer.parseInt(request.getParameter("yearTo")));
        preference.setvStateFrom(Integer.parseInt(request.getParameter("stateFrom")));
        preference.setvStateTo(Integer.parseInt(request.getParameter("stateTo")));
        preference.setvNumberPlate(request.getParameter("numberPlate"));
        preferenceDAO.save(preference);
        app.setPreferenceId(preference.getId());
        applicationDao.newApplication(app);
        response.sendRedirect("index.html");
    }
}
