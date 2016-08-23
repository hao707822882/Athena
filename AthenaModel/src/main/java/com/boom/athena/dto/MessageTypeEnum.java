package com.boom.athena.dto;

/**
 * Created by Administrator on 2016/8/23.
 */
public enum MessageTypeEnum {
    Event(0), Track(1);

    private Integer type;

    MessageTypeEnum(Integer type) {
        this.type = type;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
