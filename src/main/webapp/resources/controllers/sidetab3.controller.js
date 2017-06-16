
var app = angular.module('app');
app.controller('sidetab3',['$scope','Dataservice', function($scope,Dataservice){
	$scope.e=40;
	Dataservice.getdata().then(function(data){
		$scope.greeting = data;
	});
	console.log("hello");
	/*$http.get('/eevar/kody/manager/employees').
    then(function(response) {
    	console.log("hello inside success");
        $scope.greeting = response.data;
    },function(error) {
    	console.log("hello inside failure");
    	console.log(error);});*/
	
	$scope.f=Dataservice.getvalueofe();
}]);
