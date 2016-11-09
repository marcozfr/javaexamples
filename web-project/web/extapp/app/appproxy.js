Ext.onReady(function(){
	var store = Ext.create('app.store.Users');
	store.load(function(records,operation,success){ // callback
		console.log('loaded records');
//		Ext.each(records, function(record,index,records){
//			var enc = Ext.encode(record.data);
//			console.log('User: ' + enc);
//		});
		
		var newUser = Ext.create('app.model.User',{
			id : 6,
			firstName : 'Brandy',
			lastName : 'Watts',
			age : 32,
			status : 'Active',
			listeners : {
				'logout' : function(userFirstName, quitDate, param, paramb, paramc) {
					console.log('Event logout launched');
					console.log('Employee:' + userFirstName);
					console.log('Date:' + Ext.util.Format.date(quitDate,'Y-m-d H:i'));
					console.log('Param :' + param);
					console.log('Param B:' + paramb);
					console.log('Param C:' + paramc);
				}
			}
		});
		
		store.add(newUser);
		
		var userEdit = store.getAt(0);
		userEdit.beginEdit();
		userEdit.set('lastName','Lewis');
		userEdit.endEdit();
		
		var userDelte = store.getAt(1);
		store.remove(userDelte);
		
		store.each(function(record, index){
			console.log(index,Ext.encode(record.data));
		});
		
	});
	
	
	
});