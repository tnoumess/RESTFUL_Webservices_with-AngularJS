


List of Students registered

<br>
<div >
 <table class="fieldset_spec" style="width:50%">
  <tr class="success">
   
    <th>StudentId</th>
    <th>Name</th>
    <th>Major</th>
    <th>Country</th> 
    
  </tr>
  
<tr ng-repeat="x in studentss" class="text_spec2">
    <td >{{$index + 1}}.{{ x.studentId }}</td>
    <td >{{x.name }}</td>
     <td >{{x.major }}</td>
    <td >{{x.country}}</td>
   
  </tr>

  
</table> 

</div>