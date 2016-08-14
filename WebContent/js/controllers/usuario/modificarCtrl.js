var app = angular.module("SRD")
app.controller("UsuarioModificarCtrl", function($scope, UsuarioSrv, $route,$timeout) {
	$scope.execRegistrar = false
	$scope.msgBackgroundError = {
		'background-color' : '#E57373'
	};
	$scope.usuario = {
		usrCi : "",
		usrClave : "",
		usrNombre : "",
		usrTelefono : "",
		usrCorreo : "",
		usrRol : "",
		estadousr : 0
	}
	$scope.buscar = function() {
		console.log("Current Params: " + $route.current.params.ci);
		UsuarioSrv.buscar($route.current.params.ci, function(u) {
			if (u == "") {
				$scope.$location.path('/usuario/administrar').replace();
			} else {
				$scope.usuario.usrCi = u.usrCi;
				$scope.usuario.usrNombre = u.usrNombre;
				$scope.usuario.usrClave = u.usrClave;
				$scope.usuario.usrCorreo = u.usrCorreo;
				$scope.usuario.usrTelefono = u.usrTelefono;
				$scope.usuario.usrRol = u.usrRol;
			}
		}, function() {
			console.log("error " + msgError);
			$scope.addAlert("danger",
					"Error Interno! Consulte con el administrador.");
		})
	};

	$scope.modificar = function() {
		$scope.execRegistrar = true;
		$scope.alerts = [];
		if ($scope.usuario.usrCi == "" || $scope.usuario.usrClave == ""
				|| $scope.usuario.usrCorreo == ""
				|| $scope.usuario.usrRol == ""
				|| $scope.usuario.usrTelefono == ""
				|| $scope.usuario.usrNombre == "") {
			$scope.addAlert('danger', 'Error! Complete los campos vacíos.')
		}
		if (angular.isUndefined($scope.usuario.usrCi)
				|| angular.isUndefined($scope.usuario.usrClave)
				|| angular.isUndefined($scope.usuario.usrCorreo)
				|| angular.isUndefined($scope.usuario.usrNombre)
				|| angular.isUndefined($scope.usuario.usrTelefono)
				|| angular.isUndefined($scope.usuario.usrRol)) {
			$scope.addAlert('danger',
					'Error! Ingrese los campos correctamente.')
		}
		if ($scope.alerts.length == 0) {
			UsuarioSrv.modificar($scope.usuario, function(response) {
				console.log("exito al modificar");
				$scope.addAlert("success", "Éxito! al modificar el usuario");
				$timeout(function() {
					$scope.$location.path('/usuario/administrar').replace();
				}, 2000);

			}, function(mensajeError) {
				console.log(" error Actor modificando ctrl "+ mensajeError.danger)
				$scope.addAlert("danger", "Error! al modificar el acotr.");
			})
		}
	};
	$scope.validar = function() {
		var array = $scope.usuario.usrCi.split("");
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
			if ((final == 10 && digito == 0)
					|| (final == digito)) {

				return true;
			} else {

				return false;
			}
		} else {
			return false;
		}
	}
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

})