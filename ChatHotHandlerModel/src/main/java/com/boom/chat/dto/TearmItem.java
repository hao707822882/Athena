package com.boom.chat.dto;/**
 * Created by Administrator on 2016/8/28.
 */

import java.io.Serializable;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/28
 */
public class TearmItem implements Serializable {
    private String content;
    private Long times;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getTimes() {
        return times;
    }

    public void setTimes(Long times) {
        this.times = times;
    }
}
