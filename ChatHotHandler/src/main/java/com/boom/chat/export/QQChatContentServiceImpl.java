package com.boom.chat.export;/**
 * Created by Administrator on 2016/8/28.
 */

import com.boom.chat.dto.TearmItem;
import com.boom.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/28
 */
@Service
public class QQChatContentServiceImpl implements QQChatContentService {

    @Autowired
    private ChatService chatService;

    @Override
    public List<TearmItem> getHotContentWithCount(Date start, Date end) {
        Object o = chatService.tearmGroup(start, end);
        System.out.println(o);
        return null;
    }
}
