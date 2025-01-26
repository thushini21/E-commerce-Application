<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.Connection" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>MADHUSHI Fashion</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    .navbar {
      background-color: #6a1b9a; /* Purple */
    }
    .navbar-brand {
      color: #fff;
      font-weight: bold;
    }
    .navbar-brand:hover {
      color: #c39bd3; /* Light purple */
    }
    .navbar-nav .nav-link {
      color: white;
    }
    .navbar-nav .nav-link:hover {
      color: #c39bd3; /* Light purple */
    }
    .category-icons img {
      width: 100px;
      height: 50px;
      border-radius: 40%;
    }
    .category-label {
      margin-top: 10px;
      font-size: 14px;
      font-weight: 500;
    }
    .hero-section {
      background: linear-gradient(135deg, #8e44ad, #6a1b9a); /* Purple gradient */
      color: white;
      text-align: center;
      padding: 3rem 1rem;
    }
    .hero-section h1 {
      font-size: 2rem;
      margin-bottom: 1rem;
    }
    .hero-section p {
      font-size: 1.2rem;
    }
    #carouselExampleAutoplaying {
      height: 600px;
    }
    .category-container {
      display: flex;
      justify-content: space-between;
      flex-wrap: wrap;
      gap: 1rem;
    }
    .category-card {
      flex: 1 0 10%; /* Adjusts card width */
      text-align: center;
      border: 1px solid #c39bd3; /* Purple border */
      border-radius: 8px;
      padding: 1rem;
      background-color: #f9f3f9;
      box-shadow: 0 4px 20px rgba(0, 0, 0, 0.1);
      transition: transform 0.2s, box-shadow 0.2s;
    }
    .category-card img {
      width: 50%; /* Adjust width to fit the container */
      height: 50px; /* Adjust height as needed */
      object-fit: cover; /* Ensures the image covers the area while maintaining aspect ratio */
      border-radius: 3px; /* Optional: for rounded corners */
    }
    .category-card:hover {
      transform: scale(1.05);
      box-shadow: 0 8px 20px rgba(0, 0, 0, 0.2);
    }
    .category-name {
      color: #6a1b9a;
      font-weight: bold;
      margin: 0.5rem 0;
    }
    .category-description {
      font-size: 0.9rem;
      color: #7f8c8d;
    }
    footer {
      background-color: #6a1b9a; /* Purple */
      color: white;
    }
    .alert {
      border-radius: 8px;
    }
  </style>
</head>
<body>
<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-dark">
  <div class="container">
    <a class="navbar-brand" href="#">MADHUSHI FASHION</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <form class="d-flex ms-auto me-3" role="search">
        <input class="form-control me-2" type="search" placeholder="Search site" aria-label="Search">
        <button class="btn btn-warning" type="submit">Search</button>
      </form>
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link" href="index.jsp">Logout</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<!-- Hero Section -->
<div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="images/kade.jpeg" class="d-block w-100" style="height: 600px" alt="...">
    </div>

  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>

<!-- Categories Section -->
<div class="container">
  <h2 class="text-center mt-5 mb-4">Our Categories</h2>

  <!-- Error/Success Messages -->
  <% if (request.getAttribute("errorMessage") != null) { %>
  <div class="alert alert-danger alert-dismissible fade show" role="alert">
    ${errorMessage}
    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
  </div>
  <% } %>

  <div class="category-container">
    <%
      try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "Ijse@1234");
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM category");

        while (rs.next()) {
    %>
    <div class="category-card">
      <img src="<%= rs.getString("image") %>" alt="<%= rs.getString("name") %>" class="category-image">
      <h3 class="category-name"><%= rs.getString("name") %></h3>
      <p class="category-description"><%= rs.getString("description") %></p>
    </div>
    <%
      }
      rs.close();
      stmt.close();
      conn.close();
    } catch(Exception e) {
      request.setAttribute("errorMessage", "Database Error: " + e.getMessage());
    %>
    <% } %>
  </div>
</div>

<!-- Footer -->
<footer class="text-center py-3">
  <p>&copy; 2025 MADHUSHI FASHION. All Rights Reserved.</p>
</footer>

<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
