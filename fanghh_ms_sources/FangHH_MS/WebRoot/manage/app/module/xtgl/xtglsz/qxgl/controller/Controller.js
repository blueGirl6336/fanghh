Ext.define('HRMS.module.xtgl.xtglsz.qxgl.controller.Controller', {
	extend : 'HRMS.customize.CommonController',
	//TODO 去掉一些东西，IE测试
	stores : [ 'HRMS.store.dictionary.RoleStore',
	           'HRMS.store.PermissionStore'],
	views:[ 'HRMS.module.xtgl.xtglsz.qxgl.view.NavigationTree',
	        'HRMS.module.xtgl.xtglsz.qxgl.view.RoleList'],
	        
	refs : [ {
		ref : 'rolelist',
		selector : 'rolelist'
	}, {
		ref : 'navigationtree',
		selector : 'navigationtree'
	} ],
	
	init: function () {
        this.control({
            'rolelist dataview': {
                itemclick: this.refreshPrivilege
            },
            'navigationtree button[action=confirmUpdate]': {
                click: this.confirmUpdateTree
            },
            'navigationtree button[action=refresh]': {
                click: this.refreshPrivilege
            },
            'navigationtree': {
                checkchange: this.oncheckchange
            }

        });

    },
    refreshPrivilege: function (view, record) {
    	//清空节点树
    	this.cleanTree();
    	
    	//获取选择的角色的编码
        var sm = this.getRolelist().getSelectionModel();
        
        if(sm.getSelection()[0] == null)
        	return;

        var role = sm.getSelection()[0].data.code;

        //获取权限
        pStore = this.getStore('HRMS.store.PermissionStore');

        pStore.getProxy().extraParams = {
        	roleCode: role
        };
        pStore.load({
          scope: this,
          callback: function (records, operation, success) {
        	  //权限赋值，将拥有权限的模块打勾
              var treeStore = this.getNavigationtree().getStore();
              for (var i in records) {
                  treeStore.getNodeById(records[i].data.moduleCode).data.checked = true;
              }
              this.getNavigationtree().getView().refresh();
          }
      });
    },
    //清空节点树上的打勾
    cleanTree: function () {
        var treeStore = this.getNavigationtree().getStore();
        var records = this.getNavigationtree().getView().getChecked();

        Ext.Array.each(records, function (rec) {
            treeStore.getNodeById(rec.data.id).data.checked = false;
        });
        this.getNavigationtree().getView().refresh();
    },
    //确定修改
    confirmUpdateTree: function () {
    	//获取角色编号
        var sm = this.getRolelist().getSelectionModel();
        var role = sm.getSelection()[0].data.code;
        
        var newRecords = this.getNavigationtree().getView().getChecked();
        var store = this.getStore('HRMS.store.PermissionStore');
        var oldRecords = Ext.clone(store.data.items);

        var needChange = false;
        var tempId = 10000;
        Ext.Array.each(newRecords, function (rec) {
        	
            module = rec.data.id;

            needAdd = true;

            for (var i in oldRecords) {
                if (oldRecords[i].data.moduleCode == module) {
                    needAdd = false;
                    break;
                }
            }
            if (needAdd) {
                var r = Ext.create('HRMS.model.Permission', {
                    roleCode: role,
                    moduleCode: rec.data.id
                });
                store.add(r);
                needChange = true;
                tempId++;
            } else {
                oldRecords = Ext.Array.remove(oldRecords, oldRecords[i]);
            }
        });
        if (oldRecords.length > 0) {
            for (var j in oldRecords) {
                store.remove(oldRecords[j]);
            }
            needChange = true;
        }
        if (needChange) 
        	store.sync({
                'success': function (a, b) {
                    Ext.MessageBox.show({
                        title: '操作成功',
                        msg: a.proxy.reader.rawData.message,
                        icon: Ext.MessageBox.OK,
                        buttons: Ext.Msg.OK
                    });
                }
            });
    },
    oncheckchange: function (node, checked, options) {
        node.cascadeBy(function (n) {
            n.set('checked', checked);
        });

        var parent = node.parentNode;
        if (checked) {
            while (parent.data.id != 'root') {
                parent.set('checked', checked);
                parent = parent.parentNode;
            }
        }
    }
});