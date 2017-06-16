var app = angular.module('app',['ui.router']);

app.config(['$stateProvider', function($stateProvider){
	$stateProvider
	.state('firstSidetab', {
		url:'/first-sidetab',
		templateUrl:'resources/messages/firstmessage.htm',
		controller:'sidetab1'
	})
	.state('secondSidetab', {
		url:'/second-sidetab',
		templateUrl:'resources/messages/secondmessage.htm',
		controller:'sidetab2'
	})
	.state('thirdSidetab', {
		url:'/third-sidetab',
		templateUrl:'resources/messages/thirdmessage.htm',
		controller:'sidetab3'
	})
	.state('root', {
		url:'/',
		template:'<strong> Select any of the side tabs</strong>'
	})
	.state('noroute', {
		url:'*path',
		template:'<strong>404 forbidden</strong>'
	})
}]);






