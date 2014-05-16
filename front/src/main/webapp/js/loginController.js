sampleApp.controller('loginController', function($scope,$http,$window) {
       
    $scope.formData = {};
    $scope.error=""
    $scope.load="off"
    $scope.login = function() {
      $scope.load="on"
      $http({
        method  : 'POST',
        url     : '/api/v1/users',
        data    : $.param($scope.formData),
        headers : { 'Content-Type': 'application/x-www-form-urlencoded'},
        tracker : $scope.loadingTracker
      })
      .success(function(data, status, headers, config) {
        $window.location.href = '/news.html';
      })
      .error(function (data) {
        //data = JSON.parse(data)
        $scope.error = "Usuario o contraseña incorrectos"
        //TODO: Mandar mensajes de error.
      });
    };
  
});