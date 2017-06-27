Ext.define('HRMS.view.Header', {
	extend : 'Ext.container.Container',
	alias : 'widget.indexHeader',
	border:0,
	height : 50,//50
	margin: '0 0 2 0',
	initComponent : function() {
		Ext.apply(this, {
			layout : {
				type : 'border'
			},
			collapsible : false,
			split : false,
			items : [ {
				region : 'center',
				html : '<div style="text-align:left;padding:0px 0px 0px 50px;"><h2>房合汇后台管理系统</h2></div>',
				bodyStyle : {
					height: '50px',
					backgroundColor: '#00487F',
					color: '#cccccc'
				}
			}, {
				width :250,
				region : 'east',
				layout : 'fit',
				bodyStyle : {
					backgroundColor : '#00487F',
					paddingLeft: '10px',
					fontSize: '13px'
				},
				html : this.loginInfo()
			} ]
		});
		this.callParent(arguments);
	},
	loginInfo:function(){
		var userName = Ext.getDom('loginUserName').value;
		//var roleName = Ext.getDom('loginUserRoleName').value;
		var empNo = Ext.getDom('loginUserEmpNo').value;
		html = '<div style="text-align:left;padding:18px 0px 0px 10px;">';
		html += '<span style="color:#cccccc">欢迎登录 ：';
		html += '<span style="color:#cccccc; font-weight:bold;">'+userName+'</span> | ';
//		html += '<span style="color:#cccccc">登录身份：</span>';
//		html += '<span style="color:#cccccc; font-weight:bold;">'+roleName +'</span> | ';
		
		var logout = '<a href="logout" style="color:#cccccc;text-decoration: none;">退出登录</a>';	
		//var jumpOut = '<a href="../admin/client" target="_blank" style="color:#cccccc;text-decoration: none; margin-left:15px;">个人信息页面</a>';	
		html += logout;
		//判断如果是有工号，跳转到个人信息页面
		/*if(empNo!=null&&empNo.length>0)
			html += jumpOut;*/
		html += '<div>';
		return html;
	}
});
