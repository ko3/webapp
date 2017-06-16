//(function(){
	var app = angular.module('app');
	app.service("Dataservice",function($http){
		//var self=this;
		var _valueofe = 67;
		this.getvalueofe=function(){
			return _valueofe;
		};
		this.getdata = function(){
			
			var promise = $http({
		        method : 'GET',
		        url : '/eevar/kody/manager/employees',
		        headers:{'Content-Type':'application/json'}
		    }).then(function successCallback(response) {
		    	console.log(response);
		    	return response.data;
		    }, function errorCallback(response) {
		        console.log(response.statusText);
		    });
			
			return promise;
		};
		//return responsedata;
		

		/*$http.get('/eevar/kody/manager/employees').
	    then(function(response) {
	    	console.log("hello inside success");
	        $scope.greeting = response.data;
	    },function(error) {
	    	console.log("hello inside failure");
	    	console.log(error);});*/
		
		
	});
//})();