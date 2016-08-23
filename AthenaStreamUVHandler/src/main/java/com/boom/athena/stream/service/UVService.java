package com.boom.athena.stream.service;/**
 * Created by Administrator on 2016/8/23.
 */

import com.boom.base.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/23
 */
@Service
public class UVService {

    @Autowired
    private RedisService redisService;

    /**
     * UV标志
     *
     * @param key
     */
    public void setVisit(String key, String data) {
        redisService.setSet(key, data);
    }


}
