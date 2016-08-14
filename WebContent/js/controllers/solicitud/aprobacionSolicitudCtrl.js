var app = angular.module("SRD")
app.controller("AprobacionCtrl", function($scope, SolicitudSrv, $rootScope,
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
	$scope.execRegistrar = false
	$scope.msgBackgroundError = {
		'background-color' : '#E57373'
	};

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
	$scope.fecha = {
		inicio : "",
		fin : ""
	}
	$scope.listar = function() {
		$scope.fecha.inicio = $filter('date')($scope.fecha.inicio, "yyyy-MM-dd")
		$scope.fecha.fin = $filter('date')($scope.fecha.fin, "yyyy-MM-dd")
		console.log("fechas: " + $scope.fecha.inicio + "   "+ $scope.fecha.fin)
		SolicitudSrv.consultaFechas($scope.fecha, function(data) {
			$scope.reportes = data;
			console.log("exito");
		}, function() {
			console.log("error");
			$scope.addAlert("danger", "Error! al buscar.");
		})
	}
	$scope.aceptar = function(r) {
		r.sol_estado = "A"
		SolicitudSrv.editar(r, function() {
			$scope.addAlert("success", "Éxito! al aceptar la solicitud.");
			console.log("editado")
			for (var i = 0; i <= $scope.reportes.length; i++) {
				if ($scope.reportes[i].sol_ci == r.sol_ci) {
					$scope.reportes.splice(i, 1);
				}
			}
		}, function() {
			$scope.addAlert("danger", "Error! al aceptar.");
			console.log("error en editar")
		})
	}
	$scope.rechazar = function(r) {
		r.sol_estado = "R"
		SolicitudSrv.editar(r, function() {
			$scope.addAlert("success", "Éxito! al rechazar la solicitud.");
			console.log("editado")
			for (var i = 0; i <= $scope.reportes.length; i++) {
				if ($scope.reportes[i].sol_ci == r.sol_ci) {
					$scope.reportes.splice(i, 1);
				}
			}
		}, function() {
			$scope.addAlert("danger", "Error! al rechazar.");
			console.log("error en editar")
		})
	}
})