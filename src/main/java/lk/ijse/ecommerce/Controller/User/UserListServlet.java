package lk.ijse.ecommerce.Controller.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.ecommerce.bo.BOFactory;
import lk.ijse.ecommerce.bo.custom.userBO;
import lk.ijse.ecommerce.dto.userDTO;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserListServlet", value = "/user_list")
public class UserListServlet extends HttpServlet {
    userBO user = (userBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.USER);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<userDTO> users;

        try{
            users = user.getAllUsers();
            req.setAttribute("users", users);

            req.getRequestDispatcher("/userManagement.jsp").forward(req, resp);
        } catch (Exception e){
            e.printStackTrace();
            req.setAttribute("errorMessage", "An error occurred: " + e.getMessage());
        }
    }
}
