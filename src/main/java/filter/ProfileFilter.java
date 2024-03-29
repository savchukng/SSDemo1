package filter;

import dao.DAOImpl;
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

@WebFilter(urlPatterns = {
        "/profile"
})
public class ProfileFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        DAOImpl userDAO = new DAOImpl(User.class);
        session.setAttribute("user", (User)userDAO.get(user.getId()));
        if(user == null){
            res.sendRedirect("/login.html");
        }
        else if (user.getUserType().equals("client")){
            res.sendRedirect("/user/profile.jsp");
        }
        else if (user.getUserType().equals("dispatcher")){
            res.sendRedirect("/dispatcher/profile.jsp");
        }
        else if (user.getUserType().equals("driver")){
            res.sendRedirect("/driver/profile.jsp");
        }
        else {
            PrintWriter out = res.getWriter();
            out.println("Something went wrong");
        }
    }

}
