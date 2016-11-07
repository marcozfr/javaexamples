Ext.define('app.model.SocialInfo', {
	extend : 'Ext.data.Model',
	idProperty : 'id ',
	fields : [ {
		name : 'website',
		type : 'string'
	}, {
		name : 'twitter',
		type : 'string'
	}, {
		name : 'facebook',
		type : 'string'
	} ]
});