<form name="studentupdateform" ng-submit="sendupdateform()" width="50">
<fieldset class="fieldset_spec2"><legend><strong>UPDATE FORM</strong></legend>
<div class="success"> {{message_success_update.text}}</div><div class="error"> {{message_error_update.text}}</div>
<div class="div_spec" ng-class="getCssClasses(studentupdateform.studentId)">
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
<button type="submit" class="submit_b" ng-disabled="studentupdateform.$invalid"> submit</button>
<button type="reset" class="submit_b"> reset</button>
</div>
</fieldset>
</form>
