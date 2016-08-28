package com.boom.chat.handler;/**
 * Created by Administrator on 2016/8/23.
 */

import com.boom.athena.model.Track;
import com.boom.chat.service.ChatService;
import com.boom.chat.service.ObjectMapperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/23
 */
@Component
public class ChatHandler {
    //监听消息

    private Logger logger = LoggerFactory.getLogger(ChatHandler.class);

    @Autowired
    private ObjectMapperService objectMapperService;

    @Autowired
    private ChatService chatService;

    //消息当做Track处理
    public void handlMessage(String info) {
        Track convert = objectMapperService.convert(info, Track.class);
        if (convert == null) {
            logger.warn("msg can not to Track 【{}】", info);
        }
        //获取当前类别的名字
        String content = convert.getValue();
        try {
            chatService.saveContent(content);
        } catch (Exception e) {
            logger.error("save content error", e);
        }
    }

}
