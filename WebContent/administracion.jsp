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
<title>Administracion</title>
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
					<li class="nav-item active"><a class="nav-link"
						href="home.jsp">Home <span class="sr-only">(current)</span>
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

	<div class="container pt-5 mt-3">
		<div class="row row-cols-3">
			<div class="col">
				<div class="card" id="cardCrear">
					<img src="img\editar.png" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">
							<button type="button" name="crear" id="crear"
								class="btn btn-primary">Crear Nuevo Usuario</button>
						</h5>
						<p class="card-text">Como administrador en esta seccion podras
							agregar nuevos usuarios en la base de datos</p>
					</div>
				</div>

				<div name="formCrear" id="formCrear">
					<form class="border" action="CrearUsuario" method="post">
						<input id="signo" name="signo" type="hidden" value="">
						<div class="form-group">
							<label for="exampleInputEmail1">Nombre</label> <input type="text"
								class="form-control" id="nombre" name="nombre"
								placeholder="Nombre">
						</div>
						<div class="form-group">
							<label for="">Clave</label> <input type="password"
								class="form-control" id="clave" name="clave" placeholder="Clave">
						</div>
						<div class="form-group">
							<!-- Date input -->
							<label for="date">Fecha de nacimiento</label> <input
								class="form-control" id="date" name="date"
								placeholder="Fecha de Nacimiento" type="text" />
						</div>
						<button type="submit" class="btn btn-primary">Enviar</button>
					</form>
				</div>
			</div>
			<div class="col">
			<c:if test="${ empty sessionScope.usuarioEditar}"> 
				<div class="card" name="cardEditar" id="cardEditar">
					<img src="img\crear.png" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">
							<button type="button" id="editar" name="editar"
								class="btn btn-warning">Editar Usuario</button>
						</h5>
						<p class="card-text">Como administrador en esta seccion podras
							editar cualquier usuario en la base de datos</p>

					</div>
				</div>
				</c:if>
				<div name="divEditar" id="divEditar">
				
					<form class="border" action="ModificarUsuario" method="post">
						<input id="buscar" name="buscar" type="hidden" value="1">
						<div class="form-group" name="divFormEditar" id="divFormEditar">
							<select Name="seleccionEditar" id="seleccionEditar" class="custom-select custom-select-lg mb-3">
								<option selected>Seleccione Usuario</option>
								<c:forEach var="list" items="${sessionScope.listUS}">
									<option value="${list.user.idUser }">${list.user.nombre }</option>
								</c:forEach>
							</select>
						</div>
						<button type="submit" class="btn btn-primary">Buscar</button>
					</form>
				
				</div>
				<c:if test="${not empty sessionScope.usuarioEditar}">
				<c:set var = "ue" scope = "session" value = "${sessionScope.usuarioEditar}"/>
						<div name="divEditarFinal" id="divEditarFinal">
				<form class="border" action="ModificarUsuario" method="post">
				<input id="signoEdit" name="signoEdit" type="hidden" value="${ue.idSigno }">
				<input id="idUser" name="idUser" type="hidden" value="${ue.idUser }">
				<input id="buscar" name="buscar" type="hidden" value="2">
						<div class="form-group">
							<label for="">Nombre</label> <input type="text"
								class="form-control" id="nombreEdit" name="nombreEdit"
								placeholder="Nombre" value="${ue.nombre }">
						</div>
						<div class="form-group">
							<label for="">Clave</label> <input type="text"
								class="form-control" id="claveEdit" name="claveEdit" placeholder="Clave" value="${ue.clave }">
						</div>
						<div class="form-group">
							<!-- Date input -->
							<label for="dateEdit">Fecha de nacimiento</label> <input
								class="form-control" id="dateEdit" name="dateEdit" value="${ue.fechaNacimiento}"
								placeholder="Fecha de Nacimiento" type="text" />
						</div>
				<button type="submit" class="btn btn-primary">Editar</button>
				</form>
				
				</div>
				
				
				</c:if>
		
				
				
			</div>
			<div class="col">
				<div class="card" name="cardEliminar" id="cardEliminar">
					<img src="img\eliminar.png" class="card-img-top" alt="...">
					<div class="card-body">
						<h5 class="card-title">
							<button type="button" class="btn btn-danger"
								id="eliminar" name="eliminar">Eliminar Usuario</button>
						</h5>
						<p class="card-text">Como administrador en esta seccion podras
							eliminar cualquier usuario en la base de datos</p>
					</div>
				</div>

				<div id="divEliminar" name="divEliminar">
					<form class="border" action="EliminarUsuario" method="post">
						<div class="form-group">
							<select Name="seleccionEliminar" class="custom-select custom-select-lg mb-3">
								<option selected>Seleccione Usuario</option>
								<c:forEach var="list" items="${sessionScope.listUS}">
									<option value="${list.user.idUser }">${list.user.nombre }</option>
								</c:forEach>
							</select>

						</div>
						<div class="form-group form-check">
							<input type="checkbox" class="form-check-input"
								id="exampleCheck1"> <label class="form-check-label"
								for="exampleCheck1">Seguro desea eliminar?</label>
						</div>
						<button type="submit" class="btn btn-danger">Eliminar</button>
					</form>

				</div>


			</div>
		</div>

		<button type="button" name="mostrarLista" id="mostrarLista"
			class="btn btn-primary btn-lg btn-block">Mostrar Lista de
			Usuarios</button>
		<button type="button" name="ocultarLista" id="ocultarLista"
			class="btn btn-primary btn-lg btn-block">Ocultar Lista de
			Usuarios</button>
		<div id="tablaUsuarios" name="tablaUsuarios">

			<table class="table table-hover">
				<thead>
					<tr>
						<th scope="col">#</th>
						<th scope="col">ID</th>
						<th scope="col">Nombre</th>
						<th scope="col">Clave</th>
						<th scope="col">Fecha de Nacimiento</th>
						<th scope="col">Signo</th>
					</tr>
				</thead>
				<tbody>
					<c:set var="contador" value="${0}" />
					<c:forEach var="list" items="${sessionScope.listUS}">
						<c:set var="contador" value="${contador + 1}" />
						<tr>
							<td>${contador }</td>
							<td>${list.user.idUser }</td>
							<td>${list.user.nombre }</td>
							<td>${list.user.clave }</td>
							<td>${list.user.fechaNacimiento }</td>
							<td>${list.signo.nombre }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>


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
	<script type="text/javascript" src="js\menu.js"></script>

	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.7.1/js/bootstrap-datepicker.min.js"></script>

	<script type="text/javascript" src="js\register.js"></script>
	<script type="text/javascript" src="js\edit.js"></script>

</body>
</html>