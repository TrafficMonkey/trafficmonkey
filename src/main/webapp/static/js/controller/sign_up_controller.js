
'use strict';


mainApp.controller('SignUpCtrl', ['$rootScope','$scope','SignUpService','$location',  function($rootScope,$scope,SignUpService,$location) {
    
   
  
	$scope.errorMessage=''
		$scope.message=''

	$scope.user={name:'a',login:{email:'a',password:'a'},parentChild:{parentId:0},sponsorId:'a',sponsorName:'a',position:'', planType:'',termsAndCondition:'a',}
        
	
	$scope.submit = function() {
		
		SignUpService.createUser($scope.user)
		
        .then(
        		
        		function(d) {
        			$scope.errorMessage='';
        			$rootScope.test=d
        			$scope.message='You are successfully register in Trafficmonkey'
        		  //$location.path('dashboard')
        			
        		},
	              function(errResponse){
		              // console.error('Error while creating User.');
		               $scope.errorMessage=errResponse.data.Error.message;
	              }	
    );
		console.log($scope.user);
    };
    
  
    $scope.getSponserName=function(){
    
    	SignUpService. getSponserName($scope.user.sponsorId)
    	.then(function(d)
    			
    	{
    		$scope.errorMessage='';
    		$scope.user.sponsorName=d.SPONSOR.name;
    		$scope.user.parentChild.parentId=d.SPONSOR.id
    	},
    	function(errResponse){
    	
    		$scope.errorMessage=errResponse.data.Error.message;
    	}
    	);
    };
    

}]);