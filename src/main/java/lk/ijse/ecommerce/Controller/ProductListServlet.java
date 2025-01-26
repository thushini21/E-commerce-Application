package lk.ijse.ecommerce.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.ecommerce.bo.BOFactory;
import lk.ijse.ecommerce.bo.custom.CategoryBO;
import lk.ijse.ecommerce.bo.custom.ProductBO;
import lk.ijse.ecommerce.dto.categoryDTO;
import lk.ijse.ecommerce.dto.productDTO;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "productListServlet",value = "/product-list")
public class ProductListServlet extends HttpServlet {
    ProductBO productBo = (ProductBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.PRODUCT);
    private final CategoryBO categoryBO = (CategoryBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.CATEGORY);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<productDTO> productDTOS;
        try{

            productDTOS = productBo.getAllProductDTOs();
            req.setAttribute("productList", productDTOS);

            List<categoryDTO> categories = categoryBO.categoryList(); // Fetch only names for simplicity

            // Set categories in request scope
            req.setAttribute("categories", categories);

            req.getRequestDispatcher("productManagement.jsp").forward(req, resp);
        } catch (Exception e){
            e.printStackTrace();
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to load products.");
        }
    }
}
