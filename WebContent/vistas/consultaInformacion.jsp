<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="/templates/header.jsp"></jsp:include>

<%@ page import="java.util.*,modelo.entidades.*"%>

<%
	List<Solicitud> listaSolicitud = (List<Solicitud>) request.getAttribute("listaSolicitud");
%>

<section class="container">
	<div class="row">
		<form class="form-horizontal" method="get">
			<fieldset>
				<legend>Consulta de Información</legend>
				<div>
					<div class="form-group">
						<label for="nombre" class="col-lg-1 control-label">CI</label>
						<div class="col-lg-5">
							<input type="text" class="form-control" id="nombreActor"
								name="ci" placeholder="CI">
						</div>
						<label for="nombre" class="col-lg-1 control-label">Apellido</label>
						<div class="col-lg-5">
							<input type="text" class="form-control" id="nombreActor"
								name="apellido" placeholder="Apellido">
						</div>
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
					<%
						if (request.getAttribute("mensaje") != null){
							%>
							<p class="txt-danger">
							<%=request.getAttribute("mensaje") %>
							</p>
							<%
						}
						else {
							%>
							<table class="table table-striped table-hover ">
						<thead>
							<tr>
								<th>CI</th>
								<th>Apellidos</th>
								<th>Nombres</th>
								<th>Fecha de la solicitud</th>
								<th>Estado</th>
							</tr>
						</thead>

						<tbody>
						<%
							for (Solicitud s : listaSolicitud) {
						%>
							<tr>
								<td><%=s.getSol_ci() %></td>
								<td><%=s.getSol_apellidos() %></td>
								<td><%=s.getSol_nombres() %></td>
								<td><%=s.getSol_fecha() %></td>
								<td><%=s.getSol_estado() %></td>
							</tr>
						<%
							}
						%>
						</tbody>
					</table>
							<%
						}
					%>
					
				</div>
			</div>
		</div>
	</div>
</section>

<jsp:include page="/templates/footer.jsp"></jsp:include>