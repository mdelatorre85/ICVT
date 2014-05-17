sampleApp.controller('NewsController', function($scope,$http) {
  var meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
  $scope.formData = {};
	$scope.newsa = null;
	$scope.newsb = null;	
	$scope.newsc = null;
  $scope.newsresult = null;
  $scope.resultText = "";

	$http({
        method  : 'POST',
        url     : '/api/v1/rest/noticias/agrupadas',
        data    :  "",
        headers : { 'Content-Type': 'application/x-www-form-urlencoded'},
        tracker : $scope.loadingTracker
      })
      .success(function(data, status, headers, config) {
      		datea = data.noticias[0].fecha.split('-')
      		$scope.newsaDay = datea[2]
      		$scope.newsaMonth = datea[1]
      		$scope.newsaYear = datea[0]
        	$scope.newsa = data.noticias[0].noticias;
        	$scope.newsb = data.noticias[1].noticias;
        	$scope.newsc = data.noticias[2].noticias;
      });
  $scope.filter = function() {
    
    $scope.formData.fechaInicio = "2014-05-16";
    $scope.formData.fechaFin    = "2014-05-17";

    var dateInit  = $scope.formData.fechaInicio.split("-");
    var dateFin   = $scope.formData.fechaFin.split("-");
    var etiquetas = false;

    $http({
      method  : 'POST',
      url     : '/api/v1/rest/noticias/agrupadas',
      data    : $.param($scope.formData),
      headers : { 'Content-Type': 'application/x-www-form-urlencoded'},
      tracker : $scope.loadingTracker
    })
    .success(function(data, status, headers, config) {

      if ( $scope.formData.fechaInicio != "" &&  $scope.formData.fechaFin != "" ){
        $scope.newsresult = data.noticias[0].noticias;
        $scope.resultText = "Estos son los resultados de noticias:"; 
        $scope.resultText += " del <span class='date'>"+dateInit[2] +" de "+ meses[dateInit[1]-1];
        $scope.resultText += "</span> al <span class='date'>"+ dateFin[2]; 
        $scope.resultText += " de "+ meses[dateFin[1]-1]+"</span> del <span class='date'>"+dateFin[0] +"</span>"
      }
      
      if (  $scope.formData.tagGeneral  || $scope.formData.tagFinanzas      || 
            $scope.formData.tagComercio || $scope.formData.tagExportaciones || 
            $scope.formData.tagImportaciones ) {
        etiquetas = true;
      }
           
      if(etiquetas) {
        $scope.resultText += " y de las categorías:"
        if ($scope.formData.tagGeneral) {
          $scope.resultText += "<span class='tag-cat-line blue'>General</span>";
        }
        if ($scope.formData.tagFinanzas) {
          $scope.resultText += "<span class='tag-cat-line green'>Finanzas</span>";
        }
        if ($scope.formData.tagComercio) {
          $scope.resultText += "<span class='tag-cat-line orange'>Comercio</span>";
        }
        if ($scope.formData.tagExportaciones) {
          $scope.resultText += "<span class='tag-cat-line pink'>Exportaciones</span>";
        }
        if ($scope.formData.tagImportaciones) {
          $scope.resultText += "<span class='tag-cat-line lime-dark'>Importaciones</span>";
        }  
      }
    })
    .error(function (data) {
      $scope.load="off"
      $scope.error = "Usuario o contraseña incorrectos"
      //TODO: Mandar mensajes de error.
    });  
  };
  


});