package com.boom.athena.service;/**
 * Created by Administrator on 2016/8/23.
 */

import com.boom.athena.esdao.EventESDao;
import com.boom.athena.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/23
 */
@Service
public class EventESService {

    @Autowired
    private EventESDao eventESDao;


    public Event saveEvent(Event event) {
        return eventESDao.save(event);
    }

}
