package com.boom.chat.export;/**
 * Created by Administrator on 2016/8/28.
 */

import com.boom.chat.dto.TearmItem;

import java.util.Date;
import java.util.List;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/28
 */
public interface QQChatContentService {
    List<TearmItem> getHotContentWithCount(Date start, Date end);
}
