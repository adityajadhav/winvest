'use strict';

// Declare app level module which depends on views, and components
var myApp = angular.module('myApp', [ 'ngRoute' ]);

myApp.config(function($routeProvider) {
	$routeProvider.when('/', {
		templateUrl : './home.html',
		controller : 'HomeCtrl'
	});
	console.log("Here");
});

/*
 * .controller('NavigationCtrl', ['$scope', '$rootScope', '$http', '$location',
 * function($scope, $rootScope, $http, $location) { var self = this
 * 
 * $rootScope.selectedTab = $location.path() || '/';
 * 
 * if ($rootScope.authenticated) { $location.path('/'); $rootScope.selectedTab =
 * '/'; return; }
 * 
 * }]);
 */