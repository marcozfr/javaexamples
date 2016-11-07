/**
 * 
 */
Ext.define('app.model.User', {
	requires : ['app.fields.Status','app.model.Address', 'app.model.SocialInfo'],
	extend : 'Ext.data.Model',
	idProperty : 'id',
	mixins : {observable : 'Ext.util.observable'},
	constructor : function(config){
		this.mixins.observable.constructor.call(this,config);
	},
	logout : function(){
		this.fireEvent('logout',this.get('firstName'), new Date(), 2, 1, 'more params...');
	},
	fields : [ {
		name : 'firstName',
		type : 'string'
	}, {
		name : 'surName',
		type : 'string',
		mapping : 'lastName'
	}, {
		name : 'age',
		type : 'int'
	}, {
		name : 'status',
		type : 'status'
	},{
		name : 'social',
		reference : 'SocialInfo',
		unique : true
	} ],
	hasMany : {
		model : 'app.model.Address',
		name : 'addresses',
		associationKey : 'addresses'
	},
	validators : {
		age : [ {
			type : 'presence'
		} ],
		firstName : [ {
			type : 'length',
			min : 1,
			max : 10
		} ]
	}
});