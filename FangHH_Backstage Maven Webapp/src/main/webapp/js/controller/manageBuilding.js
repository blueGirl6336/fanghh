angular
	.module('manageBuildingCtrl', ['ngCookies'])
	//户型管理
	.controller('listHouseManagement', ['$scope', '$http', '$location', '$rootScope', '$cookieStore', function($scope, $http, $location, $rootScope, $cookieStore) {
		//填充楼盘名称
        $scope.buildingName = $cookieStore.get("buildingName");

        //确认登录人身份信息 
		var role = $cookieStore.get("role");
		if(role == "09021100" || role == "09021500")
		{
			$scope.lookShow = true;
		}
		else
		{
			$scope.lookShow = false;
		}

		/*
			翻页部分 
		*/
		$scope.page = {//页码状态
	        pageMax: 1,
	        pageNumber: 1,
	        changePage: function () {
	        }
	    }
	    //首先获得最大页面数量
	    $http({
	        url: "houseStyle/ getHouseStylePageNum",
	        method: "post",
	        headers: {
	            'Content-Type': 'multipart/form-data'
	        },
	        params: {
	            pageMaxNum: 10,
	            buildingId: $cookieStore.get("buildingId")
	        }
	    }).success(function (response) {
	        if (response.success == true) {
	            $scope.page.pageMax = response.data;
	        } else {
	            console.log("error");
	        }
	    });
	    //翻页函数
	    $scope.changePage = function (aimPage) {
	        console.log("i am changePage");
	        $scope.page.changePage(aimPage);
	    }
	    $scope.changePageFilter = function (aimPage) {
	        console.log("i am loadpage");
	        loadPage(aimPage);
	    }
	    //加载页面
	    function loadPage(page_id) {
	        $scope.page.pageNumber = page_id;
	        $scope.page.changePage = $scope.changePageFilter;
	        $http({
	            url: 'houseStyle/getAllHouseStyle',
	            method: "post",
	            headers: {
	                'Content-Type': 'multipart/form-data'
	            },
	            params: {
	                pageMaxNum: 10,
	                pageNo: page_id,
	                buildingId:$cookieStore.get("buildingId")
	            }
	        }).success(function (response) {
	            if (response.success == true) {


	            	var table = response.data;

					for(var i = 0; i < table.length; i++)
					{
						table[i].style = table[i].style.split(",");
						table[i].referencePrice = ((table[i].referencePrice)/10000).toFixed(1);
						table[i].downPayment = ((table[i].downPayment)/10000).toFixed(1);

						table[i]["look"] = "";
						table[i]["state"] = "";

						if(table[i].isCooperated == true)
						{
							table[i].isCooperated = "合作";
						}
						else 
						{
							table[i].isCooperated = "非合作";
						}
						//待上架
						if(table[i].applicationStatus == "01200100")
						{
							table[i].state="申请上架";
						}
						//已经上架
						else  if(table[i].applicationStatus == "01200300")
						{
							table[i].state="申请下架";
						}
						if(table[i].applicationStatus == "01200200" || table[i].applicationStatus == "01200400")
						{
							table[i].look="审核";
						}
						else
						{
							table[i].look="查看";
						}
						// if(table[i].applicationStatus == "01200500" || table[i].applicationStatus == "01200300")
						// {
						// 	table[i].look="审核";
						// }

					}
					//填充数据
					$scope.houseStyle = table;

					//翻页
	                $scope.refreshPageButton(page_id);

	                //批量上架
	    			$scope.manyUpBoard = function()
	    			{
	    				//获取到所有被选中的项目
	    				var checked = document.getElementsByName("houseStyle");
	    				//存放所有被选中项目的n
	    				var checkNum = [];
    					for(var i = 0;i < checked.length;i++)
    					{
        					if(checked[i].checked)
            				checkNum.push(i);
    					}

    					if(checkNum.length == 0)
    					{
    						alert("请选择需要上架的条目");
    					}
    					else
    					{
    						//全选是否在内
    						if(checkNum[0] == 0)//全选在内
    						{
    							//检测是否有不能申请上架的条目
    							var isExist = 0;//没有
    							for(var j = 1;j < (checkNum.length -1);j++)
    							{
    								var k = checkNum[j];
    								if(table[k-1].applicationStatus != "01200100")
    								{
    									isExist = 1;//有
    								}
    							}

    							//如果有不能上架的条目
    							if(isExist == 1)
    							{
    								alert("请选择能够上架的条目");
    							}
    							else//没有不能上架的条目
    							{
    								for(var j = 1;j < (checkNum.length -1);j++)
    								{
    									var k = checkNum[j];
    									singleUpBoard(table[k-1].styleId);
    								}
    								alert("上架成功");
    								loadPage($scope.page.pageNumber);
    							}
    						}
    						else//全选不在内
    						{
    							//检测是否有不能申请上架的条目
    							var isExist = 0;//没有
    							for(var j = 0;j < checkNum.length;j++)
    							{
    								var k = checkNum[j];
    								if(table[k-1].applicationStatus != "01200100")
    								{
    									isExist = 1;//有
    								}
    							}

    							//如果有不能上架的条目
    							if(isExist == 1)
    							{
    								alert("请选择能够上架的条目");
    							}
    							else//没有
    							{
    								for(var j = 0;j < checkNum.length;j++)
    								{
    									var k = checkNum[j];
    									singleUpBoard(table[k-1].styleId);
    								}
    								alert("上架成功");
    								loadPage($scope.page.pageNumber);
    							}
    						}
    					}
	    			}


	    			//批量下架
	    			$scope.manyDownBoard = function()
	    			{
	    				//获取到所有被选中的项目
	    				var checked = document.getElementsByName("houseStyle");
	    				//存放所有被选中项目的n
	    				var checkNum = [];
    					for(i = 0;i < checked.length;i++)
    					{
        					if(checked[i].checked)
            				checkNum.push(i);
    					}

    					if(checkNum.length == 0)
    					{
    						alert("请选择需要下架的条目");
    					}
    					else
    					{
    						//全选是否在内
    						if(checkNum[0] == 0)//全选在内
    						{
    							//检测是否有不能申请上架的条目
    							var isExist = 0;//没有
    							for(var j = 1;j < (checkNum.length -1);j++)
    							{
    								var k = checkNum[j];
    								if(table[k-1].applicationStatus != "01200300")
    								{
    									isExist = 1;//有
    								}
    							}

    							//如果有不能上架的条目
    							if(isExist == 1)
    							{
    								alert("请选择能够下架的条目");
    							}
    							else//没有不能上架的条目
    							{
    								for(var j = 1;j < (checkNum.length -1);j++)
    								{
    									var k = checkNum[j];
    									singleDownBoard(table[k-1].styleId);
    								}
    								alert("下架成功");
    								loadPage($scope.page.pageNumber);
    							}
    						}
    						else//全选不在内
    						{
    							//检测是否有不能申请上架的条目
    							var isExist = 0;//没有
    							for(var j = 0;j < checkNum.length;j++)
    							{
    								var k = checkNum[j];
    								if(table[k-1].applicationStatus != "01200300")
    								{
    									isExist = 1;//有
    								}
    							}

    							//如果有不能上架的条目
    							if(isExist == 1)
    							{
    								alert("请选择能够下架的条目");
    							}
    							else//没有
    							{
    								for(var j = 0;j < checkNum.length;j++)
    								{
    									var k = checkNum[j];
    									singleDownBoard(table[k-1].styleId);
    								}
    								alert("下架成功");
    								loadPage($scope.page.pageNumber);
    							}
    						}
    					}
	    			}
	            }
	        });
	    }

	    //先加载第一页
	    loadPage(1);

	    //更新翻页按钮
	    $scope.refreshPageButton = function (aimPage) {
	        $scope.page.pageNumber = aimPage;
	        $scope.pageButton = [];

	        if (aimPage >= 1 && aimPage <= 3) {
	            for (var i = 1; i <= aimPage; i++) {
	                $scope.pageButton[i] = i;
	            }

	            for (i; i <= 5; i++) { //将剩余位置置为null
	                if (i <= $scope.page.pageMax) { //aimPage+1
	                    $scope.pageButton[i] = i;
	                } else {
	                    $scope.pageButton[i] = null;
	                }
	            }
	        }
	        else if (aimPage > 3) {
	            if (aimPage + 2 <= $scope.page.pageMax) {
	                for (var i = 1; i <= 5; i++) {
	                    $scope.pageButton[i] = aimPage - 3 + i;
	                }
	            } else { //后面不足两页
	                var j = 0;
	                for (var i = 5; i >= 0; i--) {
	                    if (($scope.page.pageMax - i) < 0) {
	                        $scope.pageButton[i] = null;
	                    }
	                    else {
	                        $scope.pageButton[i] = $scope.page.pageMax - j;
	                        j++;
	                    }
	                }
	            }
	        }
	    }

	    //修改按钮
	    $scope.modify = function(styleId) {
            var buildingNum = $cookieStore.get("buildingId");
			$location.path('index/typeEnter/' + buildingNum +"&" + styleId);
		}

		//申请上架/申请下架
		$scope.upDownBoard = function(styleId, applicationStatus){
			var statusId;
			if(applicationStatus == "01200100" || applicationStatus == "01200300")
			{
				if(applicationStatus == "01200100")
				{
					statusId = true;
				}
				else
				{
					statusId = false;
				}
				$http({
	           		url: 'houseStyle/houseStyleApplication',
	            	method: "post",
	            	headers: {
	                	'Content-Type': 'multipart/form-data'
	            	},
	            	params: {
	                	styleId: styleId,
	                	status: statusId,
	            	}
	        	}).success(function (response) {
	        		if(response.success == true)
	        		{
	        			console.log("success");
	        			if(statusId == true)
	        			{
	        				alert("申请上架成功");
	        				loadPage($scope.page.pageNumber);
	        				//location.reload();
	        			}
	        			else
	        			{
	        				alert("申请下架成功");
	        				loadPage($scope.page.pageNumber);
	        				//location.reload();
	        			}
	        		}
	        		else
	        		{
	        			console.error("error");
	        		}
	        	});
			}

		}

		//查看/审核
	    $scope.lookOrExamine = function(styleId,status)
	    {
	    	//审核按钮
	    	if(status == "01200200" || status == "01200400")
	    	{
	    		$location.path('index/typeAudit/' + styleId + '&1');
	    	}
	    	else//查看
	    	{
	    		$location.path('index/typeAudit/' + $cookieStore.get("buildingId") + "&" + styleId + '&0');
	    	}
	    }

	    //添加新户型
	    $scope.newHouseStyle = function()
	    {
            var typeId = 0;
	    	$location.path('index/typeEnter/' + $cookieStore.get("buildingId") + "&" + typeId);
	    }

	    //逐个上架
	    function singleUpBoard(styleNum)
	    {
	    	$http({
	           	url: 'houseStyle/houseStyleApplication',
	            method: "post",
	            headers: {
	                'Content-Type': 'multipart/form-data'
	            },
	            params: {
	                styleId: styleNum,
	                status: true,
	            }
	        }).success(function (response) {
	        });
	    }

	    //逐个下架
	    function singleDownBoard(styleNum)
	    {
	    	$http({
	           	url: 'houseStyle/houseStyleApplication',
	            method: "post",
	            headers: {
	                'Content-Type': 'multipart/form-data'
	            },
	            params: {
	                styleId: styleNum,
	                status: false,
	            }
	        }).success(function (response) {
	        	console.log("批量下架成功");
	        });
	    }

	}])


	//房源管理
	.controller('listSourceManagement', ['$scope', '$http', '$location', '$rootScope', '$cookieStore', function($scope, $http, $location, $rootScope, $cookieStore) {
		//填充楼盘名称
        $scope.buildingName = $cookieStore.get("buildingName");

        //确认登录人身份信息 
		var role = $cookieStore.get("role");
		if(role == "09021100" || role == "09021500")
		{
			$scope.lookShow = true;
		}
		else
		{
			$scope.lookShow = false;
		}

		/*
			翻页部分 
		*/
		$scope.page = {//页码状态
	        pageMax: 1,
	        pageNumber:1,
	        changePage: function () {
	        }
	    }
	    //首先获得最大页面数量
	    $http({
	        url: "house/getHousePageNum",
	        method: "post",
	        headers: {
	            'Content-Type': 'multipart/form-data'
	        },
	        params: {
	            pageMaxNum: 10,
	            buildingId:$cookieStore.get("buildingId")
	        }
	    }).success(function (response) {
	        if (response.success == true) {
	            $scope.page.pageMax = response.data;
	        } else {
	            console.log("failTo get page num");
	        }
	    });

	    //翻页函数
	    $scope.changePage = function (aimPage) {
	        console.log("i am changePage");
	        $scope.page.changePage(aimPage);
	    }
	    $scope.changePageFilter = function (aimPage) {
	        console.log("i am loadpage");
	        loadPage(aimPage);
	    }

	    //加载页面
	    function loadPage(page_id) {
	        $scope.page.pageNumber = page_id;
	        $scope.page.changePage = $scope.changePageFilter;
	        $http({
	            url: 'house/getAllHouse',
	            method: "post",
	            headers: {
	                'Content-Type': 'multipart/form-data'
	            },
	            params: {
	                buildingId:$cookieStore.get("buildingId"),
	                pageMaxNum: 10,
	                pageNo: page_id
	            }
	        }).success(function (response) {
	        	if(response.success == true)
	        	{
	        		var table = response.data;

	        		for(var i = 0; i<table.length;i++)
	        		{
	         			getSingleHouseInfomation(table, i);

	        		}

	        		//填充数据
	        		$scope.houseSource = table;

	        		//翻页
	            	$scope.refreshPageButton(page_id);

	            	//批量上架
	    			$scope.manyUpBoard = function()
	    			{
	    				//获取到所有复选框
	    				var checked = document.getElementsByName("house");
	    				//存放所有被选中项目的n
	    				var checkNum = [];
	    				//判断是否为全选，即全选按钮是否被选中
	    				var allSelect = 0;
    					for(i = 0;i < checked.length;i++)
    					{
        					if(checked[i].checked)
            				checkNum.push(i);
    					}
    					if(checkNum.length == checked.length )
    					{
    						allSelect == 1;//全选也选中
    					}

    					if(checkNum.length == 0)
    					{
    						alert("请选择需要上架的条目");
    					}
    					else
    					{
    						//全选是否在内
    						if(allSelect == 1)//全选在内
    						{
    							//检测是否有不能申请上架的条目
    							var isExist = 0;//没有
    							for(var j = 0;j < (checkNum.length -1);j++)
    							{
    								var k = checkNum[j];
    								if(table[k].houseApplicationStatus != "01200100")
    								{
    									isExist = 1;//有
    								}
    							}

    							//如果有不能上架的条目
    							if(isExist == 1)
    							{
    								alert("请选择能够上架的条目");
    							}
    							else//没有不能上架的条目
    							{
    								for(var j = 0;j < (checkNum.length -1);j++)
    								{
    									var k = checkNum[j];
    									singleUpBoard(table[k].houseId);
    								}
    								alert("上架成功");
    								loadPage($scope.page.pageNumber);
    							}
    						}
    						else//全选不在内
    						{
    							//检测是否有不能申请上架的条目
    							var isExist = 0;//没有
    							for(var j = 0;j < checkNum.length;j++)
    							{
    								var k = checkNum[j];
    								if(table[k].houseApplicationStatus != "01200100")
    								{
    									isExist = 1;//有
    								}
    							}

    							//如果有不能上架的条目
    							if(isExist == 1)
    							{
    								alert("请选择能够上架的条目");
    							}
    							else//没有
    							{
    								for(var j = 0;j < checkNum.length;j++)
    								{
    									var k = checkNum[j];
    									singleUpBoard(table[k].styleId);
    								}
    								alert("上架成功");
    								loadPage($scope.page.pageNumber);
    							}
    						}
    					}
	    			}


	    			//批量下架
	    			$scope.manyDownBoard = function()
	    			{
	    				//获取到所有复选框
	    				var checked = document.getElementsByName("house");
	    				//存放所有被选中项目的n
	    				var checkNum = [];
	    				//判断是否为全选，即全选按钮是否被选中
	    				var allSelect = 0;
    					for(i = 0;i < checked.length;i++)
    					{
        					if(checked[i].checked)
            				checkNum.push(i);
    					}
    					if(checkNum.length == checked.length)
    					{
    						allSelect = 1;//全选被选中
    					}

    					if(checkNum.length == 0)
    					{
    						alert("请选择需要下架的条目");
    					}
    					else
    					{
    						//全选是否在内
    						if(allSelect == 1)//全选在内
    						{
    							//检测是否有不能申请上架的条目
    							var isExist = 0;//没有
    							for(var j = 1;j < (checkNum.length -1);j++)
    							{
    								var k = checkNum[j];
    								if(table[k].houseApplicationStatus != "01200300")
    								{
    									isExist = 1;//有
    								}
    							}

    							//如果有不能上架的条目
    							if(isExist == 1)
    							{
    								alert("请选择能够下架的条目");
    							}
    							else//没有不能上架的条目
    							{
    								for(var j = 0;j < (checkNum.length -1);j++)
    								{
    									var k = checkNum[j];
    									singleDownBoard(table[k].styleId);
    								}
    								alert("下架成功");
    								loadPage($scope.page.pageNumber);
    							}
    						}
    						else//全选不在内
    						{
    							//检测是否有不能申请上架的条目
    							var isExist = 0;//没有
    							for(var j = 0;j < checkNum.length;j++)
    							{
    								var k = checkNum[j];
    								if(table[k].houseApplicationStatus != "01200300")
    								{
    									isExist = 1;//有
    								}
    							}

    							//如果有不能上架的条目
    							if(isExist == 1)
    							{
    								alert("请选择能够下架的条目");
    							}
    							else//没有
    							{
    								for(var j = 0;j < checkNum.length;j++)
    								{
    									var k = checkNum[j];
    									singleDownBoard(table[k].houseId);
    								}
    								alert("下架成功");
    								loadPage($scope.page.pageNumber);
    							}
    						}
    					}
	    			}
	        
	        	}
	        });
	    }

	    //先加载第一页
	    loadPage(1);

	    //更新翻页按钮
	    $scope.refreshPageButton = function (aimPage) {
	        $scope.page.pageNumber = aimPage;
	        $scope.pageButton = [];

	        if (aimPage >= 1 && aimPage <= 3) {
	            for (var i = 1; i <= aimPage; i++) {
	                $scope.pageButton[i] = i;
	            }

	            for (i; i <= 5; i++) { //将剩余位置置为null
	                if (i <= $scope.page.pageMax) { //aimPage+1
	                    $scope.pageButton[i] = i;
	                } else {
	                    $scope.pageButton[i] = null;
	                }
	            }
	        }
	        else if (aimPage > 3) {
	            if (aimPage + 2 <= $scope.page.pageMax) {
	                for (var i = 1; i <= 5; i++) {
	                    $scope.pageButton[i] = aimPage - 3 + i;
	                }
	            } else { //后面不足两页
	                var j = 0;
	                for (var i = 5; i >= 0; i--) {
	                    if (($scope.page.pageMax - i) < 0) {
	                        $scope.pageButton[i] = null;
	                    }
	                    else {
	                        $scope.pageButton[i] = $scope.page.pageMax - j;
	                        j++;
	                    }
	                }
	            }
	        }
	    }

	    //获取单个房屋的
		function getSingleHouseInfomation(table, i)
		{
			var style = table[i].styleId;

	        table[i].orginalPrice = ((table[i].orginalPrice)/10000).toFixed(1);
			table[i].downPayment = ((table[i].downPayment)/10000).toFixed(1);

	        table[i]["look"] = "";
			table[i]["state"] = "";
			//待上架
			if(table[i].houseApplicationStatus == "01200100")
			{
				table[i].state="申请上架";
			}
			//已经上架
			else  if(table[i].houseApplicationStatus == "01200300")
			{
				table[i].state="申请下架";
			}
			if(table[i].houseApplicationStatus == "01200200" || table[i].houseApplicationStatus == "01200400")
			{
				table[i].look="审核";
			}
			else
			{
				table[i].look="查看";
			}

			$http({
	    		url: 'houseStyle/getSingleHouseStyle',
	            		method: "post",
	            		headers: {
	                		'Content-Type': 'multipart/form-data'
	            		},
	            		params: {
	                		styleId:style
	            		}
	        		}).success(function (response) {
	        			table[i]["styleCode"] = response.data.houseStyleCode;
	        			response.data.style = response.data.style.split(',');
	        			table[i]["room"] = response.data.style[0];
	        			table[i]["hall"] = response.data.style[1];
	        			table[i]["toilet"] = response.data.style[2];
	        		});

	        // function getSingleInfo()
	        // {
	        // 	return singleHouseInfo;
	        // }

	        // return getSingleInfo;
		}



		//修改按钮
	    $scope.modify = function(houseId) {
			$location.path('index/houseEnter/' + $cookieStore.get("buildingId") + "&" + houseId);
		}

		//申请上架/申请下架
		$scope.upDownBoard = function(houseNum, applicationStatus){
			var statusId = false;
			if(applicationStatus == "01200100" || applicationStatus == "01200300")
			{
				if(applicationStatus == "01200100")
				{
					statusId = true;
				}
				else
				{
					statusId = false;
				}
				$http({
	           		url: 'house/applicateHouseOnSaleAndOffSale',
	            	method: "post",
	            	headers: {
	                	'Content-Type': 'multipart/form-data'
	            	},
	            	params: {
	                	houseId: houseNum,
	                	applicationType: statusId,
	            	}
	        	}).success(function (response) {
	        		if(response.success == true)
	        		{
	        			console.log("success");
	        			if(statusId == true)
	        			{
	        				alert("申请上架成功");
	        				loadPage($scope.page.pageNumber);
	        				//location.reload();
	        			}
	        			else
	        			{
	        				alert("申请下架成功");
	        				loadPage($scope.page.pageNumber);
	        				//location.reload();
	        			}
	        		}
	        		else
	        		{
	        			console.error("error");
	        		}
	        	});
			}

		}

		//查看/审核
	    $scope.lookOrExamine = function(houseId,status)
	    {
	    	//审核按钮
	    	if(status == "01200200" || status == "01200400")
	    	{
	    		$location.path('index/houseAudit/' + houseId + '&1');
	    	}
	    	else//查看
	    	{
	    		$location.path('index/houseAudit/' + $cookieStore.get("buildingId") + "&" + houseId + '&0');
	    	}
	    }

	    //添加新房源
	    $scope.newHouseSource = function()
	    {
            var houseId = 0;
	    	$location.path('index/houseEnter/' + $cookieStore.get("buildingId") + "&" + houseId);
	    }

	    //逐个上架
	    function singleUpBoard(houseNum)
	    {
	    	$http({
	           	url: 'house/applicateHouseOnSaleAndOffSale',
	            method: "post",
	            headers: {
	                'Content-Type': 'multipart/form-data'
	            },
	            params: {
	                houseId: houseNum,
	                applicationType: true,
	            }
	        }).success(function (response) {
	        });
	    }

	    //逐个下架
	    function singleDownBoard(houseNum)
	    {
	    	$http({
	           	url: 'house/applicateHouseOnSaleAndOffSale',
	            method: "post",
	            headers: {
	                'Content-Type': 'multipart/form-data'
	            },
	            params: {
	                styleId: houseNum,
	                status: false,
	            }
	        }).success(function (response) {
	        });
	    }


	}])

//户型全选
function houseStyleAllSelect(obj)
{
	if(obj.checked == false)
	{
		$("input[name='houseStyle']").prop("checked",false);
	}
	else
	{
		$("input[name='houseStyle']").prop("checked",true);
	}
}

//房源全选
function houseSourceAllSelect(obj)
{
	if(obj.checked == false)
	{
		$("input[name='house']").prop("checked",false);
	}
	else
	{
		$("input[name='house']").prop("checked",true);
	}
}
