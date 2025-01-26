package lk.ijse.ecommerce.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.ecommerce.bo.BOFactory;
import lk.ijse.ecommerce.bo.custom.CategoryBO;
import lk.ijse.ecommerce.dto.categoryDTO;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "category_list", value = "/categoryList")
public class CategoryListServlet extends HttpServlet {
    CategoryBO categoryBO = (CategoryBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.CATEGORY);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<categoryDTO> categories ;

        try {
            categories = categoryBO.categoryList();
            req.setAttribute("categoryList", categories);

            req.getRequestDispatcher("categoryManagement.jsp").forward(req, resp);
        }catch (Exception e) {
            e.printStackTrace();

        }
    }
}
