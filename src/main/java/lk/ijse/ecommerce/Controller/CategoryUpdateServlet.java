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
//-----------------------------//
@WebServlet(name = "category_update", value = "/categoryUpdate")
public class CategoryUpdateServlet extends HttpServlet {
    CategoryBO categoryBO = (CategoryBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.CATEGORY);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String categoryName = req.getParameter("name");
        String description = req.getParameter("description");
        int id= Integer.parseInt(req.getParameter("id"));
        System.out.println(categoryName + " " + description);
        String message = "";
        String alertType = "";

        categoryDTO category = new categoryDTO(id,categoryName, description);
        try{
            boolean isUpdate = categoryBO.updateCategory(category);
            if(isUpdate){
                message = "Category Updated Successfully";
                alertType = "success";
            } else {
                message = "Failed to Update Category";
                alertType = "error";
            }
        }catch (Exception e){
            message = "An error occurred: " + e.getMessage();
            alertType = "error";
        }
    }
    }

