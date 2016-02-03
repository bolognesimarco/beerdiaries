var app=angular.module('beer',[]).controller('recipes', function recipes($scope, $http) {
    $http.get('http://localhost:8080/beerdiaries/api/recipe/all').
        success(function(data) {
            $scope.recipes = data;
        });
});