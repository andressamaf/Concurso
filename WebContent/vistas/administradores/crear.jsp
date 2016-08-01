<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="/templates/header.jsp"></jsp:include>
	<section class="container">
	<div class="row">
		<div class="col-lg-12">
			<form class="form-horizontal" id="loginForm" name="loginForm" method="post" action="singup">
				<fieldset>
					<legend>Registro de Usuario</legend>
					<div class="form-group">
						<label for="inputName" class="col-lg-2 col-md-2 control-label">Nombre</label>
						<div class="col-lg-10 col-md-10">
							<div class="col-lg-11">
								<input type="text" class="form-control" id="inputName" name="username" ng-model="nombreUsuario" placeholder="Nombre"
									pattern=".{0,50}" required>
							</div>
							<div class="col-lg-1">
								<span class="msgError" ng-show="loginForm.username.$error.required">(*)</span>
							</div>
							<div class="col-lg-11">
								<div class="alert alert-dismissible alert-danger" ng-show="loginForm.username.$error.pattern">
									<button type="button" class="close" data-dismiss="alert">&times;</button>
									<strong>Error!</strong> El nombre de usuario debe tener un máximo de 50 caracteres.
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword" class="col-lg-2 control-label">Contrase&ntilde;a</label>
						<div class="col-lg-10 col-md-10">
							<div class="col-lg-11">
								<input type="password" class="form-control" id="inputPassword" name="password" ng-model="claveUsuario"
									placeholder="Contrase&ntilde;a" required pattern=".{8,16}">
							</div>
							<div class="col-lg-1">
								<span class="msgError" ng-show="loginForm.password.$error.required">(*)</span>
							</div>
							<div class="col-lg-11">
								<div class="alert alert-dismissible alert-danger" ng-show="loginForm.password.$error.pattern">
									<button type="button" class="close" data-dismiss="alert">&times;</button>
									<strong>Error!</strong> La contrase&ntilde;a debe tener de 8 a 16 caracteres.
								</div>
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="inputPassword" class="col-lg-2 control-label">Confirmar contrase&ntilde;a</label>
						<div class="col-lg-10 col-md-10">
							<div class="col-lg-11">
								<input type="password" class="form-control" id="inputPassword" name="confirmPassword" ng-model="confirmarClaveUsuario"
									placeholder="Contrase&ntilde;a" required pattern=".{8,16}">
							</div>
							<div class="col-lg-1">
								<span class="msgError" ng-show="loginForm.confirmPassword.$error.required">(*)</span>
							</div>
							<div class="col-lg-11">
								<div class="alert alert-dismissible alert-danger" ng-show="loginForm.confirmPassword.$error.pattern">
									<button type="button" class="close" data-dismiss="alert">&times;</button>
									<strong>Error!</strong> La contrase&ntilde;a debe tener de 8 a 16 caracteres.
								</div>
							</div>
							<div class="col-lg-11">
								<div class="alert alert-dismissible alert-danger" ng-show="claveUsuario != confirmarClaveUsuario">
									<button type="button" class="close" data-dismiss="alert">&times;</button>
									<strong>Error!</strong> Las contrase&ntilde;as deben coincidir.
								</div>
							</div>
						</div>
					</div>
					<div class="form-group">
                            <label for="fecha" class="col-lg-2 control-label">Fecha de nacimiento</label>
                            <div class="col-lg-10 col-md-10">
                                <div class="col-lg-11">
                                    <input type="date" class="form-control" id="fecha" name="fecha" ng-model="actor.nacimiento" placeholder="yyyy-mm-dd" required>
                                </div>
                                <div class="col-lg-1">
                                    <span class="msgError" ng-show="actorRegistrarForm.fecha.$error.required">(*)</span>
                                </div>
                            </div>
                        </div>
					<div>
						<button type="submit" class="btn btn-primary"
							data-container="body" data-toggle="popover" data-placement="top">Registrar</button>
					</div>
				</fieldset>
			</form>
		</div>
	</div>
</section>

<jsp:include page="/templates/footer.jsp"></jsp:include>