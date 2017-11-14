'use strict';

angular.module('myApp').controller('UserController', ['$scope', 'UserService', function ($scope, UserService) {
    var self = this;
    self.user = {initialVelocity: null, finalVelocity:null, acceleration:null, distance:null, time:null };
    self.showData = {iniVelocity:null, finVelocity:null, acc:null, dist:null,tim:null};
    self.data =null;
    self.errorMessage = null
    self.submit = submit;
    self.reset = reset;
    self.items = [{id:1, label:'Initial Velocity'}, {id:2, label:'Final Velocity'}, {id:3, label:'Acceleration'}, {id:4, label:'Distance'}, {id:5, label:'Time'}];
    self.selectedItem=self.items[0];
    self.showFields =showFields;
    
    self.fieldCount =0;
    
  
 
   
    function calculateOutput(user) {
        UserService.calculateOutput(user)
            .then(
            	function (d) {
            		console.log('data recieved in controller js',d.finalVelocity);
                         self.data= d;
                     },
                function (errResponse) {
                    console.error('Inside errResponse ctrl');
                    console.error('Error executing rest service');
                    console.log('java error message' + errResponse.data.message);
                    
                    self.errorMessage = errResponse.data.message;
                }
            );
    }

    

    function submit() {
    	   console.log('submitting data in controller', self.user.initialVelocity);
    	   console.log('submitting data in controller acceleration', self.user.acceleration);
    	   self.errorMessage = null;
    	   calculateOutput(self.user);  
    	   self.data =null;
    }
    
    
    
    function reset() {
    	console.log('reset');
    	console.log('showFields');
        self.user = {initialVelocity: null, finalVelcocity:null, acceleration:null, distance:null,time:null};
        self.errorMessage = null;
        self.data =null;
        self.showData = {iniVelocity:null, finVelocity:null, acc:null, dist:null,tim:null};
        self.fieldCount =0;
        $scope.myForm.$setPristine(); //reset Form
        
    }
    
    
    function showFields(){
    	console.log('showFields');
    	if(self.selectedItem.id == 1){
    		
    		if(self.showData.iniVelocity == null){
    			
    			self.showData.iniVelocity = 'true';
        		self.fieldCount =self.fieldCount +1;
        		console.log('self.showData.iniVelocity',self.showData.iniVelocity);
        		console.log('self.fieldCount',self.fieldCount);
    		}
    	
    		
    	}else if(self.selectedItem.id == 2){
    		
    		if(self.showData.finVelocity == null){
    			
    			self.showData.finVelocity = 'true';
        		self.fieldCount =self.fieldCount +1;
        		console.log('self.showData.finVelocity',self.showData.finVelocity);
        		console.log('self.fieldCount',self.fieldCount);
    		}
    	    		
    	}else if(self.selectedItem.id == 3){
    		
    		if(self.showData.acc == null){
    			
    			self.showData.acc = 'true';
        		self.fieldCount =self.fieldCount +1;
        		console.log('self.showData.acc',self.showData.acc);
        		console.log('self.fieldCount',self.fieldCount);
    		}
    		
    		
    	}else if(self.selectedItem.id == 4){
    		
    		if(self.showData.dist == null){
    			
    			self.showData.dist = 'true';
        		self.fieldCount =self.fieldCount +1;
        		console.log('self.showData.dist',self.showData.dist);
        		console.log('self.fieldCount',self.fieldCount);
    		}
    		
    	}else if(self.selectedItem.id == 5){
    		
    		if(self.showData.tim == null){
    			
    			self.showData.tim = 'true';
        		self.fieldCount =self.fieldCount +1;
        		console.log('self.showData.tim',self.showData.tim);
        		console.log('self.fieldCount',self.fieldCount);
    		}
    		
    		
    	}
    }   
     	
    	
    	
    
    
    

}]);