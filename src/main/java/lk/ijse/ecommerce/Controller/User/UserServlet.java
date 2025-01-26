package lk.ijse.ecommerce.Controller.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.ecommerce.bo.custom.BOImpl.userBOImpl;
import lk.ijse.ecommerce.dto.userDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/user_servlet")
public class UserServlet extends HttpServlet {

    private static final Logger log = LoggerFactory.getLogger(UserServlet.class);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String FullName = req.getParameter("fullName");
        String Email = req.getParameter("email");
        String Password = req.getParameter("password");

        String message = "";
        String alertType = "";

        userBOImpl userBO = new userBOImpl();
        userDTO userDTO = new userDTO(FullName, Email, Password);

        try{

            boolean isSaved = userBO.saveUser(userDTO);

            if (isSaved) {
                message = "Signup Successfully";
                alertType = "success";
            } else {
                message = "Signup failed. Please try again!";
                alertType = "error";
            }
        } catch (Exception e) {
            message = "An error occurred: " + e.getMessage();
            alertType = "error";
        }

        req.setAttribute("message", message);
        req.setAttribute("alertType", alertType);
        req.getRequestDispatcher("signUp.jsp").forward(req, resp);
    }
}
