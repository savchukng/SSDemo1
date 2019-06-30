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
            <h1>Name <c:out value="${user.username}"/></h1>
            <h1>Your current vehicle: <c:out value="${user.driversVehicle}"/></h1>
            <button class="btn btn-primary" data-toggle="modal" data-target="#set-state-modal">Set state</button>
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