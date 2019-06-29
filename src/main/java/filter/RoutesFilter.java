package filter;

import dao.ApplicationDAO;
import dao.DAOImpl;
import model.Application;
import model.Route;
import model.User;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName = "RoutesFilter", urlPatterns = {
        "/routes"
})
public class RoutesFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null){
            req.getRequestDispatcher("login.html").forward(req, res);
        }
        else if(user.getUserType().equals("client")){
            PrintWriter out = res.getWriter();
            out.println("You don't have permission to do this");
        }
        else if(user.getUserType().equals("driver")){
            ApplicationDAO appDao = new ApplicationDAO();
            req.setAttribute("route", appDao.getDriverRoute(user.getId()));
            req.getRequestDispatcher("driver/routes.jsp").forward(req, res);
        }
        else {
            DAOImpl routeDao = new DAOImpl(Route.class);
            req.setAttribute("routes", routeDao.getAll());
            req.getRequestDispatcher("dispatcher/routes.jsp").forward(req, res);
        }
    }
}
