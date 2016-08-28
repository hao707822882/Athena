package com.boom.chat.service;/**
 * Created by Administrator on 2016/8/28.
 */

import com.boom.chat.dao.GroupChatHistroyDao;
import com.boom.chat.dao.TearmDetailDao;
import com.boom.chat.model.GroupChatHistroy;
import com.boom.chat.model.TearmDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * @author chen.xinghu
 * @comment 炸弹人数据平台
 * @date 2016/8/28
 */
@Service
public class ChatService {

    @Autowired
    private GroupChatHistroyDao groupChatHistroyDao;

    @Autowired
    private TearmDetailDao tearmDetailDao;

    @Autowired
    private SplitService splitService;

    public void saveContent(String content) throws IOException {
        Date date = new Date();
        Set<String> strings = splitService.splitContent(content);
        GroupChatHistroy groupChatHistroy = new GroupChatHistroy();
        groupChatHistroy.setChatDate(date);
        groupChatHistroy.setContent(content);
        //保存聊天详情
        GroupChatHistroy save = groupChatHistroyDao.save(groupChatHistroy);
        Iterator<String> iterator = strings.iterator();
        List<TearmDetail> tearmDetailList = new ArrayList();
        while (iterator.hasNext()) {
            String next = iterator.next();
            TearmDetail tearmDetail = new TearmDetail();
            tearmDetail.setChatContentId(save.getId());
            tearmDetail.setAddDate(date);
            tearmDetail.setTearm(next);
            tearmDetailList.add(tearmDetail);
        }
        tearmDetailDao.save(tearmDetailList);
    }


    public List tearmGroup(Date start, Date end) {
        return tearmDetailDao.teramCountByGroup(start, end);
    }
}
