/*mainApp.controller('TodayTaskCtrl', ['$scope',function($scope){
			
			$scope.name='shweta';
		}
		
		 ]);*/




mainApp.controller('TodayTaskCtrl', ['$scope', function($scope) {
    
	$scope.name='shweta';   
	console.log('lode');
	$scope.users = [
{ name: "Madhav Sai", age: 10, location: 'Nagpur' },
{ name: "Suresh Dasari", age: 30, location: 'Chennai' },
{ name: "Rohini Alavala", age: 29, location: 'Chennai' },
{ name: "Praveen Kumar", age: 25, location: 'Bangalore' },
{ name: "Sateesh Chandra", age: 27, location: 'Vizag' }
];

}]);