var bdapp = angular.module('beerdiariesApplication', [ 'ngRoute', 'bdctrls' ]);

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
	editor : 'editor',
	guest : 'guest'
});

bdctrls.controller('ApplicationController', [ '$scope', 'USER_ROLES',
		'AuthService',

		function($scope, USER_ROLES, AuthService) {
			$scope.currentUser = null;
			$scope.userRoles = USER_ROLES;
			$scope.isAuthorized = AuthService.isAuthorized;

			$scope.setCurrentUser = function(user) {
				$scope.currentUser = user;
			};
		} 
]);


bdapp.factory('AuthService', function($http, Session) {
	var authService = {};

	authService.login = function(credentials) {
		return $http.post('http://localhost:8080/beerdiaries/api/recipe/login', credentials)
			.then(function(res) {
				Session.create(res.data.id, res.data.username, res.data.password);
				return res.data.user;
			},function(response){alert(response.statusText)});
		
	};

	authService.isAuthenticated = function() {
		return !!Session.userId;
	};

	authService.isAuthorized = function(authorizedRoles) {
		if (!angular.isArray(authorizedRoles)) {
			authorizedRoles = [ authorizedRoles ];
		}
		return (authService.isAuthenticated() && authorizedRoles
				.indexOf(Session.userRole) !== -1);
	};

	return authService;
});

bdapp.service('Session', function() {
	this.create = function(sessionId, userId, userRole) {
		this.id = sessionId;
		this.userId = userId;
		this.userRole = userRole;
	};
	this.destroy = function() {
		this.id = null;
		this.userId = null;
		this.userRole = null;
	};
});

bdapp.run(function($rootScope, AUTH_EVENTS, AuthService) {
	$rootScope.$on('$routeChangeStart ', function(event, next) {
		var authorizedRoles = next.data.authorizedRoles;
		if (!AuthService.isAuthorized(authorizedRoles)) {
			event.preventDefault();
			if (AuthService.isAuthenticated()) {
				// user is not allowed
				$rootScope.$broadcast(AUTH_EVENTS.notAuthorized);
			} else {
				// user is not logged in
				$rootScope.$broadcast(AUTH_EVENTS.notAuthenticated);
			}
		}
	});
});

bdctrls.controller('diaryController', [ '$scope', '$rootScope',
		function diaryController($scope, $rootScope) {
		} 
]);

bdctrls.controller('LoginController', [ '$scope', '$rootScope', '$http',
		'$location', 'AuthService', 'AUTH_EVENTS',
		function LoginController($scope, $rootScope, $http, $location, AuthService, AUTH_EVENTS) {

			$scope.login = function(credentials) {
				AuthService.login(credentials).then(
						function(user) {
							$rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
							$scope.setCurrentUser(user);
							alert($location.path());
							$location.path("/loggedin");
						}, 
						function() {
							alert('5');
							$rootScope.$broadcast(AUTH_EVENTS.loginFailed);
						}
				);
			};

			$scope.credentials  = {
				username : "",
				password : ""
			}
		} 
]);



bdctrls.controller('registrationController', [
		'$scope',
		'$rootScope',
		'$http',
		'$location',
		function registrationController($scope, $rootScope, $http, $location) {

			$scope.metodoDelController = function() {
				alert('registration'+JSON.stringify($scope.brewer));
				var res = $http.post(
						'http://localhost:8080/beerdiaries/api/recipe/regUser',
						$scope.brewer);
				res.success(function(data, status, headers, config) {
					$location.path("/																									loggedin");
					$scope.$apply();
				});

				res.error(function(data, status, headers, config) {
					alert(JSON.stringify({
						data : data
					}));
				});
				alert($scope.brewer.username);
			};

			$scope.message = "";

			$scope.brewer = {
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

bdapp.config([ '$routeProvider', 'USER_ROLES',
		function($routeProvider, USER_ROLES) {
			$routeProvider.when('/reg', {
				templateUrl : 'views/registration.html',
				controller : 'registrationController',
				data : {
					authorizedRoles : [ USER_ROLES.all, USER_ROLES.all ]
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