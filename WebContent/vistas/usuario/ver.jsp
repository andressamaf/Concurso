<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="/templates/header.jsp"></jsp:include>
<%@ page import="java.util.*,modelo.entidades.*"%>
<% 
	Usuario u = (Usuario)request.getAttribute("usuarioInformacion");
%>

<section class="container">
	<div class="row">
		<div class="col-lg-12">
			<form class="form-horizontal" method="get" name="crearUsuario" action="${pageContext.request.contextPath}/usuario/ver">
				<legend>Informaci&oacute;n del Usuario</legend>
				<fielset>
				<div class="form-group">
					<label for="ci" class="col-lg-2">CI: </label>
					<div class="col-lg-10">
						<div class="col-lg-9">
							<input type="text" id="ci" name="ci" class="form-control"
								 required readonly value="<%=u.getUsr_ci()%>"/>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="nombre" class="col-lg-2">Nombre:</label>
					<div class="col-lg-10">
						<div class="col-lg-9">
							<input type="text" id="nombre" name="nombre" class="form-control"
								 pattern=".{10,60}" required 
								value="<%=u.getUsr_nombre()%>" readonly/>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="telefono" class="col-lg-2">Tel&eacute;fono</label>
					<div class="col-lg-10">
						<div class="col-lg-9">
							<input type="text" id="telefono" name="telefono"
								class="form-control" required
								pattern=".{9,15}" value="<%=u.getUsr_telefono()%>" readonly/>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="email" class="col-lg-2">Email: </label>
					<div class="col-lg-10">
						<div class="col-lg-9">
							<input type="email" id="email" name="email"
								class="form-control"  required
								value="<%=u.getUsr_correo()%>" readonly/>
						</div>
					</div>
				</div>
				<div>
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