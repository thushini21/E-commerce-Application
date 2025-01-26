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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

@WebServlet(name = "category_servlet", urlPatterns = {"/Category"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,    // 1 MB
        maxFileSize = 1024 * 1024 * 5,      // 5 MB
        maxRequestSize = 1024 * 1024 * 10    // 10 MB
)
public class CategoryServlet extends HttpServlet {
    private static final String UPLOAD_DIRECTORY = "category_images";
    CategoryBO categoryBO = (CategoryBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.CATEGORY);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "";
        String alertType = "";
        try {
            // Get form data
            String categoryName = request.getParameter("name");
            String description = request.getParameter("description");
            Part imagePart = request.getPart("categoryImage");

            // Input validation
            if (categoryName == null || categoryName.trim().isEmpty()) {
                response.sendRedirect("categoryManagement.jsp?error=Category name is required");
                return;
            }

            if (description == null || description.trim().isEmpty()) {
                response.sendRedirect("categoryManagement.jsp?error=Description is required");
                return;
            }

            if (imagePart == null || imagePart.getSize() == 0) {
                response.sendRedirect("categoryManagement.jsp?error=Image is required");
                return;
            }

            // Create upload directory if it doesn't exist
            String applicationPath = request.getServletContext().getRealPath("");
            String uploadPath = applicationPath + File.separator + UPLOAD_DIRECTORY;
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            // Generate unique filename
            String fileName = System.currentTimeMillis() + "_" +
                    getSubmittedFileName(imagePart);
            String filePath = uploadPath + File.separator + fileName;

            // Save the file
            try (InputStream input = imagePart.getInputStream();
                 FileOutputStream output = new FileOutputStream(filePath)) {

                byte[] buffer = new byte[8192];
                int bytesRead;
                while ((bytesRead = input.read(buffer)) != -1) {
                    output.write(buffer, 0, bytesRead);
                }
            }

            // Save to database
            String imageUrl = UPLOAD_DIRECTORY + "/" + fileName;
            boolean isSaved = categoryBO.SaveCategory(categoryName, description, "http://localhost:8080/E_commerce_Web_exploded/"+imageUrl);

            if (isSaved) {
                message = "Category Added Successfully";
                alertType = "success";
            } else {
                // Delete uploaded file if database save fails
                Files.deleteIfExists(Paths.get(filePath));
                message = "Category Add Fail. Please try again!";
                alertType = "error";
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("categoryManagement.jsp?error=" + e.getMessage());
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