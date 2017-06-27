Ext.define('HRMS.module.gzgl.fxfxgzgl.view.fxfxgzgl', {
    extend: 'Ext.panel.Panel',
    initComponent: function () {
        Ext.apply(this, {
            closable: false,
            layout: 'border',
            autoScroll: false,
            title: '添加开发商信息',
            items: [{
                region: 'center',
                flex: 1,
                closable: false,
                border: 0,
                layout: 'fit',
                items: Ext.create('HRMS.module.gzgl.fxfxgzgl.view.ShareInfo')
            }]
        });
        this.callParent(arguments);
    }
});