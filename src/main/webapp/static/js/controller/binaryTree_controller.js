mainApp.controller('BinaryTreeCtrl', ['$rootScope','$scope','$location','commonService', function($rootScope,$scope,$location,commonService) {
    
   
  
    $scope.test=commonService.getbinaryTreeDetails();

      console.log( commonService.getbinaryTreeDetails());
   
	}]);