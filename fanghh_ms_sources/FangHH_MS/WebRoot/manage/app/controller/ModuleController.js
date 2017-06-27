Ext.define('HRMS.controller.ModuleController', {
	extend : 'Ext.app.Controller',
	id : 'moduleController',

	stores : [ 'ModuleStore' ],
	//
	models : [ 'PersonBaseInfo' ],

	views : [ 'MenuPanel' ],

	refs : [ {
		ref : 'mainmenu',
		selector : 'mainmenu'
	}, {
		ref : 'cp',
		selector : 'centerpane'
	} ],

	init : function() {
		this.control({
			'leftmenu' : {
				itemclick : this.setView
			},
			'mainmenu' : {
				afterrender : this.lazyLoadStore
			}
		});
	},
	// 通过模块根节点画出左侧目录菜单
	initMenuPanel : function(node) {
		var menuPanel = this.getMainmenu();
		menuPanel.initMenuPanel(node);
	},

	// 设置单一页面显示
	setView : function(view, record, element, index, eventObject, object) {
		var path = record.raw.path;
		var controller = this.getController('HRMS.module.' + path
				+ '.controller.Controller');
		var cp = this.getCp(); // Get hold of the center pane...
		controller.setView(cp, record);
	}
	,
	lazyLoadStore : function() {
		//Ext.create('HRMS.store.dictionary.ArchiveStatusStore');
		//Ext.create('HRMS.store.dictionary.ContractKindTypeStore');
		Ext.create('HRMS.store.dictionary.ActivityStore');
		Ext.create('HRMS.store.dictionary.BuildingStore');
		Ext.create('HRMS.store.dictionary.RoleStore');
		Ext.create('HRMS.store.dictionary.CityStore');
		Ext.create('HRMS.store.dictionary.FaceStore');
		Ext.create('HRMS.store.dictionary.RoofStructerStore');
		Ext.create('HRMS.store.dictionary.RegionStore');
		Ext.create('HRMS.store.dictionary.ConstructionKindStore');
		Ext.create('HRMS.store.dictionary.ConstructionUseStore');
		Ext.create('HRMS.store.dictionary.CommentKindStore');
		Ext.create('HRMS.store.dictionary.BuildingPropertyTypeStore');
		Ext.create('HRMS.store.dictionary.HouseStore');
		Ext.create('HRMS.store.dictionary.HouseStyleStore');
		Ext.create('HRMS.store.dictionary.HouseTypeStore');
		Ext.create('HRMS.store.dictionary.HouseStatusStore');
		Ext.create('HRMS.store.dictionary.DecorationStore');
		Ext.create('HRMS.store.dictionary.PropertyTypeStore');
		Ext.create('HRMS.store.dictionary.ChildOrderStatusStore');
		Ext.create('HRMS.store.dictionary.IntegralRuleDictionaryStore');
		Ext.create('HRMS.store.dictionary.PushNewsTypeStore');  // added by zhangyu
		Ext.create('HRMS.store.dictionary.PushNewsStatusStore'); // added by zhangyu
		Ext.create('HRMS.store.dictionary.ConsultantMessageStatusStore');
		Ext.create('HRMS.store.dictionary.OperationKindStore');
		Ext.create('HRMS.store.dictionary.RuleTypeStore');
		Ext.create('HRMS.store.dictionary.RuleStatusStore');
		Ext.create('HRMS.store.building.BrokerStore'); // added by zhangyu
		Ext.create('HRMS.store.building.BuildingStore');
		Ext.create('HRMS.store.building.HouseStore');
		Ext.create('HRMS.store.building.RoofBeamStore');
		Ext.create('HRMS.store.building.UnitStore');
	/*	Ext.create('HRMS.store.dictionary.DepartmentTypeStore');
		Ext.create('HRMS.store.dictionary.DepartmentStore');
		Ext.create('HRMS.store.dictionary.TransferTypeStore');
		Ext.create('HRMS.store.dictionary.DepartmentClassStore');
		Ext.create('HRMS.store.dictionary.JobTypeStore');
		Ext.create('HRMS.store.dictionary.SchoolTypeStore');
		Ext.create('HRMS.store.dictionary.DegreeStore');
		Ext.create('HRMS.store.dictionary.EducationStore');
		Ext.create('HRMS.store.dictionary.TrainTypeStore');
		Ext.create('HRMS.store.dictionary.ProfessionalClassStore');
		Ext.create('HRMS.store.dictionary.ManagementClassStore');
		Ext.create('HRMS.store.dictionary.ProfessionalPostStore');
		Ext.create('HRMS.store.dictionary.TeacherTypeStore');
		Ext.create('HRMS.store.dictionary.DispatchTypeStore');
		Ext.create('HRMS.store.dictionary.StudyType');
		Ext.create('HRMS.store.dictionary.AbroadTypeStore');
		Ext.create('HRMS.store.dictionary.AwardsClassStore');
		Ext.create('HRMS.store.dictionary.QuotaTypeStore');
		Ext.create('HRMS.store.dictionary.QuotaTypeStore');
		Ext.create('HRMS.store.dictionary.EmployTypeStore');
		Ext.create('HRMS.store.dictionary.PersonnelDictionaryGroupStore');
		Ext.create('HRMS.store.dictionary.PersonnelDictionaryItemStore');
		Ext.create('HRMS.store.dictionary.ProfessionalLevelStore');
		Ext.create('HRMS.store.dictionary.ManagementLevelStore');
		Ext.create('HRMS.store.dictionary.ServicePostLevelStore');
		Ext.create('HRMS.store.dictionary.ServicePostTypeStore');
		Ext.create('HRMS.store.dictionary.TutorTypeStore');
		Ext.create('HRMS.store.dictionary.TalentTitleStore');
		Ext.create('HRMS.store.dictionary.AllSubUnitStore');
		Ext.create('HRMS.store.dictionary.RelationStore');
		Ext.create('HRMS.store.dictionary.WorkPlaceStore');
		Ext.create('HRMS.store.dictionary.WorkStateStore');
		Ext.create('HRMS.store.dictionary.DisciplineGroupStore');
		Ext.create('HRMS.store.dictionary.DisciplineStore');
		Ext.create('HRMS.store.dictionary.AllDisciplineStore');*/
	}

});
