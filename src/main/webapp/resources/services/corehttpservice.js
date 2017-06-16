'use strict';
angular.module('app')
	.factory('coreHttpService',['$http','$state','$rootScope', 'globals', '$q',
		function($http, $state, $rootScope, globals, $q){
			
			return {
				invokeService: function (restUrl, methodType, args, hideProgress){
					var deferred = $q.defer();
					var _hideProgress = false;
					if(hideProgress){
						_hideProgress = hideProgress;
					}
					
					$http({method: MethodType, url: restUrl, data:args, headers:{'Content-Type':'application/json'}, hideProgress:_hideProgress}).
						sucess(function(data, status, headers, config){
							deferred.resolve(data);
						}).error(function(data, status, headers, config){
							deferred.reject("An Error Occured While Loading");
						});
					return deferred.promise;
				}
			};
	}]);