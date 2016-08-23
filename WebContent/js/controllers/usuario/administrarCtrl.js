var app = angular.module("SRD")
app.controller("UsuarioAdministrarCtrl", function($scope, UsuarioSrv) {
	$scope.usuarios = "";
	$scope.nombre = "";
	$scope.listar = function() {
		UsuarioSrv.listar($scope.nombre, function(respuesta) {
			$scope.usuarios = respuesta;
		}, function(respuesta) {
			console.log("error al listar usuarios");
		})
	};
	$scope.eliminar = function(ci) {
		UsuarioSrv.eliminar(ci, function() {
			console.log("Usuario eliminado con exito ");
			$scope.addAlert("success", "Éxito! al eliminar el usuario");
			for (var i = 0; i <= $scope.usuarios.length; i++) {
				if ($scope.usuarios[i].usrCi == ci) {
					$scope.usuarios.splice(i, 1);
				}
			}
		}, function() {
			$scope.addAlert("danger", "Error! al eliminar usuario");
		})
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
})