var app = angular.module("SRD")
app.service("CiudadSrv", function($http){
	this.listar = function (id, exito, error){
		$http.get("http://localhost:8080/SRDrest/servicios/ciudad/listar?id="+id).then(
			function(response){
				console.log("Exito en el servicio listar" );
				exito(response.data);
			},
			function(response){
				console.log("Error en el servicio listar" );
				error(response.data);
			}
		)
	};
})