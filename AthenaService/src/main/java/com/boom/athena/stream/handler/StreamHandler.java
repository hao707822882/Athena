package com.boom.athena.stream.handler;
/**
 * Created by Administrator on 2016/8/23.
 */

import com.boom.athena.model.MessageBase;
import com.boom.athena.service.ObjectMapperService;
import com.boom.athena.stream.sender.RabbitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * 流处理中心类
 * 消息分发
 *
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/23
 */
@Service
public class StreamHandler {

    private Logger logger = LoggerFactory.getLogger(StreamHandler.class);

    @Autowired
    private RabbitService rabbitService;

    @Autowired
    private ObjectMapperService objectMapperService;

    private Map<Integer, String> targetQueue;

    @Value("${targetQueueStr}")
    public void setTargetQueueStr(String targetQueueStr) {
        String targetQueueStr1 = targetQueueStr;
        this.targetQueue = objectMapperService.convert(targetQueueStr, Map.class);
    }

    public void handMsg(MessageBase messageBase) {
        Integer actionType = messageBase.getActionType();
        String s = targetQueue.get(actionType);
        if (s != null) {
            rabbitService.sendMsg(s, messageBase);
        } else {
            logger.info("this message {} do not need stream handle", messageBase);
        }
    }

}
