Ext.define('HRMS.view.MenuPanel', {
	extend : 'Ext.panel.Panel',
	alias : 'widget.mainmenu',
	border:0,
	initComponent : function() {
		Ext.apply(this, {
			region : 'west',
			layout: {
                type: 'accordion'
            }
		});
		this.callParent(arguments);
	},
	addMenuTreePanel : function(moduleNode) {
		var me = this;
		if (moduleNode == null)
			return;
		var treeStore = Ext.create('HRMS.store.MenuTreeStore', {
			root : moduleNode
		});
		var tree = Ext.create('HRMS.view.MenuTree', {
			store : treeStore,
			title : moduleNode.data.text
		});
		me.add(tree);
	},
	initMenuPanel : function(rootNode) {
		var length = rootNode.childNodes.length;
		for ( var i = 0; i < length; i++) {
			// XXX 次数有疑问 rootNode 每次获取后，都会莫名奇妙remove掉，所以一直都取第一个元素
			var childNode = rootNode.childNodes[0];
			this.addMenuTreePanel(childNode);
		}
	}
	
	
});
