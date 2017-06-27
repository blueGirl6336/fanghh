var module = angular.module('PriceTrend', []);

module.controller('PriceTrendController', ['$http', '$scope', '$stateParams', function($http, $scope, $stateParams){
  var that = this;

  $scope.activePage = 5;

  this.recordTime = '';
  this.averagePrice = '';

  this.allTrends = [];

  // 获取当前的房价趋势
  // plain text
  this.fetchPriceTrends = function () {
    $http({
      url: 'building/getHouseTrend',
      method: 'post',
      params: {
        buildingId: $stateParams['buildingId']
      }
    }).success(function (response) {
      if (response.success === true) {
        that.allTrends = response.data;
      } else {
        console.log('error when fetch house trends');
      }
    });
  };

  this.fetchPriceTrends();

  // 上传
  this.commit = function () {
    // 参数检验: 已经选择时间，并填写了均价，价格不能为 0
    if (!that.recordTime || !this.averagePrice) {
      alert('请正确填写时间和均价');
      return;
    }

    // 网络请求
    $http.post('building/addHousepricetrend', {
      buildingId: $stateParams['buildingId'],
      currentPrice: that.averagePrice,
      udpateTime: new Date(that.recordTime)
    }).success(function (response) {
      if (response.success === true) {
        alert('添加成功');
        window.location.reload();
      } else {
        console.log('failed to commit price trend');
      }
    });
  };

  // 删除
  this.delete = function (trendId) {
    $http({
      url: 'building/deleteHousepricetrend', 
      method: 'post',
      params: {
        trendId: trendId
      }
    }).success(function (response) {
      if (response.success === true) {
        window.location.reload();
      } else {
        console.log('failed to delete price trend ' + trendId);
      }
    });
  };

  // 编辑
  this.edit = function () {
    if (!that.editingTrendId) {
      console.log('editing trend id == null || 0')
      return;
    }

    // 时间
    var date = $('#price-trend-date').val();
    if (!date) {
      alert('请选择日期');
      return;
    }

    // 价格
    var price = $('#price-trend-edit-price').val();
    if (!price) {
      alert('请输入正确的价格');
      return;
    }

    $http.post('building/updateHousepricetrend', {
      buildingId: $stateParams['buildingId'],
      currentPrice: price,
      udpateTime: new Date(date),
      trendId: that.editingTrendId
    }).success(function (response) {
      if (response.success === true) {
        alert('更新成功');
        window.location.reload();
      } else {
        console.log('error when update house price trend ' + that.editingTrendId);
      }
    })
  };

  // 显示弹出框
  this.showEditPopup = function (trend) {
    that.editingTrendId = trend.trendId;

    $('.pop-up-cover').fadeIn(200);
    $('.pop-up').fadeIn(200);

    $('#price-trend-date').val(new Date(trend.udpateTime).toISOString().substring(0, 10));
    $('#price-trend-edit-price').val(trend.currentPrice);
  }

  // 关闭弹出框
  this.closePopup = function () {
    $('.pop-up-cover').fadeOut(200);
    $('.pop-up').fadeOut(200);

    that.editingTrendId = null;
  };

}]);