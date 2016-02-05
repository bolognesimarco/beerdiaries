var beerApp = angular.module('beerdiaries', [ 'ngRoute' , 'beerControllers']);



beerApp.factory("HomeService", function() {
	var logged=false;
	
	return {
	    logout: function() {
	    	alert('loggin OUT....');
	    	logged=false;
	    },
	    login: function() {
	    	alert('loggin IN....');
	    	logged=true;
	    },
	    isLogged: function(){
	    	alert('logged?'+logged);
	    	return logged;
	    }
	};
});

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
					templateUrl : 'views/guest.html',
					controller : 'logoutController'
				})
			.otherwise({
					redirectTo : 'guest.html',
					controller : 'homeController'
				});
		 }
		]
);