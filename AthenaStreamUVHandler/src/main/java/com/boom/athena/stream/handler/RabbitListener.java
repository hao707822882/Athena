package com.boom.athena.stream.handler;/**
 * Created by Administrator on 2016/8/23.
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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


    @org.springframework.amqp.rabbit.annotation.RabbitListener(id = "00", queues = {"uv"})
    public void registerHandler01(String info) {
        handlMessage(info);
    }

    @org.springframework.amqp.rabbit.annotation.RabbitListener(id = "01", queues = {"uv"})
    public void registerHandler02(String info) {
        handlMessage(info);
    }

    @org.springframework.amqp.rabbit.annotation.RabbitListener(id = "02", queues = {"uv"})
    public void registerHandler03(String info) {
        handlMessage(info);
    }

    //消息当做Track处理
    public void handlMessage(String info) {

    }


}
