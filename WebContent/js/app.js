var app = angular.module("SRD",[]);
app.run(function($rootScope) {
	$rootScope.daltonismo="bootstrap.min.css"
});
app.controller("newUserCtrl", function($scope){
	$scope.usuario = {
			nombre: "",
			contrasenia: "",
			ci: "",
			fechaNac: "",
			direccion: "",
			rol: ""
	}
	$scope.contrasenia2="";
	$scope.validar = function(){
		  var array = $scope.usuario.ci.split( "" );
		  var num = array.length;
		  if ( num == 10 )
		  {
		    var total = 0;
		    var digito = (array[9]*1);
		    for(var i=0; i < (num-1); i++ )
		    {
		      var mult = 0;
		      if ( ( i%2 ) != 0 ) {
		        total = total + ( array[i] * 1 );
		      }
		      else
		      {
		        mult = array[i] * 2;
		        if ( mult > 9 )
		          total = total + ( mult - 9 );
		        else
		          total = total + mult;
		      }
		    }
		    var decena = total / 10;
		    decena = Math.floor( decena );
		    decena = ( decena + 1 ) * 10;
		    final = ( decena - total );
		    if ( ( final == 10 && digito == 0 ) || ( final == digito ) ) {
		      
		      return true;
		    }
		    else
		    {
		      
		      return false;
		    }
		  }
		  else
		  {
		    return false;
		  }
	}
});