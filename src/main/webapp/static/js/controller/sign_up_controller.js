
'use strict';


mainApp.controller('SignUpCtrl', ['$scope','SignUpService','$location',  function($scope,SignUpService,$location) {
    
   
  
	$scope.errorMessage=''

	$scope.user={name:'a',login:{email:'a',password:'a'},contact:'a',panCardFlag:'true',panCard:'a',nominee:'a',sponsorId:'a',sponsorName:'a',position:'', planType:'',termsAndCondition:'a'}
        
    
	$scope.submit = function() {
		
		SignUpService.createUser($scope.user)
		
        .then(
        		
        		function(d) {
        			$rootScope.test=d
        		  $location.path('dashboard')
        		},
	              function(errResponse){
		               console.error('Error while creating User.');
		               $scope.errorMessage=errResponse.data.Error.message;
	              }	
    );
		console.log($scope.user);
    };
    
  

}]);