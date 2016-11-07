Ext.Loader.setConfig({
	enabled :true,
	paths: {
		App : 'App'
	}
});

Ext.require(['App.sample.Util']);

Ext.define('App.sample.indoorProduct',{
	setIndoorLocation : function(location){
		console.log('setting indoor location: ' + location);
	}
});

Ext.define('App.sample.outdoorProduct',{
	extend : 'Ext.Mixin',
	mixinConfig : {
		before : {
			behavior : 'cleanLocation'
		},
		after: {
			behavior : 'takePhoto'
		}
	},
	setOutdoorLocation : function(location){
		console.log('setting outdoor location: ' + location);
	},

	cleanLocation : function(){
		console.log('clean before moving object');
	},

	takePhoto : function(){
		console.log('take photo, just to show off');
	}
});

Ext.define('App.sample.multipurposeProduct',{
	setLocation: function(location){
		console.log('setting locations: ' + location);
	}
});

Ext.define('App.sample.WoodenProduct',{
	extend : 'App.sample.Product',
	mixins: {
		indoors : 'App.sample.indoorProduct',
		outdoors : 'App.sample.outdoorProduct'
	},
	behavior : function(location){
		if(location === 'outdoors'){
			this.mixins.outdoors.setOutdoorLocation(location);
		}

		if(location === 'indoors'){
			this.mixins.indoors.setIndoorLocation(location);	
		}
	}
});

Ext.define('App.sample.GenericPanel',{
	extend : 'Ext.panel.Panel',
	alias : ['widget.customerPanel' , 'widget.productPanel' ],
	alternateClassName: 'customGenericPanel',
	title : 'Panel',
	html : 'Info'
});

Ext.onReady(
	function(){
		//alert('Ext app');
		// var customer1 = Ext.create('App.sample.Customer', 
		// 	{contact : 'John Doe', countryISO : 'PE', mainAddress : 'Arequipa', phone : 992611355});
		// Ext.Msg.alert('Customer Lookup', customer1.getContact() + '|' +customer1.getCountryISO() + '|' +customer1.getMainAddress());

		var c1 = Ext.create('App.sample.Customer' , {
			contact : 'John Doe', countryISO : 'PE'
		});

		var p1 = Ext.create('App.sample.Product' , {
			name : 'Ancient Wardrobe', sku : '#9000121'
		});

		var p2 = Ext.create('App.sample.Product' , {
			name : 'Baby basinet', sku : '#9000112'
		});

		var p3 = Ext.create('App.sample.Product' , {
			name : 'kitchen sink', sku : '#9000141'
		});

		console.log('Instance count : ' + App.sample.Product.instanceCount);
		console.log('item 2 : ' + p2.id);

		Ext.create('widget.customerPanel',{
			title: c1.getContact(),
			height:250,
			width:450,
			renderTo: Ext.getBody()
		});

		Ext.widget('productPanel',{
			title: p1.name,
			height:250,
			width:450,
			renderTo: Ext.getBody()
		});

		// Ext.Msg.alert('Created', 'Product created with name'.concat(myproduct.name));

		// Ext.Msg.confirm('Confirmation','Proceed?',function(btn){
		// 	if(btn=='yes'){
		// 		Ext.Msg.alert('Good', 'Good answer');
		// 	}else{
		// 		Ext.Msg.alert('Bad','Unexpected');
		// 	}
		// });
	}
);

//Ext way
// Ext.application({
// 	name: 'Ext App',
// 	launch: function(){
// 		Ext.Msg.alert('Hi', 'Ext first app');
// 	}
// });