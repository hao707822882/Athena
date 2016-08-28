package com.boom.athena.client;/**
 * Created by Administrator on 2016/8/26.
 */

import com.boom.athena.model.Track;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/26
 */
public class AthenaClient {

    private Logger logger = LoggerFactory.getLogger(AthenaClient.class);

    private RabbitTemplate rabbitTemplate;

    private ObjectMapper objectMapper = new ObjectMapper();

    public RabbitTemplate getRabbitTemplate() {
        return rabbitTemplate;
    }


    public void setRabbitTemplate(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void logEvent(String domain, String queue, String name, String data) {
        Track track = new Track();
        track.setDomain(domain);
        track.setName(name);
        track.setValue(data);
        if (rabbitTemplate == null) {
            logger.warn("未找到消息发送器，监控消息消息发送失败");
            return;
        }

        try {
            rabbitTemplate.convertAndSend(queue, objectMapper.writeValueAsString(track));
        } catch (JsonProcessingException e) {
            logger.error("监控消息消息发送失败", e);
        }

    }


}
