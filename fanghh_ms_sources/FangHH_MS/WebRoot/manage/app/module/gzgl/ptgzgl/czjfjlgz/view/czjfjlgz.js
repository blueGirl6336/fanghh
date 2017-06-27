Ext.define('HRMS.module.gzgl.ptgzgl.czjfjlgz.view.czjfjlgz', {
    extend: 'Ext.panel.Panel',
    initComponent: function () {
        Ext.apply(this, {
            closable: false,
            layout: 'border',
            autoScroll: false,
            title: '操作积分奖励规则',
            items: [{
                region: 'center',
                flex: 1,
                closable: false,
                border: 0,
                layout: 'fit',
                items: Ext.create('HRMS.module.gzgl.ptgzgl.czjfjlgz.view.IntegralRule')
            }]
        });
        this.callParent(arguments);
    }
});