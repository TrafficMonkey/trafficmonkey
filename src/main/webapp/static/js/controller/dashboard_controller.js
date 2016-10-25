mainApp.controller('DashBoardCtrl', ['$rootScope','$scope','$location','DashboardService','commonService', function($rootScope,$scope,$location,DashboardService,commonService) {
    
	 
	var newScope = $scope.$new();
    $scope.test=$rootScope.test;
    var user=$scope.test;
    
       
    
    
    /* below code for tree genrationn */
    
	   /*angular.element(document).ready(function () {

		   
		   DashboardService.generateTree(user.USER.registration.id)
	    	.then(
	    		function(d) {
					console.log(d);
					
					 var testData = d.BINARYTREE;
		                	alert("in ready");
		                    org_chart = $('#orgChart').orgChart({
		                        data: testData,
		                        showControls: true,
		                        allowEdit: true,
		                        onAddNode: function(node){ 
		                            log('Created new node on node '+node.data.id);
		                            org_chart.newNode(node.data.id); 
		                        },
		                        onDeleteNode: function(node){
		                            log('Deleted node '+node.data.id);
		                            org_chart.deleteNode(node.data.id); 
		                        },
		                        onClickNode: function(node){
		                            log('Clicked node '+node.data.id);
		                        }

		                    });
		               
					
				},
				
				function(errResponse){}
				);
		   
		});
	   */
	   
	   
	   /* below code for tab */
	   
	  $(document).ready(function() {

		 $('#nav').tabCollapse();
	      
	    });
	}]);