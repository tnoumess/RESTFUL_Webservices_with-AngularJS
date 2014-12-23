var app = angular.module('myApp', []);
app.controller('GetController', function ($scope, $http) {
	  
    var url="http://localhost:8080/RestfulStruts/rest/v1/status";
       
   
       $http.get(url).success(function(response){alert("in");
       $scope.students=response;	
       	
       }).error(function(data, status, headers, config) {
       	 alert("error");
       });
});

app.factory('FetchdataController',function(){ 
	scope.students=studentss;
	
	var studentss=function ($scope, $http) {
	  
    var url="http://localhost:8080/RestfulStruts/rest/v1/status";
       
   
       $http.get(url).success(function(response){alert(response);
      // $scope.studentss=response;
       alert(response);
       return response;
      
       }).error(function(data, status, headers, config) {
       	 alert("error");
       	 return "null";
       });
}
});

app.controller('greetingController', function ($scope) {
  $scope.greeting = { text: 'Hello' };
});

app.controller('formController', function ($scope) {
	 $scope.form={};
	
	 $scope.display=function(){alert($scope.form.id)}
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

app.controller('SmcController',function($scope){
	//formremoveState.show=false;
	//alert("5551");	
	$scope.addstudentform=function(){
		console.log('just switch');
		$scope.formremoveState = { show: false };
		$scope.formupdateState = { show: false};
		$scope.formlistState = { show: false };
		$scope.formState = { show: true };
			
	}
    $scope.removestudentform=function(){
    	
    	$scope.formState = { show: false };		
		$scope.formupdateState = { show:false };
		$scope.formlistState = { show: false };
		$scope.formremoveState = { show: true };
			
	}
    $scope.updatestudentform=function(){
    	
    	$scope.formState = { show: false };
		$scope.formremoveState = { show: false };
		$scope.formlistState = { show: false };
		$scope.formupdateState = { show: true };
		
    }
    $scope.liststudents=function(){
		
    	$scope.formState = { show: false };
		$scope.formremoveState = { show: false };
		$scope.formupdateState = { show: false };
		$scope.formlistState = { show: true };
			
	}
  
    
});

app.controller('formsController', function ($scope,$http) {
	console.log('just added1');
      $scope.sendform=function(){
		console.log('just added2');
		alert("inform");
	    	
				
		}
	  
	});

