var beerApp = angular.module('beerdiaries', [ 'ngRoute' , 'beerControllers']);

beerApp.config(
		[
		 '$routeProvider', 
		 function($routeProvider) {
			$routeProvider
			.when('/login', {
					templateUrl : 'views/loggedin.html',
					controller : 'loginController'
				})
			.when('/logout', {
					templateUrl : 'views/logout.html',
					controller : 'logoutController'
				})
			.otherwise({
					redirectTo : 'home.html',
					controller : 'homeController'
				});
		 }
		]
);


var beerControllers = angular.module('beerControllers',[]);

beerControllers.controller(
		'homeController',
		[
		 '$scope', 
		 '$http', 
		 function home($scope, $http){
			 alert('homeController');
		 }
		]
);

beerControllers.controller(
		'loginController',
		[
		 '$scope', 
		 '$http', 
		 '$location',
		 function logged($scope, $http, $location){
			 $scope.switcher="2";
		 }
		]
);


beerControllers.controller(
		'logoutController',
		[
		 '$scope', 
		 '$http', 
		 '$location',
		 function logged($scope, $http, $location){
			 alert('logoutController');
		 }
		]
);





var app = angular.module('beer', [ 'ngRoute' ]);

var recipesControllers = angular.module('recipesControllers', []);

app.controller('recL', [
		'$scope',
		'$http',
		function recipes($scope, $http) {
			$http.get('http://localhost:8080/beerdiaries/api/recipe/all')
					.success(function(data) {
						$scope.recipes = data;
					});
		} ]);

app.controller('recI', [ 
        '$scope', 
        '$routeParams',
        '$http',
		function recipes($scope, $routeParams, $http) {
        	$http.get('http://localhost:8080/beerdiaries/api/recipe/get/'+$routeParams.id)
			.success(function(data) {
				$scope.recipe = data;
			});
		} ]);

app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/recL', {
		templateUrl : 'views/recL.html',
		controller : 'recL'
	}).when('/recI/:id', {
		templateUrl : 'views/recI.html',
		controller : 'recI'
	}).otherwise({
		redirectTo : '/recL'
	});
} ]);