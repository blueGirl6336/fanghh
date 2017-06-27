Ext.define('HRMS.module.pjgl.jjrpjgl.view.jjrpjgl', {
    extend: 'Ext.panel.Panel',
    initComponent: function () {
        Ext.apply(this, {
            closable: false,
            layout: 'border',
            autoScroll: false,
            title: '经纪人评价',
            items: [{
                region: 'center',
                flex: 1,
                closable: false,
                border: 0,
                layout: 'fit',
                items: Ext.create('HRMS.module.pjgl.jjrpjgl.view.BrokerCommentFromConsultant')
            }]
        });
        this.callParent(arguments);
    }
});