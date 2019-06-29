package filter;

import dao.UserDAO;
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

@WebFilter(filterName = "UsersFilter", urlPatterns = {
        "/clients"
})
public class ClientsFilter extends HttpFilter {
    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null){
            req.getRequestDispatcher("login.html").forward(req, res);
        }
        else if(user.getUserType().equals("client") || user.getUserType().equals("driver")){
            PrintWriter out = res.getWriter();
            out.println("You don't have permission to do this");
        }
        else {
            UserDAO userDao = new UserDAO();
            req.setAttribute("clients", userDao.getAllClients());
            req.getRequestDispatcher("dispatcher/clients.jsp").forward(req, res);
        }
    }
}
