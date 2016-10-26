mainApp.controller('ProfileCtrl', ['$rootScope','$scope','$location','commonService',  function($rootScope,$scope,$location,commonService)  {
	 
	var userDetails= commonService.getdataDetails();
	$scope.user=userDetails;
	 console.log(userDetails);
	}]);