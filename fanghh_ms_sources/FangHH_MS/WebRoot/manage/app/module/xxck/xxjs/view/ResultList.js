Ext.define('HRMS.module.rsgl.rsjbxx.xxjs.view.ResultList', {
    extend: 'Ext.grid.Panel',
    alias: 'widget.queryResultList',
    layout: 'fit',
    title: '查询结果',
    //border: 0,
    closable: false,
    enableColumnHide: false,
    enableColumnMove: false,
    enableLocking: false,
    selModel:  {
		selType : 'checkboxmodel',
	    mode : 'MULTI'
	},
    initComponent: function () {
        var me = this;
        me.columns = [{
            xtype: 'rownumberer',
            width:40,
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
            text: '出生日期',
			renderer: me.dateRender
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
			renderer : me.subUnitRender
        }, {
            xtype: 'mycolumn',
            width: 180,
            align: 'center',
            dataIndex: 'jobType',
            text: '岗位类型',
            renderer: me.jobTypeRender
        }, 
		 {
			xtype : 'mycolumn',
			sortable : true,
			width : 150,
			align : 'center',
			dataIndex : 'dateOfEntry',
			text : '到职日期',
			renderer: me.dateRender
		},{
            xtype: 'mycolumn',
            text: '操作'
        }];
        me.dockedItems = [{
            xtype: 'toolbar',
            dock: 'top',
            items: [{
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
                xtype: 'button',
                text: '查看详细信息',
                listeners: {
                    click: {
                        fn: me.showPersonDetail,
                        scope: me
                    }
                }
            },{
                xtype: 'button',
                text: '编辑查询条件',
                action: 'editQuery'
            }, {
                xtype: 'label',
                text: '查询结果个数 : '
            }, {
                xtype: 'label',
                style : {
                	color : 'red',
                	fontSize : '20px'
                },
                id: 'id_resultCount',
                text: '0', 
                margins: '0 10 0 10'
            }, {
                xtype: 'button',
                text: '导出查询结果',
                listeners: {
                    click: {
                        fn: me.exportPersonDetail,
                        scope: me
                    }
                }
            }]
        }];
        this.store = Ext.create('HRMS.store.personnel.PersonBaseInfoStore',{id:'xxjs-resultStore'});
        this.store.proxy.api.read = 'baseinfo/query';
        this.store.proxy.actionMethods = {read:'POST'};
        
        //双击事件
        this.addListener('itemdblclick', this.showPersonDetail, this);
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
    departmentTypeRender: function (val) {
	    store = Ext.getStore('department');
	    record = store.findRecord('code', val);
	    if(record == null)
	    	return val;
	    name = record.data.name;
	    return name;
	},
	subUnitRender : function(value) {
		//alert(record.data["department"]);
		if(value == 0)
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
	    if(record == null)
	    	return val;
	    name = record.data.name;
	    return name;
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
	},
	exportPersonDetail : function(){
        var empNoArray = new Array();
        var store = this.getStore();
        store.each(function(record){
        	empNoArray.push(record.data.empNo);
        });
        //导出Excel 不能使用Ajax方式，要使用提交form方式
//        Ext.Ajax.request({
//        	url:'excel/search',
//        	method:'POST',
//        	params : {
//        		empList:empNoArray
//        	},
//        	failure: function(response, opts) {
//    	        Ext.Msg.alert("Error","导出失败");
//    	    }
//        });

        var form = document.createElement("form");
        form.setAttribute("method", "post");
        form.setAttribute("action", "excel/search");
        form.setAttribute("target", "_blank");

        store.each(function(record){
        	var input = document.createElement('input');
        	input.type = 'hidden';
        	input.name = 'empList';
        	input.value = record.data.empNo;
        	form.appendChild(input);
        });
        document.body.appendChild(form);
        //window.open('about:blank', name);
        form.submit();
        document.body.removeChild(form);
	}
    
});