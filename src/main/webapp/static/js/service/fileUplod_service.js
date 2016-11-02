'use strict';

mainApp.factory('FileUplodeService', ['$http', '$q', function($http, $q){

	return {
		
			
		uploadProfileImg: function(file){
			var fd = new FormData();
			 fd.append('file', file);
			/* comsole.log('fd is =====>>>>>');
		    	consol.log(fd);*/
					return $http.put('http://localhost:8080/trafficmonkey/upload/',fd,{
							
							transformRequest: angular.identity,
		                     headers: {'Content-Type':undefined,'Process-Data':false},
					
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
