package com.boom.athena.stream.sender;/**
 * Created by Administrator on 2016/8/23.
 */


import com.boom.athena.model.MessageBase;
import com.boom.athena.service.ObjectMapperService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/23
 */
@Service
public class RabbitService {

    private Logger logger = LoggerFactory.getLogger(RabbitService.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private RabbitAdmin rabbitAdmin;

    @Autowired
    private ObjectMapperService objectMapperService;

    public String createQueue(String queue) {
        Queue createQueue = new Queue(queue, true);
        String s = rabbitAdmin.declareQueue(createQueue);
        return s;
    }


    public Collection queueExists(String name) {
        Collection<String> strings = rabbitAdmin.getRabbitTemplate().expectedQueueNames();
        return strings;
    }

    public void sendMsg(String s, MessageBase messageBase) {
        if (messageBase == null) {
            logger.error("need send msg is null queue is 【{}】", s);
            return;
        } else {
            String d = objectMapperService.serialize(messageBase);
            rabbitTemplate.convertAndSend(s, d);
        }
    }
}
