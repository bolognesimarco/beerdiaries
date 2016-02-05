var beerControllers = angular.module('beerControllers',[]);


beerControllers.controller(
		'homeController',
		[
		 '$scope',
		 'HomeService',
		 function home($scope, HomeService){
			 $scope.logged=HomeService.isLogged();
		 }
		]
);

beerControllers.controller(
		'loginController',
		[
		 '$scope',
		 'HomeService',
		 function logged($scope, HomeService){
			 HomeService.login();
			 $scope.switcher="3";
		 }
		]
);


beerControllers.controller(
		'logoutController',
		[
		 '$scope', 
		 'HomeService',
		 function logged($scope, HomeService){
			 HomeService.logout();
		 }
		]
);

beerControllers.controller(
		'recipes', 
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
