//个人简历 store
Ext.define('HRMS.store.report.ResumeStore', {
	extend : 'Ext.data.Store',
	model : 'HRMS.model.Resume',
	autoLoad : false,
	proxy : {
		type : 'ajax',
		url: '../report/resume/getByEmpNoList',
		reader : {
			type : 'json',
			root : 'data',
			successProperty : 'success'
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

});