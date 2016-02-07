var bdapp = angular.module('beerdiariesApplication',[ 'ngRoute' , 'bdctrls']);

var bdctrls = angular.module('bdctrls',[]);

bdctrls.controller(
		'loginController',
		[
		 '$scope',
		 'logged',
		 function loginController($scope, loggedin){
			 $scope.logged=loggedin;
		 }
		]
);

bdapp.config(
		[
		 '$routeProvider', 
		 function($routeProvider) {
			$routeProvider
			.when('/login', {
					templateUrl : 'views/loggedin.html',
					controller : 'loginController',
					resolve: true
				})
			.when('/logout', {
					templateUrl : 'views/guest.html',
					controller : 'loginController',
					resolve: false
				})
			.otherwise({
					redirectTo : 'guest.html',
					controller : 'homeController'
				});
		 }
		]
);