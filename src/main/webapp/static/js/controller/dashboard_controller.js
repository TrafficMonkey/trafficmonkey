mainApp.controller('DashBoardCtrl', ['$rootScope','$scope','$location','DashboardService','commonService', function($rootScope,$scope,$location,DashboardService,commonService) {
    
   
  
    $scope.test=$rootScope.test;
var user=$scope.test;
    //$scope.name= $scope.test.USER.name;
  
    $scope.createBinaryTree=function(){
    	DashboardService.generateTree(user.USER.registration.id)
    	.then(
    		function(d) {
				console.log(d);
				commonService.setbinaryTreeDetails(d);
				$location.path('binaryTree')
				
			},
			
			function(errResponse){}
			);
    	
	   };
	   
	   $scope.selectedTab = 0;
	    
	    $scope.changeTab = function() {
	        if ($scope.selectedTab === 2) {
	            $scope.selectedTab = 0;
	        }
	        else {
	            $scope.selectedTab++;
	        }
	        
	    }
	}]);