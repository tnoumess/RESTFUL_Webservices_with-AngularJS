<html ng-app="myApp">
</head>
<link rel="stylesheet" type="text/css" href="css/app.css"/>
<script  src="lib/angular-min.js">  </script>
<script  src="ngapp/app.js">  </script>
<title>Student Management System</title>
</head> 
<body>

<div ng-controller="SmcController" > <span ng-click='addstudentform()'> <a ng-href="#" >Add Student</a></span>||<span ng-click='removestudentform()'><a href="#" >Remove Student</a></span>||<span ng-click='updatestudentform()'><a href="#" >Update Student</a></span>||<span ng-click='liststudents()'><a href="#" >List Students</a></span>
<div ng-show='formState.show' ng-controller="formsController">
<form name="studentform" ng-submit="sendform()">
<fieldset class="fieldset_spec"><legend><strong>Student Information</strong></legend>
<div class="success"> {{message.text}}</div>
<div class="div_spec" ng-class="getCssClasses(studentform.studentId)">
StudentId:<input name="studentId" type="text" title="Student Id" placeholder="G00760357" ng-model="student.Id" ng-pattern="/^[G]{1}[0-9]{6}$/" required>
<span ng-show="studentform.studentId.$dirty && studentform.studentId.$error.required" class="error" >This field is required</span>
<span ng-show="studentform.studentId.$dirty && studentform.studentId.$error.pattern" class="error" >Invalid format</span>
</div>
<br>
<div class="div_spec">
Full name:<input name="name" type="text" title="Full name" placeholder="Noumessi Thierry" ng-pattern="/^[a-zA-Z]{2,20}$/" ng-model="student.Name" required>
<span ng-show="studentform.name.$dirty && studentform.name.$error.required" class="error" >This field is required</span>
<span ng-show="studentform.name.$dirty && studentform.name.$error.pattern" class="error" >Invalid Name format</span>
</div><br>
<div class="div_spec">
Major :<input name="major" type="text" title="Major" placeholder="SWE" ng-pattern="/^[a-zA-Z]{3}$/" ng-model="student.Major" required>
<span ng-show="studentform.major.$dirty && studentform.major.$error.required" class="error" >This field is required</span>
<span ng-show="studentform.major.$dirty && studentform.major.$error.pattern" class="error" >Invalid Major format </span>
</div><br>
<div class="div_spec" >
Country: <select name="country" ng-model="student.Country" required>
<option value="US">United States</option>
<option value="CM">Cameroon</option>
</select>
<span ng-show=" studentform.country.$error.required" class="error" >This country is required</span>
</div><br>
<div class="div_spec">
<button type="submit" class="submit_b" ng-disabled="studentform.$invalid"> submit</button>
<button type="reset" class="submit_b"> reset</button>
</div>
</fieldset>
</form>

</div>
<div ng-show='formremoveState.show'>
remove
</div>
<div ng-show='formupdateState.show'>
update
</div>
<div ng-show='formlistState.show'>
List of Students<br>
<div >
<ul>
<li ng-repeat="x in students">{{$index + 1}}.
StudentId:{{ x.studentId }}
Name:{{x.name }}
</li>
</ul>
</div>
</div>
</div>

</body>
</html>