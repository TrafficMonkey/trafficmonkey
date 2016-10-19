mainApp.service('commonService',function(){
var _binaryTreeDetails=[];
this.setbinaryTreeDetails=function(binaryTreeDetails){
	_binaryTreeDetails=binaryTreeDetails;
}
this.getbinaryTreeDetails=function(){
	return _binaryTreeDetails;
}
});