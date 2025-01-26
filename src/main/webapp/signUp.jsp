<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sign Up</title>
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
            background-color: #fff;
            border-radius: 12px;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
            padding: 3rem;
            max-width: 500px;
            width: 100%;
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
        h4 {
            color: #6a1b9a; /* Purple for the header */
        }
    </style>
</head>
<body>
<div class="container">
    <h4 class="mb-4 text-center">Create an Account</h4>
    <form id="signupForm" action="user_servlet" method="POST">
        <!-- Full Name -->
        <div class="mb-3">
            <label for="fullName" class="form-label">Full Name</label>
            <input type="text" class="form-control" id="fullName" name="fullName" placeholder="Enter your full name" required>
        </div>
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
        <button type="submit" class="btn btn-primary w-100">Sign Up</button>
    </form>
    <p class="text-muted text-center mt-3">
        Already have an account? <a href="index.jsp" class="text-decoration-none">Login here</a>.
    </p>
</div>

<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
<script>
    // Client-side validation
    const signupForm = document.getElementById('signupForm');

    signupForm.addEventListener('submit', function (event) {
        event.preventDefault(); // Prevent the default form submission

        const password = document.getElementById('password').value;
        const confirmPassword = document.getElementById('confirmPassword').value;

        // Check if passwords match
        if (password !== confirmPassword) {
            Swal.fire({
                icon: 'error',
                title: 'Oops...',
                text: 'Passwords do not match!',
            });
            return;
        }

        // Check password length and complexity (example: at least 8 characters)
        if (password.length < 8) {
            Swal.fire({
                icon: 'error',
                title: 'Weak Password',
                text: 'Password must be at least 8 characters long!',
            });
            return;
        }

        // If validation passes, submit the form
        Swal.fire({
            icon: 'success',
            title: 'Validation Successful!',
            text: 'Submitting your data...',
            showConfirmButton: false,
            timer: 1500
        }).then(() => {
            signupForm.submit(); // Submit the form
        });
    });
</script>
</body>
</html>
