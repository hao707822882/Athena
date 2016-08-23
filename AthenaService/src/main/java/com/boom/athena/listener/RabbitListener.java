package com.boom.athena.listener;/**
 * Created by Administrator on 2016/8/23.
 */

import com.boom.athena.dto.MessageTypeEnum;
import com.boom.athena.dto.MessageWrapper;
import com.boom.athena.model.Event;
import com.boom.athena.model.MessageBase;
import com.boom.athena.model.Track;
import com.boom.athena.service.EventESService;
import com.boom.athena.service.ObjectMapperService;
import com.boom.athena.service.TrackESService;
import com.boom.athena.stream.handler.StreamHandler;
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
    private ObjectMapperService objectMapperService;

    @Autowired
    private StreamHandler streamHandler;

    @Autowired
    private EventESService eventESService;

    @Autowired
    private TrackESService trackESService;

    @org.springframework.amqp.rabbit.annotation.RabbitListener(id = "00", queues = {"msg"})
    public void registerHandler01(String info) {
        handlMessage(info);
    }

    @org.springframework.amqp.rabbit.annotation.RabbitListener(id = "01", queues = {"msg"})
    public void registerHandler02(String info) {
        handlMessage(info);
    }

    @org.springframework.amqp.rabbit.annotation.RabbitListener(id = "02", queues = {"msg"})
    public void registerHandler03(String info) {
        handlMessage(info);
    }

    public void handlMessage(String info) {
        MessageWrapper convert = objectMapperService.convert(info, MessageWrapper.class);
        if (convert == null) {
            //转换失败
            logger.warn("convert msg to MessageWrapper error {}", info);
        } else {
            Integer type = convert.getType();
            if (type == null) {
                logger.warn("convert MessageWrapper type is null", info);
            } else {
                String data = convert.getData();
                MessageBase messageBase = null;
                if (MessageTypeEnum.Event.getType() == type) {
                    Event convert1 = objectMapperService.convert(data, Event.class);
                    messageBase = convert1;
                    eventESService.saveEvent(convert1);
                } else if (MessageTypeEnum.Track.getType() == type) {
                    Track convert1 = objectMapperService.convert(data, Track.class);
                    messageBase = convert1;
                    trackESService.saveTrack(convert1);
                }
                streamHandler.handMsg(messageBase);
            }
        }
    }


}
