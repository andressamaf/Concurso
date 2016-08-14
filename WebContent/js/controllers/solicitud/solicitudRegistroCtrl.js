var app = angular.module("SRD")
app.controller("SolicitudCtrl", function($scope, $rootScope, SolicitudSrv, $filter, 
		$timeout, ProvinciaSrv, CiudadSrv){
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
	$scope.ciudad = {
		ciudad_id: 0,
		ciudad_nombre: "",
		provincia_id: 0
	}
	$scope.provincia = {
		provincia_id: 1,
		provincia_nombre: ""
	}
	$scope.listarCiudad = function(){
		CiudadSrv.listar($scope.provincia.provincia_id, function(data){
			$scope.ciudades = data
		}, function(){
			console.log("error")
		})
		
	}
	$scope.listarProvincia = function(){
		ProvinciaSrv.listar(function(data){
			$scope.provincias = data
		}
		,function(){
			console.log("error")
		})
	}
	$scope.provincias=listarProvincia();
	$scope.ciudades=listarCiudad();	
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

	$scope.registrar = function() {
		$scope.solicitud.sol_fechaNac = $filter('date')($scope.solicitud.sol_fechaNac, "yyyy-MM-dd")
		$scope.solicitud.sol_fecha = $filter('date')($scope.solicitud.sol_fecha, "yyyy-MM-dd")
		$scope.solicitud.sol_estado = "S"
		//$scope.solicitud.sol_usr = $rootScope.usuario.usrCi
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
	var existe = function() {
		SolicitudSrv.existe($scope.solicitud.sol_ci, function(response) {
			if (response)
				return true
			else
				return false
		}, function(msgError) {
			console.log("error")
		})
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