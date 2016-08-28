/**
 * Created by Administrator on 2016/3/9.
 */


myAppModule.filter("dateText", function (DateService) {
        return function (input) {
            return DateService.toDateStr(input)
        };
    }
)





myAppModule.filter("role", function (RoleService) {
        return function (input) {
            return RoleService.get(input) == null ? "未知角色" : RoleService.get(input).role;
        };
    }
)


