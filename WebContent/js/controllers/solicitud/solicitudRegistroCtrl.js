var app = angular.module("SRD")
app.controller("SolicitudCtrl", function($scope, $rootScope, SolicitudSrv,
		$filter, $timeout) {
	$scope.solicitud = {
		sol_ci : "",
		sol_apellidos : "",
		sol_nombres : "",
		sol_codprov : "",
		sol_codciu : "",
		sol_sexo : "",
		sol_fechaNac : "",
		sol_nummiem : "",
		sol_disc : "",
		sol_telefono : "",
		sol_fecha : "",
		sol_estado : "",
		sol_usr : ""
	}
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
	var existe = function() {
		SolicitudSrv.existe($scope.solicitud.sol_ci, function(response) {
			console.log($scope.solicitud.sol_ci)
			console.log(response)
			if (response)
				return true
			else
				return false

		}, function(msgError) {
			console.log("false")
		})
	}
	$scope.registrar = function() {
		$scope.solicitud.sol_fechaNac = $filter('date')(
				$scope.solicitud.sol_fechaNac, "yyyy-MM-dd")
		$scope.solicitud.sol_fecha = $filter('date')(
				$scope.solicitud.sol_fecha, "yyyy-MM-dd")
		$scope.solicitud.sol_estado = "S"

		$scope.execRegistrar = true;
		$scope.alerts = [];
		if ($scope.solicitud.sol_ci == "" || $scope.solicitud.sol_nombres == ""
				|| $scope.solicitud.sol_apellidos == ""
				|| $scope.solicitud.sol_sexo == ""
				|| $scope.solicitud.sol_disc == ""
				|| $scope.solicitud.sol_fechaNac == ""
				|| $scope.solicitud.sol_telefono == ""
				|| $scope.solicitud.sol_nummiem == ""
				|| $scope.solicitud.sol_estado == ""
				|| $scope.solicitud.sol_codprov == ""
				|| $scope.solicitud.sol_codciu == ""
				|| $scope.solicitud.sol_fecha == "") {
			$scope.addAlert('danger', 'Error! Complete los campos vacíos.')
		}
		if (angular.isUndefined($scope.solicitud.sol_ci)
				|| angular.isUndefined($scope.solicitud.sol_nombres)
				|| angular.isUndefined($scope.solicitud.sol_apellidos)
				|| angular.isUndefined($scope.solicitud.sol_telefono)
				|| angular.isUndefined($scope.solicitud.sol_fecha)
				|| angular.isUndefined($scope.solicitud.sol_fechaNac)
				|| angular.isUndefined($scope.solicitud.sol_estado)
				|| angular.isUndefined($scope.solicitud.sol_nummiem)
				|| angular.isUndefined($scope.solicitud.sol_sexo)
				|| angular.isUndefined($scope.solicitud.sol_disc)
				|| angular.isUndefined($scope.solicitud.sol_codprov)
				|| angular.isUndefined($scope.solicitud.sol_codciu)) {
			$scope.addAlert('danger',
					'Error! Ingrese los campos correctamente.')
		}

		if ($scope.alerts.length == 0) {
			SolicitudSrv.guardar($scope.solicitud, function() {
				$scope.addAlert("success", "Éxito! al guardar la solicitud");
				$timeout(function() {
					$scope.$location.path('/home').replace();
				}, 2000);
			}, function() {
				console.log("error");
				$scope.addAlert("danger", "Error! al guardar la solicitud.");
			})
		}
	}
	$scope.validar = function() {
		var array = $scope.solicitud.sol_ci.split("");
		var num = array.length;
		if (num == 10) {
			var total = 0;
			var digito = (array[9] * 1);
			for (var i = 0; i < (num - 1); i++) {
				var mult = 0;
				if ((i % 2) != 0) {
					total = total + (array[i] * 1);
				} else {
					mult = array[i] * 2;
					if (mult > 9)
						total = total + (mult - 9);
					else
						total = total + mult;
				}
			}
			var decena = total / 10;
			decena = Math.floor(decena);
			decena = (decena + 1) * 10;
			final = (decena - total);
			if ((final == 10 && digito == 0) || (final == digito)) {

				return true;
			} else {

				return false;
			}
		} else {
			return false;
		}
	};
})