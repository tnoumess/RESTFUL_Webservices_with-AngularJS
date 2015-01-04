<html ng-app="myApp">
</head>
<link rel="stylesheet" type="text/css" href="css/app.css"/>
<script  src="lib/angular-min.js">  </script>
<script  src="ngapp/app.js">  </script>
<script  src="ngapp/angular-route.js">  </script>

<title>Student Management System</title>
</head> 
<body>

<div ng-controller="SmcController" > <span ng-click='addstudentform()'> <a ng-href="#/add" >Add Student</a></span>||<span ng-click='removestudentform()'><a href="#" >Remove Student</a></span>||<span ng-click='updatestudentform()'><a href="#/update" >Update Student</a></span>||<span ng-click='liststudents()'><a href="#/list" >List Students</a></span>
 
<div ng-show='formState.show' ng-controller="formsController"> <div ng-view></div> </div>

<div ng-show='formremoveState.show'> remove  </div>

<div ng-show='formupdateState.show'  ng-controller="updateController">
<div ng-show='formupdatedisplayState.show'> <div ng-view></div></div>
</div>

<div ng-show='formlistState.show'> <div ng-view></div> </div>

</div>

</body>
</html>