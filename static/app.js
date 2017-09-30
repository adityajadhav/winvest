'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute'
]).

config(['$locationProvider', '$routeProvider', "$httpProvider", function($locationProvider, $routeProvider, $httpProvider) {
  $routeProvider.otherwise({redirectTo: '/'});
}])

.controller('NavigationCtrl', ['$scope', '$rootScope', '$http', '$location',
  function($scope, $rootScope, $http, $location) {
  var self = this

  $rootScope.selectedTab = $location.path() || '/';

  if ($rootScope.authenticated) {
    $location.path('/');
    $rootScope.selectedTab = '/';
    return;
  }
  
}]);