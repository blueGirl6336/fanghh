Ext.define('HRMS.module.pjgl.lppjgl.view.lppjgl', {
    extend: 'Ext.panel.Panel',
    initComponent: function () {
        Ext.apply(this, {
            closable: false,
            layout: 'border',
            autoScroll: false,
            title: '楼盘评价',
            items: [{
                region: 'center',
                flex: 1,
                closable: false,
                border: 0,
                layout: 'fit',
                items: Ext.create('HRMS.module.pjgl.lppjgl.view.BuildingComment')
            }]
        });
        this.callParent(arguments);
    }
});