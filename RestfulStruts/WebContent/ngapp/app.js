var app = angular.module('myApp', []);
app.controller('GetController', function ($scope, $http) {

     var url="/rest/v1/status";
        
    
        $http.get(url).success(function(response){
        $scope.students=response;	
        	
        });
   

 });