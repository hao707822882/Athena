package com.boom.athena.esdao;/**
 * Created by Administrator on 2016/8/23.
 */

import com.boom.athena.model.Event;
import com.boom.athena.model.Track;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/23
 */
public interface TrackESDao extends ElasticsearchRepository<Track, Long> {
}
