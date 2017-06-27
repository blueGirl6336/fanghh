angular.module("manageBuilding", ["ngCookies"])
    .controller("watchMethod", function ($scope, $http) {
        $scope.page = {
            pageMax: 1,
            pageNumber: 1,
            changePage: function () {
            }
        }
        //全选与不全选
        $scope.tesarry = [];
        $scope.choseArr = [];

        var str = "";
        var flag = '';
        $scope.x = false;

        $scope.all = function (c, v) {
            if (c == true) {
                $scope.x = true;
                $scope.choseArr = v;
            } else {
                $scope.x = false;
                $scope.choseArr = [];
            }
            flag = 'a';
        };

        $scope.chk = function (y, x) {
            z = y.toString();
            if (flag == 'a') {
                str = $scope.choseArr.join(',') + ',';
            }
            if (x == true) {
                str = str + z + ',';
            } else {
                str = str.replace(z + ',', '');//取消选中
            }

            $scope.choseArr = (str.substr(0, str.length - 1)).split(',');
        };

    }).controller("dynamicManagement", ["$stateParams", "$scope", "$http", "$location",
        function ($stateParams, $scope, $http, $location) {
            $scope.page = {//页码状态
                pageMax: 1,
                pageNumber: 1,
                changePage: function () {
                }
            }

            // 楼盘id
            var bId = $stateParams.buildingId;

            //全选与不全选
            $scope.tesarry = [];
            $scope.choseArr = [];

            var str = "";//
            var flag = '';//是否点击了全选，是为a
            $scope.x = false;//默认未选中

            $scope.all = function (c, v) {//全选 c是全选按钮选中
                if (c == true) {
                    $scope.x = true;
                    $scope.choseArr = v;
                } else {
                    $scope.x = false;
                    $scope.choseArr = [];
                }

                flag = 'a';

            };

            $scope.chk = function (y, x) {//单选或者多选
                z = y.toString();
                if (flag == 'a') {//在全选的基础上操作
                    str = $scope.choseArr.join(',') + ',';
                }
                if (x == true) {//选中
                    str = str + z + ',';
                } else {
                    str = str.replace(z + ',', '');//取消选中
                }

                $scope.choseArr = (str.substr(0, str.length - 1)).split(',');
            };

            //首先获得最大页面数量
            $http({
                url: "dynamiccontent/getDynamicContentPageNum",
                method: "post",
                headers: {
                    'Content-Type': 'multipart/form-data'
                },
                params: {
                    pageMaxNum: 10,
                }
            }).success(function (response) {
                if (response.success == true) {
                    console.log("最大页面数量：");
                    console.log(response);
                    $scope.page.pageMax = response.data;
                } else {
                    console.log("error!");
                }
            });

            //翻页函数
            $scope.changePage = function (aimPage) {
                $scope.page.changePage(aimPage);
            }
            $scope.changePageFilter = function (aimPage) {
                console.log("i am loadpage");
                loadPage(aimPage, bId);
            }

            //加载页面
            function loadPage(page_id, id) {
                $scope.page.pageNumber = page_id;
                console.log("load page aaaaaa");
                $scope.page.changePage = $scope.changePageFilter;
                $http({
                    url: "dynamiccontent/getDynamicContentByBdiId",
                    method: "post",
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    },
                    params: {
                        bdiId: id,
                        pageMaxNum: 10,
                        pageNo: page_id
                    }
                }).success(function (response) {
                    if (response.success == true) {
                        $scope.tesarry = [];
                        angular.forEach(response.data, function (data) {
                            console.log("user id" + data.dcid);
                            $scope.tesarry.push(data.dcid);
                            y = new Date(data.createTime).getFullYear();
                            m = new Date(data.createTime).getMonth() + 1;
                            d = new Date(data.createTime).getDay();

                            data.createTime = y + "-" + m + "-" + d;
                        });

                        $scope.items = response.data;

                        console.log("成功获取的数据：");
                        console.log(response.data);

                        console.log($scope.tesarry);
                        $scope.refreshPageButton(page_id);

                        $scope.all(false, $scope.tesarry);
                    }
                });
            }

            //先加载第一页
            loadPage(1, bId);
            $scope.goto = function (aT, aI, aS) {
                $location.path("index/watchActivity/" + aT + "/" + aI + "/" + aS);
            }
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

            $scope.goTo = function () {
                $location.path("index/addDynamic/" + bId);
            }

            //删除动态
            $scope.del = function (dcid) {
                $http({
                    url: "dynamiccontent/deleteDynamiccontent",
                    method: "post",
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    },
                    params: {
                        dcId: dcid,
                    }
                }).success(function (response) {
                    if (response.success == true) {
                        alert("删除成功！");
                        console.log(response.message);
                        loadPage(1, bId);
                    } else {
                        console.log("error!");
                    }
                });
            };

            //跳转编辑
            $scope.edit = function (dynamic) {
                $location.path("index/editDynamic/" + dynamic.bdiId + '/' + dynamic.dcId);
            }
        }]).controller("avtivitieManagement", function ($scope, $http, $location) {
            $scope.page = {//页码状态
                pageMax: 1,
                pageNumber: 1,
                changePage: function () {
                }
            }

            var city_id = "";
            var reg_id = "";
            var key_name = "";

            // 获取捡漏信息
            function loadPage(cId, rId, kBName, page_id) {
                $scope.page.pageNumber = page_id;
                $scope.page.changePage = $scope.changePageFilter;

                if (!cId) {
                }
                $.post(
                    "activity/getAllClearanceActivity",
                    {
                        cityId: cId,
                        regionId: rId,
                        keyBuildingName: kBName,
                        pageMaxNum: 10,
                        pageNo: page_id
                    }
                    , function (response) {
                        console.log("all back data:");
                        console.log(response);
                        console.log("end");
                        if (response.success == true) {
                            $scope.tesarry = [];
                            $scope.items = response.data;
                            console.log(response.data);
                            angular.forEach(response.data, function (data) {
                                $scope.tesarry.push(data.activityId);
                            });
                            $scope.refreshPageButton(page_id);
                            $scope.all(false, $scope.tesarry);
                            $scope.$apply();
                        }
                    });
            }

            // 获取城市和区域
            $http({
                url: 'dictionary/getAllCityAndRegion',
                method: 'post',
            }).success(function (response) {
                console.log("get cities");
                if (response.success === true) {
                    console.log(response.data);
                    $scope.allCities = response.data;
                } else {
                    console.error('error when access all region', response);
                }
            });

            // 选择城市后更新区域,同时获取信息
            $scope.chooseCity = function (city) {
                if (city == undefined) {
                    return;
                }
                console.log("will change");
                $scope.allRegions = city.regionList;
                city_id = city.cityId;
                reg_id = "";
                refresh_page(1);
            };

            // 选择区域后获取捡漏信息
            $scope.fetchInfo = function (region) {
                if (region === undefined) {
                    return;
                }
                console.log(region);
                city_id = region.cityId;
                reg_id = region.regionId;
                refresh_page(1);
            }

            //点击查询，显示查询
            $scope.search = function (kname) {
                console.log("will search name" + kname);
                key_name = kname;
                refresh_page(1);

            }
            //全选与不全选
            $scope.tesarry = [];
            $scope.choseArr = [];

            var str = "";//
            var flag = '';//是否点击了全选，是为a
            $scope.x = false;//默认未选中

            $scope.all = function (c, v) {//全选 c是全选按钮选中
                if (c == true) {
                    $scope.x = true;
                    $scope.choseArr = v;
                } else {
                    $scope.x = false;
                    $scope.choseArr = [];
                }

                flag = 'a';

            };

            $scope.chk = function (y, x) {//单选或者多选
                z = y.toString();
                if (flag == 'a') {//在全选的基础上操作
                    str = $scope.choseArr.join(',') + ',';
                }
                if (x == true) {//选中
                    str = str + z + ',';
                } else {
                    str = str.replace(z + ',', '');//取消选中
                }

                $scope.choseArr = (str.substr(0, str.length - 1)).split(',');
            };

            //首先获得捡漏页面数量
            function getPage() {
                $http({
                    url: "activity/getClearanceActivityPageNum",
                    method: "post",
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    },
                    params: {
                        cityId: city_id,
                        regionId: reg_id,
                        keyBuildingName: key_name,
                        pageMaxNum: 10,
                    }
                }).success(function (response) {
                    if (response.success == true) {
                        $scope.page.pageMax = response.data;
                    } else {
                        console.log("error!");
                    }
                }).error(function () {
                    console.log("出错啦!");
                });
            }

            getPage();
            //翻页函数
            $scope.changePage = function (aimPage) {
                console.log("i am changePage");
                $scope.page.changePage(aimPage);
                // loadPage(aimPage);
            }
            $scope.changePageFilter = function (aimPage) {
                console.log("i am loadpage");
                refresh_page(aimPage);
            }
            $scope.goto = function (aT, aI, aS) {
                $location.path("index/watchActivity/" + aT + "/" + aI + "/" + aS);
            }
            //更新翻页按钮
            $scope.refreshPageButton = function (aimPage) {
                getPage();
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

            //刷新页面
            function refresh_page(page_id) {
                // 获取所有的
                loadPage(city_id, reg_id, key_name, page_id);
                console.log("refresh page");
            }

            //刷新第一页
            refresh_page(1);

            //上架所选
            $scope.grounding = function () {
                console.log($scope.choseArr);
                // sub($scope.choseArr, "up");
                if (sub($scope.choseArr, "up")) {
                    alert("操作成功！");
                } else {
                    alert("操作失败！");
                }
            }

            //下架所选
            $scope.undercarriage = function () {
                console.log($scope.choseArr);
                // sub($scope.choseArr, "down");
                if (sub($scope.choseArr, "down")) {
                    alert("操作成功！");
                } else {
                    alert("操作失败！");
                }
            }

            //上下架一个
            $scope.upOne = function (i) {
                a = [];
                a[0] = i;
                sub(a, "up");
            }

            $scope.upDown = function (i) {
                a = [];
                a[0] = i;
                sub(a, "down");
            }

            //传入数组和操作
            function sub(acts, op) {
                console.log("acts")
                console.log(acts);
                var r = false;
                //上架
                if (op == "up") {
                    console.log(" i will up");
                    angular.forEach(acts, function (data) {
                        if (data) {
                            $http({
                                url: "activity/applicateActivityOnSale",
                                method: "post",
                                headers: {
                                    'Content-Type': 'multipart/form-data'
                                },
                                params: {
                                    activityId: data,
                                }
                            }).success(function (response) {
                                if (response.success == true) {
                                    r = true;
                                    console.log("返回信息：" + response.message);
                                    alert("操作成功！");
                                } else {
                                    console.log("error!");
                                    alert("操作失败！");
                                }
                                refresh_page($scope.page.pageNumber);
                                $scope.x = false;
                                $scope.master = false;
                            }).error(function () {
                                console.log("出错啦!");
                            });
                        }
                    })
                } else if (op == "down") {
                    angular.forEach(acts, function (data) {
                        if (data) {
                            $http({
                                url: "activity/applicateActivityOffSale",
                                method: "post",
                                headers: {
                                    'Content-Type': 'multipart/form-data'
                                },
                                params: {
                                    activityId: data,
                                }
                            }).success(function (response) {
                                if (response.success == true) {
                                    r = true;
                                    console.log("返回信息：" + response.message);
                                    alert("操作成功！");
                                } else {
                                    console.log("error!");
                                    alert("操作失败！");
                                }
                                refresh_page($scope.page.pageNumber);
                                $scope.x = false;
                                $scope.master = false;
                            }).error(function () {
                                console.log("出错啦!");
                            });
                        }
                    })
                }
            }
        }).controller("groupBuying", function ($scope, $http, $location) {
            $scope.page = {//页码状态
                pageMax: 1,
                pageNumber: 1,
                changePage: function () {
                }
            }

            var city_id = "";
            var reg_id = "";
            var key_name = "";

            //翻页函数
            $scope.changePage = function (aimPage) {
                console.log("i am changePage");
                $scope.page.changePage(aimPage);
            }
            $scope.changePageFilter = function (aimPage) {
                console.log("i am loadpage");
                refresh_page(aimPage);
            }

            // 获取团购信息
            function loadPage(cId, rId, kBName, page_id) {
                console.log("load pagge:" + kBName);
                $scope.page.pageNumber = page_id;
                $scope.page.changePage = $scope.changePageFilter;

                if (!cId) {
                }
                $.post(
                    "activity/getGroupPurchaseActivity", {
                        cityId: cId,
                        regionId: rId,
                        keyBuildingName: kBName,
                        pageMaxNum: 10,
                        pageNo: page_id
                    }
                    , function (response) {
                        console.log("all back data:");
                        console.log(response);
                        console.log("end");
                        if (response.success == true) {

                            $scope.tesarry = [];
                            $scope.items = response.data;
                            console.log(response.data);
                            angular.forEach(response.data, function (data) {
                                $scope.tesarry.push(data.activityId);
                            });
                            $scope.refreshPageButton(page_id);
                            $scope.all(false, $scope.tesarry);
                            $scope.$apply();
                        }
                    });
            }

            // 获取城市和区域
            $http({
                url: 'dictionary/getAllCityAndRegion',
                method: 'post',
            }).success(function (response) {
                console.log("get cities");
                if (response.success === true) {
                    console.log(response.data);
                    $scope.allCities = response.data;
                } else {
                    console.error('error when access all region', response);
                }
            });

            // 选择城市后更新区域,同时获取信息
            $scope.chooseCity = function (city) {
                if (city == undefined) {
                    return;
                }
                console.log("will change");
                $scope.allRegions = city.regionList;
                city_id = city.cityId;
                reg_id = "";
                refresh_page(1);
            };

            // 选择区域后获取捡漏信息
            $scope.fetchInfo = function (region) {
                if (region === undefined) {
                    return;
                }
                console.log(region);
                city_id = region.cityId;
                reg_id = region.regionId;
                refresh_page(1);
            }

            //点击查询，显示查询
            $scope.search = function (kname) {
                console.log("will search name" + kname);
                key_name = kname;
                refresh_page(1);

            }
            //全选与不全选
            $scope.tesarry = [];
            $scope.choseArr = [];

            var str = "";//
            var flag = '';//是否点击了全选，是为a
            $scope.x = false;//默认未选中

            $scope.all = function (c, v) {//全选 c是全选按钮选中
                if (c == true) {
                    $scope.x = true;
                    $scope.choseArr = v;
                } else {
                    $scope.x = false;
                    $scope.choseArr = [];
                }

                flag = 'a';

            };

            $scope.chk = function (y, x) {//单选或者多选
                z = y.toString();
                if (flag == 'a') {//在全选的基础上操作
                    str = $scope.choseArr.join(',') + ',';
                }
                if (x == true) {//选中
                    str = str + z + ',';
                } else {
                    str = str.replace(z + ',', '');//取消选中
                }

                $scope.choseArr = (str.substr(0, str.length - 1)).split(',');
            };

            function getPage() {
                $http({
                    url: "activity/getGroupPurchaseActivityPageNum",
                    method: "post",
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    },
                    params: {
                        cityId: city_id,
                        regionId: reg_id,
                        keyBuildingName: key_name,
                        pageMaxNum: 10,
                    }
                }).success(function (response) {
                    if (response.success == true) {
                        $scope.page.pageMax = response.data;
                    } else {
                        console.log("error!");
                    }
                }).error(function () {
                    console.log("出错啦!");
                });
            }

            getPage();
            //获得团购页数
            // $http({
            //     url: "activity/getGroupPurchaseActivityPageNum",
            //     method: "post",
            //     headers: {
            //         'Content-Type': 'multipart/form-data'
            //     },
            //     params: {
            //         pageMaxNum: 10,
            //     }
            // }).success(function (response) {
            //     if (response.success == true) {
            //         $scope.page.pageMax = response.data;
            //     } else {
            //         console.log("error!");
            //     }
            // }).error(function () {
            //     console.log("出错啦!");
            // });

            $scope.goto = function (aT, aI, aS) {
                $location.path("index/watchActivity/" + aT + "/" + aI + "/" + aS);
            }
            //更新翻页按钮
            $scope.refreshPageButton = function (aimPage) {
                getPage();
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

            //刷新页面
            function refresh_page(page_id) {
                // 获取所有的
                loadPage(city_id, reg_id, key_name, page_id);
                console.log("refresh page");
            }

            //刷新第一页
            refresh_page(1);

            //上架所选
            $scope.grounding = function () {
                console.log($scope.choseArr);
                // sub($scope.choseArr, "up");
                if (sub($scope.choseArr, "up")) {
                    alert("操作成功！");
                } else {
                    alert("操作失败！");
                }
            }

            //下架所选
            $scope.undercarriage = function () {
                console.log($scope.choseArr);
                // sub($scope.choseArr, "down");
                if (sub($scope.choseArr, "down")) {
                    alert("操作成功！");
                } else {
                    alert("操作失败！");
                }
            }

            //上下架一个
            $scope.upOne = function (i) {
                a = [];
                a[0] = i;
                sub(a, "up");
            }

            $scope.upDown = function (i) {
                a = [];
                a[0] = i;
                sub(a, "down");
            }
            //传入数组和操作
            function sub(acts, op) {
                console.log("acts")
                console.log(acts);
                r = false;
                //上架
                if (op == "up") {
                    console.log(" i will up");
                    angular.forEach(acts, function (data) {
                        if (data) {
                            $http({
                                url: "activity/applicateActivityOnSale",
                                method: "post",
                                headers: {
                                    'Content-Type': 'multipart/form-data'
                                },
                                params: {
                                    activityId: data,
                                }
                            }).success(function (response) {
                                if (response.success == true) {
                                    r = true;
                                    alert("操作成功！");
                                } else {
                                    alert("error!");
                                }
                                refresh_page($scope.page.pageNumber);
                                $scope.x = false;
                                $scope.master = false;
                            }).error(function () {
                                alert("出错啦!");
                            });
                        }
                    })
                } else if (op == "down") {
                    angular.forEach(acts, function (data) {
                        if (data) {
                            $http({
                                url: "activity/applicateActivityOffSale",
                                method: "post",
                                headers: {
                                    'Content-Type': 'multipart/form-data'
                                },
                                params: {
                                    activityId: data,
                                }
                            }).success(function (response) {
                                if (response.success == true) {
                                    r = true;
                                    alert("操作成功！");
                                } else {
                                    alert("error!");
                                }
                                refresh_page($scope.page.pageNumber);
                                $scope.x = false;
                                $scope.master = false;
                            }).error(function () {
                                alert("出错啦!");
                            });
                        }
                    })
                }

            }
        }).controller("tehui", function ($scope, $http, $location) {
            $scope.page = {//页码状态
                pageMax: 1,
                pageNumber: 1,
                changePage: function () {
                }
            }

            var city_id = "";
            var reg_id = "";
            var key_name = "";

            //翻页函数
            $scope.changePage = function (aimPage) {
                console.log("i am changePage");
                $scope.page.changePage(aimPage);
                // loadPage(aimPage);
            }
            $scope.changePageFilter = function (aimPage) {
                console.log("i am loadpage");
                refresh_page(aimPage);
            }

            // 获取特惠信息
            function loadPage(cId, rId, kBName, page_id) {
                console.log("load pagge:" + kBName);
                $scope.page.pageNumber = page_id;
                $scope.page.changePage = $scope.changePageFilter;

                if (!cId) {
                }
                $.post("activity/getAllPerferentialActivity", {
                    cityId: cId,
                    regionId: rId,
                    keyBuildingName: kBName,
                    pageMaxNum: 10,
                    pageNo: page_id
                },
                    function (response) {
                        console.log("all back data:");
                        console.log(response);
                        console.log("end");
                        if (response.success == true) {
                            $scope.tesarry = [];
                            $scope.items = response.data;
                            console.log(response.data);
                            angular.forEach(response.data, function (data) {
                                $scope.tesarry.push(data.activityId);
                            });
                            $scope.refreshPageButton(page_id);
                            $scope.all(false, $scope.tesarry);
                            $scope.$apply();
                        }
                    });
            }

            // 获取城市和区域
            $http({
                url: 'dictionary/getAllCityAndRegion',
                method: 'post',
            }).success(function (response) {
                console.log("get cities");
                if (response.success === true) {
                    console.log(response.data);
                    $scope.allCities = response.data;
                } else {
                    console.error('error when access all region', response);
                }
            });

            // 选择城市后更新区域,同时获取信息
            $scope.chooseCity = function (city) {
                if (city == undefined) {
                    return;
                }
                console.log("will change");
                $scope.allRegions = city.regionList;
                city_id = city.cityId;
                reg_id = "";
                refresh_page(1);
            };

            // 选择区域后获取特惠信息
            $scope.fetchInfo = function (region) {
                if (region === undefined) {
                    return;
                }
                console.log(region);
                city_id = region.cityId;
                reg_id = region.regionId;
                refresh_page(1);
            }

            //点击查询，显示查询
            $scope.search = function (kname) {
                console.log("will search name" + kname);
                key_name = kname;
                refresh_page(1);
            }
            //全选与不全选
            $scope.tesarry = [];
            $scope.choseArr = [];

            var str = "";//
            var flag = '';//是否点击了全选，是为a
            $scope.x = false;//默认未选中

            $scope.all = function (c, v) {//全选 c是全选按钮选中
                if (c == true) {
                    $scope.x = true;
                    $scope.choseArr = v;
                } else {
                    $scope.x = false;
                    $scope.choseArr = [];
                }

                flag = 'a';

            };

            $scope.chk = function (y, x) {//单选或者多选
                z = y.toString();
                if (flag == 'a') {//在全选的基础上操作
                    str = $scope.choseArr.join(',') + ',';
                }
                if (x == true) {//选中
                    str = str + z + ',';
                } else {
                    str = str.replace(z + ',', '');//取消选中
                }

                $scope.choseArr = (str.substr(0, str.length - 1)).split(',');
            };

            function getPage() {
                console.log("我要获取页数！");
                $http({
                    url: "activity/getPerferentialActivityPageNum",
                    method: "post",
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    },
                    params: {
                        cityId: city_id,
                        regionId: reg_id,
                        keyBuildingName: key_name,
                        pageMaxNum: 10,
                    }
                }).success(function (response) {
                    console.log("页码是：");
                    console.log(response.data);
                    if (response.success == true) {
                        $scope.page.pageMax = response.data;
                    } else {
                        console.log("error!");
                    }
                }).error(function () {
                    console.log("出错啦!");
                });
            }

            getPage();
            //获得特惠页数
            // $http({
            //     url: "activity/getPerferentialActivityPageNum",
            //     method: "post",
            //     headers: {
            //         'Content-Type': 'multipart/form-data'
            //     },
            //     params: {
            //         pageMaxNum: 10,
            //     }
            // }).success(function (response) {
            //     if (response.success == true) {
            //         $scope.page.pageMax = response.data;
            //     } else {
            //         console.log("error!");
            //     }
            // }).error(function () {
            //     console.log("出错啦!");
            // });

            $scope.goto = function (aT, aI, aS) {
                $location.path("index/watchActivity/" + aT + "/" + aI + "/" + aS);
            }
            //更新翻页按钮
            $scope.refreshPageButton = function (aimPage) {
                getPage();
                $scope.page.pageNumber = aimPage;
                $scope.pageButton = [];

                if (aimPage >= 1 && aimPage <= 3) {
                    for (var i = 1; i <= aimPage; i++) {
                        $scope.pageButton[i] = i;
                    }

                    for (i; i <= 5; i++) {
                        if (i <= $scope.page.pageMax) {
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
                    } else {
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

            //刷新页面
            function refresh_page(page_id) {
                // 获取所有的
                loadPage(city_id, reg_id, key_name, page_id);
                console.log("refresh page");
            }

            //刷新第一页
            refresh_page(1);

            //上架所选
            $scope.grounding = function () {
                console.log($scope.choseArr);
                sub($scope.choseArr, "up");
            }

            //下架所选
            $scope.undercarriage = function () {
                console.log($scope.choseArr);
                sub($scope.choseArr, "down");
            }

            //上下架一个
            $scope.upOne = function (i) {
                a = [];
                a[0] = i;
                sub(a, "up");
                console.log("申请上架一个");
            }

            $scope.downOne = function (i) {
                a = [];
                a[0] = i;
                sub(a, "down");
                console.log("申请下架一个！");
            }

            //传入数组和操作
            function sub(acts, op) {
                //上架
                if (op == "up") {
                    angular.forEach(acts, function (data) {
                        if (data) {
                            $http({
                                url: "activity/applicateActivityOnSale",
                                method: "post",
                                headers: {
                                    'Content-Type': 'multipart/form-data'
                                },
                                params: {
                                    activityId: data,
                                }
                            }).success(function (response) {
                                if (response.success == true) {
                                    alert("操作成功！");
                                } else {
                                    alert("error!");
                                }
                                refresh_page($scope.page.pageNumber);
                                $scope.x = false;
                                $scope.master = false;
                            }).error(function () {
                                console.log("出错啦!");
                            });
                        }
                    })
                } else if (op == "down") {
                    angular.forEach(acts, function (data) {
                        if (data) {
                            $http({
                                url: "activity/applicateActivityOffSale",
                                method: "post",
                                headers: {
                                    'Content-Type': 'multipart/form-data'
                                },
                                params: {
                                    activityId: data,
                                }
                            }).success(function (response) {
                                if (response.success == true) {
                                    alert("操作成功！");
                                } else {
                                    alert("error!");
                                }
                                refresh_page($scope.page.pageNumber);
                                $scope.x = false;
                                $scope.master = false;
                            }).error(function () {
                                console.log("出错啦!");
                            });
                        }
                    })
                }

            }
        })