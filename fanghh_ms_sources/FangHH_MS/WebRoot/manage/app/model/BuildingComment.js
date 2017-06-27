Ext.define('HRMS.model.BuildingComment', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'commentId',
		type : 'int'
	}, {
		name : 'user'
	}, {
		name : 'homeConsultant'
	}, {
		name : 'building'
	}, {
		name : 'entireComment',
		type : 'int'
	}, {
		name : 'priceComment',
		type : 'int'
	}, {
		name : 'locationComment',
		type : 'int'
	}, {
		name : 'facilitiesComment',
		type : 'int'
	}, {
		name : 'trafficComment',
		type : 'int'
	}, {
		name : 'environmentComment',
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
	},{
		name : 'isEssence',
		type : 'boolean'
	}]
});
