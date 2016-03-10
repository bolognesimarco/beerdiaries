var bdapp = angular.module('beerdiariesApplication', [ 'ngRoute', 'bdctrls',
		'ngCookies' ]);

var bdctrls = angular.module('bdctrls', []);

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

bdctrls.controller('LoginController', function($scope, $rootScope, $http, AuthService, $location) {

			$scope.login = function(credentials) {
				alert("login");
				AuthService.login(credentials)
				.then(
						function(res){alert("res.data.username");},
						function(){alert("res");}
				);
			};

			$scope.credentials = {
				username : "",
				password : ""
			};
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

bdapp.constant('USER_ROLES', {
	all : '*',
	admin : 'admin',
	brewer : 'brewer',
	guest : 'guest'
});

bdapp.factory('AuthService', function($http) {
	var authService = {};

	authService.login = function(credentials) {
		alert('authService.login');
		$http.post('api/recipe/login',
				credentials).then(function(res) {
			alert(res.data);
			return res.data;
		});

	};

	authService.logout = function() {
		// Session.destroy();
	};

	authService.isAuthenticated = function(cookieStore) {
		// return !!Session.userId;
	};

	authService.isAuthorized = function(authorizedRoles) {
		if (!angular.isArray(authorizedRoles)) {
			authorizedRoles = [ authorizedRoles ];
		}
		return (authService.isAuthenticated() && authorizedRoles
				.indexOf(Session.userRole) !== -1);
	};

	authService.boop = function() {
		return "hello";
	};

	return authService;
});
