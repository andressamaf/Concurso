var app = angular.module("SRD")
app.service("ProvinciaSrv", function($http){
	this.listar = function (exito, error){
		$http.get("http://localhost:8080/SRDrest/servicios/provincia/listar").then(
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