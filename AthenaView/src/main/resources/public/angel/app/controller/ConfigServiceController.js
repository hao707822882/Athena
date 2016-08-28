/**
 * Created by Administrator on 2016/3/8.
 */
myAppModule.controller('ConfigServiceController', ["asyncHttp", "tableService", "DataCheckService", "ScopeService", "$scope", function (asyncHttp, tableService, DataCheckService, ScopeService, $scope) {

    var domain = {
        "projects": "/admin/getProject",
        "save": "/admin/addOrUpdateProject",
        "update": "/admin/addOrUpdateProject",
        "delProject": "/admin/delProject/"
    };


    $scope.p = {};

    $scope.addProject = function () {
        asyncHttp.create(domain.save, $scope.p, function (data, status) {
            if (DataCheckService.check$HttpError(data, status)) {
                layer.alert('添加失败！' + data.msg);
                return;
            } else {
                $scope.getProjects();
            }
        }, function (data) {
            layer.alert('添加失败！' + data.msg);
        })
    }


    $scope.getProjects = function () {
        asyncHttp.get(domain.projects, function (data, status) {
            if (DataCheckService.check$HttpError(data, status)) {
                layer.alert('获取project失败！' + data.msg);
                return;
            } else {
                $scope.projects = data.data;
            }
        }, function (data) {
            layer.alert('获取project失败！' + data.msg);
        })
    }


    $scope.del = function (data) {
        asyncHttp.get(domain.delProject + data.id, function (data, status) {
            if (DataCheckService.check$HttpError(data, status)) {
                layer.alert('删除project失败！' + data.msg);
                return;
            } else {
                $scope.getProjects();
            }
        }, function (data) {
            layer.alert('删除project失败！' + data.msg);
        })
    }

    $scope.getProjects();
}]);
