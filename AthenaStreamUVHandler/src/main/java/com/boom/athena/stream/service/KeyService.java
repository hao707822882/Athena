package com.boom.athena.stream.service;/**
 * Created by Administrator on 2016/8/24.
 */

import com.boom.athena.model.Track;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/24
 */
@Service
public class KeyService {

    private static SimpleDateFormat withHour = new SimpleDateFormat("yyyy-MM-dd");

    public String getDomainKey(Track track) {
        //项目名
        String domain = track.getName();
        return getUVOuterKey(domain, new Date());
    }


    private String getDateWithHour(Date date) {
        return withHour.format(date);
    }

    public String getUVOuterKey(String name, Date date) {
        String hourKey = getDateWithHour(date);
        return name + "-" + hourKey;
    }

    public String getUVOuterKey(String name, String date) {
        return name + "-" + date;
    }

}
