Ext.define('HRMS.store.personnel.ArchiveForShowStore', {
	extend : 'Ext.data.Store',
	model : 'HRMS.model.ArchiveForShow',
	constructor : function(cfg) {
		var me = this;
		cfg = cfg || {};
		me.callParent([ Ext.apply({
			autoLoad : false,
			proxy : {
				type : 'ajax',
				api : {
					read : 'archive/search'
				},
				reader : {
					type : 'json',
					root : 'data',
					successProperty : 'success'
				},
				extraParams : {
					departmentCode : '1'
				},
				writer : {
					type : 'json',
					writeAllFields : true,
					encode : false,
					allowSingle : false
				},
				listeners : {
					exception : function(proxy, response, operation) {
						Ext.MessageBox.show({
							title : '错误',
							msg : proxy.reader.rawData.message,
							icon : Ext.MessageBox.ERROR,
							buttons : Ext.Msg.OK
						});
					}
				}

			}
		}, cfg) ]);
	}
});