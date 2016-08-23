var app = angular.module("SRD");

app.controller('MainController', function($scope, $route, $routeParams,
		$location) {
	$scope.$route = $route;
	$scope.$location = $location;
	$scope.$routeParams = $routeParams;
	$scope.daltonismo="";
});

app.config(function($routeProvider) {
	$routeProvider
	.when('/home', {
		templateUrl : 'vistas/home.html',
		controller : 'HomeCtrl'
	})
	.when('/consulta', {
		templateUrl : 'vistas/consultaInformacion.html',
		controller : 'ConsultaCtrl'
	})
	.when('/aprobacion', {
		templateUrl : 'vistas/aprobacionSolicitud.html',
		controller : 'AprobacionCtrl'
	})
	.when('/reporte', {
		templateUrl : 'vistas/reportesSolicitud.html',
		controller : 'ReporteCtrl'
	})
	.when('/registroReporte', {
		templateUrl : 'vistas/solicitudRegistro.html',
		controller : 'SolicitudCtrl'
	})
	.when('/usuario/administrar', {
		templateUrl : 'vistas/usuario/administrar.html',
		controller : 'UsuarioAdministrarCtrl'
	})
	.when('/usuario/home', {
		templateUrl : 'vistas/usuario/home.html',
		controller : 'HomeUsrCtrl'
	})
	.when('/usuario/crear', {
		templateUrl : 'vistas/usuario/crear.html',
		controller : 'UsuarioCrearCtrl'
	})
	.when('/usuario/modificar/:ci', {
		templateUrl : 'vistas/usuario/modificar.html',
		controller : 'UsuarioModificarCtrl'
	})
	.when('/usuario/ver/:ci', {
		templateUrl : 'vistas/usuario/ver.html',
		controller : 'UsuarioInfoCtrl'
	})
	.otherwise({
		templateUrl : 'vistas/loggin.html',
		controller: "loggin"
	});
});
