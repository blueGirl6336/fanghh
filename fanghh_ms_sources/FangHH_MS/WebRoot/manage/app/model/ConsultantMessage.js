Ext.define('HRMS.model.ConsultantMessage', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'messageId',
		type : 'int'
	}, {
		name : 'salesDirector'
	}, {
		name : 'homeConsultant'
	}, {
		name : 'messageTitle'
	}, {
		name : 'messageContent'
	}, {
		name : 'messageStatus'
	}, {
		name : 'modifyTime',
		type : 'date'
	}]
});
