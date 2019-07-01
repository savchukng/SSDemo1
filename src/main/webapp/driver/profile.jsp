<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script scr="/script/script.js"></script>
        <link rel = "stylesheet" type = "text/css" href = "/style/style.css" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
            <div class="container">
                <a class="navbar-brand" href="/index.html">
                    <img src="/image/logo.png" width="20%" alt="logo">
                </a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ml-auto" id="navbarResponsiveUL">
                        <li class="nav-item">
                            <a class="nav-link" href="/routes">Current route</a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="/profile">Profile<span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/sign-out">Sign Out</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <main class="col " style="height: 630px;">
<%--            <h1>Profile</h1>--%>
<%--            <h1><c:out value="${user.firstName}"/> <c:out value="${user.lastName}"/></h1>--%>
<%--            <h2 style="color: mediumslateblue"><c:out value="${user.userType}"/></h2>--%>
<%--            <h3>Username: <c:out value="${user.username}"/></h3>--%>
<%--            <h3>Email: <c:out value="${user.email}"/></h3>--%>
<%--            <h1>Your current vehicle: <c:out value="${user.driversVehicle}"/></h1>--%>
<%--            <button class="btn btn-primary" onclick="location.href='change-email.html'">Change email</button>--%>
<%--            <button class="btn btn-primary" onclick="location.href='change-password.html'">Change password</button>--%>
<%--            <button class="btn btn-primary" data-toggle="modal" data-target="#set-state-modal">Set state</button>--%>
            <div class="col-md-6 offset-md-3 profile">
                <div>
                    <h1 class="display-3" style="font-size: 40px">Profile</h1>
                    <hr />
                    <h1 class="display-4" style="margin: 20px 0; font-size: 30px"><c:out value="${user.firstName}"/> <c:out value="${user.lastName}"/></h1>
                    <h2 class="display-4" style="color: mediumslateblue; margin: 20px 0; font-size: 30px"><c:out value="${user.userType}"/></h2>
                    <div class="row" style="font-size: 20px">
                        <span class="col-sm-4">Username: </span><span><c:out value="${user.username}"/></span>
                    </div>
                    <div class="row" style="font-size: 20px">
                        <span class="col-sm-4">Email: </span><span><c:out value="${user.email}"/></span>
                    </div>
                    <div class="row" style="font-size: 20px">
                        <span class="col-sm-4">Vehicle: </span><span><c:out value="${user.driversVehicle}"/></span>
                    </div>
                    <button class="btn btn-info" style="margin-top: 20px" data-toggle="modal" data-target="#set-state-modal">Set state</button>
                    <div style="margin-top:30px">
                        <button class="btn btn-primary col-sm-5" onclick="location.href='change-email.html'">Change email</button>
                        <button class="btn btn-primary col-sm-5 offset-md-1" style="margin-left: 60px" onclick="location.href='change-password.html'">Change password</button>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="set-state-modal">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <form method="post" action="/set-state">
                            <div class="modal-header">
                                <h3 id="setDriverHeader">Set state for vehicle</h3>
                            </div>
                            <div class="modal-body">
                                <input id="appId" type="hidden" value="<c:out value="${user.driversVehicle.id}"/>" name="vehicleId">
                                <label for="state" class="col-form-label">State:</label>
                                <select class="form-control" name="state" id="state">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                </select>
                            </div>
                            <div class="modal-footer">
                                <input class="btn btn-default" type="submit" value="Set">
                                <button class="btn btn-cancel" data-dismiss="modal">Cancel</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </main>
    </body>
</html>