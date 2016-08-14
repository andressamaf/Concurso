var app = angular.module("SRD")
app.controller("ReporteCtrl", function($scope, SolicitudSrv, $filter, $timeout) {
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
	$scope.generar = function() {
		$scope.fecha.inicio = $filter('date')($scope.fecha.inicio, "yyyy-MM-dd")
		$scope.fecha.fin = $filter('date')($scope.fecha.fin, "yyyy-MM-dd")
		console.log("fechas: " + $scope.fecha.inicio + "   "+ $scope.fecha.fin)
		SolicitudSrv.reporte($scope.fecha, function(data) {
			$scope.reportes = data;
			$scope.addAlert("success", "Éxito! al generar el PDF.");
			$timeout(function() {
				html2canvas(document.getElementById("exportthis"), {
					onrendered: function(canvas){
						var img = canvas.toDataURL("image/png")
						var doc = new jsPDF();
						doc.addImage(img, 'JPEG',20,20)
						doc.save("reporte.pdf")
					}
				})
			}, 3000
			
			);
				
		}, function(){
			$scope.addAlert("danger", "Error! al generar el PDF.");
		})
	}
})