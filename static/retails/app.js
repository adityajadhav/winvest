'use strict';

// Declare app level module which depends on views, and components
var myApp = angular.module('retail', [ 'ngResource' ])

myApp.controller('HomeCtrl', [
		'$scope',
		'$resource',
		'$http',
		function($scope, $resource,$http) {

			$scope.amount = 0.0
			$scope.title = 'Chipotle Mexican Grill';
			$scope.subTitle = 'Billing System';

			$scope.pay = function() {
				/*console.log("Paying " + $scope.amount);
				var Transaction = $resource('/api/transaction/pay/'
						+ $scope.amount);
				Transaction.get();
				*/
				
				$http.put('/api/transaction/update', {
					amount : $scope.amount
				}, null)
				   .then(
				       function(response){
				         // success callback
				       }, 
				       function(response){
				         // failure callback
				       }
				    );
				
				
				
				
			}

		}

]);
