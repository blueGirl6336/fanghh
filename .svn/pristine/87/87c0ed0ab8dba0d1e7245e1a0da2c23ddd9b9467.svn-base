Ext.define('HRMS.module.rsgl.rsjbxx.view.rsjbxx', {
    extend: 'Ext.grid.Panel',
    requires: [
        'HRMS.store.dictionary.SubUnitStore'
    ],
    layout: 'fit',
    title: '人事基本信息',
    border: 0,
    departmentCode: 1,
    closable: false,
    enableColumnHide: false,
    enableColumnMove: false,
    enableLocking: false,
    //store:null,
    selModel:  {
		selType : 'checkboxmodel',
	    mode : 'MULTI'
	},
    initComponent: function () {
        var me = this;
        me.columns = [{
                xtype: 'rownumberer',
                width: 40,
    			text : '序号'
            }, {
                xtype: 'mycolumn',
                width: 90,
                dataIndex: 'empNo',
                locked: true,
                text: '工号'
            }, {
                xtype: 'mycolumn',
                width: 70,
                dataIndex: 'name',
                locked: true,
                text: '姓名'
            }, {
                xtype: 'mycolumn',
                width: 50,
                align: 'center',
                dataIndex: 'sex',
                text: '性别'
            }, {
                xtype: 'mycolumn',
                width: 50,
                align: 'center',
                dataIndex: 'ethnic',
                text: '民族'
            }, {
                xtype: 'mycolumn',
                width: 100,
                align: 'center',
                dataIndex: 'dob',
                renderer: me.dateRender,
                text: '出生日期'
            }, {
                xtype: 'mycolumn',
                hidden: true,
                sortable: false,
                dataIndex: 'idCard',
                text: '身份证号'
            }, {
                xtype: 'mycolumn',
                width: 160,
                align: 'center',
                dataIndex: 'department',
                text: '所属部门',
                renderer: me.departmentTypeRender
            }, {
                xtype: 'mycolumn',
                width: 150,
                align: 'center',
                dataIndex: 'sub_unit',
                text: '二级单位',
                renderer: me.subUnitRender
            },{
                xtype: 'mycolumn',
                width: 100,
                align: 'center',
                dataIndex: 'manage_post',
                text: '管理职务'
            },{
                xtype: 'mycolumn',
                width: 100,
                align: 'center',
                dataIndex: 'tech_post',
                text: '专业技术职务'
            },{
                xtype: 'mycolumn',
                width: 180,
                align: 'center',
                dataIndex: 'jobType',
                text: '岗位类型',
                renderer: me.jobTypeRender
            },{
                xtype: 'mycolumn',
                width: 100,
                align: 'center',
                dataIndex: 'quotaType',
                text: '编制属性',
    			renderer : me.quotaTypeRender
            }, {
                xtype: 'mycolumn',
                sortable: true,
                width: 150,
                align: 'center',
                dataIndex: 'dateOfEntry',
                renderer: me.dateRender,
                text: '到职日期'
            }, {
                xtype: 'mycolumn',
                sortable: false,
                hidden: true,
                width: 150,
                align: 'center',
                dataIndex: 'hometown',
                text: '籍贯'
            }
        ];
        me.dockedItems = [{
            xtype: 'toolbar',
            dock: 'top',
			defaults:{
				padding:'0 4 1 4'
			},
            items: [{
                    xtype: 'button',
                    text: '导出简历',
                    listeners: {
                        click: {
                            fn: function () {
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
                            scope: me
                        }
                    }
                }, {
                    xtype: 'button',
                    text: '查看详细信息',
                    listeners: {
                        click: {
                            fn: me.showPersonDetail,
                            scope: me
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
                    id: 'id_jbxx_resultCount',
                    text: '0'
                }, {
                    xtype: 'label',
                    text: '人'
                },'|' , {
                    xtype: 'combobox',
                    name: 'quota',
                    autoSelect: true,
                    fieldLabel: '编制属性',
                    emptyText: '编制属性',
                    labelWidth: 60,
                    width: 150,
                    labelAlign: 'right',
                    queryMode: 'local',
                    editable: false,
                    store: new Ext.data.ArrayStore({
                        fields: ['code', 'name'],
                        data: [
                            [1, '全部人员'],
                            [2, '固定编制'],
                            [3, '流动编制']
                        ]
                    }),
                    valueField: 'code',
                    displayField: 'name'
                },
                {
                    xtype: 'textfield',
                    fieldLabel: '姓名',
                    hideLabel: false,
                    labelAlign: 'right',
                    labelWidth: 30,
                    width: 150,
                    name: 'name',
                    emptyText: '姓名(优先查询）',
                    listeners : {
    					specialKey : function(field, e) {
    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
    							me.searchPerson();
    						}
    					}
    				}
                },
                {
                    xtype: 'datefield',
                    fieldLabel: '到职日期(晚于)',
                    name: 'dateOfEntry',
                    labelWidth: 90,
                    labelAlign: 'right',
                    hideLabel: false,
                    emptyText: '到职日期(晚于)',
                    format: 'Y/m/d',
                    listeners : {
    					specialKey : function(field, e) {
    						if (e.getKey() == Ext.EventObject.ENTER) {//响应回车
    							me.searchPerson();
    						}
    					}
    				}
                }, {
                    xtype: 'button',
                    text: '查询',
                    listeners: {
                        click: {
                            fn: me.searchPerson,
                            scope: me
                        }
                    }
                }
            ]
        }];
        this.callParent(arguments);
        this.addListener('itemdblclick', this.showPersonDetail, this);
        
        this.view.loadMask = {
        	msg:'加载中',
        	autoShow:true
        };//设置不开启mask
        
        //打开默认固定编制人员
        var quota = this.down('textfield[name=quota]');
        quota.select(2);
    },
    dateRender: function (val) {
        if (val == null || val == '')
            return '';
        if (val == '至今')
            return val;
        else
            return Ext.util.Format.date(val, 'Y/m/d');
    },
    departmentTypeRender: function (val) {
        if (val == 0)
            return '';
        store = Ext.getStore('department');
        record = store.findRecord('code', val);
        if (record == null)
            return val;
        name = record.data.name;
        return name;
    },
    subUnitRender: function (value) {
        //alert(record.data["department"]);
        if (value == 0)
            return '';
        store = Ext.getStore('allsubunit');
        record = store.findRecord('code', value);
        if (record == null)
            return value;
        name = record.data.name;
        return name;
    },
    jobTypeRender: function (val) {
        store = Ext.getStore('jobType');
        record = store.findRecord('code', val);
        if (record == null)
            return val;
        name = record.data.name;
//        if (name.indexOf('（') != -1) {
//            name = name.substring(name.indexOf('（') + 1, name.indexOf('）'));
//        }
      
        if(name=='管理岗位'){
        	 
        }
        return name;
    },
	quotaTypeRender : function(val) {
		if (val == 0)
			return '';
		store = Ext.getStore('quotaType');
		record = store.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		
		return name;
	},
    searchPerson: function () {
        var doeValue = this.down('textfield[name=dateOfEntry]').getValue();
        var nameValue = this.down('textfield[name=name]').getValue();
        var departmentValue = this.departmentCode;
        var quota = this.down('textfield[name=quota]').getValue();
        if (quota == null) quota = 1;
        //改变日期格式
        
        doeValue = Ext.Date.format(doeValue,'Y/m/d');
        //alert(quota);

        //		var departmentValue = this.down('combobox[name=department]').getValue();		
        //		//alert(departmentValue+' '+this.departmentCode);
        //		//如果部门编号为空，则使用页面内的departmentCode
        //		//如果没有权限查看，则返回
        //		if(departmentValue==null || departmentValue=='' )
        //			departmentValue=this.departmentCode;
        //		else if(departmentValue.indexOf(this.departmentCode)!=0){
        //			alert('没有权限');
        //			return;
        //		}

        var store = this.store;

        //		if ((doeValue != null && doeValue != '')
        //				|| (nameValue != null && nameValue != '') 
        //				|| (departmentValue != null && departmentValue != '') ) {
        store.proxy.api.read = "baseinfo/searchOnWork";
        store.proxy.actionMethods = {
            read: 'POST'
        };
        store.proxy.extraParams = {
            quota: quota,
            name: nameValue,
            doe: doeValue,
            empNo: null,
            department: departmentValue
        };
        store.load({
			callback: function(records, options, success){ 
				//alert(records.length);
				Ext.getCmp('id_jbxx_resultCount')
					.setText(records.length);
				}});

    },
    showPersonDetail: function () {
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