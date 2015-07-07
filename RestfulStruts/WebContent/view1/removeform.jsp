


List of Students registered
<div class="success"> {{message_delete.text}}</div>
<br>
<div ng-init="stud = { Id: 'G0000'}" >
 <table class="fieldset_spec" style="width:50%">
  <tr class="success">
   
    <th>StudentIds</th>
    <th>Name</th>
    <th>Major</th>
    <th>Country</th>
     <th>Action</th>
    
  </tr>
  
<tr ng-repeat="x in students" class="text_spec2">
    <td >{{$index + 1}}.{{ x.studentId }}</td>
    <td >{{x.name }}</td>
    <td >{{x.country}}</td>
    <td >{{x.major }}</td>
    <td > <button ng-click='remove(stud.Id = x.studentId)'>remove</button> </td>
  </tr>
  
</table> 
</div>