Ext.define('HRMS.module.rsgl.rsjbxx.xxjs.view.QueryEdit', {
    extend: 'Ext.panel.Panel',
    alias: 'widget.queryEdit',
    initComponent: function () {
        Ext.apply(this, {
            closable: false,
            autoScroll: true,
            layout: {
                type: 'hbox',
                align: 'stretch'
            },
            title: '查询条件',
            items: [{
                    xtype: 'panel',
                    width: 510,
                    border: 0,
                    layout: {
                        type: 'border'
                    },
                    items: [
                        {
                        	region: 'center',
                        	flex:2,
                        	border: 0,
                            layout: {
                                type: 'hbox',
                                align: 'stretch'
                            },
                            title: '独立条件',
                            items: [
                                Ext.create('HRMS.module.rsgl.rsjbxx.xxjs.view.QueryItemChoice'),
                                Ext.create('HRMS.module.rsgl.rsjbxx.xxjs.view.QuerySymbolChoice'),
                                Ext.create('HRMS.module.rsgl.rsjbxx.xxjs.view.QueryValueChoice')
                            ]


                        }, {
                        	region: 'south',
                        	margin: '5 0 0 0',
                        	flex:1,
                        	border: 0,
                            layout: {
                                type: 'fit'
                            },
                            title: '组合条件',
                            items: [
                                Ext.create('HRMS.module.rsgl.rsjbxx.xxjs.view.CombinedQueryInQueryPage')
                            ]
                        }
                    ]

                },

                {
                    xtype: 'panel',
                    border: 0,
                    layout: {
                        type: 'vbox',
                        align: 'center'
                    },
                    items: [
                        {
                        	xtype: 'button',
                            text: '>>',
                            margin: '1 2 1 2',
                            action: 'addQuery',
                            flex : 1
                        }, {
                        	xtype: 'button',
                            text: '<<',
                            margin: '1 2 1 2',
                            action: 'deleteQuery',
                            flex : 1
                        }
                    ]
                    
                },
                Ext.create('HRMS.module.rsgl.rsjbxx.xxjs.view.QueryBeanList')
            ],
            dockedItems: [{
                xtype: 'toolbar',
                dock: 'top',
                items: [{
                    xtype: 'button',
                    text: '添加条件',
                    action: 'addQuery'
                }, {
                    xtype: 'button',
                    text: '刷新条件列表',
                    action: 'refreshQuery'
                }, 
//                {
//                    xtype: 'button',
//                    text: '移除选中条件',
//                    action: 'deleteQuery'
//                }, 
                {
                    xtype: 'button',
                    text: '清空所有',
                    action: 'removeAll'
                }, {
                    xtype: 'button',
                    text: '查询',
                    action: 'doQuery'
                }, '|', {
                    xtype: 'button',
                    text: '保存',
                    disabled: true,
                    action: 'saveConfig'
                }]
            }]
        });
        this.callParent(arguments);
    }
});