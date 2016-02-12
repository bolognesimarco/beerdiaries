var bdapp = angular.module('beerdiariesApplication', [ 'ngRoute', 'bdctrls' ]);

var bdctrls = angular.module('bdctrls', []);

bdctrls.controller('diaryController', [ '$scope', '$rootScope',
		function diaryController($scope, $rootScope) {
		} ]);
bdctrls.controller('registrationController', [
		'$scope',
		'$rootScope',
		'$http',
		'$location',
		function registrationController($scope, $rootScope, $http, $location) {

			$scope.metodoDelController = function() {
				var res = $http.post(
						'http://localhost:8080/beerdiaries/api/recipe/regUser',
						$scope.user);
				res.success(function(data, status, headers, config) {
						$location.path("/loggedin");
						$scope.$apply();
					}
				);
				
				res.error(function(data, status, headers, config) {
						alert(JSON.stringify({data: data}));
					}
				);
				alert($scope.user.username);
			};

			$scope.message = "";

			$scope.user = {
				username : "",
				password : "",
				password_c : "",
				email : "",
				name : ""
			};
		} ]);
bdctrls.controller('loggedinController', [ '$scope', '$rootScope',
		function loggedinController($scope, $rootScope) {
			$rootScope.logged = true;
		} ]);
bdctrls.controller('loginController', [ '$scope', '$rootScope',
		function loginController($scope, $rootScope) {
		} ]);
bdctrls.controller('recipeController', [
		'$scope',
		'$http',
		'$routeParams',
		function recipeController($scope, $http, $routeParams) {
			$http.get(
					'http://localhost:8080/beerdiaries/api/recipe/get/'
							+ $routeParams.recipeid).then(function(response) {
				$scope.recipe = response.data;
			});
		} ]);
bdctrls.controller('recipesController', [
		'$scope',
		'$http',
		function recipesController($scope, $http) {
			$http.get('http://localhost:8080/beerdiaries/api/recipe/all').then(
					function(response) {
						$scope.recipes = response.data;
					});
		} ]);
bdctrls.controller('logoutController', [ '$scope', '$rootScope',
		function logoutController($scope, $rootScope) {
			$rootScope.logged = false;
		} ]);

bdapp.config([ '$routeProvider', function($routeProvider) {
	$routeProvider.when('/reg', {
		templateUrl : 'views/registration.html',
		controller : 'registrationController'
	}).when('/recipes', {
		templateUrl : 'views/recipes.html',
		controller : 'recipesController'
	}).when('/diary', {
		templateUrl : 'views/diary.html',
		controller : 'diaryController'
	}).when('/login', {
		templateUrl : 'views/login.html',
		controller : 'loginController'
	}).when('/loggedin', {
		templateUrl : 'views/loggedin.html',
		controller : 'loggedinController'
	}).when('/logout', {
		templateUrl : 'views/guest.html',
		controller : 'logoutController'
	}).when('/recipe/:recipeid', {
		templateUrl : 'views/recipeDetail.html',
		controller : 'recipeController'
	}).otherwise({
		redirectTo : 'views/guest.html',
		controller : 'logoutController'
	});
} ]);

bdapp.directive('validPasswordC', function() {
	return {
		require : 'ngModel',
		link : function(scope, elm, attrs, ctrl) {
			ctrl.$parsers.unshift(function(viewValue, $scope) {
				var noMatch = viewValue != scope.regForm.password.$viewValue
				ctrl.$setValidity('noMatch', !noMatch)
			})
		}
	}
})