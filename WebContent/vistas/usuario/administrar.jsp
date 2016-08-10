<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="/templates/header.jsp"></jsp:include>
<%@ page import="java.util.*,modelo.entidades.*"%>
<% 
	List<Usuario> listaUsuario = (List<Usuario>)request.getAttribute("listaUsuario");
%>
<section class="container">
	<div class="row">
		<div class="col-lg-12">
			<form class="form-horizontal" id="loginForm" method="get" action="${pageContext.request.contextPath}/usuario/administrar">
				<fieldset>
					<legend>Administraci&oacute;n de Usuarios</legend>
					<div>
						<div class="form-group">
							<label for="nombre" class="col-lg-1 control-label">Nombre:</label>
							<div class="col-lg-11">
								<input type="text" class="form-control" id="nombre"
									name="nombre" placeholder="Nombre del usuario">
							</div>
						</div>
						<div>
							<button type="submit" class="btn btn-primary"
								data-container="body" data-toggle="popover" data-placement="top">Buscar</button>
							<a class="btn btn-primary" data-container="body"
				data-toggle="popover" data-placement="top" href="${pageContext.request.contextPath}/usuario/crear">Registrar nuevo</a>
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
									<th class="col-xs-3">CI</th>
									<th class="col-xs-3">Nombre</th>
									<th class="col-xs-2">Tel&eacute;fono</th>
									<th class="col-xs-3">Correo Electr&oacute;nico</th>
									<th class="col-xs-1">Acci&oacute;n</th>
								</tr>
							</thead>

							<tbody>
							<%
								try{
									
								for (Usuario u:listaUsuario){
							%>
								<tr>
									<td><%=u.getUsr_ci() %></td>
									<td><%=u.getUsr_nombre() %></td>
									<td><%=u.getUsr_telefono() %></td>
									<td><%=u.getUsr_correo() %></td>
									<td>
										<form method="get"
											action="${pageContext.request.contextPath}/usuario/modificar">
											<button type="submit" class="btn btn-default" value="<%=u.getUsr_ci() %>"
												name="usuarioModificar">
												<span class="material-icons md-16">&#xE150;</span>
											</button>
										</form>
									</td>
									<td>
										<form method="post"
											action="${pageContext.request.contextPath}/usuario/eliminar">
											<button type="submit" class="btn btn-default" value="<%=u.getUsr_ci()%>"
												name="usuarioEliminar">
												<i class="material-icons md-16">&#xE872;</i>
											</button>
										</form>
									</td>
									<td>
										<form method="get"
											action="${pageContext.request.contextPath}/usuario/ver">
											<button type="submit" class="btn btn-default" value="<%=u.getUsr_ci()%>"
												name="usuarioInfo">
												<i class="material-icons">&#xE8F4;</i>
											</button>
										</form>
									</td>
								</tr>
								<%
								} }catch(Exception e){
									System.out.println("No hay lista de usuarios");
								}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>

<jsp:include page="/templates/footer.jsp"></jsp:include>