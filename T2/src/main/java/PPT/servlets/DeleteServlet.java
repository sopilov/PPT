package PPT.servlets;

import PPT.services.UserService;
import PPT.services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    private static UserService userService = UserServiceImpl.getInstance();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String idDelete = req.getParameter("iddelete");

        userService.deleteUser(Long.valueOf(idDelete));

        resp.sendRedirect("/list?msgforlist=User ID=" + idDelete + " deleted");
    }
}
