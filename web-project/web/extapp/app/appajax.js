/**
 * 
 */


Ext.onReady(function(){
	
	Ext.Ajax.request({
		url : '/web-project/extServlet',
		method: 'GET',
		params : {
			b : 'user',
			firstName : 'Marco',
			lastName : 'Flores',
			age: 34
		},
		timeout : 50000,
		headers : {
			'Accept' : 'application/json'
		},		
		success : function(response,options){
			var data = Ext.decode(response.responseText);
			console.log('success function ' + data);
			
			var user = Ext.create('app.model.User',{
				firstName : data.firstName,
				lastName : data.lastName
			});
			user.set('age', data.age);
			user.set('status', 'Active');
			user.addresses().add(
				{id : 1, addressLine1 : 'Av Jorge Chavez 154', addressLine2 : 'Of 303' , zipCode : 'LIM'}, 
				{id : 2, addressLine1 : 'Av El Bosque', addressLine2 : 'Int 130' , zipCode : 'LIMA'}
			);
			user.set('social' , {
				website : 'http://user.com',
				twitter : 'https://twitter.com/user',
				facebook : 'https://facebook.com/user/user',
			});

			validate(user);
			
			 
			var userStore = Ext.create('app.store.Users');
			userStore.add([user]);
			console.log('User count : '+ userStore.count());
			console.log('User 1 : '+ userStore.getById('app.model.User-1'));
			
			var jsonencUser = Ext.encode(user.data);
			Ext.Msg.alert("Data " , "User retrieved : " + jsonencUser);
			
		},
		failure : function(response,options){
			Ext.Msg.alert('Error','failure with code : '  + response.status );
		},
		callback : function(options,success,response){
			console.log('callback executed, more stuff ');
		}
	});
	
});


function validate (user){
	if(user.isValid()){
		console.log('Valid object');
	}else{
		var errors =user.validate();
		errors.each(function (error){
			console.log(error.field, error.message);
		});
	}
} 