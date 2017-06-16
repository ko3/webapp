angular.module('app')
	.factory('httpservice',['corehttpservice', function(corehttpservice){
		var serviceItems = {};
		var baseUrl = "/Consol/controller/";
		var message={};
		/*serviceItems.getAllEmployees = function(request){
			var restUrl = baseUrl+'manager/employees';
			var method = 'POST';
			return corehttpservice.invokeService(restUrl, method, request);
		};*/
		
		$http.get('/manager/employees').
		success(function(data, status, headers, config) {
			message = data;
		}).error(function(data, status, headers, config) {
			message = "error";
		});
		
		return message;
		
		/*var res = $http.post('/manager/employees', dataObj);
		res.success(function(data, status, headers, config) {
			$scope.message = data;
		});
		res.error(function(data, status, headers, config) {
			alert( "failure message: " + JSON.stringify({data: data}));
		});*/	
	}]);