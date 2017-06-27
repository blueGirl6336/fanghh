Ext.define('HRMS.module.xtgl.rsglsz.sjzdgl.controller.Controller', {
	extend : 'HRMS.customize.CommonController',
	refs : [ {
		ref : 'dictionaryitemlist',
		selector : 'dictionaryitemlist'
	}, {
		ref : 'dictionarygrouplist',
		selector : 'dictionarygrouplist'
	} ],

	views : [ 'HRMS.module.xtgl.rsglsz.sjzdgl.view.DictionaryGroupList',
			'HRMS.module.xtgl.rsglsz.sjzdgl.view.DictionaryItemList' ],

	stores : ['HRMS.store.DictionaryItemStore'],
			
	init : function() {
		this.control({
			'dictionarygrouplist dataview' : {
				itemclick : this.getDictionary
			},
			'dictionaryitemlist dataview' : {
				itemclick : this.prepareDelete
			},
			'dictionaryitemlist button[action=add]': {
	             click: this.addDictionaryItem
	        }
		});
	},

	getDictionary : function(grid, record) {
		var groupCode = record.data.code;
		var itemGrid = this.getDictionaryitemlist();
		var store = itemGrid.getStore();
		store.getProxy().extraParams = {
			groupCode : groupCode
		};
		store.load();
		var button = this.getDictionarygrouplist()
				.down('button[action=delete]');
		button.setDisabled(false);
	},
	
	prepareDelete: function(grid, record){
		var button = this.getDictionaryitemlist()
		.down('button[action=delete]');
		button.setDisabled(false);
	},

	addDictionaryItem : function() {
		var view = this.getDictionarygrouplist();
		var sel = view.getSelectionModel();
        var smRecord = sel.getSelection()[0];
        if (smRecord == null) {
            Ext.MessageBox.alert('警告：', '请先选择右侧的字典组再添加！');
            return;
        }
        var parent = smRecord.data.code;
        var grid = this.getDictionaryitemlist();
        var store = grid.getStore();
        grid.rowEditing.cancelEdit();
        //从store中的数据中找出code的最大值
        var array = store.data.items;
        var max = smRecord.data.code;
        for (var i in array) {
            aRecord = array[i].data;
            if (aRecord.code > max) max = aRecord.code;
        }
        max = parseInt(max) + 1;
        var r = Ext.create('HRMS.model.Dictionary', {
            code: max,
			name : '',
			module: 2,
			adminVisible: true,
			parentCode:parent,
			detailGgroup:0
        });

        store.add(r);
        var count = store.getTotalCount();
		grid.rowEditing.startEdit(count, 0);
	}
});