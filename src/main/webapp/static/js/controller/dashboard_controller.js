mainApp.controller('DashBoardCtrl', ['$rootScope','$scope','$location','DashboardService','commonService', function($rootScope,$scope,$location,DashboardService,commonService) {
    
   
  
    $scope.test=$rootScope.test;
var user=$scope.test;

    //$scope.name= $scope.test.USER.name;
     
	   angular.element(document).ready(function () {

		   
		   
		   
		   
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
	   
	   
	   
	   
	   
	   $(document).ready(function() {
	        //Horizontal Tab
	        $('#parentHorizontalTab').easyResponsiveTabs({
	            type: 'default', //Types: default, vertical, accordion
	            width: 'auto', //auto or any width like 600px
	            fit: true, // 100% fit in a container
	            tabidentify: 'hor_1', // The tab groups identifier
	            activate: function(event) { // Callback function if tab is switched
	                var $tab = $(this);
	                var $info = $('#nested-tabInfo');
	                var $name = $('span', $info);
	                $name.text($tab.text());
	                $info.show();
	            }
	        });

	        // Child Tab
	        $('#ChildVerticalTab_1').easyResponsiveTabs({
	            type: 'vertical',
	            width: 'auto',
	            fit: true,
	            tabidentify: 'ver_1', // The tab groups identifier
	            activetab_bg: '#fff', // background color for active tabs in this group
	            inactive_bg: '#F5F5F5', // background color for inactive tabs in this group
	            active_border_color: '#c1c1c1', // border color for active tabs heads in this group
	            active_content_border_color: '#5AB1D0' // border color for active tabs contect in this group so that it matches the tab head border
	        });

	        //Vertical Tab
	        $('#parentVerticalTab').easyResponsiveTabs({
	            type: 'vertical', //Types: default, vertical, accordion
	            width: 'auto', //auto or any width like 600px
	            fit: true, // 100% fit in a container
	            closed: 'accordion', // Start closed if in accordion view
	            tabidentify: 'hor_1', // The tab groups identifier
	            activate: function(event) { // Callback function if tab is switched
	                var $tab = $(this);
	                var $info = $('#nested-tabInfo2');
	                var $name = $('span', $info);
	                $name.text($tab.text());
	                $info.show();
	            }
	        });
	    });
	}]);