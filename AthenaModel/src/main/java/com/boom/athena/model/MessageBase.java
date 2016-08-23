package com.boom.athena.model;/**
 * Created by Administrator on 2016/8/23.
 */

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/23
 */
public abstract class MessageBase {
    //标记数据后续处理方式
    private Integer actionType;

    public Integer getActionType() {
        return actionType;
    }

    public void setActionType(Integer actionType) {
        this.actionType = actionType;
    }
}
