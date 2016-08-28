package com.boom.athena.stream.handler;/**
 * Created by Administrator on 2016/8/23.
 */

import com.boom.athena.model.Track;
import com.boom.athena.stream.service.KeyService;
import com.boom.athena.stream.service.ObjectMapperService;
import com.boom.athena.stream.service.UVService;
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
public class RabbitUVHandler {
    //监听消息

    private Logger logger = LoggerFactory.getLogger(RabbitUVHandler.class);

    @Autowired
    private ObjectMapperService objectMapperService;

    @Autowired
    private UVService uvService;

    @Autowired
    private KeyService keyService;

    //消息当做Track处理
    public void handlMessage(String info) {
        Track convert = objectMapperService.convert(info, Track.class);
        if (convert == null) {
            logger.warn("msg can not to Track 【{}】", info);
        }
        //获取当前类别的名字
        String domainKey = keyService.getDomainKey(convert);
        uvService.setVisit(domainKey, convert.getValue());
    }

}
