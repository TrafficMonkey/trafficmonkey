mainApp.controller('TotalpaymentCtrl', ['$rootScope','$scope','$location','TotalPaymentService', function($rootScope,$scope,$location,TotalPaymentService) {
    
	
	   $scope.name='Account Page';
	   TotalPaymentService.getUserDetailsForPayment().then(function(d){},
			   function(errResponse){
		   
	   }
	   );
	 
	}]);