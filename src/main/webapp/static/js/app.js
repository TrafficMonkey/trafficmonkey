'use strict';
var mainApp = angular.module("mainApp", ['ngRoute',"ngMaterial", "ngAnimate"]);

mainApp.config(['$routeProvider', function($routeProvider) {
   
   $routeProvider
   .when('/', {
      templateUrl: 'static/pages/home.html'
   })
   .when('/aboutUs', {
      templateUrl: 'static/pages/aboutUs.html'
   })
   
   
   .when('/plans', {
      templateUrl: 'static/pages/plans.html'
   })
   .when('/termsAndConditions', {
      templateUrl: 'static/pages/termsAndConditions.html'
   })
   .when('/whyUs', {
      templateUrl: 'static/pages/whyUs.html'
   })
   .when('/fAQ', {
      templateUrl: 'static/pages/fAQ.html'
   })
   .when('/contactUs', {
      templateUrl: 'static/pages/contactUs.html'
   })
   .when('/loginPage', {
      templateUrl: 'static/pages/loginPage.html',controller:'LoginCtrl'
   })
   
   .when('/signUp', {
      templateUrl: 'static/pages/signUp.html',controller:'SignUpCtrl'
   })
   
   .when('/dashboard', {
      templateUrl: 'static/pages/dashboard.html',controller:'DashBoardCtrl'
   })
   
   .when('/binaryTree', {
      templateUrl: 'static/pages/binaryTree.html',controller:'BinaryTreeCtrl'
   })
   .otherwise({redirectTo: '/' });
}]);

mainApp.run(function($rootScope) {
    $rootScope.test;
})





