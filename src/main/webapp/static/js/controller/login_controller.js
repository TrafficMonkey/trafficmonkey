

mainApp.controller('LoginCtrl', ['$scope','LoginService','$location',  function($scope,LoginService,$location,$rootScope)  {
	  // $scope.message = "This is view 1";
	   $scope.loginDetails={email:'', password :'' ,isRememberMe:''};
	   $scope.errorMessage='';
	   $scope.login=function(){

		   LoginService.login($scope.loginDetails)
			
	        .then(
	        		function(d) {
	        			//console.log(d.headers);
	        			$rootScope.test=d
	        		$location.path('dashboard')
	        		},
		              function(errResponse){
			               console.error('Error while creating User.');
			               console.log(errResponse);
			               $scope.errorMessage=errResponse.data.Error.message;
		              }	
	    );
			console.log($scope.loginDetails);
	   };
	}]);