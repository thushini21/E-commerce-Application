package lk.ijse.ecommerce.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import lk.ijse.ecommerce.bo.BOFactory;
import lk.ijse.ecommerce.bo.custom.CategoryBO;
import lk.ijse.ecommerce.bo.custom.ProductBO;
import lk.ijse.ecommerce.dto.categoryDTO;
import lk.ijse.ecommerce.dto.productDTO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


@WebServlet( "/product-save")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,    // 1 MB
        maxFileSize = 1024 * 1024 * 5,      // 5 MB
        maxRequestSize = 1024 * 1024 * 10    // 10 MB
)
public class ProductSaveServlet extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "product_images";
    ProductBO productBo = (ProductBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.PRODUCT);
    CategoryBO categoryBO = (CategoryBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.CATEGORY);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = "";
        String alertType = "";
        try {
            String name = req.getParameter("name");
            String description = req.getParameter("description");
            int categoryId = Integer.parseInt(req.getParameter("category"));
            Integer qty = Integer.valueOf(req.getParameter("qty"));
            Double price = Double.valueOf(req.getParameter("price"));
            Part image = req.getPart("image");

            categoryDTO categoryDTO = categoryBO.getById(categoryId);

            // Input validation
            if (name == null || name.trim().isEmpty()) {
                message = "Product name is required";
                alertType = "danger";
                resp.sendRedirect("productManagement.jsp?message=" + message + "&alertType=" + alertType);
                return;
            }

            if (categoryDTO == null) {
                message = "Category is required";
                alertType = "danger";
                resp.sendRedirect("productManagement.jsp?message=" + message + "&alertType=" + alertType);
                return;
            }

            if (qty == null) {
                message = "Quantity is required";
                alertType = "danger";
                resp.sendRedirect("productManagement.jsp?message=" + message + "&alertType=" + alertType);
                return;
            }

            if (price == null) {
                message = "Price is required";
                alertType = "danger";
                resp.sendRedirect("productManagement.jsp?message=" + message + "&alertType=" + alertType);
                return;
            }
            // Create upload directory if it doesn't exist
            String applicationPath = req.getServletContext().getRealPath("");
            String uploadPath = applicationPath + File.separator + UPLOAD_DIRECTORY;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            // Generate unique filename
            String fileName = System.currentTimeMillis() + "_" +
                    getSubmittedFileName(image);
            String filePath = uploadPath + File.separator + fileName;
            image.write(filePath);

            // Save the file
            try (InputStream input = image.getInputStream();
                 FileOutputStream output = new FileOutputStream(filePath)) {

                byte[] buffer = new byte[8192];
                int bytesRead;
                while ((bytesRead = input.read(buffer)) != -1) {
                    output.write(buffer, 0, bytesRead);
                }
            }
            String imageUrl = UPLOAD_DIRECTORY + "/" + fileName;
            productDTO productDTO = new productDTO(name, description, price, qty, categoryDTO, "http://localhost:8080/E_commerce_Web_exploded/"+imageUrl);
            boolean isSaved = productBo.SaveProduct(productDTO);

            if (isSaved) {
                req.setAttribute("message", "Product added Successfully!");
                req.setAttribute("alertType", "success"); // or "error"
                req.getRequestDispatcher("product-list").forward(req,resp);
            } else {
                req.setAttribute("message", "Product added Filed!");
                req.setAttribute("alertType", "success"); // or "error"
                req.getRequestDispatcher("product-list").forward(req,resp);
            }
        }catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("product-list");
        }



    }
    private String getSubmittedFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=") + 2, token.length() - 1);
            }
        }
        return "";
    }
}
