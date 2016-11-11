/*mainApp.controller('TodayTaskCtrl', ['$scope',function($scope){
			
			$scope.name='shweta';
		}
		
		 ]);*/




mainApp.controller('TodayTaskCtrl', ['$scope','todayTaskService', function($scope,todayTaskService) {
	$scope.getCurrentSelection = function(sdfsdfsdfds) {
		console.log("sdfsdfsdfds")
		  //var currentSelection = $scope.gridApi.selection.getSelectedRows();
		
		  console.log(sdfsdfsdfds);
		};
	$scope.name='shweta';   
	console.log('lode');
	$scope.users =[];
	$scope.gridOptions={};
	$scope.gridOptions.onRegisterApi=function(gridApi) { //register grid data first within the gridOptions
		    $scope.gridApi = gridApi;
		  };
	/*$scope.users = [
{ name: "Madhav Sai", age: 10, location: 'Nagpur' },
{ name: "Suresh Dasari", age: 30, location: 'Chennai' },
{ name: "Rohini Alavala", age: 29, location: 'Chennai' },
{ name: "Praveen Kumar", age: 25, location: 'Bangalore' },
{ name: "Sateesh Chandra", age: 27, location: 'Vizag' }
];*/

	
	$scope.gridOptions.columnDefs = [
                                       { name: 'S.N',enableCellEditOnFocus:false,width: 300 ,cellTemplate:"" },
	                                 { name: 'pageTitle',enableCellEditOnFocus:false,width: 300  },
	                                 { name: 'pageLink',  enableCellEdit: true, displayName:'Page Link', width: 300, cellTemplate:"<a type='submit' ng-click='grid.appScope.getCurrentSelection(row.entity)'>{{row.entity.pageLink}}</a>"} ,
	                                 
	                               ];
	
	
	
	
	
	todayTaskService.getTodayTask(JSON.parse(window.sessionStorage
				.getItem('loggedInUserId')).USER.registration.id)
				.then(
				 		function(d) {
							console.log(d);
							
							//$scope.users=d.TODAY_TASK;
							$scope.gridOptions.data=d.TODAY_TASK;
				               
							
						},
						
						function(errResponse){}
						);
	
}]);