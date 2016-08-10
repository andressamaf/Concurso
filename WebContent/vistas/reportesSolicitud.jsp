<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="/templates/header.jsp"></jsp:include>

<section class="container">
	<div class="row">
		<form class="form-horizontal" id="loginForm" method="post" action="Reporte">
			<fieldset>
				<legend>Reportes de Solicitud</legend>
				<div>
					<div class="form-group">
						<label for="fecha" class="col-lg-2 control-label">Fecha de
							incio</label>
						<div class="col-lg-4">
							<input type="date" class="form-control" id="fecha"
								placeholder="yyyy-mm-dd" name="fechaInicio" />
						</div>
						<label for="nombre" class="col-lg-2 control-label">Fecha
							fin</label>
						<div class="col-lg-4">
							<input type="date" class="form-control" id="fecha"
								placeholder="yyyy-mm-dd" name="fechaFin" />
						</div>
						<!--  <input type="hidden" value="<%=new Date()%>" class="form-control"
							id="fechaSolicitud" name="fechaSolicitud" /> <input
							type="hidden" value="S" class="form-control" id="estadoSolicitud"
							name="estadoSolicitud" />-->
					</div>
					<div>
						<!--  <button type="submit" class="btn btn-primary"
							data-container="body" data-toggle="popover" data-placement="top">Buscar</button>-->
						<button type="submit" class="btn btn-primary"
							data-container="body" data-toggle="popover" data-placement="top">Generar PDF</button>
					</div>
				</div>
			</fieldset>
		</form>
		<!--  <div class="formclass">
			<div class="row">
				<div class="col-xs-12">
					<table class="table table-striped table-hover ">
						<thead>
							<tr>
								<th>Provincia</th>
								<th>Ciudad</th>
								<th>CI</th>
								<th>Apellidos</th>
								<th>Nombres</th>
								<th>Fecha de la solicitud</th>
								<th>Teléfono</th>
								<th>Estado</th>
							</tr>
						</thead>

						<tbody>
							<tr>
								<td>Leonardo Di Caprio</td>
								<td>Leonardo Di Caprio</td>
								<td>Leonardo Di Caprio</td>
								<td>Leonardo Di Caprio</td>
								<td>Leonardo Di Caprio</td>
								<td>Leonardo Di Caprio</td>
								<td>Leonardo Di Caprio</td>
								<td>Leonardo Di Caprio</td>
							</tr>
							<tr>
								<td>Leonardo Di Caprio</td>
								<td>Leonardo Di Caprio</td>
								<td>Leonardo Di Caprio</td>
								<td>Leonardo Di Caprio</td>
								<td>Leonardo Di Caprio</td>
								<td>Leonardo Di Caprio</td>
								<td>Leonardo Di Caprio</td>
								<td>Leonardo Di Caprio</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>-->
	</div>
</section>

<jsp:include page="/templates/footer.jsp"></jsp:include>