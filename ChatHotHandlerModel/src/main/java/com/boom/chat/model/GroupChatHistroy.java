package com.boom.chat.model;/**
 * Created by Administrator on 2016/8/16.
 */

import com.boom.base.entity.GenerateIdEntity;

import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * 群聊天记录
 *
 * @author chen.xinghu
 * @date 2016/8/16
 */
@Entity
public class GroupChatHistroy extends GenerateIdEntity {


    private String groupId;

    private String userId;

    private String content;

    @Temporal(TemporalType.TIMESTAMP)
    private Date chatDate;

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getChatDate() {
        return chatDate;
    }

    public void setChatDate(Date chatDate) {
        this.chatDate = chatDate;
    }
}
