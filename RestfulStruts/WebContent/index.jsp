<html ng-app>
</head>

<script  src="lib\angular-min.js">  </script>
<!-- <script  src="ngapp\app.js">  </script>
<script  src="ngapp\controllers.js">  </script>
-->
<script src="ngapp\controllers.js"></script>
 <script >

  function GetController($scope, $http) {
	  
	     var url="http://localhost:8080/RestfulStruts/rest/v1/status";
	        
	    alert("hey");
	        $http.get(url).success(function(response){alert("in");
	        $scope.students=response;	
	        	
	        }).error(function(data, status, headers, config) {
	        	 alert("error");
	        });
	   

	 }
  
  </script>
  </head>
  
  
  <body ng-controller="GetController">
  <button ng-click="Getcontroller()">get</button>
  <div>
  <ul>
  <li ng-repeat="x in students">
    studentId:{{ x.studentId }} student name{{x.name }}
  </li>
</ul>
  </div>
   <div ng-controller='HelloController'>
    <p>{{greeting.text}}, World</p>
  </div>
</body>
</html>