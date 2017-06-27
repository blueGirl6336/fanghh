Ext.define('HRMS.module.xtgl.rsglsz.bmgl.view.bmgl', {
	extend : 'Ext.grid.Panel',
	requires : [ 'Ext.toolbar.Paging', 'Ext.window.MessageBox' ],
	layout : 'fit',
	title : '部门管理',
	border : 0,
	closable : false,
	enableColumnHide : false,
	enableColumnMove : false,
	enableLocking : false,
	selModel : Ext.create('Ext.selection.CheckboxModel'),
	store: Ext.create('HRMS.store.personnel.DepartmentStore'),
	initComponent : function() {
		var me = this;
		me.columns = [ {
			xtype : 'rownumberer'
		}, {
			xtype : 'mycolumn',
			width : 100,
			dataIndex : 'type',
			locked : true,
			text : '部门类型',
			renderer: this.departmentTypeRender
		}, {
			xtype : 'mycolumn',
			width : 150,
			dataIndex : 'name',
			locked : true,
			text : '部门名称'
		}, {
			xtype : 'mycolumn',
			width : 100,
			align : 'center',
			dataIndex : 'chief',
			text : '负责人'
		}, {
			xtype : 'mycolumn',
			width : 120,
			align : 'center',
			dataIndex : 'total',
			text : '在编总人数'
		}, {
			text : '管理岗位',
			columns : [ {
				xtype : 'mycolumn',
				width : 70,
				align : 'center',
				dataIndex : 'manage_sum',
				text : '小计'
			}, {
				xtype : 'mycolumn',
				width : 70,
				align : 'center',
				dataIndex : 'manage_chief',
				text : '正职'
			}, {
				xtype : 'mycolumn',
				width : 70,
				align : 'center',
				dataIndex : 'manage_deputy',
				text : '副职'
			}, {
				xtype : 'mycolumn',
				width : 70,
				align : 'center',
				dataIndex : 'manage_important',
				text : '重要岗'
			}, {
				xtype : 'mycolumn',
				width : 70,
				align : 'center',
				dataIndex : 'manage_normal',
				text : '普通岗'
			}, {
				xtype : 'mycolumn',
				width : 70,
				align : 'center',
				dataIndex : 'manage_other',
				text : '其他岗位'
			} ]
		},  {
			text : '专业技术岗位',
			columns : [ {
				xtype : 'mycolumn',
				width : 70,
				align : 'center',
				dataIndex : 'tech_sum',
				text : '小计'
			}, {
				xtype : 'mycolumn',
				width : 70,
				align : 'center',
				dataIndex : 'tech_teacher',
				text : '专任教师'
			}, {
				xtype : 'mycolumn',
				width : 70,
				align : 'center',
				dataIndex : 'tech_counselor',
				text : '辅导员'
			}, {
				xtype : 'mycolumn',
				width : 70,
				align : 'center',
				dataIndex : 'tech_experiment',
				text : '工程实验'
			}, {
				xtype : 'mycolumn',
				width : 70,
				align : 'center',
				dataIndex : 'tech_research',
				text : '专职科研'
			}, {
				xtype : 'mycolumn',
				width : 70,
				align : 'center',
				dataIndex : 'tech_other',
				text : '其他'
			} ]
		},  {
			text : '工勤岗位',
			columns : [ {
				xtype : 'mycolumn',
				width : 70,
				align : 'center',
				dataIndex : 'service_sum',
				text : '小计'
			}, {
				xtype : 'mycolumn',
				width : 70,
				align : 'center',
				dataIndex : 'service_tech',
				text : '技术岗'
			}, {
				xtype : 'mycolumn',
				width : 70,
				align : 'center',
				dataIndex : 'service_normal',
				text : '普通岗'
			}]
		}, {
			xtype : 'mycolumn',
			width : 100,
			align : 'center',
			dataIndex : 'tbd',
			text : '待定岗位'
		}];
		me.dockedItems = [ {
			xtype : 'toolbar',
			dock : 'top',
			items : [ {
				xtype : 'button',
				text : '导出',
				menu : {
					xtype : 'menu',
					items : [ {
						xtype : 'menuitem',
						text : 'Excel文件',
						listeners : {
							click : {
								fn : me.exportExcel,
								scope : me
							}
						}
					}, {
						xtype : 'menuitem',
						text : 'Word文件'
					}, {
						xtype : 'menuitem',
						text : 'PDF文件'
					} ]
				}
			}]
		} ];
		this.callParent(arguments);
		this.store.load();
	},
	departmentTypeRender: function (val) {
		if(val == null )
			return;
	    var store = Ext.getStore('departmentType');
	    record = store.findRecord('code', val);
	    name = record.data.name;
	    return name;
	},
	exportExcel:function(){
//		//var cm=this.getColumnModel();
//		var cols=this.columns;
//		//Ext.Msg.alert("",cols.length);
//		var arr=new Array();
//		for(var i=0;i<cols.length;i++){
//			//alert(cols[i].isHidden());
//			arr.push(cols[i].dataIndex);
//		}
//		
//		Ext.Ajax.request({
//			url:"export/exportExcel",
//			method:"post",
//			params:{
//				value:arr
//			}
//		});
	}
});