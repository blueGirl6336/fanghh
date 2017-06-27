Ext.define('HRMS.module.yhgl.jjrjtd.view.jjrjtd', {
    extend: 'Ext.panel.Panel',
    initComponent: function () {
        Ext.apply(this, {
            closable: false,
            layout: 'border',
            autoScroll: false,
            title: '经纪人及团队',
            items: [{
                region: 'center',
                flex: 1,
                closable: false,
                border: 0,
                layout: 'fit',
                items: Ext.create('HRMS.module.yggl.jjrjtd.view.BrokerAndGroup')
            }]
        });
        this.callParent(arguments);
    }
});