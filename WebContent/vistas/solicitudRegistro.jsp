<%@page import="modelo.entidades.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<jsp:include page="/templates/header.jsp"></jsp:include>

<section class="container">
	<div class="row">
		<form class="form-horizontal" method="post" action="RegistrarSolicitud">
			<fieldset>
				<legend>Ingreso de Solicitud de Registro</legend>
				<div class="form-group">
					<label for="nombre" class="col-lg-2 control-label">CI</label>
					<div class="col-lg-4">
						<input name="SOL_CI" type="text" class="form-control" id="CI" placeholder="CI"
						
						pattern="^[0-9]*$"
				required
				title="Solo se admiten numeros."
						
					pattern=".{10,10}"
				required title="Longitud incorrecta."	
						
						>
					</div>
				</div>
				<div class="form-group">
					<label for="nombre" class="col-lg-2 control-label">Nombres</label>
					<div class="col-lg-4">
						<input required name="SOL_NOMBRES" type="text" class="form-control" id="Nombres"
							placeholder="Nombres">
					</div>
					<label for="nombre" class="col-lg-2 control-label">Apellidos</label>
					<div class="col-lg-4">
						<input required name="SOL_APELLIDOS" type="text" class="form-control" id="Apellidos"
							placeholder="Apellidos">
					</div>
				</div>
				<div class="form-group">
					<label for="fecha" class="col-lg-2 control-label">Provincia</label>
					<div class="col-lg-4">
						<select required name="SOL_CODPROV" class="form-control" id="Provincia">
							<option selected value="0">Esmeraldas</option>
							<option value="1">Los Ríos</option>
							<option value="2">Manabí</option>
						</select>
					</div>
					<label for="fecha" class="col-lg-2 control-label">Ciudad</label>
					<div class="col-lg-4">
						<select required name="SOL_CODCIU" class="form-control" id="Ciudad">
							<option selected value="0">Cuidad 1</option>
							<option value="1">Ciudad 2</option>
							<option value="2">Ciudad 3</option>
							<option value="3">Ciudad 4</option>
							<option value="4">Ciudad 5</option>
							<option value="5">Ciudad 6</option>
							<option value="6">Ciudad 7</option>
							<option value="7">Ciudad 8</option>
							<option value="8">Ciudad 9</option>
							<option value="9">Ciudad 10</option>
							<option value="10">Ciudad 11</option>
							<option value="11">Ciudad 12</option>
							<option value="12">Ciudad 13</option>
							<option value="13">Ciudad 14</option>
							<option value="14">Ciudad 15</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label class="col-lg-2 control-label">Sexo</label>
					<div class="col-lg-10">
						<div class="radio">
							<label> <input type="radio" name="SOL_SEXO_H"
								id="optionsRadios1" value="Hombre">H
							</label>
						</div>
						<div class="radio">
							<label> <input type="radio" name="SOL_SEXO_M"
								id="optionsRadios2" value="Mujer">M
							</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<label for="fecha" class="col-lg-2 control-label">Fecha de
						nacimiento</label>
					<div class="col-lg-4">
						<input required type="date" class="form-control" id="fechaNac"
							placeholder="yyyy-mm-dd" name="SOL_FECHANAC" />
					</div>
					<label for="nombre" class="col-lg-2 control-label">Teléfono</label>
					<div class="col-lg-4">
						<input required name="SOL_TELEFONO" type="text" class="form-control" id="telefono"
							placeholder="telefono">
					</div>
				</div>
				<div class="form-group">
					<label for="nombre" class="col-lg-2 control-label">Número de miembros del hogar</label>
					<div class="col-lg-4">
						<input required name="SOL_NUMMIEM" type="text" class="form-control" id="numeroMiembros"
							placeholder="numeroMiembros"
							
							pattern="^[0-9]*$"				
				title="Solo se admiten numeros."
							
							>
					</div>
					<label class="col-lg-3 control-label">Algún miembro tiene discapacidad</label>
					<div class="col-lg-3">
						<div class="radio">
							<label> <input type="radio" name="SOL_DISC_SI"
								id="discapacidadSi" value="true">Si
							</label>
						</div>
						<div class="radio">
							<label> <input type="radio" name="SOL_DISC_NO"
								id="discapacidadNo" value="false">No
							</label>
						</div>
					</div>
				</div>
			</fieldset>
			<div>
			<input type="submit" class="btn btn-primary" data-container="body"
				data-toggle="popover" data-placement="top"  value="Registrar"/>
		</div>
		</form>
		
	</div>
</section>

<jsp:include page="/templates/footer.jsp"></jsp:include>