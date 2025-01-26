<%@ page import="java.util.List" %>
<%@ page import="lk.ijse.ecommerce.dto.userDTO" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Management</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f4f0ff; /* Light purple background */
        }
        .container {
            max-width: 1200px;
        }
        .page-header {
            background-color: #6f42c1; /* Purple header */
            color: white;
            padding: 15px;
            border-radius: 8px;
        }
        .table-striped tbody tr:nth-of-type(odd) {
            background-color: #f9f6ff; /* Subtle purple for table rows */
        }
        .table-striped tbody tr:nth-of-type(even) {
            background-color: #ffffff; /* White rows */
        }
        .btn-primary, .btn-danger, .btn-success {
            border: none;
            transition: transform 0.2s ease-in-out;
        }
        .btn-primary:hover, .btn-danger:hover, .btn-success:hover {
            transform: scale(1.05); /* Slight zoom effect on hover */
        }
        .btn-primary {
            background-color: #6f42c1; /* Primary action purple */
        }
        .btn-secondary {
            background-color: #a069d9; /* Subtle secondary purple */
        }
        .btn-secondary:hover {
            background-color: #8e56c7; /* Darker hover for secondary */
        }
    </style>
</head>
<body>
<div class="container my-4">
    <!-- Page Header -->
    <div class="page-header d-flex justify-content-between align-items-center mb-4">
        <h2 class="mb-0">User Management</h2>
        <a href="adminDashboard.jsp" class="btn btn-secondary">Back to Dashboard</a>
    </div>

    <!-- User Table -->
    <div class="card shadow-lg">
        <div class="card-header bg-dark text-white">
            <h5 class="mb-0">User List</h5>
        </div>
        <div class="card-body p-0">
            <%
                List<userDTO> userList = (List<userDTO>) request.getAttribute("users");
                if (userList != null && !userList.isEmpty()) {
            %>
            <table class="table table-striped table-hover mb-0">
                <thead class="table-dark">
                <tr>
                    <th>#</th>
                    <th>Full Name</th>
                    <th>Email</th>
                    <th>Role</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <%
                    for (userDTO user : userList) {
                %>
                <tr>
                    <td><%= user.getUserId() %></td>
                    <td><%= user.getUsername() %></td>
                    <td><%= user.getEmail() %></td>
                    <td><%= user.getRole() %></td>
                    <td>
                        <span class="badge <%= user.getStatus().equals("active") ? "bg-success" : "bg-danger" %>">
                            <%= user.getStatus() %>
                        </span>
                    </td>
                    <td>
                        <a href="user_servlet?action=Deactivate&Status=inactive&userId=<%= user.getUserId() %>" class="btn btn-sm btn-danger">Deactivate</a>
                        <a href="user_servlet?action=Activate&Status=active&userId=<%= user.getUserId() %>" class="btn btn-sm btn-success">Activate</a>
                    </td>
                </tr>
                <%
                    }
                %>
                </tbody>
            </table>
            <% } else { %>
            <div class="p-4 text-center">
                <p class="text-muted">No users found. Add some users to view them here.</p>
            </div>
            <% } %>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
