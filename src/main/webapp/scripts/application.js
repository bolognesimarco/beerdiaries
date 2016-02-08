var bdapp = angular.module('beerdiariesApplication',[ 'ngRoute' , 'bdctrls']);

var bdctrls = angular.module('bdctrls',[]);

bdctrls.controller(
		'loginController',
		[
		 '$scope',
		 '$rootScope',
		 function loginController($scope, $rootScope){
			 $rootScope.logged=true;
		 }
		]
);
bdctrls.controller(
		'recipeController',
		[
		 '$scope',
         '$http',
         '$routeParams',
         function recipes($scope, $http, $routeParams) {
			 $http.get('http://localhost:8080/beerdiaries/api/recipe/get/'+$routeParams.recipeid)
             	.then(function(response) {
             		$scope.recipe = response.data;
                }
             );
		 } 
		]
);
bdctrls.controller(
		'recipesController',
		[
		 '$scope',
         '$http',
         function recipes($scope, $http) {
			 $http.get('http://localhost:8080/beerdiaries/api/recipe/all')
             	.then(function(response) {
             		$scope.recipes = response.data;
                }
             );
		 } 
		]
);
bdctrls.controller(
		'logoutController',
		[
		 '$scope',
		 '$rootScope',
		 function logoutController($scope, $rootScope){
			 $rootScope.logged=false;
		 }
		]
);

bdapp.config(
		[
		 '$routeProvider', 
		 function($routeProvider) {
			$routeProvider
			.when('/reg', {
				templateUrl : 'views/registration.html',
				controller : 'loginController'
			})
			.when('/recipes', {
				templateUrl : 'views/recipes.html',
				controller : 'recipesController'
			})
			.when('/diary', {
				templateUrl : 'views/diary.html',
				controller : 'loginController'
			})
			.when('/login', {
					templateUrl : 'views/loggedin.html',
					controller : 'loginController'
				})
			.when('/logout', {
					templateUrl : 'views/guest.html',
					controller : 'logoutController'
				})
			.when('/recipe/:recipeid', {
					templateUrl : 'views/recipeDetail.html',
					controller : 'recipeController'
				})
			.otherwise({
					redirectTo : 'views/guest.html',
					controller : 'loginController'
				});
		 }
		]
);