angular.module("watchActivity", [])
    .controller("wActivity", ["$http", "$scope", "$stateParams", "$location", function ($http, $scope, $stateParams, $location) {

        var jianlou = '02020500';
        var tuangou = '02020200';
        var tehui = '02020600';


        var activityId = $stateParams.activityId;
        var typeId = $stateParams.activityType;
        var status = $stateParams.activityStatus;

        if ($stateParams.activityStatus == "01200400" || $stateParams.activityStatus == "01200200") {
            $scope.ifShow1 = true;
        } else {
            console.log($stateParams.activityStatus);
            $scope.ifShow1 = false;
        }
        var u = "";
        var fr = "";
        switch (typeId) {
            case jianlou:
                u = "activity/getSingleClearanceActivity";
                fr = "index/avtivitiemManagement"
                $scope.aTypeName = "捡漏";
                break;
            case tuangou:
                u = "activity/getSingleGroupPurchaseActivity";
                fr = "index/groupBuying";
                $scope.aTypeName = "团购";
                break;
            case tehui:
                u = "activity/getSinglePerferentialActivity";
                fr = "index/tehui";
                $scope.aTypeName = "特惠";
                break;
            default:
                u = "";
                break;
        }

        function getInfo(aid) {
            $http({
                url: "activity/getSinglePerferentialActivity",
                method: "post",
                headers: {
                    'Content-Type': 'multipart/form-data'
                },
                params: {
                    activityId: aid,
                }
            }).success(function (response) {
                if (response.success == true) {
                    $scope.item = response.data;
                } else {
                    console.log("error!");
                }
            });
        }
        getInfo(activityId);

        // 审核通过
        $scope.pass = function (aId) {
            //下架tongguo
            console.log(status);
            if (status == "01200400") {
                
                review(aId, 3, "");
                //shangjia tongguo
            } else if (status == "01200200") {
                review(aId, 1, "");
            }

        }

        // 不通过
        $scope.notPass = function (aId, re) {
            if (!re) {
                return;
            }
            //下架不通过
            if (status == "01200400") {
                review(aId, 4, "");
            // 下架通过
            } else if (status == "01200200") {
                review(aId, 2, "");
            }
        }

        // 审核
        function review(aId, aType, re) {
            $http({
                url: "activity/auditActivityApplication",
                method: "post",
                headers: {
                    'Content-Type': 'multipart/form-data'
                },
                params: {
                    activityId: aId,
                    auditType: aType,
                    notPassReason: re,
                }
            }).success(function (response) {
                if (response.success == true) {
                    alert("操作成功！");
                    $location.path(fr);
                } else {
                    alert(response.message);
                    console.log("error!");
                }
            });
        }
    }])