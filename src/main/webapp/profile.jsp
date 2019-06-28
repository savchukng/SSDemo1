<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% User user = (User) request.getSession().getAttribute("user"); %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
    <div class="container">
        <a class="navbar-brand" href="#">
            <img src="http://placehold.it/150x50?text=Logo" alt="">
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto" id="navbarResponsiveUL">
                <li class="nav-item">
                    <a class="nav-link" href="index.html">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="request-route">Request route</a>
                </li>
                <li class="nav-item active">
                    <a class="nav-link" href="#">Profile<span class="sr-only">(current)</span></a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container-fluid h-100" id="side">
    <div class="row h-100">
        <aside class="col-12 col-md-2 p-0 bg-dark">
            <nav class="navbar navbar-expand navbar-dark bg-dark flex-md-column flex-row align-items-start">
                <div class="collapse navbar-collapse">
                    <ul class="flex-md-column flex-row navbar-nav w-100 justify-content-between">
                        <li class="nav-item">
                            <a class="nav-link pl-0" href="routes.jsp">Routes</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link pl-0" href="drivers.jsp">Drivers</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link pl-0" href="vehicles.jsp">Vehicles</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link pl-0" href="applications.jsp">Applications</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </aside>
        <main class="col " style="height: 630px;">
            <h1>Name <%= user.getFirstName() %></h1>
        </main>
    </div>
</div>
</body>
</html>