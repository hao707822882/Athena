package com.boom.chat.export;/**
 * Created by Administrator on 2016/8/28.
 */

import com.boom.base.dto.Today;
import com.boom.base.util.DateUtil;
import com.boom.chat.BaseTest;
import com.boom.chat.dto.TearmItem;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/28
 */
public class QQChatContentServiceTest extends BaseTest {


    @Autowired
    private QQChatContentServiceImpl qqChatContentService;

    @Test
    public void getTest() throws ParseException {
        Date date = new Date();
        Today today = DateUtil.today(date);
        List<TearmItem> hotContentWithCount = qqChatContentService.getHotContentWithCount(today.getFrom(), today.getTo());
    }

}
