package com.boom.chat.listener;
/**
 * Created by Administrator on 2016/8/23.
 */

import com.boom.chat.handler.ChatHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/23
 */
@Component
public class RabbitListener {
    //监听消息

    private Logger logger = LoggerFactory.getLogger(RabbitListener.class);

    @Autowired
    private ChatHandler rabbitUVHandler;

    @org.springframework.amqp.rabbit.annotation.RabbitListener(id = "00", queues = {"chatContent"})
    public void registerHandler01(String info) {
        rabbitUVHandler.handlMessage(info);
    }

    @org.springframework.amqp.rabbit.annotation.RabbitListener(id = "01", queues = {"chatContent"})
    public void registerHandler02(String info) {
        rabbitUVHandler.handlMessage(info);
    }

    @org.springframework.amqp.rabbit.annotation.RabbitListener(id = "02", queues = {"chatContent"})
    public void registerHandler03(String info) {
        rabbitUVHandler.handlMessage(info);
    }


}
