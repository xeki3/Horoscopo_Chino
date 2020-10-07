<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="css/StyleLogin.css">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/css/bootstrap-datepicker.min.css"
	rel="stylesheet" />


<title>Login</title>
</head>
<body>
	<div class="container login-container">
		<div class="row">
			<div
				class="col-xl-6 col-lg-6 col-md-12 col-xs-12 col-sm-12 login-form-1 mt-5">
				<form action="LoginAndRegister" method="get">
				<input id="login" name="login" type="hidden" value="second">
					<h3>Login</h3>

					<div class="form-group">
						<input type="text" class="form-control" name="nombre" placeholder="Nombre"
							value="" />
					</div>
					<div class="form-group">
						<input type="password" class="form-control" name="clave"
							placeholder="Clave" value="" />
					</div>
					<div class="form-group">
						<input type="submit" class="btnSubmit" value="Login" />
					</div>
					<div class="form-group">
						<a href="#" class="btnForgetPwd">Forget Password?</a>
					</div>
				</form>
			</div>
			<div
				class="col-xl-6 col-lg-6 col-md-12 col-xs-12 col-sm-12 login-form-2 mt-5">
				<form action="LoginAndRegister" method="get" name="formRegister" id="formRegister">
				<input id="login" name="login" type="hidden" value="first">
				<input id="signo" name="signo" type="hidden" value="">
					<h3>Registrate</h3>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Tu Nombre *" name="nombre"
							value="" />
					</div>
					<div class="form-group">
						<input type="password" class="form-control" name="clave"
							placeholder="Tu Clave *" value="" />
					</div>
					<div class="form-group">
						<!-- Date input -->
						<input class="form-control" id="date" name="date"
							placeholder="Fecha de Nacimiento" type="text" />
					</div>
					<div class="form-group">
						<input type="submit" class="btnSubmit" value="Registrarse" />
					</div>
				</form>
			</div>
		</div>
	</div>


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