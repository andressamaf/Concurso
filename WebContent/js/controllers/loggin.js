var app = angular.module("SRD")
app.controller("loggin", function($rootScope, $scope, UsuarioSrv){
	$scope.msgBackgroundError = {
			'background-color': '#E57373'
	};
	$scope.execLoggin = false
	$scope.loggin = function() {
			UsuarioSrv.loggin($scope.usuario, function(loggin) {
				console.log("exito " + loggin);
				if (loggin == true){
					$scope.execLoggin = true;
					console.log("loggin")
					$scope.setInfoUser();
				    $scope.$location.path('/home').replace();
				} else {
					console.log("error if")
					$scope.alerts = [];
					$scope.addAlert("danger","Error! Usuario y/o contraseña incorrectos.");
				}
			}, function(msgError) {
				console.log("error " + msgError);
				$scope.alerts = [];
				$scope.addAlert("danger","Error Interno! Consulte con el administrador.");
			})
		
	}
	
	$scope.setInfoUser = function() {
		UsuarioSrv.buscar($scope.usuario.usr_ci, function(usr) {
			console.log("exito");
			$rootScope.usuario.usrCi = usr.usrCi;
			$rootScope.usuario.usrClave = "";
			$rootScope.usuario.usrNombre = usr.usrNombre;
			$rootScope.usuario.usrRol = usr.usrRol;
			$rootScope.usuario.usrCorreo = usr.usrCorreo;
			$rootScope.usuario.usrTelefono = usr.usrTelefono;
			$rootScope.usuario.estadousr = 1;
		}, function(msgError) {
			console.log("error");
			$scope.alerts = [];
			$scope.addAlert("danger","Error Interno! Consulte con el administrador.");
		})
	}

	$scope.alerts = [];

	$scope.addAlert = function(tipo, mensaje) {
		$scope.alerts.push({
			type: tipo,
			msg : mensaje
		});
	};

	$scope.closeAlert = function(index) {
		$scope.alerts.splice(index, 1);
	};
})