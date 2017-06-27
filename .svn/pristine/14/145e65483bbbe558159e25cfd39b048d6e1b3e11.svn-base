var module = angular.module('PicTalk', ['angularFileUpload']);

module.controller('PicTalkController', ['$http', '$scope', 'FileUploader', '$stateParams', function ($http, $scope, FileUploader, $stateParams) {

  var that = this;

  $scope.activePage = 6;

  this.title = '';
  this.picTalkModels = [{}];
  this.currentIndex = 0;
  this.imageBasePath = 'http://localhost:8080/FangHH_Backstage/';

  this.addBlankPicTalkModel = function () {
    that.picTalkModels.push({});
  };

  this.setCurrentIndex = function (index) {
    that.currentIndex = index;
  };

  this.uploader = new FileUploader({
    url: 'houseStyle/uploadStylePic'
  });
  this.uploader.onAfterAddingFile = function (item) {
    item.upload();
  };
  //
  this.uploader.onSuccessItem = function (fileItem, response, status, headers) {
    console.log('picTalk upload file result: ', response);

    var model = that.picTalkModels[that.currentIndex];
    if (response.success === true) {
      model.filePath = that.imageBasePath + response.data;
      model.ptcPic = response.data;
    } else {
      console.log('error when upload image ', that.currentIndex);
    }
  };

  this.deleteModel = function (index) {
    if (that.picTalkModels.length <= 1) {
      alert('必须至少保留一条记录');
      return;
    }

    var result = confirm('确定要删除该记录吗?');
    if (!result) {
      return;
    }

    that.picTalkModels.splice(index, 1);
  };

  this.commit = function () {
    if (!that.title) {
      alert('请输入标题');
      return;
    }

    for (var i = 0; i < that.picTalkModels.length; i++) {
      var model = that.picTalkModels[i];
      console.log(model.filePath, model.ptcContent);

      if (!model.filePath || !model.ptcContent) {
        alert('请确保每一条记录都填写完整');
        return;
      }
    }

    $http.post('building/addPicTalk', {
      buildingId: $stateParams.buildingId,
      title: that.title,
      issueTime: new Date(),
      pictalkcontentList: that.picTalkModels
    }).success(function (response) {
      if (response.success === true) {
        alert('发布成功');
        window.location.reload();
      } else {
        console.log('Failed to commit picTalk info for building ' + $stateParams.buildingId);
      }
    });
  };

  $http({
    url: "building/getPicTalk",
    method: "post",
    headers: {
      'Content-Type': 'multipart/form-data'
    },
    params: {
      buildingId: $stateParams.buildingId,
    }
  }).success(function (response) {
    if (response.success == true) {
      console.log(response.data);
      that.title = response.data.title;
      that.picTalkModels = [];

      angular.forEach(response.data.pictalkcontentList, function (item) {
        var model = {};
        model.ptId = item.ptId;
        model.filePath = item.ptcPic;
        model.ptcContent = item.ptcContent;

        that.picTalkModels.push(model);
      })

      console.log(that.picTalkModels);
    } else {
      console.log("error!");
    }
  });
}]);