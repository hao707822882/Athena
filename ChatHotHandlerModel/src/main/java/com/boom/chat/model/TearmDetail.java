package com.boom.chat.model;/**
 * Created by Administrator on 2016/8/28.
 */

import com.boom.base.entity.GenerateIdEntity;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * 聊天记录分词处理
 *
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/28
 */
@Entity
public class TearmDetail extends GenerateIdEntity {

    private String tearm;

    private Long chatContentId;

    @Temporal(TemporalType.TIMESTAMP)
    private Date addDate;

    public String getTearm() {
        return tearm;
    }

    public void setTearm(String tearm) {
        this.tearm = tearm;
    }

    public Long getChatContentId() {
        return chatContentId;
    }

    public void setChatContentId(Long chatContentId) {
        this.chatContentId = chatContentId;
    }

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }
}
