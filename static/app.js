'use strict';

// Declare app level module which depends on views, and components
var myApp = angular.module('different', [ 'ui.router' ]);

myApp.config(function($stateProvider, $locationProvider) {
	$stateProvider.state({
		name : 'home',
		url : '/',
		templateUrl : 'home.html',
		controller : 'HomeCtrl'
	});
	$locationProvider.html5Mode(true);
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