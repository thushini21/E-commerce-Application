<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>E-Commerce Web App</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <style>
        body {
            background: linear-gradient(135deg, #6a1b9a, #8e44ad); /* Purple gradient */
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            margin: 0;
        }
        .container {
            background-color: rgba(255, 255, 255, 0.95);
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
            overflow: hidden;
            display: flex;
            max-width: 1100px;
            width: 100%;
        }
        .image-section {
            background: url('images/Logo.jpg') center/cover no-repeat;
            flex: 1;
        }
        .form-section {
            flex: 1;
            padding: 3rem;
            display: flex;
            flex-direction: column;
            justify-content: center;
        }
        .form-section h4 {
            font-weight: bold;
            color: #6a1b9a; /* Purple text */
            margin-bottom: 1.5rem;
        }
        .form-control {
            border-radius: 8px;
            border: 1px solid #8e44ad; /* Purple border */
        }
        .form-control:focus {
            box-shadow: 0 0 0 0.2rem rgba(142, 68, 173, 0.25); /* Purple focus shadow */
            border-color: #8e44ad; /* Purple focus border */
        }
        .btn-primary {
            border-radius: 8px;
            padding: 0.8rem;
            font-size: 1rem;
            font-weight: bold;
            background: linear-gradient(135deg, #6a1b9a, #8e44ad); /* Purple gradient */
            border: none;
        }
        .btn-primary:hover {
            background: linear-gradient(135deg, #8e44ad, #6a1b9a); /* Hover effect */
        }
        .text-muted {
            font-size: 0.9rem;
        }
        a {
            color: #8e44ad; /* Purple links */
        }
        a:hover {
            color: #6a1b9a; /* Darker purple on hover */
        }
    </style>
</head>
<body>
<div class="container">
    <!-- Image Section -->
    <div class="image-section d-none d-md-block"></div>

    <!-- Form Section -->
    <div class="form-section">
        <h4 class="text-center">Welcome Back!</h4>
        <p class="text-center text-muted mb-4">Please login to your account</p>
        <form action="login" method="POST">
            <div class="mb-3">
                <label for="email" class="form-label">Email Address</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Password</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required>
            </div>
            <div class="d-flex justify-content-between align-items-center mb-4">
                <div>
                    <input type="checkbox" id="remember" name="remember">
                    <label for="remember" class="text-muted">Remember Me</label>
                </div>
                <a href="forgetPassword.jsp" class="text-decoration-none">Forgot Password?</a>
            </div>
            <button type="submit" class="btn btn-primary w-100">Login</button>
        </form>
        <div class="text-center mt-4">
            <p>Don't have an account? <a href="signUp.jsp" class="text-decoration-none">Sign Up</a></p>
        </div>
    </div>
</div>
<script>
    <%
        String message = (String) request.getAttribute("message");
        String alertType = (String) request.getAttribute("alertType");

        if (message != null && alertType != null) {
    %>
    Swal.fire({
        icon: '<%= alertType %>', // 'success' or 'error'
        title: '<%= alertType.equals("success") ? "Success!" : "Error!" %>',
        text: '<%= message %>',
        confirmButtonText: 'Okay'
    }).then((result) => {
        if (result.isConfirmed) {
            <% if ("success".equals(alertType)) { %>
            window.location.href = "dashboard.jsp";
            <% } %>
        }
    });
    <%} %>
</script>

<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
