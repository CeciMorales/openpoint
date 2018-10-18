import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final String user = req.getParameter("user");
        final String pswd = req.getParameter("pswd");

        final RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/main.jsp");

        if(dispatcher != null){

            final String username = isLoginValid(user, pswd);

            if(username!=null){

                req.setAttribute("username", username);
                dispatcher.forward(req, resp);

            } else {

                req.setAttribute("error", true);
                getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);

            }


        }

        if(dispatcher != null){
            dispatcher.forward(req, resp);
        }

    }

    private String isLoginValid(String user, String pswd){

        final String dbUrl = getServletContext().getInitParameter("db-connection-url");
        final String dbUser = getServletContext().getInitParameter("db-user");
        final String dbPswd = getServletContext().getInitParameter("db-pswd");


        try {

            Class.forName("com.mysql.jdbc.Driver");
            final Connection con = DriverManager.getConnection(dbUrl, dbUser, dbPswd);
            final Statement statement = con.createStatement();

            final String loginQuery = "SELECT Salesman.name FROM Salesman WHERE email='"+user+"' AND password='"+pswd+"';";

            final ResultSet resultSet = statement.executeQuery(loginQuery);

            if(resultSet.next()){

                statement.close();
                con.close();

                return resultSet.getString("name");

            }

            return null;

        } catch (SQLException | ClassNotFoundException e) {

            e.printStackTrace();
            return null;
        }
    }

}
