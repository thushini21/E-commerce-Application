<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Enhanced Admin Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://kit.fontawesome.com/a076d05399.js" crossorigin="anonymous"></script>
    <style>
        body {
            background-color: #f4f7fb;
            font-family: 'Roboto', sans-serif;
            color: #4a4a4a;
        }

        .content {
            margin-left: 0;
            padding: 2rem;
        }

        .dashboard-card {
            background-color: white;
            border-radius: 50%;
            padding: 2rem;
            box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1);
            transition: transform 0.4s ease-in-out, box-shadow 0.3s ease;
            width: 250px;
            height: 250px;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            margin: auto;
            text-align: center;
            cursor: pointer;
        }

        .dashboard-card:hover {
            transform: scale(1.1);
            box-shadow: 0 15px 30px rgba(0, 0, 0, 0.15);
        }

        .dashboard-card img {
            width: 100px;
            height: 100px;
            object-fit: cover;
            border-radius: 50%;
            margin-bottom: 1rem;
            transition: transform 0.3s ease;
        }

        .dashboard-card img:hover {
            transform: scale(1.1);
        }

        .dashboard-card h5 {
            font-size: 1.25rem;
            margin: 0.5rem 0;
            color: #6f42c1;
        }

        .dashboard-card p {
            color: #6c757d;
            margin-bottom: 1rem;
        }

        .btn-modern {
            border-radius: 5px;
            transition: all 0.2s;
            padding: 0.5rem 1rem;
        }

        .btn-modern:hover {
            opacity: 0.85;
        }

        .btn-primary {
            background-color: #6f42c1;
            border-color: #6f42c1;
        }

        .btn-primary:hover {
            background-color: #5e2a9e;
            border-color: #5e2a9e;
        }

        .btn-secondary {
            background-color: #9c27b0;
            border-color: #9c27b0;
        }

        .btn-secondary:hover {
            background-color: #7b1fa2;
            border-color: #7b1fa2;
        }

        .d-flex-center {
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .horizontal-buttons {
            display: flex;
            justify-content: center;
            margin-bottom: 2rem;
        }

        .horizontal-buttons a {
            margin: 0 1rem;
            padding: 0.8rem 1.5rem;
            font-size: 1.1rem;
            border-radius: 25px;
            transition: background-color 0.3s ease;
        }

        .horizontal-buttons a:hover {
            background-color: #6f42c1;
            color: white;
        }
    </style>
</head>
<body>

<!-- Main Content -->
<div class="content" id="content">
    <!-- Header -->
    <div class="d-flex justify-content-between align-items-center mb-4">
        <h1 class="h3 text-purple">Welcome to Admin Dashboard</h1>
        <button class="btn btn-outline-dark" id="toggleSidebar"><i class="fas fa-bars"></i></button>
    </div>

    <!-- Horizontal Button Row -->
    <div class="horizontal-buttons">
        <a href="product-list" class="btn btn-primary">Manage Products</a>
        <a href="categoryList" class="btn btn-secondary">Manage Categories</a>
        <a href="#order-management" class="btn btn-warning">View Orders</a>
        <a href="user_list" class="btn btn-success">Manage Users</a>
    </div>

    <!-- Dashboard Cards -->
    <div class="row g-4 d-flex-center">
        <div class="col-md-4">
            <div class="dashboard-card">
                <img src="images/mange%20product.jpg" alt="Product Management">
                <h5>Product Management</h5>
                <p>Manage your products efficiently, including adding, updating, and deleting products.</p>
                <a href="product-list" class="btn btn-modern btn-primary">Manage Products</a>
            </div>
        </div>
        <div class="col-md-4">
            <div class="dashboard-card">
                <img src="images/category%20manage.jpg" alt="Category Management">
                <h5>Category Management</h5>
                <p>Organize your store with effective category management.</p>
                <a href="categoryList" class="btn btn-modern btn-secondary">Manage Categories</a>
            </div>
        </div>
        <div class="col-md-4">
            <div class="dashboard-card">
                <img src="images/order%20manage.jpg" alt="Order Management">
                <h5>Order Management</h5>
                <p>Track and manage all customer orders seamlessly.</p>
                <a href="#order-management" class="btn btn-modern btn-warning">View Orders</a>
            </div>
        </div>
    </div>

    <!-- Additional Management Sections -->
    <div class="row g-4 mt-4 d-flex-center">
        <div class="col-md-4">
            <div class="dashboard-card">
                <img src="images/manage%20user.jpg" alt="User Management">
                <h5>User Management</h5>
                <p>View and manage customer accounts with ease.</p>
                <a href="user_list" class="btn btn-modern btn-success">Manage Users</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap and Script -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
<script>
    const sidebar = document.getElementById('sidebar');
    const content = document.getElementById('content');
    const toggleSidebar = document.getElementById('toggleSidebar');

    toggleSidebar.addEventListener('click', () => {
        sidebar.classList.toggle('sidebar-collapsed');
        content.classList.toggle('content-collapsed');
    });
</script>
</body>
</html>
