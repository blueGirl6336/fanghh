Ext.define('HRMS.module.yhgl.yhsmrz.view.yhsmrz', {
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
                items: Ext.create('HRMS.module.yhgl.yhsmrz.view.BaseInfo')
            }/*, {
              
                region: 'south',
                flex: 1,
                border: 0,
                header: false,
                title: null,
                collapseMode : 'mini',
                layout: 'fit',
                collapsible: true,
                split:true,
                items: Ext.create('HRMS.module.yhgl.yhsmrz.view.OtherInfoTabPanel')
            }*/]
        });
        this.callParent(arguments);
    }
});