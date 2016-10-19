mainApp.controller('BinaryTreeCtrl', ['$rootScope','$scope','$location','commonService', function($rootScope,$scope,$location,commonService) {
    
   
  
    $scope.test=commonService.getbinaryTreeDetails();
    var testData = $scope.test.BINARYTREE;
                $(function(){
                	
                    org_chart = $('#orgChart').orgChart({
                        data: testData,
                        showControls: true,
                        allowEdit: true,
                        onAddNode: function(node){ 
                           
                            org_chart.newNode(node.data.id); 
                        },
                        onDeleteNode: function(node){
                          
                            org_chart.deleteNode(node.data.id); 
                        },
                        onClickNode: function(node){
                            
                        }

                    });
                });	

   
	}]);