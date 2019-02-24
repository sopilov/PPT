package PPT.servlets;

import PPT.services.MessageService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private static MessageService messageService = MessageService.getInstance();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setAttribute("messageService", messageService);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("user/user.jsp");
        requestDispatcher.forward(req, resp);
    }
}
