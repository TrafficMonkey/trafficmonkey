'use strict';

mainApp.factory('FileUplodeService', ['$http', '$q', function($http, $q){

	return {
		
			
		uploadProfileImg: function(fileDetails){
		    	
		    	
					return $http.put('http://localhost:8080/trafficmonkey/upload/', fileDetails,
							
							{       
					    headers: {'Content-Type': false, dataType: 'text'},
					    transformRequest: angular.identity
					}
					
					)
							.then(
									function(response){
										
										
										return response.data;
									}, 
									function(errResponse){
										console.error('Error while creating user');
										//console.log(errResponse);
										return $q.reject(errResponse);
									}
							);
		    },
		    
		   
		
	};

}]);
