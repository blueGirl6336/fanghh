Ext.define('HRMS.model.Broker', {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'brokerId',
		type : 'int'
	}, {
		name : 'user'
	}, {
		name : 'brokerTeam'
	}, {
		name : 'brokerName'
	}, {
		name : 'brokerIdcard'
	}, {
		name : 'brokerType'
	}, {
		name : 'invitationCode'
	}, {
		name : 'store'
	}]
});