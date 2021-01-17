package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "AuthFilter",urlPatterns="/*")
public class AuthFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
         HttpServletRequest req = (HttpServletRequest) request;
         HttpServletResponse res = (HttpServletResponse) response;
         String login = req.getParameter("login");
         String password = req.getParameter("password");

         HttpSession session = req.getSession();


        if(session!=null&&session.getAttribute("login")!=null&&session.getAttribute("password")!=null)
            chain.doFilter(req, res);
        else
            if(login!=null&&password!=null){
                session.setAttribute("password",password);
                session.setAttribute("login",login);
                res.sendRedirect("/");
            }else {
                req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, res);

            }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
