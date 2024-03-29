<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
	<head>
		<title>Applications</title>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script scr="/script/script.js"></script>
		<link rel = "stylesheet" type = "text/css" href = "/style/style.css" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script>
			function setAppNum(num) {
				document.getElementById("appId").value = num;
				$("#setDriverHeader").text("Set driver for application #" + num);
			}
		</script>
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
                            <a class="nav-link" href="/profile">Profile</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/sign-out">Sign Out</a>
                        </li>
			      	</ul>
			    </div>
			</div>
		</nav>
		<div class="container-fluid h-100">
		    <div class="row h-100">
		        <aside class="col-12 col-md-2 p-0 bg-dark">
		            <nav class="navbar navbar-expand navbar-dark bg-dark flex-md-column flex-row align-items-start">
		                <div class="collapse navbar-collapse">
		                    <ul class="flex-md-column flex-row navbar-nav w-100 justify-content-between">
		                        <li class="nav-item">
		                            <a class="nav-link pl-0" href="/routes">Routes</a>
		                        </li>
		                        <li class="nav-item">
		                            <a class="nav-link pl-0" href="/drivers">Drivers</a>
		                        </li>
		                        <li class="nav-item">
		                            <a class="nav-link pl-0" href="/vehicles">Vehicles</a>
		                        </li>
		                        <li class="nav-item active">
		                            <a class="nav-link pl-0" href="/applications">Applications</a>
		                        </li>
								<li class="nav-item">
									<a class="nav-link pl-0" href="/clients  ">Clients</a>
								</li>
		                    </ul>
		                </div>
		            </nav>
		        </aside>
		        <main class="col" style="min-height: 630px;">
                    <div>
						<ul class="nav nav-tabs">
							<li class="nav-item">
								<a class="nav-link" href="/applications">All</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="/applications?status=New">New</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="/applications?status=In progress">In progress</a>
							</li>
							<li class="nav-item">
								<a class="nav-link" href="/applications?status=Completed">Completed</a>
							</li>
						</ul>
					</div>
		        	<table class="table table-hover" style="margin:2%">
						<thead class="thead-light">
					  		<tr>
					      		<th scope="col">ID</th>
					    		<th scope="col">Status</th>
					    		<th scope="col">Registration Date</th>
					    		<th scope="col">Reception Date</th>
					    		<th scope="col">Completion Date</th>
					    		<th scope="col">Origin</th>
					    		<th scope="col">Destination</th>
					    		<th scope="col">Vehicle preference</th>
					      		<th scope="col">Driver</th>
					      		<th scope="col">User</th>
								<th scope="col"></th>
					    	</tr>
					  	</thead>
					  	<tbody>
                        <c:forEach items="${apps}" var="app">
                            <tr>
                                <th scope="row"><c:out value="${app.id}"/></th>
                                <td><c:out value="${app.status}"/></td>
                                <td><c:out value="${app.registrationDate}"/></td>
                                <td><c:out value="${app.receptionDate}"/></td>
                                <td><c:out value="${app.completionDate}"/></td>
                                <td><c:out value="${app.origin}"/></td>
                                <td><c:out value="${app.destination}"/></td>
                                <td><c:out value="${app.preference}"/></td>
                                <td><c:out value="${app.driver}"/></td>
                                <td><c:out value="${app.user}"/></td>
								 <td>
									 <button class="btn btn-primary" data-toggle="modal" data-target="#driver-modal" onclick="setAppNum(<c:out value="${app.id}"/>)">Set driver</button>
									 <button class="btn btn-primary" style="margin-top:15px; margin-left:15px;" onclick="location.href='/delete-application?id=<c:out value="${app.id}"/>'">
										 Delete
									 </button>
								 </td>
								 <div class="modal fade" id="driver-modal">
									<div class="modal-dialog">
										<div class="modal-content">
											<form action="/set-driver" method="post">
												<div class="modal-header">
													<h3 id="setDriverHeader"></h3>
												</div>
												<div class="modal-body">
                                                   <input id="appId" type="hidden" value="" name="appId">
													<label for="driver-id" class="col-form-label">Driver id:</label>
													<input type="text" class="form-control" name="driverId" id="driver-id">
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
                        </c:forEach>
					  </tbody>
					</table>
			    </main>
		    </div>
		</div>
	</body>
</html>