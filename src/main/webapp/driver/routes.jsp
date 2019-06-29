<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
						<li class="nav-item active">
							<a class="nav-link" href="/routes">Current route</a>
						</li>
                        <li class="nav-item">
                            <a class="nav-link" href="/profile">Profile</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/sign-out">Sign Out</a>
                        </li>
			      	</ul>
			    </div>
			</div>
		</nav>
		<main class="col" style="min-height: 630px;">
			<table class="table table-hover" style="margin:2%">
				<thead class="thead-light">
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Origin</th>
					<th scope="col">Destination</th>
					<th scope="col">Current Location</th>
					<th scope="col"></th>
				</tr>
				</thead>
				<tbody>
					<tr>
						<th scope="row"><c:out value="${route.id}"/></th>
						<td><c:out value="${route.origin}"/></td>
						<td><c:out value="${route.destination}"/></td>
						<td><c:out value="${route.currentLocation}"/></td>
						<td><button class="btn btn-primary" data-toggle="modal" data-target="#driver-modal">Set current location</button></td>
						<div class="modal fade" id="driver-modal">
							<div class="modal-dialog">
								<div class="modal-content">
									<form action="/set-current-location" method="post">
										<div class="modal-header">
											<h3>Set Current Location</h3>
										</div>
										<div class="modal-body">
											<input id="appId" type="hidden" value="<c:out value="${route.id}"/>" name="routeId">
											<label for="current_location" class="col-form-label">Current location:</label>
											<input type="text" class="form-control" name="currentLocation" id="current_location">
										</div>
										<div class="modal-footer">
											<input class="btn btn-default" type="submit" value="Set">
											<button class="btn btn-cancel" data-dismiss="modal">Cancel</button>
										</div>
									</form>
								</div>
							</div>
						</div>
					</tr>
				</tbody>
			</table>
		</main>
	</body>
</html>