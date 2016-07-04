<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<aside>
	<div class="list-group">
		<form class="form-horizontal" method="post">
			<fieldset>
				<div class="form-group">
					<label for="inputEmail" class="control-label">Usuario</label>
					<div>
						<input type="text" class="form-control" id="ci" name="ci"
							placeholder="Usuario" required="true">
					</div>
				</div>
				<div class="form-group">
					<label for="inputPassword" class="control-label">Contraseña</label>
					<div>
						<input type="password" class="form-control" id="clave"
							name="clave" placeholder="Contraseña" required="true">
					</div>
				</div>
			</fieldset>
			<div>
				<button type="submit" class="btn btn-primary" data-container="body"
					data-toggle="popover" data-placement="top">Iniciar
					sesi&oacute;n</button>
			</div>
		</form>
	</div>
</aside>