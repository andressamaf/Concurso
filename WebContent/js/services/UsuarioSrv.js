var app = angular.module("SRD")
app.service("UsuarioSrv", function($http){
	this.loggin = function (usuario, exito, error){
		$http.post("http://localhost:8080/SRDrest/servicios/usuario/loggin", usuario).then(
			function(response){
				console.log("Exito en el servicio loggin");
				exito(response.data);
			},
			function(response){
				console.log("Error en el servicio loggin" );
				error(response.data);
			}
		)
	};
	this.crear = function (usuario, exito, error){
		$http.post("http://localhost:8080/SRDrest/servicios/usuario/crear", usuario).then(
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
	this.modificar = function (usuario, exito, error){
		$http.put("http://localhost:8080/SRDrest/servicios/usuario/modificar", usuario).then(
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
	this.eliminar = function (ci, exito, error){
		$http.delete("http://localhost:8080/SRDrest/servicios/usuario/eliminar?ci="+ci).then(
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
	this.buscar = function (ci, exito, error){
		$http.get("http://localhost:8080/SRDrest/servicios/usuario/buscar?ci="+ci).then(
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
	this.listar = function (nombre, exito, error){
		$http.get("http://localhost:8080/SRDrest/servicios/usuario/listar?nombre="+nombre).then(
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
	this.existe = function (ci, exito, error){
		$http.get("http://localhost:8080/SRDrest/servicios/usuario/existe?ci="+ci).then(
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
});