mainApp.controller('DashBoardCtrl', ['$rootScope','$scope','DashboardService', function($rootScope,$scope,DashboardService) {
    
   
  
    $scope.test=$rootScope.test;
var user=$scope.test;
    //$scope.name= $scope.test.USER.name;
  
    $scope.createBinaryTree=function(){
    	DashboardService.generateTree(user.USER.registration.id)
    	.then(
    		function(d) {
				console.log(d);
			},
			
			function(errResponse){}
			);
    	
	   };
	}]);