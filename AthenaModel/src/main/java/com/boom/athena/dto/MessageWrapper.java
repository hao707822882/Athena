package com.boom.athena.dto;/**
 * Created by Administrator on 2016/8/23.
 */

import java.io.Serializable;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/23
 */
public class MessageWrapper implements Serializable {

    //消息类型，event，track
    private Integer type;

    //数据
    private String data;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
