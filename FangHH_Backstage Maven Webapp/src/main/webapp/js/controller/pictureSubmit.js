angular
    .module('pictureSubmit', ['angularFileUpload'])

    .factory("map", ['$window', '$q', function($window, $q) {
        return function(mapId, config, scope) {

            var _this = this;

            //需要显示地图的元素
            this.mapId = mapId;

            //服务配置
            this.config = config;

            //地图对象
            this.map=null;

            //加载百度地图api方法
            this.load = function() {

                if (!$window.init) {

                    var script = document.createElement("script");

                    script.type = "text/javascript";

                    //url最后的callback=init,表示加载完成后调用window对象上的初始化方法。
                    script.src = "http://api.map.baidu.com/api?v=2.0&ak=eKhQCBjho1YcPR4fsoB6aCtj&callback=init";

                    document.body.appendChild(script);

                } else {

                    $window.init(this.mapId, this.config);

                };
                //定义初始化方法，挂到window对象上
                $window.init = function(mapId, config) {

                    var mapId = mapId ? mapId : _this.mapId,

                        config = config ? config : _this.config,

                        point = null;
                    //实例化地图对象并把地图容器元素传入
                    _this.map = new BMap.Map(mapId),

                    //返回转换成百度坐标并返回promise对象
                    convertorPoint = _this.convertor(config.lng, config.lat);

                    //获取百度坐标
                    convertorPoint.then(function(data) {

                        var marker= null;

                        //将经度和纬度传入,返回经纬度对象
                        point = new BMap.Point(data.lng, data.lat);

                        //设置地图中心点和放大级数      
                        _this.map.centerAndZoom(point, 12);

                        //设置地图覆盖物标记
                        marker = new BMap.Marker(point);

                        //将地图覆盖物标记添加到地图对象上      
                        _this.map.addOverlay(marker);

                    }, function(error) {

                        console.warn(errro);

                    });

                    //config配置调用控件
                    config.copyright && _this.copyright(config.copyright);

                    //滚轮放大缩小
                    _this.map.enableScrollWheelZoom();

                    _this.map.centerAndZoom(point,12);
				  	_this.map.enableScrollWheelZoom(true);
					var geoc = new BMap.Geocoder();

					_this.map.addEventListener("click", function(e){        
						var pt = e.point;
						geoc.getLocation(pt, function(rs){
							var addComp = rs.addressComponents;
							var nowPosition = {
								lng: rs.point.lng,
								lat: rs.point.lat
							};
							scope.$emit('mapPositionUpdate', nowPosition);
						});
					});
                };
            };

            //坐标转换成百度坐标方法
            this.convertor = function(lng, lat) {

                var pointArr = [],

                    point = new BMap.Point(lng, lat),

                    //实例化转换对象
                    convertor = new BMap.Convertor(),

                    deferred = $q.defer();

                //将原坐标转成数组
                pointArr.push(point);

                //将坐标传入,获取百度坐标
                convertor.translate(pointArr, 1, 5, function(data) {

                    if (data.status == 0) {

                        deferred.resolve(data.points[0]);

                    } else {

                        deferred.reject(data.status);

                        console.warn('坐标转换状态:' + data.status)

                    };

                },{enableHighAccuracy: true});

                //返回promise
                return deferred.promise;
            };

            //地图版权
            this.copyright=function(config){

                if (!config) return;

                var href = config.href,

                    name = config.name;

                //实例化版权控件对象,将位置设置到右下角
                var cr = new BMap.CopyrightControl({anchor:BMAP_ANCHOR_BOTTOM_RIGHT});

                //设置版权内容
                cr.addCopyright({id:1,content:"<a href="+href+" target='_blank' title='"+name+"版权所有'>"+name+"</a>"});

                //添加控件
                this.map.addControl(cr);
            };

        }
    }])

    .directive("map", ['map', '$parse',function(map, $parse) {
        return {
            restrict: "EA",
            scope: true,
            link: function(scope, element, attrs){
                //获取控制器中定义的地图配置config对象
                var model = $parse(attrs.map);
                var mapInfo = model(scope);
                //实例化地图service，将指令元素作为容器传入
                //传入config对象
                var mapObj = new map(element[0], mapInfo.mapPosition, scope, mapInfo.mapNowPosition);
                //开始加载
                mapObj.load();

            }
        };
    }])

    .controller('pictureSubmit', ['$scope', '$http', '$cookieStore', '$location', '$stateParams', 'FileUploader', function($scope, $http, $cookieStore, $location, $stateParams, FileUploader){
		//效果图
		$scope.effectPicList = [];
		$scope.effectpicuploader = new FileUploader({
			url: 'houseStyle/uploadStylePic',
			removeAfterUpload: true
		});
		$scope.effectpicuploader.onAfterAddingFile = onAfterAddingFile;
		$scope.effectpicuploader.onSuccessItem = function(item, response, status, headers) {
			var pic = {
				buildingId: $stateParams.buildingId,
				picType: '01030600',
				picLocation: response.data,
				picDescription: ''
			}
			$scope.effectPicList.push(pic);
			addBuildingPic(pic);
		}

		//实景图
		$scope.realPicList = [];
		$scope.realPicuploader = new FileUploader({
			url: 'houseStyle/uploadStylePic',
			removeAfterUpload: true
		});
		$scope.realPicuploader.onAfterAddingFile = onAfterAddingFile;
		$scope.realPicuploader.onSuccessItem = function(item, response, status, headers) {
			var pic = {
				buildingId: $stateParams.buildingId,
				picType: '01030100',
				picLocation: response.data,
				picDescription: ''
			}
			$scope.realPicList.push(pic);
			addBuildingPic(pic);
		}

		//规划图
		$scope.planPicList = [];
		$scope.planPicUploader = new FileUploader({
			url: 'houseStyle/uploadStylePic',
			removeAfterUpload: true
		});
		$scope.planPicUploader.onAfterAddingFile = onAfterAddingFile;
		$scope.planPicUploader.onSuccessItem = function(item, response, status, headers) {
			var pic = {
				buildingId: $stateParams.buildingId,
				picType: '01030700',
				picLocation: response.data,
				picDescription: ''
			}
			$scope.planPicList.push(pic);
			addBuildingPic(pic);
		}

		//配套图
		$scope.supportingPicList = [];
		$scope.supportingPicUploader = new FileUploader({
			url: 'houseStyle/uploadStylePic',
			removeAfterUpload: true
		});
		$scope.supportingPicUploader.onAfterAddingFile = onAfterAddingFile;
		$scope.supportingPicUploader.onSuccessItem = function(item, response, status, headers) {
			var pic = {
				buildingId: $stateParams.buildingId,
				picType: '01030500',
				picLocation: response.data,
				picDescription: ''
			}
			$scope.supportingPicList.push(pic);
			addBuildingPic(pic);
		}

		//样板间
		$scope.modelRoomPicList = [];
		$scope.modelRoomPicUploader = new FileUploader({
			url: 'houseStyle/uploadStylePic',
			removeAfterUpload: true
		});
		//$scope.modelRoomPicUploader.removeAfterUpload = true;
		$scope.modelRoomPicUploader.onAfterAddingFile = onAfterAddingFile;
		$scope.modelRoomPicUploader.onSuccessItem = function(item, response, status, headers) {
			var pic = {
				buildingId: $stateParams.buildingId,
				picType: '01030400',
				picLocation: response.data,
				picDescription: ''
			}
			$scope.modelRoomPicList.push(pic);
			addBuildingPic(pic);
		}

		//公共方法
    	$scope.deletePic = function(list, i) {
    		if($scope.ifAddNewPicAndMap == true) {
    			list.splice(i, 1);
    			return ;
    		}
    		$http.get('building/deleteBuildingPic', {
	    			params: {
		    			bpId: list[i].bpId
	    			}
				})
				.success(function(response) {
					alert(response.data);
				})
				.error(function(data, status) {
					alert('发生错误(提交时)');
				});

    		list.splice(i, 1);
    	}
    	function onAfterAddingFile(item) {
			item.upload();
		}
		function addPicAndMapInfo() {
			var buildingPicList = $scope.effectPicList;
			buildingPicList = buildingPicList.concat($scope.realPicList);
			buildingPicList = buildingPicList.concat($scope.planPicList);
			buildingPicList = buildingPicList.concat($scope.supportingPicList);
			buildingPicList = buildingPicList.concat($scope.modelRoomPicList);

			$http.post('building/addSurround', {
					buildingId: $stateParams.buildingId,
					busstation: 'ttextbusstation',
					school: 'ttextschool',
					hospital: 'ttexthospital',
					bank: 'ttextbank',
					entertainment: 'ttextentertainment',
					shopping: 'ttextshopping',
					repast: 'ttextrepast',
					exercise: 'ttextexercise',
					list: buildingPicList
				})
				.success(function(response) {
					alert(response.data);
					$location.path('index/typeEnter/' + $stateParams.buildingId + '&0');
				})
				.error(function(data, status) {
					alert('发生错误(提交时)');
				});
		}

		function updatePicAndMapInfo() {//更新时候只需要更新位置与周边
			$http.post('building/updateSurround', {
					buildingId: $stateParams.buildingId,
					sfId: $scope.sfId,
					busstation: 'busstationUpdate',
					school: 'schoolUpdate',
					hospital: 'hospitalUpdate',
					bank: 'bankUpdate',
					entertainment: 'entertainmentUpdate',
					shopping: 'shoppingUpdate',
					repast: 'repastUpdate',
					exercise: 'exerciseUpdate',
					list: null
				})
				.success(function(response) {
					alert(response.data);
					$location.path('index/typeEnter/' + $stateParams.buildingId + '&0');
				})
				.error(function(data, status) {
					alert('发生错误(提交时)');
				});
		}

		//获取图片和周边信息
		$http.get('building/getSurround', {
			params: {
				buildingId: $stateParams.buildingId
			}
		})
		.success(function(response) {
			if(response.data.buildingId == null) {//之前没有录入过, 所以使用添加接口
				$scope.submitPicAndMapInfo = addPicAndMapInfo;
				$scope.ifAddNewPicAndMap = true;
			}
			else {//之前录入了
				$scope.ifAddNewPicAndMap = false;

				$scope.sfId = response.data.sfId;
				//点击保存
				$scope.submitPicAndMapInfo = updatePicAndMapInfo;
				angular.forEach(response.data.list, function(value, key) {
					switch(value.picType) {
						case '01030600':
							$scope.effectPicList.push(value);
							break;
						case '01030100':
							$scope.realPicList.push(value);
							break;
						case '01030700':
							$scope.planPicList.push(value);
							break;
						case '01030500':
							$scope.supportingPicList.push(value);
							break;
						case '01030400':
							$scope.modelRoomPicList.push(value);
							break;
					}
				});
			}
		})
		.error(function(data, status) {
			alert('发生错误(获取时)');
		});

		//追加图片
		function addBuildingPic(onePic) {
			if($scope.ifAddNewPicAndMap == true) {
				return ;
			}

			$http.post('building/addBuildingPic', onePic)
				.success(function(response) {
					alert(response.data);
				})
				.error(function(data, status) {
					alert('发生错误(追加图片)');
				});
		}



		// 百度地图API功能
		// var map = new BMap.Map("map");
		// var point = new BMap.Point(116.331398,39.897445);
		// map.centerAndZoom(point,12);
	 //  	map.enableScrollWheelZoom(true);
		// var geoc = new BMap.Geocoder();

		// map.addEventListener("click", function(e){        
		// 	var pt = e.point;
		// 	geoc.getLocation(pt, function(rs){
		// 		var addComp = rs.addressComponents;
	 //            alert(rs.point.lng + ', ' + rs.point.lat);
	 //            alert(addComp.province + ", " + addComp.city + ", " + addComp.district + ", " + addComp.street + ", " + addComp.streetNumber);
		// 	});
		// });

		$scope.mapPosition = {
            lng: 116.331398,
            lat: 39.897445
        };

        $scope.mapArray = [{
        	name: 'bank',
        	description: '银行',
        	positionLng: 116.33333,
        	positionLat: 39.899999,
        	positionName: 'XX银行'
        },{
        	name: 'busstation',
        	description: '公交车站',
        	positionLng: 116.33333,
        	positionLat: 39.899999,
        	positionName: 'XX银行'
        },{
        	name: 'entertainment',
        	description: '周边环境',
        	positionLng: 116.33333,
        	positionLat: 39.899999,
        	positionName: 'XX银行'
        },{
        	name: 'exercise',
        	description: '运动场地',
        	positionLng: 116.33333,
        	positionLat: 39.899999,
        	positionName: 'XX银行'
        },{
        	name: 'hospital',
        	description: '医院',
        	positionLng: 116.33333,
        	positionLat: 39.899999,
        	positionName: 'XX银行'
        },{
        	name: 'repast',
        	description: '餐厅',
        	positionLng: 116.33333,
        	positionLat: 39.899999,
        	positionName: 'XX银行'
        },{
        	name: 'school',
        	description: '学校',
        	positionLng: 116.33333,
        	positionLat: 39.899999,
        	positionName: 'XX银行'
        },{
        	name: 'shopping',
        	description: '银行',
        	positionLng: 116.33333,
        	positionLat: 39.899999,
        	positionName: 'XX银行'
        }];

        $scope.mapNowPositionLng = null;
        $scope.mapNowPositionLat = null;

        $scope.$on('mapPositionUpdate', function(event, data) {
			//$scope.mapNowPosition = data;
			$scope.mapNowPositionLng = data.lng;
        	$scope.mapNowPositionLat = data.lat;
        	$scope.$apply();
			alert(data.description);
        });

        $scope.setOneMapPosition = function() {
        	alert($scope.mapOptions);
        	console.log($scope.mapOptions);
        }
    }]);