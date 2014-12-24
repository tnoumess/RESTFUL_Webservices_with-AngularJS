<html ng-app="myApp">
</head>
<link rel="stylesheet" type="text/css" href="css/app.css"/>
<script  src="lib/angular-min.js">  </script>
<script  src="ngapp/app.js">  </script>
</head> 
  
  <body >
  
  
   <div ng-controller='greetingController'>
    <p>{{greeting.text}}, World</p>
  </div>
  <form ng-controller="formController" ng-submit="computeNeeded()">
  <input type="checkbox" ng-model="form.id" ng-true-value="yes" ng-false-value="no" ng-change="display()">
  Starting: <input    
                      ng-model="funding.startingEstimate">
  Recommendation: {{funding.needed}}<br>
  <button type="submit" >submit</button>
  <button ng-click="requestFunding()">Fund my startup!</button>
  <button ng-click="reset()">Reset</button>
  </form>
  <div ng-controller='hideandshowController'>
  
   <button ng-click='toggleMenu()'>Toggle Menu</button>
  <ul ng-show='menuState.show'>
    <li ng-click='stun()'>Stun</li>
    <li ng-click='disintegrate()'>Disintegrate</li>
    <li ng-click='erase()'>Erase from history</li>
  </ul>
  </div>
  <div ng-controller='HeaderController'>
  
  <div ng-class='{error: isError, warning: isWarning, success: isSuccess}'>{{messageText}}</div>
  <button ng-click='showError()'>Simulate Error</button>
  <button ng-click='showWarning()'>Simulate Warning</button>
  <button ng-click='showSuccess()'>Simulate Success</button>
</div>
<table ng-controller='TablecolorController'>
  <tr ng-repeat='restaurant in directory' ng-click='selectRestaurant($index)'
      ng-class='{selected: $index==selectedRow}'>
    <td>{{restaurant.name}}</td>
    <td>{{restaurant.cuisine}}</td>
  </tr>
</table>
<div ng-controller='PictureController'>
<div><img ng-src="img/{{yourpicture}}" ng-show='picState.show'></div>
<button ng-click='showit()'>show picture</button>
<button ng-click='hideit()'>hide picture</button>
</div>

<div ng-controller="CartController">
  <div ng-repeat="item in items">
    <span>{{item.title}}</span>
    <input ng-model="item.quantity">
    <span>{{item.price | currency}}</span>
    <span>{{item.price * item.quantity | currency}}</span>
  </div>
  <div>Total: {{totalCart() | currency}}</div>
  <div>Discount: {{bill.discount | currency}}</div>
  <div>Subtotal: {{subtotal() | currency}}</div>
</div>



<div ng-controller="SmcController"  > <span ng-click='addstudentform()'> <a ng-href="#" >Add Student</a></span>||<span ng-click='removestudentform()'><a href="#" >Remove Student</a></span>||<span ng-click='updatestudentform()'><a href="#" >Update Student</a></span>||<span ng-click='liststudents()'><a href="#" >List Students</a></span>

<div  ng-show='formState.show' ng-controller="formsController">
<form   name="studentform" ng-submit="sendform()">
<fieldset class="fieldset_spec"><legend><strong>Student Information</strong></legend>
<div class="div_spec" ng-class="getCssClasses(studentform.studentId)">
StudentId:<input name="studentId" type="text" title="Student Id" placeholder="G00760357"  ng-model="student.Id" ng-pattern="/^[G]{1}[0-9]{6}$/"  required>
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
Major    :<input name="major" type="text" title="Major" placeholder="SWE" ng-pattern="/^[a-zA-Z]{3}$/" ng-model="student.Major" required>

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

<div  ng-show='formremoveState.show'>


remove


</div>

<div  ng-show='formupdateState.show'>
update
</div>

<div  ng-show='formlistState.show'>


  List of Students<br>

<div ng-controller="GetController">
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