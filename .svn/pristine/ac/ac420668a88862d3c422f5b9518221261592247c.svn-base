Ext.define('HRMS.store.dictionary.CityStore', {
    extend: 'Ext.data.Store',
    model: 'HRMS.model.City',
    storeId: 'city',
    autoLoad: true,
    proxy : {
		type : 'ajax',
		//在每个子类中设置该属性
		url:  'city/getAll',
		reader : {
			type : 'json',
			root : 'data',
			successProperty : 'success'
		},
		//在每个子类中设置该属性
	    extraParams: {
	    	//department:''
	    },
	    actionMethods:{read:'POST'},
		listeners : {
			exception : function(proxy, response, operation) {
				Ext.MessageBox.show( {
					title : '错误',
					msg: proxy.reader.rawData.message,
					icon : Ext.MessageBox.ERROR,
					buttons : Ext.Msg.OK
				});
			}
		}
	}
});