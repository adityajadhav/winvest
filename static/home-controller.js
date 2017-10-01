//var myApp = angular.module('myApp', []);

myApp.controller('HomeCtrl', [
		'$scope',
		'$resource',
		function($scope, $resource) {

			var me = this;

			/*
			 * $scope.wishlist = [ { name : "" } ];
			 */

			$scope.title = 'Winvest!';
			$scope.subTitle = 'Next Generation Banking Portal';

			$scope.labels = [ "Food & Dining", "Shopping", "Travel",
					"Rent & Utility", "Entertainment" ];
			$scope.data = [ 1000, 200, 800, 1500, 400 ];

			$scope.chartOptions = {
				legend : {
					display : true
				}
			};

			setInterval(function() {
				me.callOnce();
			}, 5000);

			var UserAditya = $resource('/api/user/aditya');
			var userAditya = UserAditya.query(function() {
				$scope.profile = userAditya[0];
			});

			this.callOnce = function() {

				var User = $resource('/api/user');
				var user = User.query(function() {
					$scope.wishlist = user[0].wishlist;
				});

				var Transaction = $resource('/api/transaction');
				var transactions = Transaction.query(function() {
					$scope.transactions = transactions;
				});

			};

			$scope.displayDate = function(x) {
				return x == "Wishlist Transaction";
			}

			this.callOnce();

		}

]);