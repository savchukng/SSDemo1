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
							<a class="nav-link" href="/user/request_route.html">Request route</a>
						</li>
						<li class="nav-item active">
							<a class="nav-link" href="/applications">My applications</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/profile">Profile<span class="sr-only">(current)</span></a>
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
					<th scope="col">Status</th>
					<th scope="col">Registration Date</th>
					<th scope="col">Reception Date</th>
					<th scope="col">Completion Date</th>
					<th scope="col">Origin</th>
					<th scope="col">Destination</th>
					<th scope="col">Vehicle preference</th>
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
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</main>
	</body>
</html>