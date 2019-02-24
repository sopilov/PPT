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
import java.util.List;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
    private static UserService userService = UserService.getInstance();

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        List<User> users = userService.getAllUsers();
        req.setAttribute("users", users);

        String msgforlist = req.getParameter("msgforlist");
        req.setAttribute("msgforlist", msgforlist);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("users/list.jsp");
        requestDispatcher.forward(req, resp);
    }

}
