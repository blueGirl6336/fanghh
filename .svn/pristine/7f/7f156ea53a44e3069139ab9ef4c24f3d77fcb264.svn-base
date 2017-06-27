Ext.define('HRMS.module.lpgl.kfsgl.view.kfsgl', {
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
                items: Ext.create('HRMS.module.lpgl.kfsgl.view.DeveloperInfo')
            }, {
              
                region: 'south',
                flex: 1,
                border: 0,
                header: false,
                title: null,
                collapseMode : 'mini',
                layout: 'fit',
                collapsible: true,
                split:true,
                items: Ext.create('HRMS.module.lpgl.kfsgl.view.DeveloperTabPanel')
            }]
        });
        this.callParent(arguments);
    }
});