<html ng-app="myApp">
</head>
<link rel="stylesheet" type="text/css" href="css/app.css"/>
<script  src="lib/angular-min.js">  </script>
<script  src="ngapp/app.js">  </script>
<title>Student Management System</title>
</head> 
<body>
<div ng-controller="SmcController"  > <span ng-click='addstudentform()'> <a ng-href="#"  >Add Student</a></span>||<span ng-click='removestudentform()'><a href="#" >Remove Student</a></span>||<span ng-click='updatestudentform()'><a href="#" >Update Student</a></span>||<span ng-click='liststudents'><a href="#" >List Students</a></span>

<div ng-controller="formController" ng-show='formState.show'>
<form  ng-submit="sendform()" >
<fieldset class="fieldset_spec"><legend><strong>Student Information</strong></legend>
<div class="div_spec">
StudentId:<input type="text" title="Student Id" placeholder="G00760357" ng-pattern="/[G][0-9]{6}" ng-model="student.Id" required>
<span class="error" ng-show="myForm.input.$error.required">
    Required!</span>
  <span class="error" ng-show="myForm.input.$error.pattern">
    Id should start with G followed by 6 digits</span></div><br>

<div class="div_spec">

Full name:<input type="text" title="Full name" placeholder="Noumessi Thierry" ng-pattern="/[a-zA-Z]{2,20}" ng-model="student.Name" required>
<span class="error" ng-show="myForm.input.$error.required">
    Required!</span>
  <span class="error" ng-show="myForm.input.$error.pattern">
    Name should be Alphanumeric and between 2 and 20 characters</span>
    
    </div><br>
<div class="div_spec">
Major    :<input type="text" title="Major" placeholder="SWE" ng-pattern="/[a-zA-Z]{3}" ng-model="student.Major" required>
<span class="error" ng-show="myForm.input.$error.required">
    Required!</span>
  <span class="error" ng-show="myForm.input.$error.pattern">
   Major should be 3 characters </span></div><br>
<div class="div_spec">
  Country: <select ng-model="student.Country">
	<option value="US">United States</option>

	<option value="CM">Cameroon</option>
	
</select></div><br>

<div class="div_spec">
   <button type="submit" class="submit_b"> submit</button>
   <button type="reset" class="submit_b"> reset</button>
</div>

</fieldset>
</form>

</div>

</div>

</body>
</html>