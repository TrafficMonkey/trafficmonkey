mainApp.controller('ProfileCtrl', ['$rootScope','$scope','$location','commonService','FileUplodeService',  function($rootScope,$scope,$location,commonService,FileUplodeService)  {
	 
	var userDetails= JSON.parse(window.sessionStorage.getItem('loggedInUserId')).USER;
	$scope.user=userDetails;
	 
	console.log(userDetails.registration.profileImage);
	 
	 
	 
	 $scope.myImage='data:image/JPEG;base64,'+userDetails.registration.profileImage;
	   

	    var handleFileSelect=function(evt) {
	      var file=evt.currentTarget.files[0];
	      var reader = new FileReader();
	      reader.onload = function (evt) {
	        $scope.$apply(function($scope){
	         $scope.myImage=evt.target.result;
	         console.log('before scope variable');
	         console.log($scope.myImage);
	         console.log('my target value ');
	         console.log(evt.target.result);
	       
	         FileUplodeService.uploadProfileImg(file);
	        });
	      };
	     // reader.readAsDataURL(file);
	     reader.readAsDataURL(file);
	    // reader.readAsArrayBuffer(blob);
	     console.log("file====");
	       console.log(file);
	   
	    };
	    angular.element(document.querySelector('#fileInput')).on('change',handleFileSelect);
	}]);