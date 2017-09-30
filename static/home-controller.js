var myApp = angular.module('myApp', []);

myApp.controller('HomeCtrl', [ '$scope', function($scope) {
	$scope.greeting = 'Hola!';
} ]);