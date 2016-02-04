var app = angular.module('beer', ['ngRoute' ]);

var recipesControllers = angular.module('recipesControllers', []);

app.controller('recL', [
		'$scope',
		'$http',
		function recipes($scope, $http) {
			//$scope.recipes="RICETTE"
			$http.get('http://localhost:8080/beerdiaries/api/recipe/all')
					.success(function(data) {
						$scope.recipes = data;
					});
		} ]);



app.controller('recI', [ '$scope', '$routeParams',
		function recipes($scope, $routeParams) {
			//$scope.mess="MESS"
		$scope.recipe = $routeParams.recipe;
		} ]);



app.config([ '$routeProvider', function($routeProvider) {
	$routeProvider
	.when('/recL', {
		templateUrl : 'views/recL.html',
		controller : 'recL'
	})
	.when('/recI', {
		templateUrl : 'views/recI.html',
		controller : 'recI'
	})
	.otherwise({
		redirectTo : '/recL'
	});
} ]);