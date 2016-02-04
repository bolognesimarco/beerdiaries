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