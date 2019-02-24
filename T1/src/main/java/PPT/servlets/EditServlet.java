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

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    private static UserService userService = UserService.getInstance();

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String idEdit = req.getParameter("idedit");

        User user = userService.getUser(Long.valueOf(idEdit));
        req.setAttribute("user", user);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("users/edit.jsp");
        requestDispatcher.forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String id = req.getParameter("id");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String nickname = req.getParameter("nickname");

        User user = new User(Long.valueOf(id), login, password, nickname);

        userService.updateUser(user);
        resp.sendRedirect("/list?msgforlist=User ID=" + id + " updated");
    }
}
