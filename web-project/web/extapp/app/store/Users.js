Ext.define('app.store.Users',{
	extend : 'Ext.data.Store',
	model : 'app.model.User',
	proxy : {
		type : 'ajax',
		url : '/web-project/extServlet?b=get',
		api : {
			read : '/web-project/extServlet?b=get',
			create : '/web-project/extServlet?b=add'
//			update : 'serverside/process.php?action=update',
//			destroy : 'serverside/process.php?action=destroy'
		},
		reader : {
			type : 'json' // json xml or array
//			,rootProperty : 'records'
		},
		writer : {
			type : 'json',
			encode: true, // encode data before sending
//			rootProperty : 'paramProcess',
			allowSingle : false,
			writeAllFields : true,
			root : 'records'
		},
		actionMethods : {
			create : 'POST',
			read : 'GET',
//			update: 'POST',
//			destroy: 'POST'
		}
	}
});