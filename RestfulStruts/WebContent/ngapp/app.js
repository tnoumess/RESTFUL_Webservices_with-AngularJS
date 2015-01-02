var app = angular.module('myApp', []);
app.controller('GetController', function ($scope, $http) {
	  
    var url="/RestfulStruts/rest";
       
   
       $http.get(url).success(function(response){alert("in");
       $scope.students=response;	
       console.log("in controller:"+$scope.students);
       	
       }).error(function(data, status, headers, config) {
       	 alert("error");
       });
});

/*
 * Data fetch service.
 * 
 * fetches data from server.
 */

app.factory('FetchdataService',function($http){ 
				 
	return {
	     getStudents: function() {
	 
		 
    var url="/RestfulStruts/rest";
    
   
    return  $http.get(url).success(function(response){
    
       return response.data;
      
       }).error(function(data, status, headers, config) {
       	 alert("error");
       	 return "null";
       });
       
}
	}
	  });

app.controller('greetingController', function ($scope) {
  $scope.greeting = { text: 'Hello' };
});
app.controller('SmSController',function($scope,$http){$scope.message = { text: 'Hello' };


});

app.controller('formController', function ($scope) {
	 $scope.form={};
	
	 $scope.display=function(){alert($scope.form.id);} 
	 $scope.funding = {  };
	 $scope.funding.startingEstimate;
	 

	  $scope.computeNeeded = function() {
	    $scope.funding.needed = $scope.funding.startingEstimate * 10;
	    //alert($scope.funding.startingEstimate * 10);
	    $scope.$watch('funding.startingEstimate', computeNeeded);
	    
	    
	  };
	  $scope.reset = function() {
		    $scope.funding.startingEstimate = 0;
		    $scope.funding.needed = 0;
		  };
		  $scope.requestFunding = function() {
		        window.alert("Sorry, please get more customers first.");
		      };
	  
	});

app.controller('hideandshowController', function ($scope) {
	$scope.menuState = { show: false };
	 $scope.toggleMenu = function() {
		    $scope.menuState.show = !$scope.menuState.show;
		    //alert(!$scope.menuState.showw);
		  };
	});
app.controller('HeaderController', function ($scope) {
	  $scope.isError = false;
	  $scope.isWarning = false;
	  $scope.isSuccess = false;

	  $scope.showError = function() {
	    $scope.messageText = 'This is an error!';
	    $scope.isError = true;
	    $scope.isWarning = false;
	    $scope.isSuccess = false;
	  };

	  $scope.showWarning = function() {
	    $scope.messageText = 'Just a warning.  Please carry on.';
	    $scope.isWarning = true;
	    $scope.isError = false;
	    $scope.isSuccess = false;
	  };
	  $scope.showSuccess = function() {
		    $scope.messageText = 'Just a warning.  Please carry on.';
		    $scope.isWarning = false;
		    $scope.isError = false;
		    $scope.isSuccess = true;
		  };
	});


app.controller('TablecolorController', function ($scope) {
	 $scope.directory = [{name:'The Handsome Heifer', cuisine:'BBQ'},
	                      {name:'Green\'s Green Greens', cuisine:'Salads'},
	                      {name:'House of Fine Fish', cuisine:'Seafood'}];

	  $scope.selectRestaurant = function(row) {
	    $scope.selectedRow = row;
	  };
	});

app.controller('PictureController', function ($scope) {
	$scope.showit=function(){
		$scope.yourpicture='me.jpg';
		$scope.picState = { show: true};
			
	}
	$scope.hideit=function(){
		$scope.yourpicture='me.jpg';
		$scope.picState = { show: false };
			
	}
	  
	});
app.controller('CartController',function($scope){
	
	$scope.bill = {};

	  $scope.items = [
	    {title: 'Paint pots', quantity: 1, price: 3.95},
	    {title: 'Polka dots', quantity: 10, price: 12.95},
	    {title: 'Pebbles', quantity: 5, price: 6.95}
	  ];

	  $scope.totalCart = function() {
	    var total = 0;
	    for (var i = 0, len = $scope.items.length; i < len; i++) {
	      total = total + $scope.items[i].price * $scope.items[i].quantity;
	    }

	    return total;
	  }

	  $scope.subtotal = function() {
	    return $scope.totalCart() - $scope.bill.discount;
	  };

	  function calculateDiscount(newValue, oldValue, scope) {
	    $scope.bill.discount = newValue > 100 ? 10 : 0;
	  }

	  $scope.$watch($scope.totalCart, calculateDiscount);
	
});

