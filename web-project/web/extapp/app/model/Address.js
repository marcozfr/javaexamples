Ext.define('app.model.Address',{
	extend : 'Ext.data.Model',
	idProperty : 'id',
	fields :[
         {
        	 name : 'id',
        	 type : 'int'
         },
	     {
	    	 name :  'addressLine1' , 
	    	 type : 'string'
	     },{
	    	 name :  'addressLine2' , 
	    	 type : 'string'
	     },{
	    	 name : 'zipCode',
	    	 type : 'string'
	     }
	],
	validators : {
		zipCode : [
           {
        	   type : 'length',
        	   min : 3,
        	   max : 3
           }
		]
	} 
});