/**
* controller Module
*
* Description
*/
angular
	.module('fanghhmsCtrl', [ 'ngCookies' ])
	.controller('login', ['$scope', '$http', '$location', '$rootScope', '$cookieStore', function($scope, $http, $location, $rootScope, $cookieStore) {
		if (document.all && !window.atob)
		{
			alert('当前浏览器版本太低, 建议更换浏览器访问!');
		}
		$scope.submit = function() {
			// $http.post('user/loginWithUserName', {
			// 	userName: $scope.userName,
			// 	password: $scope.password
			// })
			// .success(function(response) {
			// 	if (response.success == true) {
			// 		//存入cookie, 刷新时还保留信息
			// 		$cookieStore.put('userName', $scope.userName);//用户名
			// 		$cookieStore.put('role', response.data);//权限
			// 		alert('登陆成功');
			// 		//$location.path('index');
			// 	}
			// 	else {
			// 		alert(response.message);
			// 	}
			// })

			if($scope.userName == null || $scope.userName == '') {
				alert('请输入账号');
			}
			else if($scope.password == null || $scope.password == '') {
				alert('请输入密码');
			}
			else if($scope.checkCode == null || $scope.checkCode == '') {
				alert('请输入验证码');
			}

			$http({
				url : 'user/loginWithUserName',
				method : 'post',
				headers : {
					'Content-Type' : 'multipart/form-data'
				},
				params : {
					userName : $scope.userName,
					password : $scope.password,
					checkCode : $scope.checkCode
				}
			})
				.success(function(response) {
					if (response.success == true) {
						//存入cookie, 刷新时还保留信息
						$cookieStore.put('userName', response.data.userName); //用户名
						$cookieStore.put('userId', response.data.userId); //用户Id
						$cookieStore.put('role', response.data.role); //权限
						$cookieStore.put('cityId', response.data.cityId); //权限
						$location.path("index/listBuildingManagement");
					} else {
						alert(response.message);
						$scope.refreshConfirmCode();
					}
				});

		}

		$scope.confirmCodePath = "user/getCheckCode?width=99&height=43&stringSize=20&a=" + new Date().getTime();
		$scope.refreshConfirmCode = function() {
			$scope.confirmCodePath = "user/getCheckCode?width=99&height=43&stringSize=20&a=" + new Date().getTime();
		}
	} ])
	.controller('loginStatus', ['$scope', '$http', '$location', '$cookieStore', function($scope, $http, $location, $cookieStore){
		if ($cookieStore.get('userId') == null) {
			alert('请登录');
			$location.path('login');
		}
		else {
			$scope.userName = $cookieStore.get('userName');
		}
		$scope.logout = function() {
			$http
				.get('user/logout')
				.success(function(response) {
					$cookieStore.remove('userName');
					$cookieStore.remove('userId');
					$cookieStore.remove('role');
					if (response.success == true) {
						$location.path('login');
					}
					else {
						console.log('退出失败');
						$location.path('login');
					}
				});
		}
	}])