app.controller('SmcController',function($scope,$http,FetchdataService){
		
	/*FetchdataService.getStudents().then(function(data) {
	       //this will execute when the 
	       //AJAX call completes.
		$scope.students=data;
		alert(data);
	   });*/
	
		
		
		
	    $scope.addstudentform=function(){
		console.log('just switch');
		$scope.formremoveState = { show: false };
		$scope.formupdateState = { show: false};
		$scope.formlistState = { show: false };
		$scope.formState = { show: true };
		$scope.formupdatedisplayState={show:false};
			
	}
    $scope.removestudentform=function(){
    	
    	$scope.formState = { show: false };		
		$scope.formupdateState = { show:false };
		$scope.formlistState = { show: false };
		$scope.formremoveState = { show: true };
		$scope.formupdatedisplayState={show:false};
			
	}
    $scope.updatestudentform=function(){
    	var url="/RestfulStruts/rest";
    	console.log('inside student update');
    	$scope.students=$scope.initial;// clear the object first
    
    	FetchdataService.getStudents().success(function(data) {
 	       //this will execute when the 
 	       //AJAX call completes.
 	       $scope.students = data;
 	       console.log(data);
 	       
 	   });
        $scope.updateformdisplay=function(){
        	console.log('in updateformdisplay');
        	$scope.formState = { show: false };		
    		$scope.formupdateState = { show:false };
    		$scope.formlistState = { show: false };
    		$scope.formremoveState = { show: false };
    		$scope.formupdatedisplayState={show:true};
    	}
    	
    	$scope.formState = { show: false };
		$scope.formremoveState = { show: false };
		$scope.formlistState = { show: false };
		$scope.formupdateState = { show: true };
		$scope.formupdatedisplayState={show:true};
		
    }
    $scope.liststudents=function(){//window.location.reload();
    	//fetch the most recent data
    	alert("in list");    	
    	console.log("by data");    	
    	FetchdataService.getStudents().success(function(data) {
    	       //this will execute when the 
    	       //AJAX call completes.
    	       $scope.studentss = data;
    	       console.log(data);
    	       
    	   });

        //hide other views
    	$scope.formState = { show: false };
		$scope.formremoveState = { show: false };
		$scope.formupdateState = { show: false };
		$scope.formlistState = { show: true };
		$scope.formupdatedisplayState={show:false};
			
	}
  
    
});

app.controller('updateController', function ($scope,$http) {
	console.log('just added1');
	$scope.sendupdateform=function(){
		$scope.message_success_update={ text: null};
		$scope.message_error_update={ text: null};
		console.log($scope.Student);
		var url="/RestfulStruts/rest/students";
		var config={
				headers:{'Content-Type': 'application/x-www-form-urlencoded'}				
		};
		
		var data='studentId='+$scope.Student.Id+'&name='+$scope.Student.Name+'&major= '+$scope.Student.Major+'&country= '+$scope.Student.Country;
		$http.put(url,data,config).success(function(response){
		    console.log('data sent');
		    console.log(response);
		    $scope.students=null;
		    $scope.message_success_update={ text: 'The student was successfully updated'};
		}).error(function(data, status, headers, config) {
			console.log("data:"+data);
			console.log("status:"+status);
			console.log("headers"+headers);
			console.log("config"+config);
			 $scope.message_error_update={ text: data};
	       }
		);	
				 
	  
	}
	
	
	
});

app.controller('formsController', function ($scope,$http) {
	console.log('just added1');
		$scope.sendform = function() {
		$scope.message_success={ text: null};
		$scope.message_error={ text: null};
		console.log($scope.student);
		var url="/RestfulStruts/rest/students";
		var config={
				headers:{'Content-Type': 'application/x-www-form-urlencoded' }				
		};
		
		var data='studentId='+$scope.student.Id+'&name='+$scope.student.Name+'&major= '+$scope.student.Major+'&country= '+$scope.student.Country;
		$http.post(url,data,config).success(function(response){
		    console.log('data sent');
		    console.log(response);
		    $scope.students=null;
		    $scope.message_success={ text: 'The student was saved'};
		}).error(function(data, status, headers, config) {
			console.log("data:"+data);
			console.log("status:"+status);
			console.log("headers"+headers);
			console.log("config"+config);
			 $scope.message_error={ text: data};
	       }
		);	
				 
	  
	};});

