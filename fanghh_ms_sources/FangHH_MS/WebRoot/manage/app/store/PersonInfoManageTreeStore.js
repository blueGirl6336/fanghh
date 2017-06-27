Ext.define('HRMS.store.PersonInfoManageTreeStore', {
    extend: 'Ext.data.TreeStore',

    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            autoLoad: true,
            autoSync: true,
            storeId: 'MyTreeStore',
            defaultRootText: '人事管理系统',
            root: {
                expanded: true
            },
            proxy: {
                type: 'ajax',
                url: 'baseInfoMenu.json',
                reader: {
                    type: 'json'
                }
            },
            fields: [
                {
                    name: 'text'
                },
                {
                    name: 'id'
                }
            ]
        }, cfg)]);
    }
});