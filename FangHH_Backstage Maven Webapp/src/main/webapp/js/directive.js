/**
* fanghhms Module
*
* Description
*/
angular
    .module('fanghhmsDirective', ['ngCookies'])
    .directive('buildingmanagenavigator', ['$cookieStore', '$location', function($cookieStore, $location){
        // Runs during compile
        return {
            // name: '',
            // terminal: true,
            scope: {
                nowpageid: '='
            },
            restrict: 'EA', // E = Element, A = Attribute, C = Class, M = Comment
            templateUrl: 'template/buildingmanageavigator.html',
            replace: true,
            link: function(scope) {
                scope.buildingId = $cookieStore.get("buildingId");

                scope.clickLink = function(url, passParams) {
                    if(passParams) {
                        $location.path('index/' + url + '/' + scope.buildingId);
                    }
                    else {
                        $location.path('index/' + url);    
                    }
                }
            }
        };
    }])
	/**
         * 使用示例
         * <input def-laydate type="text" id="id1" ng-model="startTime"/>
         */

        .directive('defLaydate', function() {
            return {
                require: '?ngModel',
                restrict: 'A',
                scope: {
                    ngModel: '='
                },
                link: function(scope, element, attr, ngModel) {
                    var _date = null,_config={};
                    
                        // 初始化参数 
                    _config = {
                        elem: '#' + attr.id,
                        format: attr.format != undefined && attr.format != '' ? attr.format : 'YYYY-MM-DD',
                        max:attr.hasOwnProperty('maxDate')?attr.maxDate:'',
                        min:attr.hasOwnProperty('minDate')?attr.minDate:'',
                        choose: function(data) {
                            scope.$apply(setViewValue);
                            
                        },
                        clear:function(){
                           ngModel.$setViewValue(null);
                        }
                    };
                    // 初始化
                    _date= laydate(_config);

                  
                   
                    // 模型值同步到视图上
                    ngModel.$render = function() {
                        element.val(ngModel.$viewValue || '');
                    };

                    // 监听元素上的事件
                    element.on('blur keyup change', function() {
                        scope.$apply(setViewValue);
                    });

                    setViewValue();

                    // 更新模型上的视图值
                    function setViewValue() {
                        var val = element.val();
                        ngModel.$setViewValue(val);
                    }
                }  
            }
        })







// var bookStoreDirectives = angular.module('bookStoreDirectives', []);

// bookStoreDirectives.directive('bookStoreDirective_1', ['$scope',
//     function($scope) {}
// ]);

// bookStoreDirectives.directive('bookStoreDirective_2', ['$scope',
//     function($scope) {}
// ]);