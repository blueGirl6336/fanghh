angular.module("louquan", ["ngCookies"]).controller("louquan", function ($scope, $http) {
    //页码状态
    $scope.page = {
        pageMax: 1,
        pageNumber: 1,
        changePage: function () {
        }
    }

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
        url: "authentication/getStoreAuthenticationPageNum",
        method: "post",
        headers: {
            'Content-Type': 'multipart/form-data'
        },
        params: {
            pageMaxNum: 6,
        }
    }).success(function (response) {
        if (response.success == true) {
            $scope.page.pageMax = response.data;
        } else {
            console.log("error!");
        }
    });

    //翻页函数
    $scope.changePage = function (aimPage) {
        console.log("i am changePage");
        $scope.page.changePage(aimPage);
        // loadPage(aimPage);
    }
    $scope.changePageFilter = function (aimPage) {
        console.log("i am loadpage");
        // $scope.page.changePage(aimPage);
        loadPage(aimPage);
    }

    //加载页面
    function loadPage(page_id) {
        $scope.page.pageNumber = page_id;
        $scope.page.changePage = $scope.changePageFilter;
        $http({
            url: "authentication/getAllStore",
            method: "post",
            headers: {
                'Content-Type': 'multipart/form-data'
            },
            params: {
                pageMaxNum: 6,
                pageNo: page_id
            }
        }).success(function (response) {
            if (response.success == true) {
                 $scope.tesarry = [];
                $scope.items = response.data;
                angular.forEach(response.data, function (data) {
                    $scope.tesarry.push(data.storeId);
                });
                $scope.refreshPageButton(page_id);
                $scope.all(false, $scope.tesarry);
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

    //查询
    $scope.search = function (name) {
        
    }

    //底部审核通过与不通过
    $scope.allPass = function () {
        $scope.store_auth($scope.choseArr, true);
        console.log($scope.choseArr);
    }

    $scope.allNotPass = function () {
        $scope.store_auth($scope.choseArr, false);
        console.log($scope.choseArr);
    };

    //单个审核通过未通过
    $scope.pass = function (i) {
        a = [];
        a[0] = i;
        $scope.store_auth(a, true);
    };

    $scope.notPass = function (i) {
        a = [];
        a[0] = i;
        $scope.store_auth(a, false);
    }

    // 审核门店认证，传入一个数组和是否通过，真通过假不通过
    $scope.store_auth = function (array_id, pass) {
        angular.forEach(array_id, function (i) {
            $http({
                url: "authentication/authenticateStore",
                method: "post",
                headers: {
                    'Content-Type': 'multipart/form-data'
                },
                params: {
                    storeId: i,
                    status: pass,
                    failedReason: "no reason"
                }
            }).success(function (response) {
                if (response.success == true) {
                    console.log("success");
                    //重新加载页面
                    loadPage($scope.page.pageNumber);
                }
            });
        })
    }
})