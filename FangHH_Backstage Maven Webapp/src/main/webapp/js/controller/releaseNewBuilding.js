angular
	.module('releaseNewBuildingCtrl', ['ngCookies','angularFileUpload'])

	//楼盘录入与update
	.controller('buildingEnter', ['$scope', '$stateParams', '$http', '$location', '$cookieStore','$filter', function($scope, $stateParams, $http, $location, $cookieStore,$filter) {
		
		$('input .box11').keyup(function(){  
            var c=$(this);  
            if(/[^\d]/.test(c.val())){//替换非数字字符  
              var temp_amount=c.val().replace(/[^\d]/g,'');  
              $(this).val(temp_amount);  
            }  
         })  

		$scope.ifFail=false;

		//update获取信息
		if ($stateParams.buildingId>0) {
			$http
			.get('building/getBuildingInfo',{
				params:{
					buildingId:$stateParams.buildingId
				}		
			})
			.success(function(response){				
				if (response.data.auditNotPassReason!=""&&response.data.auditNotPassReason!=null) {
					$scope.ifFail=true;
					$scope.auditNotPassReason=response.data.auditNotPassReason;
				}
				var regionId=response.data.regionId;
				var developerId=response.data.developerId;
				//获取区域
				$http
					.get('building/getAllRegion',{
					})
					.success(function(response){
						$scope.regionList=response.data;
						for (var i in $scope.regionList) {
							if ($scope.regionList[i].regionId==regionId) {
								$scope.x=$scope.regionList[i];
								break;
							}
						}
					});
					//获取开发商
					$http
					.get('building/getAllDeveloper',{
					})
					.success(function(response){
						$scope.developerList=response.data;
						for (var j in $scope.developerList) {
							if ($scope.developerList[j].developerId==developerId) {
								$scope.y=$scope.developerList[j];
								break;
							}
						}
					});
				
				$scope.buildingName=response.data.buildingName;
				$scope.buildingLocation=response.data.buildingLocation;
				$scope.averagePrice=response.data.averagePrice;
				$scope.openingTime=new Date(response.data.openingTime).toISOString().substring(0, 10);
				$scope.launchTime=new Date(response.data.launchTime).toISOString().substring(0, 10);
				$scope.constructionArea=response.data.constructionArea;
				$scope.householdNum=response.data.householdNum;
				$scope.greeningRate=response.data.greeningRate;
				$scope.plotRate=response.data.plotRate;
				$scope.duration=response.data.duration;
				$scope.saleSiteLocation=response.data.saleSiteLocation;
				$scope.developmentprofile=response.data.developmentprofile;
				$scope.recommendReason=response.data.recommendReason;
				$scope.buildingType=response.data.buildingType;
				$scope.phoneFdz=response.data.phoneFdz.split("-");
				$scope.phoneFdz1=$scope.phoneFdz[3];
				$scope.phoneFdz2=$scope.phoneFdz[4];
				$scope.buildingLabel=response.data.buildingLabel.split(",");
				$scope.buildingLabel1=$scope.buildingLabel[0]==1?1:0;
				$scope.buildingLabel2=$scope.buildingLabel[1]==1?1:0;
				$scope.buildingLabel3=$scope.buildingLabel[2]==1?1:0;
				$scope.buildingLabel4=$scope.buildingLabel[3]==1?1:0;
				$scope.buildingLabel5=$scope.buildingLabel[4]==1?1:0;
				$scope.buildingLabel6=$scope.buildingLabel[5]==1?1:0;
				$scope.buildingLabel7=$scope.buildingLabel[6]==1?1:0;
				$scope.buildingLabel8=$scope.buildingLabel[7]==1?1:0;
				$scope.buildingLabel9=$scope.buildingLabel[8]==1?1:0;
				$scope.buildingLabel10=$scope.buildingLabel[9]==1?1:0;
				$scope.buildingLabel11=$scope.buildingLabel[10]==1?1:0;
			});
			//update保存并下一步
			$scope.saveType = function() {
				if ($scope.buildingName==''||$scope.buildingName==null) {
					alert("楼盘名称不能为空！")
				}else if ($scope.x.regionId==''||$scope.x.regionId==null) {
					alert("所在区域不能为空！")
				}else if ($scope.y.developerId==''||$scope.y.developerId==null) {
					alert("开发商不能为空！")
				}else if ($scope.buildingLocation==''||$scope.buildingLocation==null) {
					alert("详细地址不能为空！")
				}else if ($scope.averagePrice==''||$scope.averagePrice==null) {
					alert("均价不能为空！")
				}else if ($scope.openingTime==''||$scope.openingTime==null) {
					alert("开盘时间不能为空！")
				}else if ($scope.launchTime==''||$scope.launchTime==null) {
					alert("入住时间不能为空！")
				}else if ($scope.householdNum==''||$scope.householdNum==null) {
					alert("总户数不能为空！")
				}else if ($scope.duration==''||$scope.duration==null) {
					alert("产权年限不能为空！")
				}else if ($scope.saleSiteLocation==''||$scope.saleSiteLocation==null) {
					alert("售楼地址不能为空！")
				}else if ($scope.recommendReason==''||$scope.recommendReason==null) {
					alert("推荐理由不能为空！")
				}else if ($scope.phoneFdz1==''||$scope.phoneFdz1==null||$scope.phoneFdz2==''||$scope.phoneFdz2==null) {
					alert("400电话不能为空！")
				}else{
					var today = new Date();
					$scope.formatDate = $filter('date')(today, 'yyyy-MM-dd');
					$http
						.post('building/updateBuilding',{
							buildingId:$stateParams.buildingId,
							buildingName:$scope.buildingName,
							regionId:$scope.x.regionId,
							developerId:$scope.y.developerId,
							buildingLocation:$scope.buildingLocation,
							buildingType:$scope.buildingType,
							averagePrice:$scope.averagePrice,
							openingTime:$scope.openingTime,
							launchTime:$scope.launchTime,
							constructionArea:$scope.constructionArea,
							householdNum:$scope.householdNum,
							saleSiteLocation:$scope.saleSiteLocation,
							duration:$scope.duration,
							plotRate:$scope.plotRate,
							greeningRate:$scope.greeningRate,
							createTime:$scope.formatDate,
							saleSitePhone:null,
							propertyId:null,
							buildingLabel:$scope.buildingLabel1+","+$scope.buildingLabel2+","+$scope.buildingLabel3+","+$scope.buildingLabel4+","+$scope.buildingLabel5+","+$scope.buildingLabel6+","+$scope.buildingLabel7+","+$scope.buildingLabel8+","+$scope.buildingLabel9+","+$scope.buildingLabel10+","+$scope.buildingLabel11,
							recommendReason:$scope.recommendReason,
							phoneFdz:"400-800-8600-"+$scope.phoneFdz1+"-"+$scope.phoneFdz2,
							developmentprofile:$scope.developmentprofile												
						})
						.success(function(response){
							if (response.success==true) {
								alert("录入成功");
								$location.path('index/listBuildingManagement');
							}else{
								alert("录入失败");
							}
						});
				}
			}
		}else{
			//普通录入
			//获取区域
			$http
				.get('building/getAllRegion',{
				})
				.success(function(response){
					$scope.regionList=response.data;
				});
				//获取开发商
				$http
					.get('building/getAllDeveloper',{
				})
				.success(function(response){
					$scope.developerList=response.data;
				});

			$scope.buildingLabel1=$scope.buildingLabel1==1?1:0;
			$scope.buildingLabel2=$scope.buildingLabel2==1?1:0;
			$scope.buildingLabel3=$scope.buildingLabel3==1?1:0;
			$scope.buildingLabel4=$scope.buildingLabel4==1?1:0;
			$scope.buildingLabel5=$scope.buildingLabel5==1?1:0;
			$scope.buildingLabel6=$scope.buildingLabel6==1?1:0;
			$scope.buildingLabel7=$scope.buildingLabel7==1?1:0;
			$scope.buildingLabel8=$scope.buildingLabel8==1?1:0;
			$scope.buildingLabel9=$scope.buildingLabel9==1?1:0;
			$scope.buildingLabel10=$scope.buildingLabel10==1?1:0;
			$scope.buildingLabel11=$scope.buildingLabel11==1?1:0;

			//保存并下一步
			$scope.saveType = function() {
				if ($scope.buildingName==''||$scope.buildingName==null) {
					alert("楼盘名称不能为空！")
				}else if ($scope.x.regionId==''||$scope.x.regionId==null) {
					alert("所在区域不能为空！")
				}else if ($scope.y.developerId==''||$scope.y.developerId==null) {
					alert("开发商不能为空！")
				}else if ($scope.buildingLocation==''||$scope.buildingLocation==null) {
					alert("详细地址不能为空！")
				}else if ($scope.averagePrice==''||$scope.averagePrice==null) {
					alert("均价不能为空！")
				}else if ($scope.openingTime==''||$scope.openingTime==null) {
					alert("开盘时间不能为空！")
				}else if ($scope.launchTime==''||$scope.launchTime==null) {
					alert("入住时间不能为空！")
				}else if ($scope.householdNum==''||$scope.householdNum==null) {
					alert("总户数不能为空！")
				}else if ($scope.duration==''||$scope.duration==null) {
					alert("产权年限不能为空！")
				}else if ($scope.saleSiteLocation==''||$scope.saleSiteLocation==null) {
					alert("售楼地址不能为空！")
				}else if ($scope.recommendReason==''||$scope.recommendReason==null) {
					alert("推荐理由不能为空！")
				}else if ($scope.phoneFdz1==''||$scope.phoneFdz1==null||$scope.phoneFdz2==''||$scope.phoneFdz2==null) {
					alert("400电话不能为空！")
				}else{
					var today = new Date();
					$scope.formatDate = $filter('date')(today, 'yyyy-MM-dd');		
					$http
						.post('building/addBuilding',{
							buildingName:$scope.buildingName,
							regionId:$scope.x.regionId,
							developerId:$scope.y.developerId,
							buildingLocation:$scope.buildingLocation,
							buildingType:$scope.buildingType,
							averagePrice:$scope.averagePrice,
							openingTime:$scope.openingTime,
							launchTime:$scope.launchTime,
							constructionArea:$scope.constructionArea,
							householdNum:$scope.householdNum,
							saleSiteLocation:$scope.saleSiteLocation,
							duration:$scope.duration,
							plotRate:$scope.plotRate,
							greeningRate:$scope.greeningRate,
							createTime:$scope.formatDate,
							saleSitePhone:null,
							propertyId:null,
							buildingLabel:$scope.buildingLabel1+","+$scope.buildingLabel2+","+$scope.buildingLabel3+","+$scope.buildingLabel4+","+$scope.buildingLabel5+","+$scope.buildingLabel6+","+$scope.buildingLabel7+","+$scope.buildingLabel8+","+$scope.buildingLabel9+","+$scope.buildingLabel10+","+$scope.buildingLabel11,
							recommendReason:$scope.recommendReason,
							phoneFdz:"400-800-8600-"+$scope.phoneFdz1+"-"+$scope.phoneFdz2,
							developmentprofile:$scope.developmentprofile								
						})
						.success(function(response){
							if (response.success==true) {
								alert("录入成功");
								$location.path('index/pictureSubmit/'+response.data);
							}else{
								alert("录入失败");
							}
						});
				}
			}
		}
	}])

	//户型录入与update
	.controller('typeEnter', ['$scope', '$stateParams', '$http', '$location', '$cookieStore','FileUploader', function($scope,$stateParams, $http, $location, $cookieStore,FileUploader) {
		$('input .box11').keyup(function(){  
            var c=$(this);  
            if(/[^\d]/.test(c.val())){//替换非数字字符  
              var temp_amount=c.val().replace(/[^\d]/g,'');  
              $(this).val(temp_amount);  
            }  
         }) 

		$scope.ifFail=false;
		//上传图片
		//公共方法
    	$scope.deletePic = function(list, i) {
    		list.splice(i, 1);
    	}
    	function onAfterAddingFile(item) {
			item.upload();
		}
		console.log($stateParams.buildingId);

		$scope.effectpicuploader = new FileUploader({
			url: 'houseStyle/uploadStylePic'
		});

		$scope.realPicuploader = new FileUploader({
			url: 'houseStyle/uploadStylePic'
		});

		if ($stateParams.styleId==0) {
			$scope.ifNotUpdate=true;

			//效果图
			$scope.effectPicUrl = [];
			$scope.effectpicuploader.onAfterAddingFile = onAfterAddingFile;
			$scope.effectpicuploader.onSuccessItem = function(item, response, status, headers) {
				$scope.effectPicUrl.push(response.data);
			}
		
			//实景图
			$scope.realPicUrl=[];
			$scope.realPicuploader.onAfterAddingFile = onAfterAddingFile;
			$scope.realPicuploader.onSuccessItem = function(item, response, status, headers) {
				$scope.realPicUrl.push(response.data);
			}

			//继续添加户型
			$scope.continueAdd=function(){
				if ($scope.room==""||$scope.room==null||$scope.hall==""||$scope.hall==null||$scope.restroom==""||$scope.restroom==null||$scope.houseStyleCode==""||$scope.houseStyleCode==null) {
					alert("户型不能为空！");
				}else if ($scope.referencePrice==""||$scope.referencePrice==null) {
					alert("参考售价不能为空！");
				}else if ($scope.referenceMonthlyPayments==""||$scope.referenceMonthlyPayments==null) {
					alert("参考月供不能为空！");
				}else if ($scope.downPayment==""||$scope.downPayment==null) {
					alert("首付不能为空！");
				}else if ($scope.styleArea==""||$scope.styleArea==null) {
					alert("面积不能为空！");
				}else if ($scope.styleDescription1!=true&&$scope.styleDescription2!=true&&$scope.styleDescription3!=true&&$scope.styleDescription4!=true) {
					alert("标签不能为空！");
				}else if ($scope.recommendReason==""||$scope.recommendReason==null) {
					alert("推荐理由不能为空！");
				}else{

					$scope.stylePic=$scope.effectPicUrl.join(",");
					$scope.specialitiesPic=$scope.realPicUrl.join(",");

					$scope.styleDescription1 = $scope.styleDescription1==true?1:0;
					$scope.styleDescription2 = $scope.styleDescription2==true?1:0;
					$scope.styleDescription3 = $scope.styleDescription3==true?1:0;
					$scope.styleDescription4 = $scope.styleDescription4==true?1:0;
					$scope.isCooperated = $scope.isCooperated==true?true:false;
					$http
						.post('houseStyle/addStyle',{
							styleId:null,
							houseStyleCode:$scope.houseStyleCode,
							style:$scope.room+","+$scope.hall+","+$scope.restroom,
							referencePrice:$scope.referencePrice,
							referenceMonthlyPayments:$scope.referenceMonthlyPayments,
							downPayment:$scope.downPayment,
							styleArea:$scope.styleArea,
							auditStatus:null,
							styleDescription:$scope.styleDescription1+","+$scope.styleDescription2+","+$scope.styleDescription3+","+$scope.styleDescription4,
							stylePic:$scope.stylePic,
							specialitiesPic:$scope.specialitiesPic,
							recommendReason:$scope.recommendReason,
							isCooperated:$scope.isCooperated,
							buildingId:$stateParams.buildingId,
							applicationStatus:null,
							auditNotPassReason:null								
						})
						.success(function(response){
							if (response.success==true) {
								alert("录入成功");
								window.location.reload();

							}else{
								alert("录入失败");
							}
						});
				}
			}
			//保存并下一步
			$scope.saveType = function() {
				if ($scope.room==""||$scope.room==null||$scope.hall==""||$scope.hall==null||$scope.restroom==""||$scope.restroom==null||$scope.houseStyleCode==""||$scope.houseStyleCode==null) {
					alert("户型不能为空！");
				}else if ($scope.referencePrice==""||$scope.referencePrice==null) {
					alert("参考售价不能为空！");
				}else if ($scope.referenceMonthlyPayments==""||$scope.referenceMonthlyPayments==null) {
					alert("参考月供不能为空！");
				}else if ($scope.downPayment==""||$scope.downPayment==null) {
					alert("首付不能为空！");
				}else if ($scope.styleArea==""||$scope.styleArea==null) {
					alert("面积不能为空！");
				}else if ($scope.styleDescription1!=true&&$scope.styleDescription2!=true&&$scope.styleDescription3!=true&&$scope.styleDescription4!=true) {
					alert("标签不能为空！");
				}else if ($scope.recommendReason==""||$scope.recommendReason==null) {
					alert("推荐理由不能为空！");
				}else{
					$scope.stylePic=$scope.effectPicUrl.join(",");
					$scope.specialitiesPic=$scope.realPicUrl.join(",");
					if ($scope.stylePic==null||$scope.stylePic=='') {
						alert("户型图不能为空！");
					}else{


					$scope.styleDescription1 = $scope.styleDescription1==true?1:0;
					$scope.styleDescription2 = $scope.styleDescription2==true?1:0;
					$scope.styleDescription3 = $scope.styleDescription3==true?1:0;
					$scope.styleDescription4 = $scope.styleDescription4==true?1:0;
					$scope.isCooperated = $scope.isCooperated==true?true:false;
					$http
						.post('houseStyle/addStyle',{
							styleId:null,
							houseStyleCode:$scope.houseStyleCode,
							style:$scope.room+","+$scope.hall+","+$scope.restroom,
							referencePrice:$scope.referencePrice,
							referenceMonthlyPayments:$scope.referenceMonthlyPayments,
							downPayment:$scope.downPayment,
							styleArea:$scope.styleArea,
							auditStatus:null,
							styleDescription:$scope.styleDescription1+","+$scope.styleDescription2+","+$scope.styleDescription3+","+$scope.styleDescription4,
							stylePic:$scope.stylePic,
							specialitiesPic:$scope.specialitiesPic,
							recommendReason:$scope.recommendReason,
							isCooperated:$scope.isCooperated,
							buildingId:$stateParams.buildingId,
							applicationStatus:null,
							auditNotPassReason:null								
						})
						.success(function(response){
							if (response.success==true) {
								alert("录入成功");
								$location.path('index/houseEnter/'+$stateParams.buildingId+'&0');
							}else{
								alert("录入失败");
							}
						});
					}}
				}
		}else{
			//update
			$scope.ifNotUpdate=false;
			$http
				.get('houseStyle/getSingleHouseStyle',{
					params:{
						styleId:$stateParams.styleId
					}		
				})
				.success(function(response){
					if (response.data.auditNotPassReason!=""&&response.data.auditNotPassReason!=null) {
						$scope.ifFail=true;
						$scope.auditNotPassReason=response.data.auditNotPassReason;
					}
					//效果图
					if(response.data.stylePic==''||response.data.stylePic==null){
						$scope.effectPicUrl=[];
					}else{
						$scope.effectPicUrl = response.data.stylePic.split(",");
					}		
					$scope.effectpicuploader.onAfterAddingFile = onAfterAddingFile;
					$scope.effectpicuploader.onSuccessItem = function(item, response, status, headers) {
						$scope.effectPicUrl.push(response.data);
					}
		
					//实景图
					if (response.data.specialitiesPic==null||response.data.specialitiesPic=='') {
						$scope.realPicUrl=[];
					} else {
						$scope.realPicUrl=response.data.specialitiesPic.split(",");
					}	
					$scope.realPicuploader.onAfterAddingFile = onAfterAddingFile;
					$scope.realPicuploader.onSuccessItem = function(item, response, status, headers) {
						$scope.realPicUrl.push(response.data);
					}

					$scope.style=response.data.style.split(',');
					$scope.styleDescription=response.data.styleDescription.split(',');
					$scope.room=$scope.style[0];
					$scope.hall=$scope.style[1];
					$scope.restroom=$scope.style[2];
					$scope.houseStyleCode=response.data.houseStyleCode;
					$scope.referencePrice=response.data.referencePrice;
					$scope.referenceMonthlyPayments=response.data.referenceMonthlyPayments;
					$scope.downPayment=response.data.downPayment;
					$scope.styleArea=response.data.styleArea;
					$scope.styleDescription1=$scope.styleDescription[0]==1?true:false;
					$scope.styleDescription2=$scope.styleDescription[1]==1?true:false;
					$scope.styleDescription3=$scope.styleDescription[2]==1?true:false;
					$scope.styleDescription4=$scope.styleDescription[3]==1?true:false;
					$scope.recommendReason=response.data.recommendReason;
					$scope.isCooperated=response.data.isCooperated;

					$scope.auditStatus=response.data.auditStatus;
					$scope.auditNotPassReason=response.data.auditNotPassReason;
					$scope.applicationStatus=response.data.applicationStatus;					
				});

			$scope.saveType = function() {
				if ($scope.room==""||$scope.room==null||$scope.hall==""||$scope.hall==null||$scope.restroom==""||$scope.restroom==null||$scope.houseStyleCode==""||$scope.houseStyleCode==null) {
					alert("户型不能为空！");
				}else if ($scope.referencePrice==""||$scope.referencePrice==null) {
					alert("参考售价不能为空！");
				}else if ($scope.referenceMonthlyPayments==""||$scope.referenceMonthlyPayments==null) {
					alert("参考月供不能为空！");
				}else if ($scope.downPayment==""||$scope.downPayment==null) {
					alert("首付不能为空！");
				}else if ($scope.styleArea==""||$scope.styleArea==null) {
					alert("面积不能为空！");
				}else if ($scope.styleDescription1!=1&&$scope.styleDescription2!=1&&$scope.styleDescription3!=1&&$scope.styleDescription4!=1) {
					alert("标签不能为空！");
				}else if ($scope.recommendReason==""||$scope.recommendReason==null) {
					alert("推荐理由不能为空！");
				}else{

					$scope.stylePic=$scope.effectPicUrl.join(",");
					$scope.specialitiesPic=$scope.realPicUrl.join(",");
					$scope.styleDescription1 = $scope.styleDescription1==true?1:0;
					$scope.styleDescription2 = $scope.styleDescription2==true?1:0;
					$scope.styleDescription3 = $scope.styleDescription3==true?1:0;
					$scope.styleDescription4 = $scope.styleDescription4==true?1:0;
					$scope.isCooperated = $scope.isCooperated==true?true:false;
					$http
						.post('houseStyle/updateStyle',{
							styleId:$stateParams.styleId,
							houseStyleCode:$scope.houseStyleCode,
							style:$scope.room+","+$scope.hall+","+$scope.restroom,
							referencePrice:$scope.referencePrice,
							referenceMonthlyPayments:$scope.referenceMonthlyPayments,
							downPayment:$scope.downPayment,
							styleArea:$scope.styleArea,
							auditStatus:$scope.auditStatus,
							styleDescription:$scope.styleDescription1+","+$scope.styleDescription2+","+$scope.styleDescription3+","+$scope.styleDescription4,
							stylePic:$scope.stylePic,
							specialitiesPic:$scope.specialitiesPic,
							recommendReason:$scope.recommendReason,
							isCooperated:$scope.isCooperated,
							buildingId:$stateParams.buildingId,
							applicationStatus:$scope.applicationStatus,
							auditNotPassReason:$scope.auditNotPassReason								
						})
						.success(function(response){
							if (response.success==true) {
								alert("录入成功");
								$location.path('index/listHouseManagement');
							}else{
								alert("录入失败");
							}
						});
				}
			}
		}
	}])

	//房源录入与update
	.controller('houseEnter', ['$scope', '$stateParams', '$http', '$location', '$cookieStore','FileUploader',function($scope, $stateParams, $http, $location, $cookieStore,FileUploader) {
		$('input .box11').keyup(function(){  
            var c=$(this);  
            if(/[^\d]/.test(c.val())){//替换非数字字符  
              var temp_amount=c.val().replace(/[^\d]/g,'');  
              $(this).val(temp_amount);  
            }  
         }) 

		//获取所有户型
		$http
			.get('houseStyle/ getAllHouseStyle',{
				params:{
					buildingId:$stateParams.buildingId,
					pageMaxNum:100,
					pageNo:1
				}		
			})
			.success(function(response){
				$scope.typeList=response.data;
			});
			$scope.ifFail=false;

			//上传图片
			//公共方法
    		$scope.deletePic = function(list, i) {
    			list.splice(i, 1);
    		}
    		function onAfterAddingFile(item) {
				item.upload();
			}
			$scope.submitPicAndMapInfo = function () {
				var buildingPicList = $scope.effectPicList;
			}
			$scope.effectpicuploader = new FileUploader({
				url: 'houseStyle/uploadStylePic'
			});

			if ($stateParams.houseId==0) {
				$scope.ifNotUpdate=true;
				//效果图
				$scope.effectPicUrl = [];
				$scope.effectpicuploader.onAfterAddingFile = onAfterAddingFile;
				$scope.effectpicuploader.onSuccessItem = function(item, response, status, headers) {
					$scope.effectPicUrl.push(response.data);
				}
				//继续添加房源
				$scope.continueAdd=function(){
					if ($scope.x.styleId==''||$scope.x.styleId==null) {
						alert("户型不能为空！");
					}else if ($scope.buildingNo==''||$scope.buildingNo==null||$scope.unit==''||$scope.unit==null||$scope.houseNum==''||$scope.houseNum==null) {
						alert("房源楼号不能为空！");
					}else if ($scope.orginalPrice==''||$scope.orginalPrice==null) {
						alert("参考售价不能为空！");
					}else if ($scope.downPayment==''||$scope.downPayment==null) {
						alert("首付不能为空！");
					}else if ($scope.monthlyPayment==''||$scope.monthlyPayment==null) {
						alert("参考月供不能为空！");
					}else if ($scope.face==''||$scope.face==null) {
						alert("户型朝向不能为空！");
					}else if ($scope.maxFloor==''||$scope.maxFloor==null||$scope.floor==''||$scope.floor==null) {
						alert("楼层不能为空！");
					}else if ($scope.area==''||$scope.area==null) {
						alert("住房面积不能为空！");
					}else{
						$scope.housePic=$scope.effectPicUrl.join(",");
						$http
							.post('house/addHouse',{
								houseId:$stateParams.houseId,
								styleId:$scope.x.styleId,
								buildingId:$stateParams.buildingId,
								unit:$scope.unit,
								houseNum:$scope.houseNum,
								orginalPrice:$scope.orginalPrice,
								downPayment:$scope.downPayment,
								monthlyPayment:$scope.monthlyPayment,
								auditStatus:null,
								face:$scope.face,
								maxFloor:$scope.maxFloor,
								floor:$scope.floor,
								area:$scope.area,
								decoration:$scope.decoration,
								basementSquare:$scope.basementSquare,
								parkingLotPrice:$scope.parkingLotPrice,
								parkingPlaceArea:$scope.parkingPlaceArea,
								housePic:$scope.housePic,
								auditNotPassReason:null,
								houseApplicationStatus:null,
								buildingNo:$scope.buildingNo
							})
							.success(function(response){
								if (response.success==true) {
									alert("录入成功");
									window.location.reload();
								}else{
									alert("录入失败");
								}
							});
					}
				}
				//保存
				$scope.saveType = function() {
					if ($scope.x.styleId==''||$scope.x.styleId==null) {
						alert("户型不能为空！");
					}else if ($scope.buildingNo==''||$scope.buildingNo==null||$scope.unit==''||$scope.unit==null||$scope.houseNum==''||$scope.houseNum==null) {
						alert("房源楼号不能为空！");
					}else if ($scope.orginalPrice==''||$scope.orginalPrice==null) {
						alert("参考售价不能为空！");
					}else if ($scope.downPayment==''||$scope.downPayment==null) {
						alert("首付不能为空！");
					}else if ($scope.monthlyPayment==''||$scope.monthlyPayment==null) {
						alert("参考月供不能为空！");
					}else if ($scope.face==''||$scope.face==null) {
						alert("户型朝向不能为空！");
					}else if ($scope.maxFloor==''||$scope.maxFloor==null||$scope.floor==''||$scope.floor==null) {
						alert("楼层不能为空！");
					}else if ($scope.area==''||$scope.area==null) {
						alert("住房面积不能为空！");
					}else{
						$scope.housePic=$scope.effectPicUrl.join(",");
						$http
							.post('house/addHouse',{
								houseId:$stateParams.houseId,
								styleId:$scope.x.styleId,
								buildingId:$stateParams.buildingId,
								unit:$scope.unit,
								houseNum:$scope.houseNum,
								orginalPrice:$scope.orginalPrice,
								downPayment:$scope.downPayment,
								monthlyPayment:$scope.monthlyPayment,
								auditStatus:null,
								face:$scope.face,
								maxFloor:$scope.maxFloor,
								floor:$scope.floor,
								area:$scope.area,
								decoration:$scope.decoration,
								basementSquare:$scope.basementSquare,
								parkingLotPrice:$scope.parkingLotPrice,
								parkingPlaceArea:$scope.parkingPlaceArea,
								housePic:$scope.housePic,
								auditNotPassReason:null,
								houseApplicationStatus:null,
								buildingNo:$scope.buildingNo
							})
							.success(function(response){
								if (response.success==true) {
									alert("录入成功");
									$location.path('index/listBuildingManagement');
								}else{
									alert("录入失败");
								}
							});
					}
				}
			}else{
				//update
				$scope.ifNotUpdate=false;
				$http
					.get('house/getSingleHouse',{
						params:{
							houseId:$stateParams.houseId
						}		
					})
					.success(function(response){
						if (response.data.auditNotPassReason!=""&&response.data.auditNotPassReason!=null) {
							$scope.ifFail=true;
							$scope.auditNotPassReason=response.data.auditNotPassReason;
						}
						//效果图
						if (response.data.housePic==null||response.data.housePic=='') {
							$scope.effectPicUrl=[];
						}else{
							$scope.effectPicUrl = response.data.housePic.split(",");
						}
						$scope.effectpicuploader.onAfterAddingFile = onAfterAddingFile;
						$scope.effectpicuploader.onSuccessItem = function(item, response, status, headers) {
						$scope.effectPicUrl.push(response.data);
					}
					for (var i in $scope.typeList) {
						if ($scope.typeList[i].styleId==response.data.styleId) {
							$scope.x=$scope.typeList[i];
						}
					}
					$scope.styleId=response.data.styleId;
					$scope.buildingNo=response.data.buildingNo;
					$scope.unit=response.data.unit;
					$scope.houseNum=response.data.houseNum;
					$scope.orginalPrice=response.data.orginalPrice;
					$scope.monthlyPayment=response.data.monthlyPayment;
					$scope.downPayment=response.data.downPayment;
					$scope.face=response.data.face;
					$scope.maxFloor=response.data.maxFloor;
					$scope.floor=response.data.floor;
					$scope.area=response.data.area;
					$scope.decoration=response.data.decoration;
					$scope.basementSquare=response.data.basementSquare;
					$scope.parkingLotPrice=response.data.parkingLotPrice;
					$scope.parkingPlaceArea=response.data.parkingPlaceArea;
					$scope.recommendReason=response.data.recommendReason;
					$scope.houseApplicationStatus=response.data.houseApplicationStatus;
					$scope.auditStatus=response.data.auditStatus;
				});
				$scope.saveType = function() {
					if ($scope.x.styleId==''||$scope.x.styleId==null) {
						alert("户型不能为空！");
					}else if ($scope.buildingNo==''||$scope.buildingNo==null||$scope.unit==''||$scope.unit==null||$scope.houseNum==''||$scope.houseNum==null) {
						alert("房源楼号不能为空！");
					}else if ($scope.orginalPrice==''||$scope.orginalPrice==null) {
						alert("参考售价不能为空！");
					}else if ($scope.downPayment==''||$scope.downPayment==null) {
						alert("首付不能为空！");
					}else if ($scope.monthlyPayment==''||$scope.monthlyPayment==null) {
						alert("参考月供不能为空！");
					}else if ($scope.face==''||$scope.face==null) {
						alert("户型朝向不能为空！");
					}else if ($scope.maxFloor==''||$scope.maxFloor==null||$scope.floor==''||$scope.floor==null) {
						alert("楼层不能为空！");
					}else if ($scope.area==''||$scope.area==null) {
						alert("住房面积不能为空！");
					}else{
						$scope.housePic=$scope.effectPicUrl.join(",");
						$http
						.post('house/updateHouse',{
							houseId:$stateParams.houseId,
							styleId:$scope.x.styleId,
							buildingId:$stateParams.buildingId,
							unit:$scope.unit,
							houseNum:$scope.houseNum,
							orginalPrice:$scope.orginalPrice,
							downPayment:$scope.downPayment,
							monthlyPayment:$scope.monthlyPayment,
							auditStatus:$scope.auditStatus,
							face:$scope.face,
							maxFloor:$scope.maxFloor,
							floor:$scope.floor,
							area:$scope.area,
							decoration:$scope.decoration,
							basementSquare:$scope.basementSquare,
							parkingLotPrice:$scope.parkingLotPrice,
							parkingPlaceArea:$scope.parkingPlaceArea,
							housePic:$scope.housePic,
							auditNotPassReason:$scope.auditNotPassReason,
							houseApplicationStatus:$scope.houseApplicationStatus,
							buildingNo:$scope.buildingNo
						})
						.success(function(response){
							if (response.success==true) {
								alert("录入成功");
								$location.path('index/listSourceManagement');
							}else{
								alert("录入失败");
							}
						});
				}
			}
		}
	}])

	//楼盘审核
	.controller('buildingAudit', function($scope, $stateParams, $http, $location, $cookieStore) {
		if ($stateParams.buttonShow==1) {
			$scope.buttonShow=true;
		}else{
			$scope.buttonShow=false;
		}
		$http
			.get('building/getBuildingInfo',{
				params:{
					buildingId:$stateParams.buildingId//4
				}		
			})
			.success(function(response){
				$scope.buildingInfo=response.data;
				$scope.ifFail=false;
				if ($scope.buildingInfo.auditNotPassReason!=""&&$scope.buildingInfo.auditNotPassReason!=null) {
					$scope.ifFail=true;
				}
				$scope.buildingInfo.buildingLabel=$scope.buildingInfo.buildingLabel.split(",");
				if ($scope.buildingInfo.buildingLabel[0]==1) {
					$scope.buildingInfo.buildingLabel[0]="水景地产/";
				}else{
					$scope.buildingInfo.buildingLabel[0]="";
				}
				if ($scope.buildingInfo.buildingLabel[1]==1) {
					$scope.buildingInfo.buildingLabel[1]="海景地产/";
				}else{
					$scope.buildingInfo.buildingLabel[1]="";
				}
				if ($scope.buildingInfo.buildingLabel[2]==1) {
					$scope.buildingInfo.buildingLabel[2]="公园地产/";
				}else{
					$scope.buildingInfo.buildingLabel[2]="";
				}
				if ($scope.buildingInfo.buildingLabel[3]==1) {
					$scope.buildingInfo.buildingLabel[3]="旅游地产/";
				}else{
					$scope.buildingInfo.buildingLabel[3]="";
				}
				if ($scope.buildingInfo.buildingLabel[4]==1) {
					$scope.buildingInfo.buildingLabel[4]="景观居所/";
				}else{
					$scope.buildingInfo.buildingLabel[4]="";
				}
				if ($scope.buildingInfo.buildingLabel[5]==1) {
					$scope.buildingInfo.buildingLabel[5]="宜居生态/";
				}else{
					$scope.buildingInfo.buildingLabel[5]="";
				}
				if ($scope.buildingInfo.buildingLabel[6]==1) {
					$scope.buildingInfo.buildingLabel[6]="其他/";
				}else{
					$scope.buildingInfo.buildingLabel[6]="";
				}
				if ($scope.buildingInfo.buildingLabel[7]==1) {
					$scope.buildingInfo.buildingLabel[7]="休闲度假/";
				}else{
					$scope.buildingInfo.buildingLabel[7]="";
				}
				if ($scope.buildingInfo.buildingLabel[8]==1) {
					$scope.buildingInfo.buildingLabel[8]="养老房/";
				}else{
					$scope.buildingInfo.buildingLabel[8]="";
				}
				if ($scope.buildingInfo.buildingLabel[9]==1) {
					$scope.buildingInfo.buildingLabel[9]="婚房/";
				}else{
					$scope.buildingInfo.buildingLabel[9]="";
				}
				if ($scope.buildingInfo.buildingLabel[10]==1) {
					$scope.buildingInfo.buildingLabel[10]="投资旅游";
				}else{
					$scope.buildingInfo.buildingLabel[10]="";
				}
				$scope.buildingInfo.buildingLabel=$scope.buildingInfo.buildingLabel[0]+$scope.buildingInfo.buildingLabel[1]+$scope.buildingInfo.buildingLabel[2]+$scope.buildingInfo.buildingLabel[3]+$scope.buildingInfo.buildingLabel[4]+$scope.buildingInfo.buildingLabel[5]+$scope.buildingInfo.buildingLabel[6]+$scope.buildingInfo.buildingLabel[7]+$scope.buildingInfo.buildingLabel[8]+$scope.buildingInfo.buildingLabel[9]+$scope.buildingInfo.buildingLabel[10];
				//获取区域
				$http
					.get('building/getAllRegion',{
					})
					.success(function(response){
						for (var i = 0; i <response.count; i++) {
							if ($scope.buildingInfo.regionId==response.data[i].regionId) {
								$scope.buildingInfo.regionName=response.data[i].regionName;
							}
						}
					});
				//获取开发商
				$http
					.get('building/getAllDeveloper',{
					})
					.success(function(response){
						for (var i = 0; i <response.count; i++) {
							if ($scope.buildingInfo.developerId==response.data[i].developerId) {
								$scope.buildingInfo.developName=response.data[i].developName;
							}
						}
					});
				if ($scope.buildingInfo.buildingType==1) {
					$scope.buildingInfo.buildingType="在售";
				}else if ($scope.buildingInfo.buildingType==2) {
					$scope.buildingInfo.buildingType="待售";
				}else if ($scope.buildingInfo.buildingType==3) {
					$scope.buildingInfo.buildingType="售罄";
				}
			});

		//审核
		$scope.ifNotPass = false;
		$scope.submitReason = function() {
			$.post('building/auditBuildingApplication', {
				buildingId: $stateParams.buildingId,
				auditResult: false,
				auditNotPassReason: $scope.backMessage
			})
			.success(function(response) {
					if (response.success==true) {
						alert("提交审核结果成功");
						$location.path('index/listBuildingManagement');
					} else{
						alert("提交审核结果失败");
					}
					
					// $location.path('index/myCustomer');
				});
		}
		$scope.pass = function() {
			$http
				.get('building/auditBuildingApplication', {
					params: {
						buildingId: $stateParams.buildingId,
						auditResult: true,
						auditNotPassReason:''
					}
				})
				.success(function(response) {
					if (response.success==true) {
						alert("提交审核结果成功");
						$location.path('index/listBuildingManagement');
					} else{
						alert("提交审核结果失败");
					}
					// $location.path('index/myCustomer');
				});
		}
	})

	//户型审核
	.controller('typeAudit', function($scope, $stateParams, $http, $location, $cookieStore) {
		if ($stateParams.buttonShow==1) {
			$scope.buttonShow=true;
		}else{
			$scope.buttonShow=false;
		}
		$http
			.get('houseStyle/getSingleHouseStyle',{
				params:{
					styleId:$stateParams.styleId//1022
				}		
			})
			.success(function(response){
				$scope.typeInfo=response.data;
				$scope.ifFail=false;
				if ($scope.typeInfo.auditStatus=="13020200") {
					$scope.ifFail=true;
				}
				if ($scope.typeInfo.stylePic==null||$scope.typeInfo.stylePic=='') {
					$scope.typeInfo.stylePic=[];
				}else{
					$scope.typeInfo.stylePic=$scope.typeInfo.stylePic.split(',');
				}
				if ($scope.typeInfo.specialitiesPic==null||$scope.typeInfo.specialitiesPic=='') {
					$scope.typeInfo.specialitiesPic=[];
				}else{
					$scope.typeInfo.specialitiesPic=$scope.typeInfo.specialitiesPic.split(',');
				}	
				$scope.typeInfo.style=$scope.typeInfo.style.split(',');
				$scope.typeInfo.styleDescription=$scope.typeInfo.styleDescription.split(',');
				if ($scope.typeInfo.styleDescription[0]=='1') {
					$scope.typeInfo.styleDescription[0]="方正户型";
				} else {
					$scope.typeInfo.styleDescription[0]="";
				}
				if ($scope.typeInfo.styleDescription[1]=='1') {
					$scope.typeInfo.styleDescription[1]="南北通透";
				} else {
					$scope.typeInfo.styleDescription[1]="";
				}
				if ($scope.typeInfo.styleDescription[2]=='1') {
					$scope.typeInfo.styleDescription[2]="超大客厅";
				} else {
					$scope.typeInfo.styleDescription[2]="";
				}
				if ($scope.typeInfo.styleDescription[3]=='1') {
					$scope.typeInfo.styleDescription[3]="方正布局";
				} else {
					$scope.typeInfo.styleDescription[3]="";
				}
				if ($scope.typeInfo.isCooperated==true) {
					$scope.typeInfo.isCooperated="是";
				} else{
					$scope.typeInfo.isCooperated="否";
				}
			});

		//审核
		$scope.ifNotPass = false;
		$scope.submitReason = function() {
			$.post('houseStyle/houseStyleAudit', {
				styleId: $stateParams.styleId,
				status: false,
				auditNotPassReason: $scope.backMessage
			}).success(function(response) {
					if (response.success==true) {
						alert("提交审核结果成功");
						$location.path('index/listHouseManagement');
					} else{
						alert("提交审核结果失败");
					}
				});
		}
		$scope.pass = function() {
			$http
				.get('houseStyle/houseStyleAudit', {
					params: {
						styleId: $stateParams.styleId,
						status: true,
						auditNotPassReason:''
					}
				})
				.success(function(response) {
					if (response.success==true) {
						alert("提交审核结果成功");
						$location.path('index/listHouseManagement');
					} else{
						alert("提交审核结果失败");
					}
				});
		}
	})

	//房源审核
	.controller('houseAudit', function($scope, $stateParams, $http, $location, $cookieStore) {
		if ($stateParams.buttonShow==1) {
			$scope.buttonShow=true;
		}else{
			$scope.buttonShow=false;
		}
		$http
			.get('house/getSingleHouse',{
				params:{
					houseId:$stateParams.houseId//1253
				}		
			})
			.success(function(response){
				$scope.houseInfo=response.data;
				$scope.ifFail=false;
				if ($scope.houseInfo.auditStatus=="13020200") {
					$scope.ifFail=true;
				}
				if ($scope.houseInfo.housePic==null||$scope.houseInfo.housePic=='') {
					$scope.houseInfo.housePic=[];
				}else{
					$scope.houseInfo.housePic=$scope.houseInfo.housePic.split(',');
				}
				$http
					.get('houseStyle/ getAllHouseStyle',{
						params:{
							buildingId:$scope.houseInfo.buildingId,
							pageMaxNum:100,
							pageNo:1
						}		
					})
					.success(function(response){
						for (var i = 0; i < response.data.length; i++) {
							if (response.data[i].styleId== $scope.houseInfo.styleId) {
								$scope.houseInfo.houseStyleCode=response.data[i].houseStyleCode;
								$http
									.get('dictionary/getDictName',{
										params:{
											dictCode:$scope.houseInfo.face
										}		
									})
									.success(function(response){
										$scope.houseInfo.face=response.data;
									})
								$http
									.get('dictionary/getDictName',{
										params:{
											dictCode:$scope.houseInfo.decoration
										}		
									})
									.success(function(response){
										$scope.houseInfo.decoration=response.data;
									})
							}
						}
					})
			});

		//审核
		$scope.ifNotPass = false;

		$scope.submitReason = function() {
			$.ajax({
				url: 'house/auditHouseApplication',
				data: {
					houseId: $stateParams.houseId,
					auditResult: false,
					notPassReason: $scope.backMessage
				},
				type: 'POST',
				async: false,
				success: function(response) {
					if (response.success==true) {
						$scope.ifNotPass=false;
						alert("提交审核结果成功");
						$location.path('index/listSourceManagement');
					} else{
						alert("提交审核结果失败");
					}
				}
			})
			// $.post('house/auditHouseApplication', {
			// 	houseId: $stateParams.houseId,
			// 	auditResult: false,
			// 	notPassReason: $scope.backMessage
			// })
			// .success(function(response) {
			// 		if (response.success==true) {
			// 			$scope.ifNotPass=false;
			// 			alert("提交审核结果成功");
			// 			//goto();
			// 			$location.path('index/listSourceManagement');
			// 		} else{
			// 			alert("提交审核结果失败");
			// 		}
			// 	});
			$scope.$apply();
		}


		$scope.pass = function() {
			$http
				.get('house/auditHouseApplication', {
					params: {
						houseId: $stateParams.houseId,
						auditResult: true,
						notPassReason:''
					}
				})
				.success(function(response) {
					if (response.success==true) {
						alert("提交审核结果成功");
						$location.path('index/listSourceManagement');
					} else{
						alert("提交审核结果失败");
					}
				});
		}
		$scope.ifNot=function(aa){
			$scope.ifNotPass=aa;
		}
	});