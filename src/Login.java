import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String user = req.getParameter("user");
        final String pswd = req.getParameter("pswd");

        req.setAttribute("username", "Rodrigo");

        final RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/main.jsp");

        if(dispatcher != null){
            dispatcher.forward(req, resp);
        }

    }
}
