<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="/templates/header.jsp"></jsp:include>
<%@ page import="java.util.*,modelo.entidades.*"%>
<section class="container" ng-controller="newUserCtrl">
	<div class="row">
		<div class="col-lg-9">
			<form class="form-horizontal" method="post" name="crearUsuario" action="${pageContext.request.contextPath}/usuario/crear">
				<legend>Registrar Usuario nuevo</legend>
				<fielset>
				<div class="form-group">
					<label for="ci" class="col-lg-2">CI: </label>
					<div class="col-lg-10">
						<div class="col-lg-9">
							<input type="text" id="ci" name="ci" class="form-control"
								ng-model="usuario.ci" required />
						</div>
						<div class="col-lg-3">
							<span class="msgError" ng-show="crearUsuario.ci.$error.required">Campo
								Requerido!</span>
						</div>
						<div class="col-lg-9">
							<div class="alert alert-dismissible alert-danger"
								ng-show="!validar()">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								<strong>Error!</strong> La c&eacute;dula es de 10 d&iacute;gitos
							</div>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="clave" class="col-lg-2">Contraseña: </label>
					<div class="col-lg-10">
						<div class="col-lg-9">
							<input type="password" id="clave" name="clave"
								class="form-control" ng-model="usuario.contrasenia" required
								pattern=".{8,16}" />
						</div>
						<div class="col-lg-3">
							<span class="msgError"
								ng-show="crearUsuario.clave.$error.required">Campo
								Requerido!</span>
						</div>
						<div class="col-lg-9">
							<div class="alert alert-dismissible alert-danger"
								ng-show="crearUsuario.clave.$error.pattern">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								<strong>Error!</strong> La contraseña debe tener de 8 a 16
								caracteres.
							</div>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="contrasenia2" class="col-lg-2">Confirmar
						Contraseña: </label>
					<div class="col-lg-10">
						<div class="col-lg-9">
							<input type="password" id="contrasenia2" name="contrasenia2"
								class="form-control" ng-model="contrasenia2" required />
						</div>
						<div class="col-lg-3">
							<span class="msgError"
								ng-show="crearUsuario.contrasenia2.$error.required">Campo
								Requerido!</span>
						</div>
						<div class="col-lg-9">
							<div class="alert alert-dismissible alert-danger"
								ng-show="usuario.contrasenia!=contrasenia2">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								<strong>Error!</strong> No coinciden las contraseñas.
							</div>
						</div>
					</div>

				</div>
				<div class="form-group">
					<label for="nombre" class="col-lg-2">Nombre:</label>
					<div class="col-lg-10">
						<div class="col-lg-9">
							<input type="text" id="nombre" name="nombre" class="form-control"
								ng-model="usuario.nombre" pattern=".{10,60}" required />
						</div>
						<div class="col-lg-3">
							<span class="msgError"
								ng-show="crearUsuario.nombre.$error.required">Campo
								Requerido!</span>
						</div>
						<div class="col-lg-9">
							<div class="alert alert-dismissible alert-danger"
								ng-show="crearUsuario.nombre.$error.pattern">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								<strong>Error!</strong> Debe colocar nombre y apellido que sea
								m&iacute;nimo de 10 a 60 caracteres
							</div>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="telefono" class="col-lg-2">Tel&eacute;fono</label>
					<div class="col-lg-10">
						<div class="col-lg-9">
							<input type="text" id="telefono" name="telefono"
								class="form-control" ng-model="usuario.fechaNac" required
								pattern=".{9,15}" />
						</div>
						<div class="col-lg-3">
							<span class="msgError"
								ng-show="crearUsuario.telefono.$error.required">Campo
								Requerido!</span>
						</div>
						<div class="col-lg-9">
							<div class="alert alert-dismissible alert-danger"
								ng-show="crearUsuario.telefono.$error.pattern">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								<strong>Error!</strong> debe tener de 9 a 15 d&iacute;gitos
							</div>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="email" class="col-lg-2">Email: </label>
					<div class="col-lg-10">
						<div class="col-lg-9">
							<input type="email" id="email" name="email"
								class="form-control" ng-model="usuario.direccion" required
								/>
						</div>
						<div class="col-lg-3">
							<span class="msgError"
								ng-show="crearUsuario.email.$error.required">Campo
								Requerido!</span>
						</div>
						<div class="col-lg-9">
							<div class="alert alert-dismissible alert-danger"
								ng-show="crearUsuario.email.$error.email">
								<button type="button" class="close" data-dismiss="alert">&times;</button>
								<strong>Error!</strong> No es un formato de correo electr&oacute;nico
							</div>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="admin" class="col-lg-2">Rol</label>
					<div class="col-lg-10">
						<div class="col-lg-9">
							<div class="radio">
								<label for="admin"> <input type="radio"
									ng-model="usuario.rol" name="rol" id="admin"
									value="Administrador" required>
									Administrador
								</label>
							</div>
							<div class="radio">
								<label for="digitador"> <input type="radio"
									ng-model="usuario.rol" name="rol" id="digitador"
									value="Digitador" required>
									Digitador
								</label>
							</div>
						</div>
						<div class="col-lg-3">
							<span class="msgError"
								ng-show="crearUsuario.rol.$error.required">Campo Requerido!</span>
						</div>
					</div>
				</div>
				<div>
					<button type="submit" class="btn btn-primary" data-container="body"
				data-toggle="popover" data-placement="top">Registrar</button>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a class="btn btn-primary" data-container="body"
				data-toggle="popover" data-placement="top" href="${pageContext.request.contextPath}/usuario/administrar">Volver</a>
				</div>
				</fielset>
			</form>
		</div>
		<div class="col-lg-3">
			<h2>Datos ingresados</h2>
			<p>CI: {{usuario.ci}}</p>
			<p>Nombre: {{usuario.nombre}}</p>
			<p>Fecha de nacimiento: {{usuario.fechaNac}}</p>
			<p>Direccion: {{usuario.direccion}}</p>
			<p>Rol: {{usuario.rol}}</p>
		</div>

	</div>
</section>
<jsp:include page="/templates/footer.jsp"></jsp:include>