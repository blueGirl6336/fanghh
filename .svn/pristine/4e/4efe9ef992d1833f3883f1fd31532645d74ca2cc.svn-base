Ext.define('SymbolModel', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id',  type: 'int'},
        {name: 'symbol', type: 'string'}
    ]
});

Ext.define('HRMS.module.rsgl.rsjbxx.xxjs.controller.Controller', {
	extend : 'HRMS.customize.CommonController',
	id:'xxjsController',
	
	queryBeanId : 0,
	
	combinedGroupId:0,
	
	//single 表示单个增加
	//combine  表示从组合中增加
	addFrom: 'single',
	
	addFromCombinedId: 0,
	
	refs : [ {
		ref : 'symbolChoice',
		selector : 'symbolChoice'
	},{
		ref : 'itemChoice',
		selector : 'itemChoice'
	},{
		ref : 'valueChoice',
		selector : 'valueChoice'
	},{
		ref : 'queryEdit',
		selector : 'queryEdit'
	},{
		ref : 'queryList',
		selector : 'queryList'
	},{
		ref : 'queryResultList',
		selector : 'queryResultList'
	},{
		ref : 'xxjspanle',
		selector : 'xxjspanle'
	},{
		ref : 'combinedqueryView',
		selector : 'combinedqueryView'
	},{
		ref : 'combinedQueryList',
		selector : 'combinedQueryList'
	},{
		ref : 'combinequerybeanList',
		selector : 'combinequerybeanList'
	},{
		ref : 'combinedQueryListInQueryPage',
		selector : 'combinedQueryListInQueryPage'
	}],

	views : 'HRMS.module.rsgl.rsjbxx.xxjs.view.*',

	init : function() {
		this.control({
			'itemChoice dataview' : {
				itemclick : this.chooseItem
			},
			'queryEdit button[action=addQuery]' : {
				click : this.addQuery
			},
			'queryEdit button[action=deleteQuery]' : {
				click : this.deleteQuery
			},
			'queryEdit button[action=saveConfig]' : {
				click : this.saveConfig
			},
			'queryEdit button[action=refreshQuery]' : {
				click : this.refreshQuery	
			},
			'queryEdit button[action=removeAll]' : {
				click : this.removeAllQuery
			},
			'queryEdit button[action=doQuery]' : {
				click : this.doQuery	
			},
			'queryResultList button[action=editQuery]' : {
				click : this.editQuery	
			},
			'combinedQueryList button[action=doCombinedQuery]' : {
				click : this.doCombinedQuery	
			},
			'combinedQueryList dataview' : {
				itemclick : this.findQueryBean	
			},
			'combinedQueryList button[action=editCombinedQuery]' : {
				click : this.editCombinedQuery	
			},
			'combinedQueryListInQueryPage dataview' : {
				itemclick : this.prepareCombinedAdd	
			}
		});
	},
	
	chooseItem: function(grid, record, item, index){
		var relativities = record.data.relativities;
		var inputType = record.data.input_type;
		
		//set symbol list
		var symbols = relativities.split(',');
		var symbolStore =  this.getSymbolChoice().getStore();
		symbolStore.removeAll();
		for(var i = 0; i < symbols.length; i++){
			var symbolRecord = Ext.create('SymbolModel', {id: i, symbol:symbols[i]});
			symbolStore.add(symbolRecord);
		};
		//如果只有一个元素 自动选择
		if(symbols.length == 1){
			this.getSymbolChoice().getSelectionModel().select(symbolRecord); 
		}
		
		//set value list
		var valuePage = this.getValueChoice();
		var valueStore = valuePage.getStore();
		valueStore.removeAll();
		
		
		//特殊处理
		if(record.data.propertyName== "sex" ){
			var valuePage = this.getValueChoice();
			var newDic1 = Ext.create('HRMS.model.Dictionary', {code: 1, name:"男"});
			valueStore.add(newDic1);
			var newDic2 = Ext.create('HRMS.model.Dictionary', {code: 2, name:"女"});
			valueStore.add(newDic2);
			return;
		}
		
		//普通情况，判断输入类型
		if(inputType == 0){
			valuePage.cellEditing.disable();
			var dic_code = record.data.dic_code;
			valueStore.proxy.extraParams={groupCode: dic_code};
			valueStore.load();
		}else{
			var newDic = Ext.create('HRMS.model.Dictionary', {code: 0, name:""});
			valuePage.cellEditing.enable();
			valueStore.add(newDic);
			valuePage.cellEditing.startEditByPosition({
				row : 0,
				column : 0
			});
		}
		this.changeAddFromMode('single');
	},
	addQuery:function(){
		var me = this;
		//judge the mode
		if(this.addFrom == 'combine'){
			if(this.addFromCombinedId == 0){
				return;
			}
			var store = Ext.create('HRMS.store.personnel.QueryBeanStore',{autoLoad: false});
			store.proxy.extraParams = {groupId:this.addFromCombinedId};
			store.proxy.api.read = 'query/getByGroupId';
			store.load({
		        // store loading is asynchronous, use a load listener or callback to handle results
		        callback: function(){
		          var records = this.data.items;
		          if(records != null && records.length > 0){
		        	  var queryBeanList = me.getQueryList();
		        	  for(var a = 0; a < records.length; a++){
		        		  queryBeanList.getStore().add(records[a]);
		        	  }
		        	  queryBeanList.needRender = true;
		          }
		        }
		    });
			
			//reset the id
			this.addFromCombinedId = 0;
			return;
		}
		
		
		
		//check item choice
		var itemRecord = this.getItemChoice().getSelectionModel().getSelection()[0];
		if(itemRecord == null){
			Ext.Msg.alert('操作错误', '请先选择一个查询项！');
			return;
		}
		var needNextCheck = true;
		var propertyName = itemRecord.data.propertyName;
		if(propertyName == "schoolFate"
			|| propertyName == "workingParents"){
			needNextCheck  =false;
		}
		//check symbol choice
		var symbolRecord = this.getSymbolChoice().getSelectionModel().getSelection()[0];
		if(needNextCheck && symbolRecord == null){
			Ext.Msg.alert('操作错误', '请先选择一个比较符！');
			return;
		}
		//check value 
		var valueRecord = this.getValueChoice().getSelectionModel().getSelection()[0];
		if(needNextCheck && (valueRecord == null || valueRecord.data.name == '')){
			Ext.Msg.alert('操作错误', '请输入目标值！');
			return;
		}
		
		//init new bean
//		var queryBean = Ext.clone(itemRecord);
		var queryBean = Ext.create('HRMS.model.QueryBean', {
			name: itemRecord.data.name,
			entityName: itemRecord.data.entityName,
			propertyName:itemRecord.data.propertyName,
			input_type: itemRecord.data.input_type,
			dic_code: itemRecord.data.dic_code,
			orderInShow: 0,
			groupQueryId: me.combinedGroupId
		});
		
		queryBean.data.id = this.getQueryList().getStore().getCount()+1;
		queryBean.data.relativities = symbolRecord.data.symbol;
		if(itemRecord.data.input_type == 0 ){
			queryBean.data.value = valueRecord.data.code;
		}else
			queryBean.data.value = valueRecord.data.name;
		
		//add to list
		if( me.combinedGroupId == 0){
			queryBean.setId( this.queryBeanId );
			this.queryBeanId++;
			
			var queryBeanList = this.getQueryList();
			if(queryBean.data.input_type == 0)
				queryBeanList.needRender = true;
			else
				queryBeanList.needRender = false;
			
			queryBeanList.getStore().add(queryBean);
		}else{
			var currentStore = this.getCombinequerybeanList().getStore();
			
			currentStore.add(queryBean);
		}
		
	},
	refreshQuery:function(){
		this.getItemChoice().getStore().load();
	},
	deleteQuery: function(){
		var itemRecord = this.getQueryList().getSelectionModel().getSelection()[0];
		if(itemRecord == null){
			Ext.Msg.alert('操作错误', '请先选择要删除的查询条件！');
			return;
		}
		this.getQueryList().getStore().remove(itemRecord);
	},
	removeAllQuery: function(){
		this.getQueryList().getStore().removeAll();
	},
	doQuery:function(){
		//get query info records
		var queryBeans = this.getQueryList().getStore().data.items;
		if(queryBeans == null || queryBeans.length == 0){
			Ext.Msg.alert('操作错误', '查询条件为空，请添加查询条件！');
			return;
		}
		
		var resultPanel = this.getQueryResultList();
		var personStore = resultPanel.getStore();
		//get the query objects from records
		var queryToSent = new Array();
		for(var i = 0; i< queryBeans.length; i++){
			queryToSent[i] = queryBeans[i].data;
		}
		//send by json string
		//as the object can't be send by param
		var string = Ext.JSON.encode(queryToSent);
		personStore.proxy.extraParams = null;
		//do query
		personStore.load({params:{s_queryList: string},
			callback: function(records, options, success){ 
				//alert(records.length);
				Ext.getCmp('id_resultCount')
					.setText(records.length);
				} });
		
		//set active
		this.getXxjspanle().setActiveTab(1);
		
	},
	editQuery:function(){
		this.getXxjspanle().setActiveTab(0);
		this.refreshQuery();
		this.getItemChoice().getSelectionModel().deselectAll();
		this.getSymbolChoice().getSelectionModel().deselectAll();
		this.getValueChoice().getSelectionModel().deselectAll();
		
	},
	doCombinedQuery:function(){
		//get query info records
		var queryBeans = this.getCombinequerybeanList().getStore().data.items;
		if(queryBeans == null || queryBeans.length == 0){
			Ext.Msg.alert('操作错误', '查询条件为空，请添加查询条件！');
			return;
		}
		
		var personStore = this.getQueryResultList().getStore();
		//get the query objects from records
		var queryToSent = new Array();
		for(var i = 0; i< queryBeans.length; i++){
			queryToSent[i] = queryBeans[i].data;
		}
		//send by json string
		//as the object can't be send by param
		var string = Ext.JSON.encode(queryToSent);
		personStore.proxy.extraParams = null;
		//do query
		personStore.load({params:{s_queryList: string},
			callback: function(records, options, success){ 
				//alert(records.length);
				Ext.getCmp('id_resultCount')
					.setText(records.length);
				}});
		
		//set active
		this.getXxjspanle().setActiveTab(1);
		
		
	},
	findQueryBean : function(grid, record, item, index){
		var groupid = record.data.groupId;
		var view = this.getCombinequerybeanList();
		var store = view.getStore();
		store.proxy.extraParams = {groupId:groupid};
		store.proxy.api.read = 'query/getByGroupId';
		store.load();
	},
	
	editCombinedQuery:function(){
		var view = this.getCombinedQueryList();
		var sel = view.getSelectionModel();
        var record = sel.getSelection()[0];
		if(record == null)
			return;
		var groupId = record.data.groupId;
		//set group id for the controller
		this.combinedGroupId = groupId;
		
		this.getXxjspanle().setActiveTab(0);
		var currentStore = this.getCombinequerybeanList().getStore();
		var qbView = this.getQueryList();
		qbView.reconfigure(currentStore);
		currentStore.load();
		this.getItemChoice().getSelectionModel().deselectAll();
		this.getSymbolChoice().getSelectionModel().deselectAll();
		this.getValueChoice().getSelectionModel().deselectAll();
		
		//set save button enable
		var button = this.getQueryEdit().down('button[action=saveConfig]');
		button.setDisabled(false);
	},
	saveConfig: function(){
		//set store
		var oldView = this.getQueryList()
		var storeToSync = oldView.getStore();
		var oldStore = oldView.privateStore;
		oldView.reconfigure(oldStore);
		
		var button = this.getQueryEdit().down('button[action=saveConfig]');
		button.setDisabled(true);
		this.getXxjspanle().setActiveTab(2);
		this.combinedGroupId = 0;
		storeToSync.sync();
	},
	prepareCombinedAdd : function(grid, record, item, index){
		
		this.addFromCombinedId = record.data.groupId;
		this.changeAddFromMode('combine');
		
	},
	changeAddFromMode: function(mode){
		this.addFrom = mode;
		if(mode == 'single'){
			//deselect all
			var view = this.getCombinedQueryListInQueryPage();
			if(view != null){
				view.getSelectionModel().deselectAll();
			}
		}else if(mode == 'combine'){
			var view = this.getItemChoice();
			view.getSelectionModel().deselectAll();
			this.getSymbolChoice().getStore().removeAll();
			this.getValueChoice().getStore().removeAll();
		}
	}
});

