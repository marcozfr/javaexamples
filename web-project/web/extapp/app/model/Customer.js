Ext.define('app.model.Customer',{
	config :{
		countryISO : null,
		contact : 'Unknown',
		mainAddress : 'Unknown',
		phone : null
	},
	constructor : function(config){
		this.initConfig(config);
		console.log('created customer '+this.getContact() + ' country: '+ this.getCountryISO());
	},

	applyCountryISO : function(countryISO){
		if(countryISO === App.sample.Util.defaultCountryISO){
		// if(countryISO === 'PE'){
			this.setMainAddress('Lima');	
		}
		return countryISO;
	}

});