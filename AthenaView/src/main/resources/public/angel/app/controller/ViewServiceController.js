/**
 * Created by Administrator on 2016/3/8.
 */
myAppModule.controller('ViewServiceController', ["asyncHttp", "tableService", "DataCheckService", "ScopeService", "$routeParams", "$scope",
    function (asyncHttp, tableService, DataCheckService, ScopeService, $routeParams, $scope) {

        $scope.projectId = $routeParams.projectId;

        var domain = {
            "projects": "/admin/getProject",
            "save": "/admin/addOrUpdateProject",
            "update": "/admin/addOrUpdateProject",
            "delProject": "/admin/delProject/",
            "project": "/admin/getProject/"
        };


        $scope.p = {};

        $scope.addProject = function () {
            var project = angular.copy($scope.project);
            if (project.views) {
                project.views.push($scope.p);
            } else {
                project.views = [];
                project.views.push($scope.p);
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


        $scope.getProject = function () {
            asyncHttp.get(domain.project +  $scope.projectId, function (data, status) {
                if (DataCheckService.check$HttpError(data, status)) {
                    layer.alert('获取project失败！' + data.msg);
                    return;
                } else {
                    $scope.project = data.data;
                    $scope.views = $scope.project.views;
                }
            }, function (data) {
                layer.alert('获取project失败！' + data.msg);
            })
        }


        $scope.getProject();
    }]);
