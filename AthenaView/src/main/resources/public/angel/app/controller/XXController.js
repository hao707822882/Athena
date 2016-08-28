/**
 * Created by Administrator on 2016/3/8.
 */
myAppModule.controller('XXController', ["asyncHttp", "tableService", "DataCheckService", "ScopeService", "$routeParams", "$scope",
    function (asyncHttp, tableService, DataCheckService, ScopeService, $routeParams, $scope) {

        //初始化echart
        var myChart = echarts.init(document.getElementById('main'))

        //视图controller
        $scope.projectId = $routeParams.projectId;

        var domain = {
            "projects": "/admin/getProject",
            "save": "/admin/addOrUpdateProject",
            "update": "/admin/addOrUpdateProject",
            "delProject": "/admin/delProject/",
            "project": "/admin/getProject/"
        };


        $scope.getProject = function () {
            asyncHttp.get(domain.project + $scope.projectId, function (data, status) {
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


        $scope.showChartList = function (view) {
            $scope.indicators = view.indicators;
        }

        $scope.choseChart = function (indicator) {
            $scope.indicator = indicator;
        }

        $scope.showChart = function () {
            if (!$scope.indicator) {
                layer.alert("请先点击视图列表,在点击图标项目列表")
                return;
            }
            show($scope.indicator.name, $scope.indicator.codeName, $scope.start, $scope.end)
        }

        function show(title, name, start, end) {
            // 基于准备好的dom，初始化echarts图表
            $.getJSON("/admin/new?name=" + name + "&start=" + start + "&end=" + end, function (data) {
                var option = setDate(title, data.data);
                myChart.clear();
                myChart.setOption(option);
            })

            function setDate(title, data) {
                var columns = [];
                var xs = [];
                for (var a = 0; a < data.length; a++) {
                    data[a].type = 'line';
                    columns.push(data[a].name);
                    var nameSplit = data[a].name.split("-");
                    xs.push(a)
                }
                var option = {
                    title: {
                        text: title,
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    legend: {
                        data: columns,
                    },
                    toolbox: {
                        show: true,
                        feature: {
                            mark: {show: true},
                            dataView: {show: true, readOnly: false},
                            magicType: {show: true, type: ['line', 'bar', 'stack', 'tiled']},
                            restore: {show: true},
                            saveAsImage: {show: true}
                        }
                    },
                    calculable: true,
                    xAxis: [
                        {
                            type: 'category',
                            boundaryGap: false,
                            data: xs
                        }
                    ],
                    yAxis: [
                        {
                            type: 'value'
                        }
                    ],
                    series: data
                };
                return option;
            }
        }

        $scope.getProject();

    }]);
