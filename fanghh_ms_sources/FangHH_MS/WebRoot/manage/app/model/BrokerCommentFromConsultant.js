Ext.define('HRMS.model.BrokerCommentFromConsultant', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'bcfcId',
		type : 'int'
	}, {
		name : 'broker'
	}, {
		name : 'homeConsultant'
	}, {
		name : 'orderId'
	}, {
		name : 'entireComment'
	}, {
		name : 'customerQualityComment',
		type : 'int'
	}, {
		name : 'expertiseLevelComment',
		type : 'int'
	}, {
		name : 'commentWriting'
	}, {
		name : 'commentCheckStatus'
	},{
		name : 'commentTime',
		type : 'date'
	}, {
		name : 'replyContent'
	},{
		name : 'replyCheckStatus'
	},{
		name : 'replyTime',
		type : 'date'
	}]
});
