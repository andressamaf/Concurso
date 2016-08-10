<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" ng-app="SRD" ng-controller="newUserCtrl">
<head>
<title>SRD</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/styles.css">
	<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/{{daltonismo}}">

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/angular.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/modal.js"></script>
<script src="${pageContext.request.contextPath}/js/app.js"
	type="text/javascript"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/js/ui-bootstrap-2.0.0.min.js"></script>
</head>
<body >
	<header class="container">
		<h1 class="col-lg-6">Sistema de Registro de Damnificados</h1>
		<label for="daltonismo" class="col-lg-2 control-label">Daltonismo</label>
		<div class="col-lg-4">
			<select class="form-control" id="daltonismo" ng-model="daltonismo" ng-click="estilo()">
				<option value="naranja.css">Con daltonismo</option>
				<option value="bootstrap.min.css">Sin daltonismo</option>
				</select>
		</div>
	</header>

	<nav class="container navbar navbar-inverse">
		<div class="container-fluid">
			<div class="active navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#bs-example-navbar-collapse-2">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand"
					href="${pageContext.request.contextPath}/Home">Home</a>
			</div>

			<div class="container collapse navbar-collapse"
				id="bs-example-navbar-collapse-2">
				<ul class="nav navbar-nav">
					<li><a href="${pageContext.request.contextPath}/Consulta">Consulta
							de información <span class="sr-only">(current)</span>
					</a></li>
					<li><a
						href="${pageContext.request.contextPath}/RegistrarSolicitud">Solicitud
							de registro </a></li>
					<li><a
						href="${pageContext.request.contextPath}/AprobacionSolicitud">Aprobación
							de solicitud </a></li>
					<li><a href="${pageContext.request.contextPath}/Reporte">Reportes
							de solicitudes </a></li>
					<li><a
						href="${pageContext.request.contextPath}/usuario/administrar">Administraci&oacute;n
					</a></li>

				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="${pageContext.request.contextPath}/CerrarSesion">Cerrar
							Sesión</a></li>
				</ul>
			</div>
		</div>
	</nav>