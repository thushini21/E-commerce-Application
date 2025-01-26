package lk.ijse.ecommerce.Controller.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.ecommerce.bo.BOFactory;
import lk.ijse.ecommerce.bo.custom.userBO;

import java.io.IOException;

@WebServlet(name = "userStatusServlet", value = "/user_status")
public class UserStatusServlet extends HttpServlet {
    userBO userBO = (lk.ijse.ecommerce.bo.custom.userBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.USER);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String status = req.getParameter("Status");
        String userId = req.getParameter("userId");

        String message = "";
        String alertType = "";

        try {
            if ("Deactivate".equals(action) && "false".equals(status)) {
                userBO.deactivateUser(Integer.parseInt(userId));
                req.getRequestDispatcher("/userManagement.jsp").forward(req,resp);

            } else if ("Activate".equals(action) && "true".equals(status)) {
                userBO.activateUser(Integer.parseInt(userId));
                req.getRequestDispatcher("/userManagement.jsp").forward(req,resp);
            }else {
                message = "Error";
                alertType = "error";
            }
        }catch (Exception e){
            e.printStackTrace();
            resp.sendRedirect("userManagement.jsp?error=" + e.getMessage());
        }


    }
}
