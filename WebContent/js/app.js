var app = angular.module("SRD",['ngRoute','ui.bootstrap']);

app.run(function($rootScope) {
	$rootScope.usuario = {
			usrCi: "",
			usrClave: "",
			usrNombre: "",
			usrTelefono: "",
			usrCorreo: "",
			usrRol: "",
			estadousr: 0
	    };
});