Ext.define('app.fields.Status',{
	extend: 'Ext.data.field.String', // Step 1
	alias: 'data.field.status',// Step 2
	validators: {// Step 3
		type: 'inclusion',
		list: [ 'Active', 'Inactive'],
		message: 'Is not a valid status value, please select the proper options [Active, Inactive]'
	}
});