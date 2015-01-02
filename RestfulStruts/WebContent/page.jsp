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
<form novalidate name="studentform" ng-submit="sendform()" >
<fieldset class="fieldset_spec"><legend><strong>Student Information</strong></legend>
<div class="success"> {{message_success.text}}</div><div class="error"> {{message_error.text}}</div>
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
<div ng-show='formupdateState.show'  ng-controller="updateController">
Update Students<br>
<div ng-show='formupdatedisplayState.show'>
<form novalidate name="studentupdateform" ng-submit="sendupdateform()" >
<fieldset class="fieldset_spec"><legend><strong>UPDATE INFORMATION</strong></legend>
<div class="success"> {{message_success_update.text}}</div><div class="error"> {{message_error_update.text}}</div>
<div class="div_spec" ng-class="getCssClasses(studentupdateform.StudentId)">
StudentId:<input name="studentId" type="text" title="Student Id" placeholder="G00760357" ng-model="Student.Id" ng-pattern="/^[G]{1}[0-9]{6}$/" required>
<span ng-show="studentupdateform.studentId.$dirty && studentupdateform.studentId.$error.required" class="error" >This field is required</span>
<span ng-show="studentupdateform.studentId.$dirty && studentupdateform.studentId.$error.pattern" class="error" >Invalid format</span>
</div>
<br>
<div class="div_spec">
Full name:<input name="name" type="text" title="Full name" placeholder="Noumessi Thierry" ng-pattern="/^[a-zA-Z]{2,20}$/" ng-model="Student.Name" required>
<span ng-show="studentupdateform.name.$dirty && studentupdateform.name.$error.required" class="error" >This field is required</span>
<span ng-show="studentupdateform.name.$dirty && studentupdateform.name.$error.pattern" class="error" >Invalid Name format</span>
</div><br>
<div class="div_spec">
Major :<input name="major" type="text" title="Major" placeholder="SWE" ng-pattern="/^[a-zA-Z]{3}$/" ng-model="Student.Major" required>
<span ng-show="studentupdateform.major.$dirty && studentupdateform.major.$error.required" class="error" >This field is required</span>
<span ng-show="studentupdateform.major.$dirty && studentupdateform.major.$error.pattern" class="error" >Invalid Major format </span>
</div><br>
<div class="div_spec" >
Country: <select name="country" ng-model="Student.Country" required>
<option value="US">United States</option>
<option value="CM">Cameroon</option>
</select>
<span ng-show=" studentupdateform.country.$error.required" class="error" >This country is required</span>
</div><br>
<div class="div_spec">
<button type="update" class="submit_b" ng-disabled="studentupdateform.$invalid"> submit</button>
<button type="reset" class="submit_b"> reset</button>
</div>
</fieldset>
</form>

</div>
<div >
<ul>
<li ng-repeat="x in students">{{$index + 1}}.
StudentId:{{ x.studentId }}
</li>
</ul>
</div>
</div>
<div ng-show='formlistState.show'>
List of Students<br>  
<div ng-bind="list">
{{students}}
</div>
<div>
<ul>
<table class="div_spec">
 <tr class="success"><td>Student Id </td><td>Name</td><td>Major</td><td>Country</td></tr>
<div>
<tr ng-repeat="x in studentss" class="fieldset_spec"><td>{{x.studentId}}</td><td>{{x.name}}</td><td>{{x.major}}</td><td>{{x.country}}</td></tr>
</div>
</table>
</ul>
</div>

</div>
</div>

</body>
</html>