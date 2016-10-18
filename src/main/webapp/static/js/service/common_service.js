mainApp.service('commonService',function(){
var _binaryTreeDetails='';
this.setbinaryTreeDetails=function(binaryTreeDetails){
	this._binaryTreeDetails=binaryTreeDetails;
}
this.getbinaryTreeDetails=function(binaryTreeDetails){
	return _binaryTreeDetails;
}
});