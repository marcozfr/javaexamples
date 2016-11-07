Ext.define('app.model.Product',{
	statics : {
		instanceCount : 0,
		nextId : function(){
			return this.instanceCount;
		}
	},
	id : 0,
	name : null,
	sku: null,
	constructor : function(config){
		Ext.apply(this,config || {});
		this.statics().instanceCount++;
		this.id = this.statics().nextId();
		console.log('created class ' + this.name + ' and sku:' + this.sku + " and id:"+this.id);
	},
	toInventory : function(){
		console.log(this.name + ' being moved to inventory with sku: '+this.sku);
	}
});