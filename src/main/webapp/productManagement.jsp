<%@ page import="java.util.List" %>
<%@ page import="lk.ijse.ecommerce.dto.categoryDTO" %>
<%@ page import="lk.ijse.ecommerce.dto.productDTO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Management</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container my-4">
    <!-- Page Header -->
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h1>Product Management</h1>
        <a href="adminDashboard.jsp" class="btn btn-secondary">Back to Dashboard</a>
    </div>

    <!-- Product Form -->
    <%
        String action = request.getParameter("action");
        String productId = request.getParameter("id");
        String productName = request.getParameter("name");
        String qty = request.getParameter("qty");
        String productCategory = request.getParameter("category");
        String productPrice = request.getParameter("price");

        boolean isEdit = action != null && action.equals("edit");
        boolean isID = productId != null && action.equals("id");
        boolean isName = productName != null && action.equals("name");
        boolean isQty = qty != null && action.equals("qty");


        // Assume categories are provided in the request scope as a List<String>
        List<categoryDTO> categories = (List<categoryDTO>) request.getAttribute("categories");
    %>
    <!-- Add Product Form -->
    <div class="card mb-4">
        <div class="card-header">
            Add New Product
        </div>
        <div class="card-body">
            <form action="product-save" method="post" enctype="multipart/form-data">
                <div class="mb-3">
                    <label for="name" class="form-label">Product Name</label>
                    <input type="text" class="form-control" id="name" name="name" required>
                </div>
                <div class="mb-3">
                    <label for="des" class="form-label">Product Description</label>
                    <input type="text" class="form-control" id="des" name="description" required>
                </div>
                <div class="mb-3">
                    <label for="category" class="form-label">Category</label>
                    <select class="form-control" id="category" name="category" required>
                        <% if (categories != null) { %>
                        <% for (categoryDTO category : categories) { %>
                        <option value="<%= category.getCategoryId() %>"><%= category.getName() %></option>
                        <% } %>
                        <% } %>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="qty" class="form-label">Quantity</label>
                    <input type="text" class="form-control" id="qty" name="qty" required>
                </div>
                <div class="mb-3">
                    <label for="price" class="form-label">Price ($)</label>
                    <input type="number" class="form-control" id="price" name="price" required>
                </div>
                <div class="mb-3">
                    <label for="image" class="form-label">Product Image</label>
                    <input type="file" class="form-control" id="image" name="image" accept="image/*" required>
                </div>
                <div class="text-end mt-4">
                    <button type="submit" class="btn btn-primary">Save Product</button>
                </div>
            </form>
        </div>
    </div>
    <!-- Edit Product Modal -->
    <div class="modal fade" id="editProductModal" tabindex="-1" aria-labelledby="editProductModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="editProductModalLabel">Edit Product</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form id="editProductForm" action="productServlet" method="post" enctype="multipart/form-data">
                        <input type="hidden" name="id" id="editProductId">
                        <div class="mb-3">
                            <label for="editName" class="form-label">Product Name</label>
                            <input type="text" class="form-control" id="editName" name="name" required>
                        </div>
                        <div class="mb-3">
                            <label for="editCategory" class="form-label">Category</label>
                            <select class="form-control" id="editCategory" name="category" required>
                                <% if (categories != null) { %>
                                <% for (categoryDTO category : categories) { %>
                                <option value="<%= category %>"><%= category %></option>
                                <% } %>
                                <% } %>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="editQty" class="form-label">Quantity</label>
                            <input type="text" class="form-control" id="editQty" name="qty" required>
                        </div>
                        <div class="mb-3">
                            <label for="editPrice" class="form-label">Price ($)</label>
                            <input type="number" class="form-control" id="editPrice" name="price" required>
                        </div>
                        <div class="mb-3">
                            <label for="editImage" class="form-label">Product Image</label>
                            <input type="file" class="form-control" id="editImage" name="image" accept="image/*">
                        </div>
                        <button type="submit" class="btn btn-success">Update Product</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <%
        List<productDTO> dataList = (List<productDTO>) request.getAttribute("productList");
        if (dataList != null && !dataList.isEmpty()) {


    %>

    <!-- Product List -->
    <h2>Product List</h2>
    <table class="table table-striped">
        <thead class="table-dark">
        <tr>
            <th>#</th>
            <th>Image</th>
            <th>Product Name</th>
            <th>Category</th>
            <th>Price</th>
            <th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (productDTO productDTO : dataList) {
        %>
        <%-- Example row (dynamic content should be generated by the servlet or backend logic) --%>
        <tr>
            <td><%=productDTO.getProductId() %></td>
            <td><img src="<%=productDTO.getImagepath() %>" alt="<%=productDTO.getImagepath() %>" style="width: 50px; height: 50px;"></td>
            <td><%=productDTO.getName() %></td>
            <td><%=productDTO.getCategory().getName() %></td>
            <td><%=productDTO.getPrice() %></td>
            <td>
                <button class="btn btn-sm btn-warning" onclick="openEditModal('1', 'Example Product', 'Example Category', '10', '100')">Edit</button>
                <a href="productServlet?action=delete&id=1" class="btn btn-sm btn-danger">Delete</a>
            </td>
        </tr>
        <%
            }
        %>

        <%-- Add dynamic rows here from the backend --%>
        </tbody>
        <%
            }
        %>
    </table>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
<script>
    function openEditModal(id, name, category, qty, price) {
        document.getElementById('editProductId').value = id;
        document.getElementById('editName').value = name;
        document.getElementById('editCategory').value = category;
        document.getElementById('editQty').value = qty;
        document.getElementById('editPrice').value = price;
        var editProductModal = new bootstrap.Modal(document.getElementById('editProductModal'));
        editProductModal.show();
    }
</script>
</body>
</html>