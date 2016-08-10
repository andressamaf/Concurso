<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="/templates/header.jsp"></jsp:include>
<%@ page import="java.util.*,modelo.entidades.*"%>
<%
	Usuario u = (Usuario) request.getAttribute("usuarioEditar");
%>

<section class="container">
	<div class="row">
		<div class="col-lg-12">
			<form class="form-horizontal" method="post" name="modificarUsuario"
				action="${pageContext.request.contextPath}/usuario/modificar">
				<legend>Modificar Usuario</legend>
				<fielset>
				<div class="form-group">
					<label for="ci" class="col-lg-2">CI: </label>
					<div class="col-lg-10">
						<div class="col-lg-9">
							<input type="text" id="ci" name="ci" class="form-control"
								required value="<%=u.getUsr_ci()%>" readonly />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="nombre" class="col-lg-2">Nombre:</label>
					<div class="col-lg-10">
						<div class="col-lg-9">
							<input type="text" id="nombre" name="nombre" class="form-control"
								pattern=".{10,60}" required value="<%=u.getUsr_nombre()%>" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="clave" class="col-lg-2">Contraseña: </label>
					<div class="col-lg-10">
						<div class="col-lg-9">
							<input type="password" id="clave" name="clave"
								class="form-control" ng-model="usuario.contrasenia" required
								value="<%=u.getUsr_clave()%>" pattern=".{8,16}" />
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
					<label for="telefono" class="col-lg-2">Tel&eacute;fono</label>
					<div class="col-lg-10">
						<div class="col-lg-9">
							<input type="text" id="telefono" name="telefono"
								class="form-control" pattern=".{9,15}"
								value="<%=u.getUsr_telefono()%>" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="email" class="col-lg-2">Email: </label>
					<div class="col-lg-10">
						<div class="col-lg-9">
							<input type="email" id="email" name="email" class="form-control"
								required value="<%=u.getUsr_correo()%>" readonly />
						</div>
					</div>
				</div>
				<%
					if (u.getUsr_rol() == "Administrador") {
				%>
				<div class="form-group">
					<label class="col-lg-2 control-label">Rol</label>
					<div class="col-lg-10">
						<div class="col-lg-9">
							<div class="radio">
								<label> <input type="radio" name="genero"
									id="optionsRadios1" value="Administrador" checked>
									Administrador
								</label>
							</div>
							<div class="radio">
								<label> <input type="radio" name="genero"
									id="optionsRadios2" value="Digitador"> Digitador
								</label>
							</div>
						</div>
					</div>
				</div>
				<%
					} else {
				%>
				<div class="form-group">
					<label class="col-lg-2 control-label">Rol</label>
					<div class="col-lg-10">
						<div class="col-lg-9">
							<div class="radio">
								<label> <input type="radio" name="rol"
									id="optionsRadios1" value="Administrador">
									Administrador
								</label>
							</div>
							<div class="radio">
								<label> <input type="radio" name="rol"
									id="optionsRadios2" value="Digitador" checked>
									Digitador
								</label>
							</div>
						</div>
					</div>
				</div>
				<%
					}
				%>
				<div>
					<button type="submit" class="btn btn-primary" data-container="body"
						data-toggle="popover" data-placement="top">Modificar</button>
					<a class="btn btn-primary" data-container="body"
						data-toggle="popover" data-placement="top"
						href="${pageContext.request.contextPath}/usuario/administrar">Volver</a>
				</div>
				</fielset>
			</form>
		</div>
	</div>
</section>
<jsp:include page="/templates/footer.jsp"></jsp:include>