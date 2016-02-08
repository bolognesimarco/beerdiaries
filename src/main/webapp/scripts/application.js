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
		'recipesController',
		[
		 '$scope',
         '$http',
         function recipes($scope, $http) {
			 $http.get('http://localhost:8080/beerdiaries/api/recipe/all')
             	.success(function(data) {
             		$scope.recipes = data;
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
				controller : 'loginController',
				resolve: true
			})
			.when('/recipes', {
				templateUrl : 'views/recipes.html',
				controller : 'recipesController',
				resolve: true
			})
			.when('/diary', {
				templateUrl : 'views/diary.html',
				controller : 'loginController',
				resolve: true
			})
			.when('/login', {
					templateUrl : 'views/loggedin.html',
					controller : 'loginController',
					resolve: true
				})
			.when('/logout', {
					templateUrl : 'views/guest.html',
					controller : 'logoutController',
					resolve: false
				})
			.otherwise({
					redirectTo : 'views/guest.html',
					controller : 'loginController'
				});
		 }
		]
);