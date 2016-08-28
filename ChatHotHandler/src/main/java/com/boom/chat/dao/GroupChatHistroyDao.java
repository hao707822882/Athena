package com.boom.chat.dao;/**
 * Created by Administrator on 2016/8/28.
 */

import com.boom.chat.model.GroupChatHistroy;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/28
 */
public interface GroupChatHistroyDao extends JpaRepository<GroupChatHistroy, Long> {
    
}
