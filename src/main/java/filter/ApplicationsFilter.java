package filter;

import dao.ApplicationDAO;
import dao.DAOImpl;
import model.Application;
import model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebFilter(filterName = "ApplicationsFilter", urlPatterns = {
        "/applications"
})
public class ApplicationsFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null){
            req.getRequestDispatcher("login.html").forward(req, res);
        }
        else if(user.getUserType().equals("driver")){
            PrintWriter out = res.getWriter();
            out.println("You don't have permission to do this");
        }
        else if(user.getUserType().equals("client")){
            ApplicationDAO appDao = new ApplicationDAO();
            req.setAttribute("apps", appDao.getClientApps(user.getId()));
            req.getRequestDispatcher("user/applications.jsp").forward(req, res);
        }
        else {
            ApplicationDAO appDao = new ApplicationDAO();
            List<Object> apps = appDao.getAll();
            if(req.getParameter("status") != null){
                List<Application> statusApps = new ArrayList<>();
                for(Object objApp : apps){
                    Application app = (Application) objApp;
                    if(app.getStatus().equals(req.getParameter("status"))){
                        statusApps.add(app);
                    }
                }
                req.setAttribute("apps", statusApps);
            }
            else {
                req.setAttribute("apps", apps);
            }
            req.getRequestDispatcher("dispatcher/applications.jsp").forward(req, res);
        }
    }
}
