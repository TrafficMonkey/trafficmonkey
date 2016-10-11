'use strict';

mainApp.factory('SignUpService', ['$http', '$q', function($http, $q){

	return {
		
			
		    createUser: function(user){
     		    	console.log(user);
					return $http.post('http://localhost:8080/trafficmonkey/signUp/', user)
							.then(
									function(response){
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating user');
										return $q.reject(errResponse);
									}
							);
		    },
		    
		   
		
	};

}]);
