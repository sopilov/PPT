package PPT.servlets;

import PPT.models.User;
import PPT.dao.UserDaoImpl;
import PPT.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add")
public class AddServlet extends HttpServlet {
    private static UserService userService = UserService.getInstance();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("users/add.jsp");
        requestDispatcher.forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");

        User user = new User(0L, login, password, nickname);

        userService.addUser(user);
        resp.sendRedirect("/list?msgforlist=User login=" + login + " added");
    }
}
