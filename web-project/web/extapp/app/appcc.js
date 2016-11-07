Ext.define('App.sample.CustomComponent',{
	extend: 'Ext.Component',
	initComponent: function(){
		var me = this;
		me.width = 200;
		me.height = 100;
		me.html = {
			tag: 'div',
			html: 'X',
			style: { // this can be replaced by a CSS rule
				'float': 'right',
				'padding': '10px',
				'background-color': '#e00',
				'color': '#fff',
				'font-weight': 'bold',

				'cursor': 'pointer'
			}
		};
		me.myOwnProperty = [1,2,3,4];
		me.callParent();
		console.log('Step 1. initComponent');
	},
	beforeRender: function(){
		console.log('Step 2. beforeRender');
		this.callParent(arguments);
	},
	onRender: function(){
		console.log('Step 3. onRender');
		this.callParent(arguments);
		this.el.setStyle('background-color','#ccc');
	},
	afterRender : function(){
		console.log('4. afterRender');
		this.el.down('div').on('click',this.myCallback,this);
		this.callParent(arguments);
	},
	beforeDestroy : function(){
		console.log('5. beforeDestroy');
		this.callParent(arguments);
	},
	onDestroy : function(){
		console.log('6. onDestroy');
		delete this.myOwnProperty;
		this.el.down('div').un('click',this.myCallback);
		this.callParent(arguments);
	},
	myCallback : function(){
		var me = this;
		Ext.Msg.confirm('Confirmation','Are you sure you want to close this panel?',function(btn){
			if(btn === 'yes'){
				me.destroy();
			}
		});
	}
});



Ext.define('App.sample.MyContainer',{
	extend: 'Ext.container.Container',
	border: true,
	padding: 10,
	initComponent : function(){
		var me = this;
		Ext.each(me.items, function (item){
			item.style = {
				backgroundColor : '#f4f4f4',
				border : '1px dotted #333'
			};
			item.padding = 10;
			item.height = 100;
		});
		me.callParent();
	},
	onRender : function(){
		var me = this;
		me.callParent(arguments);
		if(me.border){
			me.el.setStyle('border','2px solid #333');
		}
	}
}
);

Ext.onReady(function(){
	Ext.create('App.sample.CustomComponent', {
		renderTo : Ext.getBody()
	});

	Ext.create('Ext.panel.Panel',{
		height : 100,
		width : 200,
		title : 'App Panel',
		renderTo : Ext.getBody(),
		closable: true
	});


	Ext.create('App.sample.MyContainer',{
		renderTo : Ext.getBody(),
		defaults : {
			xtype : 'component',
			width : 100
		},
		items : [
			{
				//xtype : 'component',
				html : 'Child component one'
			},
			{
				//xtype : 'component',
				html : 'Child component two'
			}
		]
	});


});