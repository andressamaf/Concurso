var app = angular.module("SRD")
app.controller("HomeUsrCtrl",function($rootScope, $scope) {
	$scope.cerrarSesion = function () {
		$rootScope.usuario.usr_ci = "";
		$rootScope.usuario.usr_nombre = "";
		$rootScope.usuario.estadousr = 0;
		$rootScope.usuario.usr_clave = "";
		$rootScope.usuario.usr_correo = "";
		$rootScope.usuario.usr_telefono = "";
		$scope.$location.path('/').replace();
	}
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
	$scope.buscar = function () {
        console.log("Current Params: " + $route.current.params.ci);
        UsuarioSrv.buscar($route.current.params.ci, function (u) {
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
        }, function () {
            console.log("error " + msgError);
            $scope.addAlert("danger", "Error Interno! Consulte con el administrador.");
        })
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
	$scope.eliminar = function() {
		UsuarioSrv.eliminar($route.current.params.ci, function() {
			console.log("Usuario eliminado con exito ");
			$scope.addAlert("success", "Éxito! al eliminar el usuario");
			for (var i = 0; i <= $scope.usuarios.length; i++) {
				if ($scope.usuarios[i].usrCi == ci) {
					$scope.usuarios.splice(i, 1);
				}
			}
		}, function() {
			$scope.addAlert("danger", "Error! al eliminar actor");
		})
	};

})