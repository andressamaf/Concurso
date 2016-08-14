var app = angular.module("SRD")
app.controller("UsuarioInfoCtrl", function($scope, UsuarioSrv, $route){
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

})