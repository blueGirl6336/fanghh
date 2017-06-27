Ext.define('HRMS.module.yhgl.zygwgl.view.zygwgl', {
    extend: 'Ext.panel.Panel',
    initComponent: function () {
        Ext.apply(this, {
            closable: false,
            layout: 'border',
            autoScroll: false,
            title: '',
            items: [{
                region: 'center',
                flex: 2,
                closable: false,
                border: 0,
                layout: 'fit',
                items: Ext.create('HRMS.module.yhgl.zygwgl.view.BaseInfo')
            }]
        });
        this.callParent(arguments);
    }
});