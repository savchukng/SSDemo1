package controller;

import dao.ApplicationDAO;
import model.Application;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/set-driver")
public class SetDriverController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationDAO appDao = new ApplicationDAO();
        appDao.setDriverId(Integer.parseInt(req.getParameter("appId")), Integer.parseInt(req.getParameter("driverId")));
        appDao.setReceptionDate(Integer.parseInt(req.getParameter("appId")), new Date());
        resp.sendRedirect("/applications");
    }
}
