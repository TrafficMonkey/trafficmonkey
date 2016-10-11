
'use strict';


mainApp.controller('SignUpCtrl', ['$scope','SignUpService','$location',  function($scope,SignUpService,$location) {
    
   
  

	$scope.user={name:'a',login:{email:'a',password:'a'},contact:'a',pancardFlag:'true',pancard:'a',nominee:'a',sponsorId:'a',sponcerName:'a',position:'', planType:'',termsAndCondition:'a'}
        
    
	$scope.submit = function() {
		
		SignUpService.createUser($scope.user)
		
		//$location.path('#dashboard')
        .then(
        		
        		$location.path('signUp/dashboard'),
	              function(errResponse){
		               console.error('Error while creating User.');
	              }	
    );
		console.log($scope.user);
    };
    
  

}]);