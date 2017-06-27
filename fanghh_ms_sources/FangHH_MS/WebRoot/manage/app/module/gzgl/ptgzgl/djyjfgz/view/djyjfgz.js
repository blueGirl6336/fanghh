Ext.define('HRMS.module.gzgl.ptgzgl.djyjfgz.view.djyjfgz', {
    extend: 'Ext.panel.Panel',
    initComponent: function () {
        Ext.apply(this, {
            closable: false,
            layout: 'border',
            autoScroll: false,
            title: '等级与积分规则',
            items: [{
                region: 'center',
                flex: 1,
                closable: false,
                border: 0,
                layout: 'fit',
                items: Ext.create('HRMS.module.gzgl.ptgzgl.djyjfgz.view.IntegralLevel')
            }]
        });
        this.callParent(arguments);
    }
});