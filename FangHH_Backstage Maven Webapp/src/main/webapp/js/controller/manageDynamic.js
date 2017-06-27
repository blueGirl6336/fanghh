var module = angular.module('DynamicManagement', ['meta.umeditor']);

module.controller('AddDynamicController', ['$http', '$scope', '$stateParams', '$location', function($http, $scope, $stateParams, $location){

  var that = this;

  $scope.activePage = 4;

  this.title = '';
  this.content = '';

  // 编辑用变量
  this.baseUrl = 'http://localhost:8080/FangHH_Backstage/';

  this.umconfig = {
    imageUrl: 'houseStyle/uploadStylePic',
    imagePath: 'http://localhost:8080/FangHH_Backstage/',
    toolbar: [
      'source | undo redo | bold italic underline strikethrough | superscript subscript | forecolor backcolor | removeformat |',
      'insertorderedlist insertunorderedlist | selectall cleardoc paragraph | fontfamily fontsize',
      '| justifyleft justifycenter justifyright justifyjustify |',
      'link unlink | image',
      '| horizontal preview', 'drafts', 'formula'
    ]
  };

  var dynamicId = $stateParams.dynamicId;
  this.isEditing = true;
  if (!dynamicId) {
    // 添加动态
    this.isEditing = false;
  }

  if (this.isEditing) {
    // 网络请求已有动态数据
    $http({
      method: 'post',
      url: 'dynamiccontent/getDynamiccontentByBdId',
      params: {
        dcId: dynamicId
      }
    }).success(function (response) {
      if (response.success === true) {
        that.title = response.data.dcPic;

        // 读取 html 内容
        $http.get(that.baseUrl + response.data.dcWriting).success(function (response) {
          that.content = response.replace(/<!DOCTYPE html>.*?<\/title>/i, '').replace('</html>', '');
        });
      } else {
        console.log('error when fetch dynamic ' + dynamicId);
      }
    });

  }

  this.commit = function () {
    if (!that.title) {
      alert('请填写动态标题');
      return;
    }

    if (!that.content) {
      alert('请填写动态内容');
      return;
    }

    console.log((that.isEditing ? '编辑内容: ' : '发表内容: ') + that.content);

    var url = that.isEditing ? 'dynamiccontent/updateDynamiccontent' : 'dynamiccontent/addDynamiccontent';
    var params = {
      bdiId: $stateParams.buildingId,
      dcPic: that.title,
      dcWriting: that.content
    };
    if (that.isEditing) {
      params.dcId = $stateParams.dynamicId;
    }

    $http.post(url, params).success(function (response) {
      console.log(response);

      if (response.success === true) {
        alert('操作成功');
        $location.path('index/listDynamicManagement/' + $stateParams.buildingId);
      } else {
        console.log('error when add dynamic ' + that.title);
      }
    });
  };

}]);