mainApp.controller('DashBoardCtrl', ['$rootScope','$scope','$location','DashboardService', function($rootScope,$scope,$location,DashboardService) {
    
	 
	var newScope = $scope.$new();
    $scope.test=$rootScope.test;
    var user=$scope.test;
    
  
	      /* below code for tab */
	   
	  $(document).ready(function() {

		 $('#nav').tabCollapse();
	      
	    });
	}]);