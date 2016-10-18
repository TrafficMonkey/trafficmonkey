mainApp.controller('DashBoardCtrl', ['$rootScope','$scope','$location','DashboardService','commonService', function($rootScope,$scope,$location,DashboardService,commonService) {
    
   
  
    $scope.test=$rootScope.test;
var user=$scope.test;
    //$scope.name= $scope.test.USER.name;
  
    $scope.createBinaryTree=function(){
    	DashboardService.generateTree(user.USER.registration.id)
    	.then(
    		function(d) {
				console.log(d);
				$location.path('binaryTree')
				commonService.setbinaryTreeDetails(d);
			},
			
			function(errResponse){}
			);
    	
	   };
	}]);