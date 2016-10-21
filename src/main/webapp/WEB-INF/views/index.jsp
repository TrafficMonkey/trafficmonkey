<html>

<head>
<title>Trafficmonkey</title>
<link rel="stylesheet" href="static/css/bootstrap.css"></link>
<link href="static/css/app.css" rel="stylesheet"></link>
<link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
   <link href="./static/css/jquery.orgchart.css" media="all" rel="stylesheet" type="text/css" />
   <link href="https://ajax.googleapis.com/ajax/libs/angular_material/0.9.4/angular-material.min.css" rel="stylesheet"/>
   <link href="./static/css/easy-responsive-tabs.css" media="all" rel="stylesheet" type="text/css" />
   <link href="./static/css/font-awesome.min.css" media="all" rel="stylesheet" type="text/css" />
   <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.6.3/css/font-awesome.min.css">



</head>

<body class="background">


	<div ng-app="mainApp" >

		<div ng-app="mainApp" class="navbar navbar-inverse navbar-fixed-top">
			<a href="#home" class="navbar-brand"> TrafficMonkey.com </a>
			<button class=" navbar navbar-toggle" data-toggle="collapse"
				data-target=".navheadercollapse">
				<span class=" icon-bar"></span> <span class=" icon-bar"></span> <span
					class=" icon-bar"></span>
			</button>
			<div class=" collapse navbar-collapse navheadercollapse">
				<ul class=" nav navbar-nav">
					<li><a href="#home">Home</a></li>
					<li><a href="#aboutUs">About us</a></li>
					<li><a href="#plans">Plans</a></li>
					<li><a href="#termsAndConditions">Terms and Conditions</a></li>
					<li><a href="#whyUs">Why us</a></li>
					<li><a href="#fAQ">FAQ</a></li>
					<li><a href="#contactUs">Contact us</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#signUp"> Signup</a></li>
					<li><a href="#loginPage">Log In </a></li>
				</ul>
			</div>
		</div>



		<div ng-view style="margin-top: 70px;"></div>





		<div class="navbar navbar-inverse navbar-fixed-bottom">
			<button class=" navbar navbar-toggle" data-toggle="collapse"
				data-target=".navfootercollapse">
				<span class=" icon-bar"></span> <span class=" icon-bar"></span> <span
					class=" icon-bar"></span>
			</button>
			<div class=" collapse navbar-collapse navfootercollapse">
				<ul class=" nav navbar-nav">
					<li><a href="#">Terms and conditions</a></li>
					<li><a href="#">Privacy Policy</a></li>
					<li><a href="#">Renewable Policy</a></li>
					<li><a href="#">Task Holidays</a></li>
					<li><a href="#">FAQ</a></li>
					<li><a href="#">Contact us</a></li>
				</ul>
			</div>
		</div>
	</div>




	<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular.min.js"></script>
	<script src="static/js/app.js" /></script>
	<script
		src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-route.js"></script>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="static/js/controller/sign_up_controller.js"></script>
	<script src="static/js/controller/login_controller.js"></script>
	<script src="static/js/controller/dashboard_controller.js"></script>
	<script src="static/js/service/dashboard_service.js"></script>
	<script src="static/js/service/signup_services.js"></script>
	<script src="static/js/service/login_service.js"></script>
	<script src="static/js/service/common_service.js"></script>
	<script src="static/js/controller/binaryTree_controller.js"></script>
	<script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
    <script  src="static/JSlib/jquery.orgchart.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular-animate.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.7/angular-aria.min.js"></script>

    <script src="https://ajax.googleapis.com/ajax/libs/angular_material/0.9.4/angular-material.min.js"></script>
     <script  src="static/JSlib/easyResponsiveTabs.js"></script>
      

</body>
</html>