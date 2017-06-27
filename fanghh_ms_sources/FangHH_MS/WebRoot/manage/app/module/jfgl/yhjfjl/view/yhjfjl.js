Ext.define('HRMS.module.jfgl.yhjfjl.view.yhjfjl', {
    extend: 'Ext.panel.Panel',
    initComponent: function () {
        Ext.apply(this, {
            closable: false,
            layout: 'border',
            autoScroll: false,
            title: '用户积分记录',
            items: [{
                region: 'center',
                flex: 1,
                closable: false,
                border: 0,
                layout: 'fit',
                items: Ext.create('HRMS.module.jfgl.yhjfjl.view.IntegralRecord')
            }]
        });
        this.callParent(arguments);
    }
});