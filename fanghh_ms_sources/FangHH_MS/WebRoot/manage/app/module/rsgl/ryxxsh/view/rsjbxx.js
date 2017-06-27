var me;

Ext.define('HRMS.module.rsgl.ryxxsh.view.rsjbxx', {
	extend : 'Ext.grid.Panel',
	layout : 'fit',
	title : '人员信息审核',
	border : 0,
	departmentCode : 1,
	closable : false,
	enableColumnHide : false,
	enableColumnMove : false,
	enableLocking : false,
	selModel:  {
		selType : 'checkboxmodel',
	    mode : 'MULTI'
	},
	initComponent : function() {
		me = this;
		me.columns = [ {
			xtype : 'rownumberer',
			width : 40,
			align : 'center'
		}, {
			xtype : 'mycolumn',
			width : 150,
			dataIndex : 'empNo',
			text : '工号',
			renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
			
			var status = record.get('status');
			
				if(status == '10' || status == '3'){
					return "<a href='../manage/check/" + value 	+ "' target='_blank' style='color:blue;text-decoration: none;'>" + value + "</a>";
				}else{
					return "<span style='color:black;'>"+value+"</span>"
				}
				
			}
		},{
			xtype : 'mycolumn',
			width : 300,
			dataIndex : 'name',
			text : '姓名',
			renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
			
				var empNo = record.get("empNo");
				var status = record.get('status');
				
				if(status == '10' || status == '3'){
					return "<a href='../manage/check/" + empNo + "' target='_blank' style='color:blue;text-decoration: none;'>" + value + "</a>";
				}else{
					return "<span style='color:black;'>"+value+"</span>"
				}
				
			}
		}, {
			xtype : 'mycolumn',
			width : 200,
			align : 'center',
			dataIndex : 'status',
			text : '当前状态',
			renderer:function(value){
				if (value == '10') {
					return "<span style='color:green;'>审核完毕</span>";
				} else if (value == '2') {
					return "<span style='color:red;'>未通过</span>";
				}else if (value == '3'){
					return "<span style='color:black;'>用户已提交，待审核</span>";
				}else if (value == '0'){
					return "<span style='color:black;'>用户未浏览</span>";
				}else if (value == '1'){
					return "<span style='color:black;'>正在修改</span>";
				}else if (value == '5'){
					return "<span style='color:black;'>审核待定</span>";
				}else if (value == '7'){
					return "<span style='color:black;'>留待查询</span>";
				}
			}
		}, {
			xtype : 'mycolumn',
			width : 300,
			align : 'center',
			text : '操作',
			renderer:function(value, cellmeta, record, rowIndex, columnIndex, store){
				var empNo = record.get('empNo');
				var status = record.get('status');
				var name = record.get('name');
				if(status == '3'){
					return "<a href='javascript:cancelSubmit(\"" + empNo+ "\",\"" + name+ "\");' style='color:blue;text-decoration: none;'>取消提交</a>";
				}else if (status == '10' || status == '7' || status == '5'){
					return "<a href='javascript:cancelSubmit(\"" + empNo+ "\",\"" + name+ "\");' style='color:blue;text-decoration: none;'>取消提交</a>&nbsp&nbsp<a href='javascript:void(0);' onclick='cancelCheck(\"" + empNo + "\",\"" + name+ "\")' style='color:blue;text-decoration: none;'>重新审核</a>";
				} else {
					return "<span style='color:black;'>无</span>";
				}
			}
		}
		];
		
		me.addListener('itemdblclick', itemdblclick);     
	    
		function itemdblclick(dv, record, item, index, e){    
			
			var status = record.get('status');
			
			if(status == '10' || status == '3'){
			
				var empNo = record.get('empNo');
				window.open('../manage/check/' + empNo);
			}
			
			
		} 
		
		
		
		me.dockedItems = [ {
			xtype : 'toolbar',
			dock : 'top',
			defaults:{
				padding:'0 4 1 4'
			},
			items : [{
                xtype: 'label',
                text: '共有'
            }, {
                xtype: 'label',
                style : {
                	color : 'red',
                	fontSize : '20px'
                },
                id: 'id_jbxxsh_resultCount',
                text: '0'
            }, {
                xtype: 'label',
                text: ' 人'
            },'|' ,{
				xtype : 'combobox',
				name : 'status',
				autoSelect : true,
				fieldLabel : '审核进度',
				emptyText : '审核进度',
				labelWidth : 60,
				width:260,
				labelAlign : 'right',
				queryMode : 'local',
				editable:false,
				store : new Ext.data.ArrayStore({
			        fields: ['code','name'],
			        data: [[10, '审核完毕'],
			               [2, '未通过'],
			               [3,'用户已提交，待审核'],
			               [0,'用户未浏览'],
			               [1,'正在修改'],
			               [5,'审核待定'],
			               [7,'留待查询']]
			    }),
				valueField : 'code',
				displayField : 'name'
			},
			{
				xtype : 'textfield',
				fieldLabel : '姓名',
				hideLabel : false,
				labelAlign : 'right',
				labelWidth : 30,
				width:150,
				name : 'name',
				emptyText : '姓名',
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
			}]
		} ];
		//this.addListener('itemdblclick',this.showPersonDetail,this);
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
	departmentTypeRender : function(val) {
		if(val == 0)
			return '';
		store = Ext.getStore('department');
		record = store.findRecord('code', val);
		if (record == null)
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
	jobTypeRender : function(val) {
		store = Ext.getStore('jobType');
		record = store.findRecord('code', val);
		if (record == null)
			return val;
		name = record.data.name;
		if(name.indexOf('（')!=-1){
			name=name.substring(name.indexOf('（')+1,name.indexOf('）'));
		}
		return name;
	},
	searchPerson : function() {
		//var doeValue = this.down('textfield[name=dateOfEntry]').getValue();
		var nameValue = this.down('textfield[name=name]').getValue();
		var departmentValue=this.departmentCode;
		var status=this.down('textfield[name=status]').getValue()
		
		
		var store = this.store;

		
		
		if( nameValue != null && nameValue != ''){
			store.proxy.api.read = "baseinfo/getInfoCheckByName";
		}else if((status != null && status != '' && status != -1) || status == 0){
			store.proxy.api.read = "baseinfo/getInfoCheckByStatus";
		}
	
		store.proxy.actionMethods = {
			read : 'POST'
		};
		store.proxy.extraParams = {
			status : status,
			name : nameValue,
			//doe : doeValue,
			empNo: null,
			departmentCode : departmentValue
		};
		store.load();
	}

});


window.cancelSubmit=function(empNo,name){  
    if (confirm("您确定要取消提交吗？")){
    	$.ajax({
			type : "GET",
			url : "../manage/check/" + empNo + "/cancelSubmit",
			dataType : "json",
			cache : false,
			success : function(data) {
				alert(name + "的信息取消提交成功。");
				refreshPage();
			}
		});
    }
} 

window.cancelCheck=function(empNo,name){  
    if (confirm("您确定要重新审核吗？")){
    	$.ajax({
    		type : "GET",
    		url : "../manage/check/" + empNo + "/cancelCheck",
    		dataType : "json",
    		cache : false,
    		success : function(data) {
    			alert(name + "的信息取消提交成功。");
    			refreshPage();
    		}
    	});
    }
}

window.refreshPage = function(){
	me.getStore().load();
}


