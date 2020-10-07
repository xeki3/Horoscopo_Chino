<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
	
	<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.min.css"
	rel="stylesheet" />
<title>Home</title>
</head>
<body>
	<header class="container-fluid">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="#"> <img
				src="https://static2.ideal.es/www/pre2017/multimedia/noticias/201612/12/media/cortadas/horoscopo-chino-kHcE-U216276673887LC-490x490@Ideal.jpg"
				width="30" height="30" alt="" loading="lazy">
			</a> <a class="navbar-brand" href="#">Horoscopo Chino</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="#">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="Administracion">Administracion</a></li>
				</ul>
				<form class="form-inline my-2 my-lg-0" action="CerrarSesion">
					<label class="form-control mr-sm-2" type="search"
						placeholder="Search" aria-label="Search">Hola,
						${sessionScope.login }</label>
					<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Salir</button>
				</form>
			</div>
		</nav>
	</header>

	<div class="container pt-5 mt-5">
		<form action="Administracion" method="post">
		<input id="signo" name="signo" type="hidden" value="">
		<input id="buscar" name="buscar" type="hidden" value="buscar">
		<h1>Busca tu signo del Horoscopo Chino</h1>
			<div class="input-group mb-3 input-group-lg">
			
				<input type="text" class="form-control" id="date" name="date"
					placeholder="Fecha de Nacimiento" aria-label="Recipient's username"
					aria-describedby="button-addon2">
				<div class="input-group-append">
					<button class="btn btn-outline-primary" type="submit"
						id="button-addon2">Buscar</button>
				</div>
			</div>

		</form>


	</div>
	
	<c:if test="${not empty sessionScope.nombreSigno}">
	<div>
		<h1 class="text-center">Felicidades en el Horoscopo Chino tu eres: ${sessionScope.nombreSigno} </h1>
	</div>
	
	</c:if>




	<script src="https://code.jquery.com/jquery-3.5.1.min.js"
		integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
		integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
		integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8shuf57BaghqFfPlYxofvL8/KUEfYiJOMMV+rV"
		crossorigin="anonymous"></script>
		
		<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>

	<script type="text/javascript" src="js\register.js"></script>
		

</body>
</html>