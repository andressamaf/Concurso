<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="/templates/header.jsp"></jsp:include>
<%@ page import="java.util.*,modelo.entidades.*"%>

<%
	List<Administrador> listaAdmin = (List<Administrador>) request.getAttribute("listaAdmin");
%>

	<section class="container">
		<form>
			<legend>
				Administración del usuario
			</legend>
			<fieldset>
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
								<th>Modificar</th>
								<th>Eliminar</th>
								<th>Ver</th>
							</tr>
						</thead>

						<tbody>
						<%
							for (Administrador a : listaAdmin) {
						%>
							<tr>
								<td><%=a.getUsr_ci() %></td>
								<td><%=a.getUsr_clave() %></td>
								<td>
										<form method="get"
											action="${pageContext.request.contextPath}/admin/modificar">
											<button type="submit" class="btn btn-default" value="<%=a.getUsr_ci() %>"
												name="adminModificar">
												<span class="material-icons md-16">&#xE150;</span>
											</button>
										</form>
									</td>
									<td>
										<form method="post"
											action="${pageContext.request.contextPath}/admin/eliminar">
											<button type="submit" class="btn btn-default" value="<%=a.getUsr_ci()%>"
												name="adminEliminar">
												<i class="material-icons md-16">&#xE872;</i>
											</button>
										</form>
									</td>
									<td>
										<form method="get"
											action="${pageContext.request.contextPath}/admin/info">
											<button type="submit" class="btn btn-default" value="<%=a.getUsr_ci() %>"
												name="adminInfo">
												<i class="material-icons">&#xE8F4;</i>
											</button>
										</form>
									</td>
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
	</section>
<jsp:include page="/templates/footer.jsp"></jsp:include>