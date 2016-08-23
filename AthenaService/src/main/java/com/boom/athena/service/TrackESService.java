package com.boom.athena.service;/**
 * Created by Administrator on 2016/8/23.
 */

import com.boom.athena.esdao.TrackESDao;
import com.boom.athena.model.Track;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/23
 */
@Service
public class TrackESService {

    @Autowired
    private TrackESDao trackESDao;

    public Track saveTrack(Track track) {
        return trackESDao.save(track);
    }

}
