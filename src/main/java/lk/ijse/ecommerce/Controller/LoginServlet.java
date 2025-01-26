package lk.ijse.ecommerce.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.ecommerce.bo.BOFactory;
import lk.ijse.ecommerce.bo.custom.LoginBO;
import lk.ijse.ecommerce.entity.User;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    LoginBO loginBO = (LoginBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.LOGIN);
    //loginBOImpl LoginBO = new loginBOImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        String message = "";
        String alertType = "";


        User user = loginBO.cheackEmail(email, password);
        if (user.getStatus()) {
            if ("admin".equalsIgnoreCase(String.valueOf(user.getRole()))) {
                message = "Login Successfully";
                alertType = "success";
                resp.sendRedirect("adminDashboard.jsp");
            }else {
                message = "Login Successfully";
                alertType = "success";
                resp.sendRedirect("dashboard.jsp");
            }

        } else {
            message = "Invalid email or password!";
            alertType = "error";
        }



    }
}
