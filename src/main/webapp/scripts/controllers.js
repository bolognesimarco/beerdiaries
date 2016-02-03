var app = angular.module('beer', [ 'recipesControllers', 'ngRoute' ]);

var recipesControllers = angular.module('recipesControllers', []);

recipesControllers.controller('recL', [
		'$scope',
		'$http',
		function recipes($scope, $http) {
			$http.get('http://localhost:8080/beerdiaries/api/recipe/all')
					.success(function(data) {
						$scope.recipes = data;
					});
		} ]);

recipesControllers.controller('recI', [ '$scope', '$routeParams',
		function recipes($scope, $routeParams) {
			$scope.recipe = $routeParams.recipe;
		} ]);

app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/recipes', {
		templateUrl : 'views/recL.html',
		controller : 'recL'
	}).when('/recipes/:recipe', {
		templateUrl : 'views/recI.html',
		controller : 'recI'
	}).otherwise({
		redirectTo : '/recipes'
	});
} ]);