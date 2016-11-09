Ext.Loader.setConfig({
	enabled :true,
	paths: {
		App : 'app'
	}
});

Ext.onReady(function(){

	Ext.create('Ext.container.Viewport',{
		padding : '5px',
		layout : 'auto',
		style : {
			'background-color' : '#ccc',
			'color' : '#000'
		},
		html : 'This is an application area'

	});

	Ext.create('Ext.panel.Panel',{
		renderTo : Ext.getBody(),
		title : 'App Panel',
		width : 300,
		height : 200,
		html : '<b>Critical content</b>'
	});

	// Ext.create('Ext.window.Window',{
	// 	title : 'App Window',
	// 	width : 300,
	// 	height : 200,
	// 	maximizable : true,
	// 	closable : true,
	// 	html : 'Custom Window'
	// }).show();


	Ext.create('Ext.panel.Panel', {
		width : 500,
		height: 300,
		title : 'Border Layout',
		layout : 'border',
		items: [
			{
				xtype: 'panel',
				title : 'South region is rezisable',
				region : 'south',
				height: 100,
				split : true
			},
			{
				xtype: 'panel',
				title : 'West region',
				region : 'west',
				width: 200,
				collapsible: true,
				layout : 'fit',
				split : true
			},
			{
				title : 'Center region',
				region : 'center',
				layout : 'fit',
				margin : '5 5 0 0',
				html : '<b>Main content</b> goes here'
			}
		],
		renderTo : Ext.getBody()
	});

	var win = Ext.create('Ext.window.Window',{
		layout : 'card',
		title  : 'card window',
		height: 300,
		width : 200,
		maximizable : true,
		defaults : {
			xtype : 'panel',
			height : 60,
			border : false
		},
		items : [
			{
				title : 'Menu',
				html : 'Main menu'
			},
			{
				title : 'Content',
				html: 'Main content'
			}
		]
	});
	// win.show();	

	// setTimeout(function(){
	// 	win.getLayout().setActiveItem(1);
	// },3000);

	var accwin = Ext.create('Ext.window.Window',{
		title : 'Accordion window',
		width : 300,
		height : 200,
		maximizable : true,
		layout : 'accordion',
		defaults: {
			xtype : 'panel'
		},
		items: [
			{
				title : 'Menu', html : 'Main menu'
			},
			{
				title : 'Content', html : 'Main content'
			},
			{
				title : '3rd panel', html : 'Content here.'
			}
		]
	}).show();

	Ext.create('Ext.window.Window',{
		title : 'Anchor window',
		width : 300,
		height : 300,
		maximizable : true,
		layout : 'anchor',
		defaults: {
			xtype : 'panel' , height : 60, border : false
		},
		items: [
			{
				title : 'Menu', 
				html : 'Main menu',
				anchor : '-10'
			},
			{
				title : 'Content', 
				html : 'Main content',
				anchor : '70%'
			},
			{
				title : '3rd panel', 
				html : 'Content here.',
				anchor : '50% 40%',
				bodyStyle : 'background-color : #f3c;'
			}
		]
	}).show();



});