<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Forgot Password</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background: linear-gradient(135deg, #7b1fa2, #9c27b0);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            margin: 0;
        }
        .container {
            background-color: #fff;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
            padding: 3rem;
            max-width: 500px;
            width: 100%;
        }
        h4 {
            color: #7b1fa2;
            font-weight: bold;
        }
        .form-control {
            border-radius: 8px;
            border: 1px solid #9c27b0;
        }
        .form-control:focus {
            border-color: #7b1fa2;
            box-shadow: 0 0 0 0.2rem rgba(123, 31, 162, 0.25);
        }
        .btn-primary {
            border-radius: 8px;
            padding: 0.8rem;
            font-size: 1rem;
            font-weight: bold;
            background: linear-gradient(135deg, #7b1fa2, #9c27b0);
            border: none;
        }
        .btn-primary:hover {
            background: linear-gradient(135deg, #9c27b0, #7b1fa2);
        }
        .text-muted {
            font-size: 0.9rem;
            color: #6a1b9a;
        }
        .text-muted a {
            color: #7b1fa2;
            font-weight: bold;
        }
        .text-muted a:hover {
            color: #9c27b0;
            text-decoration: underline;
        }
    </style>
</head>
<body>
<div class="container">
    <h4 class="mb-4 text-center">Reset Your Password</h4>
    <form action="#" method="POST">
        <!-- Email -->
        <div class="mb-3">
            <label for="email" class="form-label">Email Address</label>
            <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" required>
        </div>
        <!-- Password -->
        <div class="mb-3">
            <label for="password" class="form-label">Password</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" required>
        </div>
        <!-- Confirm Password -->
        <div class="mb-3">
            <label for="confirmPassword" class="form-label">Confirm Password</label>
            <input type="password" class="form-control" id="confirmPassword" name="confirmPassword" placeholder="Confirm your password" required>
        </div>

        <!-- Signup Button -->
        <button type="submit" class="btn btn-primary w-100">Reset Password</button>
    </form>
    <p class="text-muted text-center mt-3">
        Already have an account? <a href="index.jsp" class="text-decoration-none">Login here</a>.
    </p>
</div>
<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>