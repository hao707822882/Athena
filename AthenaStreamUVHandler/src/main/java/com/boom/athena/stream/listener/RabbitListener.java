package com.boom.athena.stream.listener;/**
 * Created by Administrator on 2016/8/23.
 */

import com.boom.athena.model.Track;
import com.boom.athena.stream.handler.RabbitUVHandler;
import com.boom.athena.stream.service.ObjectMapperService;
import com.boom.athena.stream.service.UVService;
import com.boom.base.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/23
 */
@Component
public class RabbitListener {
    //监听消息

    private Logger logger = LoggerFactory.getLogger(RabbitListener.class);

    private RabbitUVHandler rabbitUVHandler;

    @org.springframework.amqp.rabbit.annotation.RabbitListener(id = "00", queues = {"uv"})
    public void registerHandler01(String info) {
        rabbitUVHandler.handlMessage(info);
    }

    @org.springframework.amqp.rabbit.annotation.RabbitListener(id = "01", queues = {"uv"})
    public void registerHandler02(String info) {
        rabbitUVHandler.handlMessage(info);
    }

    @org.springframework.amqp.rabbit.annotation.RabbitListener(id = "02", queues = {"uv"})
    public void registerHandler03(String info) {
        rabbitUVHandler.handlMessage(info);
    }


}
