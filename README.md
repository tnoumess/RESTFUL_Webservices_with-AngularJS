RESTFUL_Webservices_with-AngularJS
==================================

This is a restful web services that uses AngularJS at the front-end.

System architecture design:
 We did not include Authentication for the sake of simplicity.

Requirements:  
 *User can register.
 *User can update information
 *User can delete information
 *user can view the list of current registered students
 *user can view a specific student information 
Resources:  
  *Student
  *List of Students
Resource representation: JSON
  *Student           {"student":{"studentId":"G000000", "name":"Edson", "major":"swe","country":"US"}}
  *List of students  [{"studentId":"G000000","name":"thierry","major":" swe","country":" US"}, {"studentId":"G000041","name":"simenou", "major":" swe","country":" CM"}]
URI definition:      
         http://localhost:8080/RestfulStruts/students with the GET method, this URI returns a list of all messages from all users; with the POST method, it creates a new message, with student info Jsonrepresentation as the payload of the request
        http://localhost:8080/RestfulStruts/students{studentId}   with the GET method, this URI returns a representation of a user with a unique identifier studentId; with the PUT method, it updates a user; and, with the DELETE method, it deletes a user.
