//var myApp = angular.module('myApp', []);

myApp.controller('HomeCtrl', [
		'$scope',
		'$resource',
		function($scope, $resource) {

			/*$scope.wishlist = [ {
				name : ""
			} ];*/

			$scope.title = 'Winvest!';
			$scope.subTitle = 'Next Generation Banking Portal';

			$scope.labels = [ "Download Sales", "In-Store Sales",
					"Mail-Order Sales" ];
			$scope.data = [ 300, 500, 100 ];

			setInterval(function() {
				
				var User = $resource('/api/user');
				var user = User.query(function() {
					$scope.wishlist = user[0].wishlist;
				});

			}, 5000)

		}

]);