'use strict';

mainApp.factory('AccountService', ['$http', '$q', function($http, $q){

	return {
		
			
		    createAccount: function(parentId){
     		    	//console.log(user);
					/*return $http.get('http://localhost:8080/trafficmonkey/generateTree?parentId='+parentId)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating user');
										return $q.reject(errResponse);
									}
							);*/
		    },
		    
		 
		
	};
	
	

}]);
