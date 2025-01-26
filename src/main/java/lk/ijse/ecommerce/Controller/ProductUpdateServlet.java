package lk.ijse.ecommerce.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
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

@WebServlet("/product-update")
@MultipartConfig
public class ProductUpdateServlet extends HttpServlet {
    private final ProductBO productBO = (ProductBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.PRODUCT);
    CategoryBO categoryBO = (CategoryBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.CATEGORY);
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Retrieve form data
            Long productId = Long.valueOf(request.getParameter("id"));
            String productName = request.getParameter("name");
            String productCategory = request.getParameter("category");
            Integer productQty = Integer.valueOf(request.getParameter("qty"));
            Double productPrice = Double.valueOf(request.getParameter("price"));
            String productDescription = request.getParameter("des");
            String imagePart = request.getParameter("image");

            // Validate and convert data
            if (productId == null || productName == null || productCategory == null || productQty == null || productPrice == null) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Input Data");
                return;
            }

            /*int qty = Integer.parseInt(String.valueOf(productQty));
            double price = Double.parseDouble(String.valueOf(productPrice));

            // Save the image to a folder and get its path
            String uploadDir = getServletContext().getRealPath("") + "uploads";
            File uploadFolder = new File(uploadDir);
            if (!uploadFolder.exists()) uploadFolder.mkdir();

            String imagePath = null;
            if (imagePart != null && imagePart.getSize() > 0) {
                String fileName = System.currentTimeMillis() + "_" + imagePart.getSubmittedFileName();
                File imageFile = new File(uploadFolder, fileName);
                imagePart.write(imageFile.getAbsolutePath());
                imagePath = "uploads/" + fileName; // Relative path to be stored in the database
            }*/

            categoryDTO categoryDTO = categoryBO.getByName(productCategory);
            // Construct DTO
            productDTO productDTO = new productDTO(productId,productName,productDescription,productPrice,productQty,categoryDTO,imagePart);

            // Call BO to update product
            boolean isUpdated = productBO.updateProduct(productDTO);

            if (isUpdated) {
                response.sendRedirect("product-list?message=Product updated successfully");
            } else {
                response.sendRedirect("product-list?error=Product update failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("product-list?error=Something went wrong");
        }
    }
}
