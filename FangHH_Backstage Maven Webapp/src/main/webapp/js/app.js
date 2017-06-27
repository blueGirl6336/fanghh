var modules = [
	'ui.router',
	'fanghhmsCtrl',
	'releaseNewBuildingCtrl',
	'manageBuildingCtrl',
	'manageBuildingFilter',
	'fhhStore',
	'fhhUser',
	'navigator',
	'fanghhmsDirective',
	'ActivitiesLaunch', 	// 添加活动
	'manageBuilding',
	'DynamicManagement',	// 添加动态
	'BuildingList',		   	// 楼盘列表
	'pictureSubmit',      // 图片上传(楼盘录入第二步)
	'angularFileUpload',  // 图片上传控件
	'commentCtrl',
	'PriceTrend',		   		// 房价趋势
	'watchActivity',
	'PicTalk'						// 看图说房
];

angular
	.module('fanghhms', modules)
	.config(function ($stateProvider, $urlRouterProvider) {
		$urlRouterProvider.otherwise('login');
		$stateProvider
			.state('index', {
				url: '/index',
				views: {
					'main': {
						templateUrl: './template/index.html'
					}
				}
			})
			.state('login', {
				url: '/login',
				views: {
					'main': {
						templateUrl: './template/login.html'
					}
				}
			})

			.state('index.buildingEnter', {
				url: '/buildingEnter/{buildingId}',
				views: {
					'content': {
						templateUrl: './template/building/releaseNewBuilding/buildingEnter.html'
					}
				}
			})
			.state('index.buildingAudit', {
				url: '/buildingAudit/{buildingId}&{buttonShow}',
				views: {
					'content': {
						templateUrl: './template/building/releaseNewBuilding/buildingAudit.html'
					}
				}
			})

			.state('index.typeEnter', {
				url: '/typeEnter/{buildingId}&{styleId}',
				views: {
					'content': {
						templateUrl: './template/building/releaseNewBuilding/typeEnter.html'
					}
				}
			})
			.state('index.typeAudit', {
				url: '/typeAudit/{styleId}&{buttonShow}',
				views: {
					'content': {
						templateUrl: './template/building/releaseNewBuilding/typeAudit.html'
					}
				}
			})

			.state('index.houseEnter', {
				url: '/houseEnter/{buildingId}&{houseId}',
				views: {
					'content': {
						templateUrl: './template/building/releaseNewBuilding/houseEnter.html'
					}
				}
			})
			.state('index.houseAudit', {
				url: '/houseAudit/{houseId}&{buttonShow}',
				views: {
					'content': {
						templateUrl: './template/building/releaseNewBuilding/houseAudit.html'
					}
				}
			})
			.state('index.listBuildingManagement', {
				url: '/listBuildingManagement',
				views: {
					'content': {
						templateUrl: './template/building/manageBuilding/list_buildingManagement.html'
					}
				}
			})
			.state('index.listHouseManagement', {
				url: '/listHouseManagement',
				views: {
					'content': {
						templateUrl: './template/building/manageBuilding/list_houseManagement.html'
					}
				}
			})
			.state('index.userAuthentication', {
				url: '/userAuthentication',
				views: {
					'content': {
						templateUrl: './template/userAuthentication/userAuthentication.html'
					}
				}
			})
			.state('index.storeCertification', {
				url: '/storeCertification',
				views: {
					'content': {
						templateUrl: './template/userAuthentication/storeCertification.html'
					}
				}
			})
			.state('index.moneyPrincple', {
				url: '/moneyPrincple',
				views: {
					'content': {
						templateUrl: './template/building/manageBuilding/moneyPrincple.html'
					}
				}
			})
			.state('index.priceTrendPrice', {
				url: '/priceTrendPrice',
				views: {
					'content': {
						templateUrl: './template/building/manageBuilding/priceTrendPrice.html'
					}
				}
			})
			.state('index.listSourceManagement', {
				url: '/listSourceManagement',
				views: {
					'content': {
						templateUrl: './template/building/manageBuilding/list_sourceManagement.html'
					}
				}
			})
			.state('index.launchActivity', {
				url: '/launchActivity',
				views: {
					'content': {
						templateUrl: './template/activityManagement/activitieslaunch.html'
					}
				}
			})
			.state('index.editActivity', {
				url: '/editActivity/:activityId/:activityType',
				views: {
					'content': {
						templateUrl: './template/activityManagement/activitieslaunch.html'
					}
				}
			})
			.state('index.listWatchMethod', {
				url: '/listWatchMethod',
				views: {
					'content': {
						templateUrl: './template/building/manageBuilding/list_watchMethod.html'
					}
				}
			})
			.state('index.dynamicManagement', {
				url: '/listDynamicManagement/{buildingId}',
				views: {
					'content': {
						templateUrl: './template/building/manageBuilding/list_dynamicManagement.html'
					}
				}
			})
			.state('index.avtivitiemManagement', {
				url: '/avtivitiemManagement',
				views: {
					'content': {
						templateUrl: './template/activityManagement/avtivitieManagement.html'
					}
				}
			})
			.state('index.addDynamic', {
				url: '/addDynamic/:buildingId',
				views: {
					'content': {
						templateUrl: './template/dynamic/adddynamic.html'
					},
					'buildingPanel@index.addDynamic': {
						templateUrl: './template/buildingManagementPanel.html'
					}
				}
			})
			.state('index.editDynamic', {
				url: '/editDynamic/:buildingId/:dynamicId',
				views: {
					'content': {
						templateUrl: './template/dynamic/adddynamic.html'
					}
				}
			})
			.state('index.pictureSubmit', {
				url: '/pictureSubmit/{buildingId}',
				views: {
					'content': {
						templateUrl: './template/building/manageBuilding/pictureSubmit.html'
					}
				}
			})
			.state('index.comment', {
				url: '/comment',
				views: {
					'content': {
						templateUrl: './template/building/buildingCircleReview/comment.html'
					}
				}
			})
			.state('index.priceTrend', {
				url: '/priceTrend/:buildingId',
				views: {
					'content': {
						templateUrl: './template/building/manageBuilding/priceTrendPrice.html'
					},
					'buildingPanel@index.priceTrend': {
						templateUrl: './template/buildingManagementPanel.html'
					}
				}
			})
			.state('index.groupBuying', {
				url: '/groupBuying',
				views: {
					'content': {
						templateUrl: './template/activityManagement/groupBuying.html'
					}
				}
			})
			.state('index.tehui', {
				url: '/tehui',
				views: {
					'content': {
						templateUrl: './template/activityManagement/tehui.html'
					}
				}
			})
			.state('index.watchActivity', {
				url: '/watchActivity/:activityType/:activityId/:activityStatus',
				views: {
					'content': {
						templateUrl: './template/userAuthentication/watchActivity.html'
					}
				}
			})
			.state('index.picTalk', {
				url: '/picTalk/:buildingId',
				views: {
					'content': {
						templateUrl: './template/picTalk/picTalk.html'
					},
					'buildingPanel@index.picTalk': {
						templateUrl: './template/buildingManagementPanel.html'
					}
				}
			});
	});