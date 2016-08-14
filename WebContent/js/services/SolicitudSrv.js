var app = angular.module("SRD")
app.service("SolicitudSrv", function($http){
	this.editar = function (solicitud, exito, error){
		$http.put("http://localhost:8080/SRDrest/servicios/solicitud/editar", solicitud).then(
			function(response){
				console.log("Exito en el servicio crear" );
				exito(response.data);
			},
			function(response){
				console.log("Error en el servicio crear" );
				error(response.data);
			}
		)
	};
	this.existe = function (solicitud, exito, error){
		$http.get("http://localhost:8080/SRDrest/servicios/solicitud/existe", solicitud).then(
			function(response){
				console.log("Exito en el servicio crear" );
				exito(response.data);
			},
			function(response){
				console.log("Error en el servicio crear" );
				error(response.data);
			}
		)
	};
	this.consultaFechas = function (fecha, exito, error){
		$http.get("http://localhost:8080/SRDrest/servicios/solicitud/consultaPorFechas?fechaIni="+fecha.inicio
				+"&fechaFin="+fecha.fin).then(
			function(response){
				console.log("Exito en el servicio crear" );
				exito(response.data);
			},
			function(response){
				console.log("Error en el servicio crear" );
				error(response.data);
			}
		)
	};
	this.reporte = function (fecha, exito, error){
		$http.get("http://localhost:8080/SRDrest/servicios/solicitud/consultaPorFechasReporte?fechaIni="
				+fecha.inicio+"&fechaFin="+fecha.fin).then(
			function(response){
				console.log("Exito en el servicio reporte" );
				exito(response.data);
			},
			function(response){
				console.log("Error en el servicio reporte" );
				error(response.data);
			}
		)
	};
	this.listar = function (lista, exito, error){
		$http.get("http://localhost:8080/SRDrest/servicios/solicitud/listaSolicitud?ci="+lista.ci
				+"&apellido="+lista.apellido).then(
			function(response){
				console.log("Exito en el servicio crear" );
				exito(response.data);
			},
			function(response){
				console.log("Error en el servicio crear" );
				error(response.data);
			}
		)
	};
	this.eliminar = function (solicitud, exito, error){
		$http.delete("http://localhost:8080/SRDrest/servicios/solicitud/eliminar", solicitud).then(
			function(response){
				console.log("Exito en el servicio crear" );
				exito(response.data);
			},
			function(response){
				console.log("Error en el servicio crear" );
				error(response.data);
			}
		)
	};
	this.guardar = function (solicitud, exito, error){
		$http.post("http://localhost:8080/SRDrest/servicios/solicitud/guardar", solicitud).then(
			function(response){
				console.log("Exito en el servicio crear" );
				exito(response.data);
			},
			function(response){
				console.log("Error en el servicio crear" );
				error(response.data);
			}
		)
	};
})