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
import java.util.List;

@WebServlet("/admin/list")
public class ListServlet extends HttpServlet {
    private static UserService userService = UserServiceImpl.getInstance();
    private static MessageService messageService = MessageService.getInstance();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<User> users = userService.getAllUsers();
        req.setAttribute("users", users);

        req.setAttribute("messageService", messageService);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("list.jsp");
        requestDispatcher.forward(req, resp);
    }

}
