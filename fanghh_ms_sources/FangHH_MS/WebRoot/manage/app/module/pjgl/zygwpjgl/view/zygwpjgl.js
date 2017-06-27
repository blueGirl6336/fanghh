Ext.define('HRMS.module.pjgl.zygwpjgl.view.zygwpjgl', {
    extend: 'Ext.panel.Panel',
    initComponent: function () {
        Ext.apply(this, {
            closable: false,
            layout: 'border',
            autoScroll: false,
            title: '置业顾问评价',
            items: [{
                region: 'center',
                flex: 1,
                closable: false,
                border: 0,
                layout: 'fit',
                items: Ext.create('HRMS.module.pjgl.zygwpjgl.view.ConsultantCommentFromBroker')
            }]
        });
        this.callParent(arguments);
    }
});