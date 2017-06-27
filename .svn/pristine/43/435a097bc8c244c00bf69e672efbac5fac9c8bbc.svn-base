Ext.define('HRMS.module.rsgl.rygl.glzwbd.view.OperationFormPanel_modify', {
	id : 'id_modifyGLZWBD_Form',
	extend : 'Ext.form.Panel',
	alias: 'widget.new_modify_glzwbd',
	frame : false,
	title : null,//'职务变动操作',
	width : 410,
	height : 380,
	bodyPadding : 10,
	fieldDefaults : {
		labelAlign : 'right',
		labelWidth : 135,
		msgTarget : 'side'
	},
	initComponent : function() {
		var me = this;
		this.items = [ 
//			{
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
			//xtype : 'fieldset',
			//title : '添加/修改信息',
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
				fieldLabel : '职务',
				name : 'title'
			},{
				xtype : 'combobox',
				fieldLabel : '职务级别',
				name : 'mp_class',
				store: Ext.getStore('managementClass'),
				valueField : 'code',
				displayField : 'name',
				typeAhead : true,
				queryMode : 'local',
				editable : false,
				allowBlank : true
			},{
				fieldLabel : '聘任单位',
				name : 'employer',
				value : '哈尔滨工业大学（威海）'
			},{
				fieldLabel : '聘任院系部门',
				xtype : 'combobox',
				name : 'mp_department',
				autoSelect : true,
				queryMode : 'local',
				store : Ext.getStore('department'),
				valueField : 'name',//'code',
				displayField : 'name'
			},{
				xtype : 'datefield',
				fieldLabel : '职务任命日期',
				name : 'title_from',
				format: 'Y/m/d',
				//value:new Date(),
				allowBlank : true
			},{
				xtype : 'datefield',
				fieldLabel : '职务解除日期',
				name : 'title_to',
				format: 'Y/m/d',
				//hidden:true,
				//value:new Date(),
				allowBlank : true/*,
				listeners: {  
                   isNull: function() {  
                        if (Ext.getCmp("isTeacher").getValue().inputValue == "是") {  
                            Ext.getCmp("fieldEmploy").setVisible(true);  
                        } else {  
                            Ext.getCmp("fieldEmploy").setVisible(false);  
                        }  
                    }  
                }  */
			},{
				xtype:'radiogroup',
				id   :'upToPresent',
			    name :'upToPresent',
			    fieldLabel: "至今",
			    items : [{
			    	boxLabel: '是',
			    	name: 'upToPresent',
			    	inputValue:true, //映射的值
			    	checked:this.value == true ? true : false
			    },{
			    	boxLabel: '否',
			    	name: 'upToPresent',
			    	inputValue:false,
			    	checked:this.value == true ? true : false
			    }],
			    //以下是监听事件
			    listeners : {
			               change : function(radiofield,oldvalue){//这事件是当radiogroup的值发生改变时进入
			                    //alert(radiofield.getValue().inputValue);//输出选中的值
			                    //alert(oldValue);//输出原值
			                    //var sex = Ext.getCmp('upToPresent').getChecked()[0].inputValue;
			                    //alert(sex);
			               }
			    }
			},{
				xtype : 'combobox',
				fieldLabel : '职员职级',
				name : 'manag_grade',
				store: Ext.getStore('managementLevel'),
				valueField : 'code',
				displayField : 'name',
				typeAhead : true,
				queryMode : 'local',
				editable : false,
				//allowBlank : true
			},{
				xtype : 'datefield',
				fieldLabel : '职员职级任命日期',
				name : 'manag_grade_date',
				format: 'Y/m/d',
				//value:new Date(),
				allowBlank : true
			},{
				fieldLabel : '人员类型',
				name : 'emp_type',
				hidden : true
			},{
				xtype:'radiogroup',
			    name:'title_attribute',
			    fieldLabel: "是否兼职",
			    items : [{
			    	boxLabel: '是',
			    	name: 'title_attribute',
			    	inputValue:true  //映射的值
			    },{
			    	boxLabel: '否',
			    	name: 'title_attribute',
			    	inputValue:false
			    }]
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
