var bdapp = angular.module('beerdiariesApplication', [ 'ngRoute', 'bdctrls',
		'ngCookies' ]);

var bdctrls = angular.module('bdctrls', []);
bdapp.constant('AUTH_EVENTS', {
	loginSuccess : 'auth-login-success',
	loginFailed : 'auth-login-failed',
	logoutSuccess : 'auth-logout-success',
	sessionTimeout : 'auth-session-timeout',
	notAuthenticated : 'auth-not-authenticated',
	notAuthorized : 'auth-not-authorized'
});
bdapp.constant('USER_ROLES', {
	all : '*',
	admin : 'admin',
	brewer : 'brewer',
	guest : 'guest'
});

bdctrls.controller('ApplicationController', [ '$scope',

function($scope) {
	alert('init ApplicationController');

	$scope.currentUser = $scope.getAllreadyAuthenticated;

	alert('dopo getauthenticated');

	$scope.setCurrentUser = function(user) {
		alert('setCurrentUser:' + user)
		$scope.currentUser = user;
	};

	$scope.getAllreadyAuthenticated = function() {
		alert('getAllreadyAuthenticated');
		return null;
	};
} ]);

bdapp.config([ '$routeProvider', 'USER_ROLES',
		function($routeProvider, USER_ROLES) {
			$routeProvider.when('/reg', {
				templateUrl : 'views/registration.html',
				controller : 'registrationController',
				data : {
					authorizedRoles : [ USER_ROLES.all ]
				}
			}).when('/recipes', {
				templateUrl : 'views/recipes.html',
				controller : 'recipesController',
				data : {
					authorizedRoles : [ USER_ROLES.all ]
				}
			}).when('/diary', {
				templateUrl : 'views/diary.html',
				controller : 'diaryController',
				data : {
					authorizedRoles : [ USER_ROLES.all ]
				}
			}).when('/login', {
				templateUrl : 'views/login.html',
				controller : 'LoginController',
				data : {
					authorizedRoles : [ USER_ROLES.all ]
				}
			}).when('/loggedin', {
				templateUrl : 'views/loggedin.html',
				controller : 'loggedinController',
				data : {
					authorizedRoles : [ USER_ROLES.all ]
				}
			}).when('/logout', {
				templateUrl : 'views/guest.html',
				controller : 'logoutController',
				data : {
					authorizedRoles : [ USER_ROLES.all ]
				}
			}).when('/recipe/:recipeid', {
				templateUrl : 'views/recipeDetail.html',
				controller : 'recipeController',
				data : {
					authorizedRoles : [ USER_ROLES.all ]
				}
			}).otherwise({
				redirectTo : 'views/guest.html',
				controller : 'logoutController',
				data : {
					authorizedRoles : [ USER_ROLES.all ]
				}
			});
		} ]);

bdctrls.controller('LoginController', [
		'$scope',
		'$rootScope',
		'$http',
		'$location',
		'AuthService',
		'AUTH_EVENTS',
		'$cookieStore',
		function LoginController($scope, $rootScope, $http, $location,
				AuthService, AUTH_EVENTS, $cookieStore) {

			$scope.login = function(credentials) {
				
				AuthService.boop().then(
						function(data){alert(data);},
						function(problem){alert(problem);}
				);
				
				
				
				
				//alert('LoginController.login');
				//AuthService.login(credentials)
				  //.then(function(res) {
					//alert('AuthService.login.then');
					//$rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
					//$scope.setCurrentUser(user);
					//$location.path("/loggedin");
					//$cookieStore.put('loggedinUser', JSON.stringify(user));
				  //}, function(res) {
					//alert('login failed');
					//$rootScope.$broadcast(AUTH_EVENTS.loginFailed);
				  //}
				 //);
				//alert('LoginController.login done');
			};

			$scope.credentials = {
				username : "",
				password : ""
			};
		} ]);

bdapp.factory('AuthService', function($http) {
	var authService = {};

	authService.login = function(credentials) {
		alert('authService.login');
		$http.post('http://localhost:8080/beerdiaries/api/recipe/login',
				credentials).then(function(res) {
			alert(res.data);
			return res.data;
		},function(res){alert('authService.login...http.post failed');return res;}
		);

	};

	authService.logout = function() {
		//Session.destroy();
	};

	authService.isAuthenticated = function(cookieStore) {
		//return !!Session.userId;
	};

	authService.isAuthorized = function(authorizedRoles) {
		if (!angular.isArray(authorizedRoles)) {
			authorizedRoles = [ authorizedRoles ];
		}
		return (authService.isAuthenticated() && authorizedRoles
				.indexOf(Session.userRole) !== -1);
	};
	
	authService.boop = function(){
		return "hello";
	};

	return authService;
});

bdctrls.controller('loggedinController', [ '$scope', '$rootScope',
		function loggedinController($scope, $rootScope) {
			alert('init loggedinController');
		} ]);