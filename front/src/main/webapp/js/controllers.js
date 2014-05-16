sampleApp.controller('NewsController', function($scope,$http) {
     
	$scope.newsa = null;
	$scope.newsb = null;	
	$scope.newsc = null;

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
});