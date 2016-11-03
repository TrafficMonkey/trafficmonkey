

mainApp.controller('LoginCtrl', ['$rootScope','$scope','$state','LoginService','commonService','$location',  function($rootScope,$scope,$state,LoginService,commonService,$location)  {
	  // $scope.message = "This is view 1";
	   $scope.loginDetails={email:'', password :'' ,isRememberMe:''};
	   $scope.errorMessage='';
	   $scope.login=function(){

		   LoginService.login($scope.loginDetails)
			
	        .then(
	        		function(d) {
	        			
	        			$rootScope.test=d
	        			console.log(d);
	        			 window.sessionStorage.setItem('loggedInUserId',JSON.stringify(d));
	        			 commonService.setdataDetails(d.USER);
	        		     $state.go('dashboard.profile')
	        		},
		              function(errResponse){
			               console.error('Error while creating User.');
			               console.log(errResponse);
			               $scope.errorMessage=errResponse.data.Error.message;
		              }	
	    );
			
	   };
	}]);