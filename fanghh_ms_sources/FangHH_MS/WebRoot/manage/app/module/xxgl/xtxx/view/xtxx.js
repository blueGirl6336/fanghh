Ext.define('HRMS.module.xxgl.xtxx.view.xtxx', {
    extend: 'Ext.panel.Panel',
    initComponent: function () {
        Ext.apply(this, {
            closable: false,
            layout: 'border',
            autoScroll: false,
            title: '系统消息',
            items: [{
                region: 'center',
                flex: 1,
                closable: false,
                border: 0,
                layout: 'fit',
                items: Ext.create('HRMS.module.xxgl.xtxx.view.PushNews')
            }]
        });
        this.callParent(arguments);
    }
});