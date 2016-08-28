/**
 * Created by Administrator on 2016/3/8.
 */
myAppModule.controller('IndicatorServiceController', ["asyncHttp", "tableService", "DataCheckService", "ScopeService", "$routeParams", "$scope",
    function (asyncHttp, tableService, DataCheckService, ScopeService, $routeParams, $scope) {

        var projectId = Number.parseInt($routeParams.projectId.split("-")[0])
        var viewId = Number.parseInt($routeParams.projectId.split("-")[1])

        var domain = {
            "projects": "/admin/getProject",
            "save": "/admin/addOrUpdateProject",
            "update": "/admin/addOrUpdateProject",
            "delProject": "/admin/delProject/",
            "project": "/admin/getProject/"
        };


        $scope.p = {};

        $scope.updateProject = function () {
            var project = angular.copy($scope.project);
            var views = project.views;
            var view = $scope.findIndicator(views, viewId)
            var indicators = view.indicators;

            if (indicators) {
                indicators.push($scope.p)
            } else {
                view.indicators = [];
                view.indicators.push($scope.p);
            }

            asyncHttp.create(domain.save, project, function (data, status) {
                if (DataCheckService.check$HttpError(data, status)) {
                    layer.alert('添加失败！' + data.msg);
                    return;
                } else {
                    $scope.getProject();
                }
            }, function (data) {
                layer.alert('添加失败！' + data.msg);
            })
        }


        $scope.findIndicator = function (views, id) {
            for (var a = 0; a < views.length; a++) {
                if (views[a].id == id) {
                    return views[a];
                }
            }
        }

        $scope.getProject = function () {
            asyncHttp.get(domain.project + projectId, function (data, status) {
                    if (DataCheckService.check$HttpError(data, status)) {
                        layer.alert('获取project失败！' + data.msg);
                        return;
                    } else {
                        $scope.project = data.data;
                        $scope.views = $scope.project.views;
                        $scope.view = $scope.findIndicator($scope.views, viewId)
                        $scope.indicators = $scope.view.indicators;
                    }
                }
                ,
                function (data) {
                    layer.alert('获取project失败！' + data.msg);
                }
            )
        }


        $scope.getProject();
    }
])
;
