var app = angular.module("SRD")
app.controller("ConsultaCtrl", function($scope, $rootScope, SolicitudSrv,
		$filter, $timeout) {
	$scope.solicitud = {
		sol_ci : "",
		sol_apellidos : "",
		sol_nombres : "",
		sol_codprov : 0,
		sol_codciu : 0,
		sol_sexo : "",
		sol_fechaNac : "",
		sol_nummiem : 0,
		sol_disc : 0,
		sol_telefono : "",
		sol_fecha : "",
		sol_estado : "",
		sol_usr : ""
	}
	$scope.lista = {
		ci: "",
		apellido: ""
	}
	$scope.reportes = []
	$scope.execRegistrar = false
	$scope.msgBackgroundError = {
		'background-color' : '#E57373'
	};
	$scope.solicitud.sol_fecha = new Date();
	$scope.alerts = [];

	$scope.addAlert = function(tipo, mensaje) {
		$scope.alerts.push({
			type : tipo,
			msg : mensaje
		});
	};

	$scope.closeAlert = function(index) {
		$scope.alerts.splice(index, 1);
	};
	$scope.listar = function(data){
		SolicitudSrv.listar($scope.lista, function(data) {
			$scope.reportes = data;
			console.log("exito");
		}, function() {
			console.log("error");
			$scope.addAlert("danger", "Error! al buscar.");
		})
	}
})