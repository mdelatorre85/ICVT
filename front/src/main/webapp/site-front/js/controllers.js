// pick-a-date (attribute)
angular.module('ng').directive('pickADate', function () {
    return {
        restrict: "A",
        scope: {
            pickADate: '=',
            minDate: '=',
            maxDate: '='
        },
        link: function (scope, element, attrs) {
            element.pickadate({
                onSet: function (e) {
                    if (scope.$$phase || scope.$root.$$phase) // we are coming from $watch or link setup
                        return;
                    var select = element.pickadate('picker').get('select'); // selected date
                    scope.$apply(function () {
                        if (e.hasOwnProperty('clear')) {
                            scope.pickADate = null;
                            return;
                        }
                        if (!scope.pickADate)
                            scope.pickADate = new Date(0);
                        scope.pickADate.setYear(select.obj.getFullYear());
                        // Interesting: getYear returns only since 1900. Use getFullYear instead.
            // It took me half a day to figure that our. Ironically setYear()
            // (not setFullYear, duh) accepts the actual year A.D.
                        // So as I got the $#%^ 114 and set it, guess what, I was transported to ancient Rome 114 A.D.
                        // That's it I'm done being a programmer, I'd rather go serve Emperor Trajan as a sex slave.
                        scope.pickADate.setMonth(select.obj.getMonth());
                        scope.pickADate.setDate(select.obj.getDate());
                    });
                },
                onClose: function () {
                    element.blur();
                }
            });
            function updateValue(newValue) {
                if (newValue) {
                    scope.pickADate = (newValue instanceof Date) ? newValue : new Date(newValue);
                    // needs to be in milliseconds
                    element.pickadate('picker').set('select', scope.pickADate.getTime());
                } else {
                    element.pickadate('picker').clear();
                    scope.pickADate = null;
                }
            }
            updateValue(scope.pickADate);
            element.pickadate('picker').set('min', scope.minDate ? scope.minDate : false);
            element.pickadate('picker').set('max', scope.maxDate ? scope.maxDate : false);
            scope.$watch('pickADate', function (newValue, oldValue) {
                if (newValue == oldValue)
                    return;
                updateValue(newValue);
            }, true);
            scope.$watch('minDate', function (newValue, oldValue) {
                element.pickadate('picker').set('min', newValue ? newValue : false);
            }, true);
            scope.$watch('maxDate', function (newValue, oldValue) {
                element.pickadate('picker').set('max', newValue ? newValue : false);
            }, true);
        }
    };
});

// pick-a-time (attribute)
angular.module('ng').directive('pickATime', function () {
    return {
        restrict: "A",
        scope: {
            pickATime: '='
        },
        link: function (scope, element, attrs) {
            element.pickatime({
                onSet: function (e) {
                    if (scope.$$phase || scope.$root.$$phase) // we are coming from $watch or link setup
                        return;
                    var select = element.pickatime('picker').get('select'); // selected date
                    scope.$apply(function () {
                        if (e.hasOwnProperty('clear')) {
                            scope.pickATime = null;
                            return;
                        }
                        if (!scope.pickATime)
                            scope.pickATime = new Date(0);
                        // (attrs.setUtc)
                            // ? scope.pickATime.setUTCHours(select.hour)
                            // : scope.pickATime.setHours(select.hour);
                        scope.pickATime.setHours(select.hour);
                        scope.pickATime.setMinutes(select.mins);
                        scope.pickATime.setSeconds(0);
                        scope.pickATime.setMilliseconds(0);
                    });
                },
                onClose: function () {
                    element.blur();
                }
            });
            function updateValue(newValue) {
                if (newValue) {
                    scope.pickATime = (newValue instanceof Date) ? newValue : new Date(newValue);
                    // needs to be in minutes
                    var totalMins = scope.pickATime.getHours() * 60 + scope.pickATime.getMinutes();
                    element.pickatime('picker').set('select', totalMins);
                } else {
                    element.pickatime('picker').clear();
                    scope.pickATime = null;
                }
            }
            updateValue(scope.pickATime);
            scope.$watch('pickATime', function (newValue, oldValue) {
                if (newValue == oldValue)
                    return;
                updateValue(newValue);
            }, true);
        }
    };
});

