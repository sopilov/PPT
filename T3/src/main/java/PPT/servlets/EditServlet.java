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

@WebServlet("/admin/edit")
public class EditServlet extends HttpServlet {
    private static UserService userService = UserServiceImpl.getInstance();
    private static MessageService messageService = MessageService.getInstance();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String idEdit = req.getParameter("idedit");

        User user = userService.getUser(Long.valueOf(idEdit));
        req.setAttribute("user", user);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("edit.jsp");
        requestDispatcher.forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String id = req.getParameter("id");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");
        String role = req.getParameter("role");

        User user = new User(Long.valueOf(id), login, password, nickname, role);

        userService.updateUser(user);

        messageService.sendMessage("User ID=" + id + " updated");

        resp.sendRedirect("/admin/list");
    }
}
