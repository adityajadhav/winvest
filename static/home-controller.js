var myApp = angular.module('myApp', []);

myApp.controller('HomeCtrl', [ '$scope', function($scope) {
	$scope.title = 'WInvest!';
	$scope.subTitle = 'Next Generation Banking Portal';
} ]);