sampleApp.controller('NewsController', function($scope,$http,dateFilter) {
  
  var meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"];
  $scope.tags = [{id:1,value:"general",color:"blue"},{id:2,value:"finanzas",color:"green"},{id:3,value:"comercio",color:"orange"},{id:4,value:"exportaciones",color:"pink"},{id:5,value:"importaciones",color:"lime-dark"}];
  $scope.formData = {};
  $scope.formData.tagsc = {};
	$scope.newsa = null;
	$scope.newsb = null;	
	$scope.newsc = null;
  $scope.newsresult = null;
  $scope.resultText = "";
  $scope.formData.tagGeneral = 1;
  $scope.noticiaVisible = true;
  $scope.panelVisible = false;
  $scope.urlNoticia="";

	$http({
    method  : 'POST',
    url     : '/api/v1/rest/noticias/agrupadas',
    data    :  "",
    headers : { 'Content-Type': 'application/x-www-form-urlencoded'},
    tracker : $scope.loadingTracker
  })
  .success(function(data, status, headers, config) {
    
    datea             = data.noticias[0].fecha.split('-')
    dateb             = data.noticias[1].fecha.split('-')
    $scope.newsaDay   = datea[2]
		$scope.newsaMonth = meses[datea[1]-1]
		$scope.newsaYear  = datea[0]
    $scope.newsbDay   = dateb[2]
    $scope.newsbMonth = meses[dateb[1]-1]
    $scope.newsbYear  = dateb[0]
  	$scope.newsa      = data.noticias[0].noticias;
  	$scope.newsb      = data.noticias[1].noticias;
  	$scope.newsc      = data.noticias[2].noticias;
  
  });

  $scope.filter = function() {

    var tags       = ""
    var fechaInicio= ""
    var fechaFin   = ""
    var filterDate = false;
    var filterTags = false;
    var dateInit   = null;
    var dateFin    = null;

    for(key in $scope.formData.tagsc) {
      tags += key+",";
    }

    if (tags.length > 0) {
      filterTags = true;
      tags = tags.substr(0,tags.length-1)
    }

    filterDate = $scope.fechaInicio != null && $scope.fechaFin != null;
  
    if (filterDate) {
       fechaInicio = dateFilter($scope.fechaInicio, 'yyyy-MM-dd');
       fechaFin    = dateFilter($scope.fechaFin, 'yyyy-MM-dd');
       dateInit    = fechaInicio.split("-");
       dateFin     = fechaFin.split("-");
    }

    $http({
      method  : 'POST',
      url     : '/api/v1/rest/noticias/agrupadas',
      data    : "fechaInicio="+fechaInicio+"&fechaFin="+fechaFin+"&etiquetas="+tags,
      headers : { 'Content-Type': 'application/x-www-form-urlencoded'},
      tracker : $scope.loadingTracker
    })
    .success(function(data, status, headers, config) {
      
      var existNews = data.noticias[0].noticias.length > 0 
      $scope.newsresult = data.noticias[0].noticias;

      if (!existNews) {
        $scope.resultText = "No se encontraron resultados: " 
      }else{
        $scope.resultText = "Estos son los resultados de noticias:"; 
      }

      if (filterDate) {
        $scope.resultText += " del <span class='date'>"+dateInit[2] +" de "+ meses[dateInit[1]-1];
        $scope.resultText += "</span> al <span class='date'>"+ dateFin[2]; 
        $scope.resultText += " de "+ meses[dateFin[1]-1]+"</span> del <span class='date'>"+dateFin[0] +"</span>"
      }
      
      if(filterTags) {
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
        $('.js-filters-listing').toggle();  
      }

    })
    .error(function (data) {
      // $scope.load="off"
      // $scope.error = "Usuario o contraseña incorrectos"
      //TODO: Mandar mensajes de error.
    }); 


  };
  $scope.reset = function() {
      $scope.formData.tagsc = {};
      $scope.fechaInicio    = "";
      $scope.fechaFin       = "";
  }

  $scope.muestra = function ($url) {
    $scope.noticiaVisible = false;
    $scope.panelVisible   = true;
    $scope.urlNoticia = $url;
  }

  $scope.regresa = function() {
    $scope.urlNoticia = "";
    $scope.noticiaVisible = true;
    $scope.panelVisible   = false;
  };

});


sampleApp.controller('tweetsController', function($scope,$http,dateFilter) {
  
  $scope.tweets = null;
  $http({
    method  : 'POST',
    url     : '/api/v1/rest/tweets/retrieve',
    data    :  "",
    headers : { 'Content-Type': 'application/x-www-form-urlencoded'},
    tracker : $scope.loadingTracker
  })
  .success(function(data, status, headers, config) {
    $scope.tweets = data;      
  });

  $scope.filter = function() {

    var fechaInicio= ""
    var fechaFin   = ""
    var filterDate = false;
    var filterTags = false;
    var dateInit   = null;
    var dateFin    = null;

    filterDate = $scope.fechaInicio != null && $scope.fechaFin != null;
  
    if (filterDate) {
       fechaInicio = dateFilter($scope.fechaInicio, 'yyyy-MM-dd');
       fechaFin    = dateFilter($scope.fechaFin, 'yyyy-MM-dd');
       dateInit    = fechaInicio.split("-");
       dateFin     = fechaFin.split("-");
    }else{
      return false;
    }

    $http({
      method  : 'POST',
      url     : '/api/v1/rest/tweets/retrieve',
      data    : "fechaInicio="+fechaInicio+"&fechaFin="+fechaFin+"&etiquetas="+tags,
      headers : { 'Content-Type': 'application/x-www-form-urlencoded'},
      tracker : $scope.loadingTracker
    })
    .success(function(data, status, headers, config) {
      $scope.tweets = data;      
    })
    .error(function (data) {
      // $scope.load="off"
      // $scope.error = "Usuario o contraseña incorrectos"
      //TODO: Mandar mensajes de error.
    }); 


  };
 
  $scope.reset = function() {
      $scope.fechaInicio    = "";
      $scope.fechaFin       = "";
  }
});







