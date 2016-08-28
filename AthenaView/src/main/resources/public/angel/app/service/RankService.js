/**
 * Created by Administrator on 2016/3/9.
 */
myAppModule.service("RankService", function () {
        var rt = {};

        var rank = {
            rankMap: {
                50: "青铜Ⅰ",
                51: "青铜Ⅱ",
                52: "青铜Ⅲ",
                53: "青铜Ⅳ",
                54: "青铜Ⅴ",
                40: "白银Ⅰ",
                41: "白银Ⅱ",
                42: "白银Ⅲ",
                43: "白银Ⅳ",
                44: "白银Ⅴ",
                30: "黄金Ⅰ",
                31: "黄金Ⅱ",
                32: "黄金Ⅲ",
                33: "黄金Ⅳ",
                34: "黄金Ⅴ",
                20: "铂金Ⅰ",
                21: "铂金Ⅱ",
                22: "铂金Ⅲ",
                23: "铂金Ⅳ",
                24: "铂金Ⅴ",
                10: "钻石Ⅰ",
                11: "钻石Ⅱ",
                12: "钻石Ⅲ",
                13: "钻石Ⅳ",
                14: "钻石Ⅴ",
                00: "最强王者",
                60: "超凡大师",
                255255: "无段位"
            },
            rankFunc: function (tier, queue) {
                return rank.rankMap[String(tier) + String(queue)]
            },
            rankFuncStr: function (str) {
                return rank.rankMap[str]
            }
        }

        rt.rankTextInteger = function (tier, queue) {
            return rank.rankFunc(tier, queue);
        }
        rt.rankTextStr = function (str) {
            return rank.rankFuncStr(str);
        }

        return rt;
    }
)
