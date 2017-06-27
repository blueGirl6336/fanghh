Ext.define('HRMS.module.rsgl.rsjbxx.ltxjqt.view.ltxjqt', {
	extend : 'Ext.grid.Panel',
	requires : [ 'Ext.toolbar.Paging', 'Ext.window.MessageBox'],
	layout : 'fit',
	title : '离退休及其他人员基本信息',
	border : 0,
	closable : false,
	enableColumnHide : false,
	enableColumnMove : false,
	enableLocking : false,
	workStates : [],
	selModel : {
		selType : 'checkboxmodel',
	    mode : 'MULTI'
	},
//	store : Ext.create('HRMS.store.personnel.OtherPersonInfoStore'),
	initComponent : function() {
		var me = this;
		me.columns = [ {
			xtype : 'rownumberer',
			width : 40,
			text : '序号'
		}, {
			xtype : 'mycolumn',
			width : 90,
			dataIndex : 'empNo',
			locked : true,
			text : '工号'
		}, 
//		{
//			xtype : 'mycolumn',
//			width : 100,
//			dataIndex : 'retirementDate',
//			renderer: me.dateRender,
//			text : '退休日期'
//		},
		{
			xtype : 'mycolumn',
			width : 70,
			dataIndex : 'name',
			locked : true,
			text : '姓名'
		}, {
			xtype : 'mycolumn',
			width : 50,
			align : 'center',
			dataIndex : 'sex',
			text : '性别'
		}, {
			xtype : 'mycolumn',
			width : 50,
			align : 'center',
			dataIndex : 'ethnic',
			text : '民族'
		}, {
			xtype : 'mycolumn',
			width : 100,
			align : 'center',
			dataIndex : 'dob',
			renderer: me.dateRender,
			text : '出生日期'
		}, {
			xtype : 'mycolumn',
			hidden : true,
			sortable : false,
			dataIndex : 'idCard',
			text : '身份证号'
		}, {
			xtype : 'mycolumn',
			width : 80,
			align : 'center',
			dataIndex : 'workState',
			text : '工作状态',
			renderer : me.workStateRender
		}, {
			xtype : 'mycolumn',
			width : 160,
			align : 'center',
			dataIndex : 'department',
			text : '所属部门',
			renderer : me.departmentTypeRender
		}, {
			xtype : 'mycolumn',
			width : 150,
			align : 'center',
			dataIndex : 'sub_unit',
			text : '二级单位',
			renderer : me.subUnitTypeRender
		}, {
			xtype : 'mycolumn',
			width : 300,
			align : 'center',
			dataIndex : 'remark',
			text : '备注'
		}
		];
		me.dockedItems = [ {
			xtype : 'toolbar',
			dock : 'top',
			defaults:{
				padding:'0 4 1 4'
			},
			items : [ {
				xtype : 'button',
				text : '导出简历',
				listeners : {
					click : {
						fn : function(){
                            var sels = me.getSelectionModel().getSelection();
                            if (sels.length == 0) {
                                Ext.Msg.alert("提示", "未选中任何人");
                                return;
                            }
                            var empList = new Array();
                            for (var i in sels) {
                                empList.push(sels[i].data.empNo);
                            }
                            if (empList.length == 1) {
                                window.location.href = 'excel/single/' + empList[0];
                                return;
                            }
                            var hiddenForm = Ext.create('Ext.form.Panel', {
                                title: 'hiddenForm',
                                standardSubmit: true,
                                url: 'excel/choosenResumes.zip',
                                timeout: 1200000,
                                height: 0,
                                width: 0,
                                hidden: true
                            });
                            var fakeForm = hiddenForm.getForm();
                            fakeForm.submit({
                                params: {
                                    empList: empList
                                }
                            });
						},
						scope : me
					}
				}
			}, {
				xtype : 'button',
				text : '查看详细信息',
				listeners : {
					click : {
						fn : me.showPersonDetail,
						scope : me
					}
				}
			}, {
                xtype: 'label',
                text: '共有'
            }, {
                xtype: 'label',
                style : {
                	color : 'red',
                	fontSize : '20px'
                },
                id: 'id_ltxjqt_resultCount',
                text: '0'
            }, {
                xtype: 'label',
                text: '人'
            },'|' 
//            ,{
//				xtype : 'combobox',
//				name : 'department',
//				autoSelect : true,
//				fieldLabel : '部门',
//				emptyText : '部门',
//				labelWidth : 40,
//				width:260,
//				labelAlign : 'right',
//				queryMode : 'local',
//				store : Ext.getStore('department'),
//				valueField : 'code',
//				displayField : 'name',
//				editable : false
//			},
            ,{
            	xtype: 'textfield',
                fieldLabel: '姓名',
                hideLabel: false,
                labelAlign: 'right',
                labelWidth: 30,
                width: 150,
                name: 'name',
                emptyText: '姓名',
                listeners : {
					specialKey : function(field, e) {
						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
							me.searchPerson();
						}
					}
				}
            },
			{
				xtype : 'button',
				text : '查询',
				listeners : {
					click : {
						fn : me.searchPerson,
						scope : me
					}
				}
			}
			]
		} ];
        this.addListener('itemdblclick', this.showPersonDetail, this);
		this.callParent(arguments);
		
		//给部门加上全部人员
//		var departStore=this.down('combobox[name=department]')
//		.getStore();
//		if(departStore.findExact('code','1') == -1)
//			departStore.insert(0,{code:'1',name:'全部人员'});
		
	},
	// 工作状态render
	workStateRender : function(val) {
		store = Ext.getStore('workState');
		record = store.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		return name;
	},
	subUnitTypeRender : function(val) {
		store = Ext.getStore('allsubunit');
		record = store.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		return name;
	},
	dateRender: function(val){
		if(val == null || val == '')
			return '';
		if(val == '至今')
			return val;
		else
			return Ext.util.Format.date(val, 'Y/m/d');
	},
	sexRender : function(val) {
		if (val == 'm')
			return '男';
		else
			return '女';
	},
	departmentTypeRender : function(val) {
		store = Ext.getStore('department');
		record = store.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		return name;
	},
	jobTypeRender : function(val) {
		store = Ext.getStore('jobType');
		record = store.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		return name;
	},
	searchPerson : function() {
//		var departmentValue = this.down('combobox[name=department]')
//				.getValue();
		var nameValue = this.down('textfield[name=name]').getValue();
		if(null==name)
			name='';
		//alert(departmentValue);

		var store = this.store;
		store.proxy.extraParams.
			name = nameValue;
		store.load({
			callback: function(records, options, success){ 
				//alert(records.length);
				Ext.getCmp('id_ltxjqt_resultCount')
					.setText(records.length);
				}});

	},
	showPersonDetail : function(){
        var records = this.getSelectionModel().getSelection();
        var length = records.length;
        if (length == 0)
            return;
        var empNoArrary = new Array(length);
        for (var i = 0; i < length; i++) {
            empNoArrary[i] = records[i].data.empNo;
        }
        var form = document.createElement("form");
        form.setAttribute("method", "post");
        form.setAttribute("action", "../report/resume/personDetailInfo");
        form.setAttribute("target", "_blank");

        for (var i = 0; i < length; i++) {
            var input = document.createElement('input');
            input.type = 'hidden';
            input.name = 'empNoArr';
            input.value = records[i].data.empNo;
            form.appendChild(input);
        }
        document.body.appendChild(form);
        //window.open('about:blank', name);
        form.submit();
        document.body.removeChild(form);
	}

});