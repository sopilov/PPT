package PPT.servlets;

import PPT.models.User;
import PPT.services.MessageService;
import PPT.services.UserService;
import PPT.services.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/add")
public class AddServlet extends HttpServlet {
    private static UserService userService = UserServiceImpl.getInstance();
    private static MessageService messageService = MessageService.getInstance();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("add.jsp");
        requestDispatcher.forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");
        String role = req.getParameter("role");

        User user = new User(0L, login, password, nickname, role);

        userService.addUser(user);

        messageService.sendMessage("User login=" + login + " added");

        resp.sendRedirect("/admin/list");
    }
}
