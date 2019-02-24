package PPT.servlets;

import PPT.models.User;
import PPT.services.MessageService;
import PPT.services.UserService;
import PPT.services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static UserService userService = UserServiceImpl.getInstance();
    private static MessageService messageService = MessageService.getInstance();

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = userService.getUser(login);

        if (user == null || !user.getPassword().equals(password)) {
            String errorMessage = "Invalid userName or Password";
            response.setContentType("text/html");
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().println(errorMessage);
            return;
        }

        request.getSession().setAttribute("loginedUser", user);

        if (user.getRole().equals("admin")) {
            messageService.sendMessage("User login=" + user.getLogin() + " logined");
            response.sendRedirect("/admin/list");
        } else {
            messageService.sendMessage("User login=" + user.getLogin() + " logined");
            response.sendRedirect("/user");
        }

    }
}
