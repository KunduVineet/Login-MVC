package in.sp.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import in.sp.dbConnector.DbConnection;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/RegForm")
public class Register extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.setContentType("text/html");

        String myname = req.getParameter("name1");
        String myemail = req.getParameter("email1");
        String mypass = req.getParameter("pass1");
        String mycity = req.getParameter("city1");

        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DbConnection.getConnection();
            if (con != null) {
                System.out.println("Connection established successfully!");
            } else {
                System.out.println("Failed to establish connection.");
            }
            String sql_insert_query = "INSERT INTO register(name, email, password, city) VALUES(?,?,?,?)";
            ps = con.prepareStatement(sql_insert_query);
            ps.setString(1, myname);
            ps.setString(2, myemail);
            ps.setString(3, mypass);
            ps.setString(4, mycity);

            int count = ps.executeUpdate();

            if (count > 0) {
                out.println("<h3 style='color:green;'>Registered Successfully</h3>");
                RequestDispatcher rd = req.getRequestDispatcher("/login.html");
                rd.include(req, resp);
            } else {
                out.println("<h3 style='color:red;'>User not Registered</h3>");
                
                RequestDispatcher rd = req.getRequestDispatcher("/Register.html");
                rd.include(req, resp);
            }
        } catch (Exception e) {
            out.println("<h3 style='color:red;'>An error occurred during registration. Please try again.</h3>");
            e.printStackTrace(out); // Log the error for debugging
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (Exception e) {
                e.printStackTrace(out);
            }
        }
    }
}
