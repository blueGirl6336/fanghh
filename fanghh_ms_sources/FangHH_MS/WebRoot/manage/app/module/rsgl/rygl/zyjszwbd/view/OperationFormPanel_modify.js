Ext.define('HRMS.module.rsgl.rygl.zyjszwbd.view.OperationFormPanel_modify', {
	id : 'id_modifyZYJSZW_Form',
	extend : 'Ext.form.Panel',
	alias: 'widget.new_modify_zyjszw',
	frame : false,
	title : null,
	width : 410,
	height : 335,
	bodyPadding : 10,
	fieldDefaults : {
		labelAlign : 'right',
		labelWidth : 135,
		msgTarget : 'side'
	},
	initComponent : function() {
		var me = this;
		this.items = [ 		
//				{
//			xtype : 'fieldset',
//			title : '人员信息',
//			defaultType : 'textfield',
//			items : [ {
//				readOnly:true,
//				fieldLabel : '工号',
//				name : 'empNo'
//			}, {
//				readOnly:true,
//				fieldLabel : '姓名',
//				name : 'name'
//			}/*, {
//				readOnly:true,
//				fieldLabel : '出生日期',
//				name : 'dob'
//			}*/ , {
//				readOnly:true,
//				fieldLabel : '部门',
//				name : 'department'
//			} ]
//		}, 
			
				
					{
//			xtype : 'fieldset',
//			title : '添加/修改信息',
			defaultType : 'textfield',
			items : [
			{
				//fieldLabel : 'id',
				hidden: true,
				name : 'empNo'//工号
			},
			{
				//fieldLabel : 'id',
				hidden: true,
				name : 'id'//专业技术职务条目id
			},{
				xtype : 'combobox',
				fieldLabel : '职称',
				name : 'title',
				store: Ext.getStore('professionalPost'),
				valueField : 'code',
				displayField : 'name',
				typeAhead : true,
				queryMode : 'local',
				editable : false,
				allowBlank : false
			},{
				xtype : 'combobox',
				fieldLabel : '职称级别',
				name : 'pat_class',
				store: Ext.getStore('professionalClass'),
				valueField : 'code',
				displayField : 'name',
				typeAhead : true,
				queryMode : 'local',
				editable : false,
				allowBlank : false
			},{
				fieldLabel : '聘任单位',
				name : 'employer',
				value : '哈尔滨工业大学（威海）'
			},{
				fieldLabel : '聘任院系部门',
				xtype : 'combobox',
				name : 'sub_unit',
				autoSelect : true,
				queryMode : 'local',
				store : Ext.getStore('department'),
				valueField : 'code',
				displayField : 'name'
			},{
				xtype : 'datefield',
				fieldLabel : '专业技术职务评定日期',
				name : 'title_from',
				format: 'Y/m/d',
				value:new Date(),
				allowBlank : true
			},{
				xtype : 'datefield',
				fieldLabel : '职称结束日期',
				name : 'title_to',
				//hidden:true,
				format: 'Y/m/d',
				value:new Date(),
				allowBlank : true
			},{
				xtype:'radiogroup',
			    name:'upToPresent',
			    fieldLabel: "至今",
			    items : [{
			    	boxLabel: '是',
			    	name: 'upToPresent',
			    	inputValue:true  //映射的值
			    },{
			    	boxLabel: '否',
			    	name: 'upToPresent',
			    	inputValue:false
			    }]
			},{
				xtype : 'combobox',
				fieldLabel : '专业技术级别',
				name : 'tech_grade',
				store: Ext.getStore('professionalLevel'),
				valueField : 'code',
				displayField : 'name',
				typeAhead : true,
				queryMode : 'local',
				editable : false,
				allowBlank : false
			},{
				xtype : 'datefield',
				fieldLabel : '级别评定日期',
				name : 'tech_grade_date',
				format: 'Y/m/d',
				value:new Date(),
				allowBlank : true
			},{
				fieldLabel : '备注',
				name : 'remark'
			}]
		} ];

		this.callParent();
	},
	buttons : [ {
		text : '确定修改',
		action: 'modify',
		disabled : true,
		formBind : true
	},{
		text : '取消',
		action: 'cancel_modify',
		disabled : true,
		formBind : true
	}/*,{
		text : '确认修改',
		action: 'modify',
		disabled : true,
		formBind : true
	} */]
});