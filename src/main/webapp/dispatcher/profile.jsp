<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
						<li class="nav-item active">
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
								<li class="nav-item">
									<a class="nav-link pl-0" href="/applications">Applications</a>
								</li>
								<li class="nav-item">
									<a class="nav-link pl-0" href="/clients">Clients</a>
								</li>
		                    </ul>
		                </div>
		            </nav>
		        </aside>
				<main class="col" style="height: 630px;">
					<div class="col-md-5 offset-md-3 profile">
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
							<div style="margin-top:30px">
								<button class="btn btn-primary col-sm-5" style="margin-left: 15px" onclick="location.href='change-email.html'">Change email</button>
								<button class="btn btn-primary col-sm-5 offset-md-1" onclick="location.href='change-password.html'">Change password</button>
							</div>
						</div>
					</div>
				</main>
		    </div>
		</div>
	</body>
</html>