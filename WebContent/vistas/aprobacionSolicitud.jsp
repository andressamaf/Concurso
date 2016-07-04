<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="/templates/header.jsp"></jsp:include>
<%@ page import="java.util.*,modelo.entidades.*"%>

<section class="container">
	<div class="row">
		<form class="form-horizontal" id="loginForm" method="get">
			<fieldset>
				<legend>Aprobación de Solicitud</legend>
				<div>
					<div class="form-group">
						<label for="fecha" class="col-lg-2 control-label">Fecha de
							incio</label>
						<div class="col-lg-4">
							<input type="date" class="form-control" id="fechaInicio"
								placeholder="yyyy-mm-dd" name="fechaInicio" />
						</div>
						<label for="nombre" class="col-lg-2 control-label">Fecha
							fin</label>
						<div class="col-lg-4">
							<input type="date" class="form-control" id="fechaFin"
								placeholder="yyyy-mm-dd" name="fechaFin" />
						</div>
						<input type="hidden" value="<%=new Date()%>" class="form-control"
							id="fechaSolicitud" name="fechaSolicitud" /> <input
							type="hidden" value="S" class="form-control" id="estadoSolicitud"
							name="estadoSolicitud" />
					</div>
					<div>
						<button type="submit" class="btn btn-primary"
							data-container="body" data-toggle="popover" data-placement="top">Buscar</button>
					</div>
				</div>
			</fieldset>
		</form>
		<div class="formclass">
			<div class="row">
				<div class="col-xs-12">
					<table class="table table-striped table-hover ">
						<thead>
							<tr>
								<th>CI</th>
								<th>Apellidos</th>
								<th>Nombres</th>
								<th>Fecha de la solicitud</th>
								<th>Estado</th>
								<th></th>
							</tr>
						</thead>

						<tbody>
							<%
								List<Solicitud> listaSolicitud = (List<Solicitud>) request.getAttribute("listaSolicitud");
								for (Solicitud s : listaSolicitud) {
							%>
							<tr>
								<td><%=s.getSol_ci()%></td>
								<td><%=s.getSol_apellidos()%></td>
								<td><%=s.getSol_nombres()%></td>
								<td><%=s.getSol_fecha()%></td>
								<td><form method="post" class="btnclass"
										action="${pageContext.request.contextPath}/Aceptar">
										<button type="submit" class="btn btn-default" value="<%=s.getSol_ci()%>"
											name="solicitudAceptar">Aceptar</button>
									</form></td>
								<td>
									<form method="post" class="btnclass"
										action="${pageContext.request.contextPath}/Rechazar">
										<button type="submit" class="btn btn-default" value="<%=s.getSol_ci()%>"
											name="solicitudRechazar">Rechazar</button>
									</form>
								</td>
							</tr>
							<%
								}
							%>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</section>

<jsp:include page="/templates/footer.jsp"></jsp:include>