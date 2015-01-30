
<form name="studentform" ng-submit="sendform()">
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
