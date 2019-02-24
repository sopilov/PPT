package PPT.filters;

import PPT.models.User;
import PPT.services.MessageService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebFilter("/*")
public class SecurityFilter implements Filter {
    private static MessageService messageService = MessageService.getInstance();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        User loginedUser = (User) request.getSession().getAttribute("loginedUser");
        String servletPath = request.getServletPath();

        if (servletPath.equals("/index.jsp") || servletPath.equals("/") || servletPath.equals("/login")) {
            filterChain.doFilter(request, response);
            return;
        }

        if (loginedUser == null) {
            response.sendRedirect("/");
            return;
        } else {
            String role = loginedUser.getRole();
            if (!hasAccess(role, servletPath)) {
                messageService.sendMessage("Access denied!!!");
                response.sendRedirect("/user");
                return;
            }
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
    }

    private boolean hasAccess (String role, String path) {
        if (role.equals("admin")) {
            return true;
        }
        if (role.equals("user")) {
            return path.contains("user") || path.contains("logout");
        }
        return false;
    }
}
