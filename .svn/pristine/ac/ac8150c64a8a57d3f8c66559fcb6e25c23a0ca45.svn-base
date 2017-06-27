Ext.define('HRMS.module.lpgl.ldxxgl.view.House', {
	extend : 'Ext.grid.Panel',
	alias: 'widget.researchAchvView',
	layout : 'fit',
	title : '房屋信息',
	border : 0,
	unit : 0,
	closable : false,
	enableColumnHide : false,
	enableColumnMove : false,
	enableLocking : false,
	initComponent : function() {
		var me = this;
		me.store = Ext.create('HRMS.store.building.HouseStore');
		me.cellEditing = new Ext.grid.plugin.CellEditing({
			clicksToEdit : 2
		});
		me.columns = [ {
			xtype : 'rownumberer',
			width : 40
		}, {
			xtype : 'mycolumn',
			width : 110,
			dataIndex : 'id',
			text : '编号',
			hidden:true
		}, {
			xtype : 'mycolumn',
			editable : false,
			width : 110,
			align : 'center',
			dataIndex : 'houseStyleCode',
			text : '房屋样式',
			renderer : me.houseStyleRender,
			editor :  new Ext.form.field.ComboBox({
				typeAhead : true,
				triggerAction : 'all',
				store : Ext.getStore('houseStyle'),
				valueField : 'dictCode',
				displayField : 'dictName',
				editable : false,
				allowBlank : false
			})
		},{
			xtype : 'mycolumn',
			editable : false,
			align : 'center',
			dataIndex : 'houseType',
			text : '房屋类型',
			renderer: me.houseTypeRender,
			editor : new Ext.form.field.ComboBox({
				typeAhead : true,
				triggerAction : 'all',
				store : Ext.getStore('houseType'),
				valueField : 'dictCode',
				displayField : 'dictName',
				editable : false,
				allowBlank : false
			}) 
			
		}, {
			xtype : 'mycolumn',
			width : 110,
			editable:false,
			align : 'center',
			dataIndex : 'floor',
			text : '楼层',
			editor : new Ext.form.NumberField({
				allowBlank : false,
				allowNegative : false,
				allowDecimals : true
			})	
		}, {
			xtype : 'mycolumn',
			editable:false,
			align : 'center',
			dataIndex : 'houseNum',
			text : '房间号',
			editor : new Ext.form.NumberField({
				allowBlank : false,
				allowNegative : false,
				allowDecimals : true
			})	
		
		},{
			xtype : 'mycolumn',
			editable : false,
			align : 'center',
			dataIndex : 'houseStatus',
			text : '房屋状态',
			renderer: me.houseStatusRender,
			editor : new Ext.form.field.ComboBox({
				typeAhead : true,
				triggerAction : 'all',
				store : Ext.getStore('houseStatus'),
				valueField : 'dictCode',
				displayField : 'dictName',
				editable : false,
				allowBlank : false
			}) 
			
		},{
			xtype : 'mycolumn',
			editable : false,
			align : 'center',
			dataIndex : 'face',
			text : '房屋朝向',
			renderer: me.faceRender,
			editor : new Ext.form.field.ComboBox({
				typeAhead : true,
				triggerAction : 'all',
				store : Ext.getStore('face'),
				valueField : 'dictCode',
				displayField : 'dictName',
				editable : false,
				allowBlank : false
			}) 
			
		},
		{
			xtype : 'mycolumn',
			editable : false,
			align : 'center',
			dataIndex : 'decoration',
			text : '装修情况',
			renderer: me.decorationRender,
			editor : new Ext.form.field.ComboBox({
				typeAhead : true,
				triggerAction : 'all',
				store : Ext.getStore('decoration'),
				valueField : 'dictCode',
				displayField : 'dictName',
				editable : false,
				allowBlank : false
			}) 
			
		}, {
			xtype : 'mycolumn',
			editable:false,
			align : 'center',
			dataIndex : 'highestCommission',
			text : '最高佣金',
			editor : new Ext.form.NumberField({
				allowBlank : false,
				allowNegative : false,
				allowDecimals : true
			})	
		
		}, {
			xtype : 'mycolumn',
			editable:false,
			align : 'center',
			dataIndex : 'area',
			text : '面积(㎡)',
			editor : new Ext.form.NumberField({
				allowBlank : false,
				allowNegative : false,
				allowDecimals : true
			})	
		
		}, {
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'orginalPricePerSquare',
			text : '原来每平米价格(元)',
			editor : {
				xtype : 'textfield'
			}
		}, {
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'currentPricePerSquare',
			text : '现每平米价格(元)',
			editor : {
				xtype : 'textfield'
			}
		}, {
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'orginalPrice',
			text : '原价(元)',
			editor : {
				xtype : 'textfield'
			}
		}, {
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'currentPrice',
			text : '现价(元)',
			editor : {
				xtype : 'textfield'
			}
		} ];
		me.dockedItems = [ {
			xtype : 'toolbar',
			dock : 'top',
			items : [ {
				xtype : 'button',
				text : '添加新项',
				listeners : {
					click : {
						fn : me.addNewItem,
						scope : me
					}
				}
			}, {
				xtype : 'button',
				text : '删除选中行',
				listeners : {
					click : {
						fn : me.deleteChosenItem,
						scope : me
					}
				}

			}, {
				xtype : 'button',
				text : '刷新',
				listeners : {
					click : {
						fn : me.refreshData,
						scope : me
					}
				}
			}, {
				xtype : 'button',
				text : '保存修改',
				listeners : {
					click : {
						fn : me.commit,
						scope : me
					}
				}
			} ]
		} ];
		this.plugins = [ this.cellEditing ];
		this.callParent(arguments);
	},
	dateRender: function(val){
		if(val == null || val == '')
			return '';
		if(val == '至今')
			return val;
		else
			return Ext.util.Format.date(val, 'Y/m/d');
	},
	houseTypeRender : function(val) {
		store = Ext.getStore('houseType'); 
		record = store.findRecord('dictCode', val);
		if (record == null)
			return val;
		name = record.data.dictName;
		return name;
	},
	houseStyleRender : function(val) {
		store = Ext.getStore('houseStyle'); 
		record = store.findRecord('dictCode', val);
		if (record == null)
			return val;
		name = record.data.dictName;
		return name;
	},
	houseStatusRender : function(val) {
		store = Ext.getStore('houseStatus'); 
		record = store.findRecord('dictCode', val);
		if (record == null)
			return val;
		name = record.data.dictName;
		return name;
	},
	faceRender : function(val) {
		store = Ext.getStore('face'); 
		record = store.findRecord('dictCode', val);
		if (record == null)
			return val;
		name = record.data.dictName;
		return name;
	},
	decorationRender : function(val) {
		store = Ext.getStore('decoration'); 
		record = store.findRecord('dictCode', val);
		if (record == null)
			return val;
		name = record.data.dictName;
		return name;
	},
	refreshData : function() {
		var me = this;
		if (this.unit == 0)
			return;
		var store = this.getStore();
		store.proxy.extraParams = {
				unitId : this.unit.unitId
		};
		store.load({
			callback : function( records, successful) {
				Ext.each(records, function(rec) {
					rec.stripeRows = true;
				});
			}
		});
	},
	addNewItem : function() {
		var rec = new HRMS.model.House({
			unit : this.unit,
			building : this.unit.roofBeam.building
		});

		this.getStore().insert(0, rec);
		this.cellEditing.startEditByPosition({
			row : 0,
			column : 1
		});

	},
	deleteChosenItem : function() {
		var position = this.getSelectionModel().getCurrentPosition();
		if (position == null) {
			return;
		}

		var me = this;
		Ext.MessageBox.confirm("确认", "是否确认删除？", function (btn) {
            if(btn == 'yes'){
            	me.store.removeAt(position.row);
            	me.commit();
            }
        });
	},
	commit : function() {
		var me = this;
		this.store.sync({
			'success' : function(a, b) {
				Ext.MessageBox.show({
					title : '操作成功',
					msg : a.proxy.reader.rawData.message,
					icon : Ext.MessageBox.OK,
					buttons : Ext.Msg.OK
				});
				me.refreshData();
			}
		});
	},
	


});