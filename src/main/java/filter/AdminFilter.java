package filter;

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
        "/admin/*"
})
public class AdminFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null){
            res.sendRedirect("/login.html");
        }
        else if (!user.getUserType().equals("admin")) {
            PrintWriter out = res.getWriter();
            out.println("You don't have permission to do this");
        }
        else {
            chain.doFilter(req, res);
        }
    }

}
