/**
 * Created by Administrator on 2016/3/8.
 */
myAppModule.config(['$routeProvider', function ($routeProvider) {
    $routeProvider.
        when('/config', {
            templateUrl: '/angel/app/temp/ConfigService.html',
            controller: 'ConfigServiceController'
        }).when('/view/:projectId', {
            templateUrl: '/angel/app/temp/ConfigViewService.html',
            controller: 'ViewServiceController'
        }).when('/indicator/:projectId', {
            templateUrl: '/angel/app/temp/ConfigIndicatorService.html',
            controller: 'IndicatorServiceController'
        }).when('/liucun/:projectId', {
            templateUrl: '/angel/app/temp/liucun.html',
            controller: 'LCController'
        }).when('/xinxian/:projectId', {
            templateUrl: '/angel/app/temp/xinxian.html',
            controller: 'XXController'
        }).when('/viewChart/:projectId', {
            templateUrl: '/angel/app/temp/view.html',
            controller: 'ViewController'
        }).
        otherwise({
            redirectTo: '/config'
        });
}])

