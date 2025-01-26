package lk.ijse.ecommerce.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "UserServlet", value = "/user_servlet")
public class UserServlet extends HttpServlet {
    String DB_URL = "jdbc:mysql://localhost:3306/ecommerce";
    String DB_USER = "root";
    String DB_PASSWORD = "Ijse@1234";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String FullName = req.getParameter("fullName");
        String Email = req.getParameter("email");
        String Password = req.getParameter("password");
        String Confirm_Password = req.getParameter("confirmPassword");
        String Security_answer = req.getParameter("security-answer");
        String Role = req.getParameter("role");

        String message = "";
        String alertType = "";

        try{
            if (Password != null && Password.equals(Confirm_Password)){

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            String sql = "INSERT INTO users (fullName, email, password, answer, role) VALUES (?,?,?,?,?)";

            PreparedStatement ps = connection.prepareStatement(sql);

            ps.setString(1, FullName);
            ps.setString(2, Email);
            ps.setString(3, Password);
            ps.setString(4, Security_answer);
            ps.setString(5, Role);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                message = "Signup Successfully";
                alertType = "success";
            } else {
                message = "Signup failed. Please try again!";
                alertType = "error";
            }
            } else {
                message = "Passwords do not match!";
                alertType = "error";
            }
        } catch (SQLException | ClassNotFoundException e) {
            message = "An error occurred: " + e.getMessage();
            alertType = "error";
        }

        req.setAttribute("message", message);
        req.setAttribute("alertType", alertType);
        req.getRequestDispatcher("signUp.jsp").forward(req, resp);
    }
}
